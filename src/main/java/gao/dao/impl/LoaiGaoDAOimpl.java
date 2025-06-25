/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.dao.impl;

import gao.entity.Gao;
import gao.entity.LoaiGao;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

/**
 *
 * @author lengh
 */
public class LoaiGaoDAOimpl implements LoaiGaoDAO {

    private final String createSql = "INSERT INTO LoaiGao(MaLoai, TenLoai) VALUES (?, ?)";
    private final String updateSql = "UPDATE LoaiGao SET TenLoai=? WHERE MaLoai=?";
    private final String deleteByIdSql = "DELETE FROM LoaiGao WHERE MaLoai=?";
    private final String findAllSql = "SELECT * FROM LoaiGao";
    private final String findByIdSql = findAllSql + " WHERE MaLoai=?";

    @Override
    public LoaiGao create(LoaiGao entity) {
        Object[] values = {
            entity.getMaLoai(),
            entity.getTenLoai()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(LoaiGao entity) {
        Object[] values = {
            entity.getTenLoai(),
            entity.getMaLoai()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<LoaiGao> findAll() {
        return XQuery.getBeanList(LoaiGao.class, findAllSql);
    }

    @Override
    public LoaiGao findById(String id) {
        return XQuery.getSingleBean(LoaiGao.class, findByIdSql, id);
    }

    @Override
    public LoaiGao findByUsername(String username) {
        return null;
    }

    @Override
    public List<Gao> findByLoaiId(String maLoai) {
        String sql = "SELECT * FROM Gao WHERE MaLoai=?";
        return XQuery.getBeanList(Gao.class, sql, maLoai);
    }

}
