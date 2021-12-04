package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAL.Services.JDBCHelper;
import java.awt.Color;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JLabel;
import org.jdesktop.swingx.border.DropShadowBorder;
import org.jdesktop.swingx.painter.effects.ShadowPathEffect;

/**
 *
 * @author 84349
 */
public class QuenPass extends javax.swing.JFrame {

    int randomCode;
    Connection con;
    /**
     * Creates new form test
     */
    String to;

    public QuenPass() {
        con = JDBCHelper.ketnoi();
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     

    }
    
    public boolean chekguima() {
        if (txttaikhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể bỏ trống tài khoản");
            txttaikhoan.requestFocus();
            return false;
        } else {
            try {
                String sql = "select * from nhanvien where manv=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txttaikhoan.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Không có tài khoản " + txttaikhoan.getText());
                    return false;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean chek() {
        if (txttaikhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể bỏ trống tài khoản");
            txttaikhoan.requestFocus();
            return false;
        } else {
            try {
                String sql = "select * from nhanvien where manv=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txttaikhoan.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Không có tài khoản " + txttaikhoan.getText());
                    return false;
                }
                
            } catch (Exception e) {
            }
        }
        if (txtcode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể bỏ trống mã xác thực");
            txtcode.requestFocus();
            return false;
        } else {
            try {
                int a = Integer.parseInt(txtcode.getText());
                if (txtcode.getText().length() != 6) {
                    JOptionPane.showMessageDialog(this, "mã phải có 6 chữ số");
                    return false;
                }
                if (Integer.parseInt(txtcode.getText()) != randomCode) {
                    JOptionPane.showMessageDialog(this, "Mã xác nhận không đúng mời bạn kiểm tra lại email");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Mã xác thực phải là số");
                return false;
            }
        }
        if (txtpass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể bỏ trống mật khẩu");
            txtpass.requestFocus();
            return false;
        }
        if (txtchekpass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể bỏ trống xác nhận mật khẩu");
            txtchekpass.requestFocus();
            return false;
        }
        if (txtchekpass.getText().equalsIgnoreCase(txtpass.getText())) {
            
        } else {
            JOptionPane.showMessageDialog(this, "xác thực mật khẩu không trùng với mật khẩu mời bạn nhập lại");
            txtchekpass.requestFocus();
            return false;
        }
        return true;
    }

    public void tk() {
        try {
            String sql = "select * from nhanvien where manv=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txttaikhoan.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                to = rs.getString("email");
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        
        tk();
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "cuongndph14605@fpt.edu.vn";
            String pass = "Duycuong1";
            String subject = "Reseting Code";
            String message = "Mã để khôi phục lại mật khẩu của bạn là: " + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.starttls.required", "true");
            pros.put("mail.smtp.host", host);
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Mã đã được gửi đến email của bạn mời bạn kiểm tra");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtchekpass = new javax.swing.JPasswordField();
        txttaikhoan = new javax.swing.JTextField();
        btngui = new javax.swing.JLabel();
        btnXacNhan = new rojerusan.RSButtonMetro();
        btnQuaylai = new rojerusan.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Mã Xác Thực:");

        txtcode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcode.setForeground(new java.awt.Color(25, 29, 74));
        txtcode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Quên Mật Khẩu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Nhập Mật Khẩu:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Tài Khoản: ");

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpass.setForeground(new java.awt.Color(25, 29, 74));
        txtpass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Xác Nhận Mật Khẩu:");

        txtchekpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtchekpass.setForeground(new java.awt.Color(25, 29, 74));
        txtchekpass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        txttaikhoan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttaikhoan.setForeground(new java.awt.Color(25, 29, 74));
        txttaikhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        btngui.setText("Gửi mã về email đăng kí tài khoản");
        btngui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnguiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnguiMouseExited(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(25, 29, 74));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnQuaylai.setBackground(new java.awt.Color(25, 29, 74));
        btnQuaylai.setText("Quay lại");
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtcode, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtchekpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(txtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btngui)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtchekpass, txtcode, txtpass});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtchekpass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtchekpass, txtcode, txtpass, txttaikhoan});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        int hi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn quay lại ??", "Quên Mật Khẩu", JOptionPane.YES_NO_OPTION);
        if (hi == 0) {
            this.dispose();
            new Login(this, true).setVisible(true);
        } else {
            return;
        }
    }//GEN-LAST:event_btnQuaylaiActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (chek()) {
            try {
                String sql = "update nhanvien set matkhau = ? where manv = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(2, txttaikhoan.getText());
                ps.setString(1, new String(txtpass.getPassword()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công mời bạn đăng nhập");
                xoa();
                new Login(this, true).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnguiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguiMouseExited
        resetColor(btngui);
    }//GEN-LAST:event_btnguiMouseExited

    private void btnguiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguiMouseEntered
        setColor(btngui);
    }//GEN-LAST:event_btnguiMouseEntered

    private void btnguiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguiMouseClicked
        // TODO add your handling code here:
        if (chekguima()) {
            if (ok == true) {
                run();
                Thread time;
                time = new Thread() {
                    int i = 0;

                    @Override
                    public void run() {
                        while (i < 61) {
                            try {
                                btngui.setText("code sẽ được gửi sau " + i + " giây nữa");
                                Thread.sleep(100);
                                i++;
                                btngui.setEnabled(false);
                                if (i < 60) {
                                    ok = false;
                                }
                                if (i == 60) {
                                    i = 0;
                                    btngui.setText("Gửi lại code vào email");

                                    btngui.setEnabled(true);

                                    ok = true;
                                    return;

                                }

                            } catch (Exception e) {
                            }
                        }
                    }

                };
                time.start();
            } else {
                JOptionPane.showMessageDialog(this, "Mời bạn chờ trong giây lát");
            }
        }
    }//GEN-LAST:event_btnguiMouseClicked
boolean ok = true;    
void xoa() {
        txttaikhoan.setText("");
        txtchekpass.setText("");
        txtpass.setText("");
        txtcode.setText("");
    }
 public void setColor(JLabel lb) {
        lb.setForeground(new Color(25,29,74));
    }

    public void resetColor(JLabel lb1) {
        lb1.setForeground(new Color(0, 0, 0));
    }
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
            java.util.logging.Logger.getLogger(QuenPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnQuaylai;
    private rojerusan.RSButtonMetro btnXacNhan;
    private javax.swing.JLabel btngui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtchekpass;
    private javax.swing.JTextField txtcode;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txttaikhoan;
    // End of variables declaration//GEN-END:variables
}
