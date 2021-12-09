/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import static BUS.IServices.ISanPhamService.INSERT;
import static BUS.IServices.ISanPhamService.SELECT_ALL;
import static BUS.IServices.ISanPhamService.SELECT_BY_ID;
import static BUS.IServices.ISanPhamService.UPDATE;
import DAL.IServices.IDalPhanLoaiSpService;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalPhanLoaiSpModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DalPhanLoaiSpService implements IDalPhanLoaiSpService, IPhoneMangementService<DalPhanLoaiSpModel, Integer> {

    @Override
    public void insert(DalPhanLoaiSpModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.getTenLoai(),
                    entity.isTrangThai()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalPhanLoaiSpModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getTenLoai(),
                    entity.isTrangThai(),
                    entity.getMaPhanLoai()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public DalPhanLoaiSpModel selectByID(Integer id) {
        try {
            return this.selectBySql(SELECT_BY_ID, id).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DalPhanLoaiSpModel> selectTable(int trangThai) {
        try {
            return this.selectBySql(SELECT_ALL, trangThai) == null ? null : this.selectBySql(SELECT_ALL, trangThai);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<DalPhanLoaiSpModel> selectBySql(String sql, Object... args) {
        List<DalPhanLoaiSpModel> listMau = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DalPhanLoaiSpModel mau = new DalPhanLoaiSpModel();
                mau.setMaPhanLoai(rs.getInt("MaPhanLoai"));
                mau.setTenLoai(rs.getString("Loai"));
                mau.setTrangThai(rs.getBoolean("trangthai"));
                listMau.add(mau);
            }
            rs.getStatement().close();
            return listMau;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<DalPhanLoaiSpModel> selectAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

}
