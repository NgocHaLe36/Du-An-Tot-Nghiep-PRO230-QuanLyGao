package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Gao {

    private int maGao;          // Mã gạo (tự tăng)
    private String tenGao;      // Tên gạo
    private String xuatXu;      // Xuất xứ
    private double gia;         // Giá (bán)
    private String donViTinh;   // Đơn vị tính (Kg, bao,...)
    private int soLuongTon;     // Số lượng tồn kho
    private String maLoai;      // Mã loại gạo (FK)
}
