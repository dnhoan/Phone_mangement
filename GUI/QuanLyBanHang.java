package GUI;

import BUS.Models.BusCTSanPhamModel;
import BUS.Models.BusHoaDon;
import BUS.Models.BusPhanLoaiSpModel;
import BUS.Models.BusVoucherModel;
import BUS.Models.KhachHangModel;
import BUS.Services.BusImeiService;
import BUS.Services.BusPhanLoaiSpService;
import BUS.Services.CTHoaDonService;
import BUS.Services.HoaDonService;
import BUS.Services.KhachHangService;
import BUS.Services.SanPhamService;
import BUS.Services.VoucherService;
import DAL.Models.DalChiTietHoaDon;
import DAL.Models.DalHoaDon;
import DAL.Models.DalImeiModel;
import DAL.Services.DalImeiService;
import GUI.Models.CartModel;
import GUI.Services.AuthService;
import GUI.Services.ButtonColumn;
import GUI.Services.DateService;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import GUI.Services.UtilityService;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class QuanLyBanHang extends javax.swing.JInternalFrame {

    Comparator<BusCTSanPhamModel> comparator = Comparator.comparing(BusCTSanPhamModel::getGiaBan);
    public static List<BusCTSanPhamModel> listSp = new ArrayList<>();
    List<BusHoaDon> listHoaDon = new ArrayList<>();
    SanPhamService sanPhamService = new SanPhamService();
    public static List<CartModel> listCart = new ArrayList<>();
    List<KhachHangModel> listKhachHang = new ArrayList<>();
    public static List<DalImeiModel> listImeiThem = new ArrayList<>();
    public static List<DalImeiModel> listImeiXoa = new ArrayList<>();
    static DefaultTableModel cartModel;
    static DefaultTableModel modelSp;
    DefaultTableModel sanPhamModel;
    DefaultTableModel hoaDonModel;
    DefaultTableModel hoaDonRecycleModel;
    DefaultComboBoxModel<KhachHangModel> khachHangModel;
    KhachHangService khachHangService = new KhachHangService();
    HoaDonService hoaDonService = new HoaDonService();
    CTHoaDonService cTHoaDonService = new CTHoaDonService();
    int row = -1;
    int rowHoaDon;
    static float totalMoney = 0;
    static float khachThanhToan = 0;
    static float tienThua = 0;
    static float giamGia = 0;
    static float khachCanTra = 0;
    static float tienKhuyenMai = 0;
    float hoaDonTong;
    int currentId;
    static Icon iconAddToCart = new ImageIcon();
    Icon iconBackUp = new ImageIcon(getClass().getResource("/icon/curve-arrow.png"));
    Icon iconDelete = new ImageIcon(getClass().getResource("/icon/bin.png"));
    static Icon iconView = new ImageIcon();
    static float phiShip = 0;

    public QuanLyBanHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int h = d.height;
        int w = d.width;
        this.setSize(w, h);
        desginTable();
        iconAddToCart = new ImageIcon(getClass().getResource("/icon/add-cart (3).png"));
        iconView = new ImageIcon(getClass().getResource("/icon/view.png"));
        this.init();
    }

    public void desginTable() {
        tblCart.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblCart.getTableHeader().setOpaque(false);
        tblCart.getTableHeader().setBackground(new Color(25, 29, 74));
        tblCart.getTableHeader().setForeground(Color.WHITE);
        tblCart.setGridColor(new Color(25, 29, 74));
        tblCart.setSelectionBackground(new Color(38, 117, 191));
        tblCart.setShowGrid(true);

        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        tblHoaDon.getTableHeader().setOpaque(false);
        tblHoaDon.getTableHeader().setBackground(new Color(25, 29, 74));
        tblHoaDon.getTableHeader().setForeground(Color.WHITE);
        tblHoaDon.setGridColor(new Color(25, 29, 74));
        tblHoaDon.setSelectionBackground(new Color(38, 117, 191));
        tblHoaDon.setShowGrid(true);
        tblSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        tblSanPham.getTableHeader().setOpaque(false);
        tblSanPham.getTableHeader().setBackground(new Color(25, 29, 74));
        tblSanPham.getTableHeader().setForeground(Color.WHITE);
        tblSanPham.setGridColor(new Color(25, 29, 74));
        tblSanPham.setSelectionBackground(new Color(38, 117, 191));
        tblSanPham.setShowGrid(true);
    }

    static void setTienThanhToan() {
        tienKhuyenMai = giamTheoTien ? giamGia : (totalMoney * giamGia / 100);
        lblTongTien.setText("Tổng tiền hàng: " + UtilityService.toVnd(totalMoney));
        khachCanTra = totalMoney + phiShip - tienKhuyenMai;
        lblGiamGia.setText("Giảm giá: " + UtilityService.toVnd(tienKhuyenMai));
        lblKhachCanTra.setText("Khách cần trả: " + UtilityService.toVnd(khachCanTra));
        if (khachThanhToan - (totalMoney + phiShip) >= 0) {
            lblTienThua.setText("Trả lại: " + UtilityService.toVnd(khachThanhToan - (totalMoney + phiShip - tienKhuyenMai)));
        } else {
            lblTienThua.setText("Thiếu: " + UtilityService.toVnd(totalMoney + phiShip - tienKhuyenMai - khachThanhToan));
        }
        if (khachThanhToan >= khachCanTra) {
            btnThanhToan.setEnabled(true);
            rdoGiaoThanhCong.setSelected(true);
            btnLuuHoaDon.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(false);
            if (!rdoShipHang.isSelected()) {
                rdoChuaGiao.setSelected(true);
            }
            btnLuuHoaDon.setEnabled(true);
        }
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        btnThanhToan = new javax.swing.JButton();
        lblGiamGia = new javax.swing.JLabel();
        cboKhachHang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKhachThanhToan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editKhachHang = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDiahChiKh = new javax.swing.JTextArea();
        jpnHoaDOn = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jpnSanPham = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnAscen = new javax.swing.JButton();
        txtSearchBox = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNewReceip2 = new javax.swing.JButton();
        txtNhanVien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jpnHoaDonTreo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rdoKhongGiao = new javax.swing.JRadioButton();
        rdoShipHang = new javax.swing.JRadioButton();
        txtTienShip = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNgayGiaoHang = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        btnSwichDanhsach = new javax.swing.JButton();
        btnDesc = new javax.swing.JButton();
        lblTienThua = new javax.swing.JLabel();
        lblKhachCanTra = new javax.swing.JLabel();
        btnLuuHoaDon = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rdoDangGiao = new javax.swing.JRadioButton();
        rdoGiaoThanhCong = new javax.swing.JRadioButton();
        rdoChuaGiao = new javax.swing.JRadioButton();
        btnInHoaDon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cboGiamGia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        cboPhanLoai = new javax.swing.JComboBox<>();
        lblPhanLoai = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThanhToan.setBackground(new java.awt.Color(25, 29, 74));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/payment2.png"))); // NOI18N
        btnThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        getContentPane().add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 870, 86, 41));

        lblGiamGia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblGiamGia.setForeground(new java.awt.Color(255, 51, 0));
        lblGiamGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGiamGia.setText("Tổng tiền hàng: 0 VNĐ");
        getContentPane().add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 780, 390, -1));

        cboKhachHang.setBackground(new java.awt.Color(153, 153, 153));
        cboKhachHang.setEditable(true);
        cboKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboKhachHang.setForeground(new java.awt.Color(25, 29, 74));
        cboKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        getContentPane().add(cboKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 240, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Khách hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Nhân viên");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, -1, -1));

        txtKhachThanhToan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtKhachThanhToan.setForeground(new java.awt.Color(25, 29, 74));
        txtKhachThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtKhachThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachThanhToanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKhachThanhToanKeyTyped(evt);
            }
        });
        getContentPane().add(txtKhachThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 620, 290, 35));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Địa chỉ nhận hàng");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, -1, -1));

        editKhachHang.setBackground(new java.awt.Color(25, 29, 74));
        editKhachHang.setForeground(new java.awt.Color(25, 29, 74));
        editKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editing.png"))); // NOI18N
        editKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 20));
        editKhachHang.setBorderPainted(false);
        editKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKhachHangActionPerformed(evt);
            }
        });
        getContentPane().add(editKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 190, 45, 37));

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(25, 29, 74));
        txtGhiChu.setRows(5);
        txtGhiChu.setAutoscrolls(false);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        jScrollPane4.setViewportView(txtGhiChu);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 300, 290, 70));

        txtDiahChiKh.setEditable(false);
        txtDiahChiKh.setColumns(20);
        txtDiahChiKh.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtDiahChiKh.setForeground(new java.awt.Color(25, 29, 74));
        txtDiahChiKh.setRows(5);
        txtDiahChiKh.setText("Tại cửa hàng\n");
        txtDiahChiKh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        jScrollPane6.setViewportView(txtDiahChiKh);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 410, 290, 69));

        jpnHoaDOn.setBackground(new java.awt.Color(255, 255, 255));
        jpnHoaDOn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(5, 10, 46))); // NOI18N
        jpnHoaDOn.setForeground(new java.awt.Color(255, 255, 0));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mahd", "Mã nv", "Tên KH + SĐT", "Ngày tạo", "SL", "Phí vận chuyển", "Thành tiền", "Khách trả", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(30);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseEntered(evt);
            }
        });
        jScrollPane10.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(0);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblHoaDon.getColumnModel().getColumn(1).setMinWidth(50);
            tblHoaDon.getColumnModel().getColumn(1).setMaxWidth(50);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(100);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(40);
            tblHoaDon.getColumnModel().getColumn(5).setMinWidth(120);
            tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(120);
            tblHoaDon.getColumnModel().getColumn(6).setMinWidth(120);
            tblHoaDon.getColumnModel().getColumn(6).setMaxWidth(120);
            tblHoaDon.getColumnModel().getColumn(7).setMinWidth(120);
            tblHoaDon.getColumnModel().getColumn(7).setMaxWidth(120);
            tblHoaDon.getColumnModel().getColumn(8).setMinWidth(60);
            tblHoaDon.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        javax.swing.GroupLayout jpnHoaDOnLayout = new javax.swing.GroupLayout(jpnHoaDOn);
        jpnHoaDOn.setLayout(jpnHoaDOnLayout);
        jpnHoaDOnLayout.setHorizontalGroup(
            jpnHoaDOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        jpnHoaDOnLayout.setVerticalGroup(
            jpnHoaDOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDOnLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jpnHoaDOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, 980, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(5, 10, 46))); // NOI18N

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaCTSP", "Ảnh", "Tên sản phẩm", "Giá", "Sale /1 SP", "SL", "Tổng tiền", "Imei"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        tblCart.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tblCartComponentResized(evt);
            }
        });
        tblCart.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblCartInputMethodTextChanged(evt);
            }
        });
        tblCart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCartKeyTyped(evt);
            }
        });
        jScrollPane8.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setMinWidth(0);
            tblCart.getColumnModel().getColumn(0).setMaxWidth(0);
            tblCart.getColumnModel().getColumn(1).setMinWidth(60);
            tblCart.getColumnModel().getColumn(1).setMaxWidth(60);
            tblCart.getColumnModel().getColumn(3).setMinWidth(120);
            tblCart.getColumnModel().getColumn(3).setMaxWidth(120);
            tblCart.getColumnModel().getColumn(4).setMinWidth(100);
            tblCart.getColumnModel().getColumn(4).setMaxWidth(100);
            tblCart.getColumnModel().getColumn(5).setMinWidth(50);
            tblCart.getColumnModel().getColumn(5).setMaxWidth(50);
            tblCart.getColumnModel().getColumn(6).setMinWidth(120);
            tblCart.getColumnModel().getColumn(6).setMaxWidth(120);
            tblCart.getColumnModel().getColumn(7).setMinWidth(60);
            tblCart.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 623, 980, 300));

        jpnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jpnSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(5, 10, 46))); // NOI18N
        jpnSanPham.setForeground(new java.awt.Color(255, 255, 0));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CTSP", "Ảnh", "Tên SP", "Giá Bán", "Kho", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(0);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSanPham.getColumnModel().getColumn(1).setMinWidth(60);
            tblSanPham.getColumnModel().getColumn(1).setMaxWidth(60);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(150);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(150);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(60);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(60);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(60);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        getContentPane().add(jpnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, 980, 420));

        btnAscen.setBackground(new java.awt.Color(25, 29, 74));
        btnAscen.setForeground(new java.awt.Color(25, 29, 74));
        btnAscen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ascend.png"))); // NOI18N
        btnAscen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnAscen.setBorderPainted(false);
        btnAscen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAscen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscenActionPerformed(evt);
            }
        });
        getContentPane().add(btnAscen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 86, 41));

        txtSearchBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchBox.setForeground(new java.awt.Color(25, 29, 74));
        txtSearchBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 40));

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(5, 10, 46));
        lblTimKiem.setText("Tìm kiếm sản phẩm");
        getContentPane().add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 24));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 10, 46));
        jLabel9.setText("Ghi chú");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, 80, -1));

        btnNewReceip2.setBackground(new java.awt.Color(25, 29, 74));
        btnNewReceip2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newbill.png"))); // NOI18N
        btnNewReceip2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnNewReceip2.setBorderPainted(false);
        btnNewReceip2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewReceip2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewReceip2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewReceip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 870, 86, 41));

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNhanVien.setForeground(new java.awt.Color(25, 29, 74));
        txtNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });
        getContentPane().add(txtNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 250, 290, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(5, 10, 46));
        jLabel11.setText("Khách đưa");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 640, -1, -1));

        jpnHoaDonTreo.setBackground(new java.awt.Color(204, 255, 255));
        jpnHoaDonTreo.setLayout(new java.awt.GridLayout(0, 1));
        getContentPane().add(jpnHoaDonTreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 170, 120, 716));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(5, 10, 46));
        jLabel12.setText("Hóa đơn treo");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 150, -1, -1));

        rdoKhongGiao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoKhongGiao);
        rdoKhongGiao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoKhongGiao.setForeground(new java.awt.Color(25, 29, 74));
        rdoKhongGiao.setSelected(true);
        rdoKhongGiao.setText("Tại cửa hàng");
        rdoKhongGiao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoKhongGiaoItemStateChanged(evt);
            }
        });
        getContentPane().add(rdoKhongGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 380, -1, -1));

        rdoShipHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoShipHang);
        rdoShipHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoShipHang.setForeground(new java.awt.Color(25, 29, 74));
        rdoShipHang.setText("Ship hàng");
        rdoShipHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoShipHangItemStateChanged(evt);
            }
        });
        getContentPane().add(rdoShipHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 380, -1, -1));

        txtTienShip.setEditable(false);
        txtTienShip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTienShip.setForeground(new java.awt.Color(25, 29, 74));
        txtTienShip.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtTienShip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienShipFocusLost(evt);
            }
        });
        txtTienShip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienShipKeyReleased(evt);
            }
        });
        getContentPane().add(txtTienShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 490, 290, 35));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(5, 10, 46));
        jLabel14.setText("Ngày giao hàng");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 100, -1));

        txtNgayGiaoHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtNgayGiaoHang.setForeground(new java.awt.Color(25, 29, 74));
        txtNgayGiaoHang.setDateFormatString("dd/MM/yyyy");
        txtNgayGiaoHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNgayGiaoHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNgayGiaoHangKeyReleased(evt);
            }
        });
        getContentPane().add(txtNgayGiaoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 540, 290, 35));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(5, 10, 46));
        jLabel15.setText("Phí vận chuyển");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 500, 100, -1));

        btnSwichDanhsach.setBackground(new java.awt.Color(25, 29, 74));
        btnSwichDanhsach.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSwichDanhsach.setForeground(new java.awt.Color(255, 255, 255));
        btnSwichDanhsach.setText("Danh sách hóa đơn");
        btnSwichDanhsach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 20));
        btnSwichDanhsach.setBorderPainted(false);
        btnSwichDanhsach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwichDanhsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwichDanhsachActionPerformed(evt);
            }
        });
        getContentPane().add(btnSwichDanhsach, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 130, 201, 40));

        btnDesc.setBackground(new java.awt.Color(25, 29, 74));
        btnDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/descend.png"))); // NOI18N
        btnDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnDesc.setBorderPainted(false);
        btnDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 86, 41));

        lblTienThua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(5, 10, 46));
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTienThua.setText("Tiền thừa: ");
        getContentPane().add(lblTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 840, 390, -1));

        lblKhachCanTra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblKhachCanTra.setForeground(new java.awt.Color(255, 51, 0));
        lblKhachCanTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKhachCanTra.setText("Khách cần trả: 0 VNĐ");
        getContentPane().add(lblKhachCanTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 810, 390, -1));

        btnLuuHoaDon.setBackground(new java.awt.Color(25, 29, 74));
        btnLuuHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save1.png"))); // NOI18N
        btnLuuHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnLuuHoaDon.setBorderPainted(false);
        btnLuuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHoaDonActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuuHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 870, 86, 41));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 10, 46));
        jLabel7.setText("Trạng thái GH");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 600, -1, -1));

        rdoDangGiao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoDangGiao);
        rdoDangGiao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoDangGiao.setForeground(new java.awt.Color(25, 29, 74));
        rdoDangGiao.setText("Đang giao");
        rdoDangGiao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoDangGiaoItemStateChanged(evt);
            }
        });
        getContentPane().add(rdoDangGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 600, -1, -1));

        rdoGiaoThanhCong.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoGiaoThanhCong);
        rdoGiaoThanhCong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoGiaoThanhCong.setForeground(new java.awt.Color(25, 29, 74));
        rdoGiaoThanhCong.setSelected(true);
        rdoGiaoThanhCong.setText("Giao thành công");
        rdoGiaoThanhCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoGiaoThanhCongActionPerformed(evt);
            }
        });
        getContentPane().add(rdoGiaoThanhCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 600, -1, -1));

        rdoChuaGiao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoChuaGiao);
        rdoChuaGiao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoChuaGiao.setForeground(new java.awt.Color(25, 29, 74));
        rdoChuaGiao.setText("Chưa giao");
        getContentPane().add(rdoChuaGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 600, -1, -1));

        btnInHoaDon.setBackground(new java.awt.Color(25, 29, 74));
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print1.png"))); // NOI18N
        btnInHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnInHoaDon.setBorderPainted(false);
        btnInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });
        getContentPane().add(btnInHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 870, 86, 41));

        jPanel3.setBackground(new java.awt.Color(25, 29, 74));
        jPanel3.setPreferredSize(new java.awt.Dimension(1870, 100));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bán hàng");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 114));

        cboGiamGia.setBackground(new java.awt.Color(153, 153, 153));
        cboGiamGia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboGiamGia.setForeground(new java.awt.Color(25, 29, 74));
        cboGiamGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        cboGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGiamGiaItemStateChanged(evt);
            }
        });
        getContentPane().add(cboGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 680, 290, 37));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(5, 10, 46));
        jLabel10.setText("Chọn mã giảm giá");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 690, -1, 20));

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 51, 0));
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTongTien.setText("Tổng tiền hàng: 0 VNĐ");
        getContentPane().add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 750, 390, -1));

        cboPhanLoai.setBackground(new java.awt.Color(153, 153, 153));
        cboPhanLoai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboPhanLoai.setForeground(new java.awt.Color(25, 29, 74));
        cboPhanLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        cboPhanLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhanLoaiItemStateChanged(evt);
            }
        });
        getContentPane().add(cboPhanLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 190, 40));

        lblPhanLoai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPhanLoai.setForeground(new java.awt.Color(5, 10, 46));
        lblPhanLoai.setText("Phân Loại sản phẩm");
        getContentPane().add(lblPhanLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, 24));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (validateForm()) {
            if (MessageService.confirm(rootPane, "Bạn có muốn thanh toán hóa đơn không ?")) {
                if (rdoGiaoThanhCong.isSelected()) {
                    if (isEditting) {
                        this.update(false);
                    } else {
                        this.insert(false);
                    }
                } else {
                    MessageService.alert(rootPane, "Vui lòng chọn giao hàng thành công nếu muốn thanh toán");
                }
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void editKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKhachHangActionPerformed
//        removeAllImei();
        if (MessageService.confirm(rootPane, "Bạn có muốn mở form khách hàng không ?")) {
            QuanLyKhachHang kh = new QuanLyKhachHang();
            MainThuNghiem.dashboardview.removeAll();
            MainThuNghiem.dashboardview.add(kh).setVisible(true);

        }
    }//GEN-LAST:event_editKhachHangActionPerformed

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCartMouseClicked

    private void tblCartComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblCartComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCartComponentResized

    private void tblCartInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblCartInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCartInputMethodTextChanged

    private void tblCartKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCartKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCartKeyTyped

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (evt.getClickCount() == 2) {
            new XemChiTietSanPham((int) tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0)).setVisible(true);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnAscenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscenActionPerformed
        this.sortAsend();
    }//GEN-LAST:event_btnAscenActionPerformed

    private void btnNewReceip2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewReceip2ActionPerformed
        if (MessageService.confirm(rootPane, "Bạn có muốn làm mới form không ?"))
            this.clearHoaDon(false);
    }//GEN-LAST:event_btnNewReceip2ActionPerformed

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed

    private void cboPhanLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhanLoaiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!isFirst && !isDsHoaDon) {
                BusPhanLoaiSpModel busPhanLoaiSpModel = (BusPhanLoaiSpModel) cboPhanLoai.getSelectedItem();
                getProductDataByPhanLoai(busPhanLoaiSpModel.getDalPhanLoaiSpModel().getMaPhanLoai());
                fillTable(QuanLyBanHang.listSp);
            } else if (!isFirst) {
                cboSelected = cboPhanLoai.getSelectedIndex();
                System.out.println("index cbo" + cboSelected);
                getDataHoaDon(cboSelected);
                fillTableHoaDon(hoaDonModel, tblHoaDon, listHoaDon);
            }
        }
    }//GEN-LAST:event_cboPhanLoaiItemStateChanged

    private void rdoKhongGiaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoKhongGiaoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtDiahChiKh.setEditable(false);
            txtTienShip.setEditable(false);
            rdoGiaoThanhCong.setSelected(true);
            rdoDangGiao.setEnabled(false);
            txtDiahChiKh.setText("Tại cửa hàng");
            txtTienShip.setText(0 + "");
            txtNgayGiaoHang.setEnabled(false);
            txtNgayGiaoHang.setDate(currentDate);
        }
    }//GEN-LAST:event_rdoKhongGiaoItemStateChanged

    private void btnSwichDanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwichDanhsachActionPerformed
        this.isDsHoaDon = !this.isDsHoaDon;
        clearHoaDon(false);
        if (this.isDsHoaDon) {
            showDanhSachHoaDon();
        } else {
            showDanhSachSanPhamm();
        }
    }//GEN-LAST:event_btnSwichDanhsachActionPerformed

    private void btnDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescActionPerformed
        this.sortDesc();
    }//GEN-LAST:event_btnDescActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        rowHoaDon = tblHoaDon.getSelectedRow();
        currentMahd = (int) tblHoaDon.getValueAt(rowHoaDon, 0);
        setFormHoaDon(currentMahd);
        isEditting = true;
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTienShipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienShipFocusLost
        if (!isEditting) {
            getPhiShip();
        }
    }//GEN-LAST:event_txtTienShipFocusLost

    private void btnLuuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHoaDonActionPerformed
        if (validateForm()) {
            if (MessageService.confirm(rootPane, "Bạn có muốn lưu hóa đơn không ?")) {
                if (!rdoGiaoThanhCong.isSelected()) {
                    if (isEditting) {
                        this.update(true);
                    } else {
                        this.insert(true);
                    }
                } else {
                    MessageService.alert(rootPane, "Nếu bạn muốn lưu vui lòng chọn trạng thái giao hàng khác giao hàng thành công");
                }

            }
        }
    }//GEN-LAST:event_btnLuuHoaDonActionPerformed

    private void txtTienShipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienShipKeyReleased
        getPhiShip();
    }//GEN-LAST:event_txtTienShipKeyReleased

    private void txtKhachThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachThanhToanKeyReleased
        if (!txtKhachThanhToan.getText().isEmpty()) {
            try {
                khachThanhToan = Float.parseFloat(txtKhachThanhToan.getText());
            } catch (Exception e) {
                System.out.println("errror");
                khachThanhToan = 0;
            }
        } else {
            khachThanhToan = 0;
        }
        setTienThanhToan();
    }//GEN-LAST:event_txtKhachThanhToanKeyReleased

    private void txtSearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBoxKeyReleased
        if (isDsHoaDon) {
            cboSelected = cboPhanLoai.getSelectedIndex();
            this.getDataHoaDon(cboSelected);
            this.fillTableHoaDon(hoaDonModel, tblHoaDon, listHoaDon);
        } else {
            this.getProductData();
            fillTable(QuanLyBanHang.listSp);
        }
    }//GEN-LAST:event_txtSearchBoxKeyReleased

    private void rdoDangGiaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoDangGiaoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDangGiaoItemStateChanged

    private void txtNgayGiaoHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgayGiaoHangKeyReleased
        if (DateService.toString(txtNgayGiaoHang.getDate(), "dd/MM/yyyy").equals(DateService.toString(currentDate, "dd/MM/yyyy"))) {
            rdoDangGiao.setSelected(true);
        } else {
            rdoChuaGiao.setSelected(true);
        }
    }//GEN-LAST:event_txtNgayGiaoHangKeyReleased

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        if (validateForm()) {
            if (MessageService.confirm(rootPane, "Bạn có muốn in hóa đơn này không")) {
                printHoaDon();
            }
        }
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void rdoGiaoThanhCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGiaoThanhCongActionPerformed

    }//GEN-LAST:event_rdoGiaoThanhCongActionPerformed

    private void tblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonMouseEntered

    private void rdoShipHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoShipHangItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtDiahChiKh.setEditable(true);
            txtDiahChiKh.setText("");
            txtNgayGiaoHang.setEnabled(true);
            rdoChuaGiao.setEnabled(true);
            rdoDangGiao.setEnabled(true);
            txtTienShip.setEditable(true);
            rdoDangGiao.setSelected(true);
        }
    }//GEN-LAST:event_rdoShipHangItemStateChanged

    private void cboGiamGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGiamGiaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            selectGiamGiaHoaDon();
        }
    }//GEN-LAST:event_cboGiamGiaItemStateChanged

    private void txtKhachThanhToanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachThanhToanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachThanhToanKeyTyped
    static void getPhiShip() {
        if (!txtTienShip.getText().isEmpty()) {
            try {
                phiShip = Float.parseFloat(txtTienShip.getText());
            } catch (Exception e) {
                System.out.println("errror");
                phiShip = 0;
            }
        } else {
            phiShip = 0;
        }
        setTienThanhToan();
    }
    DAL.Models.NhanVienModel currentUser = AuthService.user;
    DalImeiService dalImeiService = new DalImeiService();
    VoucherService voucherService = new VoucherService();
    DefaultComboBoxModel<BusPhanLoaiSpModel> phanLoaiModel;
    static DefaultComboBoxModel<BusVoucherModel> modelGiamGia;
    String regex_float = "[+-]?([0-9]*[.])?[0-9]+";
    boolean isFirst;
    static List<BusVoucherModel> listVoucher = new ArrayList<>();

    void init() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtNgayGiaoHang.getDateEditor();
        editor.setEnabled(false);
        addTableHeader();
        isFirst = true;
        BusPhanLoaiSpService.fillCombo(phanLoaiModel, cboPhanLoai);
        isFirst = false;
        txtNhanVien.setText(currentUser.getMaNV() + " - " + currentUser.getHoTen());
        this.fillToComboKhachHang();
        getProductData();
        fillTable(QuanLyBanHang.listSp);
        fillButtonHoaDonTreo();
        buttonAdd();
        buttonRemove();
        buttonRemoveHoaDon();
        AutoCompleteDecorator.decorate(cboKhachHang);
        rdoDangGiao.setEnabled(false);
        jpnHoaDOn.hide();
        setTienThanhToan();
        txtNgayGiaoHang.setDate(currentDate);
        listVoucher = VoucherService.selectGiamGiaHoaDon();
        VoucherService.fillCombo(modelGiamGia, cboGiamGia, listVoucher);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblCart.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        showTopupSelectGiamGia();
    }
    boolean isDsHoaDon = false;
    int cboSelected;

    void showDanhSachHoaDon() {
        lblTimKiem.setText("Tìm kiếm hóa đơn");
        lblPhanLoai.setText("Trạng thái giao hàng");
        btnSwichDanhsach.setText("Danh sách sản phẩm");
        tblSanPham.hide();
        btnAscen.hide();
        btnDesc.hide();
        jpnSanPham.hide();
        jpnHoaDOn.show();
        this.getDataHoaDon(0);
        cboPhanLoai.removeAllItems();
        cboPhanLoai.addItem("Tất cả");
        cboPhanLoai.addItem("Đang giao");
        cboPhanLoai.addItem("Chưa giao");
        cboPhanLoai.setSelectedItem("Tất cả");
        fillTableHoaDon(hoaDonModel, tblHoaDon, listHoaDon);
    }

    void showDanhSachSanPhamm() {
        lblTimKiem.setText("Tìm kiếm sản phẩm");
        lblPhanLoai.setText("Phân loại hàng");
        btnSwichDanhsach.setText("Danh sách hóa đơn");
        tblSanPham.show();
        btnAscen.show();
        btnDesc.show();
        jpnHoaDOn.hide();
        jpnSanPham.show();
        getProductData();
        isFirst = true;
        BusPhanLoaiSpService.fillCombo(phanLoaiModel, cboPhanLoai);
        isFirst = false;
        fillTable(QuanLyBanHang.listSp);
    }

    void getProductDataByPhanLoai(int maPhanLoai) {
        String keyWord = txtSearchBox.getText();
        try {
            QuanLyBanHang.listSp = sanPhamService.selectBySearchAndPhanLoai(1, keyWord, maPhanLoai);
        } catch (Exception e) {
            MessageService.alert(rootPane, "Lỗi lấy phân loại sản phẩm");
        }
    }

    void getProductData() {
        String keyWord = txtSearchBox.getText();
        try {
            QuanLyBanHang.listSp = sanPhamService.selectBySearch(1, keyWord);

        } catch (Exception e) {
            MessageService.alert(rootPane, "Lỗi get data");
        }
    }

    void getDataHoaDon(int filter) {
        try {
            String keyWord = txtSearchBox.getText();
            listHoaDon = hoaDonService.selectAll1(keyWord, filter);
        } catch (Exception e) {
        }
    }

    public void fillTableHoaDon(DefaultTableModel model, JTable tbl, List<BusHoaDon> list) {
        model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            if (list != null) {
                for (BusHoaDon hd : list) {
                    model.addRow(new Object[]{
                        hd.getMahd(),
                        hd.getNhanVienModel().getMaNV(),
                        hd.getKhachHangModel().getTenKH() + " - " + hd.getKhachHangModel().getSDT(),
                        hd.getNgayTao(),
                        hd.getSoLuong(),
                        hd.getPhiVanChuyen(),
                        UtilityService.toVnd(hd.getTongTien()),
                        UtilityService.toVnd(hd.getTienKhachTra()),
                        cboSelected == 3 ? iconBackUp : iconDelete
                    });
                }
            }
        } catch (Exception e) {
        }
    }

    static void fillTable(List<BusCTSanPhamModel> listSp) {
        modelSp = (DefaultTableModel) tblSanPham.getModel();
        modelSp.setRowCount(0);
        QuanLyBanHang.listSp.forEach(sp -> {
            JLabel imageLabel = new JLabel();
            File path = new File("logos", sp.getHinh());
            ImageIcon imageicon = new ImageIcon(path.getAbsolutePath());
            Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            modelSp.addRow(new Object[]{
                sp.getMaCTSP(),
                imageLabel,
                sp.getSanPhamModel().getTensp() + " - " + sp.getBusMauSacModel().getDalMauSacModel().getTenMau()
                + " - " + sp.getBusPhanLoaiSpModel().getDalPhanLoaiSpModel().getTenLoai(),
                UtilityService.toVnd(sp.getGiaBan()),
                sp.getTonKho(),
                iconAddToCart
            });
        });
    }

    void addToCart() {
        int rowSelected = tblSanPham.getSelectedRow();
        BusCTSanPhamModel busCTSanPhamModel = QuanLyBanHang.listSp.get(rowSelected);
        if (busCTSanPhamModel.getTonKho() > 0) {
            new SelectImei(busCTSanPhamModel).setVisible(true);
        } else {
            MessageService.alert(rootPane, "Sản phẩm này hết đã hết hàng vui lòng chọn sản phẩm khác");
        }
    }

    static void fillToCart(DefaultTableModel model, JTable tbl) {
        totalMoney = 0;
        model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        if (listCart.size() > 0) {
            List<CartModel> listEmpty = listCart.stream().filter(c -> c.getListImeis().isEmpty()).toList();
            if (listEmpty.size() > 0) {
                CartModel cartRemove = listEmpty.get(0);
                listCart.remove(cartRemove);
                getPhiShip();
            }
            if (listCart.size() > 0) {
                for (CartModel ca : listCart) {
                    totalMoney += ca.getTongTien();
                    JLabel imageLabel = new JLabel();
                    File path = new File("logos", ca.getHinh());
                    ImageIcon imageicon = new ImageIcon(path.getAbsolutePath());
                    Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(img));
                    model.addRow(new Object[]{
                        ca.getMactsp(),
                        imageLabel,
                        ca.getTensp(),
                        UtilityService.toVnd(ca.getGia()),
                        (ca.isGiamTheoTien() ? UtilityService.toVnd(ca.getSoLuongGiam()) : ca.getSoLuongGiam() + " %"),
                        ca.getListImeis().size(),
                        UtilityService.toVnd(ca.getTongTien()),
                        iconView
                    });
                }
                getPhiShip();
            }
        }
        setTienThanhToan();
    }

    void delete() {
        int idcthd = (int) tblHoaDon.getValueAt(rowHoaDon, 0);
        try {
            cTHoaDonService.delete(idcthd);
            MessageService.alert(rootPane, "Xóa hóa đơn thành công !");
        } catch (Exception e) {
            MessageService.alert(rootPane, "Lỗi xóa hóa đơn");
        }
    }
    Date currentDate = new Date();

    void update(boolean isSave) {
        try {
            DalHoaDon dalHoaDon = this.getFormHoaDon();
            if (!isSave) {
                dalHoaDon.setNgayThanhToan(currentDate);
                dalHoaDon.setTienKhachTra(phiShip + totalMoney);
            } else {
                dalHoaDon.setNgayThanhToan(null);
            }
            hoaDonService.update(dalHoaDon);
            listCart.forEach(ca -> {
//                    Thêm từng imei vào chi tiết hóa đơn dong thoi update imei thanh da ban
                for (DalImeiModel imei : ca.getListImeis()) {
                    DalChiTietHoaDon dalChiTietHoaDon = new DalChiTietHoaDon();
                    dalChiTietHoaDon.setMaImei(imei.getMaImei());
                    dalChiTietHoaDon.setMahd(dalHoaDon.getMaHD());
                    dalChiTietHoaDon.setGiaBanSauSale(ca.isGiamTheoTien() ? (ca.getGia() - ca.getSoLuongGiam()) : ca.getGia() - (ca.getGia() * ca.getSoLuongGiam() / 100));
                    dalChiTietHoaDon.setGiaBan(ca.getGia());
                    try {
                        cTHoaDonService.insert(dalChiTietHoaDon);
                        dalImeiService.updateMaSPSale(imei.getMaImei(), imei.getMaSpSale() > 0 ? imei.getMaSpSale() : null);
                    } catch (Exception e) {
                        System.out.println("Lỗi lưu hóa đơn @" + ca.getMactsp());
                    }
                }
                if (listImeiXoa.size() > 0) {
                    listImeiXoa.forEach(imei -> {
                        cTHoaDonService.updateByMaImei(imei.getMaImei());
                    });
                }
            });
            MessageService.alert(this, isSave ? "Lưu hóa đơn thành công" : "Thanh toán thành công");
            if (MessageService.confirm(rootPane, "Bạn có muốn in hóa này đơn không ?")) {
                this.printHoaDon();
            }
            clearHoaDon(false);
            fillButtonHoaDonTreo();
        } catch (Exception e) {
            MessageService.alert(rootPane, "Lỗi cập nhật dữ liệu @");
        }
    }

    void insert(boolean isSave) {

        DalHoaDon dalHoaDon = this.getFormHoaDon();
        if (!isSave) {
            dalHoaDon.setNgayThanhToan(currentDate);
            dalHoaDon.setTienKhachTra(khachCanTra);
        } else {
            dalHoaDon.setNgayThanhToan(null);
        }
        try {
//            thêm vào hóa đơn
            hoaDonService.insert(dalHoaDon);
//            lấy mã hóa đơn vừa thêm vào
            int lastID = hoaDonService.selectLasID();
            if (lastID > 0) {
//                thêm vào hóa đơn chi tiết
                listCart.forEach(ca -> {
//                    Thêm từng imei vào chi tiết hóa đơn dong thoi update imei thanh da ban
                    for (DalImeiModel imei : ca.getListImeis()) {
                        DalChiTietHoaDon dalChiTietHoaDon = new DalChiTietHoaDon();
                        dalChiTietHoaDon.setMaImei(imei.getMaImei());
                        dalChiTietHoaDon.setMahd(lastID);
                        dalChiTietHoaDon.setGiaBanSauSale(ca.isGiamTheoTien() ? (ca.getGia() - ca.getSoLuongGiam()) : ca.getGia() - (ca.getGia() * ca.getSoLuongGiam() / 100));
                        dalChiTietHoaDon.setGiaBan(ca.getGia());
                        try {
                            cTHoaDonService.insert(dalChiTietHoaDon);
                            dalImeiService.updateMaSPSale(imei.getMaImei(), imei.getMaSpSale() > 0 ? imei.getMaSpSale() : null);
                        } catch (Exception e) {
                            System.out.println("Lỗi lưu hóa đơn @" + ca.getMactsp());
                        }
                    }
                });
                MessageService.alert(this, isSave ? "Lưu hóa đơn thành công" : "Thanh toán thành công");
                if (MessageService.confirm(rootPane, "Bạn có muốn in hóa đơn này không ?")) {
                    this.printHoaDon();
                }
                this.clearHoaDon(false);
                fillButtonHoaDonTreo();
            }
        } catch (Exception e) {
            MessageService.alert(rootPane, "Thêm hóa đơn không thành công");
        }
    }
    static boolean giamTheoTien;

    static void selectGiamGiaHoaDon() {
        if (cboGiamGia.getSelectedIndex() == 0) {
            giamGia = 0;
        } else {
            BusVoucherModel busVoucherModel = (BusVoucherModel) cboGiamGia.getSelectedItem();
            if (totalMoney < busVoucherModel.getDKKM()) {
                MessageService.alert(null, "Bạn không đủ điều kiện để chọn mã giảm giá này");
                cboGiamGia.setSelectedIndex(0);
            } else {
                giamGia = busVoucherModel.getMucGG();
                //            0: tiền 1: %
                giamTheoTien = busVoucherModel.getLoaiGG() == 0;
            }
        }
        setTienThanhToan();
    }

    public DalHoaDon getFormHoaDon() {
        DalHoaDon dalHoaDon = new DalHoaDon();
        KhachHangModel kh = (KhachHangModel) cboKhachHang.getSelectedItem();
        dalHoaDon.setMakh(kh.getMaKH());
        System.out.println("mkh " + cboGiamGia.getSelectedIndex());
        if (cboGiamGia.getSelectedIndex() > 0) {
            BusVoucherModel busVoucherModel = (BusVoucherModel) cboGiamGia.getSelectedItem();
            dalHoaDon.setMaKm(busVoucherModel.getMaKM());
        } else {
            dalHoaDon.setMaKm(0);
            tienKhuyenMai = 0;
        }
        dalHoaDon.setTienKm(tienKhuyenMai);
        if (rdoShipHang.isSelected()) {
            dalHoaDon.setDiaChiNhanHang(txtDiahChiKh.getText());
            dalHoaDon.setNgayGiaoHang(txtNgayGiaoHang.getDate());
            dalHoaDon.setPhiVanChuyen(Float.parseFloat(txtTienShip.getText()));
        } else {
            dalHoaDon.setDiaChiNhanHang(null);
            dalHoaDon.setNgayGiaoHang(null);
            dalHoaDon.setPhiVanChuyen(0);
        }
        dalHoaDon.setManv(currentUser.getMaNV());
        dalHoaDon.setGhiChu(txtGhiChu.getText());
        dalHoaDon.setTongTien(khachCanTra);
        if (!txtKhachThanhToan.getText().isEmpty()) {
            dalHoaDon.setTienKhachTra(Float.parseFloat(txtKhachThanhToan.getText()));
        } else {
            dalHoaDon.setTienKhachTra(0);
        }
        //  0: Chua giao, 1: GiaoThanhCong, 2: Dang giao,
        if (rdoChuaGiao.isSelected()) {
            dalHoaDon.setTrangThaiGiaoHang(0);
        } else if (rdoDangGiao.isSelected()) {
            dalHoaDon.setTrangThaiGiaoHang(2);
        } else {
            dalHoaDon.setTrangThaiGiaoHang(1);
        }
        if (isEditting) {
            dalHoaDon.setMaHD(currentHoaDonSelected.getMahd());
            dalHoaDon.setNgayTao(currentHoaDonSelected.getNgayTao());
        }
        return dalHoaDon;
    }
    static int currentSLCart;
    static int currentMahd;

    void fillButtonHoaDonTreo() {
        jpnHoaDonTreo.removeAll();
        List<BusHoaDon> listHDTreo = hoaDonService.selectHoaDonTreo();
        if (listHDTreo.size() > 0) {
            JPanel panelTreo = new JPanel();
            for (BusHoaDon hoaDon : listHDTreo) {
                JButton btnTreo = new JButton("HD0" + hoaDon.getMahd() + "");
                btnTreo.addActionListener((ActionEvent e) -> {
                    System.out.println(btnTreo.getText());
                    currentMahd = Integer.parseInt(btnTreo.getText().substring(3));
                    setFormHoaDon(Integer.parseInt(btnTreo.getText().substring(3)));
                    isEditting = true;
                });
                btnTreo.setPreferredSize(new Dimension(50, 70));
                btnTreo.setSize(new Dimension(50, 70));
                btnTreo.setBackground(Color.RED);
                btnTreo.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panelTreo.add(btnTreo);
            }
            //            fill button in hoa don treo
            GridLayout gridLayoutTreo = new GridLayout(listHDTreo.size() < 10 ? 10 : listHDTreo.size(), 1, 0, 2);
            panelTreo.setLayout(gridLayoutTreo);
            JScrollPane scrollPaneTreo = new JScrollPane(panelTreo);
            scrollPaneTreo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPaneTreo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPaneTreo.setBounds(10, 10, 180, 250);
            jpnHoaDonTreo.setPreferredSize(new Dimension(180, 250));
            jpnHoaDonTreo.add(scrollPaneTreo);
        } else {
            JPanel panelTreo = new JPanel();
            GridLayout gridLayoutTreo = new GridLayout(listHDTreo.size() < 10 ? 10 : listHDTreo.size(), 1, 0, 2);
            panelTreo.setLayout(gridLayoutTreo);
            JScrollPane scrollPaneTreo = new JScrollPane(panelTreo);
            scrollPaneTreo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPaneTreo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPaneTreo.setBounds(10, 10, 180, 250);
            jpnHoaDonTreo.setPreferredSize(new Dimension(180, 250));
            jpnHoaDonTreo.add(scrollPaneTreo);
        }
    }
    BusHoaDon currentHoaDonSelected;
    boolean isEditting = false;

    void setFormHoaDon(int maHd) {
        isEditting = true;
        clearHoaDon(true);
//        removeAllImei();
        try {
//            select hoa don by mahd
            currentHoaDonSelected = hoaDonService.selectByMahd(maHd, 1);
            btnInHoaDon.setEnabled(true);
//            select cart by mah
            List<CartModel> carts = sanPhamService.selectSpByMahd(maHd);
            if (carts.size() > 0) {
                carts.forEach(cart -> {
//                    lấy danh sách imei by masp
                    List<DalImeiModel> dalImeiModels = BusImeiService.getImeisByMactspAndMahd(cart.getMactsp(), maHd);
                    cart.setListImeis(dalImeiModels);
                    cart.setTongTienHang(dalImeiModels.size() * cart.getGia());
                    BusVoucherModel busVoucherModel;
//                            lấy voucher đã lưu của sản phẩm trong db
                    busVoucherModel = voucherService.selectVoucherByMaImei(dalImeiModels.get(0).getMaSpSale());
                    if (busVoucherModel == null) {
                        cart.setTongTien(cart.getTongTienHang());
                        cart.getListImeis().forEach(imei -> {
                            imei.setMaSpSale(0);
                        });
                        cart.setSoLuongGiam(0);
                        cart.setGiamTheoTien(true);
                    } else {
                        float tongTienSauSale;
                        if (busVoucherModel.getLoaiGG() == 1) {
                            tongTienSauSale = cart.getTongTienHang() - ((cart.getGia() * busVoucherModel.getMucGG() / 100) * cart.getListImeis().size());
                        } else {
                            tongTienSauSale = cart.getTongTienHang() - (busVoucherModel.getMucGG() * cart.getListImeis().size());
                        }
                        cart.setSoLuongGiam(busVoucherModel.getMucGG());
                        cart.setGiamTheoTien(busVoucherModel.getLoaiGG() == 0);
                        cart.setTongTien(tongTienSauSale);
                    }
                    listCart.add(cart);
                });
            }
            totalMoney = currentHoaDonSelected.getTongTien();
            fillToCart(cartModel, tblCart);

            cboKhachHang.getModel().setSelectedItem(
                    listKhachHang.
                            stream().
                            filter(kh -> kh.getMaKH() == currentHoaDonSelected.getKhachHangModel().getMaKH())
                            .toList()
                            .get(0));
            txtNhanVien.setText(currentHoaDonSelected.getNhanVienModel().getMaNV());
            txtGhiChu.setText(currentHoaDonSelected.getGhiChu());
//            currentHoaDonSelected = hoaDon.getMahd();
            phiShip = currentHoaDonSelected.getPhiVanChuyen();
            khachThanhToan = currentHoaDonSelected.getTienKhachTra();

            txtTienShip.setText(new BigDecimal(currentHoaDonSelected.getPhiVanChuyen()) + "");
            txtKhachThanhToan.setText(new BigDecimal(currentHoaDonSelected.getTienKhachTra()) + "");
//            getPhiShip();
            cboGiamGia.setSelectedIndex(0);
            if (listVoucher.size() > 0) {
                for (BusVoucherModel voucher : listVoucher) {
                    if (voucher.getMaKM() == currentHoaDonSelected.getMakm()) {
                        cboGiamGia.setSelectedIndex(listVoucher.indexOf(voucher) + 1);
//                        cboGiamGia.getModel().setSelectedItem(voucher);
                        break;
                    }
                }
            }
            setTienThanhToan();
            if (currentHoaDonSelected.getPhiVanChuyen() > 0) {
                rdoShipHang.setSelected(true);
                txtDiahChiKh.setEditable(true);
                txtDiahChiKh.setText(currentHoaDonSelected.getDiaChiNhanHang());
            } else {
                rdoKhongGiao.setSelected(true);
            }
        } catch (Exception e) {
        }
    }

    void removeCart() {
        int rowCart = tblCart.getSelectedRow();
        CartModel cart = listCart.get(rowCart);
        new RemoveImeiHoaDon(cart, rowCart, isEditting).setVisible(true);
    }

    private void buttonAdd() {
        Action add = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboKhachHang.getSelectedItem() == null || cboKhachHang.getSelectedItem().equals("")) {
                    MessageService.alert(rootPane, "Vui lòng chọn khách hàng trước khi thêm sản phẩm");
                } else {
                    addToCart();
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tblSanPham, add, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    private void buttonRemoveHoaDon() {
        Action add = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblHoaDon.getSelectedRow();
                int mahd = (int) tblHoaDon.getValueAt(row, 0);
                if (cboSelected == 3) {
                    if (MessageService.confirm(rootPane, "Bạn có muốn khôi phục hóa đơn này không ?")) {
                        hoaDonService.updateStatus(1, mahd, "");
                        MessageService.alert(rootPane, "Khôi phục hóa đơn thành công");
                    }
                } else {
                    if (MessageService.confirm(rootPane, "Bạn có muốn xóa hóa đơn này không ?")) {
                        hoaDonService.updateStatus(0, mahd, "");
                        MessageService.alert(rootPane, "Xóa hóa đơn thành công");
                    }
                }
                fillButtonHoaDonTreo();
                clearHoaDon(false);
                getDataHoaDon(cboSelected);
                fillTableHoaDon(hoaDonModel, tblHoaDon, listHoaDon);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tblHoaDon, add, 8);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    private void buttonRemove() {
        Action remove = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCart();
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblCart, remove, 7);

        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    void removeAllImei() {
        if (listCart.size() > 0) {
            listCart.stream().filter(cart -> (cart.getListImeis().size() > 0)).forEachOrdered(cart -> {
                cart.getListImeis().forEach(imei -> {
                    BusImeiService.updateStatusSell(imei.getMaImei(), 1);
                });
            });
        }
        listCart.clear();
    }

    void clearHoaDon(boolean isNotFillHoaDon) {
        rdoChuaGiao.setEnabled(true);
        rdoGiaoThanhCong.setEnabled(true);
        isEditting = false;
//        removeAllImei();
        cboKhachHang.getModel().setSelectedItem(null);
        txtDiahChiKh.setText("");
        txtGhiChu.setText("");
        txtNgayGiaoHang.setDate(currentDate);
        txtKhachThanhToan.setText("");
        txtTienShip.setText("");
        phiShip = 0;
        totalMoney = 0;
        khachThanhToan = 0;
        setTienThanhToan();
        QuanLyBanHang.listCart.clear();
        QuanLyBanHang.fillToCart(cartModel, tblCart);
        if (isNotFillHoaDon) {
            currentHoaDonSelected = new BusHoaDon();
            btnInHoaDon.setEnabled(false);
            currentMahd = -1;
            this.getProductData();
            fillTable(QuanLyBanHang.listSp);
        } else {
            int filter = cboPhanLoai.getSelectedIndex();
            this.getDataHoaDon(filter);
            fillTableHoaDon(hoaDonModel, tblHoaDon, listHoaDon);
        }
        cboGiamGia.setSelectedIndex(0);
    }

    public void updateSoLuongGiam() {
        if (listCart.size() > 0) {
            listCart.forEach(ca -> {

            });
        }
    }

    boolean validateForm() {
        if (cboKhachHang.getSelectedItem() == null || cboKhachHang.getSelectedItem().equals("")) {
            MessageService.alert(rootPane, "Vui lòng chọn khách hàng");
            return false;
        }
        if (listCart.size() <= 0) {
            MessageService.alert(rootPane, "Vui lòng thêm sản phẩm vào đơn hàng");
            return false;
        }
        try {
            if (txtKhachThanhToan.getText().isBlank() || txtKhachThanhToan.getText().isEmpty()) {
                MessageService.alert(rootPane, "Vui lòng nhập tiền khách đưa");
                return false;
            }
            float khachDuaTien = Float.parseFloat(txtKhachThanhToan.getText());
            if (khachDuaTien < 0) {
                MessageService.alert(rootPane, "Vui lòng nhập số tiền khách đưa lớn hơn 0");
                return false;
            }
        } catch (NumberFormatException e) {
            MessageService.alert(rootPane, "Nhập số tiền khách đưa bằng số");
            return false;
        }
        if (rdoShipHang.isSelected()) {
            if (txtDiahChiKh.getText().isBlank() || txtDiahChiKh.getText().isEmpty()) {
                MessageService.alert(rootPane, "Vui lòng nhập địa chỉ giao hàng");
                return false;
            }
            try {
                if (txtTienShip.getText().isBlank() || txtTienShip.getText().isEmpty()) {
                    MessageService.alert(rootPane, "Vui lòng nhập phí vận chuyển");
                    return false;
                }
                float khachDuaTien = Float.parseFloat(txtTienShip.getText());
                if (khachDuaTien < 0) {
                    MessageService.alert(rootPane, "Vui lòng nhập phí vận chuyển lớn hơn 0");
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageService.alert(rootPane, "Nhập phí vận chuyển bằng số");
                return false;
            }
            Date ngayGiaoHang = DateService.toDate(DateService.toString(txtNgayGiaoHang.getDate(), "dd/MM/yyyy"), "dd/MM/yyyy");
            long diff = currentDate.getTime() - ngayGiaoHang.getTime();
            int khoangNgay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (rdoDangGiao.isSelected() || rdoGiaoThanhCong.isSelected()) {
                if (khoangNgay < 0) {
                    MessageService.alert(rootPane, "Vui lòng chọn ngày giao hàng trước hoặc ngày hiện tại nếu bạn chọn" + (rdoChuaGiao.isSelected() ? " chưa giao" : " giao thành công"));
                    return false;
                }
            }
            if (rdoChuaGiao.isSelected()) {
                if (khoangNgay >= 0) {
                    MessageService.alert(rootPane, "Vui lòng chọn ngày giao hàng sau ngày hiện nếu bạn bạn chọn chưa giao");
                    return false;
                }
            }
        }
        return true;
    }

    void showTopupSelectGiamGia() {
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem selectGG = new JMenuItem("Chọn voucher giảm giá cho sản phẩm");
        selectGG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblCart.getSelectedRow();
                if (row < 0) {
                    MessageService.alert(rootPane, "Vui lòng chọn sản phẩm trên bảng đơn hàng");
                } else {
                    int mactsp = (int) tblCart.getValueAt(row, 0);
                    new SelectVoucherGG(mactsp).setVisible(true);
                }
            }
        });
        popupMenu.add(selectGG);
        tblCart.setComponentPopupMenu(popupMenu);
    }

    public void addTableHeader() {
        modelSp = (DefaultTableModel) tblSanPham.getModel();
        cartModel = (DefaultTableModel) tblCart.getModel();
        tblSanPham.setFillsViewportHeight(true);
        tblSanPham.getColumn("Ảnh").setCellRenderer(new CellRenderer());
        tblCart.setFillsViewportHeight(true);
        tblCart.getColumn("Ảnh").setCellRenderer(new CellRenderer());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAscen;
    private javax.swing.JButton btnDesc;
    public static javax.swing.JButton btnInHoaDon;
    public static javax.swing.JButton btnLuuHoaDon;
    private javax.swing.JButton btnNewReceip2;
    private javax.swing.JButton btnSwichDanhsach;
    public static javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public static javax.swing.JComboBox<String> cboGiamGia;
    private javax.swing.JComboBox<String> cboKhachHang;
    public static javax.swing.JComboBox<String> cboPhanLoai;
    private javax.swing.JButton editKhachHang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnHoaDOn;
    private javax.swing.JPanel jpnHoaDonTreo;
    private javax.swing.JPanel jpnSanPham;
    public static javax.swing.JLabel lblGiamGia;
    public static javax.swing.JLabel lblKhachCanTra;
    private javax.swing.JLabel lblPhanLoai;
    public static javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTimKiem;
    public static javax.swing.JLabel lblTongTien;
    public static javax.swing.JRadioButton rdoChuaGiao;
    private javax.swing.JRadioButton rdoDangGiao;
    public static javax.swing.JRadioButton rdoGiaoThanhCong;
    private javax.swing.JRadioButton rdoKhongGiao;
    public static javax.swing.JRadioButton rdoShipHang;
    public static javax.swing.JTable tblCart;
    public static javax.swing.JTable tblHoaDon;
    public static javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtDiahChiKh;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtKhachThanhToan;
    private com.toedter.calendar.JDateChooser txtNgayGiaoHang;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSearchBox;
    public static javax.swing.JTextField txtTienShip;
    // End of variables declaration//GEN-END:variables
void sortDesc() {
        Collections.sort(QuanLyBanHang.listSp, comparator);
        fillTable(QuanLyBanHang.listSp);
    }

    void sortAsend() {
        Collections.sort(QuanLyBanHang.listSp, comparator);
        Collections.reverse(QuanLyBanHang.listSp);
        fillTable(QuanLyBanHang.listSp);
    }

    void fillToComboKhachHang() {
        khachHangModel = (DefaultComboBoxModel) cboKhachHang.getModel();
        khachHangModel.removeAllElements();
        try {
            listKhachHang = khachHangService.selectToFillCombo();
            listKhachHang.forEach(kh -> {
                khachHangModel.addElement(kh);
            });
            cboKhachHang.getModel().setSelectedItem(null);
        } catch (Exception e) {
        }
    }

    void printHoaDon() {
        FirstPdf expPdf = new FirstPdf();
        try {
            KhachHangModel khachHang = (KhachHangModel) cboKhachHang.getSelectedItem();
            String diaChiNhanHang = txtDiahChiKh.getText();
            expPdf.exportFile(khachHang, phiShip, khachThanhToan, diaChiNhanHang, listCart);
            MessageService.alert(rootPane, "In thành công");
        } catch (Exception e) {
            MessageService.alert(rootPane, "Lỗi in hóa đơn");
        }
    }

    class CellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            TableColumn tb = tblSanPham.getColumn("Ảnh");
            tb.setMaxWidth(60);
            tb.setMinWidth(60);
            tblSanPham.setRowHeight(60);

            TableColumn cart = tblCart.getColumn("Ảnh");
            cart.setMaxWidth(60);
            cart.setMinWidth(60);
            tblCart.setRowHeight(60);
            return (Component) value;
        }

    }
}
