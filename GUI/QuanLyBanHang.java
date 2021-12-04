// cập nhập tồn kho sau khi xóa back up
// sửa hóa đơn trả hàng
// in hóa đơn
// xuất file excel
package GUI;

import BUS.Models.BusCTSanPhamModel;
import BUS.Models.BusHoaDon;
import BUS.Models.BusPhanLoaiSpModel;
import BUS.Models.KhachHangModel;
import BUS.Services.BusImeiService;
import BUS.Services.BusPhanLoaiSpService;
import BUS.Services.CTHoaDonService;
import BUS.Services.HoaDonService;
import BUS.Services.KhachHangService;
import BUS.Services.SanPhamService;
import DAL.Models.DalChiTietHoaDon;
import DAL.Models.DalHoaDon;
import DAL.Models.DalImeiModel;
import static GUI.Main.jDesktopPane1;
import GUI.Models.CartModel;
import GUI.Services.AuthService;
import GUI.Services.ButtonColumn;
import GUI.Services.DateService;
import GUI.Services.MessageService;
import GUI.Services.UtilityService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.IconView;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class QuanLyBanHang extends javax.swing.JInternalFrame {

    Comparator<BusCTSanPhamModel> comparator = Comparator.comparing(BusCTSanPhamModel::getGiaBan);
    public static List<BusCTSanPhamModel> listSp = new ArrayList<>();
    List<BusHoaDon> listHoaDon = new ArrayList<>();
    SanPhamService sanPhamService = new SanPhamService();
    public static List<CartModel> listCart = new ArrayList<>();
    List<KhachHangModel> listKhachHang = new ArrayList<>();
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
    float hoaDonTong;
    int currentId;
    Icon iconAddToCart = new ImageIcon(getClass().getResource("/icon/add-cart (3).png"));
    Icon iconBackUp = new ImageIcon(getClass().getResource("/icon/curve-arrow.png"));
    Icon iconDelete = new ImageIcon(getClass().getResource("/icon/bin.png"));
    Icon iconView = new ImageIcon(getClass().getResource("/icon/view.png"));
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
        this.init();
    }

   
    public void desginTable() {
        tblCart.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
       tblCart.getTableHeader().setOpaque(false);
        tblCart.getTableHeader().setBackground(new Color(25, 29, 74));
        tblCart.getTableHeader().setForeground(Color.WHITE);
        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
     
         tblHoaDon.getTableHeader().setOpaque(false);
        tblHoaDon.getTableHeader().setBackground(new Color(25, 29, 74));
       tblHoaDon.getTableHeader().setForeground(Color.WHITE);
       tblSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
     
          tblSanPham.getTableHeader().setOpaque(false);
           tblSanPham.getTableHeader().setBackground(new Color(25, 29, 74));
        tblSanPham.getTableHeader().setForeground(Color.WHITE);
    }
    static void setTienThanhToan() {
        lblTongTien.setText("Tổng tiền hàng: " + UtilityService.toVnd(totalMoney));
        lblKhachCanTra.setText("Khách cần trả: " + UtilityService.toVnd(totalMoney + phiShip));
        if (khachThanhToan - (totalMoney + phiShip) >= 0) {
            lblTienThua.setText("Trả lại: " + UtilityService.toVnd(khachThanhToan - (totalMoney + phiShip)));
        } else {
            lblTienThua.setText("Thiếu: " + UtilityService.toVnd(totalMoney + phiShip - khachThanhToan));
        }
        if (khachThanhToan >= totalMoney + phiShip) {
            btnThanhToan.setEnabled(true);
            btnLuuHoaDon.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(false);
            btnLuuHoaDon.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnThanhToan = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
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
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jpnHoaDOn = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jpnSanPham = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnExportexcel = new javax.swing.JButton();
        btnAscen = new javax.swing.JButton();
        txtSearchBox = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNewReceip2 = new javax.swing.JButton();
        txtNhanVien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboPhanLoai = new javax.swing.JComboBox<>();
        lblPhanLoai = new javax.swing.JLabel();
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

        setBackground(new java.awt.Color(255, 255, 255));

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

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 51, 0));
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTongTien.setText("Tổng tiền hàng: 0 VNĐ");

        cboKhachHang.setBackground(new java.awt.Color(153, 153, 153));
        cboKhachHang.setEditable(true);
        cboKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboKhachHang.setForeground(new java.awt.Color(25, 29, 74));
        cboKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Khách hàng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Nhân viên");

        txtKhachThanhToan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtKhachThanhToan.setForeground(new java.awt.Color(25, 29, 74));
        txtKhachThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtKhachThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachThanhToanKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Địa chỉ nhận hàng");

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

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(25, 29, 74));
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        jScrollPane4.setViewportView(txtGhiChu);

        txtDiahChiKh.setEditable(false);
        txtDiahChiKh.setColumns(20);
        txtDiahChiKh.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtDiahChiKh.setForeground(new java.awt.Color(25, 29, 74));
        txtDiahChiKh.setRows(5);
        txtDiahChiKh.setText("Tại cửa hàng\n");
        txtDiahChiKh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        jScrollPane6.setViewportView(txtDiahChiKh);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaCTSP", "Ảnh", "Tên sản phẩm", "Giá", "SL", "Tổng tiền", "Imei"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            tblCart.getColumnModel().getColumn(3).setMinWidth(150);
            tblCart.getColumnModel().getColumn(3).setMaxWidth(150);
            tblCart.getColumnModel().getColumn(4).setMinWidth(50);
            tblCart.getColumnModel().getColumn(4).setMaxWidth(50);
            tblCart.getColumnModel().getColumn(5).setMinWidth(150);
            tblCart.getColumnModel().getColumn(5).setMaxWidth(150);
            tblCart.getColumnModel().getColumn(6).setMinWidth(60);
            tblCart.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnHoaDOn.setBackground(new java.awt.Color(255, 255, 255));
        jpnHoaDOn.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jpnHoaDOn.setForeground(new java.awt.Color(255, 255, 0));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mahd", "Manv", "Ten kh + st", "Ngay tao", "SL", "Phi ship", "Thanh tien", "Khach tra", ""
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
            tblHoaDon.getColumnModel().getColumn(5).setMinWidth(100);
            tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(100);
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
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        jpnHoaDOnLayout.setVerticalGroup(
            jpnHoaDOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        jpnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jpnSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));
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
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        btnExportexcel.setBackground(new java.awt.Color(25, 29, 74));
        btnExportexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        btnExportexcel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnExportexcel.setBorderPainted(false);
        btnExportexcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        txtSearchBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchBox.setForeground(new java.awt.Color(25, 29, 74));
        txtSearchBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyReleased(evt);
            }
        });

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(5, 10, 46));
        lblTimKiem.setText("Tìm kiếm sản phẩm");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 10, 46));
        jLabel9.setText("Ghi chú");

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

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNhanVien.setForeground(new java.awt.Color(25, 29, 74));
        txtNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(5, 10, 46));
        jLabel11.setText("Khách thanh toán");

        cboPhanLoai.setBackground(new java.awt.Color(153, 153, 153));
        cboPhanLoai.setEditable(true);
        cboPhanLoai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboPhanLoai.setForeground(new java.awt.Color(25, 29, 74));
        cboPhanLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        cboPhanLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhanLoaiItemStateChanged(evt);
            }
        });

        lblPhanLoai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPhanLoai.setForeground(new java.awt.Color(5, 10, 46));
        lblPhanLoai.setText("Phân Loại sản phẩm");

        jpnHoaDonTreo.setBackground(new java.awt.Color(204, 255, 255));
        jpnHoaDonTreo.setLayout(new java.awt.GridLayout(0, 1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(5, 10, 46));
        jLabel12.setText("Hóa đơn treo");

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

        rdoShipHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoShipHang);
        rdoShipHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoShipHang.setForeground(new java.awt.Color(25, 29, 74));
        rdoShipHang.setText("Ship hàng");

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(5, 10, 46));
        jLabel14.setText("Ngày giao hàng");

        txtNgayGiaoHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtNgayGiaoHang.setForeground(new java.awt.Color(25, 29, 74));
        txtNgayGiaoHang.setDateFormatString("dd/MM/yyyy");
        txtNgayGiaoHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNgayGiaoHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNgayGiaoHangKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(5, 10, 46));
        jLabel15.setText("Phí vận chuyển");

        btnSwichDanhsach.setBackground(new java.awt.Color(25, 29, 74));
        btnSwichDanhsach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        lblTienThua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(5, 10, 46));
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTienThua.setText("Tiền thừa: ");

        lblKhachCanTra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblKhachCanTra.setForeground(new java.awt.Color(255, 51, 0));
        lblKhachCanTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKhachCanTra.setText("Khách cần trả: 0 VNĐ");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 10, 46));
        jLabel7.setText("Trạng thái GH");

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

        rdoChuaGiao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoChuaGiao);
        rdoChuaGiao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoChuaGiao.setForeground(new java.awt.Color(25, 29, 74));
        rdoChuaGiao.setText("Chưa giao");

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
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAscen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExportexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhanLoai)
                            .addComponent(cboPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTimKiem)
                            .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnHoaDOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoKhongGiao)
                                    .addGap(3, 3, 3)
                                    .addComponent(rdoShipHang))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSwichDanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(55, 55, 55)
                                            .addComponent(cboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(editKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(rdoDangGiao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoChuaGiao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoGiaoThanhCong))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnNewReceip2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnHoaDonTreo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane4, jScrollPane6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtKhachThanhToan, txtTienShip});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExportexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAscen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cboPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnHoaDOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnHoaDonTreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSwichDanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(cboKhachHang))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(rdoKhongGiao)
                                            .addComponent(rdoShipHang))
                                        .addGap(11, 11, 11)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel14))
                                    .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoDangGiao)
                                    .addComponent(jLabel7)
                                    .addComponent(rdoChuaGiao)
                                    .addComponent(rdoGiaoThanhCong))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(lblTongTien)
                                .addGap(8, 8, 8)
                                .addComponent(lblKhachCanTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTienThua)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNewReceip2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtKhachThanhToan, txtNgayGiaoHang, txtTienShip});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (MessageService.confirm(rootPane, "Ban muon thanh toan hoa don nay ko")) {
            if (isEditting) {
                this.update(false);
            } else {
                this.insert(false);
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void editKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKhachHangActionPerformed
        removeAllImei();
//        QuanLyKhachHang kh = new QuanLyKhachHang();
//        MainThuNghiem.dashboardview.removeAll();
//        MainThuNghiem.dashboardview.add(kh).setVisible(true);
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
        this.clearHoaDon();
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
            } else {
                cboSelected = cboPhanLoai.getSelectedIndex();
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
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            txtDiahChiKh.setEditable(true);
            txtDiahChiKh.setText("");
            txtTienShip.setEditable(true);
            rdoDangGiao.setSelected(true);
        }
    }//GEN-LAST:event_rdoKhongGiaoItemStateChanged

    private void btnSwichDanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwichDanhsachActionPerformed
        this.isDsHoaDon = !this.isDsHoaDon;
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
        if (MessageService.confirm(rootPane, "Ban muon luu hoa don nay ko")) {
            if (isEditting) {
                this.update(true);
            } else {
                this.insert(true);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void rdoGiaoThanhCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGiaoThanhCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoGiaoThanhCongActionPerformed
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
    DefaultComboBoxModel<BusPhanLoaiSpModel> phanLoaiModel;
    String regex_float = "[+-]?([0-9]*[.])?[0-9]+";
    boolean isFirst;

    void init() {
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
       
        btnExportexcel.hide();
        jpnHoaDOn.hide();
        setTienThanhToan();
        txtNgayGiaoHang.setDate(currentDate);
    }
    boolean isDsHoaDon = false;
    int cboSelected;

    void showDanhSachHoaDon() {
        lblTimKiem.setText("Tìm kiếm hóa đơn");
        lblPhanLoai.setText("Tình trạng hóa đơn");
        btnSwichDanhsach.setText("Danh sách sản phẩm");
        tblSanPham.hide();
        btnAscen.hide();
        btnDesc.hide();
        btnExportexcel.show();
        jpnSanPham.hide();
        jpnHoaDOn.show();
        this.getDataHoaDon(0);
        cboPhanLoai.removeAllItems();
        cboPhanLoai.addItem("Tất cả");
        cboPhanLoai.addItem("Đã thanh toán");
        cboPhanLoai.addItem("Chưa thanh toán");
        cboPhanLoai.addItem("Đã xóa");
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
        btnExportexcel.hide();
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
            MessageService.alert(this, "Lỗi lấy phân loại sản phẩm");
        }
    }
    void getProductData() {
        String keyWord = txtSearchBox.getText();
        try {
            QuanLyBanHang.listSp = sanPhamService.selectBySearch(1, keyWord);

        } catch (Exception e) {
            MessageService.alert(this, "Lỗi get data");
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
                "Thêm"
            });
        });
    }

    void addToCart() {
        int rowSelected = tblSanPham.getSelectedRow();
        BusCTSanPhamModel busCTSanPhamModel = QuanLyBanHang.listSp.get(rowSelected);
        if (busCTSanPhamModel.getTonKho() > 0) {
            new SelectImei(busCTSanPhamModel).setVisible(true);
        } else {
            MessageService.alert(this, "Sản phẩm này hết đã hết hàng vui lòng chọn sản phẩm khác");
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
//                lblTongTien.setText("Tổng tiền: " + UtilityService.toVnd(totalMoney));
            }
            if (listCart.size() > 0) {
                for (CartModel ca : listCart) {
                    totalMoney += ca.getGia() * ca.getListImeis().size();
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
                        ca.getListImeis().size(),
                        UtilityService.toVnd(Float.parseFloat(ca.getListImeis().size() + "") * ca.getGia()),
                        "Xem"
                    });
                }
                getPhiShip();
//                lblTongTien.setText("Tổng tiền: " + UtilityService.toVnd(totalMoney));
            }
        }
    }

    void delete() {
        int idcthd = (int) tblHoaDon.getValueAt(rowHoaDon, 0);
        try {
            cTHoaDonService.delete(idcthd);
            MessageService.alert(this, "yeaehhhh");
        } catch (Exception e) {
            MessageService.alert(this, "loi xoa");
        }
    }
    Date currentDate = new Date();
    void update(boolean isSave) {
        try {
            DalHoaDon dalHoaDon = this.getFormHoaDon();
            if(!isSave) {
                dalHoaDon.setNgayThanhToan(currentDate);
                dalHoaDon.setTienKhachTra(phiShip + totalMoney);
            } else {
                dalHoaDon.setNgayThanhToan(currentHoaDonSelected.getNgayThanhToan());
            }
            hoaDonService.update(dalHoaDon);
            clearHoaDon();
            fillButtonHoaDonTreo();
            MessageService.alert(rootPane, "ok");
        } catch (Exception e) {
            MessageService.alert(rootPane, "error");
        }
    }

    void insert(boolean isSave) {

        DalHoaDon dalHoaDon = this.getFormHoaDon();
        if (!isSave) {
            dalHoaDon.setNgayThanhToan(currentDate);
            dalHoaDon.setTienKhachTra(phiShip + totalMoney);
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
                        dalChiTietHoaDon.setGiaBanSauSale(ca.getGia());
                        try {
                            cTHoaDonService.insert(dalChiTietHoaDon);
                            BusImeiService.updateStatusSell(imei.getMaImei(), 0);
//                            0: Đã bán
//                            1: Chưa bán
                        } catch (Exception e) {
                            System.out.println("error insert" + ca.getMactsp());
                        }
                    }
                    BusCTSanPhamModel sp = QuanLyBanHang.listSp.stream().filter(s -> s.getMaCTSP() == ca.getMactsp()).toList().get(0);
//                    cập nhật lại stock của ctsanpham
                    sanPhamService.updateStock(ca.getMactsp(), sp.getTonKho());
                });
                this.clearHoaDon();
//                this.getDataHoaDon();
fillButtonHoaDonTreo();
                MessageService.alert(this, "Thêm hóa đơn thành công");
            }
        } catch (Exception e) {
            MessageService.alert(rootPane, "Thêm hóa đơn không thành công");
        }
    }

    public DalHoaDon getFormHoaDon() {
        DalHoaDon dalHoaDon = new DalHoaDon();
        KhachHangModel kh = (KhachHangModel) cboKhachHang.getSelectedItem();
        dalHoaDon.setMakh(kh.getMaKH());
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
        dalHoaDon.setTongTien(totalMoney);
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
        if(isEditting) {
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
        }
    }
    BusHoaDon currentHoaDonSelected;
    boolean isEditting = false;

    void setFormHoaDon(int maHd) {
        isEditting = true;
        removeAllImei();
        try {
//            select by mahd
            currentHoaDonSelected = hoaDonService.selectByMahd(maHd, 1);
//            select cart by mah
            List<CartModel> carts = sanPhamService.selectSpByMahd(maHd);
            if (carts.size() > 0) {
                carts.forEach(cart -> {
                    List<DalImeiModel> dalImeiModels = BusImeiService.getImeisByMactspAndMahd(cart.getMactsp(), maHd);
                    cart.setListImeis(dalImeiModels);
                    listCart.add(cart);
                });
            }
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
            txtDiahChiKh.setText(currentHoaDonSelected.getDiaChiNhanHang());
            if (currentHoaDonSelected.getPhiVanChuyen() > 0) {
                rdoShipHang.setSelected(true);
            } else {
                rdoKhongGiao.setSelected(true);
            }
            phiShip = currentHoaDonSelected.getPhiVanChuyen();
            khachThanhToan = currentHoaDonSelected.getTienKhachTra();
            totalMoney = currentHoaDonSelected.getTongTien();
            txtTienShip.setText(currentHoaDonSelected.getPhiVanChuyen() + "");
            txtKhachThanhToan.setText(currentHoaDonSelected.getTienKhachTra() + "");
//            getPhiShip();
            setTienThanhToan();
        } catch (Exception e) {
        }
    }

    void removeCart() {
        int rowCart = tblCart.getSelectedRow();
        CartModel cart = listCart.get(rowCart);
        new RemoveImeiHoaDon(cart, rowCart).setVisible(true);
    }

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

    private void buttonAdd() {
        Action add = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
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
                currentMahd = (int) tblHoaDon.getValueAt(row, 0);
                if (cboSelected == 3) {
                    if (MessageService.confirm(null, "Co muon khoi phuc hoa don ko")) {
                        hoaDonService.updateStatus(1, currentMahd);
                        MessageService.alert(null, "back up  ok");
                    }
                } else {
                    if (MessageService.confirm(null, "Co muon xoa hoa don ko")) {
                        hoaDonService.updateStatus(0, currentMahd);
                        MessageService.alert(null, "Xoa ok");
                    }
                }
                fillButtonHoaDonTreo();
                clearHoaDon();
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

        ButtonColumn buttonColumn = new ButtonColumn(tblCart, remove, 6);

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

    void clearHoaDon() {
        currentHoaDonSelected = new BusHoaDon();
        currentMahd = -1;
        isEditting = false;
        removeAllImei();
        cboKhachHang.getModel().setSelectedItem(null);
        txtDiahChiKh.setText("");
        txtGhiChu.setText("");
        currentMahd = -1;
        txtNgayGiaoHang.setDate(currentDate);
        txtKhachThanhToan.setText("");
        txtTienShip.setText("");
        phiShip = 0;
        totalMoney = 0;
        khachThanhToan = 0;
        setTienThanhToan();
        QuanLyBanHang.listCart.clear();
        QuanLyBanHang.fillToCart(cartModel, tblCart);
        this.getProductData();
        fillTable(QuanLyBanHang.listSp);
    }

    public void addTableHeader() {
        modelSp = (DefaultTableModel) tblSanPham.getModel();
        cartModel = (DefaultTableModel) tblCart.getModel();
        tblSanPham.setFillsViewportHeight(true);
        tblSanPham.getColumn("Ảnh").setCellRenderer(new CellRenderer());
        tblCart.setFillsViewportHeight(true);
        tblCart.getColumn("Ảnh").setCellRenderer(new CellRenderer());
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAscen;
    private javax.swing.JButton btnDesc;
    private javax.swing.JButton btnExportexcel;
    public static javax.swing.JButton btnInHoaDon;
    public static javax.swing.JButton btnLuuHoaDon;
    private javax.swing.JButton btnNewReceip2;
    private javax.swing.JButton btnSwichDanhsach;
    public static javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboKhachHang;
    public static javax.swing.JComboBox<String> cboPhanLoai;
    private javax.swing.JButton editKhachHang;
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
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnHoaDOn;
    private javax.swing.JPanel jpnHoaDonTreo;
    private javax.swing.JPanel jpnSanPham;
    public static javax.swing.JLabel lblKhachCanTra;
    private javax.swing.JLabel lblPhanLoai;
    public static javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTimKiem;
    public static javax.swing.JLabel lblTongTien;
    private javax.swing.JRadioButton rdoChuaGiao;
    private javax.swing.JRadioButton rdoDangGiao;
    private javax.swing.JRadioButton rdoGiaoThanhCong;
    private javax.swing.JRadioButton rdoKhongGiao;
    private javax.swing.JRadioButton rdoShipHang;
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

}
