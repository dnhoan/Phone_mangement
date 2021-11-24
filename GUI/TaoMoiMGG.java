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
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 84349
 */
public class TaoMoiMGG extends javax.swing.JFrame {

    /**
     * Creates new form TaoMoiMGG
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

    public TaoMoiMGG() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillcbb();
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
        rdotoanshop.setSelected(true);
        txtTenChuongTrinh.setText("");
        txtMaVC.setText("");
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtMucGG.setText("");
        tblSanPhamSAle.setEnabled(true);
        btnchonlaisanpham.setEnabled(true);
        btnchontatcasanpham.setEnabled(true);
        cbbLoaiGG.setSelectedIndex(0);
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
                    vc.isLoaikm() ? "Toàn Shop" : "Từng sản phẩm",
                    vc.getTenKM(),
                    vc.getMaVC(),
                    vc.MucGGtable(),
                    vc.TrangThaitable(),
                    "từ " + vc.getNgayBD() + " đến " + vc.getNgayKT()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loaima() {
        if (rdotoanshop.isSelected()) {
            jPanel2.setVisible(false);
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);
            }
            txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");
        } else if (rdotuongsp.isSelected()) {
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
        entity.setLoaikm(rdotoanshop.isSelected());
        entity.setTenKM(txtTenChuongTrinh.getText());
        entity.setMaVC(txtMaVC.getText());
        entity.setLoaiGG(cbbLoaiGG.getSelectedIndex());
        entity.setNgayBD(txtNgayBD.getDate());
        entity.setNgayKT(txtNgayKT.getDate());
        entity.setMucGG(Integer.parseInt(txtMucGG.getText()));
        return entity;
    }

    private BusVoucherModel getEntiti() {
        BusVoucherModel entity = new BusVoucherModel();
        entity.setLoaikm(rdotoanshop.isSelected());
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
        return entity;
    }
    private void sttclear() {
        txtMaVC.setEnabled(true);
        rdotoanshop.setEnabled(true);
        rdotuongsp.setEnabled(true);
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
            if (rdotoanshop.isSelected()) {
                daovc.update(model);
            } else if (rdotuongsp.isSelected()) {
                daovc.update(model);
                daovc.deleteSPsale(model);
                int masp;
                for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                    if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                        masp = Integer.parseInt(tblSanPhamSAle.getValueAt(i, 0).toString());
                        daovc.insertsanphamdcsale(masp, makm());
                    }
                }
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
        try {
            int masp;
            daovc.insert(entity);
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                    masp = Integer.parseInt(tblSanPhamSAle.getValueAt(i, 0).toString());
                    System.out.println(masp);
                    daovc.insertspsale(masp);
                }
            }
        } catch (Exception e) {
        }
    }
    void demspsale() {
        if (rdotoanshop.isSelected()) {
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                tblSanPhamSAle.setValueAt(true, i, 2);

            }
            txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");
        } else if (rdotuongsp.isSelected()) {
            sospGG = 0;
            for (int i = 0; i < tblSanPhamSAle.getRowCount(); i++) {
                if (tblSanPhamSAle.getValueAt(i, 2).equals(true)) {
                    sospGG++;
                }
            }
            txtSAnphamdcapdung.setText(sospGG + " Sản phẩm được trọn");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gropvocher = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtMaVC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdotoanshop = new javax.swing.JRadioButton();
        rdotuongsp = new javax.swing.JRadioButton();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtTenChuongTrinh = new javax.swing.JTextField();
        txtTienTe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtMucGG = new javax.swing.JTextField();
        cbbLoaiGG = new javax.swing.JComboBox<>();
        btndanang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bang = new javax.swing.JScrollPane();
        tblSanPhamSAle = new javax.swing.JTable();
        HangDT = new javax.swing.JLabel();
        cbbhangdt = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbTimSP = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnchontatcasanpham = new javax.swing.JButton();
        btnchonlaisanpham = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtSAnphamdcapdung = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btndn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Thời Gian Diễn Ra:");

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Loại Giảm Giá:");

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Loại Mã");

        rdotoanshop.setBackground(java.awt.Color.white);
        gropvocher.add(rdotoanshop);
        rdotoanshop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdotoanshop.setSelected(true);
        rdotoanshop.setText("Voucher Giảm Toàn Shop");
        rdotoanshop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdotoanshopMouseClicked(evt);
            }
        });

        rdotuongsp.setBackground(java.awt.Color.white);
        gropvocher.add(rdotuongsp);
        rdotuongsp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdotuongsp.setText("Voucher Giảm Theo Sản Phẩm");
        rdotuongsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdotuongspMouseClicked(evt);
            }
        });

        txtNgayBD.setBackground(java.awt.Color.white);

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên Chương Trình Giảm Giá:");

        txtTienTe.setBackground(java.awt.Color.white);
        txtTienTe.setText("VNĐ");

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mã Voucher:");

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Từ Ngày:");

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Đến Ngày:");

        txtNgayKT.setBackground(java.awt.Color.white);

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Mức Giảm Giá");

        cbbLoaiGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm Giá Theo Số Tiền", "Giảm Giá Theo Phần Trăm" }));
        cbbLoaiGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiGGActionPerformed(evt);
            }
        });

        btndanang.setText("Kết Thúc Chương Trình Này");
        btndanang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndanangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btndanang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(rdotoanshop)
                                .addGap(18, 18, 18)
                                .addComponent(rdotuongsp))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbbLoaiGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtMucGG, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienTe))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdotoanshop)
                    .addComponent(rdotuongsp))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(cbbLoaiGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMucGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienTe)
                    .addComponent(btndanang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbLoaiGG, txtMaVC, txtMucGG, txtNgayBD, txtNgayKT, txtTenChuongTrinh});

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
        tblSanPhamSAle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamSAleMouseClicked(evt);
            }
        });
        bang.setViewportView(tblSanPhamSAle);

        HangDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HangDT.setText("Hãng Điện Thoại");

        cbbhangdt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbhangdt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbhangdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbhangdtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Tìm");

        cbbTimSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbTimSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tên Sản Phẩm", "Theo Mã Sản Phẩm" }));
        cbbTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimSPActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnchontatcasanpham.setText("Chọn Tất Cả Sản Phẩm Của Hãng");
        btnchontatcasanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchontatcasanphamActionPerformed(evt);
            }
        });

        btnchonlaisanpham.setText("Chọn Lại Sản Phẩm Sale");
        btnchonlaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonlaisanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bang, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(HangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbhangdt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnchontatcasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnchonlaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbhangdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HangDT))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchontatcasanpham)
                    .addComponent(btnchonlaisanpham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bang, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        jLabel12.setText("Sản Phẩm Được Áp Dụng:");

        txtSAnphamdcapdung.setText("Tất Cả Sản Phẩm Trong Shop");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSAnphamdcapdung)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSAnphamdcapdung)))
        );

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
        tblbangtatca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangtatcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbangtatca);

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtap.addTab("Tất Cả", tab1);

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
        tblbangđangienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangđangienraMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblbangđangienra);

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtap.addTab("Đang Diễn RA", tab2);

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
        tblbangsapdienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangsapdienraMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblbangsapdienra);

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jtap.addTab("Sắp Diễn Ra", tab3);

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
        tblbangdaketthuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangdaketthucMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblbangdaketthuc);

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
            .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jtap.addTab("Đã Kết Thúc", tab4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Danh Sách Mã Giảm Giá");

        jLabel10.setText("Tạo Mã giảm giá toàn shop hoặc Mã giảm giá sản phẩm ngay bây giờ để thu hút người mua.");

        btnThem.setText("Thêm Mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnMoi.setText("Tạo Mới dữ liệu");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSua.setText("Cập Nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btndn2.setText("dnanang2");
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
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(btndn2)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(31, 31, 31)
                .addComponent(btnMoi)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnMoi)
                    .addComponent(btnSua)
                    .addComponent(btndn2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtap)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtap, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiGGActionPerformed
        // TODO add your handling code here:
        if (cbbLoaiGG.getSelectedIndex() == 0) {
            txtTienTe.setText("VNĐ");
        } else
            txtTienTe.setText("%");
    }//GEN-LAST:event_cbbLoaiGGActionPerformed

    private void rdotoanshopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdotoanshopMouseClicked
        // TODO add your handling code here:

        loaima();
    }//GEN-LAST:event_rdotoanshopMouseClicked

    private void rdotuongspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdotuongspMouseClicked
        // TODO add your handling code here:
        loaima();

    }//GEN-LAST:event_rdotuongspMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
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

    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbhangdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbhangdtActionPerformed
        // TODO add your handling code here:
        filltableByHang();
    }//GEN-LAST:event_cbbhangdtActionPerformed

    private void tblSanPhamSAleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamSAleMouseClicked
        // TODO add your handling code here:
        demspsale();
    }//GEN-LAST:event_tblSanPhamSAleMouseClicked

    private void cbbTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimSPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (cbbTimSP.getSelectedIndex() == 0) {
            filltableByTen();
        } else
            filltableByMaSP();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                this.filltabletoForm();
                this.loaima();
                clicktable();
                this.sanphamdsale();

//                sttCTtap2();
                //                tabs.setSelectedIndex(0);
            }
        }
        int dong;
//        dong = tblbangtatca.getSelectedRow();
//        System.out.println(Integer.parseInt(tblbangtatca.getValueAt(tblbangtatca.getSelectedRow(), 0).toString()));
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
//                sttCTtap2();
                //                tabs.setSelectedIndex(0);
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

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
//        new TaoMoiMGG().setVisible(true);
//        this.dispose();
        clear();


    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
//        insert()
        if (cheksua() == true) {
            update();

        }


    }//GEN-LAST:event_btnSuaActionPerformed
    
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
    
    private void btndn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndn2ActionPerformed
        // TODO add your handling code here:
         if (btndn2.getText().equals("Sửa ngày kết thúc")) {
             
            themngaysale();

        } else if (btndn2.getText().equals("Sửa")) {
            if (chekngay()==true) {
              them();

             }
        }
    }//GEN-LAST:event_btndn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaoMoiMGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoMoiMGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoMoiMGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoMoiMGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoMoiMGG().setVisible(true);
            }
        });
    }

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
    private javax.swing.ButtonGroup gropvocher;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jtap;
    private javax.swing.JRadioButton rdotoanshop;
    private javax.swing.JRadioButton rdotuongsp;
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
    // End of variables declaration//GEN-END:variables

    private void setModel(BusVoucherModel model) {
        rdotoanshop.setSelected(model.isLoaikm());
        rdotuongsp.setSelected(!model.isLoaikm());
        txtTenChuongTrinh.setText(model.getTenKM());
        txtMaVC.setText(model.getMaVC());
        cbbLoaiGG.setSelectedIndex(model.getLoaiGG());
        txtNgayBD.setDate(model.getNgayBD());
        txtNgayKT.setDate(model.getNgayKT());
        txtMucGG.setText(String.valueOf(model.getMucGG()));
    }
}
