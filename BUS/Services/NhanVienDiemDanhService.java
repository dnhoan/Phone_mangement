/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import DAL.Services.JDBCHelper;
import BUS.Models.NhanVienDiemDanhModel;

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
public class NhanVienDiemDanhService {

    String sqlSelect1 = "select NhanVien.MaNV, NhanVien.HoTen from NhanVien where trangthai=1";
    String sqlSelect_BY_ID = "select NhanVien.MaNV, NhanVien.HoTen,NhanVien.Hinh from NhanVien where trangthai=1 and MaNV = ?";

    public List<NhanVienDiemDanhModel> selectAll() {
        if (this.selectBySql(sqlSelect1) == null) {
            return null;
        }
        return this.selectBySql(sqlSelect1);
    }
    public List<NhanVienDiemDanhModel> selectBY_ID(){
         if (this.selectBySql(sqlSelect_BY_ID) == null) {
            return null;
        }
        return this.selectBySql(sqlSelect_BY_ID);
    }

    public List<NhanVienDiemDanhModel> selectBySql(String sql, Object... args) {
        List<NhanVienDiemDanhModel> listHang = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVienDiemDanhModel busDiemDanh = new NhanVienDiemDanhModel(
                        rs.getString("MaNV"),
                        rs.getString("HoTen")
                 
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
