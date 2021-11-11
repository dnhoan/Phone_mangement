/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.ISanPhamService.SELECT_ALL;
import BUS.Models.BusCameraModel;
import BUS.Models.BusCameraModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CameraService implements IPhoneMangementService<BusCameraModel, Integer> {

    @Override
    public void insert(BusCameraModel entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BusCameraModel entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusCameraModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL).get(0);
    }

    @Override
    public List<BusCameraModel> selectAll() {
        if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
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
                        rs.getString("dophangiacam")
                );
                listCam.add(cameraModel);
            }
            rs.getStatement().close();
            return listCam;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
