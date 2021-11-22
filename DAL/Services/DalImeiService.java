/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.IServices.IDalImeiService;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalImeiModel;
import GUI.QuanLySanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DalImeiService implements IPhoneMangementService<DalImeiModel, Integer>, IDalImeiService {

    @Override
    public void insert(DalImeiModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.getMaCtsp(),
                    entity.getMaSpSale() == 0 ? null : entity.getMaSpSale(),
                    entity.getTenImei()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalImeiModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getTenImei(),
                    entity.getMaImei()
            );
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JDBCHelper.executeUpdate(DELETE, id);
        } catch (SQLException e) {
        }
    }
    
    @Override
    public DalImeiModel selectByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DalImeiModel> selectByMaCtSp(Integer id, String search) {
        return this.selectBySql(SELECT_BY_IDSP, id, "%" + search + "%") == null ? null : this.selectBySql(SELECT_BY_IDSP, id, "%" + search + "%");
    }

    @Override
    public List<DalImeiModel> selectAll() {
        return null;
    }

    @Override
    public List<DalImeiModel> selectBySql(String sql, Object... args) {
        List<DalImeiModel> listImei = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DalImeiModel dalImeiModel = new DalImeiModel();
                dalImeiModel.setMaImei(rs.getInt("maImei"));
                dalImeiModel.setMaCtsp(rs.getInt("mactsp"));
                dalImeiModel.setTenImei(rs.getString("tenImei"));
                dalImeiModel.setMaSpSale(rs.getInt("maspsale"));
                listImei.add(dalImeiModel);
            }
            return listImei;
        } catch (SQLException e) {
        }
        return null;
    }

}
