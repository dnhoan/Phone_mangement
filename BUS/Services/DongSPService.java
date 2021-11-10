/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IDongService;
import BUS.Models.BusDongSpModel;
import BUS.Models.BusHangModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DongSPService implements IDongService, IPhoneMangementService<BusDongSpModel, Integer> {

    @Override
    public void insert(BusDongSpModel entity) {
        try {
            this.selectBySql(INSERT,
                    entity.getTenDong(),
                    entity.getBusHangModel().getMaHang(),
                    entity.isTrangThai()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusDongSpModel entity) {
        try {
            this.selectBySql(UPDATE,
                    entity.getTenDong(),
                    entity.getBusHangModel().getMaHang(),
                    entity.isTrangThai(),
                    entity.getMaDong()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusDongSpModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusDongSpModel> selectAll() {
        if (this.selectBySql(SELECT_BY_STATUS) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS);
    }

    public List<BusDongSpModel> selectRecycle() {
        if (this.selectBySql(SELECT_BY_RECYCLE) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_RECYCLE);
    }

    public List<BusDongSpModel> selectByHangsp(int id) {
        System.out.println(id);
        if (this.selectBySql(SELECT_BY_MAHANG, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_MAHANG, id);
    }

    @Override
    public List<BusDongSpModel> selectBySql(String sql, Object... args) {
        List<BusDongSpModel> listDongsp = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusHangModel dalHangModel = new BusHangModel(
                        rs.getInt("mahang"),
                        rs.getString("tenHang")
                );
                BusDongSpModel busDongSpModel = new BusDongSpModel(
                        rs.getInt("madong"),
                        rs.getString("tendong"),
                        dalHangModel,
                        rs.getBoolean("trangthai")
                );
                listDongsp.add(busDongSpModel);
            }
            rs.getStatement().close();
            return listDongsp;
        } catch (Exception e) {
        }
        return null;
    }

}
