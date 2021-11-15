package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAL.Services.JDBCHelper;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.sql.*;

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

        jLabel4 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtchekpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txttaikhoan = new javax.swing.JTextField();
        btngui = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Mã Xác Thực:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quên Mật Khẩu");

        jLabel5.setText("Nhập Mật Khẩu:");

        jLabel2.setText("Tài Khoản: ");

        jLabel6.setText("Xác Nhận Mật Khẩu:");

        jButton1.setText("Xác Nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quay Lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btngui.setText("Gửi mã về email đăng kí tài khoản");
        btngui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(btngui))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtcode)
                                .addComponent(txtpass)
                                .addComponent(txtchekpass)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txttaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtchekpass, txtcode, txtpass, txttaikhoan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtchekpass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtchekpass, txtcode, txtpass, txttaikhoan});

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean ok = true;
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
    void xoa() {
        txttaikhoan.setText("");
        txtchekpass.setText("");
        txtpass.setText("");
        txtcode.setText("");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int hi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn quay lại ??", "Quên Mật Khẩu", JOptionPane.YES_NO_OPTION);
        if (hi == 0) {
            this.dispose();
            new Login(this, true).setVisible(true);
        } else {
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel btngui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtchekpass;
    private javax.swing.JTextField txtcode;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txttaikhoan;
    // End of variables declaration//GEN-END:variables
}
