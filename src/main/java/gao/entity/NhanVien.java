package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NhanVien {

    private int maNV;
    private String hoTen;
    private boolean gioiTinh;
    private String chucVu;
}
