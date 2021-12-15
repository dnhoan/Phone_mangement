/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusVoucherModel;
import BUS.Models.spsalemodel;
import BUS.Services.SanPhamsaleSevice;
import BUS.Services.ThemMoiSPsell;
import BUS.Services.VoucherService;
import DAL.Models.ThemSPsaleMoldel;
import DAL.Services.JDBCHelper;
import GUI.Services.DateService;
import GUI.Services.MessageService;
import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author DUCNAM
 */
public class QLGiamGia extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLGiamGia
     */
    int sospGG;
    String id;
    ThemMoiSPsell saledao = new ThemMoiSPsell();
    Connection con = JDBCHelper.ketnoi();
    VoucherService daovc = new VoucherService();
    int index = 0;
    SanPhamsaleSevice spsaledao = new SanPhamsaleSevice();
    JTextFieldDateEditor editor0;
    JTextFieldDateEditor editor1;

    public QLGiamGia() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillcbb();
        fillloaima();
        jPanel2.setVisible(false);
        filltb();
        for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
            tblSanPhamSAle.setValueAt(true, i, 2);
        }
        editor0 = (JTextFieldDateEditor) txtNgayBD.getDateEditor();
        editor1 = (JTextFieldDateEditor) txtNgayKT.getDateEditor();
        editor0.setEditable(false);
        editor1.setEditable(false);
        btndanang.setVisible(false);
        btndn2.setVisible(false);
        txtdonvidonhangtoiithieu.setVisible(false);
        lblgiatridonhangtoithieu.setVisible(false);
        txtgiatridonhangtoiitheu.setVisible(false);
//        clear();
        setUI();
        desginTable();
    }

    public void setUI() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int h = d.height;
        int w = d.width;
        this.setSize(w, h);
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void desginTable() {
        tblSanPhamSAle.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblSanPhamSAle.getTableHeader().setOpaque(false);
        tblSanPhamSAle.getTableHeader().setBackground(new Color(25, 29, 74));
        tblSanPhamSAle.getTableHeader().setForeground(Color.WHITE);
        tblbangdaketthuc.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblSanPhamSAle.setGridColor(new Color(25, 29, 74));
        tblSanPhamSAle.setShowGrid(true);
        tblSanPhamSAle.setSelectionBackground(new Color(38, 117, 191));
        tblbangdaketthuc.getTableHeader().setOpaque(false);
        tblbangdaketthuc.getTableHeader().setBackground(new Color(25, 29, 74));
        tblbangdaketthuc.getTableHeader().setForeground(Color.WHITE);
        tblbangdaketthuc.setGridColor(new Color(25, 29, 74));
        tblbangdaketthuc.setShowGrid(true);
        tblbangdaketthuc.setSelectionBackground(new Color(38, 117, 191));
        tblbangsapdienra.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblbangđangienra.setSelectionBackground(new Color(38, 117, 191));
        tblbangsapdienra.getTableHeader().setOpaque(false);
        tblbangsapdienra.getTableHeader().setBackground(new Color(25, 29, 74));
        tblbangsapdienra.getTableHeader().setForeground(Color.WHITE);
        tblbangsapdienra.setGridColor(new Color(25, 29, 74));
        tblbangsapdienra.setShowGrid(true);
        tblbangtatca.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblbangsapdienra.setSelectionBackground(new Color(38, 117, 191));
        tblbangtatca.getTableHeader().setOpaque(false);
        tblbangtatca.getTableHeader().setBackground(new Color(25, 29, 74));
        tblbangtatca.getTableHeader().setForeground(Color.WHITE);
        tblbangtatca.setGridColor(new Color(25, 29, 74));
        tblbangtatca.setShowGrid(true);
        tblbangtatca.setSelectionBackground(new Color(38, 117, 191));
        tblbangđangienra.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        tblbangđangienra.getTableHeader().setOpaque(false);
        tblbangđangienra.getTableHeader().setBackground(new Color(25, 29, 74));
        tblbangđangienra.getTableHeader().setForeground(Color.WHITE);
        tblbangđangienra.setGridColor(new Color(25, 29, 74));
        tblbangđangienra.setShowGrid(true);
        tblbangđangienra.setSelectionBackground(new Color(38, 117, 191));
    }

    private void fillloaima() {
//        cbbloaima.removeAllItems();
//
//        try {
//            String sql = "select * from loaimagiamgia";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                cbbloaima.addItem(rs.getString("tenloaigiamgia"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    boolean cheksua() {
        if (chekrong() == false) {
            return false;
        } else if (chekmucGG() == false) {
            return false;
        }
        return true;
    }

    boolean chekrong() {
        if (txtTenChuongTrinh.getText().equals("")) {
            MessageService.alert(rootPane, "Bạn không thể bỏ trống tên trương trình");
            txtTenChuongTrinh.requestFocus();
            return false;

        } else if (txtMaVC.getText().equals("")) {
            MessageService.alert(rootPane, "Bạn không thể bỏ trống mã voucher");
            txtMaVC.requestFocus();
            return false;
        }
        return true;

    }

    boolean checkthem() {
        if (chekrong() == false) {
            return false;
        } else if (chekngay() == false) {
            return false;
        } else if (chekmucGG() == false) {
            return false;
        } else if (chektrung() == false) {
            return false;
        }

        return true;
    }

    boolean chektrung() {
        List<BusVoucherModel> list = daovc.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (txtMaVC.getText().equalsIgnoreCase(list.get(i).getMaVC())) {
                MessageService.alert(rootPane, "Đã có mã vocher mời bạn nhập mã khác");
                return false;
            }
        }
        return true;
    }

    boolean chekmucGG() {
        if (txtMucGG.getText().equals("")) {
            MessageService.alert(rootPane, "Bạn không thể bỏ trống mức giảm giá");
            txtMucGG.requestFocus();
            return false;
        }
        try {
            int mucgg = Integer.parseInt(txtMucGG.getText());
            if (mucgg <= 0) {
                MessageService.alert(rootPane, "Mức giảm giá phải là số lớn hơn 0");
                txtMucGG.requestFocus();
                return false;
            } else if (cbbLoaiGG.getSelectedIndex() == 1) {
                if (mucgg > 100) {
                    MessageService.alert(rootPane, "Không thể sale lớn hơn 100%");
                    txtMucGG.requestFocus();
                    return false;
                }
            }
        } catch (Exception e) {
            MessageService.alert(rootPane, "Mức giảm giá phải là số mời bạn nhập lại");
            txtMucGG.requestFocus();
            return false;
        }
        return true;
    }

    boolean chekngay() {

        if (txtNgayBD.getDate() == null) {
            MessageService.alert(rootPane, "Không thể bỏ trống ngày bắt đầu");
            txtNgayBD.requestFocus();
            return false;
        } else if (txtNgayKT.getDate() == null) {
            MessageService.alert(rootPane, "Không thể bỏ trống ngày kết thúc");
            txtNgayKT.requestFocus();
            return false;
        }
        try {
            LocalDate dateNgay = LocalDate.now();
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dateNgay.toString());
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            c1.setTime(txtNgayBD.getDate());
            c2.setTime(d);
            c3.setTime(txtNgayKT.getDate());
            long noDay2 = (c3.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
            if (noDay2 == 0) {
                MessageService.alert(rootPane, "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất một ngày");
                return false;
            } else if (noDay2 < 0) {
                MessageService.alert(rootPane, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(rootPane, "ETR");
            return false;
        }
        return true;
    }

    void filltb() {
        filltableByHang();
        filltabletatca();
        filltabledangdienra();
        filltablesapdienra();
        filltabledaketthuc();
    }

    void clicktable() {

        if (jtap.getSelectedIndex() == 0) {
            if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 5).equals("Đang diễn ra")) {
                btndanang.setVisible(true);
                btndanang.setEnabled(true);
                btndn2.setVisible(true);
                btndanang.setText("Dừng chương trình này");
                btndn2.setText("Sửa ngày kết thúc");
                btndn2.setEnabled(true);
                txtNgayBD.setEnabled(false);
                txtNgayKT.setEnabled(false);
                cbbLoaiGG.setEnabled(true);
                txtMucGG.setEnabled(true);
                btnSua.setEnabled(true);
                txtTenChuongTrinh.setEnabled(true);
                tblSanPhamSAle.setEnabled(true);
                btnchonlaisanpham.setEnabled(true);
                btnchontatcasanpham.setEnabled(true);
                btnThem.setEnabled(false);
                demspsale();
                if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                    txtdonvidonhangtoiithieu.setVisible(true);
                    lblgiatridonhangtoithieu.setVisible(true);
                    txtgiatridonhangtoiitheu.setVisible(true);
                } else {
                    txtdonvidonhangtoiithieu.setVisible(false);
                    lblgiatridonhangtoithieu.setVisible(false);
                    txtgiatridonhangtoiitheu.setVisible(false);
                }

            } else if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 5).equals("Sắp diễn ra")) {
                btndanang.setVisible(true);
                btndanang.setEnabled(true);
                btndn2.setVisible(false);
                btndanang.setText("Cho chương trình sale luôn");
                txtTenChuongTrinh.setEnabled(true);
                cbbLoaiGG.setEnabled(true);
                txtMucGG.setEnabled(true);
                demspsale();
                btnSua.setEnabled(true);
                tblSanPhamSAle.setEnabled(true);
                btnchonlaisanpham.setEnabled(true);
                btnchontatcasanpham.setEnabled(true);
                if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                    txtdonvidonhangtoiithieu.setVisible(true);
                    lblgiatridonhangtoithieu.setVisible(true);
                    txtgiatridonhangtoiitheu.setVisible(true);
                } else {
                    txtdonvidonhangtoiithieu.setVisible(false);
                    lblgiatridonhangtoithieu.setVisible(false);
                    txtgiatridonhangtoiitheu.setVisible(false);
                }
            } else if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 5).equals("Đã kết thúc")) {
                btndanang.setVisible(true);
                btndanang.setText("Khôi phục lại trương trình sale");
                btndanang.setEnabled(true);
                btnSua.setEnabled(false);
                btnThem.setEnabled(false);
                btndn2.setVisible(false);
                txtTenChuongTrinh.setEnabled(false);
                txtNgayBD.setEnabled(false);
                txtNgayKT.setEnabled(false);
                cbbLoaiGG.setEnabled(false);
                txtMucGG.setEnabled(false);
                demspsale();
                tblSanPhamSAle.setEnabled(false);
                txtMaVC.setEnabled(false);
                btnchonlaisanpham.setEnabled(false);
                btnchontatcasanpham.setEnabled(false);
                btndn2.setEnabled(true);
                if (tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                    txtdonvidonhangtoiithieu.setVisible(true);
                    lblgiatridonhangtoithieu.setVisible(true);
                    txtgiatridonhangtoiitheu.setVisible(true);
                } else {
                    txtdonvidonhangtoiithieu.setVisible(false);
                    lblgiatridonhangtoithieu.setVisible(false);
                    txtgiatridonhangtoiitheu.setVisible(false);
                }
            }

        } else if (jtap.getSelectedIndex() == 1) {
            btndanang.setVisible(true);
            btndn2.setVisible(true);
            btndanang.setText("Dừng chương trình này");
            btndn2.setText("Thêm ngày sale");
            btnThem.setEnabled(false);
            btndn2.setEnabled(true);
            cbbLoaiGG.setEnabled(true);
            btndanang.setEnabled(true);
            txtMucGG.setEnabled(true);
            btnSua.setEnabled(true);
            txtNgayBD.setEnabled(false);
            txtNgayKT.setEnabled(false);
            txtTenChuongTrinh.setEnabled(true);
            tblSanPhamSAle.setEnabled(true);
            btnchonlaisanpham.setEnabled(true);
            demspsale();
            btnchontatcasanpham.setEnabled(true);
            if (tblbangđangienra.getValueAt(tblbangđangienra.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                txtdonvidonhangtoiithieu.setVisible(true);
                lblgiatridonhangtoithieu.setVisible(true);
                txtgiatridonhangtoiitheu.setVisible(true);
            } else {
                txtdonvidonhangtoiithieu.setVisible(false);
                lblgiatridonhangtoithieu.setVisible(false);
                txtgiatridonhangtoiitheu.setVisible(false);
            }
        } else if (jtap.getSelectedIndex() == 2) {
            btndanang.setVisible(true);
            btndn2.setVisible(false);
            btndanang.setText("Cho chương trình sale luôn");
            txtTenChuongTrinh.setEnabled(true);
            cbbLoaiGG.setEnabled(true);
            txtMucGG.setEnabled(true);
            btndanang.setEnabled(true);
            btnSua.setEnabled(true);
            tblSanPhamSAle.setEnabled(true);
            btnchonlaisanpham.setEnabled(true);
            btnchontatcasanpham.setEnabled(true);
            demspsale();
            if (tblbangsapdienra.getValueAt(tblbangsapdienra.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                txtdonvidonhangtoiithieu.setVisible(true);
                lblgiatridonhangtoithieu.setVisible(true);
                txtgiatridonhangtoiitheu.setVisible(true);
            } else {
                txtdonvidonhangtoiithieu.setVisible(false);
                lblgiatridonhangtoithieu.setVisible(false);
                txtgiatridonhangtoiitheu.setVisible(false);
            }
        } else if (jtap.getSelectedIndex() == 3) {
            btndanang.setVisible(true);
            btndanang.setText("Khôi phục lại trương trình sale");
            btndanang.setEnabled(true);
            btnSua.setEnabled(false);
            btnThem.setEnabled(false);
            btndn2.setVisible(false);
            txtTenChuongTrinh.setEnabled(false);
            cbbLoaiGG.setEnabled(false);
            txtMucGG.setEnabled(false);
            txtMaVC.setEnabled(false);
            demspsale();
            txtNgayBD.setEnabled(false);
            txtNgayKT.setEnabled(false);
            tblSanPhamSAle.setEnabled(false);
            btnchonlaisanpham.setEnabled(false);
            btnchontatcasanpham.setEnabled(false);
            btndn2.setEnabled(true);
            if (tblbangdaketthuc.getValueAt(tblbangdaketthuc.getSelectedRow(), 1).equals("Giảm giá theo hóa đơn")) {
                txtdonvidonhangtoiithieu.setVisible(true);
                lblgiatridonhangtoithieu.setVisible(true);
                txtgiatridonhangtoiitheu.setVisible(true);
            } else {
                txtdonvidonhangtoiithieu.setVisible(false);
                lblgiatridonhangtoithieu.setVisible(false);
                txtgiatridonhangtoiitheu.setVisible(false);
            }
        }

    }

    void fillcbb() {
        cbbhangdt.removeAllItems();

        try {
            String sql = "select * from HangSanPham";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbbhangdt.addItem("Tất Cả");
            while (rs.next()) {

                cbbhangdt.addItem(rs.getString("tenhang"));
            }
        } catch (Exception e) {
        }

    }

    private void filltableByHang() {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamSAle.getModel();
        model.setRowCount(0);
        try {
            id = String.valueOf(cbbhangdt.getSelectedItem());
            if (id.equals("Tất Cả")) {
                id = "";
            }
            List< ThemSPsaleMoldel> list = saledao.selectByHang(id);
            for (ThemSPsaleMoldel sale : list) {
                Object[] row = {
                    sale.getMasp(),
                    sale.getTenSP(),
                    false
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    void clear() {
        cbbloaima.setSelectedIndex(0);
        txtTenChuongTrinh.setText("");
        txtMaVC.setText("");
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtMucGG.setText("");
        tblSanPhamSAle.setEnabled(true);
        btnchonlaisanpham.setEnabled(true);
        btnchontatcasanpham.setEnabled(true);
        cbbLoaiGG.setSelectedIndex(0);
        txtgiatridonhangtoiitheu.setText("");
        btnSua.setEnabled(false);
        loaima();
        sttclear();
    }

    private void filltableByTen() {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamSAle.getModel();
        model.setRowCount(0);
        try {
            List< ThemSPsaleMoldel> list = saledao.selectByKeyword(txtTimKiem.getText());
            for (ThemSPsaleMoldel sale : list) {
                Object[] row = {
                    sale.getMasp(),
                    sale.getTenSP(),};
                model.addRow(row);

            }
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    void filltabledangdienra() {
        DefaultTableModel model = (DefaultTableModel) tblbangđangienra.getModel();
        model.setRowCount(0);

        for (int i = 0; i < tblbangtatca.getRowCount(); i++) {
            if (tblbangtatca.getValueAt(i, 5).equals("Đang diễn ra")) {
                model.addRow(new Object[]{
                    tblbangtatca.getValueAt(i, 0),
                    tblbangtatca.getValueAt(i, 1),
                    tblbangtatca.getValueAt(i, 2),
                    tblbangtatca.getValueAt(i, 3),
                    tblbangtatca.getValueAt(i, 4),
                    tblbangtatca.getValueAt(i, 5),
                    tblbangtatca.getValueAt(i, 6),});
            }
        }
    }

    void filltabledaketthuc() {
        DefaultTableModel model = (DefaultTableModel) tblbangdaketthuc.getModel();
        model.setRowCount(0);

        for (int i = 0; i < tblbangtatca.getRowCount(); i++) {
            if (tblbangtatca.getValueAt(i, 5).equals("Đã kết thúc")) {
                model.addRow(new Object[]{
                    tblbangtatca.getValueAt(i, 0),
                    tblbangtatca.getValueAt(i, 1),
                    tblbangtatca.getValueAt(i, 2),
                    tblbangtatca.getValueAt(i, 3),
                    tblbangtatca.getValueAt(i, 4),
                    tblbangtatca.getValueAt(i, 5),
                    tblbangtatca.getValueAt(i, 6),});
            }
        }
    }

    void filltablesapdienra() {
        DefaultTableModel model = (DefaultTableModel) tblbangsapdienra.getModel();
        model.setRowCount(0);
        for (int i = 0; i < tblbangtatca.getRowCount(); i++) {
            if (tblbangtatca.getValueAt(i, 5).equals("Sắp diễn ra")) {
                model.addRow(new Object[]{
                    tblbangtatca.getValueAt(i, 0),
                    tblbangtatca.getValueAt(i, 1),
                    tblbangtatca.getValueAt(i, 2),
                    tblbangtatca.getValueAt(i, 3),
                    tblbangtatca.getValueAt(i, 4),
                    tblbangtatca.getValueAt(i, 5),
                    tblbangtatca.getValueAt(i, 6),});
            }
        }
    }

    private void filltableByMaSP() {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamSAle.getModel();
        model.setRowCount(0);
        try {
            List< ThemSPsaleMoldel> list = saledao.selectByID(txtTimKiem.getText());
            for (ThemSPsaleMoldel sale : list) {
                Object[] row = {
                    sale.getMasp(),
                    sale.getTenSP(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    void filltabletatca() {
        DefaultTableModel model = (DefaultTableModel) tblbangtatca.getModel();
        model.setRowCount(0);
        try {
            List<BusVoucherModel> list = daovc.selectAll();
            for (BusVoucherModel vc : list) {
                Object[] row = {
                    vc.getMaKM(),
                    vc.loaiKMtable(),
                    vc.getTenKM(),
                    vc.getMaVC(),
                    vc.MucGGtable(),
                    vc.TrangThaitable(),
                    "từ " + DateService.toString(vc.getNgayBD(), "dd-MM-yyyy") + " đến " + DateService.toString(vc.getNgayKT(), "dd-MM-yyyy")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loaima() {
        if (cbbloaima.getSelectedIndex() == 0) {
            jPanel2.setVisible(false);
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);
            }
            txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");
            txtdonvidonhangtoiithieu.setVisible(false);
            lblgiatridonhangtoithieu.setVisible(false);
            txtgiatridonhangtoiitheu.setVisible(false);
        } else if (cbbloaima.getSelectedIndex() == 1) {
            jPanel2.setVisible(true);
            if (tblSanPhamSAle.getRowCount() == 0) {
                txtSAnphamdcapdung.setText("");
            } else {
                sospGG = 0;
            }
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(false, i, 2);
                if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                    sospGG++;
                }
            }
            txtSAnphamdcapdung.setText(sospGG + " Sản phẩm được trọn");
            txtdonvidonhangtoiithieu.setVisible(false);
            lblgiatridonhangtoithieu.setVisible(false);
            txtgiatridonhangtoiitheu.setVisible(false);
        } else if (cbbloaima.getSelectedIndex() == 2) {
            jPanel2.setVisible(false);
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);
            }
            txtSAnphamdcapdung.setText("");
            txtdonvidonhangtoiithieu.setVisible(true);
            lblgiatridonhangtoithieu.setVisible(true);
            txtgiatridonhangtoiitheu.setVisible(true);
        }
    }

    void filltabletoForm() {
        try {
            BusVoucherModel model = daovc.selectByID(makm());
            if (model != null) {
                this.setModel(model);
            }
        } catch (Exception a) {
            MessageService.alert(this, "lỗi truy vấn dữ liệu!");
            a.printStackTrace();
        }

    }

    private BusVoucherModel getEntity() {
        BusVoucherModel entity = new BusVoucherModel();
        entity.setLoaikm(cbbloaima.getSelectedIndex());
        entity.setTenKM(txtTenChuongTrinh.getText());
        entity.setMaVC(txtMaVC.getText());
        entity.setLoaiGG(cbbLoaiGG.getSelectedIndex());
        entity.setNgayBD(txtNgayBD.getDate());
        entity.setNgayKT(txtNgayKT.getDate());
        entity.setMucGG(Integer.parseInt(txtMucGG.getText()));
        if (txtgiatridonhangtoiitheu.getText().equals("")) {
            entity.setDKKM(0);
        } else {
            entity.setDKKM(Integer.parseInt(txtgiatridonhangtoiitheu.getText()));
        }

        return entity;
    }

    private BusVoucherModel getEntiti() {
        BusVoucherModel entity = new BusVoucherModel();
        entity.setLoaikm(cbbloaima.getSelectedIndex());
        entity.setTenKM(txtTenChuongTrinh.getText());
        entity.setMaVC(txtMaVC.getText());
        entity.setLoaiGG(cbbLoaiGG.getSelectedIndex());
        entity.setNgayBD(txtNgayBD.getDate());
        entity.setNgayKT(txtNgayKT.getDate());
        entity.setMucGG(Integer.parseInt(txtMucGG.getText()));
        if (jtap.getSelectedIndex() == 0) {
            entity.setMaKM(Integer.parseInt(tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 0).toString()));
        } else if (jtap.getSelectedIndex() == 1) {
            entity.setMaKM(Integer.parseInt(tblbangđangienra.getValueAt(tblbangđangienra.getSelectedRow(), 0).toString()));
        } else if (jtap.getSelectedIndex() == 2) {
            entity.setMaKM(Integer.parseInt(tblbangsapdienra.getValueAt(tblbangsapdienra.getSelectedRow(), 0).toString()));
        } else if (jtap.getSelectedIndex() == 3) {
            entity.setMaKM(Integer.parseInt(tblbangdaketthuc.getValueAt(tblbangdaketthuc.getSelectedRow(), 0).toString()));
        }
        entity.setDKKM(Integer.parseInt(txtgiatridonhangtoiitheu.getText()));
        return entity;
    }

    private void sttclear() {
        txtMaVC.setEnabled(true);
        cbbloaima.setEnabled(true);
        cbbloaima.setVisible(true);
        txtNgayBD.setEnabled(true);
        txtNgayKT.setEnabled(true);
        txtMucGG.setEnabled(true);
        editor0.setEditable(false);
        editor1.setEditable(false);
        btndanang.setVisible(false);
        btndn2.setVisible(false);
        txtTenChuongTrinh.setEnabled(true);
        cbbLoaiGG.setEnabled(true);
        btnThem.setEnabled(true);

    }

    private int makm() {
        int makm = 0;
        if (jtap.getSelectedIndex() == 0) {
            makm = Integer.parseInt(tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 0).toString());
        } else if (jtap.getSelectedIndex() == 1) {
            makm = Integer.parseInt(tblbangđangienra.getValueAt(tblbangđangienra.getSelectedRow(), 0).toString());
        } else if (jtap.getSelectedIndex() == 2) {
            makm = Integer.parseInt(tblbangsapdienra.getValueAt(tblbangsapdienra.getSelectedRow(), 0).toString());
        } else if (jtap.getSelectedIndex() == 3) {
            makm = Integer.parseInt(tblbangdaketthuc.getValueAt(tblbangdaketthuc.getSelectedRow(), 0).toString());
        }
        return makm;
    }

    private void update() {
        try {
            BusVoucherModel model = getEntiti();
            if (cbbloaima.getSelectedIndex() == 0) {
                daovc.update(model);
            } else if (cbbloaima.getSelectedIndex() == 1) {
                daovc.update(model);
                daovc.deleteSPsale(model);
                int masp;
                for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                    if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                        masp = Integer.parseInt(tblSanPhamSAle.getValueAt(i, 0).toString());
                        daovc.insertsanphamdcsale(masp, makm());
                    }
                }
            } else if (cbbloaima.getSelectedIndex() == 2) {
                daovc.updatesalehoadon(model);
            }
            filltb();

            MessageService.alert(this, "Cập nhập Thành công!");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(this, "Cập nhập thất bại!");
        }
    }

    void insertnew() {
        BusVoucherModel entity = getEntity();
        if (cbbloaima.getSelectedIndex() == 0 || cbbloaima.getSelectedIndex() == 1) {
            try {
                int masp;
                daovc.insert(entity);
                for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                    if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                        masp = Integer.parseInt(tblSanPhamSAle.getValueAt(i, 0).toString());
                        daovc.insertspsale(masp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (cbbloaima.getSelectedIndex() == 2) {
            try {
                daovc.insertsalehoadon(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    void demspsale() {
        if (cbbloaima.getSelectedIndex() == 0) {
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);

            }
            txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");
        } else if (cbbloaima.getSelectedIndex() == 1) {
            sospGG = 0;
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                    sospGG++;
                }
            }
            txtSAnphamdcapdung.setText(sospGG + " Sản phẩm được trọn");
        } else if (cbbloaima.getSelectedIndex() == 2) {
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);

            }
            txtSAnphamdcapdung.setText("");
        }
    }

    void sanphamdsale() {
        try {
            int makm = Integer.parseInt(tblbangtatca.getValueAt(index, 0).toString());
            List<spsalemodel> list = spsaledao.selectByMaKM(makm);
            for (spsalemodel sps : list) {
                for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                    if (tblSanPhamSAle.getValueAt(i, 0).equals(sps.getMaSP())) {
                        tblSanPhamSAle.setValueAt(true, i, 2);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dungchuongtrinhnay() {
        txtNgayKT.setDate(DateService.now());
        try {
            BusVoucherModel model = getEntiti();
            daovc.Update_NgayBD_Ngaykt(model);
            filltb();

            MessageService.alert(this, "Chương trình đã kết thúc");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(this, "ERRON!");
        }
    }

    void chochuongtrinhsleluon() {
        txtNgayBD.setDate(DateService.now());
        try {
            BusVoucherModel model = getEntiti();
            daovc.Update_NgayBD_Ngaykt(model);
            filltb();
            MessageService.alert(this, "Chương trình đã bắt đầu sale");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(this, "ERRON!");
        }
    }

    void khoiphuclaitruongtrinh() {
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtNgayKT.setEnabled(true);
        txtNgayBD.setEnabled(true);
        MessageService.alert(rootPane, "Mời bạn chọn ngày bắt đầu và kết thúc");
        btndn2.setEnabled(false);
        editor0.setEditable(false);
        editor1.setEditable(false);

        btndanang.setText("Khôi Phục");

    }

    void khoiphuc() {
        try {
            BusVoucherModel model = getEntiti();

            daovc.Update_NgayBD_Ngaykt(model);
//                    System.out.println("hihi");

            filltb();

            MessageService.alert(this, "Chương trình đã được khôi phục");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(this, "ERRON!");
        }

    }

    void themngaysale() {
        btndn2.setText("Sửa");
        btndanang.setVisible(true);
        btndanang.setEnabled(false);

        btndanang.setText("Dừng chương trình này");
        btndn2.setVisible(true);
        txtTenChuongTrinh.setEnabled(false);
        cbbLoaiGG.setEnabled(false);
        txtMucGG.setEnabled(false);
        tblSanPhamSAle.setEnabled(false);
        btnchonlaisanpham.setEnabled(false);
        btnchontatcasanpham.setEnabled(false);
        btnSua.setEnabled(false);
        btnThem.setEnabled(false);
        MessageService.alert(rootPane, "Mời bạn sửa ngày kết thúc");
        txtNgayKT.setEnabled(true);

    }

    void them() {
        try {
            BusVoucherModel model = getEntiti();

            daovc.Update_NgayBD_Ngaykt(model);
//                    System.out.println("hihi");

            filltb();

            MessageService.alert(this, "Chương trình đã được Sửa");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
            MessageService.alert(this, "ERRON!");
        }

    }

    boolean checkthemsalehoadon() {
        if (chekrong() == false) {
            return false;
        } else if (chekngay() == false) {
            return false;
        } else if (chekmucGG() == false) {
            return false;
        } else if (chektrung() == false) {
            return false;
        } else if (txtgiatridonhangtoiitheu.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống giá trị đơn hàng tối thiểu");
            txtgiatridonhangtoiitheu.requestFocus();
            return false;
        }
        return true;
    }

    boolean cheksuasalehoadon() {
        if (chekrong() == false) {
            return false;
        } else if (chekmucGG() == false) {
            return false;
        } else if (txtgiatridonhangtoiitheu.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống giá trị đơn hàng tối thiểu");
            txtgiatridonhangtoiitheu.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaVC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenChuongTrinh = new javax.swing.JTextField();
        txtTienTe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMucGG = new javax.swing.JTextField();
        cbbLoaiGG = new javax.swing.JComboBox<>();
        btndanang = new javax.swing.JButton();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        cbbloaima = new javax.swing.JComboBox<>();
        lblgiatridonhangtoithieu = new javax.swing.JLabel();
        txtgiatridonhangtoiitheu = new javax.swing.JTextField();
        txtdonvidonhangtoiithieu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bang = new javax.swing.JScrollPane();
        tblSanPhamSAle = new javax.swing.JTable();
        HangDT = new javax.swing.JLabel();
        cbbhangdt = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbTimSP = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnchontatcasanpham = new javax.swing.JButton();
        btnchonlaisanpham = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btndn2 = new javax.swing.JButton();
        txtSAnphamdcapdung = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtap = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbangtatca = new javax.swing.JTable();
        tab2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblbangđangienra = new javax.swing.JTable();
        tab3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblbangsapdienra = new javax.swing.JTable();
        tab4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblbangdaketthuc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1870, 1030));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaVC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaVC.setForeground(new java.awt.Color(25, 29, 74));
        txtMaVC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        jPanel1.add(txtMaVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, 30));

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Loại Giảm Giá:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Loại Mã");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, -1, -1));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Tên CT giảm giá");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtTenChuongTrinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenChuongTrinh.setForeground(new java.awt.Color(25, 29, 74));
        txtTenChuongTrinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        jPanel1.add(txtTenChuongTrinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 280, 30));

        txtTienTe.setBackground(java.awt.Color.white);
        txtTienTe.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTienTe.setForeground(new java.awt.Color(5, 10, 46));
        txtTienTe.setText("VNĐ");
        jPanel1.add(txtTienTe, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Mã Voucher:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 10, 46));
        jLabel8.setText("Từ Ngày:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 10, 46));
        jLabel9.setText("Đến Ngày:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 10, 46));
        jLabel7.setText("Mức Giảm Giá:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txtMucGG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMucGG.setForeground(new java.awt.Color(25, 29, 74));
        txtMucGG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        jPanel1.add(txtMucGG, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 170, 30));

        cbbLoaiGG.setBackground(new java.awt.Color(240, 240, 240));
        cbbLoaiGG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbLoaiGG.setForeground(new java.awt.Color(25, 29, 74));
        cbbLoaiGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm Giá Theo Số Tiền", "Giảm Giá Theo Phần Trăm" }));
        cbbLoaiGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiGGActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLoaiGG, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 170, 30));

        btndanang.setBackground(new java.awt.Color(25, 29, 74));
        btndanang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndanang.setForeground(new java.awt.Color(255, 255, 255));
        btndanang.setText("Kết Thúc Chương Trình Này");
        btndanang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 15));
        btndanang.setBorderPainted(false);
        btndanang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndanang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndanangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndanangMouseExited(evt);
            }
        });
        btndanang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndanangActionPerformed(evt);
            }
        });
        jPanel1.add(btndanang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 200, 40));

        txtNgayBD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtNgayBD.setForeground(new java.awt.Color(25, 29, 74));
        txtNgayBD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtNgayBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, 30));

        txtNgayKT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtNgayKT.setForeground(new java.awt.Color(25, 29, 74));
        txtNgayKT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtNgayKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 164, 30));

        cbbloaima.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbloaima.setForeground(new java.awt.Color(25, 29, 74));
        cbbloaima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá toàn shop", "Giảm giá theo từng sản phẩm", "Giảm giá theo hóa đơn" }));
        cbbloaima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbloaimaActionPerformed(evt);
            }
        });
        jPanel1.add(cbbloaima, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 13, 280, 30));

        lblgiatridonhangtoithieu.setBackground(java.awt.Color.white);
        lblgiatridonhangtoithieu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblgiatridonhangtoithieu.setForeground(new java.awt.Color(5, 10, 46));
        lblgiatridonhangtoithieu.setText("Giá Trị Đơn Hàng Tối Thiểu:");
        jPanel1.add(lblgiatridonhangtoithieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        txtgiatridonhangtoiitheu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        jPanel1.add(txtgiatridonhangtoiitheu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 223, 30));

        txtdonvidonhangtoiithieu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtdonvidonhangtoiithieu.setForeground(new java.awt.Color(5, 10, 46));
        txtdonvidonhangtoiithieu.setText("VNĐ");
        jPanel1.add(txtdonvidonhangtoiithieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 210, 580, 310));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSanPhamSAle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSanPhamSAle.setForeground(new java.awt.Color(25, 29, 74));
        tblSanPhamSAle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPhamSAle.setGridColor(new java.awt.Color(25, 29, 74));
        tblSanPhamSAle.setRowHeight(25);
        tblSanPhamSAle.getTableHeader().setReorderingAllowed(false);
        tblSanPhamSAle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamSAleMouseClicked(evt);
            }
        });
        bang.setViewportView(tblSanPhamSAle);
        if (tblSanPhamSAle.getColumnModel().getColumnCount() > 0) {
            tblSanPhamSAle.getColumnModel().getColumn(0).setMinWidth(0);
            tblSanPhamSAle.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSanPhamSAle.getColumnModel().getColumn(2).setMinWidth(50);
            tblSanPhamSAle.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jPanel2.add(bang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 540, 240));

        HangDT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        HangDT.setForeground(new java.awt.Color(5, 10, 46));
        HangDT.setText("Hãng sp");
        jPanel2.add(HangDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        cbbhangdt.setBackground(new java.awt.Color(240, 240, 240));
        cbbhangdt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbhangdt.setForeground(new java.awt.Color(25, 29, 74));
        cbbhangdt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbhangdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbhangdtActionPerformed(evt);
            }
        });
        jPanel2.add(cbbhangdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(5, 10, 46));
        jLabel11.setText("Tìm");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        cbbTimSP.setBackground(new java.awt.Color(240, 240, 240));
        cbbTimSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbTimSP.setForeground(new java.awt.Color(25, 29, 74));
        cbbTimSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tên Sản Phẩm", "Theo Mã Sản Phẩm" }));
        cbbTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimSPActionPerformed(evt);
            }
        });
        jPanel2.add(cbbTimSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 161, 30));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        jPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 310, 30));

        btnchontatcasanpham.setBackground(new java.awt.Color(25, 29, 74));
        btnchontatcasanpham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnchontatcasanpham.setForeground(new java.awt.Color(255, 255, 255));
        btnchontatcasanpham.setText("Chọn Tất Cả Sản Phẩm Của Hãng");
        btnchontatcasanpham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 15));
        btnchontatcasanpham.setBorderPainted(false);
        btnchontatcasanpham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnchontatcasanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnchontatcasanphamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnchontatcasanphamMouseExited(evt);
            }
        });
        btnchontatcasanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchontatcasanphamActionPerformed(evt);
            }
        });
        jPanel2.add(btnchontatcasanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, 30));

        btnchonlaisanpham.setBackground(new java.awt.Color(25, 29, 74));
        btnchonlaisanpham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnchonlaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btnchonlaisanpham.setText("Chọn Lại Sản Phẩm Sale");
        btnchonlaisanpham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 15));
        btnchonlaisanpham.setBorderPainted(false);
        btnchonlaisanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnchonlaisanphamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnchonlaisanphamMouseExited(evt);
            }
        });
        btnchonlaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonlaisanphamActionPerformed(evt);
            }
        });
        jPanel2.add(btnchonlaisanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 200, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 550, 360));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(25, 29, 74));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnThem.setBorderPainted(false);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMouseExited(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(25, 29, 74));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnMoi.setBorderPainted(false);
        btnMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMoiMouseExited(evt);
            }
        });
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(25, 29, 74));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnSua.setBorderPainted(false);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuaMouseExited(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btndn2.setBackground(new java.awt.Color(25, 29, 74));
        btndn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/versatile.png"))); // NOI18N
        btndn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btndn2.setBorderPainted(false);
        btndn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndn2MouseExited(evt);
            }
        });
        btndn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btndn2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndn2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 408, -1, -1));

        txtSAnphamdcapdung.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSAnphamdcapdung.setForeground(new java.awt.Color(5, 10, 46));
        txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");
        jPanel3.add(txtSAnphamdcapdung, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(5, 10, 46));
        jLabel12.setText("Sản Phẩm Được Áp Dụng:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 500, -1, -1));

        jtap.setForeground(new java.awt.Color(102, 0, 102));
        jtap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tab1.setBackground(new java.awt.Color(255, 255, 255));

        tblbangtatca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblbangtatca.setForeground(new java.awt.Color(25, 29, 74));
        tblbangtatca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến Mại", "Loại Mã", "Tên Mã", "Mã Voucher", "Giảm Giá", "Trạng Thái", "Thời Gian Diễn Ra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbangtatca.setGridColor(new java.awt.Color(25, 29, 74));
        tblbangtatca.setRowHeight(30);
        tblbangtatca.getTableHeader().setReorderingAllowed(false);
        tblbangtatca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangtatcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbangtatca);
        if (tblbangtatca.getColumnModel().getColumnCount() > 0) {
            tblbangtatca.getColumnModel().getColumn(0).setMinWidth(0);
            tblbangtatca.getColumnModel().getColumn(0).setMaxWidth(0);
            tblbangtatca.getColumnModel().getColumn(1).setMinWidth(200);
            tblbangtatca.getColumnModel().getColumn(1).setMaxWidth(200);
            tblbangtatca.getColumnModel().getColumn(3).setMinWidth(120);
            tblbangtatca.getColumnModel().getColumn(3).setMaxWidth(120);
            tblbangtatca.getColumnModel().getColumn(4).setMinWidth(120);
            tblbangtatca.getColumnModel().getColumn(4).setMaxWidth(120);
            tblbangtatca.getColumnModel().getColumn(5).setMinWidth(120);
            tblbangtatca.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtap.addTab("Tất Cả", tab1);

        tab2.setBackground(new java.awt.Color(255, 255, 255));

        tblbangđangienra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblbangđangienra.setForeground(new java.awt.Color(25, 29, 74));
        tblbangđangienra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến Mại", "Loại Mã", "Tên Mã", "Mã Voucher", "Giảm Giá", "Trạng Thái", "Thời Gian Diễn Ra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbangđangienra.setGridColor(new java.awt.Color(25, 29, 74));
        tblbangđangienra.setRowHeight(30);
        tblbangđangienra.getTableHeader().setReorderingAllowed(false);
        tblbangđangienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangđangienraMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblbangđangienra);
        if (tblbangđangienra.getColumnModel().getColumnCount() > 0) {
            tblbangđangienra.getColumnModel().getColumn(0).setMinWidth(0);
            tblbangđangienra.getColumnModel().getColumn(0).setMaxWidth(0);
            tblbangđangienra.getColumnModel().getColumn(3).setMinWidth(120);
            tblbangđangienra.getColumnModel().getColumn(3).setMaxWidth(120);
            tblbangđangienra.getColumnModel().getColumn(4).setMinWidth(150);
            tblbangđangienra.getColumnModel().getColumn(4).setMaxWidth(150);
            tblbangđangienra.getColumnModel().getColumn(5).setMinWidth(150);
            tblbangđangienra.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtap.addTab("Đang Diễn RA", tab2);

        tab3.setBackground(new java.awt.Color(255, 255, 255));

        tblbangsapdienra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblbangsapdienra.setForeground(new java.awt.Color(25, 29, 74));
        tblbangsapdienra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến Mại", "Loại Mã", "Tên Mã", "Mã Voucher", "Giảm Giá", "Trạng Thái", "Thời Gian Diễn Ra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbangsapdienra.setGridColor(new java.awt.Color(25, 29, 74));
        tblbangsapdienra.setRowHeight(30);
        tblbangsapdienra.getTableHeader().setReorderingAllowed(false);
        tblbangsapdienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangsapdienraMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblbangsapdienra);
        if (tblbangsapdienra.getColumnModel().getColumnCount() > 0) {
            tblbangsapdienra.getColumnModel().getColumn(0).setMinWidth(0);
            tblbangsapdienra.getColumnModel().getColumn(0).setMaxWidth(0);
            tblbangsapdienra.getColumnModel().getColumn(3).setMinWidth(120);
            tblbangsapdienra.getColumnModel().getColumn(3).setMaxWidth(120);
            tblbangsapdienra.getColumnModel().getColumn(4).setMinWidth(120);
            tblbangsapdienra.getColumnModel().getColumn(4).setMaxWidth(120);
            tblbangsapdienra.getColumnModel().getColumn(5).setMinWidth(120);
            tblbangsapdienra.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jtap.addTab("Sắp Diễn Ra", tab3);

        tab4.setBackground(new java.awt.Color(255, 255, 255));

        tblbangdaketthuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblbangdaketthuc.setForeground(new java.awt.Color(25, 29, 74));
        tblbangdaketthuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến Mại", "Loại Mã", "Tên Mã", "Mã Voucher", "Giảm Giá", "Trạng Thái", "Thời Gian Diễn Ra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbangdaketthuc.setGridColor(new java.awt.Color(25, 29, 74));
        tblbangdaketthuc.setRowHeight(30);
        tblbangdaketthuc.getTableHeader().setReorderingAllowed(false);
        tblbangdaketthuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangdaketthucMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblbangdaketthuc);
        if (tblbangdaketthuc.getColumnModel().getColumnCount() > 0) {
            tblbangdaketthuc.getColumnModel().getColumn(0).setMinWidth(0);
            tblbangdaketthuc.getColumnModel().getColumn(0).setMaxWidth(0);
            tblbangdaketthuc.getColumnModel().getColumn(3).setMinWidth(120);
            tblbangdaketthuc.getColumnModel().getColumn(3).setMaxWidth(120);
            tblbangdaketthuc.getColumnModel().getColumn(4).setMinWidth(120);
            tblbangdaketthuc.getColumnModel().getColumn(4).setMaxWidth(120);
            tblbangdaketthuc.getColumnModel().getColumn(5).setMinWidth(120);
            tblbangdaketthuc.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtap.addTab("Đã Kết Thúc", tab4);

        getContentPane().add(jtap, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 196, 1040, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Danh Sách Mã Giảm Giá");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 143, -1, 27));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(5, 10, 46));
        jLabel10.setText("Tạo Mã giảm giá toàn shop hoặc Mã giảm giá sản phẩm ngay bây giờ để thu hút người mua.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, -1, -1));

        jPanel4.setBackground(new java.awt.Color(25, 29, 74));
        jPanel4.setPreferredSize(new java.awt.Dimension(1870, 100));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Giảm giá");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 114));

        setBounds(0, 0, 1870, 1030);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiGGActionPerformed
        // TODO add your handling code here:
        if (cbbLoaiGG.getSelectedIndex() == 0) {
            txtTienTe.setText("VNĐ");
        } else
            txtTienTe.setText("%");
    }//GEN-LAST:event_cbbLoaiGGActionPerformed

    private void btndanangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndanangActionPerformed
        // TODO add your handling code here:Dừng chương trình này Cho chương trình sale luôn Khôi phục lại trương trình sale
        if (btndanang.getText().equals("Dừng chương trình này")) {
            dungchuongtrinhnay();
        } else if (btndanang.getText().equals("Cho chương trình sale luôn")) {
            chochuongtrinhsleluon();
        } else if (btndanang.getText().equals("Khôi phục lại trương trình sale")) {
            khoiphuclaitruongtrinh();
        } else if (btndanang.getText().equals("Khôi Phục")) {

            khoiphuc();
        }
    }//GEN-LAST:event_btndanangActionPerformed

    private void tblSanPhamSAleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamSAleMouseClicked
        // TODO add your handling code here:
        demspsale();
    }//GEN-LAST:event_tblSanPhamSAleMouseClicked

    private void cbbhangdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbhangdtActionPerformed
        // TODO add your handling code here:
        filltableByHang();
    }//GEN-LAST:event_cbbhangdtActionPerformed

    private void cbbTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimSPActionPerformed

    private void btnchontatcasanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchontatcasanphamActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
            tblSanPhamSAle.setValueAt(true, i, 2);

        }
        txtSAnphamdcapdung.setText(tblSanPhamSAle.getRowCount() + " Sản phẩm được trọn");
    }//GEN-LAST:event_btnchontatcasanphamActionPerformed

    private void btnchonlaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonlaisanphamActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
            tblSanPhamSAle.setValueAt(false, i, 2);

        }
        txtSAnphamdcapdung.setText("0 Sản phẩm được trọn");
    }//GEN-LAST:event_btnchonlaisanphamActionPerformed

    private void tblbangtatcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangtatcaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            this.index = tblbangtatca.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                clicktable();
                this.loaima();
                this.filltabletoForm();
                this.sanphamdsale();
            }
        }
    }//GEN-LAST:event_tblbangtatcaMouseClicked

    private void tblbangđangienraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangđangienraMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            this.index = tblbangđangienra.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.filltabletoForm();
                this.loaima();
                this.clicktable();
                this.sanphamdsale();

            }
        }
    }//GEN-LAST:event_tblbangđangienraMouseClicked

    private void tblbangsapdienraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangsapdienraMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            this.index = tblbangsapdienra.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.filltabletoForm();
                this.loaima();
                this.clicktable();
                this.sanphamdsale();
//                sttCTtap2();
                //                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblbangsapdienraMouseClicked

    private void tblbangdaketthucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangdaketthucMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            this.index = tblbangdaketthuc.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.filltabletoForm();
                this.loaima();
                this.clicktable();
                this.sanphamdsale();
//                sttCTtap2();
                //                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblbangdaketthucMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (cbbloaima.getSelectedIndex() == 0 || cbbloaima.getSelectedIndex() == 1) {
            if (checkthem() == true) {
                try {
                    insertnew();
                    filltb();
                    MessageService.alert(this, "Thêm mới thành công!");
                    clear();
                } catch (Exception e) {
                    MessageService.alert(this, "Thêm mới thất bại!");
                    e.printStackTrace();
                }
            }
        } else if (cbbloaima.getSelectedIndex() == 2) {
            if (checkthemsalehoadon() == true) {
                try {
                    insertnew();
                    filltb();
                    MessageService.alert(this, "Thêm mới thành công!");
                    clear();
                } catch (Exception e) {
                    MessageService.alert(this, "Thêm mới thất bại!");
                    e.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        //        new TaoMoiMGG().setVisible(true);
        //        this.dispose();
        clear();

    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        //        insert()
        if (cbbloaima.getSelectedIndex() == 0 || cbbloaima.getSelectedIndex() == 1) {

            if (cheksua() == true) {
                update();

            }
        } else if (cbbloaima.getSelectedIndex() == 2) {
            if (cheksuasalehoadon() == true) {
                update();

            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btndn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndn2ActionPerformed
        // TODO add your handling code here:
        if (btndn2.getText().equals("Sửa ngày kết thúc")) {

            themngaysale();

        } else if (btndn2.getText().equals("Sửa")) {
            if (chekngay() == true) {
                them();

            }
        }
    }//GEN-LAST:event_btndn2ActionPerformed

    private void btndanangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndanangMouseEntered
        changeColor(btndanang, new Color(102, 0, 102));
    }//GEN-LAST:event_btndanangMouseEntered

    private void btndanangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndanangMouseExited
        changeColor(btndanang, new Color(25, 29, 74));
    }//GEN-LAST:event_btndanangMouseExited

    private void btnchontatcasanphamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchontatcasanphamMouseEntered
        changeColor(btnchontatcasanpham, new Color(102, 0, 102));
    }//GEN-LAST:event_btnchontatcasanphamMouseEntered

    private void btnchontatcasanphamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchontatcasanphamMouseExited
        changeColor(btnchontatcasanpham, new Color(25, 29, 74));
    }//GEN-LAST:event_btnchontatcasanphamMouseExited

    private void btnchonlaisanphamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchonlaisanphamMouseEntered
        changeColor(btnchonlaisanpham, new Color(102, 0, 102));
    }//GEN-LAST:event_btnchonlaisanphamMouseEntered

    private void btnchonlaisanphamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchonlaisanphamMouseExited
        changeColor(btnchonlaisanpham, new Color(25, 29, 74));
    }//GEN-LAST:event_btnchonlaisanphamMouseExited

    private void btndn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndn2MouseEntered
        changeColor(btndn2, new Color(102, 0, 102));
    }//GEN-LAST:event_btndn2MouseEntered

    private void btndn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndn2MouseExited
        changeColor(btndn2, new Color(25, 29, 74));
    }//GEN-LAST:event_btndn2MouseExited

    private void btnSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseEntered
        changeColor(btnSua, new Color(102, 0, 102));
    }//GEN-LAST:event_btnSuaMouseEntered

    private void btnSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseExited
        changeColor(btnSua, new Color(25, 29, 74));
    }//GEN-LAST:event_btnSuaMouseExited

    private void btnMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseEntered
        changeColor(btnMoi, new Color(102, 0, 102));
    }//GEN-LAST:event_btnMoiMouseEntered

    private void btnMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseExited
        changeColor(btnMoi, new Color(25, 29, 74));
    }//GEN-LAST:event_btnMoiMouseExited

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        changeColor(btnThem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        changeColor(btnThem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnThemMouseExited

    private void cbbloaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbloaimaActionPerformed
        // TODO add your handling code here:
        loaima();
    }//GEN-LAST:event_cbbloaimaActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        if (cbbTimSP.getSelectedIndex() == 0) {
            filltableByTen();
        } else
            filltableByMaSP();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HangDT;
    private javax.swing.JScrollPane bang;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnchonlaisanpham;
    private javax.swing.JButton btnchontatcasanpham;
    private javax.swing.JButton btndanang;
    private javax.swing.JButton btndn2;
    private javax.swing.JComboBox<String> cbbLoaiGG;
    private javax.swing.JComboBox<String> cbbTimSP;
    private javax.swing.JComboBox<String> cbbhangdt;
    private javax.swing.JComboBox<String> cbbloaima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jtap;
    private javax.swing.JLabel lblgiatridonhangtoithieu;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JTable tblSanPhamSAle;
    private javax.swing.JTable tblbangdaketthuc;
    private javax.swing.JTable tblbangsapdienra;
    private javax.swing.JTable tblbangtatca;
    private javax.swing.JTable tblbangđangienra;
    private javax.swing.JTextField txtMaVC;
    private javax.swing.JTextField txtMucGG;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JLabel txtSAnphamdcapdung;
    private javax.swing.JTextField txtTenChuongTrinh;
    private javax.swing.JLabel txtTienTe;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txtdonvidonhangtoiithieu;
    private javax.swing.JTextField txtgiatridonhangtoiitheu;
    // End of variables declaration//GEN-END:variables

    private void setModel(BusVoucherModel model) {
        cbbloaima.setSelectedIndex(model.getLoaikm());
        txtTenChuongTrinh.setText(model.getTenKM());
        txtMaVC.setText(model.getMaVC());
        cbbLoaiGG.setSelectedIndex(model.getLoaiGG());
        txtNgayBD.setDate(model.getNgayBD());
        txtNgayKT.setDate(model.getNgayKT());
        txtMucGG.setText(String.valueOf(model.getMucGG()));
        txtgiatridonhangtoiitheu.setText(String.valueOf(model.getDKKM()));
    }
}
