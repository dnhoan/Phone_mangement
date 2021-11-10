/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Services.IEditService;
import BUS.Models.BusRamModel;

import BUS.Services.RamService;
import GUI.Services.IEditService;
import GUI.Services.MessageService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLRam extends javax.swing.JFrame {

    /**
     * Creates new form QLRam
     */
    public QLRam() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel53 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblram = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtloai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jrdioDangKD = new javax.swing.JRadioButton();
        JradioNgungKD = new javax.swing.JRadioButton();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdungluong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblram2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        tblram.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Ram", "Loại ram", "Dung lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblramMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblram);

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel21.setText("Loại ram:");

        jLabel22.setText("Trạng thái:");

        buttonGroup1.add(jrdioDangKD);
        jrdioDangKD.setText("Đang kinh doanh");

        buttonGroup1.add(JradioNgungKD);
        JradioNgungKD.setText("Ngừng kinh doanh");

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setText("Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        jLabel1.setText("Dung lượng:");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtloai)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addGap(18, 18, 18)
                                .addComponent(btnsua)
                                .addGap(18, 18, 18)
                                .addComponent(btnlammoi))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jrdioDangKD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JradioNgungKD))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(txtdungluong))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdungluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdioDangKD)
                    .addComponent(JradioNgungKD))
                .addGap(26, 26, 26)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnlammoi))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        jButton1.setText("Khôi phục");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblram2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Ram", "Loại ram", "Tên ram", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblram2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblram2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblram2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ngừng kinh doanh", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(769, Short.MAX_VALUE)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblramMouseClicked
        // TODO add your handling code here:
        this.row = tblram.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblramMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        insert();

    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        update();
        fillTable2();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        khoiphuc();
        fillTable();
        fillTable2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblram2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblram2MouseClicked
        // TODO add your handling code here:
        this.rowRecycle = tblram2.getSelectedRow();
        
    }//GEN-LAST:event_tblram2MouseClicked

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
            java.util.logging.Logger.getLogger(QLRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLRam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JradioNgungKD;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jrdioDangKD;
    private javax.swing.JTable tblram;
    private javax.swing.JTable tblram2;
    private javax.swing.JTextField txtdungluong;
    private javax.swing.JTextField txtloai;
    // End of variables declaration//GEN-END:variables

    int row = -1;
    int rowRecycle = -1;
    List<BusRamModel> list = new ArrayList<>();
    List<BusRamModel> listRecycle = new ArrayList<>();
    DefaultTableModel model, modelRecycle;
    RamService ram = new RamService();

    public void init() {
        this.setLocationRelativeTo(this);
        this.setTitle("");
        this.fillTable();
        this.fillTable2();

    }

    public void khoiphuc() {
        int id = (int) tblram2.getValueAt(this.rowRecycle, 0);
        try {
            ram.khoiphuc(id);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "khôi phục thành công");
        } catch (Exception e) {
        }
    }

    public BusRamModel getForm() {
        BusRamModel modell = new BusRamModel();
        modell.setLoaiRam(txtloai.getText());
        modell.setDungLuongRam(Float.parseFloat(txtdungluong.getText()));
        boolean trangthai;
        if (JradioNgungKD.isSelected()) {
            trangthai = false;
        } else {
            trangthai = true;
        }
        modell.setTrangThai(trangthai);

        return modell;
    }

    public void setForm(BusRamModel bushangmodel) {
        txtloai.setText(bushangmodel.getLoaiRam());
        txtdungluong.setText(bushangmodel.getDungLuongRam() + "");
        jrdioDangKD.setSelected(bushangmodel.isTrangThai());
        JradioNgungKD.setSelected(!bushangmodel.isTrangThai());

//        boolean trangthai = bushangmodel.isTrangThai();
//        if (trangthai = true) {
//            jrdioDangKD.setSelected(true);
//        }
//        //jrdioDangKD.setSelected(bushangmodel.isTrangThai());
    }

    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnthem.setEnabled(!edit);
        btnsua.setEnabled(edit);
        btnlammoi.setEnabled(edit);

    }

    public void insert() {
        BusRamModel busHangModel = getForm();
        try {
            ram.insert(busHangModel);
            this.fillTable();
            this.clearForm();
            this.updateStatus();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e) {
        }

    }

    public void update() {
        BusRamModel modell = this.getForm();
        int id = (int) tblram.getValueAt(this.row, 0);
        modell.setMaRam(id);
        try {
            ram.update(modell);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
        } catch (Exception e) {
        }
    }

    public void edit() {
        int id = (int) tblram.getValueAt(this.row, 0);
        BusRamModel bushangmodel = this.ram.selectByID(id);
        this.setForm(bushangmodel);
        this.updateStatus();
    }

    public void clearForm() {
        BusRamModel bus = new BusRamModel();
        setForm(bus);
        row = -1;
        this.updateStatus();

    }

    public void fillTable() {
        row = -1;
        model = (DefaultTableModel) tblram.getModel();
        model.setRowCount(0);
        try {
            this.list = ram.selectAll();
            for (BusRamModel sp : list) {
                model.addRow(new Object[]{sp.getMaRam(), sp.getLoaiRam(), sp.getDungLuongRam(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"});
            }
            this.updateStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTable2() {
        row = -1;
        modelRecycle = (DefaultTableModel) tblram2.getModel();
        modelRecycle.setRowCount(0);

        try {
            listRecycle = ram.selectStatus();
            for (BusRamModel sp : listRecycle) {
                modelRecycle.addRow(new Object[]{
                    sp.getMaRam(), sp.getLoaiRam(), sp.getDungLuongRam(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"
                });
            }

        } catch (Exception e) {
        }
    }

}
