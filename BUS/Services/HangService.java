/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.ISanPhamService.SELECT_ALL;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import BUS.IServices.IHangService;
import BUS.Models.BusDongSpModel;
import BUS.Models.BusHangModel;
import BUS.Models.BusHangModel;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author ADMIN
 */
public class HangService implements IHangService, IPhoneMangementService<BusHangModel, Integer> {
//     String INSERT = "INSERT INTO HangSanPham(TenHang, TrangThai) VALUES (?,?)";
//    String SELECT_ALL = "SELECT * FROM HangSanPham";
//    String SELECT_BY_ID = "SELECT * FROM HangSanPham WHERE MaHang = ?";

    String KHOIPHUC = "UPDATE HangSanPham SET TrangThai = 1 WHERE MaHang = ?";
//    String SELECT_BY_STATUS = "SELECT * FROM HangSanPham WHERE TrangThai = 1";

    public void khoiphuc(BusHangModel entity) {
        try {
            this.selectBySql(KHOIPHUC, entity.getMaHang());
        } catch (Exception e) {
        }
    }

    @Override
    public void insert(BusHangModel entity) {
        try {
            this.selectBySql(INSERT, entity.getTenHang(), entity.isTrangThai());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusHangModel entity) {
        try {
            this.selectBySql(UPDATE, entity.getTenHang(), entity.isTrangThai(), entity.getMaHang());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public BusHangModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusHangModel> selectAll() {
        if (this.selectBySql(SELECT_BY_STATUS, 1) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 1);
    }

    public List<BusHangModel> selectStatus() {
        if (this.selectBySql(SELECT_BY_STATUS, 0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 0);
    }

    @Override
    public List<BusHangModel> selectBySql(String sql, Object... args) {
        List<BusHangModel> listHang = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusHangModel busHangModel = new BusHangModel(
                        rs.getInt("MaHang"),
                        rs.getString("TenHang"),
                        rs.getBoolean("TrangThai")
                );
                listHang.add(busHangModel);
            }
            rs.getStatement().close();
            return listHang;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
