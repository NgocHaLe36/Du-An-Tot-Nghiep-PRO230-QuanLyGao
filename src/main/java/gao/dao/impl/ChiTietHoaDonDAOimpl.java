package gao.dao.impl;

import gao.dao.*;
import gao.entity.ChiTietHoaDon;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

public class ChiTietHoaDonDAOimpl implements ChiTietHoaDonDAO {

    private final String createSql = "INSERT INTO ChiTietHoaDon (MaHD, MaGao, DonGia, GiamGia, SoLuong) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE ChiTietHoaDon SET DonGia=?, GiamGia=?, SoLuong=? WHERE MaHD=? AND MaGao=?";
    private final String deleteSql = "DELETE FROM ChiTietHoaDon WHERE MaCT=?";

    private final String findAllSql = "SELECT cthd.*, g.TenGao AS TenGao FROM ChiTietHoaDon cthd JOIN Gao g ON g.MaGao = cthd.MaGao";
    private final String findByHoaDonIdSql = findAllSql + " WHERE cthd.MaHD=?";
    private final String findByGaoIdSql = findAllSql + " WHERE cthd.MaGao=?";
    private final String findByIdSql = findAllSql + " WHERE cthd.MaHD=? AND cthd.MaGao=?";
    private final String findLastSql = findAllSql + " WHERE cthd.MaCT IN (SELECT MAX(MaCT) FROM ChiTietHoaDon)";

    @Override
    public ChiTietHoaDon create(ChiTietHoaDon entity) {
        Object[] values = {
            entity.getMaHD(),
            entity.getMaGao(),
            entity.getDonGia(),
            entity.getGiamGia(),
            entity.getSoLuong()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(ChiTietHoaDon.class, findLastSql);
    }

    @Override
    public void update(ChiTietHoaDon entity) {
        Object[] values = {
            entity.getDonGia(),
            entity.getGiamGia(),
            entity.getSoLuong(),
            entity.getMaHD(),
            entity.getMaGao()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long maCT) {
        XJdbc.executeUpdate(deleteSql, maCT);
    }

    public void deleteByHoaDonVaGao(int maHD, int maGao) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE MaHD=? AND MaGao=?";
        XJdbc.executeUpdate(sql, maHD, maGao);
    }

    @Override
    public List<ChiTietHoaDon> findAll() {
        return XQuery.getBeanList(ChiTietHoaDon.class, findAllSql);
    }

    @Override
    public ChiTietHoaDon findById(Long id) {
        throw new UnsupportedOperationException("ChiTietHoaDon cần 2 khóa (MaHD, MaGao) để tìm.");
    }

    public ChiTietHoaDon findById(int maHD, int maGao) {
        return XQuery.getSingleBean(ChiTietHoaDon.class, findByIdSql, maHD, maGao);
    }

    @Override
    public List<ChiTietHoaDon> findByHoaDonId(Long maHD) {
        return XQuery.getBeanList(ChiTietHoaDon.class, findByHoaDonIdSql, maHD);
    }

    @Override
    public List<ChiTietHoaDon> findByGaoId(int maGao) {
        return XQuery.getBeanList(ChiTietHoaDon.class, findByGaoIdSql, maGao);
    }

    @Override
    public ChiTietHoaDon findByUsername(Long username) {
        throw new UnsupportedOperationException("ChiTietHoaDon không có Username.");
    }
}