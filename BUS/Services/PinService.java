/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.IPinService.*;


import BUS.Models.BusPinModel;
import BUS.Models.BusPinModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author ADMIN
 */
public class PinService implements IPhoneMangementService<BusPinModel, Integer> {

    @Override
    public void insert(BusPinModel busPinModel) {
          try {
            this.selectBySql(INSERT, busPinModel.getLoaiPin(),busPinModel.getDungLuongPin(),busPinModel.isTrangThai());
        } catch (Exception e) {
            
        }
    }

    @Override
    public void update(BusPinModel busPinModel) {
          try {
            this.selectBySql(UPDATE,
                    busPinModel.getLoaiPin(),
                    busPinModel.getDungLuongPin(),
                   busPinModel.isTrangThai(),
                  busPinModel.getMaLoaiPin()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusPinModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID,id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID,id).get(0);
    }

    public List<BusPinModel> selectAllKD() {
        if (this.selectBySql(SELECT_BY_STATUS,1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,1);
    }
    public List<BusPinModel> selectAllNKD() {
        if (this.selectBySql(SELECT_BY_STATUS,0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,0);
    }
 
    public static void fillCombo(DefaultComboBoxModel<BusPinModel> model, JComboBox cbo, List<BusPinModel> list) {
        PinService pinService = new PinService();
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = pinService.selectAllKD();
            if (list != null) {
                for (BusPinModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<BusPinModel> selectBySql(String sql, Object... args) {
        List<BusPinModel> listPin = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusPinModel pinModel = new BusPinModel(
                        rs.getInt("MaPin"),
                        rs.getString("LoaiPin"),
                        rs.getFloat("DungLuongPin"),
                        rs.getBoolean("TrangThai")
                );
                listPin.add(pinModel);
            }
            rs.getStatement().close();
            return listPin;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<BusPinModel> selectAll() {
         if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
    }

}
