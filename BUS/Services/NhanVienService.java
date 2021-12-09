/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.INhanVienServices;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.NhanVienModel;
import DAL.Services.JDBCHelper;


import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author 84349
 */
public class NhanVienService implements IPhoneMangementService<NhanVienModel, String>, INhanVienServices {

    @Override
    public void insert(NhanVienModel entity) {
        String sql = INSERT;
        try {
            JDBCHelper.executeUpdate(sql,
                    entity.getMaNV(),
                    entity.getMatKhau(),
                    entity.getHoTen(),
                    entity.getSDT(),
                    entity.isGioiTinh(),
                    entity.getNgaySinh(),
                    entity.getDiaChi(),
                    entity.isVaiTro(),
                    entity.getGhiChu(),
                    entity.getHinh(),
                    entity.getNgayBD(),
                    entity.getEmail()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVienModel entity) {
        try {
            this.selectBySql(UPDATE,
                    entity.getMatKhau(),
                    entity.getHoTen(),
                    entity.getSDT(),
                    entity.isGioiTinh(),
                    entity.getNgaySinh(),
                    entity.getDiaChi(),
                    entity.isVaiTro(),
                    entity.getGhiChu(),
                    entity.getHinh(),
                    entity.getEmail(),
                    entity.getNgayBD(),
                    entity.getMaNV()
            );
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    @Override
    public NhanVienModel selectByID(String id) {
        String sql = "SELECT * FROM Nhanvien WHERE Manv=?";
        List<NhanVienModel> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVienModel> selectAll() {
        String sql = SELECT_ALL;
        return selectBySql(sql);
    }

    public List<NhanVienModel> selectAllON() {
        String sql = SELECT_ON;
        return selectBySql(sql);
    }

    public List<NhanVienModel> selectAllOFF() {
        String sql = SELECT_OFF;
//        JDBCHelper.executeQuery(sql, args)
        return selectBySql(sql);
    }

    public void Ngaynghi(String date, String maNV) {
        try {
            String SQl = UPDATE_NGAYNGHI;

            JDBCHelper.executeUpdate(SQl,
                    date, maNV
            );
        } catch (Exception e) {
        }

    }
    public List<NhanVienModel> selectByKeywordON(String keyword) {
        
        return selectBySql(SELECT_BY_KEYWORD_ON, "%" + keyword + "%");
    }
    public List<NhanVienModel> selectByKeywordOFF(String keyword) {
        
        return selectBySql(SELECT_BY_KEYWORD_OFF, "%" + keyword + "%");
    }

    @Override
    public List<NhanVienModel> selectBySql(String sql, Object... args) {
        List<NhanVienModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVienModel model = readFromResultSet(rs);
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

    @Override
    public void delete(String id) {
        try {
            String sql = DELETE;
            JDBCHelper.executeUpdate(sql,
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void KhoiPhuc(String id) {
        try {
            String sql = KHOIPHUC;
            JDBCHelper.executeUpdate(sql,
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    [MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD
    private NhanVienModel readFromResultSet(ResultSet rs) throws SQLException {
        NhanVienModel model = new NhanVienModel();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setSDT(rs.getString("SDT"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setVaiTro(rs.getBoolean("Vaitro"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setHinh(rs.getString("Hinh"));
        model.setNgayBD(rs.getDate("NgayBD"));
        model.setNgayKT(rs.getDate("NgayKT"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setEmail(rs.getString("Email"));
        return model;

    }

    

}
