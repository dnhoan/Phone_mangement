/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.ICpuService;
import BUS.Models.BusCPUModel;
import BUS.Models.BusCPUModel;
import BUS.Models.BusPinModel;
import BUS.Models.BusCPUModel;
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
public class CpuService implements ICpuService, IPhoneMangementService<BusCPUModel, Integer> {

    @Override
    public void insert(BusCPUModel entity) {
        try {
            this.selectBySql(INSERT,
                    entity.getTenCPU(),
                    entity.isTrangThai());
        } catch (Exception e) {

        }
    }

    @Override
    public void update(BusCPUModel entity) {
        try {
            this.selectBySql(UPDATE,
                    entity.getTenCPU(),
                    entity.isTrangThai(),
                    entity.getMaCPU()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<BusCPUModel> selectAll() {
        if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
    }

    public List<BusCPUModel> selectAllsd() {
        if (this.selectBySql(SELECT_BY_STATUS, 1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 1);
    }

    public List<BusCPUModel> selectAllNsd() {
        if (this.selectBySql(SELECT_BY_STATUS, 0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 0);
    }

    public static void fillCombo(DefaultComboBoxModel<BusCPUModel> model, JComboBox cbo, List<BusCPUModel> list) {
        CpuService cpu = new CpuService();
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = cpu.selectAllsd();
            if (list != null) {
                for (BusCPUModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BusCPUModel> selectBySql(String sql, Object... args) {
        List<BusCPUModel> listCPU = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusCPUModel cPUModel = new BusCPUModel(
                        rs.getInt("MaCPU"),
                        rs.getString("TenCPU"),
                        rs.getBoolean("TrangThai")
                );
                listCPU.add(cPUModel);
            }
            rs.getStatement().close();
            return listCPU;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public BusCPUModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

}
