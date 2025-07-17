/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.dao.impl;

import gao.dao.*;
import gao.entity.KhachHang;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

/**
 *
 * @author lengh
 */
public class KhachHangDAOimpl implements KhachHangDAO {

    private final String createSql = "INSERT INTO KhachHang(MaKH, HoTen, SoDT, DiaChi, Email, NgayDangKy) VALUES(?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE KhachHang SET HoTen=?, SoDT=?, DiaChi=?, Email=?, NgayDangKy=? WHERE MaKH=?";
    private final String deleteByIdSql = "DELETE FROM KhachHang WHERE MaKH=?";

    private final String findAllSql = "SELECT * FROM KhachHang";
    private final String findByIdSql = findAllSql + " WHERE MaKH=?";
    private final String findByNameSql = findAllSql + " WHERE HoTen=?";

    @Override
    public KhachHang create(KhachHang entity) {
        Object[] values = {
            entity.getMaKH(),
            entity.getHoTen(),
            entity.getSoDT(),
            entity.getDiaChi(),
            entity.getEmail(),
            entity.getNgayDangKy(),};
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(KhachHang entity) {
        Object[] values = {
            entity.getMaKH(),
            entity.getHoTen(),
            entity.getSoDT(),
            entity.getDiaChi(),
            entity.getEmail(),
            entity.getNgayDangKy(),
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        return XQuery.getBeanList(KhachHang.class, findAllSql);
    }

    @Override
    public KhachHang findById(String id) {
        return XQuery.getSingleBean(KhachHang.class, findByIdSql, id);
    }

    @Override
    public KhachHang findByUsername(String username) {
        return XQuery.getSingleBean(KhachHang.class, findByNameSql, username);
    }

}
