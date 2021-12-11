/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusCameraModel;
import BUS.Services.CameraService;
import BUS.Services.HeDieuHanhService;
import DAL.Services.JDBCHelper;
import GUI.Services.IEditService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLCameraSp extends javax.swing.JFrame implements IEditService<BusCameraModel> {

    /**
     * Creates new form QLCameraSp
     */
    int row = -1;
    CameraService cameraService = new CameraService();
    
//    QuanLySanPham qlsp = new QuanLySanPham();
    

    public QLCameraSp() {
        initComponents();
        desginTable();
        getContentPane().setBackground(Color.WHITE);
        this.init();
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void desginTable() {
        tbldsd.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tbldsd.getTableHeader().setOpaque(false);
        tbldsd.getTableHeader().setBackground(new Color(25, 29, 74));
        tbldsd.getTableHeader().setForeground(Color.WHITE);
        tblnsd.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tbldsd.getTableHeader().setDraggedColumn(null);
        tblnsd.getTableHeader().setOpaque(false);
        tblnsd.getTableHeader().setBackground(new Color(25, 29, 74));
        tblnsd.getTableHeader().setForeground(Color.WHITE);
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
        jPanel53 = new javax.swing.JPanel();
        TAB = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldsd = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblnsd = new javax.swing.JTable();
        rdo0 = new javax.swing.JRadioButton();
        rdo1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtLoaiCam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        btnThem4 = new javax.swing.JButton();
        btnSua4 = new javax.swing.JButton();
        btnLamMoiForm4 = new javax.swing.JButton();
        txtDoPhanGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        TAB.setForeground(new java.awt.Color(102, 0, 102));
        TAB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TAB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABMouseClicked(evt);
            }
        });

        tbldsd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Camera", "Loại Camera", "Độ phân giải", "Trạng thái"
            }
        ));
        tbldsd.setGridColor(new java.awt.Color(25, 29, 74));
        tbldsd.setRowHeight(25);
        tbldsd.setRowMargin(0);
        tbldsd.setRowSelectionAllowed(false);
        tbldsd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldsdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldsd);
        if (tbldsd.getColumnModel().getColumnCount() > 0) {
            tbldsd.getColumnModel().getColumn(0).setMinWidth(0);
            tbldsd.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        TAB.addTab("Đang sử dụng", jPanel2);

        tblnsd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Camera", "Loại Camera", "Độ phân giải", "Trạng thái"
            }
        ));
        tblnsd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnsdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblnsd);
        if (tblnsd.getColumnModel().getColumnCount() > 0) {
            tblnsd.getColumnModel().getColumn(0).setMinWidth(0);
            tblnsd.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        TAB.addTab("Ngừng sử dụng", jPanel3);

        rdo0.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo0);
        rdo0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdo0.setForeground(new java.awt.Color(25, 29, 74));
        rdo0.setText("Ngừng sử dụng");

        rdo1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo1);
        rdo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdo1.setForeground(new java.awt.Color(25, 29, 74));
        rdo1.setSelected(true);
        rdo1.setText("Đang sử dụng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Trạng thái");

        txtLoaiCam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLoaiCam.setForeground(new java.awt.Color(25, 29, 74));
        txtLoaiCam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Loại Camera");

        jPanel54.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnThem4.setBackground(new java.awt.Color(25, 29, 74));
        btnThem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnThem4.setBorderPainted(false);
        btnThem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThem4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThem4MouseExited(evt);
            }
        });
        btnThem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem4ActionPerformed(evt);
            }
        });
        jPanel54.add(btnThem4);

        btnSua4.setBackground(new java.awt.Color(25, 29, 74));
        btnSua4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnSua4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnSua4.setBorderPainted(false);
        btnSua4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSua4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSua4MouseExited(evt);
            }
        });
        btnSua4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua4ActionPerformed(evt);
            }
        });
        jPanel54.add(btnSua4);

        btnLamMoiForm4.setBackground(new java.awt.Color(25, 29, 74));
        btnLamMoiForm4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnLamMoiForm4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnLamMoiForm4.setBorderPainted(false);
        btnLamMoiForm4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel54.add(btnLamMoiForm4);

        txtDoPhanGia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDoPhanGia.setForeground(new java.awt.Color(25, 29, 74));
        txtDoPhanGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Độ phân giải");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TAB)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rdo1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdo0))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtLoaiCam, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDoPhanGia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoaiCam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoPhanGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo1)
                    .addComponent(rdo0))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TAB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldsdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldsdMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tbldsd.getSelectedRow();
            this.edit();

        }
    }//GEN-LAST:event_tbldsdMouseClicked

    private void tblnsdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnsdMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblnsd.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblnsdMouseClicked

    private void TABMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABMouseClicked
        // TODO add your handling code here:
        if (TAB.getSelectedIndex() == 0) {
            clearForm();
            updateStatus();
        } else {
            clearForm();
            updateStatus2();
        }
    }//GEN-LAST:event_TABMouseClicked

    private void btnSua4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua4ActionPerformed
        // TODO add your handling code here:
        if (TAB.getSelectedIndex() == 0) {
            if (checkNull() ) {
                update();
            }

        } else {
            update2();
        }
    }//GEN-LAST:event_btnSua4ActionPerformed

    private void btnThem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem4ActionPerformed

        if (checkNull() && checkUpdate()) {
            insert();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem4ActionPerformed

    private void btnLamMoiForm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiForm4ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnLamMoiForm4ActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        CameraService.fillCombo(QuanLySanPham.cameraModel, QuanLySanPham.cboCamera, QuanLySanPham.listCamera);
    }//GEN-LAST:event_formWindowClosed

    private void btnThem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem4MouseEntered
        changeColor(btnThem4, new Color(102, 0, 102));
    }//GEN-LAST:event_btnThem4MouseEntered

    private void btnThem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem4MouseExited
        changeColor(btnThem4, new Color(25, 29, 74));
    }//GEN-LAST:event_btnThem4MouseExited

    private void btnSua4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSua4MouseEntered
        changeColor(btnSua4, new Color(102, 0, 102));
    }//GEN-LAST:event_btnSua4MouseEntered

    private void btnSua4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSua4MouseExited
        changeColor(btnSua4, new Color(25, 29, 74));
    }//GEN-LAST:event_btnSua4MouseExited

    private void btnLamMoiForm4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiForm4MouseEntered
        changeColor(btnLamMoiForm4, new Color(102, 0, 102));
    }//GEN-LAST:event_btnLamMoiForm4MouseEntered

    private void btnLamMoiForm4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiForm4MouseExited
        changeColor(btnLamMoiForm4, new Color(25, 29, 74));
    }//GEN-LAST:event_btnLamMoiForm4MouseExited

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
            java.util.logging.Logger.getLogger(QLCameraSp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLCameraSp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLCameraSp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLCameraSp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLCameraSp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TAB;
    private javax.swing.JButton btnLamMoiForm4;
    private javax.swing.JButton btnSua4;
    private javax.swing.JButton btnThem4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JTable tbldsd;
    private javax.swing.JTable tblnsd;
    private javax.swing.JTextField txtDoPhanGia;
    private javax.swing.JTextField txtLoaiCam;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.fillTableDsd();
        this.fillTableNsd();
        updateStatus();
        this.row = -1;
    }

    void fillTableDsd() {

        DefaultTableModel modelsd = (DefaultTableModel) tbldsd.getModel();
        modelsd.setRowCount(0);
        try {
            List<BusCameraModel> listdsd = cameraService.selectAll();
            for (BusCameraModel x : listdsd) {
                Object[] row = {x.getMaCamera(), x.getTenCamera(), x.getDoPhanGiai(),
                    x.isTrangThai() ? "Đang sử dụng" : "Ngừng sử dụng"};
                modelsd.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void fillTableNsd() {
        DefaultTableModel modelnsd = (DefaultTableModel) tblnsd.getModel();
        modelnsd.setRowCount(0);
        try {
            List<BusCameraModel> listnsd = cameraService.selectRecycle();
            if (listnsd != null) {
                for (BusCameraModel x : listnsd) {
                    Object[] row = {x.getMaCamera(), x.getTenCamera(), x.getDoPhanGiai(),
                        x.isTrangThai() ? "Đang sử dụng" : "Ngừng sử dụng"};
                    modelnsd.addRow(row);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearForm() {
        BusCameraModel busCameraModel = new BusCameraModel();
        this.row = -1;
        this.setForm(busCameraModel);
        this.updateStatus();
    }

    @Override
    public void setForm(BusCameraModel entity) {
        txtLoaiCam.setText(entity.getTenCamera());
        txtDoPhanGia.setText(entity.getDoPhanGiai());
        if (entity.isTrangThai()) {
            rdo1.setSelected(true);
        } else {
            rdo0.setSelected(true);
        }
    }

    @Override
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnThem4.setEnabled(!edit);
        btnSua4.setEnabled(edit);
        btnLamMoiForm4.setEnabled(true);
    }

    public void updateStatus2() {
        boolean edit = (this.row >= 0);
        btnThem4.setEnabled(false);
        btnSua4.setEnabled(edit);
        btnLamMoiForm4.setEnabled(false);
    }

    @Override
    public void insert() {
        BusCameraModel busCameraModel = this.getForm();
        try {
            cameraService.insert(busCameraModel);
            this.fillTableDsd();
            this.clearForm();
            this.updateStatus();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        BusCameraModel busCameraModel = this.getForm();
        int idCam = (int) tbldsd.getValueAt(this.row, 0);
        busCameraModel.setMaCamera(idCam);
        try {
            cameraService.update(busCameraModel);
            this.fillTableDsd();
            this.fillTableNsd();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");

        }
    }

    public void update2() {
        BusCameraModel busCameraModel = this.getForm();
        int idCam = (int) tblnsd.getValueAt(this.row, 0);
        busCameraModel.setMaCamera(idCam);
        try {
            cameraService.update(busCameraModel);
            this.fillTableNsd();
            this.fillTableDsd();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");
            e.printStackTrace();
        }
    }

    public boolean checkUpdate() {
        try {
            int chkmacam = (int) tbldsd.getValueAt(row, 0);
             Connection con = JDBCHelper.ketnoi();
            PreparedStatement pstm = con.prepareStatement("SELECT MaCamera from CTSANPHAM where TrangThai = 1");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (chkmacam == rs.getInt("MaCamera")) {
                    MessageService.alert(this, "Camera này vẫn đang được sử dụng trong sản phẩm!");
                    return false;
                }

            }

        } catch (SQLException ex) {
            MessageService.alert(this, "Lỗi check update");
        }
        return true;
    }

    public boolean checkNull() {
        if (txtLoaiCam.getText().isEmpty()) {
            MessageService.alert(this, "Không bỏ trống loại cam!");
            return false;
        }
        if (txtDoPhanGia.getText().isEmpty()) {
            MessageService.alert(this, "Không bỏ trống độ phân giải!");
            return false;
        }
        return true;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit() {
        if (TAB.getSelectedIndex() == 0) {
            int idCam = (int) tbldsd.getValueAt(this.row, 0);
            BusCameraModel busCameraModel = this.cameraService.selectByID(idCam);
            setForm(busCameraModel);
            updateStatus();
        } else {
            int idCam = (int) tblnsd.getValueAt(this.row, 0);
            BusCameraModel busCameraModel = this.cameraService.selectByID(idCam);
            setForm(busCameraModel);
            updateStatus2();

        }
    }

    @Override
    public void fillTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public BusCameraModel getForm() {
        BusCameraModel busCameraModel = new BusCameraModel();
        busCameraModel.setTenCamera(txtLoaiCam.getText());
        busCameraModel.setDoPhanGiai(txtDoPhanGia.getText());
        busCameraModel.setTrangThai(rdo1.isSelected());
        return busCameraModel;
    }

}
