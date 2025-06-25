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
    private int maHD;
    private int maGao;
    private int soLuong;
    private double donGia;
    private double thanhTien;
}
