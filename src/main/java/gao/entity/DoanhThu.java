/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.entity;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lengh
 */
public class DoanhThu {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class ByLoai {

        private String Tenloai; // Tên loại
        private double Doanhthu; // Doanh thu
        private int Soluong; // Số lượng đồ uống đã bán
        private double Giabancaonhat; // Giá bán cao nhất
        private double Giabanthapnhat; // Giá bán thấp nhất
        private double Giabantb; // Giá bán trung bình
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class ByUser {

        private String Ten;
        private double Doanhthu;
        private int SoluongHang;
        private Timestamp firstTime; // sửa lại
        private Timestamp lastTime;  // sửa lại
    }

}
