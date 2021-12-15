/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Services.BusImeiService;
import DAL.Models.DalImeiModel;
import DAL.Services.DalImeiService;
import GUI.Services.ButtonColumn;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

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
    DalImeiService dalImeiService = new DalImeiService();

    public QLImei() {
        initComponents();
        desginTable();
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.isNewProduct = true;
        buttonRemove();
        fillTable(listImei);
        btnThem.setEnabled(false);
        setIconImage(ImageService.getAppIcon());
    }

    public void desginTable() {
        tblImei.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblImei.getTableHeader().setOpaque(false);
        tblImei.getTableHeader().setBackground(new Color(25, 29, 74));
        tblImei.getTableHeader().setForeground(Color.WHITE);

        tblImei.getTableHeader().setDraggedColumn(null);

    }

    public QLImei(int mactsp) {
        initComponents();
        this.mactsp = mactsp;
        setIconImage(ImageService.getAppIcon());
        btnThem.setEnabled(false);
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
        lblSoluong.setText("Tổng: " + tblImei.getRowCount());
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
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imei");
        setBackground(new java.awt.Color(255, 255, 255));
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
            tblImei.getColumnModel().getColumn(0).setMinWidth(0);
            tblImei.getColumnModel().getColumn(0).setMaxWidth(0);
            tblImei.getColumnModel().getColumn(1).setResizable(false);
            tblImei.getColumnModel().getColumn(2).setMinWidth(60);
            tblImei.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        txtTenImei.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenImei.setForeground(new java.awt.Color(25, 29, 74));
        txtTenImei.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtTenImei.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenImeiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenImeiKeyReleased(evt);
            }
        });

        lblThem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblThem.setForeground(new java.awt.Color(5, 10, 46));
        lblThem.setText("Thêm imei");

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(25, 29, 74));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Tìm kiếm");

        lblSoluong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoluong.setForeground(new java.awt.Color(153, 0, 0));
        lblSoluong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoluong.setText("Tổng: 0");

        btnThem.setBackground(new java.awt.Color(25, 29, 74));
        btnThem.setForeground(new java.awt.Color(5, 10, 46));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnThem.setBorderPainted(false);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThem)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTenImei, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblThem)
                        .addGap(12, 12, 12)
                        .addComponent(txtTenImei, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
            if (!isNewProduct) {
                int maImei = (int) tblImei.getValueAt(i, 0);
                dalImeiModel.setMaImei(maImei);
            }
            QuanLySanPham.listImei.add(dalImeiModel);
        }
        if (isNewProduct) {
            QuanLySanPham.txtTonKho.setText(QuanLySanPham.listImei.size() + "");
        }
        BusImeiService.fillComboImei(QuanLySanPham.imeiModel, QuanLySanPham.cboListImei, QuanLySanPham.listImei);
        lblSoluong.setText("Tổng: " + 0);
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
    }//GEN-LAST:event_formWindowClosed

    private void txtTenImeiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenImeiKeyPressed

    }//GEN-LAST:event_txtTenImeiKeyPressed

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        changeColor(btnThem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        changeColor(btnThem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnThemMouseExited

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String imeiAdd = txtTenImei.getText();
        addImei(imeiAdd);
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTenImeiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenImeiKeyReleased
        String imeiAdd = txtTenImei.getText();
        if (imeiAdd.matches("^[0-9]{15}")) {
            btnThem.setEnabled(true);
        } else {
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_txtTenImeiKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
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
    }//GEN-LAST:event_txtSearchKeyReleased
    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }
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
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblSoluong;
    private javax.swing.JLabel lblThem;
    public static javax.swing.JTable tblImei;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenImei;
    // End of variables declaration//GEN-END:variables
//  014109002431693
//    546168219735897
//    864675917024329
//    500653521781436
//    547465960596091
//    333946805840024
//    869068252624140
//    501236005641190
//    999133656101641
//    013762940416993
//    502463588344716
//    863107742209660
//    499523071863608
//    350736940239200
//    997890792366840
//    535582199013666
//    997519698738394
//    507869074025871
//    449062261104649
//    501144457670669
//    532144552937172
    DefaultTableModel modelImei;

    void addImei(String imeiAdd) {
        if (isValidIMEI(imeiAdd)) {
            if (!dalImeiService.isImeiExist(imeiAdd)) {
                if (MessageService.confirm(rootPane, "Bạn có muốn thêm Imei này không ?")) {
                    if (isNewProduct) {
                        listImei.add(imeiAdd);
                        clearFormList();
                    } else {
                        DalImeiModel dalImeiModel = new DalImeiModel();
                        dalImeiModel.setMaCtsp(this.mactsp);
                        dalImeiModel.setTenImei(imeiAdd);
                        if (BusImeiService.insert(dalImeiModel)) {
                            int currentStock = Integer.parseInt(QuanLySanPham.txtTonKho.getText());
                            currentStock++;
                            QuanLySanPham.txtTonKho.setText(currentStock + "");
                            MessageService.alert(this, "Thêm Imei thành công!");
                            clearForm();
                        } else {
                            MessageService.alert(this, "Thêm Imei thất bại @");
                        }
                    }
                }
            } else {
                MessageService.alert(rootPane, "Imei này đã tồn tại vui lòng nhập Imei khác @");
            }
        } else {
            MessageService.alert(rootPane, "Imei này không đúng quy định vui lòng kiểm tra lại @");
        }
    }

    void init() {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BusImeiService.fillTable(modelImei, tblImei, BusImeiService.listDalImei);
        currentRow = -1;
    }

    void clearFormList() {
        btnThem.setEnabled(false);
        fillTable(listImei);
        txtTenImei.setText("");
    }

    void clearForm() {
        BusImeiService.getImeiByMactsp(this.mactsp, txtSearch.getText());
        BusImeiService.fillTable(modelImei, tblImei, BusImeiService.listDalImei);
        btnThem.setEnabled(false);
        txtTenImei.setText("");
        currentRow = -1;
    }

    static int sumDig(int n) {
        int a = 0;
        while (n > 0) {
            a = a + n % 10;
            n = n / 10;
        }
        return a;
    }

    boolean isValidIMEI(String imei) {
        long n = Long.parseLong(imei);
        int len = imei.length();

        if (len != 15) {
            return false;
        }

        int sum = 0;
        for (int i = len; i >= 1; i--) {
            int d = (int) (n % 10);

            // Doubling every alternate digit
            if (i % 2 == 0) {
                d = 2 * d;
            }

            // Finding sum of the digits
            sum += sumDig(d);
            n = n / 10;
        }
        return (sum % 10 == 0);
    }
}
