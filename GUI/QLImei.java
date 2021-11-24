/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusCTSanPhamModel;
import BUS.Services.BusImeiService;
import DAL.Models.DalImeiModel;
import GUI.Models.CartModel;
import static GUI.QuanlyGiaoDichJFrame.cartModel;
import static GUI.QuanlyGiaoDichJFrame.tblSanPham;
import GUI.Services.ButtonColumn;
import GUI.Services.MessageService;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ADMIN
 */
public class QLImei extends javax.swing.JFrame {

    Icon iconXoa = new ImageIcon(getClass().getResource("/icon/Delete.png"));
    public static int mactsp;
    static List<String> listImei = new ArrayList<>();
    boolean isNewProduct = false;
    int currentRow;

    public QLImei() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.isNewProduct = true;
        buttonRemove();
        fillTable(listImei);
    }

    public QLImei(int mactsp) {
        initComponents();
        this.mactsp = mactsp;
        init();
    }

    void fillTable(List<String> list) {
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
        if (list.size() > 0) {
            for (String imei : list) {
                modelImei.addRow(new Object[]{
                    listImei.indexOf(imei) + 1,
                    imei,
                    "Xóa"
                });
            }
        }
        lblSoluong.setText("Tổng: "+ tblImei.getRowCount());
    }

    void buttonRemove() {
        Action remove = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblImei.getSelectedRow();
                listImei.remove((int) tblImei.getValueAt(row, 0) - 1);
                clearFormList();
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblImei, remove, 2);

        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
//    CartModel cart = new CartModel();
//    int index;
//    int indexsp;
//    BusCTSanPhamModel busCTSanPhamModes;
//    public QLImei(CartModel cart, int index) {
//        initComponents();
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        this.cart = cart;
//        busCTSanPhamModel = QuanlyGiaoDichJFrame.listSp.stream().filter(sp -> sp.getMaCTSP()== cart.getMactsp()).toList().get(0);
//        indexsp = QuanlyGiaoDichJFrame.listSp.indexOf(busCTSanPhamModel);
//        this.index = index;
//        btnRemoveCart();
//        fillTable();
//        isGiaoDich = true;
//        txtTenImei.setEditable(false);
//    }
//    DefaultTableModel model;
//    boolean isGiaoDich = false;
//    void fillTable() {
//        model = (DefaultTableModel) tblImei.getModel();
//        model.setRowCount(0);
//        cart.getListImeis().forEach(imei -> {
//            model.addRow(new Object[] {
//                imei.getMaImei(),
//                imei.getTenImei(),
//                iconXoa
//            });
//        });
//    }
//    private void btnRemoveCart() {
//        Action remove = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for(int row: tblImei.getSelectedRows()) {
//                    int tonKho = busCTSanPhamModel.getTonKho() + 1;
//                    busCTSanPhamModel.setTonKho(tonKho);
//                    cart.getListImeis().remove(row);
//                    fillTable();
//                }
//            }
//        };
//
//        ButtonColumn buttonColumn = new ButtonColumn(tblImei, remove, 2);
//
//        buttonColumn.setMnemonic(KeyEvent.VK_D);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        txtTenImei = new javax.swing.JTextField();
        lblThem = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblSoluong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Imei", "Tên Imei", "Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImei.setRowHeight(30);
        jScrollPane1.setViewportView(tblImei);
        if (tblImei.getColumnModel().getColumnCount() > 0) {
            tblImei.getColumnModel().getColumn(0).setMinWidth(50);
            tblImei.getColumnModel().getColumn(0).setMaxWidth(50);
            tblImei.getColumnModel().getColumn(1).setResizable(false);
            tblImei.getColumnModel().getColumn(2).setMinWidth(60);
            tblImei.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        txtTenImei.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenImeiKeyPressed(evt);
            }
        });

        lblThem.setText("Thêm imei");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jLabel2.setText("Tìm kiếm");

        lblSoluong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoluong.setForeground(new java.awt.Color(153, 0, 0));
        lblSoluong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoluong.setText("Tổng: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThem)
                    .addComponent(txtTenImei, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblThem)
                .addGap(12, 12, 12)
                .addComponent(txtTenImei, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        if(isGiaoDich) {
//            QuanlyGiaoDichJFrame.listCart.set(index, cart);
//            QuanlyGiaoDichJFrame.listSp.set(indexsp, busCTSanPhamModel);
//            QuanlyGiaoDichJFrame.fillTable(QuanlyGiaoDichJFrame.listSp);
//            QuanlyGiaoDichJFrame.fillToCart(QuanlyGiaoDichJFrame.cartModel, QuanlyGiaoDichJFrame.tblCart);
//        }
        QuanLySanPham.listImei.clear();
        for (int i = 0; i < tblImei.getRowCount(); i++) {
            DalImeiModel dalImeiModel = new DalImeiModel();
            dalImeiModel.setTenImei((String) tblImei.getValueAt(i, 1));
            if(!isNewProduct) {
                int maImei = (int) tblImei.getValueAt(i, 0);
                dalImeiModel.setMaImei(maImei);
            }
            QuanLySanPham.listImei.add(dalImeiModel);
        }
        if(isNewProduct) {
            QuanLySanPham.txtTonKho.setText(QuanLySanPham.listImei.size() + "");
        }
        BusImeiService.fillComboImei(QuanLySanPham.imeiModel, QuanLySanPham.cboListImei, QuanLySanPham.listImei);
        lblSoluong.setText("Tổng: "+0);
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
    }//GEN-LAST:event_formWindowClosed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        if (isNewProduct) {
            if (txtSearch.getText().length() > 0) {
                List<String> listFilter = listImei.stream().filter(imei -> imei.contains(txtSearch.getText())).toList();
                fillTable(listFilter);
            } else {
                fillTable(listImei);
            }
        } else {
            clearForm();
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtTenImeiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenImeiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && txtTenImei.getText() != null && !"".equals(txtTenImei.getText().trim())) {
            if (isNewProduct) {
                listImei.add(txtTenImei.getText());
                clearFormList();
            } else {
                DalImeiModel dalImeiModel = new DalImeiModel();
                dalImeiModel.setMaCtsp(this.mactsp);
                dalImeiModel.setTenImei(txtTenImei.getText());
                if (BusImeiService.insert(dalImeiModel)) {
                    int currentStock = Integer.parseInt(QuanLySanPham.txtTonKho.getText());
                    currentStock++;
                    QuanLySanPham.txtTonKho.setText(currentStock+"");
                    MessageService.alert(this, "Ok");
                    clearForm();
                } else {
                    MessageService.alert(this, "false");
                }
                
            }
        }
    }//GEN-LAST:event_txtTenImeiKeyPressed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QLImei().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblSoluong;
    private javax.swing.JLabel lblThem;
    public static javax.swing.JTable tblImei;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenImei;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel modelImei;

    void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BusImeiService.fillTable(modelImei, tblImei, BusImeiService.listDalImei);
        currentRow = -1;
    }

    void clearFormList() {
        fillTable(listImei);
        txtTenImei.setText("");
    }

    void clearForm() {
        BusImeiService.getImeiByMactsp(this.mactsp, txtSearch.getText());
        BusImeiService.fillTable(modelImei, tblImei, BusImeiService.listDalImei);
        
        txtTenImei.setText("");
        currentRow = -1;
    }
}
