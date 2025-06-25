package gao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoaiGao {

    private String maLoai;   // Mã loại gạo (ví dụ: LG01)
    private String tenLoai;  // Tên loại gạo (ví dụ: Gạo Nhật, Gạo Thơm...)
}
