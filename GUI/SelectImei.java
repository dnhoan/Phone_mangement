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
import static GUI.QuanlyGiaoDichJFrame.fillTable;
import static GUI.QuanlyGiaoDichJFrame.listCart;
import static GUI.QuanlyGiaoDichJFrame.listSp;
import static GUI.QuanlyGiaoDichJFrame.tblCart;
import static GUI.QuanlyGiaoDichJFrame.tblSanPham;
import GUI.Services.MessageService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ADMIN
 */
public class SelectImei extends javax.swing.JFrame {

    /**
     * Creates new form SelectImei
     */
    static BusCTSanPhamModel busCTSanPhamModel;

//    public SelectImei() {
//        initComponents();
//        this.init();
//    }
    public SelectImei(BusCTSanPhamModel busCTSanPhamModel) {
        initComponents();
        System.out.println(busCTSanPhamModel.getMaCTSP());
        SelectImei.busCTSanPhamModel = busCTSanPhamModel;
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboImei = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboImei.setEditable(true);

        jLabel1.setText("Chọn Imei");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        SelectImei.ok();
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(SelectImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SelectImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SelectImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SelectImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SelectImei().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    public static javax.swing.JComboBox<String> cboImei;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    static DefaultComboBoxModel<DalImeiModel> imeiModel;

    void init() {
        AutoCompleteDecorator.decorate(cboImei);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println("mactsp " + SelectImei.busCTSanPhamModel.getMaCTSP());
        BusImeiService.getImeisNotSell(SelectImei.busCTSanPhamModel.getMaCTSP());
        BusImeiService.fillcboImeiBymactsp(imeiModel, cboImei);
    }

    public static void ok() {
        if ("".equals(cboImei.getSelectedItem()) || cboImei.getSelectedItem() == null) {
            MessageService.alert(null, "Bạn chưa nhập imei máy");
        } else {
            DalImeiModel imei = (DalImeiModel) cboImei.getSelectedItem();
            
            BusImeiService.updateStatusSell(imei.getMaImei(), 0);
            
            List<DalImeiModel> listImeis = new ArrayList<>();
            CartModel cart = new CartModel();
            cart.setMactsp(busCTSanPhamModel.getMaCTSP());
            cart.setTensp(busCTSanPhamModel.getSanPhamModel().getTensp());
            cart.setHinh(busCTSanPhamModel.getHinh());
            cart.setGia(busCTSanPhamModel.getGiaBan());
            if (listCart.size() > 0) {
                for (int i = 0; i < listCart.size(); i++) {
                    CartModel c = listCart.get(i);
                    if (c.getMactsp() == cart.getMactsp()) {
                        listImeis = c.getListImeis();
                        listImeis.add(imei);
                        cart.setListImeis(listImeis);
                        cart.setTongTien(busCTSanPhamModel.getGiaBan() * cart.getListImeis().size());

                        int indexsp = listSp.indexOf(busCTSanPhamModel);
                        int conLai = busCTSanPhamModel.getTonKho() - 1;
                        busCTSanPhamModel.setTonKho(conLai);
                        listSp.set(indexsp, busCTSanPhamModel);

                        QuanlyGiaoDichJFrame.listCart.set(i, cart);
                        break;
                    } else if (i == listCart.size() - 1) {
                        listImeis.add(imei);
                        cart.setListImeis(listImeis);
                        cart.setTongTien(busCTSanPhamModel.getGiaBan() * cart.getListImeis().size());

                        int indexsp = listSp.indexOf(busCTSanPhamModel);
                        int conLai = busCTSanPhamModel.getTonKho() - 1;
                        busCTSanPhamModel.setTonKho(conLai);
                        listSp.set(indexsp, busCTSanPhamModel);

                        listCart.add(cart);
                        break;
                    }
                }
            } else {
                listImeis.add(imei);
                cart.setListImeis(listImeis);
                cart.setTongTien(busCTSanPhamModel.getGiaBan() * cart.getListImeis().size());

                int indexsp = listSp.indexOf(busCTSanPhamModel);
                int conLai = busCTSanPhamModel.getTonKho() - 1;
                busCTSanPhamModel.setTonKho(conLai);
                listSp.set(indexsp, busCTSanPhamModel);

                listCart.add(cart);
            }
        }
        QuanlyGiaoDichJFrame.fillToCart(cartModel, tblCart);
        tblSanPham.removeRowSelectionInterval(0, listSp.size() - 1);
        fillTable(listSp);
    }
}
