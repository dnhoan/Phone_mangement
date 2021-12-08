/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusMauSacModel;
import BUS.Services.BusPhanLoaiSpService;
import BUS.Services.MauSacService;
import DAL.Models.DalMauSacModel;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLMauSac extends javax.swing.JFrame {

    /**
     * Creates new form QLMauSac
     */
    public QLMauSac() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        desginTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void desginTable() {
        tblKD.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblKD.getTableHeader().setOpaque(false);
        tblKD.getTableHeader().setBackground(new Color(25, 29, 74));
        tblKD.getTableHeader().setForeground(Color.WHITE);

        tblKD.getTableHeader().setDraggedColumn(null);
        tblNKD.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblNKD.getTableHeader().setOpaque(false);
        tblNKD.getTableHeader().setBackground(new Color(25, 29, 74));
        tblNKD.getTableHeader().setForeground(Color.WHITE);
    }
    DefaultTableModel modelDkd;
    DefaultTableModel modelNkd;
    int rowSeleted;
    int maMau;

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
        txtTenMau = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdoNKD = new javax.swing.JRadioButton();
        rdoKd = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoiForm4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabs.setForeground(new java.awt.Color(102, 0, 102));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        tblKD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKD.setForeground(new java.awt.Color(25, 29, 74));
        tblKD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã màu", "Tên màu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKD.setGridColor(new java.awt.Color(25, 29, 74));
        tblKD.setRowHeight(25);
        tblKD.setRowMargin(0);
        tblKD.getTableHeader().setReorderingAllowed(false);
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
        if (tblKD.getColumnModel().getColumnCount() > 0) {
            tblKD.getColumnModel().getColumn(0).setMinWidth(0);
            tblKD.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        tabs.addTab("Đang kinh doanh", jPanel1);

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        tblNKD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNKD.setForeground(new java.awt.Color(25, 29, 74));
        tblNKD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã màu", "Tên màu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNKD.setGridColor(new java.awt.Color(25, 29, 74));
        tblNKD.setRowHeight(25);
        tblNKD.setRowMargin(0);
        tblNKD.getTableHeader().setReorderingAllowed(false);
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
        if (tblNKD.getColumnModel().getColumnCount() > 0) {
            tblNKD.getColumnModel().getColumn(0).setMinWidth(0);
            tblNKD.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        tabs.addTab("Ngừng kinh doanh", jPanel2);

        txtTenMau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenMau.setForeground(new java.awt.Color(25, 29, 74));
        txtTenMau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Tên màu");

        rdoNKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNKD);
        rdoNKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNKD.setForeground(new java.awt.Color(25, 29, 74));
        rdoNKD.setText("Ngừng kinh doanh");

        rdoKd.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoKd);
        rdoKd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoKd.setForeground(new java.awt.Color(25, 29, 74));
        rdoKd.setSelected(true);
        rdoKd.setText("Đang kinh doanh");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Trạng thái");

        btnThem.setBackground(new java.awt.Color(25, 29, 74));
        btnThem.setForeground(new java.awt.Color(25, 29, 74));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnThem.setBorderPainted(false);
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
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnSua.setBorderPainted(false);
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

        btnLamMoiForm4.setBackground(new java.awt.Color(25, 29, 74));
        btnLamMoiForm4.setForeground(new java.awt.Color(25, 29, 74));
        btnLamMoiForm4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnLamMoiForm4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnLamMoiForm4.setBorderPainted(false);
        btnLamMoiForm4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLamMoiForm4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLamMoiForm4MouseExited(evt);
            }
        });
        btnLamMoiForm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiForm4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoKd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNKD, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoiForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoKd)
                    .addComponent(rdoNKD))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
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

    private void tabsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabsPropertyChange

    }//GEN-LAST:event_tabsPropertyChange

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DalMauSacModel dalMauSacModel = getForm();
        if (MauSacService.insert(dalMauSacModel)) {
            MessageService.alert(this, "yeahhh");
            filTable();
        } else {
            MessageService.alert(this, "no");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (MauSacService.update(this.getForm())) {
            MessageService.alert(this, "yeahhh");
            filTable();
        } else {
            MessageService.alert(this, "no");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiForm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiForm4ActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiForm4ActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        filTable();
    }//GEN-LAST:event_tabsStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MauSacService.fillCombo(QuanLySanPham.mauSacModel, QuanLySanPham.cboMauSac);
    }//GEN-LAST:event_formWindowClosed

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

    private void btnLamMoiForm4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiForm4MouseEntered
        changeColor(btnLamMoiForm4, new Color(102, 0, 102));
    }//GEN-LAST:event_btnLamMoiForm4MouseEntered

    private void btnLamMoiForm4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiForm4MouseExited
        changeColor(btnLamMoiForm4, new Color(25, 29, 74));
    }//GEN-LAST:event_btnLamMoiForm4MouseExited

    void filTable() {
        if (tabs.getSelectedIndex() == 0) {
            MauSacService.getDataMau(1);
            MauSacService.fillTable(modelDkd, tblKD);
        } else {
            MauSacService.getDataMau(0);
            MauSacService.fillTable(modelNkd, tblNKD);
        }
        clearForm();
    }

    DalMauSacModel getForm() {
        DalMauSacModel dalMauSacModel = new DalMauSacModel();
        if (rowSeleted >= 0 && tabs.getSelectedIndex() == 0) {
            dalMauSacModel.setMaMau((int) tblKD.getValueAt(rowSeleted, 0));
        }
        if (rowSeleted >= 0 && tabs.getSelectedIndex() == 1) {
            dalMauSacModel.setMaMau((int) tblNKD.getValueAt(rowSeleted, 0));
        }
        dalMauSacModel.setTenMau(txtTenMau.getText());
        dalMauSacModel.setTrangThai(rdoKd.isSelected());
        return dalMauSacModel;
    }

    void setForm() {
        BusMauSacModel busMauSacModel = MauSacService.selectMauSac(maMau);
        txtTenMau.setText(busMauSacModel.getDalMauSacModel().getTenMau());
        rdoKd.setSelected(busMauSacModel.getDalMauSacModel().isTrangThai());
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLMauSac().setVisible(true);
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
