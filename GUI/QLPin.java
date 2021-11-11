/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusPinModel;

import BUS.Services.PinService;
import GUI.Services.IEditService;
import GUI.Services.MessageService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLPin extends javax.swing.JFrame implements IEditService<BusPinModel> {

    PinService psr = new PinService();
    int row = -1;

    /**
     * Creates new form QLPin
     */
    public QLPin() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtLoaiPin = new javax.swing.JTextField();
        rdoKD = new javax.swing.JRadioButton();
        rdoNKD = new javax.swing.JRadioButton();
        txtDungLuongPin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        j = new javax.swing.JScrollPane();
        tblNKD = new javax.swing.JTable();
        btnLamMoiForm4 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pin");

        jLabel1.setText("Loại Pin");

        buttonGroup1.add(rdoKD);
        rdoKD.setSelected(true);
        rdoKD.setText("Đang kinh doanh");

        buttonGroup1.add(rdoNKD);
        rdoNKD.setText("Ngừng kinh doanh");

        jLabel2.setText("Dung Lượng Pin");

        jLabel3.setText("Trạng thái");

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        jLabel4.setText("mAh");

        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsMouseClicked(evt);
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Pin", "Loại Pin", "Dung Lượng Pin", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
        if (tblKD.getColumnModel().getColumnCount() > 0) {
            tblKD.getColumnModel().getColumn(0).setMinWidth(50);
            tblKD.getColumnModel().getColumn(0).setMaxWidth(50);
            tblKD.getColumnModel().getColumn(1).setMinWidth(130);
            tblKD.getColumnModel().getColumn(1).setMaxWidth(130);
            tblKD.getColumnModel().getColumn(2).setMinWidth(110);
            tblKD.getColumnModel().getColumn(2).setMaxWidth(110);
        }

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Pin", "Loại Pin", "Dung Lượng Pin", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        if (tblNKD.getColumnModel().getColumnCount() > 0) {
            tblNKD.getColumnModel().getColumn(0).setMinWidth(50);
            tblNKD.getColumnModel().getColumn(0).setMaxWidth(50);
            tblNKD.getColumnModel().getColumn(1).setMinWidth(130);
            tblNKD.getColumnModel().getColumn(1).setMaxWidth(130);
            tblNKD.getColumnModel().getColumn(2).setMinWidth(110);
            tblNKD.getColumnModel().getColumn(2).setMaxWidth(110);
        }

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

        btnLamMoiForm4.setText("Làm mới");
        btnLamMoiForm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiForm4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoiForm4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLoaiPin, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoKD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNKD, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(txtLoaiPin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoKD)
                    .addComponent(rdoNKD))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKDMouseClicked

        if (evt.getClickCount() == 1) {
            this.row = tblKD.getSelectedRow();
            this.edit();

        }

    }//GEN-LAST:event_tblKDMouseClicked

    private void tblNKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNKDMouseClicked
        if (evt.getClickCount() == 1) {
            this.row = tblNKD.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNKDMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tabs.getSelectedIndex() == 0) {
            update();
        } else {
            update2();
        }


    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiForm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiForm4ActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiForm4ActionPerformed

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        if (tabs.getSelectedIndex() == 0) {
            clearForm();
            updateStatus();

        } else {
            clearForm();
            updateStatus2();
        }

    }//GEN-LAST:event_tabsMouseClicked

    private void tblKDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblKDPropertyChange

    }//GEN-LAST:event_tblKDPropertyChange

    private void tblNKDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblNKDPropertyChange


    }//GEN-LAST:event_tblNKDPropertyChange

    private void tblNKDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblNKDComponentShown

    }//GEN-LAST:event_tblNKDComponentShown

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked


    }//GEN-LAST:event_jPanel1MouseClicked

    private void tabsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabsPropertyChange


    }//GEN-LAST:event_tabsPropertyChange

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
            java.util.logging.Logger.getLogger(QLPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPin().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoKD;
    private javax.swing.JRadioButton rdoNKD;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKD;
    private javax.swing.JTable tblNKD;
    private javax.swing.JTextField txtDungLuongPin;
    private javax.swing.JTextField txtLoaiPin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.fillTableDKD();
        this.fillTableNKD();
        updateStatus();
        this.row = -1;
    }

    void fillTableDKD() {

        DefaultTableModel modelkd = (DefaultTableModel) tblKD.getModel();
        modelkd.setRowCount(0);
        try {
            List<BusPinModel> listpidkd = psr.selectAllKD();
            for (BusPinModel x : listpidkd) {
                Object[] row = {x.getMaLoaiPin(), x.getLoaiPin(), x.getDungLuongPin(),
                    x.isTrangThai() ? "Đang kinh doanh" : "Ngừng kinh doanh"};
                modelkd.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void fillTableNKD() {

        DefaultTableModel modelnkd = (DefaultTableModel) tblNKD.getModel();
        modelnkd.setRowCount(0);
        try {
            List<BusPinModel> listpidnkd = psr.selectAllNKD();
            for (BusPinModel x : listpidnkd) {
                Object[] row = {x.getMaLoaiPin(), x.getLoaiPin(), x.getDungLuongPin(),
                    x.isTrangThai() ? "Đang kinh doanh" : "Ngừng kinh doanh"};
                modelnkd.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit() {
        if (tabs.getSelectedIndex() == 0) {
            String idpin = (String) tblKD.getValueAt(this.row, 0);
            BusPinModel pinmodel = this.psr.selectByID(idpin);
            setForm(pinmodel);
            updateStatus();
        } else {
            String idpin = (String) tblNKD.getValueAt(this.row, 0);
            BusPinModel pinmodel = this.psr.selectByID(idpin);
            setForm(pinmodel);
            updateStatus2();

        }

    }

    @Override
    public void setForm(BusPinModel model) {
        txtLoaiPin.setText(model.getLoaiPin());
        txtDungLuongPin.setText(model.getDungLuongPin() + "");
        rdoKD.setSelected(model.isTrangThai());
        rdoNKD.setSelected(!model.isTrangThai());
    }

    @Override
    public void insert() {
        BusPinModel buspinModel = this.getForm();
        try {
            psr.insert(buspinModel);
            this.fillTableDKD();
            this.clearForm();
            this.updateStatus();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");
            e.printStackTrace();
        }
    }

    @Override
    public BusPinModel getForm() {
        BusPinModel busPinModel = new BusPinModel();
        busPinModel.setLoaiPin(txtLoaiPin.getText());
        busPinModel.setDungLuongPin(Float.parseFloat(txtDungLuongPin.getText()));
        busPinModel.setTrangThai(rdoKD.isSelected());
        return busPinModel;
    }

    @Override
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnLamMoiForm4.setEnabled(edit);
    }

    public void updateStatus2() {
        boolean edit = (this.row >= 0);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnLamMoiForm4.setEnabled(edit);
    }

    @Override
    public void update() {

        BusPinModel busPinModel = this.getForm();
        String idpin = (String) tblKD.getValueAt(this.row, 0);
        busPinModel.setMaLoaiPin(idpin);
        try {
            psr.update(busPinModel);
            this.fillTableDKD();
            this.fillTableNKD();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");

        }
    }

    public void update2() {
        BusPinModel busPinModel = this.getForm();
        String idpin = (String) tblNKD.getValueAt(this.row, 0);
        busPinModel.setMaLoaiPin(idpin);
        try {
            psr.update(busPinModel);
            this.fillTableNKD();
            this.fillTableDKD();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearForm() {
        BusPinModel pinmodel = new BusPinModel();
        this.row = -1;
        this.setForm(pinmodel);
        this.updateStatus();
    }

    @Override
    public void first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void previous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateForm(boolean isEdit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
