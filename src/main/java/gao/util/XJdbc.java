package gao.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XJdbc {

    private static Connection connection;

    public static Connection openConnection() {
        var driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        var dburl = "jdbc:sqlserver://localhost:1433;database=QuanLyGao;encrypt=true;trustServerCertificate=true;";
        var username = "sa";
        var password = "123456";
        try {
            if (!XJdbc.isReady()) {
                Class.forName(driver);
                connection = DriverManager.getConnection(dburl, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (XJdbc.isReady()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isReady() {
        try {
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int executeUpdate(String sql, Object... values) {
        try {
            var stmt = getStmt(sql, values);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ResultSet executeQuery(String sql, Object... values) {
        try {
            var stmt = getStmt(sql, values);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getValue(String sql, Object... values) {
        try {
            var resultSet = executeQuery(sql, values);
            if (resultSet.next()) {
                return (T) resultSet.getObject(1);
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getBeanList(Class<T> type, String sql, Object... args) {
        List<T> list = new ArrayList<>();
        try {
            ResultSet rs = executeQuery(sql, args);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                T bean = type.getDeclaredConstructor().newInstance();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String col = rsmd.getColumnLabel(i);
                    Object val = rs.getObject(i);
                    try {
                        Field field = type.getDeclaredField(col);
                        field.setAccessible(true);
                        field.set(bean, val);
                    } catch (NoSuchFieldException ex) {
                        // ignore
                    }
                }
                list.add(bean);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getSingleBean(Class<T> type, String sql, String... args) {
        List<T> list = getBeans(type, sql, args);
        return list.isEmpty() ? null : list.get(0);
    }

    private static <T> List<T> getBeans(Class<T> type, String sql, String[] args) {
        return getBeanList(type, sql, (Object[]) args);
    }

    static ResultSet query(String sql, String[] args) {
        return executeQuery(sql, (Object[]) args);
    }

    private static PreparedStatement getStmt(String sql, Object... values) throws SQLException {
        var conn = openConnection();
        var stmt = sql.trim().startsWith("{") ? conn.prepareCall(sql) : conn.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
        return stmt;
    }

    // DEMO
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    private static void demo1() {
        String sql = "SELECT * FROM Drinks WHERE UnitPrice BETWEEN ? AND ?";
        var rs = executeQuery(sql, 1.5, 5.0);
    }

    private static void demo2() {
        String sql = "SELECT max(UnitPrice) FROM Drinks WHERE UnitPrice > ?";
        var maxPrice = getValue(sql, 1.5);
    }

    private static void demo3() {
        String sql = "DELETE FROM Drinks WHERE UnitPrice < ?";
        var count = executeUpdate(sql, 0.0);
    }
}
