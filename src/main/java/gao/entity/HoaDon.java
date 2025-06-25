package gao.entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HoaDon {
    private int maHD;
    private Date ngayLap;
    private int maNV;
    private double tongTien;
}
