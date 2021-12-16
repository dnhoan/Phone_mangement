/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.BusImeiModel;
import DAL.Models.DalImeiModel;
import DAL.Services.DalImeiService;
import GUI.Models.CartModel;
import GUI.QLImei;
import GUI.QuanLySanPham;
import static GUI.QuanLySanPham.cboListImei;
import static GUI.QuanLySanPham.cboSanPham;
import GUI.QuanLyBanHang;
import GUI.Services.ButtonColumn;
import GUI.Services.MessageService;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BusImeiService {

    static DalImeiService dalImeiService = new DalImeiService();
    public static List<BusImeiModel> listBusImei = new ArrayList<>();
    public static List<DalImeiModel> listDalImei = new ArrayList<>();

    public static void getImeiByMactsp(Integer mactsp, String keyWord) {
        try {
            listDalImei = dalImeiService.selectByMaCtSp(mactsp, keyWord);
            listDalImei.forEach(i -> {
                BusImeiModel busImeiModel = new BusImeiModel();
                busImeiModel.setDalImeiModel(i);
                listBusImei.add(busImeiModel);
            });
        } catch (Exception e) {
        }
    }

    public static List<DalImeiModel> getImeisByMactspAndMahd(int mactsp, int mahd) {
        try {
            listDalImei = dalImeiService.selectImeisByMactspAndMahd(mactsp, mahd);
            return listDalImei;
        } catch (Exception e) {
        }
        return null;
    }

    public static void getImeisNotSell(Integer mactsp) {
        try {
            listDalImei = dalImeiService.selectImeisNotSell(mactsp);
            listDalImei.forEach(i -> {
                System.out.println(i.getMaImei());
                BusImeiModel busImeiModel = new BusImeiModel();
                busImeiModel.setDalImeiModel(i);
                listBusImei.add(busImeiModel);
            });
        } catch (Exception e) {
        }
    }

    public static void fillTable(DefaultTableModel model, JTable tbl, List<DalImeiModel> list) {
        buttonRemove(model, tbl);
        model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        if (list.size() > 0) {
            for (DalImeiModel imei : list) {
                model.addRow(new Object[]{
                    imei.getMaImei(),
                    imei.getTenImei(),
                    "Xóa"
                });
            }
        }
        QLImei.lblSoluong.setText("Tổng: " + QLImei.tblImei.getRowCount());
    }

    public static void buttonRemove(DefaultTableModel model, JTable tbl) {
        Action remove = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbl.getSelectedRow();
                int maImei = (int) tbl.getValueAt(row, 0);
                if (dalImeiService.isDuocPhepXoa(maImei)) {
                    if (MessageService.confirm(null, "Bạn có thực sự muốn xóa máy có Imei này không ?")) {
                        dalImeiService.delete(maImei);
                        int currentStock = Integer.parseInt(QuanLySanPham.txtTonKho.getText());
                        if (currentStock > 0) {
                            currentStock--;
                        }
                        MessageService.alert(null, "Xóa Imei máy thành công !");
                        QuanLySanPham.txtTonKho.setText(currentStock + "");
                        getImeiByMactsp(QLImei.mactsp, "");
                        fillTable(model, tbl, listDalImei);
                    }
                } else {
                    MessageService.alert(null, "Mã Imei đã được bán cho khách hàng @");
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tbl, remove, 2);

        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    public static boolean insert(DalImeiModel dalImeiModel) {
        try {
            dalImeiService.insert(dalImeiModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update(DalImeiModel dalImeiModel) {
        try {
            dalImeiService.update(dalImeiModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateStatusSell(Integer maImei, Integer statusSell) {
        try {
            dalImeiService.updateStatusSell(maImei, statusSell);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateStatusSellByMahd(Integer statusSell, Integer mahd) {
        try {
            dalImeiService.updateStatusSellByMaHD(statusSell, mahd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateGhiChuImei(int currentImei, int newImei, String ghiChu, int maspsale) {
        try {
            dalImeiService.updateDoiHang(currentImei, newImei, ghiChu, maspsale);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void fillcboImeiBymactsp(DefaultComboBoxModel<DalImeiModel> model, JComboBox cbo, int mactsp) {
        if (QuanLyBanHang.listCart.size() > 0) {
            List<CartModel> listTestExist = QuanLyBanHang.listCart.stream().filter(ca -> ca.getMactsp() == mactsp).toList();
            if (listTestExist.size() > 0) {
                CartModel currentCart = listTestExist.get(0);
                if (currentCart != null) {
                    if (currentCart.getListImeis().size() > 0) {
                        currentCart.getListImeis().forEach(imeiCart -> {
                            int index = 0;
                            boolean isDelete = false;
                            for (int i = 0; i < listDalImei.size(); i++) {
                                if (listDalImei.get(i).getTenImei().equals(imeiCart.getTenImei())) {
                                    index = i;
                                    isDelete = true;
                                }
                            }
                            if (isDelete) {
                                listDalImei.remove(index);
                            }
                        });
                    }
                }
            }
        }
        fillComboImei(model, cbo, listDalImei);
    }

    public static void fillComboImeiDoihang(DefaultComboBoxModel<DalImeiModel> model, JComboBox cbo, int mactsp) {
        try {
            listDalImei = dalImeiService.selectImeisNotSell(mactsp);
            fillComboImei(model, cbo, listDalImei);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillComboImei(DefaultComboBoxModel<DalImeiModel> model, JComboBox cbo, List<DalImeiModel> list) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            for (DalImeiModel imei : list) {
                model.addElement(imei);
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
        }
    }
}
