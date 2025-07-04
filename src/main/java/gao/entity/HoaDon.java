package gao.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HoaDon {

    private Integer cardId;
    private Integer maHd;
    private String username;
    private Timestamp thoiGianVao;
    private Timestamp thoiGianRa;
    private Integer trangThai;

    public static final String DATE_PATTERN = "HH:mm:ss dd-MM-yyyy";
}
