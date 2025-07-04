/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.ui.manager;

import gao.entity.HoaDon;
import poly.cafe.ui.manager.CrudController;

/**
 *
 * @author lengh
 */
public interface HoaDonController extends CrudController<HoaDon> {

    void fillBillDetails(); // tải và hiển thị chi tiết phiếu

    void selectTimeRange(); // xử lý chọn khoảng thời gian trong cboTimeRanges
}
