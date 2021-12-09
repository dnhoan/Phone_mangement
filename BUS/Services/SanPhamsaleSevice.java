/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.BusVoucherModel;
import BUS.Models.spsalemodel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author 84349
 */
public class SanPhamsaleSevice implements IPhoneMangementService<spsalemodel, Object> {
     

    @Override
    public void insert(spsalemodel entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(spsalemodel entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public spsalemodel selectByID(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<spsalemodel> selectAll() {
      String sql = "select * from sanphamdcsale ";
        return selectBySql(sql);
    }
    public List<spsalemodel> selectByMaKM(int makm) {
        String sql = "select * from sanphamdcsale where makm=?";
        return selectBySql(sql, makm);
    }

    @Override
    public List<spsalemodel> selectBySql(String sql, Object... args) {
       
        List<spsalemodel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    spsalemodel model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
//            System.out.println("hi");
            throw new RuntimeException(ex);
        }
        return list;
    }
    private spsalemodel readFromResultSet(ResultSet rs) throws SQLException {
        spsalemodel model = new spsalemodel();
        model.setMaKM(rs.getInt("makm"));
        model.setMaSP(rs.getInt("masp"));
        return model;

    }
}