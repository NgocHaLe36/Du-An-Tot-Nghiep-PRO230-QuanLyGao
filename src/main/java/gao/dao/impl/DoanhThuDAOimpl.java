/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.dao.impl;

import gao.entity.DoanhThu;
import gao.dao.DoanhThuDAO;
import gao.ui.manager.DoanhThuController;
import gao.util.XQuery;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lengh
 */
public class DoanhThuDAOimpl implements DoanhThuDAO {

    @Override
    public List<DoanhThu.ByLoai> getByCategory(Date begin, Date end) {
        String sql = """
        SELECT l.TenLoai AS Tenloai,
               SUM(ct.DonGia * ct.SoLuong * (1 - ct.GiamGia)) AS Doanhthu,
               SUM(ct.SoLuong) AS Soluong,
               MAX(ct.DonGia) AS Giabancaonhat,
               MIN(ct.DonGia) AS Giabanthapnhat,
               AVG(ct.DonGia) AS Giabantb
        FROM ChiTietHoaDon ct
        JOIN HoaDon hd ON hd.MaHD = ct.MaHD
        JOIN Gao g ON g.MaGao = ct.MaGao
        JOIN LoaiGao l ON l.MaLoai = g.MaLoai
        WHERE hd.TrangThai = 1
          AND hd.ThoiGianRa BETWEEN ? AND ?
        GROUP BY l.TenLoai
        ORDER BY Doanhthu DESC
    """;

        return XQuery.getBeanList(DoanhThu.ByLoai.class, sql, begin, end);
    }

    @Override
    public List<DoanhThu.ByUser> getByUser(Date begin, Date end) {
        String sql = """
        SELECT 
            hd.Username AS Ten,
            SUM(ct.DonGia * ct.SoLuong * (1 - ISNULL(ct.GiamGia, 0))) AS Doanhthu,
            COUNT(DISTINCT hd.MaHD) AS SoluongHang,
            MIN(hd.ThoiGianVao) AS firstTime,
            MAX(hd.ThoiGianRa) AS lastTime
        FROM ChiTietHoaDon ct
        JOIN HoaDon hd ON hd.MaHD = ct.MaHD
        WHERE hd.TrangThai = 1
          AND hd.ThoiGianRa BETWEEN ? AND ?
        GROUP BY hd.Username
        ORDER BY Doanhthu DESC
    """;

        return XQuery.getBeanList(DoanhThu.ByUser.class, sql, begin, end);
    }

}
