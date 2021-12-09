/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.BusPhanLoaiSpModel;
import DAL.Models.DalPhanLoaiSpModel;
import DAL.Services.DalPhanLoaiSpService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BusPhanLoaiSpService {
     static DalPhanLoaiSpService dalPhanLoaiSpService = new DalPhanLoaiSpService();
    
    static List<BusPhanLoaiSpModel> listMau = new ArrayList<>();
    static List<DalPhanLoaiSpModel> listDal = new ArrayList<>();
    public static void getDataMau(int trangThai) {
        listDal.clear();
        listMau.clear();
        try {
            listDal = dalPhanLoaiSpService.selectTable(trangThai);
            if(listDal.size() > 0) {
                listDal.stream().map(mau -> {
                    BusPhanLoaiSpModel busMauSacModel = new BusPhanLoaiSpModel();
                    busMauSacModel.setDalPhanLoaiSpModel(mau);
                    return busMauSacModel;
                }).forEachOrdered(busMauSacModel -> {
                    listMau.add(busMauSacModel);
                });
            }
        } catch (Exception e) {
        }
    }
    public static void fillTable(DefaultTableModel model, JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        if(listMau.size() > 0) {
            for(BusPhanLoaiSpModel mau: listMau) {
                model.addRow(new Object[] {
                    mau.getDalPhanLoaiSpModel().getMaPhanLoai(),
                    mau.getDalPhanLoaiSpModel().getTenLoai(),
                    mau.getDalPhanLoaiSpModel().isTrangThai() ? "Đang kinh doanh" : "Ngừng kinh doanh"
                });
            }
        }
    }
    public static BusPhanLoaiSpModel selectMauSac(Integer maMau) {
        BusPhanLoaiSpModel busMauSacModel = new BusPhanLoaiSpModel();
        try {
            DalPhanLoaiSpModel dal  = dalPhanLoaiSpService.selectByID(maMau);
            busMauSacModel.setDalPhanLoaiSpModel(dal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return busMauSacModel;
    }
    public static boolean insert(DalPhanLoaiSpModel dalMauSacModel) {
        try {
            dalPhanLoaiSpService.insert(dalMauSacModel);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static boolean update(DalPhanLoaiSpModel dalMauSacModel) {
        try {
            dalPhanLoaiSpService.update(dalMauSacModel);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static void fillCombo(DefaultComboBoxModel<BusPhanLoaiSpModel> model, JComboBox cbo) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            getDataMau(1);
            if (listMau != null) {
                for (BusPhanLoaiSpModel bus : listMau) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
