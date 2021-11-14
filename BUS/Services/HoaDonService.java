/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IHoaDonService;
import BUS.Models.BusCTHoaDon;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalHoaDon;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonService implements IPhoneMangementService<DalHoaDon, Integer>, IHoaDonService{

    @Override
    public void insert(DalHoaDon entity) {
        System.out.println(entity.getManv() + " " +
                    entity.getMakh() + " " +
                    entity.getMakm());
        try {
            JDBCHelper.executeUpdate(INSERT, 
                    entity.getManv(),
                    entity.getMakh(), 
                    null,
//                    entity.getMakm(),
                    entity.getGhiChu()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE, 
                    entity.getManv(),
                    entity.getMakh(),
                    entity.getMakm(),
                    entity.getMaHD()
                    );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JDBCHelper.executeUpdate(DELETE, id);
        } catch (Exception e) {
        }
    }
    public Integer selectLasID() {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SELECT_LASTID);
            while(rs.next()) {
                return rs.getInt("LastID");
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<BusCTHoaDon> selectSql(String sql, Object... args) {
        List<BusCTHoaDon> listCTHD = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                BusCTHoaDon busCTHoaDon = new BusCTHoaDon();
                busCTHoaDon.setMacthd(rs.getInt("macthd"));
                busCTHoaDon.setMacthd(0);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
    @Override
    public DalHoaDon selectByID(Integer id) {
        return null;
    }

    @Override
    public List<DalHoaDon> selectAll() {
        return null;
    }

    @Override
    public List<DalHoaDon> selectBySql(String sql, Object... args) {
        return null;
    }
    
}
