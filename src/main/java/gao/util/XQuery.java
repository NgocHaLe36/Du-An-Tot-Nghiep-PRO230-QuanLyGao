/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.util;
import gao.entity.Users;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp tiện ích hỗ trợ truy vấn và chuyển đổi sang đối tượng
 *
 * @author NghiemN
 * @version 1.0
 */
public class XQuery {

    /**
     * Truy vấn 1 đối tượng
     *
     * @param <B> kiểu của đối tượng cần chuyển đổi
     * @param beanClass lớp của đối tượng kết quả
     * @param sql câu lệnh truy vấn
     * @param values các giá trị cung cấp cho các tham số của SQL
     * @return kết quả truy vấn
     * @throws RuntimeException lỗi truy vấn
     */
    public static <B> B getSingleBean(Class<B> beanClass, String sql, Object... values) {
        List<B> list = XQuery.getBeanList(beanClass, sql, values);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * Truy vấn nhiều đối tượng
     *
     * @param <B> kiểu của đối tượng cần chuyển đổi
     * @param beanClass lớp của đối tượng kết quả
     * @param sql câu lệnh truy vấn
     * @param values các giá trị cung cấp cho các tham số của SQL
     * @return kết quả truy vấn
     * @throws RuntimeException lỗi truy vấn
     */
    public static <B> List<B> getBeanList(Class<B> beanClass, String sql, Object... values) {
        List<B> list = new ArrayList<>();
        try {
            ResultSet resultSet = XJdbc.executeQuery(sql, values);
            while (resultSet.next()) {
                list.add(XQuery.readBean(resultSet, beanClass));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    //chatGPT 
    public static <T> List<T> getEntityList(Class<T> clazz, String sql, String[] args) {
        List<T> list = new ArrayList<T>();
        try {
           ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                T entity = clazz.getDeclaredConstructor().newInstance();
                // Cần viết hàm load dữ liệu từ rs vào entity ở đây
                // Ví dụ: if (entity instanceof Category) ((Category) entity).loadFromResultSet(rs);
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * Tạo bean với dữ liệu đọc từ bản ghi hiện tại
     *
     * @param <B> kiểu của đối tượng cần chuyển đổi
     * @param resultSet tập bản ghi cung cấp dữ liệu
     * @param beanClass lớp của đối tượng kết quả
     * @return kết quả truy vấn
     * @throws RuntimeException lỗi truy vấn
     */
    private static <B> B readBean(ResultSet resultSet, Class<B> beanClass) throws Exception {
        B bean = beanClass.getDeclaredConstructor().newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("set") && method.getParameterCount() == 1) {
                try {
                    Object value = resultSet.getObject(name.substring(3));
                    method.invoke(bean, value);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
                    System.out.printf("+ Column '%s' not found!\r\n", name.substring(3));
                }
            }
        }
        return bean;
    }
//   private static <B> B readBean(ResultSet resultSet, Class<B> beanClass) throws Exception {
//    B bean = beanClass.getDeclaredConstructor().newInstance();
//    Method[] methods = beanClass.getDeclaredMethods();
//    for (Method method : methods) {
//        String name = method.getName();
//        if (name.startsWith("set") && method.getParameterCount() == 1) {
//            String column = name.substring(3);
//            try {
//                Class<?> paramType = method.getParameterTypes()[0];
//                Object value;
//                
//                // Xử lý kiểu LocalDate
//                if (paramType == java.time.LocalDate.class) {
//                    java.sql.Date date = resultSet.getDate(column);
//                    value = (date != null) ? date.toLocalDate() : null;
//                } else {
//                    value = resultSet.getObject(column);
//                }
//
//                method.invoke(bean, value);
//            } catch (Exception ex) {
//                System.out.printf("+ Column '%s' not found or failed to set!\n", column);
//            }
//        }
//    }
//    return bean;
//}

/// chỉ chỗ này thôi!!

   public static void main(String[] args) {
        demo1();
        demo2();
    }

    private static void demo1() {
        String sql = "SELECT * FROM Users WHERE Username=? AND Password=?";
        Users user = XQuery.getSingleBean(Users.class, sql, "NghiemN", "123456");
    }

    private static void demo2() {
        String sql = "SELECT * FROM Users WHERE Fullname LIKE ?";
        List<Users> list = XQuery.getBeanList(Users.class, sql, "%Nguyễn %");
    }
    
}
