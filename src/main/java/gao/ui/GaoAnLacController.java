/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.ui;

import gao.ui.manager.CardsManagerJDialog;
import gao.ui.manager.DoanhThuMannagerJDialog;
import gao.ui.manager.HoaDonManagerJDialog;
import gao.ui.manager.KhachHangManagerJDialog;
import gao.ui.manager.LoaiGaoManagerJDialog;
import gao.ui.manager.PhieuNhapManagerJDialog;
import gao.ui.manager.RiceManagerJDialog;
import gao.ui.manager.UserManagerJDialog;
import gao.util.XDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author lengh
 */
public interface GaoAnLacController {

    void init();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showSalesJDialog(JFrame frame) {
        this.showJDialog(new SalesJDialog(frame, true));
    }

    default void showLichSuJDialog(JFrame frame) {
        this.showJDialog(new LichSuJDialog(frame, true));
    }

    default void showRiceManagerJDialog(JFrame frame) {
        this.showJDialog(new RiceManagerJDialog(frame, true));
    }

    default void showLoaiGaoManagerJDialog(JFrame frame) {
        this.showJDialog(new LoaiGaoManagerJDialog(frame, true));
    }

    default void showCardManagerJDialog(JFrame frame) {
        this.showJDialog(new CardsManagerJDialog(frame, true));
    }

    default void showHoaDonManagerJDialog(JFrame frame) {
        this.showJDialog(new HoaDonManagerJDialog(frame, true));
    }

    default void showHoaDonJDialog(JFrame frame) {
        this.showJDialog(new HoaDonJDialog(frame, true));
    }

    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new UserManagerJDialog(frame, true));
    }

    default void showDoanhThuMannageJDialog(JFrame frame) {
        this.showJDialog(new DoanhThuMannagerJDialog(frame, true));
    }

    default void showKhachHangMannageJDialog(JFrame frame) {
        this.showJDialog(new KhachHangManagerJDialog(frame, true));
    }

    default void showPhieuNhapMannageJDialog(JFrame frame) {
        this.showJDialog(new PhieuNhapManagerJDialog(frame, true));
    }

    default void showNhaCungCapJDialog(JFrame frame) {
        this.showJDialog(new NhaCungCapJDialog(frame, true));
    }
}
