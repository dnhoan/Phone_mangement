/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.ICameraService;
import static BUS.IServices.ISanPhamService.SELECT_ALL;
import BUS.Models.BusCameraModel;
import BUS.Models.BusCameraModel;
import BUS.Models.BusCameraModel;
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
public class CameraService implements ICameraService, IPhoneMangementService<BusCameraModel, Integer> {

    @Override
    public void insert(BusCameraModel entity) {
        try {
            this.selectBySql(INSERT, 
                    entity.getTenCamera(), 
                    entity.getDoPhanGiai(), 
                    entity.isTrangThai()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusCameraModel entity) {
        try {
            this.selectBySql(UPDATE, 
                    entity.getTenCamera(), 
                    entity.getDoPhanGiai(), 
                    entity.isTrangThai(),
                    entity.getMaCamera()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public BusCameraModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    public List<BusCameraModel> selectRecycle() {
        if (this.selectBySql(SELECT_BY_RECYCLE) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_RECYCLE);
    }

    @Override
    public List<BusCameraModel> selectAll() {
        if (this.selectBySql(SELECT_BY_USING) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_USING);
    }
    public static void fillCombo(DefaultComboBoxModel<BusCameraModel> model, JComboBox cbo, List<BusCameraModel> list) {
        CameraService cameraService = new CameraService();
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = cameraService.selectAll();
            if (list != null) {
                for (BusCameraModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<BusCameraModel> selectBySql(String sql, Object... args) {
        List<BusCameraModel> listCam = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusCameraModel cameraModel = new BusCameraModel(
                        rs.getInt("macamera"),
                        rs.getString("loaicamera"),
                        rs.getString("DoPhanGiai"),
                        rs.getBoolean("trangthai")
                );
                listCam.add(cameraModel);
            }
            rs.getStatement().close();
            return listCam;
        } catch (Exception e) {
        }
        return null;
    }

}
