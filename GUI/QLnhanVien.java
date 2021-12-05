/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Services.NhanVienService;
import DAL.Models.NhanVienModel;
import GUI.Services.DateService;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84349
 */
public class QLnhanVien extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLnhanVien
     */
    NhanVienService nvdao = new NhanVienService();
    int today = LocalDate.now().getYear();
    int lastday;
    int j = 0;
    LocalDate dateNgay = LocalDate.now();
    int index = 0;
    Date d;

    public QLnhanVien() {
        System.out.println("chay nhan vien");
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimen = t.getScreenSize();
        int h = dimen.height;
        int w = dimen.width;
        this.setSize(w, h);
        filltableNVON();
        filltableNVOFF();
        desginTable();
//        System.out.println(tblDSNVON.getRowCount());

        try {
            //        System.out.println(today);
//        lastday=LocalDate.parse(txtNgayBD.getText()).getYear();
//        System.out.println(lastday);
//        Date date=jDateChooser1.getDate();
//        txtNgayBD.setDate(DateService.addDays(date,today ));
//        System.out.println(date);
            d = new SimpleDateFormat("yyyy-MM-dd").parse(dateNgay.toString());
            txtNgaySinh.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(QLnhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desginTable() {
        tblDSNVON.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblDSNVON.getTableHeader().setOpaque(false);
        tblDSNVON.getTableHeader().setBackground(new Color(25, 29, 74));
        tblDSNVON.getTableHeader().setForeground(Color.WHITE);
        tblDSNVOFF.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblDSNVON.getTableHeader().setDraggedColumn(null);
        tblDSNVOFF.getTableHeader().setOpaque(false);
        tblDSNVOFF.getTableHeader().setBackground(new Color(25, 29, 74));
        tblDSNVOFF.getTableHeader().setForeground(Color.WHITE);
    }

    private void filltableNVON() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVON.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectAllON();
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getNgaySinh(),
                    nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(),
                    nv.getGhiChu(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.getNgayBD()

                };
                model.addRow(row);

            }
            tblDSNVON.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
//            MessageService.alert(rootPane, "Bảng chưa có dữ liệu mời bạn nhập dữ liệu.");
            e.printStackTrace();
        }

    }

    private void filltableNVOFF() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVOFF.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectAllOFF();
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getDiaChi(),
                    nv.getNgayKT(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.NamLamViec()
                };

                model.addRow(row);
            }
//            if(model.getRowCount()<0){
//                
//            }
//            tblDSNVOFF.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    private boolean ChekTrung() {
        List<NhanVienModel> list = nvdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (txtMaNV.getText().equals(list.get(i).getMaNV())) {
                JOptionPane.showMessageDialog(this, "Đã có mã nhân viên " + txtMaNV.getText() + " .Mời bạn nhập mã khác.");
                txtMaNV.requestFocus();
                return false;
            }
        }
        return true;
    }

    private boolean chekrong() {
        String ngaysing;
        ngaysing = DateService.toString(txtNgaySinh.getDate(), "yyyy-MM-dd");
        if (txtMaNV.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Mã nhân viên mời bạn nhập Mã nhân viên");
            txtMaNV.requestFocus();
            return false;
        } else if (txtmatkhau.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Mật khẩu mời bạn nhập Mật khẩu");
            txtmatkhau.requestFocus();
            return false;
        } else if (!(txtChekMatKhau.getText().equals(txtmatkhau.getText()))) {
            MessageService.alert(rootPane, "Mật khẩu nhập lại không đúng với Mật khẩu mời bạn kiểm tra lại");
            txtMaNV.requestFocus();
            return false;
        } else if (txtDiaChi.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Địa chỉ mời bạn nhập Địa chỉ");
            txtDiaChi.requestFocus();
            return false;
        } //        else if(txtGhiChu.getText().equals("")){
        //            MessageService.alert(rootPane, "Không thể bỏ trống Ghi Chú mời bạn nhập Ghi chú");
        //            txtGhiChu.requestFocus();
        //            return false ;
        //        }
        else if (txtHoTen.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Họ tên mời bạn nhập Họ tên");
            txtHoTen.requestFocus();
            return false;
        } else if (txtemail.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống email mời bạn nhập email");
            txtemail.requestFocus();
            return false;

        } else if (ngaysing.length() == 0) {
            MessageService.alert(rootPane, "Không thể bỏ trống Ngày sinh mời bạn chọn ngày sinh");
            txtNgaySinh.requestFocus();
            return false;
        } else if (txtSDT.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Số điện thoại mời bạn nhập Số điện thoại");
            txtSDT.requestFocus();
            return false;
        } else if (imgAnh.getIcon() == null) {
            MessageService.alert(rootPane, "Không thể bỏ trống ảnh mời bạn click vào hình ảnh để chọn ảnh");
            return false;
        }
        return true;
    }

    private boolean valid() {
        if (txtMaNV.getText().length() < 3) {
            MessageService.alert(this, "Mã nhân viên phải có từ 3 kí tự trở lên");
            txtMaNV.requestFocus();
            return false;
        } else if (txtmatkhau.getText().length() < 6) {
            MessageService.alert(this, "Mật khẩu phải có từ 6 kí tự trở lên");
            txtmatkhau.requestFocus();
            return false;
        } else if (!(txtSDT.getText()).matches("[0-9]{10}")) {
            MessageService.alert(rootPane, "Số điện thoại phải nhập đúng 10 số");
            txtSDT.requestFocus();
            return false;
        } else if (!(txtemail.getText()).matches("^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng email", "Error", 1);
            txtemail.requestFocus();
            return false;
        } else if (!(txtNgayBD.getText()).matches("^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày sinh \nĐịnh dạng năm-tháng-ngày(năm từ 19xx-20xx)", "Error", 1);
            txtemail.requestFocus();
            return false;
        }
        return true;
    }

    public void update() {
        NhanVienModel model = getEntity();
        String confirm = new String(txtChekMatKhau.getPassword());
        if (!confirm.equals(model.getMatKhau())) {
            MessageService.alert(this, "xác nhận mật khẩu không đúng");
        } else {
            try {
                nvdao.update(model);
                filltableNVON();
                filltableNVOFF();
                MessageService.alert(this, "Cập nhập Thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Cập nhập thất bại!");
            }
        }
    }
    String imageName;

    public void ResizeImage(String imageName) {
        ImageIcon icon = new ImageIcon("src\\image\\" + imageName);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(imgAnh.getWidth(), imgAnh.getHeight(), image.SCALE_SMOOTH));
        imgAnh.setIcon(icon1);

    }
    int hi = -1;

    private void KhoiPhuc() {
        if (MessageService.confirm(rootPane, "Bạn chắc chắn khôi phục chứ ???")) {
            String maNV = (String) tblDSNVOFF.getValueAt(j, 0);
            try {
                nvdao.KhoiPhuc(maNV);
                nvdao.Ngaynghi("", maNV);
                this.filltableNVON();
                this.filltableNVOFF();
//                this.clear();
                MessageService.alert(this, "Khôi phục thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Khôi phục Thất bại!");
            }
        }
    }

    private NhanVienModel getEntity() {
        NhanVienModel entity = new NhanVienModel();
        entity.setMaNV(txtMaNV.getText());
        entity.setMatKhau(txtmatkhau.getText());
        entity.setHoTen(txtHoTen.getText());
        entity.setSDT(txtSDT.getText());
        entity.setGioiTinh(rdoGTNam.isSelected());
        entity.setNgaySinh(txtNgaySinh.getDate());
        entity.setDiaChi(txtDiaChi.getText());
        entity.setVaiTro(rdoVTruongPhong.isSelected());
        entity.setGhiChu(txtGhiChu.getText());
        entity.setHinh(imgAnh.getToolTipText());
        entity.setNgayBD(DateService.toDate(txtNgayBD.getText(), "yyyy-MM-dd"));
        entity.setEmail(txtemail.getText());
        return entity;
    }

    private void clear() {
        try {

            txtChekMatKhau.setText("");
            txtDiaChi.setText("");
            txtGhiChu.setText("");
            txtHoTen.setText("");
            txtMaNV.setText("");
            txtNgayBD.setText("");
            txtNgaySinh.setDate(d);
            txtSDT.setText("");
            txtemail.setText("");
            txtmatkhau.setText("");
            rdoGTNam.setSelected(true);
            rdoVTruongPhong.setSelected(true);
            imgAnh.setIcon(null);
            sttCTtap3();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sttOff() {
        lblNgaybatdau.setText("Năm làm việc");
        txtMaNV.setFocusable(false);
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    private void sttCTtap3() {
        lblNgaybatdau.setText("Ngày bắt đầu");
        txtMaNV.setFocusable(true);
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void sttCTtap2() {
        lblNgaybatdau.setText("Ngày bắt đầu");
        txtMaNV.setFocusable(false);
        btnThem.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void edit() {
        try {
            String manv = (String) tblDSNVON.getValueAt(this.index, 0);
            NhanVienModel model = nvdao.selectByID(manv);
            if (model != null) {
                this.setModel(model);
            }
        } catch (Exception a) {
            MessageService.alert(this, "lỗi truy vấn dữ liệu!");
            a.printStackTrace();
        }
    }

    private void edit1() {
        try {
            String manv = (String) tblDSNVOFF.getValueAt(this.j, 0);
            NhanVienModel model = nvdao.selectByID(manv);
            if (model != null) {
                this.setModel(model);
//                this.setStatus(false);
            }
        } catch (Exception a) {
            MessageService.alert(this, "lỗi truy vấn dữ liệu!");
            a.printStackTrace();
        }
    }

    private void setModel(NhanVienModel model) {

        txtMaNV.setText(model.getMaNV());
        txtHoTen.setText(model.getHoTen());
        txtmatkhau.setText(model.getMatKhau());
        txtChekMatKhau.setText(model.getMatKhau());
        rdoVTruongPhong.setSelected(model.isVaiTro());
        rdoVTNhanVien.setSelected(!model.isVaiTro());
        rdoGTNam.setSelected(model.isGioiTinh());
        rdoGTNu.setSelected(!model.isGioiTinh());
        txtNgaySinh.setDate(model.getNgaySinh());
        txtSDT.setText(model.getSDT());
        txtemail.setText(model.getEmail());
        txtDiaChi.setText(model.getDiaChi());
        txtNgayBD.setText(model.getNgayBD() + "");
        imgAnh.setToolTipText(model.getHinh());
        if (model.getHinh() != null) {
            imgAnh.setIcon(ImageService.readLogo(model.getHinh()));
        }
        txtGhiChu.setText(model.getGhiChu());
//        setMaNV(txtMaNV.getText());
//        setMatKhau(txtmatkhau.getText());
//        entity.setHoTen(txtHoTen.getText());
//        entity.setSDT(txtSDT.getText());
//        entity.setGioiTinh(rdoGTNam.isSelected());
//        entity.setNgaySinh(txtNgaySinh.getDate());
//        entity.setDiaChi(txtDiaChi.getText());
//        entity.setVaiTro(rdoVTruongPhong.isSelected());
//        entity.setGhiChu(txtGhiChu.getText());
//         entity.setHinh(imgAnh.getToolTipText());
//        entity.setNgayBD(DateService.toDate(txtNgayBD.getText(), "yyyy-MM-dd"));
//        entity.setEmail(txtemail.getText());
    }
//    private void capnhapngatnghi(){
//        try {
//            nvdao.Ngaynghi(e);
//            
//        } catch (Exception e) {
//        }
//    }

    private void xoa() {

        if (MessageService.confirm(rootPane, "Bạn chắc chắn muốn xóa chứ ???")) {
            String maNV = (String) tblDSNVON.getValueAt(hi, 0);
            try {

                nvdao.delete(maNV);
                nvdao.Ngaynghi(dateNgay.toString(), maNV);
                this.filltableNVON();
                this.filltableNVOFF();
                this.clear();
                MessageService.alert(this, "Xóa thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Xóa Thất bại!");
            }
        }

    }

    private void xoatrenForm() {
        if (MessageService.confirm(rootPane, "Bạn chắc chắn muốn xóa chứ ???")) {
            String maNV = txtMaNV.getText();
            try {
                nvdao.delete(maNV);
                nvdao.Ngaynghi(dateNgay.toString(), maNV);
                this.filltableNVON();
                this.filltableNVOFF();
                this.clear();
                MessageService.alert(this, "Xóa thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Xóa Thất bại!");
            }
        }

    }

    private void timNhanVienON() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVON.getModel();
        model.setRowCount(0);
        try {
            List<NhanVienModel> list = nvdao.selectByKeywordON(txtTimKiemON.getText());
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getNgaySinh(),
                    nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(),
                    nv.getGhiChu(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.getNgayBD()

                };
                model.addRow(row);

            }
            tblDSNVON.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    private void timNhanVienOFF() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVOFF.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectByKeywordOFF(txtTimKiemOFF.getText());
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getDiaChi(),
                    nv.getNgayKT(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.NamLamViec()
                };

                model.addRow(row);
            }
            tblDSNVOFF.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNVON = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiemON = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSNVOFF = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiemOFF = new javax.swing.JTextField();
        btnTimKiem2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoVTruongPhong = new javax.swing.JRadioButton();
        rdoVTNhanVien = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        txtmatkhau = new javax.swing.JPasswordField();
        txtChekMatKhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        rdoGTNam = new javax.swing.JRadioButton();
        rdoGTNu = new javax.swing.JRadioButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        lblNgaybatdau = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        imgAnh = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDiemDanh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1870, 1002));

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setForeground(new java.awt.Color(102, 0, 102));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblDSNVON.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblDSNVON.setForeground(new java.awt.Color(25, 29, 74));
        tblDSNVON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ và tên", "SDT", "Email", "Ngày sinh", "Giới tính", "Địa chỉ", "Ghi chú", "Vai trò", "Ngày bắt đầu làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNVON.setGridColor(new java.awt.Color(25, 29, 74));
        tblDSNVON.setRowHeight(30);
        tblDSNVON.setRowMargin(0);
        tblDSNVON.getTableHeader().setReorderingAllowed(false);
        tblDSNVON.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDSNVONAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDSNVON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVONMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNVON);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(5, 10, 46));
        jLabel13.setText("Tìm Kiếm:");

        txtTimKiemON.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTimKiemON.setForeground(new java.awt.Color(25, 29, 74));
        txtTimKiemON.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtTimKiemON.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnTimKiem.setBackground(new java.awt.Color(25, 29, 74));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search1.png"))); // NOI18N
        btnTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseExited(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(25, 29, 74));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fast-backward.png"))); // NOI18N
        btnPrev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnPrev.setBorderPainted(false);
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrev.setPreferredSize(new java.awt.Dimension(86, 41));
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevMouseExited(evt);
            }
        });
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(25, 29, 74));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/step-backward.png"))); // NOI18N
        btnFirst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnFirst.setBorderPainted(false);
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.setPreferredSize(new java.awt.Dimension(86, 41));
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstMouseExited(evt);
            }
        });
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(25, 29, 74));
        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fast-forward.png"))); // NOI18N
        btnnext.setToolTipText("");
        btnnext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnnext.setBorderPainted(false);
        btnnext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnext.setPreferredSize(new java.awt.Dimension(86, 41));
        btnnext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnextMouseExited(evt);
            }
        });
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(25, 29, 74));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/step-forward.png"))); // NOI18N
        btnLast.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnLast.setBorderPainted(false);
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.setPreferredSize(new java.awt.Dimension(86, 41));
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastMouseExited(evt);
            }
        });
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(jLabel13)
                            .addGap(10, 10, 10)
                            .addComponent(txtTimKiemON, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(156, 156, 156))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemON, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐANG LÀM VIỆC", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDSNVOFF.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblDSNVOFF.setForeground(new java.awt.Color(25, 29, 74));
        tblDSNVOFF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ và tên", "SDT", "Email", "Địa chỉ", "Ngày nghỉ", "Vai trò", "Số năm làm việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNVOFF.setGridColor(new java.awt.Color(25, 29, 74));
        tblDSNVOFF.setRowHeight(30);
        tblDSNVOFF.setRowMargin(0);
        tblDSNVOFF.getTableHeader().setReorderingAllowed(false);
        tblDSNVOFF.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDSNVOFFAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDSNVOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVOFFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblDSNVOFFMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSNVOFF);

        jButton3.setBackground(new java.awt.Color(25, 29, 74));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(5, 10, 46));
        jLabel15.setText("Tìm Kiếm:");

        txtTimKiemOFF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTimKiemOFF.setForeground(new java.awt.Color(25, 29, 74));
        txtTimKiemOFF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        btnTimKiem2.setBackground(new java.awt.Color(25, 29, 74));
        btnTimKiem2.setForeground(new java.awt.Color(25, 29, 74));
        btnTimKiem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search1.png"))); // NOI18N
        btnTimKiem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnTimKiem2.setBorderPainted(false);
        btnTimKiem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem2.setPreferredSize(new java.awt.Dimension(86, 41));
        btnTimKiem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTimKiem2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTimKiem2MouseExited(evt);
            }
        });
        btnTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐÃ NGHỈ VIÊC", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Mã nhân viên");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(25, 29, 74));
        txtMaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Họ và tên");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(25, 29, 74));
        txtHoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Vai trò");

        rdoVTruongPhong.setBackground(new java.awt.Color(255, 255, 255));
        rdoVTruongPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoVTruongPhong.setForeground(new java.awt.Color(25, 29, 74));
        rdoVTruongPhong.setSelected(true);
        rdoVTruongPhong.setText("Trưởng phòng");
        rdoVTruongPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVTruongPhongActionPerformed(evt);
            }
        });

        rdoVTNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        rdoVTNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoVTNhanVien.setForeground(new java.awt.Color(25, 29, 74));
        rdoVTNhanVien.setText("Nhân viên");
        rdoVTNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVTNhanVienActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(25, 29, 74));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnThem.setBorderPainted(false);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(86, 41));
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

        btnSua.setBackground(new java.awt.Color(25, 29, 74));
        btnSua.setForeground(new java.awt.Color(25, 29, 74));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnSua.setBorderPainted(false);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(86, 41));
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

        btnXoa.setBackground(new java.awt.Color(25, 29, 74));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete1.png"))); // NOI18N
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnXoa.setBorderPainted(false);
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(86, 41));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoaMouseExited(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(25, 29, 74));
        btnMoi.setForeground(new java.awt.Color(25, 29, 74));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnMoi.setBorderPainted(false);
        btnMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoi.setPreferredSize(new java.awt.Dimension(86, 41));
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

        txtmatkhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmatkhau.setForeground(new java.awt.Color(25, 29, 74));
        txtmatkhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        txtChekMatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtChekMatKhau.setForeground(new java.awt.Color(25, 29, 74));
        txtChekMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtChekMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChekMatKhauActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 10, 46));
        jLabel7.setText("Số Điện Thoại");

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(25, 29, 74));
        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 10, 46));
        jLabel8.setText("Giới Tính");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 10, 46));
        jLabel9.setText("Ngày Sinh");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(5, 10, 46));
        jLabel10.setText("Địa Chỉ");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(25, 29, 74));
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        rdoGTNam.setBackground(new java.awt.Color(255, 255, 255));
        rdoGTNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoGTNam.setForeground(new java.awt.Color(25, 29, 74));
        rdoGTNam.setSelected(true);
        rdoGTNam.setText("Nam");
        rdoGTNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoGTNamActionPerformed(evt);
            }
        });

        rdoGTNu.setBackground(new java.awt.Color(255, 255, 255));
        rdoGTNu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoGTNu.setForeground(new java.awt.Color(25, 29, 74));
        rdoGTNu.setText("Nữ");

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtNgaySinh.setForeground(new java.awt.Color(25, 29, 74));
        txtNgaySinh.setDateFormatString("y-MM-d");
        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(5, 10, 46));
        jLabel12.setText("Ghi Chú");

        lblNgaybatdau.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNgaybatdau.setForeground(new java.awt.Color(5, 10, 46));
        lblNgaybatdau.setText("Ngày Bắt Đầu");

        txtNgayBD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNgayBD.setForeground(new java.awt.Color(25, 29, 74));
        txtNgayBD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtNgayBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBDActionPerformed(evt);
            }
        });

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(5, 10, 46), 2, true));

        imgAnh.setBackground(new java.awt.Color(255, 255, 255));
        imgAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgAnh.setToolTipText("");
        imgAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(25, 29, 74));
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        jScrollPane4.setViewportView(txtGhiChu);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(5, 10, 46));
        jLabel14.setText("Email");

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtemail.setForeground(new java.awt.Color(25, 29, 74));
        txtemail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChekMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoVTruongPhong)
                .addGap(18, 18, 18)
                .addComponent(rdoVTNhanVien))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoGTNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoGTNu))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBD)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(lblNgaybatdau)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThem});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(txtChekMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rdoVTruongPhong)
                        .addComponent(rdoVTNhanVien)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblNgaybatdau))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoGTNam)
                            .addComponent(rdoGTNu))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSua, btnThem});

        jPanel5.setBackground(new java.awt.Color(25, 29, 74));
        jPanel5.setPreferredSize(new java.awt.Dimension(1870, 100));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nhân viên");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnDiemDanh.setBackground(new java.awt.Color(25, 29, 74));
        btnDiemDanh.setForeground(new java.awt.Color(25, 29, 74));
        btnDiemDanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        btnDiemDanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnDiemDanh.setBorderPainted(false);
        btnDiemDanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiemDanh.setPreferredSize(new java.awt.Dimension(86, 41));
        btnDiemDanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDiemDanhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDiemDanhMouseExited(evt);
            }
        });
        btnDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemDanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
            .addComponent(btnDiemDanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(btnDiemDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 1893, 1063);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSNVONAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDSNVONAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVONAncestorAdded

    private void tblDSNVONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVONMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblDSNVON.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                sttCTtap2();
                //                tabs.setSelectedIndex(0);
            }
        }
        //index = tblDSNVON.getSelectedRow();
        //        if (index < 0) {
        //            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        //        } else {
        //            this.edit();
        //            tabs.setSelectedIndex(0);
        //            sttCTtap2();
        //        }
    }//GEN-LAST:event_tblDSNVONMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timNhanVienON();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDSNVOFFAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDSNVOFFAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVOFFAncestorAdded

    private void tblDSNVOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVOFFMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.j = tblDSNVOFF.rowAtPoint(evt.getPoint());
            if (this.j >= 0) {
                this.edit1();
                sttOff();
                //                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblDSNVOFFMouseClicked

    private void tblDSNVOFFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVOFFMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVOFFMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        j = tblDSNVOFF.getSelectedRow();
        if (j < 0) {
            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        } else {
            KhoiPhuc();
            //            MessageService.alert(rootPane, "Xóa Thành Công");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem2ActionPerformed
        // TODO add your handling code here:
        timNhanVienOFF();
    }//GEN-LAST:event_btnTimKiem2ActionPerformed

    private void rdoVTruongPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVTruongPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoVTruongPhongActionPerformed

    private void rdoVTNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVTNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoVTNhanVienActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        //        if (check()) {
        //            this.insert();
        //        }

        if (chekrong() == true) {
            if (valid() == true) {
                if (ChekTrung()) {
                    try {
                        //                nvdao.insert(entity);
                        NhanVienModel entity = getEntity();

                        try {
                            nvdao.insert(entity);
                            this.filltableNVON();
                            filltableNVOFF();
                            this.clear();
                            MessageService.alert(this, "Thêm mới thành công!");
                            //                            System.out.println(jDateChooser1.getDate());
                            String hi = DateService.toString(txtNgaySinh.getDate(), "yyyy-MM-dd");
                            System.out.println(hi);
                        } catch (Exception e) {
                            MessageService.alert(this, "Thêm mới thất bại!");
                        }

                    } catch (Exception e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (chekrong()) {
            if (valid()) {
                update();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        //        String checkmanv = txtMaNV.getText();
        //        //        if (ShareHelper.USER.getMaNV().equals(checkmanv)) {
        //            //            DialogHelper.alert(this, "không xóa chính mình");
        //            //        } else {
        //            //            this.delete();
        //            //        }
        //        //        if (!Auth.isManager()) {
        //            //           DialogHelper.alert(this, "Ban k co quyen xoa");
        //            //        }else{
        //            if(checkmanv.equals(Auth.user.getMaNV())){
        //                DialogHelper.alert(this, "ban k xoa duoc ban");
        //            }else{
        //                DialogHelper.confirm(this, "Ban muon xoa chu ?");
        //                this.delete();
        //                //            }
        //        }
        this.xoatrenForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        //        this.clear();
        clear();
        sttCTtap3();
        //        txtnhanvien.setEditable(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (index == 0) {
            index = tblDSNVON.getRowCount() - 1;

        } else if (index < 0) {

        }
        index--;
        this.edit();
        //        System.out.println(index);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:

        if (index == tblDSNVON.getRowCount() - 1) {
            index = 0;

        }
        index++;
        this.edit();

    }//GEN-LAST:event_btnnextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        this.index = tblDSNVON.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtChekMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChekMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChekMatKhauActionPerformed

    private void txtNgayBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBDActionPerformed

    private void imgAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAnhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser file = new JFileChooser("image\\");
            int kq = file.showOpenDialog(file);
            if (kq == JFileChooser.APPROVE_OPTION) {
                imageName = file.getSelectedFile().getName();
                ResizeImage(imageName);
                imgAnh.setToolTipText(imageName);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn ảnh...");
            }

        } catch (Exception a) {

        }
        //            try {
        //                ImageService.getAppIcon();
        //        } catch (Exception e) {
        //        }
    }//GEN-LAST:event_imgAnhMouseClicked

    private void rdoGTNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGTNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoGTNamActionPerformed

    private void btnTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseEntered
        changeColor(btnTimKiem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnTimKiemMouseEntered

    private void btnTimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseExited
        changeColor(btnTimKiem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnTimKiemMouseExited

    private void btnTimKiem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiem2MouseEntered
        changeColor(btnTimKiem2, new Color(102, 0, 102));
    }//GEN-LAST:event_btnTimKiem2MouseEntered

    private void btnTimKiem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiem2MouseExited
        changeColor(btnTimKiem2, new Color(25, 29, 74));
    }//GEN-LAST:event_btnTimKiem2MouseExited

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        changeColor(btnThem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        changeColor(btnThem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnThemMouseExited

    private void btnSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseEntered
        changeColor(btnSua, new Color(102, 0, 102));
    }//GEN-LAST:event_btnSuaMouseEntered

    private void btnSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseExited
        changeColor(btnSua, new Color(25, 29, 74));
    }//GEN-LAST:event_btnSuaMouseExited

    private void btnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseEntered
        changeColor(btnXoa, new Color(102, 0, 102));
    }//GEN-LAST:event_btnXoaMouseEntered

    private void btnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseExited
        changeColor(btnXoa, new Color(25, 29, 74));
    }//GEN-LAST:event_btnXoaMouseExited

    private void btnMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseEntered
        changeColor(btnMoi, new Color(102, 0, 102));
    }//GEN-LAST:event_btnMoiMouseEntered

    private void btnMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseExited
        changeColor(btnMoi, new Color(25, 29, 74));
    }//GEN-LAST:event_btnMoiMouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        changeColor(jButton3, new Color(102, 0, 102));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        changeColor(jButton3, new Color(25, 29, 74));
    }//GEN-LAST:event_jButton3MouseExited

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        changeColor(btnPrev, new Color(102, 0, 102));
    }//GEN-LAST:event_btnPrevMouseEntered

    private void btnPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseExited
        changeColor(btnPrev, new Color(25, 29, 74));
    }//GEN-LAST:event_btnPrevMouseExited

    private void btnFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseEntered
        changeColor(btnFirst, new Color(102, 0, 102));
    }//GEN-LAST:event_btnFirstMouseEntered

    private void btnFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseExited
        changeColor(btnFirst, new Color(25, 29, 74));
    }//GEN-LAST:event_btnFirstMouseExited

    private void btnnextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnextMouseEntered
        changeColor(btnnext, new Color(102, 0, 102));
    }//GEN-LAST:event_btnnextMouseEntered

    private void btnnextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnextMouseExited
        changeColor(btnnext, new Color(25, 29, 74));
    }//GEN-LAST:event_btnnextMouseExited

    private void btnLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseEntered
        changeColor(btnLast, new Color(102, 0, 102));
    }//GEN-LAST:event_btnLastMouseEntered

    private void btnLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseExited
        changeColor(btnLast, new Color(25, 29, 74));
    }//GEN-LAST:event_btnLastMouseExited

    private void btnDiemDanhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemDanhMouseEntered
          changeColor(btnDiemDanh, new Color(102, 0, 102));
    }//GEN-LAST:event_btnDiemDanhMouseEntered

    private void btnDiemDanhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemDanhMouseExited
        changeColor(btnDiemDanh, new Color(25, 29, 74));
    }//GEN-LAST:event_btnDiemDanhMouseExited

    private void btnDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemDanhActionPerformed
        new DiemDanh().setVisible(true);
    }//GEN-LAST:event_btnDiemDanhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiemDanh;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem2;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnnext;
    private javax.swing.JLabel imgAnh;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNgaybatdau;
    private javax.swing.JRadioButton rdoGTNam;
    private javax.swing.JRadioButton rdoGTNu;
    private javax.swing.JRadioButton rdoVTNhanVien;
    private javax.swing.JRadioButton rdoVTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDSNVOFF;
    private javax.swing.JTable tblDSNVON;
    private javax.swing.JPasswordField txtChekMatKhau;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiemOFF;
    private javax.swing.JTextField txtTimKiemON;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtmatkhau;
    // End of variables declaration//GEN-END:variables

}
