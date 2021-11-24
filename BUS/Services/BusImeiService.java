/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.BusImeiModel;
import DAL.Models.DalImeiModel;
import DAL.Services.DalImeiService;
import GUI.QLImei;
import GUI.QuanLySanPham;
import static GUI.QuanLySanPham.cboListImei;
import static GUI.QuanLySanPham.cboSanPham;
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
                System.out.println(i.getMaImei());
                BusImeiModel busImeiModel = new BusImeiModel();
                busImeiModel.setDalImeiModel(i);
                listBusImei.add(busImeiModel);
            });
        } catch (Exception e) {
        }
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
                if (MessageService.confirm(null, "Xoa ko")) {
                    int row = tbl.getSelectedRow();
                    int maImei = (int) tbl.getValueAt(row, 0);
                    dalImeiService.delete(maImei);
                    int currentStock = Integer.parseInt(QuanLySanPham.txtTonKho.getText());
                    System.out.println("stock " + currentStock);
                    if (currentStock > 0) {
                        currentStock--;
                    }
                    System.out.println("stock2 " + currentStock);
                    QuanLySanPham.txtTonKho.setText(currentStock + "");
                    getImeiByMactsp(QLImei.mactsp, "");
                    fillTable(model, tbl, listDalImei);
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
        System.out.println("imei xoa " +maImei);
        try {
            dalImeiService.updateStatusSell(maImei, statusSell);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void fillcboImeiBymactsp(DefaultComboBoxModel<DalImeiModel> model, JComboBox cbo) {
        fillComboImei(model, cbo, listDalImei);
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
