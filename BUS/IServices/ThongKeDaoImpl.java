/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.doanhthuModel;
import BUS.Models.soluongbanmodel;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ThongKeDaoImpl implements ThongKeDao {

    @Override
    public List<soluongbanmodel> GetSLBan() {
        
        Connection cons = help.ketnoi();
        String sql = "select MONTH(HoaDon.NgayThanhToan) as thang, count(ChiTietHoaDon.MaImei) as soluong \n"
                + "                from HoaDon, ChiTietHoaDon where HoaDon.MaHD = ChiTietHoaDon.MaHD\n"
                + "                GROUP BY MONTH(HoaDon.NgayThanhToan)";
        List<soluongbanmodel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluongbanmodel sl = new soluongbanmodel();
                sl.setThang(rs.getString(1));
                sl.setSoluongban(rs.getInt(2));
                list.add(sl);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<doanhthuModel> GetDoanhThu() {
        Connection cons = help.ketnoi();
        String sql = "select MONTH(HoaDon.NgayThanhToan) as thang, sum(HoaDon.TongTien) as tongtien \n"
                + "                from HoaDon\n"
                + "                GROUP BY MONTH(HoaDon.NgayThanhToan)";
        List<doanhthuModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doanhthuModel sl = new doanhthuModel();
                sl.setThang(rs.getString(1));
                sl.setDoanhthu(rs.getInt(2));
                list.add(sl);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
