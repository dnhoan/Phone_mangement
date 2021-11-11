/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Animacion.Animacion;
import GUI.Home;
import GUI.QuanLySanPham;
import GUI.QuanLyKhachHang;
import GUI.Services.AuthService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DUCNAM
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        init();

    }

    public void setColor(JPanel p) {
        p.setBackground(new Color(255, 255, 102));
    }

    public void resetColor(JPanel p1) {
        p1.setBackground(new Color(255, 255, 255));
    }

    private void init() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int h = d.height;
        int w = d.width;
        this.setSize(w, h);
        new Login(this, true).setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);

        Home home = new Home();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(home).setVisible(true);
    }

    public void showPopUp(MouseEvent e) {
        PopMenu.show(this, e.getX(), e.getY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopMenu = new javax.swing.JPopupMenu();
        LogOut = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        bg = new javax.swing.JPanel();
        sidepanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpnHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpnHangHoa = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpnCauHinh = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jpnGiaoDich = new javax.swing.JPanel();
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
        btnMenu = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        LogOut.setText("Log out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        PopMenu.add(LogOut);

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit_1.png"))); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        PopMenu.add(Exit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepanel.setBackground(new java.awt.Color(255, 255, 102));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        sidepanel.setBorder(dropShadowBorder1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/output-onlinepngtools.png"))); // NOI18N

        jpnHome.setBackground(new java.awt.Color(255, 255, 102));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Home");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home1.png"))); // NOI18N

        javax.swing.GroupLayout jpnHomeLayout = new javax.swing.GroupLayout(jpnHome);
        jpnHome.setLayout(jpnHomeLayout);
        jpnHomeLayout.setHorizontalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jpnHomeLayout.setVerticalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHomeLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jpnHangHoa.setBackground(new java.awt.Color(255, 255, 102));
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
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Hàng hóa");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N

        javax.swing.GroupLayout jpnHangHoaLayout = new javax.swing.GroupLayout(jpnHangHoa);
        jpnHangHoa.setLayout(jpnHangHoaLayout);
        jpnHangHoaLayout.setHorizontalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jpnHangHoaLayout.setVerticalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHangHoaLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jpnCauHinh.setBackground(new java.awt.Color(255, 255, 102));
        jpnCauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnCauHinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnCauHinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnCauHinhMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Cấu hình");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/configuration.png"))); // NOI18N

        javax.swing.GroupLayout jpnCauHinhLayout = new javax.swing.GroupLayout(jpnCauHinh);
        jpnCauHinh.setLayout(jpnCauHinhLayout);
        jpnCauHinhLayout.setHorizontalGroup(
            jpnCauHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCauHinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jpnCauHinhLayout.setVerticalGroup(
            jpnCauHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCauHinhLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpnCauHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jpnGiaoDich.setBackground(new java.awt.Color(255, 255, 102));
        jpnGiaoDich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnGiaoDichMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnGiaoDichMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnGiaoDichMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Giao dịch");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/business-icon-asset-management-system-32.png"))); // NOI18N

        javax.swing.GroupLayout jpnGiaoDichLayout = new javax.swing.GroupLayout(jpnGiaoDich);
        jpnGiaoDich.setLayout(jpnGiaoDichLayout);
        jpnGiaoDichLayout.setHorizontalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGiaoDichLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jpnGiaoDichLayout.setVerticalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnGiaoDichLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jpnNhanVien.setBackground(new java.awt.Color(255, 255, 102));
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
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Nhân viên");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/users_team_icon_176932.png"))); // NOI18N

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jpnKhachHang.setBackground(new java.awt.Color(255, 255, 102));
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
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Khách hàng");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/client-6-32.png"))); // NOI18N

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(24, 24, 24))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jpnThongKe.setBackground(new java.awt.Color(255, 255, 102));
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
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Thống kê");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-stats.png"))); // NOI18N

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnCauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidepanelLayout.setVerticalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jpnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnCauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 190, 1060));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setDefaultCapable(false);
        btnMenu.setFocusable(false);
        btnMenu.setRequestFocusEnabled(false);
        btnMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        btnMenu.setVerifyInputWhenFocusTarget(false);
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        bg.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jDesktopPane1.setAutoscrolls(true);
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1670, 1080));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1670, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        bg.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1670, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseClicked
        Home home = new Home();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(home).setVisible(true);

    }//GEN-LAST:event_jpnHomeMouseClicked

    private void jpnHomeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseDragged

    }//GEN-LAST:event_jpnHomeMouseDragged

    private void jpnHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseMoved

    }//GEN-LAST:event_jpnHomeMouseMoved

    private void jpnHomeMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jpnHomeMouseWheelMoved

    }//GEN-LAST:event_jpnHomeMouseWheelMoved

    private void jpnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseExited
        setColor(jpnHome);
    }//GEN-LAST:event_jpnHomeMouseExited

    private void jpnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHomeMouseEntered
        resetColor(jpnHome);
    }//GEN-LAST:event_jpnHomeMouseEntered

    private void jpnHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseClicked
        // TODO add your handling code here:
//        QuanLyKhoJFrame sp = new QuanLyKhoJFrame();
        if (AuthService.isLogin()) {
            QuanLySanPham sp = new QuanLySanPham();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(sp).setVisible(true);
        } else {
            MessageService.alert(this, "Vui lòng đăng nhập!");
        }

    }//GEN-LAST:event_jpnHangHoaMouseClicked

    private void jpnHangHoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseEntered
        // TODO add your handling code here:
        resetColor(jpnHangHoa);
    }//GEN-LAST:event_jpnHangHoaMouseEntered

    private void jpnHangHoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHangHoaMouseExited
        // TODO add your handling code here:
        setColor(jpnHangHoa);
    }//GEN-LAST:event_jpnHangHoaMouseExited

    private void jpnCauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnCauHinhMouseClicked

    }//GEN-LAST:event_jpnCauHinhMouseClicked

    private void jpnCauHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnCauHinhMouseEntered
        resetColor(jpnCauHinh);
    }//GEN-LAST:event_jpnCauHinhMouseEntered

    private void jpnCauHinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnCauHinhMouseExited
        setColor(jpnCauHinh);
    }//GEN-LAST:event_jpnCauHinhMouseExited

    private void jpnGiaoDichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiaoDichMouseClicked

    }//GEN-LAST:event_jpnGiaoDichMouseClicked

    private void jpnGiaoDichMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiaoDichMouseEntered
        resetColor(jpnGiaoDich);
    }//GEN-LAST:event_jpnGiaoDichMouseEntered

    private void jpnGiaoDichMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnGiaoDichMouseExited
        setColor(jpnGiaoDich);
    }//GEN-LAST:event_jpnGiaoDichMouseExited

    private void jpnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnNhanVienMouseClicked

    private void jpnNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseEntered
        resetColor(jpnNhanVien);
    }//GEN-LAST:event_jpnNhanVienMouseEntered

    private void jpnNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseExited
        setColor(jpnNhanVien);
    }//GEN-LAST:event_jpnNhanVienMouseExited

    private void jpnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseClicked
        QuanLyKhachHang kh = new QuanLyKhachHang();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(kh).setVisible(true);
    }//GEN-LAST:event_jpnKhachHangMouseClicked

    private void jpnKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseEntered
        resetColor(jpnKhachHang);
    }//GEN-LAST:event_jpnKhachHangMouseEntered

    private void jpnKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseExited
        setColor(jpnKhachHang);
    }//GEN-LAST:event_jpnKhachHangMouseExited

    private void jpnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnThongKeMouseClicked

    private void jpnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseEntered
        resetColor(jpnThongKe);
    }//GEN-LAST:event_jpnThongKeMouseEntered

    private void jpnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseExited
        setColor(jpnThongKe);
    }//GEN-LAST:event_jpnThongKeMouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        int position = btnMenu.getX();

        if (position > 15) {
            Animacion.mover_izquierda(211, 10, 2, 2, btnMenu);
            Animacion.mover_izquierda(5, -200, 2, 2, sidepanel);

        } else {
            Animacion.mover_derecha(5, 205, 2, 2, btnMenu);
            Animacion.mover_derecha(-200, 5, 2, 2, sidepanel);

        }


    }//GEN-LAST:event_btnMenuMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt);
        }
    }//GEN-LAST:event_formMouseReleased

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int chooser = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thoát không ???", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (chooser == JOptionPane.YES_OPTION) {
            System.exit(0);

        } else {
            return;
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
       AuthService.clear();
        new Login(this, true).setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpnCauHinh;
    private javax.swing.JPanel jpnGiaoDich;
    private javax.swing.JPanel jpnHangHoa;
    private javax.swing.JPanel jpnHome;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel sidepanel;
    // End of variables declaration//GEN-END:variables
}
