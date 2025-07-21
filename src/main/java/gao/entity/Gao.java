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

    private int maGao;          
    private String tenGao;     
    private String xuatXu;      
    private double gia;        
    private String donViTinh;   
    private int soLuongTon;     
    private String maLoai;      
    private double giamGia;     
}
