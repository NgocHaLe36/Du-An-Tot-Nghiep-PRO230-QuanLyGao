package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PhieuNhap {
    private Integer maPN;
    private Date ngayNhap;
    private Integer maNCC;
    private String ghiChu;
    private Integer maGao;
    private Integer soLuong;
    private Double donGiaNhap;
}
