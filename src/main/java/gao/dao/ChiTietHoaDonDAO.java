/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.dao;

import gao.entity.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author lengh
 */
public interface ChiTietHoaDonDAO extends CrudDAO<ChiTietHoaDon, Long> {

    List<ChiTietHoaDon> findByHoaDonId(Long maHD);

    List<ChiTietHoaDon> findByGaoId(int maGao);
}
