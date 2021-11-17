/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IHoaDonService;
import BUS.Models.BusHoaDon;
import BUS.Models.KhachHangModel;
import BUS.Models.NhanVienModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalHoaDon;
import DAL.Services.JDBCHelper;
import GUI.Services.DateService;
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
        try {
            JDBCHelper.executeUpdate(INSERT, 
                    entity.getManv(),
                    entity.getMakh(), 
                    null,
//                    entity.getMakm(),
                    entity.getGhiChu(),
                    DateService.toString(entity.getNgayBan(), "yyyy-MM-yy")
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
    public List<BusHoaDon> selectAll1() {
        if(this.selectSql(SELECT_ALL1,1) == null) {
            return null;
        }
        return this.selectSql(SELECT_ALL1,1);
    }
    public List<BusHoaDon> selectAll0() {
        if(this.selectSql(SELECT_ALL1,0) == null) {
            return null;
        }
        return this.selectSql(SELECT_ALL1,0);
    }
    public List<BusHoaDon> selectSql(String sql, Object... args) {
        List<BusHoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
               BusHoaDon busHoaDon = this.getResultSet(rs);
               listHoaDon.add(busHoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    BusHoaDon getResultSet(ResultSet rs) throws SQLException {
        BusHoaDon busHoaDon = new BusHoaDon();
        KhachHangModel khachHangModel = new KhachHangModel();
        khachHangModel.setMaKH(rs.getInt("makh"));
        khachHangModel.setTenKH(rs.getString("tenkhach"));
        khachHangModel.setSDT(rs.getString("sdt"));
        NhanVienModel nhanVienModel = new NhanVienModel();
        nhanVienModel.setMaNV(rs.getString("manv"));
        nhanVienModel.setHoTen(rs.getString("tenNhanVien"));
        busHoaDon.setKhachHangModel(khachHangModel);
        busHoaDon.setNhanVienModel(nhanVienModel);
        busHoaDon.setMahd(rs.getInt("mahd"));
        busHoaDon.setNgayBan(rs.getDate("ngayBan"));
        busHoaDon.setNgayTao(rs.getDate("ngaytao"));
        busHoaDon.setSoLuong(rs.getInt("soluong"));
        busHoaDon.setTongTien(rs.getFloat("tong"));
        return busHoaDon;
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
