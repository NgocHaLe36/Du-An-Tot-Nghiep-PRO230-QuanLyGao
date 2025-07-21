package gao.dao.impl;

import gao.dao.PhieuNhapDAO;
import gao.entity.PhieuNhap;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

public class PhieuNhapDAOimpl implements PhieuNhapDAO {

    private final String insertSql = "INSERT INTO PhieuNhap(MaPN, NgayNhap, MaNCC, GhiChu, MaGao, SoLuong, DonGiaNhap) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE PhieuNhap SET NgayNhap=?, MaNCC=?, GhiChu=?, MaGao=?, SoLuong=?, DonGiaNhap=? WHERE MaPN=?";
    private final String deleteSql = "DELETE FROM PhieuNhap WHERE MaPN=?";
    private final String selectAllSql = "SELECT * FROM PhieuNhap";
    private final String selectByIdSql = "SELECT * FROM PhieuNhap WHERE MaPN=?";

    @Override
    public PhieuNhap create(PhieuNhap entity) {
        Object[] args = {
            entity.getMaPN(),
            entity.getNgayNhap(),
            entity.getMaNCC(),
            entity.getGhiChu(),
            entity.getMaGao(),
            entity.getSoLuong(),
            entity.getDonGiaNhap()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(PhieuNhap entity) {
        Object[] args = {
            entity.getNgayNhap(),
            entity.getMaNCC(),
            entity.getGhiChu(),
            entity.getMaGao(),
            entity.getSoLuong(),
            entity.getDonGiaNhap(),
            entity.getMaPN()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<PhieuNhap> findAll() {
        return XQuery.getBeanList(PhieuNhap.class, selectAllSql);
    }

    @Override
    public PhieuNhap findById(String id) {
        return XQuery.getSingleBean(PhieuNhap.class, selectByIdSql, id);
    }

    @Override
    public PhieuNhap findByUsername(String username) {
        return null; // Không áp dụng với phiếu nhập
    }
}
