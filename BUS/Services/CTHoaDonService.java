/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.ICTHoaDonService;
import BUS.Models.BusCTHoaDon;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalChiTietHoaDon;
import DAL.Services.JDBCHelper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CTHoaDonService implements ICTHoaDonService , IPhoneMangementService<DalChiTietHoaDon, Integer>{

    @Override
    public void insert(DalChiTietHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(INSERT, 
                    entity.getMahd(),
                    entity.getMactsp(),
                    entity.getSoLuong(),
                    entity.getGia()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalChiTietHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE, 
                    entity.getMahd(),
                    entity.getMactsp(),
                    entity.getSoLuong(),
                    entity.getGia(),
                    entity.getMacthd()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JDBCHelper.executeUpdate(DELETE, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DalChiTietHoaDon selectByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DalChiTietHoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DalChiTietHoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
