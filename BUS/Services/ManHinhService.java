/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.IManHinhService.*;

import BUS.Models.BusManHinhModel;
import BUS.Models.BusManHinhModel;
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
public class ManHinhService implements IPhoneMangementService<BusManHinhModel, String> {

    @Override
    public void insert(BusManHinhModel entity) {
        try {
            this.selectBySql(INSERT, entity.getLoaiManHinh(), entity.getKichThuoc(), entity.getDoPhanGiaiManHinh(), entity.isTrangThai());
        } catch (Exception e) {

        }
    }

    @Override
    public void update(BusManHinhModel entity) {
        try {
            this.selectBySql(UPDATE,
                    entity.getLoaiManHinh(),
                    entity.getKichThuoc(),
                    entity.getDoPhanGiaiManHinh(),
                    entity.isTrangThai(),
                    entity.getMaManHinh()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusManHinhModel selectByID(String id) {
        if (this.selectBySql(SELECT_BY_ID, id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusManHinhModel> selectAll() {
        if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
    }

    public List<BusManHinhModel> selectAllKD() {
        if (this.selectBySql(SELECT_BY_STATUS, 1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 1);
    }

    public List<BusManHinhModel> selectAllNKD() {
        if (this.selectBySql(SELECT_BY_STATUS, 0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 0);
    }
    public void fillCombo(DefaultComboBoxModel<BusManHinhModel> model, JComboBox cbo, List<BusManHinhModel> list) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = this.selectAll();
            if (list != null) {
                for (BusManHinhModel bus : list) {
                    model.addElement(bus);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<BusManHinhModel> selectBySql(String sql, Object... args) {
        List<BusManHinhModel> listCam = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusManHinhModel manHinhModel = new BusManHinhModel(
                        rs.getString("MaManHinh"),
                        rs.getString("LoaiManHinh"),
                        rs.getFloat("KichThuoc"),
                        rs.getString("DoPhanGiai"),
                        rs.getBoolean("TrangThai")
                );
                listCam.add(manHinhModel);
            }
            rs.getStatement().getConnection().close();
            return listCam;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
