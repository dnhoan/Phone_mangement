/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Services.NhanVienService;
import GUI.Services.AuthService;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author DUCNAM
 */
public class ChangePass extends javax.swing.JDialog {
    NhanVienService dao = new NhanVienService();
    /**
     * Creates new form ChangePass
     */
    public ChangePass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
              setIconImage(ImageService.getAppIcon());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMKHT = new javax.swing.JPasswordField();
        txtMKMoi = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtXNMKMoi = new javax.swing.JPasswordField();
        btnDongY = new rojerusan.RSButtonMetro();
        btnHuy = new rojerusan.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đổi mật khẩu");

        txtMaNV.setEditable(false);
        txtMaNV.setBackground(new java.awt.Color(255, 255, 255));
        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(25, 29, 74));
        txtMaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtMaNV.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Tên đăng nhập");

        txtMKHT.setForeground(new java.awt.Color(25, 29, 74));
        txtMKHT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        txtMKMoi.setForeground(new java.awt.Color(25, 29, 74));
        txtMKMoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Mật khẩu mới");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Mật khẩu hiện tại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Xác nhận mật khẩu mới");

        txtXNMKMoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        btnDongY.setBackground(new java.awt.Color(25, 29, 74));
        btnDongY.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        btnDongY.setText("Đồng ý");
        btnDongY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDongYMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDongYMouseExited(evt);
            }
        });
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(25, 29, 74));
        btnHuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        btnHuy.setText("Hủy bỏ");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyMouseExited(evt);
            }
        });
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMKMoi)
                    .addComponent(txtMKHT, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtXNMKMoi)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDongY, btnHuy});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXNMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMKHT, txtMKMoi, txtMaNV, txtXNMKMoi});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
       if(checkNull(txtMKHT)){
            if(checkNull(txtMKMoi)){
                if(checkNull(txtXNMKMoi)){
                      change();
                }
            }
        }
    }//GEN-LAST:event_btnDongYActionPerformed

    private void btnDongYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDongYMouseEntered
        changeColor(btnDongY, new Color(102, 0, 102));
    }//GEN-LAST:event_btnDongYMouseEntered

    private void btnDongYMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDongYMouseExited
        changeColor(btnDongY, new Color(25, 29, 74));
    }//GEN-LAST:event_btnDongYMouseExited

    private void btnHuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseEntered
         changeColor(btnHuy, new Color(102, 0, 102));
    }//GEN-LAST:event_btnHuyMouseEntered

    private void btnHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseExited
         changeColor(btnHuy, new Color(25, 29, 74));
    }//GEN-LAST:event_btnHuyMouseExited

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
                    FlatLightLaf.setup(); //setting the look and feel
                   UIManager.put("TitlePane.background", new ColorUIResource(5,10,46));
                   UIManager.put("TitlePane.foreground", new ColorUIResource(255,255,255));
                   UIManager.put("TitlePane.buttonHoverBackground", new ColorUIResource( 25, 29, 74));
                    UIManager.put("TitlePane.closeHoverBackground", new ColorUIResource( 25, 29, 74));
                    UIManager.put("TitlePane.iconSize", new Dimension(20, 10));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangePass dialog = new ChangePass(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
 public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnDongY;
    private rojerusan.RSButtonMetro btnHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMKHT;
    private javax.swing.JPasswordField txtMKMoi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtXNMKMoi;
    // End of variables declaration//GEN-END:variables

    private void init() {
       txtMaNV.setText(AuthService.user.getMaNV());
        setLocationRelativeTo(null);
    }

    private void change() {
        String matKhau=new String(txtMKHT.getPassword());
        String matKhauMoi=new String(txtMKMoi.getPassword());
        String xacNhanMKM=new String(txtXNMKMoi.getPassword());
        if(matKhau.equals(AuthService.user.getMatKhau())){
            if(matKhauMoi.equals(xacNhanMKM)){
                AuthService.user.setMatKhau(matKhauMoi);
                dao.update(AuthService.user);
                MessageService.alert(this, "Đổi mật khẩu thành công!!");
                this.dispose();
            }else{
                MessageService.alert(this, "Mật khẩu xác nhận không trùng mật khẩu mới!");
            }
        }else{
            MessageService.alert(this, "Mật khẩu cũ nhập không chính xác!");
        }
    }
    public static boolean checkNull(JPasswordField txt) {
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            MessageService.alert(txt.getRootPane(), "Không được để trống ");
            return false;
        }
    }
    
    
}
