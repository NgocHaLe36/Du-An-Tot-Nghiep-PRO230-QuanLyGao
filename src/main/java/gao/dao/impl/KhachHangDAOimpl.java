package gao.dao.impl;

import gao.dao.KhachHangDAO;
import gao.entity.KhachHang;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.sql.Date;
import java.util.List;

public class KhachHangDAOimpl implements KhachHangDAO {

    private final String insertSql = "INSERT INTO KhachHang (HoTen, SoDT, DiaChi, Email, NgayDangKy) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE KhachHang SET HoTen = ?, SoDT = ?, DiaChi = ?, Email = ?, NgayDangKy = ? WHERE MaKH = ?";
    private final String deleteSql = "DELETE FROM KhachHang WHERE MaKH = ?";
    private final String selectAllSql = "SELECT * FROM KhachHang";
    private final String selectByIdSql = "SELECT * FROM KhachHang WHERE MaKH = ?";
    private final String selectByUsernameSql = "SELECT * FROM KhachHang WHERE Email = ?"; // Tạm dùng Email làm "username"

    @Override
    public KhachHang create(KhachHang entity) {
        Object[] args = {
            entity.getHoTen(),
            entity.getSoDT(),
            entity.getDiaChi(),
            entity.getEmail(),
            entity.getNgayDangKy()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(KhachHang entity) {
        Object[] args = {
            entity.getHoTen(),
            entity.getSoDT(),
            entity.getDiaChi(),
            entity.getEmail(),
            entity.getNgayDangKy(),
            entity.getMaKH()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        return XQuery.getBeanList(KhachHang.class, selectAllSql);
    }

    @Override
    public KhachHang findById(String id) {
        return XQuery.getSingleBean(KhachHang.class, selectByIdSql, id);
    }

    @Override
    public KhachHang findByUsername(String username) {
        return XQuery.getSingleBean(KhachHang.class, selectByUsernameSql, username);
    }
}
