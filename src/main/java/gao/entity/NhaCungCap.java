package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NhaCungCap {
    private Integer maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDT;
    private String email;
}
