
package BUS.Services;

import BUS.Models.BusMauSacModel;
import DAL.Models.DalMauSacModel;
import DAL.Services.DalMauSacService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MauSacService {

    static DalMauSacService dalMauSacService = new DalMauSacService();
    public MauSacService() {
    }
    
    static List<BusMauSacModel> listMau = new ArrayList<>();
    static List<DalMauSacModel> listDal = new ArrayList<>();
    public static void getDataMau(int trangThai) {
        listDal.clear();
        listMau.clear();
        try {
            listDal = dalMauSacService.selectTable(trangThai);
            if(listDal.size() > 0) {
                listDal.stream().map(mau -> {
                    BusMauSacModel busMauSacModel = new BusMauSacModel();
                    busMauSacModel.setDalMauSacModel(mau);
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
            for(BusMauSacModel mau: listMau) {
                model.addRow(new Object[] {
                    mau.getDalMauSacModel().getMaMau(),
                    mau.getDalMauSacModel().getTenMau(),
                    mau.getDalMauSacModel().isTrangThai() ? "Đang kinh doanh" : "Ngừng kinh doanh"
                });
            }
        }
    }
    public static BusMauSacModel selectMauSac(Integer maMau) {
        BusMauSacModel busMauSacModel = new BusMauSacModel();
        try {
            DalMauSacModel dal  = dalMauSacService.selectByID(maMau);
            busMauSacModel.setDalMauSacModel(dal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return busMauSacModel;
    }
    public static boolean insert(DalMauSacModel dalMauSacModel) {
        try {
            dalMauSacService.insert(dalMauSacModel);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static boolean update(DalMauSacModel dalMauSacModel) {
        try {
            dalMauSacService.update(dalMauSacModel);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static void fillCombo(DefaultComboBoxModel<BusMauSacModel> model, JComboBox cbo) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            getDataMau(1);
            if (listMau != null) {
                for (BusMauSacModel bus : listMau) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
