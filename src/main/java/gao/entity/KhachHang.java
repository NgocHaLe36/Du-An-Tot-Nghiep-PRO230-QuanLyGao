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
public class KhachHang {
    private Integer maKH;
    private String hoTen;
    private String soDT;
    private String diaChi;
    private String email;
    private Date ngayDangKy;
}
