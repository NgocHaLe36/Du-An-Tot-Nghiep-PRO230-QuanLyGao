package gao.dao.impl;

import gao.entity.HoaDon;
import java.util.Date;
import java.util.List;

/**
 * Interface xử lý DAO cho đối tượng HoaDon
 */
public interface HoaDonDAO extends CrudDAO<HoaDon, Long> {

    /**
     * Lấy danh sách hóa đơn theo username nhân viên
     * 
     * @param username tên đăng nhập của nhân viên
     * @return danh sách hóa đơn
     */
    List<HoaDon> findByUsername(String username);

    /**
     * Lấy hóa đơn đang được phục vụ bởi nhân viên
     * 
     * @param username tên đăng nhập của nhân viên
     * @return hóa đơn đang phục vụ hoặc null nếu không có
     */
    HoaDon findServicingByUsername(String username);

    /**
     * Lấy danh sách hóa đơn theo khoảng thời gian
     * 
     * @param from thời gian bắt đầu
     * @param to thời gian kết thúc
     * @return danh sách hóa đơn trong khoảng
     */
    List<HoaDon> findByTimeRange(Date from, Date to);

    /**
     * Lấy danh sách hóa đơn theo username và khoảng thời gian
     * 
     * @param username tên đăng nhập
     * @param from thời gian bắt đầu
     * @param to thời gian kết thúc
     * @return danh sách hóa đơn tương ứng
     */
    List<HoaDon> findByUserAndTimeRange(String username, Date from, Date to);

    public HoaDon findServicingByCardId(int cardId);
    
}
