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
    
    public boolean isImeiExist(String imei) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CHECK_EXIST, imei);
            while(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isDuocPhepXoa(int maImei) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CHECK_TRANG_THAI_BAN, maImei);
            while(rs.next()) {
                if(rs.getBoolean("TrangThaiBan")) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void updateMaSPSale(int maImei, int maspSale) {
        try {
            JDBCHelper.executeUpdate("update Imei set MaSPSale = ? where MaImei = ?", maspSale, maImei);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean updateDoiHang(int currentImei, int newImei, String ghiChu, int maspsale) {
        try {
            JDBCHelper.executeUpdate(UPDATE_GHICHU, ghiChu, currentImei);
            JDBCHelper.executeUpdate(UPDATE_IMEI_IN_CTHD, newImei, currentImei);
            JDBCHelper.executeUpdate(UPDATE_MASPSALE_NEWIMEI_IN_HOADON, maspsale, newImei);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void updateStatusSellByMaHD(Integer statusSell, Integer mahd) {
//        1: Chưa bán
//        0: Đã bán
        try {
            JDBCHelper.executeUpdate(UPDATE_STATUS_SELL_BY_MAHD,
                    statusSell,
                    mahd
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusSell(Integer maImei, Integer statusSell) {
//        1: Chưa bán
//        0: Đã bán
        try {
            JDBCHelper.executeUpdate(UPDATE_STATUS_SELL,
                    statusSell,
                    maImei
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

    public List<DalImeiModel> selectByMaCtSp(Integer mactsp, String search) {
        return this.selectBySql(SELECT_BY_IDSP, mactsp, "%" + search + "%") == null ? null : this.selectBySql(SELECT_BY_IDSP, mactsp, "%" + search + "%");
    }

    public List<DalImeiModel> selectImeisNotSell(Integer mactsp) {
        return this.selectBySql(SELECT_IMEIS_NOT_SELL, mactsp) == null ? null : this.selectBySql(SELECT_IMEIS_NOT_SELL, mactsp);
    }

    public List<DalImeiModel> selectImeisByMactspAndMahd(Integer mactsp, Integer mahd) {
        return this.selectBySql(SELECT_IMEI_BY_MACTSP_AND_MAHD, mactsp, mahd) == null ? null : this.selectBySql(SELECT_IMEI_BY_MACTSP_AND_MAHD, mactsp, mahd);
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
                dalImeiModel.setTrangThaiBan(rs.getBoolean("TrangThaiBan"));
                dalImeiModel.setGhiChu(rs.getString("ghichu"));
                listImei.add(dalImeiModel);
            }
            return listImei;
        } catch (SQLException e) {
        }
        return null;
    }

}
