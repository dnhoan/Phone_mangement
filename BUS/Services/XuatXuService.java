/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.ISanPhamService.SELECT_ALL;
import BUS.IServices.IXuatXuService;
import BUS.Models.BusXuatXuModel;
import BUS.Models.BusXuatXuModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BUS.IServices.IXuatXuService;
import BUS.Models.BusXuatXuModel;

/**
 *
 * @author ADMIN
 */
public class XuatXuService implements IXuatXuService, IPhoneMangementService<BusXuatXuModel, Integer> {
//  String INSERT = "INSERT INTO XuatXu(NoiXuatXu, TrangThai) VALUES (?,?)";
//    String SELECT_ALL = "SELECT * FROM XuatXu";
//    String SELECT_BY_ID = "SELECT * FROM XuatXu WHERE MaXuatXu = ?";
//    String UPDATE = "UPDATE XuatXu SET NoiXuatXu =?, TrangThai = ? WHERE MaXuatXu = ?";
//    String SELECT_BY_STATUS = "SELECT * FROM XuatXu WHERE TrangThai = 0";
    String KHOIPHUC = "UPDATE XuatXu SET TrangThai = 1 WHERE MaXuatXu = ?";
      public  void khoiphuc(BusXuatXuModel entity){
        try {
            this.selectBySql(KHOIPHUC, entity.getMaXuatXu());
        } catch (Exception e) {
        }
    }
    @Override
    public void insert(BusXuatXuModel entity) {
          try {
            this.selectBySql( INSERT, entity.getNoiXuatXu(),entity.isTrangThai());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusXuatXuModel entity) {
         try {
            this.selectBySql(UPDATE, entity.getNoiXuatXu(),entity.isTrangThai(),entity.getMaXuatXu());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusXuatXuModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusXuatXuModel> selectAll() {
        if (this.selectBySql(SELECT_BY_STATUS,1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,1);
    }
      public List<BusXuatXuModel> selectStatus(){
         if (this.selectBySql(SELECT_BY_STATUS,0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,0);
    }

    @Override
    public List<BusXuatXuModel> selectBySql(String sql, Object... args) {
        List<BusXuatXuModel> listCam = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusXuatXuModel xuatXuModel = new BusXuatXuModel(
                        rs.getInt("MaXuatXu"),
                        rs.getString("NoiXuatXu"),
                        rs.getBoolean("TrangThai")
                );
                listCam.add(xuatXuModel);
            }
            rs.getStatement().close();
            return listCam;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
