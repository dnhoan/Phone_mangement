/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Services.AuthService;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author DUCNAM
 */
public class MainThuNghiem extends javax.swing.JFrame {

    boolean a = false;
    boolean b = false;

    int xMouse, yMouse;

    /**
     * Creates new form MainThuNghiem
     */
    public MainThuNghiem() {
        initComponents();
        changeLAFI("Windows");
        init();
        FlatLightLaf.setup();
        setIconImage(ImageService.getAppIcon());
    }

    public static void changeLAFI(String nameLAFI) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (nameLAFI.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    FlatLightLaf.setup();
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }

    public void changeColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }

    public void clickMenu(JPanel pnl, JPanel pnl2, int number) {
        if (number == 1) {
            pnl.setBackground(new Color(25, 29, 74));
            pnl2.setBackground(new Color(5, 10, 46));
        } else {
            pnl.setBackground(new Color(5, 10, 46));
            pnl2.setBackground(new Color(25, 29, 74));
        }
    }

    public void showHide(JPanel showhide, boolean viewdashboard) {
        if (viewdashboard == true) {
            showhide.setPreferredSize(new Dimension(50, showhide.getHeight()));
        } else {
            showhide.setPreferredSize(new Dimension(270, showhide.getHeight()));
        }
    }

    public void openHome() {

        Home home = new Home();
        dashboardview.removeAll();
        dashboardview.add(home).setVisible(true);

    }

    public void openKhachHang() {

        if (AuthService.isLogin()) {
            QuanLyKhachHang kh = new QuanLyKhachHang();
            dashboardview.removeAll();
            dashboardview.add(kh).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập!");
        }

    }

    public void openHangHoa() {
        if (AuthService.isLogin()) {
            QuanLySanPham sp = new QuanLySanPham();
            dashboardview.removeAll();
            dashboardview.add(sp).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập!");
        }
    }

    public void openBanHang() {
        if (AuthService.isLogin()) {
            QuanLyBanHang gd = new QuanLyBanHang();
            dashboardview.removeAll();
            dashboardview.add(gd).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập!");
        }
    }

    public boolean openThongKe() {
        if (!AuthService.isLogin()) {
            MessageService.alert(this, "Vui lòng đăng nhập!");
            return false;
        } else if (!AuthService.isManager()) {
            MessageService.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            return false;
        } else if (AuthService.isLogin()) {
            QlthongKe tk = new QlthongKe();
            dashboardview.removeAll();
            dashboardview.add(tk).setVisible(true);
        }
        return true;
    }

    public void openHoaDon() {
        if (AuthService.isLogin()) {
            QuanLyHoaDon hd = new QuanLyHoaDon();
            dashboardview.removeAll();
            dashboardview.add(hd).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập!");
        }
    }

    public boolean openNhanVien() {

        if (!AuthService.isLogin()) {
            MessageService.alert(this, "Vui lòng đăng nhập!");
            return false;
        } else if (!AuthService.isManager()) {
            MessageService.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            return false;
        } else if (AuthService.isLogin()) {
            QLnhanVien gd = new QLnhanVien();
            dashboardview.removeAll();
            dashboardview.add(gd).setVisible(true);
        }

        return true;
    }

    public boolean openGiamGia() {
        if (!AuthService.isLogin()) {
            MessageService.alert(this, "Vui lòng đăng nhập!");
            return false;
        } else if (!AuthService.isManager()) {
            MessageService.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            return false;
        } else if (AuthService.isLogin()) {
            QLGiamGia gg = new QLGiamGia();
            dashboardview.removeAll();
            dashboardview.add(gg).setVisible(true);
        }
        return true;
    }

    public void changeImage() {

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        pnlminmaxclose = new javax.swing.JPanel();
        pnlClose = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        pnlMaximum = new javax.swing.JPanel();
        maxsize = new javax.swing.JLabel();
        pnlMinimize = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnlMenuIcon = new javax.swing.JPanel();
        pnlhidemenu = new javax.swing.JPanel();
        pnlmenu = new javax.swing.JPanel();
        hidemenu = new javax.swing.JLabel();
        pnlsettings = new javax.swing.JPanel();
        hidesetting = new javax.swing.JLabel();
        pnlhidesetting = new javax.swing.JPanel();
        menuhide = new javax.swing.JPanel();
        jpnHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpnHangHoa = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpnBanHang = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jpnGiamGia = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        menuhide1 = new javax.swing.JPanel();
        jpnChangePass = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpnLogout = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dashboardview = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        pnlHeader.setBackground(new java.awt.Color(5, 0, 30));
        pnlHeader.setPreferredSize(new java.awt.Dimension(800, 50));
        pnlHeader.setLayout(new java.awt.BorderLayout());

        pnlminmaxclose.setBackground(new java.awt.Color(5, 0, 30));
        pnlminmaxclose.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlminmaxclose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlClose.setBackground(new java.awt.Color(5, 0, 30));
        pnlClose.setLayout(new java.awt.BorderLayout());

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        pnlClose.add(close, java.awt.BorderLayout.CENTER);

        pnlminmaxclose.add(pnlClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        pnlMaximum.setBackground(new java.awt.Color(5, 0, 30));
        pnlMaximum.setLayout(new java.awt.BorderLayout());

        maxsize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxsize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fullscreen.png"))); // NOI18N
        maxsize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maxsize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxsizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maxsizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maxsizeMouseExited(evt);
            }
        });
        pnlMaximum.add(maxsize, java.awt.BorderLayout.CENTER);

        pnlminmaxclose.add(pnlMaximum, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        pnlMinimize.setBackground(new java.awt.Color(5, 0, 30));
        pnlMinimize.setLayout(new java.awt.BorderLayout());

        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        pnlMinimize.add(minimize, java.awt.BorderLayout.CENTER);

        pnlminmaxclose.add(pnlMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        pnlHeader.add(pnlminmaxclose, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phần mềm quản lý cửa hàng bán điện thoại MobiMonster");
        pnlHeader.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logomobi.png"))); // NOI18N
        pnlHeader.add(jLabel2, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlMenu.setPreferredSize(new java.awt.Dimension(50, 450));
        pnlMenu.setLayout(new java.awt.BorderLayout());

        pnlMenuIcon.setBackground(new java.awt.Color(5, 10, 46));
        pnlMenuIcon.setPreferredSize(new java.awt.Dimension(50, 450));

        pnlhidemenu.setBackground(new java.awt.Color(5, 10, 46));

        javax.swing.GroupLayout pnlhidemenuLayout = new javax.swing.GroupLayout(pnlhidemenu);
        pnlhidemenu.setLayout(pnlhidemenuLayout);
        pnlhidemenuLayout.setHorizontalGroup(
            pnlhidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlhidemenuLayout.setVerticalGroup(
            pnlhidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlmenu.setBackground(new java.awt.Color(5, 10, 46));
        pnlmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hidemenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hidemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu1.png"))); // NOI18N
        hidemenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hidemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidemenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hidemenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hidemenuMouseExited(evt);
            }
        });
        pnlmenu.add(hidemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        pnlsettings.setBackground(new java.awt.Color(5, 10, 46));
        pnlsettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hidesetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hidesetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings.png"))); // NOI18N
        hidesetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hidesetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidesettingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hidesettingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hidesettingMouseExited(evt);
            }
        });
        pnlsettings.add(hidesetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        pnlhidesetting.setBackground(new java.awt.Color(5, 10, 46));
        pnlhidesetting.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout pnlhidesettingLayout = new javax.swing.GroupLayout(pnlhidesetting);
        pnlhidesetting.setLayout(pnlhidesettingLayout);
        pnlhidesettingLayout.setHorizontalGroup(
            pnlhidesettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlhidesettingLayout.setVerticalGroup(
            pnlhidesettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuIconLayout = new javax.swing.GroupLayout(pnlMenuIcon);
        pnlMenuIcon.setLayout(pnlMenuIconLayout);
        pnlMenuIconLayout.setHorizontalGroup(
            pnlMenuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuIconLayout.createSequentialGroup()
                .addGroup(pnlMenuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlhidesetting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(pnlhidemenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlsettings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(pnlmenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMenuIconLayout.setVerticalGroup(
            pnlMenuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuIconLayout.createSequentialGroup()
                .addGroup(pnlMenuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuIconLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(pnlhidesetting, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlhidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuIconLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(pnlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(pnlsettings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlMenuIcon, java.awt.BorderLayout.LINE_START);

        menuhide.setBackground(new java.awt.Color(25, 29, 74));
        menuhide.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuhide.setDoubleBuffered(false);
        menuhide.setPreferredSize(new java.awt.Dimension(220, 450));
        menuhide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnHome.setBackground(new java.awt.Color(25, 29, 74));
        jpnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnHome.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnHomeMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpnHomeMouseMoved(evt);
            }
        });
        jpnHome.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jpnHomeMouseWheelMoved(evt);
            }
        });
        jpnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnHomeMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Home");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home1.png"))); // NOI18N

        javax.swing.GroupLayout jpnHomeLayout = new javax.swing.GroupLayout(jpnHome);
        jpnHome.setLayout(jpnHomeLayout);
        jpnHomeLayout.setHorizontalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHomeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jpnHomeLayout.setVerticalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHomeLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        menuhide.add(jpnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 220, -1));

        jpnHangHoa.setBackground(new java.awt.Color(25, 29, 74));
        jpnHangHoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnHangHoa.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnHangHoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnHangHoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnHangHoaMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sản phẩm");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N

        javax.swing.GroupLayout jpnHangHoaLayout = new javax.swing.GroupLayout(jpnHangHoa);
        jpnHangHoa.setLayout(jpnHangHoaLayout);
        jpnHangHoaLayout.setHorizontalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHangHoaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jpnHangHoaLayout.setVerticalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHangHoaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        menuhide.add(jpnHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        jpnBanHang.setBackground(new java.awt.Color(25, 29, 74));
        jpnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnBanHang.setPreferredSize(new java.awt.Dimension(181, 70));
        jpnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnBanHangMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bán hàng");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cart.png"))); // NOI18N

        javax.swing.GroupLayout jpnBanHangLayout = new javax.swing.GroupLayout(jpnBanHang);
        jpnBanHang.setLayout(jpnBanHangLayout);
        jpnBanHangLayout.setHorizontalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jpnBanHangLayout.setVerticalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBanHangLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        menuhide.add(jpnBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 220, -1));

        jpnGiamGia.setBackground(new java.awt.Color(25, 29, 74));
        jpnGiamGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnGiamGia.setPreferredSize(new java.awt.Dimension(175, 70));
        jpnGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnGiamGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnGiamGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnGiamGiaMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Giảm giá");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sale.png"))); // NOI18N

        javax.swing.GroupLayout jpnGiamGiaLayout = new javax.swing.GroupLayout(jpnGiamGia);
        jpnGiamGia.setLayout(jpnGiamGiaLayout);
        jpnGiamGiaLayout.setHorizontalGroup(
            jpnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGiamGiaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jpnGiamGiaLayout.setVerticalGroup(
            jpnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGiamGiaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        menuhide.add(jpnGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 220, -1));

        jpnNhanVien.setBackground(new java.awt.Color(25, 29, 74));
        jpnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnNhanVienMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nhân viên");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        menuhide.add(jpnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 220, -1));

        jpnKhachHang.setBackground(new java.awt.Color(25, 29, 74));
        jpnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnKhachHang.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnKhachHangMouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Khách hàng");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/client.png"))); // NOI18N

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        menuhide.add(jpnKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 220, 70));

        jpnThongKe.setBackground(new java.awt.Color(25, 29, 74));
        jpnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnThongKe.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnThongKeMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Thống kê");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/stats.png"))); // NOI18N

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        menuhide.add(jpnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 220, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image (1).png"))); // NOI18N
        menuhide.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 220));

        jpnHoaDon.setBackground(new java.awt.Color(25, 29, 74));
        jpnHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnHoaDon.setPreferredSize(new java.awt.Dimension(175, 70));
        jpnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnHoaDonMouseExited(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Hóa đơn");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        menuhide.add(jpnHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 220, -1));

        pnlMenu.add(menuhide, java.awt.BorderLayout.CENTER);
        menuhide.getAccessibleContext().setAccessibleParent(pnlMenu);

        menuhide1.setBackground(new java.awt.Color(25, 29, 74));
        menuhide1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuhide1.setDoubleBuffered(false);
        menuhide1.setPreferredSize(new java.awt.Dimension(220, 200));
        menuhide1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnChangePass.setBackground(new java.awt.Color(25, 29, 74));
        jpnChangePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnChangePass.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnChangePass.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnChangePassMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpnChangePassMouseMoved(evt);
            }
        });
        jpnChangePass.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jpnChangePassMouseWheelMoved(evt);
            }
        });
        jpnChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnChangePassMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đổi mật khẩu");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/password.png"))); // NOI18N

        javax.swing.GroupLayout jpnChangePassLayout = new javax.swing.GroupLayout(jpnChangePass);
        jpnChangePass.setLayout(jpnChangePassLayout);
        jpnChangePassLayout.setHorizontalGroup(
            jpnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChangePassLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpnChangePassLayout.setVerticalGroup(
            jpnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnChangePassLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        menuhide1.add(jpnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 220, -1));

        jpnLogout.setBackground(new java.awt.Color(25, 29, 74));
        jpnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnLogout.setPreferredSize(new java.awt.Dimension(220, 70));
        jpnLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnLogoutMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpnLogoutMouseMoved(evt);
            }
        });
        jpnLogout.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jpnLogoutMouseWheelMoved(evt);
            }
        });
        jpnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnLogoutMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Đăng xuất");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N

        javax.swing.GroupLayout jpnLogoutLayout = new javax.swing.GroupLayout(jpnLogout);
        jpnLogout.setLayout(jpnLogoutLayout);
        jpnLogoutLayout.setHorizontalGroup(
            jpnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLogoutLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jpnLogoutLayout.setVerticalGroup(
            jpnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLogoutLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        menuhide1.add(jpnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, -1));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("???");
        lblName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblNameFocusGained(evt);
            }
        });
        lblName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lblNameComponentShown(evt);
            }
        });
        lblName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblNameInputMethodTextChanged(evt);
            }
        });
        lblName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblNamePropertyChange(evt);
            }
        });
        lblName.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                lblNameVetoableChange(evt);
            }
        });
        menuhide1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Hello,");
        menuhide1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, -1));

        pnlMenu.add(menuhide1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMenu, java.awt.BorderLayout.LINE_START);

        dashboardview.setLayout(new java.awt.BorderLayout());
        getContentPane().add(dashboardview, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1920, 1060));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        boolean chooser = MessageService.confirm(this, "Bạn có chắc chắn muốn thoát không ???");
        if (chooser == true) {
            System.exit(0);

        } else {
            return;
        }
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        changeColor(pnlClose, new Color(25, 29, 74));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        changeColor(pnlClose, new Color(5, 0, 30));
    }//GEN-LAST:event_closeMouseExited

    private void maxsizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxsizeMouseClicked
        if (this.getExtendedState() != MainThuNghiem.MAXIMIZED_BOTH) {
            this.setExtendedState(MainThuNghiem.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(MainThuNghiem.NORMAL);
        }
    }//GEN-LAST:event_maxsizeMouseClicked

    private void maxsizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxsizeMouseEntered
        changeColor(pnlMaximum, new Color(25, 29, 74));
    }//GEN-LAST:event_maxsizeMouseEntered

    private void maxsizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxsizeMouseExited
        changeColor(pnlMaximum, new Color(5, 0, 30));
    }//GEN-LAST:event_maxsizeMouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(MainThuNghiem.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        changeColor(pnlMinimize, new Color(5, 0, 30));
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        changeColor(pnlMinimize, new Color(25, 29, 74));
    }//GEN-LAST:event_minimizeMouseEntered

    private void hidemenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidemenuMouseExited
        changeColor(pnlhidemenu, new Color(5, 10, 46));
    }//GEN-LAST:event_hidemenuMouseExited

    private void hidemenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidemenuMouseEntered
        changeColor(pnlhidemenu, new Color(247, 78, 105));
    }//GEN-LAST:event_hidemenuMouseEntered

    private void hidemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidemenuMouseClicked

        clickMenu(pnlmenu, pnlsettings, 1);

        if (evt.getClickCount() == 1) {
            pnlMenu.add(menuhide);
            menuhide.setFocusable(true);
            pnlMenu.remove(menuhide1);
        }

        if (a == true) {
            showHide(pnlMenu, a);
            SwingUtilities.updateComponentTreeUI(pnlMenu);
            a = false;
        } else {
            showHide(pnlMenu, a);
            SwingUtilities.updateComponentTreeUI(pnlMenu);
            a = true;
        }

    }//GEN-LAST:event_hidemenuMouseClicked

    private void hidesettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidesettingMouseExited
        changeColor(pnlhidesetting, new Color(5, 10, 46));
    }//GEN-LAST:event_hidesettingMouseExited

    private void hidesettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidesettingMouseEntered
        changeColor(pnlhidesetting, new Color(247, 78, 105));
    }//GEN-LAST:event_hidesettingMouseEntered

    private void hidesettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidesettingMouseClicked
        clickMenu(pnlsettings, pnlmenu, 1);
        if (evt.getClickCount() == 1) {
            pnlMenu.add(menuhide1);
            menuhide1.setFocusable(true);
            pnlMenu.remove(menuhide);
        }

        if (a == true) {
            showHide(pnlMenu, a);
            SwingUtilities.updateComponentTreeUI(pnlMenu);
            a = false;

        } else {
            showHide(pnlMenu, a);
            SwingUtilities.updateComponentTreeUI(pnlMenu);
            a = true;

        }
    }//GEN-LAST:event_hidesettingMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        moveFrame(evt.getXOnScreen(), evt.getYOnScreen());
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMouseMoved

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized


    }//GEN-LAST:event_formComponentResized

    private void jpnHomeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseDragged

    }//GEN-LAST:event_jpnHomeMouseDragged

    private void jpnHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseMoved

    }//GEN-LAST:event_jpnHomeMouseMoved

    private void jpnHomeMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jpnHomeMouseWheelMoved

    }//GEN-LAST:event_jpnHomeMouseWheelMoved

    private void jpnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseClicked

        openHome();
    }//GEN-LAST:event_jpnHomeMouseClicked

    private void jpnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseEntered
        changeColor(jpnHome, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnHomeMouseEntered

    private void jpnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseExited
        changeColor(jpnHome, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnHomeMouseExited

    private void jpnHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseClicked

        openHangHoa();
    }//GEN-LAST:event_jpnHangHoaMouseClicked

    private void jpnHangHoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseEntered
        // TODO add your handling code here:
        changeColor(jpnHangHoa, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnHangHoaMouseEntered

    private void jpnHangHoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseExited
        // TODO add your handling code here:
        changeColor(jpnHangHoa, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnHangHoaMouseExited

    private void jpnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBanHangMouseClicked
        openBanHang();
    }//GEN-LAST:event_jpnBanHangMouseClicked

    private void jpnBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBanHangMouseEntered
        changeColor(jpnBanHang, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnBanHangMouseEntered

    private void jpnBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBanHangMouseExited
        changeColor(jpnBanHang, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnBanHangMouseExited

    private void jpnGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiamGiaMouseClicked
        openGiamGia();
    }//GEN-LAST:event_jpnGiamGiaMouseClicked

    private void jpnGiamGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiamGiaMouseEntered
        changeColor(jpnGiamGia, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnGiamGiaMouseEntered

    private void jpnGiamGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiamGiaMouseExited
        changeColor(jpnGiamGia, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnGiamGiaMouseExited

    private void jpnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseClicked
        openNhanVien();
    }//GEN-LAST:event_jpnNhanVienMouseClicked

    private void jpnNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseEntered
        changeColor(jpnNhanVien, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnNhanVienMouseEntered

    private void jpnNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseExited
        changeColor(jpnNhanVien, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnNhanVienMouseExited

    private void jpnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseClicked

        openKhachHang();
//         showHide(pnlMenu, a);
//  
//            a = false;
    }//GEN-LAST:event_jpnKhachHangMouseClicked

    private void jpnKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseEntered
        changeColor(jpnKhachHang, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnKhachHangMouseEntered

    private void jpnKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseExited
        changeColor(jpnKhachHang, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnKhachHangMouseExited

    private void jpnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseClicked
        openThongKe();
    }//GEN-LAST:event_jpnThongKeMouseClicked

    private void jpnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseEntered
        changeColor(jpnThongKe, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnThongKeMouseEntered

    private void jpnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseExited
        changeColor(jpnThongKe, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnThongKeMouseExited

    private void jpnChangePassMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChangePassMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChangePassMouseDragged

    private void jpnChangePassMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChangePassMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChangePassMouseMoved

    private void jpnChangePassMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jpnChangePassMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnChangePassMouseWheelMoved

    private void jpnChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChangePassMouseClicked
        if (AuthService.isLogin()) {
            new ChangePass(this, true).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập trước khi đổi mật khẩu");
        }
    }//GEN-LAST:event_jpnChangePassMouseClicked

    private void jpnChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChangePassMouseEntered
        changeColor(jpnChangePass, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnChangePassMouseEntered

    private void jpnChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnChangePassMouseExited
        changeColor(jpnChangePass, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnChangePassMouseExited

    private void jpnLogoutMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnLogoutMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnLogoutMouseDragged

    private void jpnLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnLogoutMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnLogoutMouseMoved

    private void jpnLogoutMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jpnLogoutMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnLogoutMouseWheelMoved

    private void jpnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnLogoutMouseClicked
        boolean chooser = MessageService.confirm(this, "Bạn muốn đăng xuất???");
        if (chooser == true) {
            AuthService.clear();
            setVisible(false);
            new Login(this, true).setVisible(true);

        } else {
            return;
        }

    }//GEN-LAST:event_jpnLogoutMouseClicked

    private void jpnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnLogoutMouseEntered
        changeColor(jpnLogout, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnLogoutMouseEntered

    private void jpnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnLogoutMouseExited
        changeColor(jpnLogout, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnLogoutMouseExited

    private void lblNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblNamePropertyChange
        if (AuthService.isLogin()) {
            lblName.setText(AuthService.user.getMaNV());
        } else {
            lblName.setText("???");
        }
    }//GEN-LAST:event_lblNamePropertyChange

    private void lblNameVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_lblNameVetoableChange

    }//GEN-LAST:event_lblNameVetoableChange

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void lblNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblNameInputMethodTextChanged

    }//GEN-LAST:event_lblNameInputMethodTextChanged

    private void lblNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblNameFocusGained

    }//GEN-LAST:event_lblNameFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown


    }//GEN-LAST:event_formComponentShown

    private void lblNameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lblNameComponentShown

    }//GEN-LAST:event_lblNameComponentShown

    private void jpnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHoaDonMouseClicked
        openHoaDon();
    }//GEN-LAST:event_jpnHoaDonMouseClicked

    private void jpnHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHoaDonMouseEntered
        changeColor(jpnHoaDon, new Color(25, 29, 150));
    }//GEN-LAST:event_jpnHoaDonMouseEntered

    private void jpnHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHoaDonMouseExited
        changeColor(jpnHoaDon, new Color(25, 29, 74));
    }//GEN-LAST:event_jpnHoaDonMouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        openThongKe();
    }//GEN-LAST:event_jLabel21MouseClicked

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
                    FlatLightLaf.setup(); //setting the look and feel
                    UIManager.put("TitlePane.background", new ColorUIResource(5, 10, 46));
                    UIManager.put("TitlePane.foreground", new ColorUIResource(255, 255, 255));
                    UIManager.put("TitlePane.buttonHoverBackground", new ColorUIResource(25, 29, 74));
                    UIManager.put("TitlePane.closeHoverBackground", new ColorUIResource(25, 29, 74));
                    UIManager.put("TitlePane.iconSize", new Dimension(20, 10));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainThuNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainThuNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainThuNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainThuNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainThuNghiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    public static javax.swing.JDesktopPane dashboardview;
    private javax.swing.JLabel hidemenu;
    private javax.swing.JLabel hidesetting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpnBanHang;
    private javax.swing.JPanel jpnChangePass;
    private javax.swing.JPanel jpnGiamGia;
    private javax.swing.JPanel jpnHangHoa;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnHome;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnLogout;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel maxsize;
    private javax.swing.JPanel menuhide;
    private javax.swing.JPanel menuhide1;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel pnlClose;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMaximum;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuIcon;
    private javax.swing.JPanel pnlMinimize;
    private javax.swing.JPanel pnlhidemenu;
    private javax.swing.JPanel pnlhidesetting;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JPanel pnlminmaxclose;
    private javax.swing.JPanel pnlsettings;
    // End of variables declaration//GEN-END:variables

    private void init() {
//        new Login(this, true).setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        openHome();

    }

    private void moveFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

}
