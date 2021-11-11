/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.ILoaiSanPhamService;
import BUS.Models.BusDongSpModel;
import BUS.Models.BusHangModel;
import BUS.Models.BusSanPham;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalLoaiSanPham;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiSPService implements ILoaiSanPhamService, IPhoneMangementService<DalLoaiSanPham, Integer> {

    @Override
    public void insert(DalLoaiSanPham sp) {
        try {
            this.select(INSERT,
                    sp.getTensp(),
                    sp.getMaDong()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void update(DalLoaiSanPham sp) {
        try {
            this.select(UPDATE,
                    sp.getTensp(),
                    sp.getMaDong(),
                    sp.getMasp()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            this.select(DELETE, id
            );
        } catch (Exception e) {
        }
    }

    @Override
    public DalLoaiSanPham selectByID(Integer id) {
        return null;
    }

    public void backup(Integer id) {
        try {
            this.select(BACK_UP, id
            );
        } catch (Exception e) {
        }
    }

    public BusSanPham selectID(Integer id) {
        if (this.select(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.select(SELECT_BY_ID, id).get(0);
    }

    public List<BusSanPham> select(String sql, Object... args) {
        List<BusSanPham> listProducts = new ArrayList<>();
        try {
            ResultSet resultSet = JDBCHelper.executeQuery(sql, args);
            while (resultSet.next()) {
                BusSanPham product = this.getResultSet(resultSet);
                listProducts.add(product);
            }
            resultSet.getStatement().close();
            return listProducts;
        } catch (Exception e) {
        }
        return null;
    }

    public List<BusSanPham> selectInRecycle() {
        if (this.select(SELECT_RECYCLE) == null) {
            return null;
        }
        return this.select(SELECT_RECYCLE);
    }
    public List<BusSanPham> selectByDongsp(Integer idDong) {
        if (this.select(SELECT_BY_ID_DONG, idDong) == null) {
            return null;
        }
        return this.select(SELECT_BY_ID_DONG, idDong);
    } 
    public List<BusSanPham> selectBySearch(String keyWord) {
        return this.select(SELECT_BY_KEYWORD, "%" + keyWord + "%");
    }

    private BusSanPham getResultSet(ResultSet rs) throws SQLException {
        BusHangModel busHangModel = new BusHangModel(
                rs.getInt("mahang"),
                rs.getString("tenHang")
        );
        BusDongSpModel busDongSpModel = new BusDongSpModel(
                rs.getInt("madong"),
                rs.getString("tendong"),
                busHangModel
        );
        BusSanPham sanPham = new BusSanPham(
                rs.getInt("masp"),
                rs.getString("tensp"),
                busDongSpModel,
                rs.getBoolean("trangthai"));
        return sanPham;
    }

    @Override
    public List<DalLoaiSanPham> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DalLoaiSanPham> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
