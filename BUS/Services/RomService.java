/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IRomService;
import static BUS.IServices.ISanPhamService.SELECT_ALL;
import BUS.Models.BusRomModel;
import BUS.Models.BusRomModel;
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
public class RomService implements IRomService, IPhoneMangementService<BusRomModel, Integer> {

    @Override
    public void insert(BusRomModel busRomModel) {
        try {
            this.selectBySql(INSERT,
                    busRomModel.getLoaiRon(),
                    busRomModel.getDungLuongRom()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusRomModel busRomModel) {
        try {
            this.selectBySql(UPDATE,
                    busRomModel.getLoaiRon(),
                    busRomModel.getDungLuongRom(),
                    busRomModel.isTrangThai(),
                    busRomModel.getMaRom()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            this.selectBySql(DELETE, id
            );
        } catch (Exception e) {
        }
    }
    
    public void backup(Integer id) {
        try {
            this.selectBySql(BACK_UP, id
            );
        } catch (Exception e) {
        }
    }
    
    public void deleteforever(Integer id) {
        try {
            this.selectBySql(DELETE_FOREVER, id
            );
        } catch (Exception e) {
        }
    }

    @Override
    public BusRomModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID,id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusRomModel> selectAll() {
        if (this.selectBySql(SELECT_BY_STATUS,1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,1);
    }
    
    public List<BusRomModel> selectRecycle() {
        if (this.selectBySql(SELECT_BY_STATUS, 0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 0);
    }

    @Override
    public List<BusRomModel> selectBySql(String sql, Object... args) {
        List<BusRomModel> listRoms = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusRomModel romModel = new BusRomModel(
                        rs.getInt("marom"),
                        rs.getString("tenrom"),
                        rs.getFloat("Dungluong"),
                        rs.getBoolean("trangthai")
                );
                listRoms.add(romModel);
            }
            rs.getStatement().close();
            return listRoms;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
