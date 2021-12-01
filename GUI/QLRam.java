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
import java.awt.Color;
import java.awt.Font;
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
          getContentPane().setBackground(Color.WHITE);
         desginTable();
        init();
    }
public void desginTable() {
        tblram.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblram.getTableHeader().setOpaque(false);
        tblram.getTableHeader().setBackground(new Color(25, 29, 74));
       tblram.getTableHeader().setForeground(Color.WHITE);
        
        tblram.getTableHeader().setDraggedColumn(null);
        tblram2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
      tblram2.getTableHeader().setOpaque(false);
         tblram2.getTableHeader().setBackground(new Color(25, 29, 74));
        tblram2.getTableHeader().setForeground(Color.WHITE);
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblram.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblram.setForeground(new java.awt.Color(25, 29, 74));
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
        tblram.setGridColor(new java.awt.Color(25, 29, 74));
        tblram.setRowHeight(25);
        tblram.setRowMargin(0);
        tblram.getTableHeader().setReorderingAllowed(false);
        tblram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblramMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblram);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        btnthem.setBackground(new java.awt.Color(25, 29, 74));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnthem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnthem.setBorderPainted(false);
        btnthem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(5, 10, 46));
        jLabel21.setText("Loại ram:");

        txtloai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtloai.setForeground(new java.awt.Color(25, 29, 74));
        txtloai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(5, 10, 46));
        jLabel22.setText("Trạng thái:");

        jrdioDangKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jrdioDangKD);
        jrdioDangKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdioDangKD.setForeground(new java.awt.Color(25, 29, 74));
        jrdioDangKD.setText("Đang kinh doanh");

        JradioNgungKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JradioNgungKD);
        JradioNgungKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JradioNgungKD.setForeground(new java.awt.Color(25, 29, 74));
        JradioNgungKD.setText("Ngừng kinh doanh");

        btnsua.setBackground(new java.awt.Color(25, 29, 74));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnsua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnsua.setBorderPainted(false);
        btnsua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(25, 29, 74));
        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnlammoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnlammoi.setBorderPainted(false);
        btnlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Dung lượng:");

        txtdungluong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdungluong.setForeground(new java.awt.Color(25, 29, 74));
        txtdungluong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(txtloai)
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtdungluong)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jrdioDangKD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JradioNgungKD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtloai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtdungluong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdioDangKD)
                    .addComponent(JradioNgungKD))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 279, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(25, 29, 74));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore1.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblram2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblram2.setForeground(new java.awt.Color(25, 29, 74));
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
        tblram2.setGridColor(new java.awt.Color(25, 29, 74));
        tblram2.setRowHeight(25);
        tblram2.setRowMargin(0);
        tblram2.getTableHeader().setReorderingAllowed(false);
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        RamService.fillCombo(QuanLySanPham.ramModel, QuanLySanPham.cboRam, QuanLySanPham.listRam);
    }//GEN-LAST:event_formWindowClosed

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            this.clearForm();
            this.updateStatus();
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
