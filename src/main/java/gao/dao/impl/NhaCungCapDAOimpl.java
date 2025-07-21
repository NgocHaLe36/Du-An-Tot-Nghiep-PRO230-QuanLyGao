package gao.dao.impl;

import gao.dao.NhaCungCapDAO;
import gao.entity.NhaCungCap;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

public class NhaCungCapDAOimpl implements NhaCungCapDAO {

    private final String insertSql = "INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SoDT, Email) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE NhaCungCap SET TenNCC=?, DiaChi=?, SoDT=?, Email=? WHERE MaNCC=?";
    private final String deleteSql = "DELETE FROM NhaCungCap WHERE MaNCC=?";
    private final String selectAllSql = "SELECT * FROM NhaCungCap";
    private final String selectByIdSql = "SELECT * FROM NhaCungCap WHERE MaNCC=?";

    @Override
    public NhaCungCap create(NhaCungCap entity) {
        Object[] args = {
            entity.getMaNCC(),
            entity.getTenNCC(),
            entity.getDiaChi(),
            entity.getSoDT(),
            entity.getEmail()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(NhaCungCap entity) {
        Object[] args = {
            entity.getTenNCC(),
            entity.getDiaChi(),
            entity.getSoDT(),
            entity.getEmail(),
            entity.getMaNCC()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<NhaCungCap> findAll() {
        return XQuery.getBeanList(NhaCungCap.class, selectAllSql);
    }

    @Override
    public NhaCungCap findById(Integer id) {
        return XQuery.getSingleBean(NhaCungCap.class, selectByIdSql, id);
    }

    @Override
    public NhaCungCap findByUsername(Integer username) {
        return null;
    }
}
