/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.ui;

import gao.entity.HoaDon;

/**
 *
 * @author lengh
 */
public interface GaoController {

    void setHoaDon(HoaDon hoadon); // nhận bill từ BillJDialog

    void open(); // hiển thị loại và đồ uống

    void fillLoaiGao(); // tải và hiển thị loại đồ uống

    void fillGao(); // tải và hiển thị đồ uống

    void addGaoToHoaDon(); // thêm đồ uống vào
}

