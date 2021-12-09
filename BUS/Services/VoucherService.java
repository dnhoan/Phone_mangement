/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IVoucher;
import BUS.Models.BusVoucherModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author 84349
 */
public class VoucherService implements IVoucher,IPhoneMangementService<BusVoucherModel, Object>{

    @Override
    public void insert(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.isLoaikm(),
                    entity.getTenKM(),
                    entity.getMaVC(),
                    entity.getDieuKienKM(),
                    entity.getLoaiGG(),
                    entity.getNgayBD(),
                    entity.getNgayKT(),
                    entity.getSotienduocTru(),
                    entity.getGiaTriDonHangToiThieu(),
                    entity.isTrangThai()
                    );
//            [loaima],[tenKM],[mavocher],[DieuKienKM],[LoaiGiamGia],[NgayBD],[NgayKT],[sotienduoctru],[giatridonhangtoithieu],[trangthai]
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getDieuKienKM(),
                    entity.getLoaiGG(),
                    entity.getSotienduocTru(),
                    entity.getGiaTriDonHangToiThieu(),
                    entity.getMaVC()
                    );
//            UPDATE KHUYENMAI SET DIEUKIENKM =?, LOAIGIAMGIA=?,SOTIENDUOCTRU=?,GIATRIDONHANGTOITHIEU=? WHERE MAVOCHER=? 
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Object id) {
        try {
            String sql = DELETE;
            JDBCHelper.executeUpdate(sql,
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BusVoucherModel selectByID(Object id) {
        String sql = "SELECT * FROM KhuyenMai WHERE Mavocher=?";
        List<BusVoucherModel> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<BusVoucherModel> selectAll() {
         String sql = SELECT_ALL;
        return selectBySql(sql);
    }

    @Override
    public List<BusVoucherModel> selectBySql(String sql, Object... args) {
        List<BusVoucherModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BusVoucherModel model = readFromResultSet(rs);
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

    
    
    private BusVoucherModel readFromResultSet(ResultSet rs) throws SQLException {
        BusVoucherModel entity = new BusVoucherModel();
        entity.setMaKM(rs.getInt("MaKM"));
        entity.setLoaikm(rs.getBoolean("loaima"));
        entity.setTenKM(rs.getString("tenKM"));
      entity.setMaVC(rs.getString("mavocher"));
       entity.setDieuKienKM(rs.getString("DieuKienKM"));
        entity.setLoaiGG(rs.getInt("LoaiGiamGia"));
        entity.setNgayBD(rs.getDate("NgayBD"));
       entity.setNgayKT(rs.getDate("NgayKT"));
       entity.setSotienduocTru(rs.getInt("sotienduoctru"));
       entity.setGiaTriDonHangToiThieu(rs.getInt("giatridonhangtoithieu"));
       entity.setTrangThai(rs.getBoolean("trangthai"));
        return entity;

    }
    
}
