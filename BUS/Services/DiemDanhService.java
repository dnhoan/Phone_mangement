/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import DAL.Services.JDBCHelper;
import BUS.Models.BusDiemDanh;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author LENOVO
 */
public class DiemDanhService {

    String sqlSelect1 = "select * from DiemDanh";
    String sqlDiemDanh = "insert into DiemDanh(MaNV,DiemDanh,DiMuon,NgayDiemDanh) values(?,1,0,getdate())";
    String sqlDiMuon = "insert into DiemDanh(MaNV,DiemDanh,DiMuon,NgayDiemDanh) values(?,1,1,getdate())";
    String sqlBoVe = "UPDATE DiemDanh set TrangThai = 0 where MaDiemDanh = ?";
    String sqlThongKe = "select  diemdanh.MaNV, count( DiemDanh.DiemDanh) as diemdanh, MONTH(DiemDanh.NgayDiemDanh) as thang -- count(diemdanh.DiMuon) as solandimuon\n"
            + "from DiemDanh,NhanVien\n"
            + "where NhanVien.MaNV = DiemDanh.MaNV and DiemDanh.TrangThai = 1 --and MONTH(DiemDanh.NgayDiemDanh) = MONTH(GETDATE())   -- DiemDanh.DiMuon =1\n"
            + "group by DiemDanh.MaNV, NhanVien.HoTen, MONTH(DiemDanh.NgayDiemDanh) ";

    public void select1(BusDiemDanh model) {
        try {

        } catch (Exception e) {
        }
    }
    

    public List<BusDiemDanh> selectAll() {
        if (this.selectBySql(sqlSelect1) == null) {
            return null;
        }
        return this.selectBySql(sqlSelect1);
    }

    public List<BusDiemDanh> thongKe() {
        if (this.selectBySql(sqlThongKe) == null) {
            return null;
        }
        return this.selectBySql(sqlThongKe);
    }

    public void DiemDanh(BusDiemDanh entity) {
        try {
            this.selectBySql(sqlDiemDanh, entity.getManv());
        } catch (Exception e) {
        }
    }

    public void DiMuon(BusDiemDanh entity) {
        try {
            this.selectBySql(sqlDiMuon, entity.getManv());
        } catch (Exception e) {
        }
    }

    public void BoVe(Integer entity) {
        try {
            //BusDiemDanh model = new BusDiemDanh();
            this.selectBySql(sqlBoVe, entity);
        } catch (Exception e) {
        }
    }

    public List<BusDiemDanh> selectBySql(String sql, Object... args) {
        List<BusDiemDanh> listHang = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusDiemDanh busDiemDanh = new BusDiemDanh(
                        rs.getString("MaNV"),
                        rs.getInt("MaDiemDanh"),
                        rs.getString("NgayDiemDanh"),
                        rs.getBoolean("DiemDanh"),
                        rs.getBoolean("DiMuon"),
                        rs.getBoolean("TrangThai")
                );
                listHang.add(busDiemDanh);
            }
            rs.getStatement().close();
            return listHang;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
