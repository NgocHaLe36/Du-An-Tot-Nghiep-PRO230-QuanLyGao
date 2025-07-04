package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChiTietHoaDon {
    private int maCT;
    private int maHD;        // MaHD khoá ngoại tới HoaDon
    private int maGao;       // MaGao khoá ngoại tới Gao
    private double donGia;   // Đơn giá
    private double giamGia;  // Giảm giá
    private int soLuong;     // Số lượng
    private double thanhTien;// Thành tiền = (đơn giá - giảm giá) * số lượng
    private String TenGao;
}
