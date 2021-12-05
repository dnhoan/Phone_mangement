/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Services.IEditService;
import BUS.Models.BusXuatXuModel;

import BUS.Services.XuatXuService;
import GUI.Services.IEditService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLXuatXu extends javax.swing.JFrame {

    /**
     * Creates new form QLXuatXu
     */
    public QLXuatXu() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        desginTable();
        init();
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void desginTable() {
        tblxuatxu.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblxuatxu.getTableHeader().setOpaque(false);
        tblxuatxu.getTableHeader().setBackground(new Color(25, 29, 74));
        tblxuatxu.getTableHeader().setForeground(Color.WHITE);

        tblxuatxu.getTableHeader().setDraggedColumn(null);
        tblxuatxu2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblxuatxu2.getTableHeader().setOpaque(false);
        tblxuatxu2.getTableHeader().setBackground(new Color(25, 29, 74));
        tblxuatxu2.getTableHeader().setForeground(Color.WHITE);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jrdioDangKD = new javax.swing.JRadioButton();
        JradioNgungKD = new javax.swing.JRadioButton();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblxuatxu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblxuatxu2 = new javax.swing.JTable();
        btnkhoiphuc = new javax.swing.JButton();

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

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        btnthem.setBackground(new java.awt.Color(25, 29, 74));
        btnthem.setForeground(new java.awt.Color(25, 29, 74));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnthem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnthem.setBorderPainted(false);
        btnthem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnthemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnthemMouseExited(evt);
            }
        });
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(5, 10, 46));
        jLabel21.setText("Nơi xuất xứ:");

        txtTenHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenHang.setForeground(new java.awt.Color(25, 29, 74));
        txtTenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(5, 10, 46));
        jLabel22.setText("Trạng thái:");

        jrdioDangKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jrdioDangKD);
        jrdioDangKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdioDangKD.setForeground(new java.awt.Color(25, 29, 74));
        jrdioDangKD.setSelected(true);
        jrdioDangKD.setText("Đang kinh doanh");

        JradioNgungKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JradioNgungKD);
        JradioNgungKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JradioNgungKD.setForeground(new java.awt.Color(25, 29, 74));
        JradioNgungKD.setText("Ngừng kinh doanh");

        btnsua.setBackground(new java.awt.Color(25, 29, 74));
        btnsua.setForeground(new java.awt.Color(25, 29, 74));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnsua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnsua.setBorderPainted(false);
        btnsua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsuaMouseExited(evt);
            }
        });
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(25, 29, 74));
        btnlammoi.setForeground(new java.awt.Color(25, 29, 74));
        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnlammoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnlammoi.setBorderPainted(false);
        btnlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlammoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlammoiMouseExited(evt);
            }
        });
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jrdioDangKD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JradioNgungKD)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdioDangKD)
                    .addComponent(JradioNgungKD))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        tblxuatxu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã xuất xứ", "Nơi xuất xứ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblxuatxu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblxuatxuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblxuatxu);
        if (tblxuatxu.getColumnModel().getColumnCount() > 0) {
            tblxuatxu.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        tblxuatxu2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã xuất xứ", "Nơi xuất xứ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblxuatxu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblxuatxu2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblxuatxu2);

        btnkhoiphuc.setBackground(new java.awt.Color(25, 29, 74));
        btnkhoiphuc.setForeground(new java.awt.Color(25, 29, 74));
        btnkhoiphuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore1.png"))); // NOI18N
        btnkhoiphuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnkhoiphuc.setBorderPainted(false);
        btnkhoiphuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnkhoiphuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnkhoiphucMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnkhoiphucMouseExited(evt);
            }
        });
        btnkhoiphuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhoiphucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btnkhoiphuc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(btnkhoiphuc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ngừng kinh doanh", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblxuatxuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblxuatxuMouseClicked
        // TODO add your handling code here:
        this.row = tblxuatxu.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblxuatxuMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        update();
        fillTable2();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void tblxuatxu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblxuatxu2MouseClicked
        // TODO add your handling code here:
        this.row = tblxuatxu2.getSelectedRow();

    }//GEN-LAST:event_tblxuatxu2MouseClicked

    private void btnkhoiphucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhoiphucActionPerformed
        // TODO add your handling code here:
        khoiphuc();
        fillTable2();
    }//GEN-LAST:event_btnkhoiphucActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        XuatXuService.fillCombo(QuanLySanPham.xuatXuModel, QuanLySanPham.cboXuatXu, QuanLySanPham.listXuatXu);
    }//GEN-LAST:event_formWindowClosed

    private void btnthemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseEntered
        changeColor(btnthem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnthemMouseEntered

    private void btnthemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseExited
        changeColor(btnthem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnthemMouseExited

    private void btnsuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseEntered
        changeColor(btnsua, new Color(102, 0, 102));
    }//GEN-LAST:event_btnsuaMouseEntered

    private void btnsuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseExited
        changeColor(btnsua, new Color(25, 29, 74));
    }//GEN-LAST:event_btnsuaMouseExited

    private void btnlammoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlammoiMouseEntered
        changeColor(btnlammoi, new Color(102, 0, 102));
    }//GEN-LAST:event_btnlammoiMouseEntered

    private void btnlammoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlammoiMouseExited
        changeColor(btnlammoi, new Color(25, 29, 74));
    }//GEN-LAST:event_btnlammoiMouseExited

    private void btnkhoiphucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhoiphucMouseEntered
        changeColor(btnkhoiphuc, new Color(102, 0, 102));
    }//GEN-LAST:event_btnkhoiphucMouseEntered

    private void btnkhoiphucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhoiphucMouseExited
        changeColor(btnkhoiphuc, new Color(25, 29, 74));
    }//GEN-LAST:event_btnkhoiphucMouseExited

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
            java.util.logging.Logger.getLogger(QLXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLXuatXu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JradioNgungKD;
    private javax.swing.JButton btnkhoiphuc;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jrdioDangKD;
    private javax.swing.JTable tblxuatxu;
    private javax.swing.JTable tblxuatxu2;
    private javax.swing.JTextField txtTenHang;
    // End of variables declaration//GEN-END:variables

    int row = -1;
    int rowRecycle = -1;
    List<BusXuatXuModel> list = new ArrayList<>();
    List<BusXuatXuModel> listRecycle = new ArrayList<>();
    DefaultTableModel model, modelRecycle;
    XuatXuService xuatxu = new XuatXuService();

    private void init() {
        this.setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("");
        this.fillTable();
        this.fillTable2();
    }

    public void khoiphuc() {
        BusXuatXuModel modell = this.getForm();
        int id = (int) tblxuatxu2.getValueAt(this.row, 0);
        modell.setMaXuatXu(id);
        try {
            xuatxu.khoiphuc(modell);
            this.fillTable();
            fillTable2();
            JOptionPane.showMessageDialog(this, "khôi phục thành công");
        } catch (Exception e) {
        }
    }

    public void update() {
        BusXuatXuModel modell = this.getForm();
        int id = (int) tblxuatxu.getValueAt(this.row, 0);
        modell.setMaXuatXu(id);
        try {
            xuatxu.update(modell);
            this.fillTable();
            fillTable2();
            this.clearForm();
            this.updateStatus();
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
        } catch (Exception e) {
        }
    }

    public void insert() {
        BusXuatXuModel busXuatXumodel = getForm();
        try {
            xuatxu.insert(busXuatXumodel);
            this.fillTable();
            fillTable2();
            this.clearForm();
            this.updateStatus();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e) {
        }

    }

    public BusXuatXuModel getForm() {
        BusXuatXuModel modell = new BusXuatXuModel();
        modell.setNoiXuatXu(txtTenHang.getText());
        boolean trangthai;
        if (JradioNgungKD.isSelected()) {
            trangthai = false;
        } else {
            trangthai = true;
        }
        modell.setTrangThai(trangthai);
        return modell;
    }

    public void edit() {
        int id = (int) tblxuatxu.getValueAt(this.row, 0);
        BusXuatXuModel bushangmodel = this.xuatxu.selectByID(id);
        this.setForm(bushangmodel);
        this.updateStatus();
    }

    public void setForm(BusXuatXuModel bushangmodel) {
        txtTenHang.setText(bushangmodel.getNoiXuatXu());
        boolean trangthai = bushangmodel.isTrangThai();
        if (trangthai = true) {
            jrdioDangKD.setSelected(true);
        }
        //jrdioDangKD.setSelected(bushangmodel.isTrangThai());

    }

    public void clearForm() {
        BusXuatXuModel bus = new BusXuatXuModel();
        setForm(bus);
        row = -1;
        this.updateStatus();

    }

    private void fillTable() {
        row = -1;
        model = (DefaultTableModel) tblxuatxu.getModel();
        model.setRowCount(0);
        try {
            this.list = xuatxu.selectAll();
            for (BusXuatXuModel sp : list) {
                model.addRow(new Object[]{sp.getMaXuatXu(), sp.getNoiXuatXu(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"});
            }
            this.updateStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnthem.setEnabled(!edit);
        btnsua.setEnabled(edit);
        btnlammoi.setEnabled(edit);

    }

    private void fillTable2() {
        row = -1;
        modelRecycle = (DefaultTableModel) tblxuatxu2.getModel();
        modelRecycle.setRowCount(0);

        try {
            listRecycle = xuatxu.selectStatus();
            for (BusXuatXuModel sp : listRecycle) {
                modelRecycle.addRow(new Object[]{
                    sp.getMaXuatXu(), sp.getNoiXuatXu(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"
                });
            }
            updateStatus();
        } catch (Exception e) {
        }
    }

}
