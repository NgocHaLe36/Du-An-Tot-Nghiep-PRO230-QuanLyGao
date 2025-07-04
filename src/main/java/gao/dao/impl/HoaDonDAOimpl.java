package gao.dao.impl;

import gao.entity.HoaDon;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class HoaDonDAOimpl implements HoaDonDAO {

    private final String createSql = "INSERT INTO HoaDon(Username, ThoiGianVao, ThoiGianRa, TrangThai, CardId) VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE HoaDon SET Username=?, ThoiGianVao=?, ThoiGianRa=?, TrangThai=?, CardId=? WHERE MaHD=?";
    private final String deleteByIdSql = "DELETE FROM HoaDon WHERE MaHD=?";

    private final String findAllSql = "SELECT * FROM HoaDon";
    private final String findByIdSql = "SELECT * FROM HoaDon WHERE MaHD = ?";
    private final String findLastSql = "SELECT * FROM HoaDon WHERE MaHD = (SELECT MAX(MaHD) FROM HoaDon)";
    private final String findByUsernameSql = findAllSql + " WHERE Username=?";
    private final String findServicingByUsernameSql = findAllSql + " WHERE Username=? AND TrangThai=0";
    private final String findByTimeRangeSql = findAllSql + " WHERE ThoiGianVao BETWEEN ? AND ? ORDER BY ThoiGianVao DESC";
    private final String findByUserAndTimeRangeSql = findAllSql + " WHERE Username=? AND ThoiGianVao BETWEEN ? AND ? ORDER BY ThoiGianVao DESC";

    @Override
    public HoaDon create(HoaDon entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getThoiGianVao(),
            entity.getThoiGianRa(),
            entity.getTrangThai(),
            entity.getCardId()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(HoaDon.class, findLastSql);
    }

    @Override
    public void update(HoaDon entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getThoiGianVao(),
            entity.getThoiGianRa(),
            entity.getTrangThai(),
            entity.getCardId(),
            entity.getMaHd()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<HoaDon> findAll() {
        return XQuery.getBeanList(HoaDon.class, findAllSql);
    }

    @Override
    public HoaDon findById(Long id) {
        return XQuery.getSingleBean(HoaDon.class, findByIdSql, id);
    }

    @Override
    public List<HoaDon> findByUsername(String username) {
        return XQuery.getBeanList(HoaDon.class, findByUsernameSql, username);
    }

    @Override
    public HoaDon findServicingByUsername(String username) {
        HoaDon hoadon = XQuery.getSingleBean(HoaDon.class, findServicingByUsernameSql, username);
        if (hoadon == null) {
            HoaDon newHd = new HoaDon();
            newHd.setUsername(username);
            newHd.setThoiGianVao(new Timestamp(System.currentTimeMillis()));
            newHd.setTrangThai(0); // trạng thái đang phục vụ
            newHd.setCardId(1);    // mặc định hoặc random
            hoadon = this.create(newHd);
        }
        return hoadon;
    }

    @Override
    public List<HoaDon> findByTimeRange(Date from, Date to) {
        return XQuery.getBeanList(HoaDon.class, findByTimeRangeSql, from, to);
    }

    @Override
    public List<HoaDon> findByUserAndTimeRange(String username, Date from, Date to) {
        return XQuery.getBeanList(HoaDon.class, findByUserAndTimeRangeSql, username, from, to);
    }

    @Override
    public HoaDon findByUsername(Long username) {
        return null; // không dùng
    }

    @Override
    public HoaDon findServicingByCardId(int cardId) {
        String sql = "SELECT * FROM HoaDon WHERE TrangThai = 0 AND CardId = ?";
        return XQuery.getSingleBean(HoaDon.class, sql, cardId);
    }

}
