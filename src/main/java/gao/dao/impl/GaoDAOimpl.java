package gao.dao.impl;

import gao.entity.Gao;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

public class GaoDAOimpl implements GaoDAO {

    private final String createSql = "INSERT INTO Gao(TenGao, XuatXu, Gia, DonViTinh, SoLuongTon, MaLoai, GiamGia) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Gao SET TenGao=?, XuatXu=?, Gia=?, DonViTinh=?, SoLuongTon=?, MaLoai=?, GiamGia=? " + "WHERE MaGao=?";
    private final String deleteByIdSql = "DELETE FROM Gao WHERE MaGao=?";
    private final String findAllSql = "SELECT * FROM Gao";
    private final String findByIdSql = findAllSql + " WHERE MaGao=?";
    private final String findByLoaiIdSql = findAllSql + " WHERE MaLoai=?";

    @Override
    public Gao create(Gao entity) {
        Object[] values = {
            entity.getTenGao(),
            entity.getXuatXu(),
            entity.getGia(),
            entity.getDonViTinh(),
            entity.getSoLuongTon(),
            entity.getMaLoai(),
            entity.getGiamGia()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Gao entity) {
        Object[] values = {
            entity.getTenGao(),
            entity.getXuatXu(),
            entity.getGia(),
            entity.getDonViTinh(),
            entity.getSoLuongTon(),
            entity.getMaLoai(),
            entity.getGiamGia(),
            entity.getMaGao()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Gao> findAll() {
        return XQuery.getBeanList(Gao.class, findAllSql);
    }

    @Override
    public Gao findById(String id) {
        return XQuery.getSingleBean(Gao.class, findByIdSql, id);
    }

    @Override
    public Gao findByUsername(String username) {
        return null; // Không áp dụng cho gạo
    }

    public List<Gao> findByLoaiId(String maLoai) {
        return XQuery.getBeanList(Gao.class, findByLoaiIdSql, maLoai);
    }
}
