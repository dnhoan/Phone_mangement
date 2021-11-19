/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusPhanLoaiSpModel;
import BUS.Services.BusPhanLoaiSpService;
import DAL.Models.DalPhanLoaiSpModel;
import GUI.Services.MessageService;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLPhanLoai extends javax.swing.JFrame {

    /**
     * Creates new form QLPhanLoai
     */
    public QLPhanLoai() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    DefaultTableModel modelDkd;
    DefaultTableModel modelNkd;
    int rowSeleted;
    int maMau;
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        j = new javax.swing.JScrollPane();
        tblNKD = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoiForm4 = new javax.swing.JButton();
        txtTenMau = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdoKd = new javax.swing.JRadioButton();
        rdoNKD = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });
        tabs.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabsPropertyChange(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        tblKD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phân loại", "Tên phân loại", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKDMouseClicked(evt);
            }
        });
        tblKD.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblKDPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblKD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabs.addTab("Đang kinh doanh", jPanel1);

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        tblNKD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phân loại", "Tên phân loại", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNKD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNKDMouseClicked(evt);
            }
        });
        tblNKD.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblNKDComponentShown(evt);
            }
        });
        tblNKD.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblNKDPropertyChange(evt);
            }
        });
        j.setViewportView(tblNKD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabs.addTab("Ngừng kinh doanh", jPanel2);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoiForm4.setText("Làm mới");
        btnLamMoiForm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiForm4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên phân loại");

        jLabel3.setText("Trạng thái");

        buttonGroup1.add(rdoKd);
        rdoKd.setSelected(true);
        rdoKd.setText("Đang kinh doanh");

        buttonGroup1.add(rdoNKD);
        rdoNKD.setText("Ngừng kinh doanh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(472, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoKd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNKD, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoiForm4)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(267, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoKd)
                    .addComponent(rdoNKD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKDMouseClicked
        if (evt.getClickCount() == 1) {
            rowSeleted = tblKD.getSelectedRow();
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            maMau = (int) tblKD.getValueAt(rowSeleted, 0);
            this.setForm();
        }
    }//GEN-LAST:event_tblKDMouseClicked

    private void tblKDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblKDPropertyChange

    }//GEN-LAST:event_tblKDPropertyChange

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void tblNKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNKDMouseClicked
        if (evt.getClickCount() == 1) {
            rowSeleted = tblNKD.getSelectedRow();
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            maMau = (int) tblNKD.getValueAt(rowSeleted, 0);
            this.setForm();
        }
    }//GEN-LAST:event_tblNKDMouseClicked

    private void tblNKDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblNKDComponentShown

    }//GEN-LAST:event_tblNKDComponentShown

    private void tblNKDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblNKDPropertyChange

    }//GEN-LAST:event_tblNKDPropertyChange

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        filTable();
    }//GEN-LAST:event_tabsStateChanged

    private void tabsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabsPropertyChange

    }//GEN-LAST:event_tabsPropertyChange

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DalPhanLoaiSpModel dalMauSacModel = getForm();
        if (BusPhanLoaiSpService.insert(dalMauSacModel)) {
            MessageService.alert(this, "yeahhh");
            filTable();
        } else {
            MessageService.alert(this, "no");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (BusPhanLoaiSpService.update(this.getForm())) {
            MessageService.alert(this, "yeahhh");
            filTable();
        } else {
            MessageService.alert(this, "no");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiForm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiForm4ActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiForm4ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        BusPhanLoaiSpService.fillCombo(QuanLySanPham.phanLoaiModel, QuanLySanPham.cboPhanLoai);
    }//GEN-LAST:event_formWindowClosed
    void filTable() {
        if (tabs.getSelectedIndex() == 0) {
            BusPhanLoaiSpService.getDataMau(1);
            BusPhanLoaiSpService.fillTable(modelDkd, tblKD);
        } else {
            BusPhanLoaiSpService.getDataMau(0);
            BusPhanLoaiSpService.fillTable(modelNkd, tblNKD);
        }
        clearForm();
    }
    DalPhanLoaiSpModel getForm() {
        DalPhanLoaiSpModel dalMauSacModel = new DalPhanLoaiSpModel();
        if (rowSeleted >= 0 && tabs.getSelectedIndex() == 0) {
            dalMauSacModel.setMaPhanLoai((int) tblKD.getValueAt(rowSeleted, 0));
        }
        if (rowSeleted >= 0 && tabs.getSelectedIndex() == 1) {
            dalMauSacModel.setMaPhanLoai((int) tblNKD.getValueAt(rowSeleted, 0));
        }
        dalMauSacModel.setTenLoai(txtTenMau.getText());
        dalMauSacModel.setTrangThai(rdoKd.isSelected());
        return dalMauSacModel;
    }
    
    void setForm() {
        BusPhanLoaiSpModel busMauSacModel = BusPhanLoaiSpService.selectMauSac(maMau);
        txtTenMau.setText(busMauSacModel.getDalPhanLoaiSpModel().getTenLoai());
        rdoKd.setSelected(busMauSacModel.getDalPhanLoaiSpModel().isTrangThai());
    }
    void clearForm() {
        txtTenMau.setText("");
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        rowSeleted = -1;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLPhanLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPhanLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPhanLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPhanLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPhanLoai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiForm4;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoKd;
    private javax.swing.JRadioButton rdoNKD;
    private javax.swing.JTabbedPane tabs;
    public static javax.swing.JTable tblKD;
    public static javax.swing.JTable tblNKD;
    private javax.swing.JTextField txtTenMau;
    // End of variables declaration//GEN-END:variables
}
