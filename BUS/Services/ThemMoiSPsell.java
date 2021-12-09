/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.spsalemodel;
import DAL.Models.ThemSPsaleMoldel;
import DAL.Services.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author 84349
 */
public class ThemMoiSPsell {
    
    public List<ThemSPsaleMoldel> selectAll() {
        String sql;
        sql = "select * from SanPham";
        return selectBySql(sql);
    }
    
    public List<ThemSPsaleMoldel> selectBySql(String sql, Object... args) {
        List<ThemSPsaleMoldel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThemSPsaleMoldel model = readFromResultSet(rs);
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
    public List<ThemSPsaleMoldel> selectByHang(String id) {
        String sql = "select SanPham.TenSP, SanPham.masp, DongSP.TenDong, HangSanPham.TenHang from SanPham,DongSP,HangSanPham \n" +
"where SanPham.MaDong = DongSP.MaDong and HangSanPham.MaHang=DongSP.MaHang and tenhang like ?";
//        List<ThemSPsaleMoldel> list = selectBySql(sql, id);
        return selectBySql(sql, "%"+id+"%");
    }
    public List<ThemSPsaleMoldel> selectByKeyword(String keyword) {
        String sql;
        sql="select SanPham.TenSP, SanPham.masp, DongSP.TenDong, HangSanPham.TenHang from SanPham,DongSP,HangSanPham \n" +
"where SanPham.MaDong = DongSP.MaDong and HangSanPham.MaHang=DongSP.MaHang and tensp like ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
    public List<ThemSPsaleMoldel> selectByID(String id) {
        String sql = "select SanPham.TenSP, SanPham.masp, DongSP.TenDong, HangSanPham.TenHang from SanPham,DongSP,HangSanPham \n" +
"where SanPham.MaDong = DongSP.MaDong and HangSanPham.MaHang=DongSP.MaHang and masp=?";
        return selectBySql(sql, id);
    }
    private ThemSPsaleMoldel readFromResultSet(ResultSet rs) throws SQLException {
        ThemSPsaleMoldel model = new ThemSPsaleMoldel();
        model.setTenSP(rs.getString("tensp"));
        model.setMasp(rs.getInt("masp"));
        return model;

    }
    
    
}
