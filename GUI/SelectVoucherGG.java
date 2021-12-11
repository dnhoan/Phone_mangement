package GUI;

import BUS.Models.BusVoucherModel;
import BUS.Services.SanPhamService;
import BUS.Services.VoucherService;
import DAL.Models.DalImeiModel;
import GUI.Models.CartModel;
import javax.swing.DefaultComboBoxModel;

public class SelectVoucherGG extends javax.swing.JFrame {

    int masp;
    int mactsp;
    DefaultComboBoxModel<BusVoucherModel> model;
    SanPhamService sanPhamService = new SanPhamService();

    public SelectVoucherGG(int mactsp) {
        initComponents();
        this.mactsp = mactsp;
        this.masp = sanPhamService.selectMaspByMactsp(mactsp);
        System.out.println("masp " + this.masp);
        setTitle("Chọn mã voucher giảm giá");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        VoucherService.fillCombo(model, cboGiamGia, masp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboGiamGia = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cboGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cboGiamGia.getSelectedIndex() == 0) {
            for (CartModel cart : QuanLyBanHang.listCart) {
                if (cart.getBusSanPham().getMasp() == this.masp) {
                    cart.setTongTien(cart.getTongTienHang());
                    cart.getListImeis().forEach(imei -> {
                        imei.setMaSpSale(0);
                    });
                    cart.setSoLuongGiam(0);
                    cart.setGiamTheoTien(true);
                    break;
                }
            }
        } else {
            BusVoucherModel busVoucherModel = (BusVoucherModel) cboGiamGia.getSelectedItem();
            for (CartModel cart : QuanLyBanHang.listCart) {
                if (cart.getMactsp() == this.mactsp) {
                    //                    0: tiền, 1 là %
                    cart.getListImeis().forEach(imei -> {
                        imei.setMaSpSale(busVoucherModel.getMaspDCSale());
                    });
                    float tongTienSauSale;
                    if (busVoucherModel.getLoaiGG() == 1) {
                        tongTienSauSale = cart.getTongTienHang() - ((cart.getGia() * busVoucherModel.getMucGG() / 100) * cart.getListImeis().size());
                    } else {
                        tongTienSauSale = cart.getTongTienHang() - (busVoucherModel.getMucGG() * cart.getListImeis().size());
                    }
                    cart.setSoLuongGiam(busVoucherModel.getMucGG());
                    cart.setGiamTheoTien(busVoucherModel.getLoaiGG() == 0);
                    cart.setTongTien(tongTienSauSale);
                    break;
                }
            }
        }
        QuanLyBanHang.fillToCart(QuanLyBanHang.cartModel, QuanLyBanHang.tblCart);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//            public static void main(String args[]) {
//                /* Set the Nimbus look and feel */
//                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//                 */
//                try {
//                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Nimbus".equals(info.getName())) {
//                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                            break;
//                        }
//                    }
//                } catch (ClassNotFoundException ex) {
//                    java.util.logging.Logger.getLogger(SelectVoucherGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (InstantiationException ex) {
//                    java.util.logging.Logger.getLogger(SelectVoucherGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    java.util.logging.Logger.getLogger(SelectVoucherGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//                    java.util.logging.Logger.getLogger(SelectVoucherGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                }
//                //</editor-fold>
//        
//                /* Create and display the form */
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//                        new SelectVoucherGG().setVisible(true);
//                    }
//                });
//            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboGiamGia;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
