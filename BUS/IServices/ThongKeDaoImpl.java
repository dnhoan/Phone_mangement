/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.doanhthuModel;
import BUS.Models.soluongbanmodel;
import java.util.List;
import DAL.Services.JDBCHelper;
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

        Connection cons = JDBCHelper.ketnoi();
        String sql = "select NgayThanhToan, count(ChiTietHoaDon.MaImei) as soluong\n"
                + "from HoaDon, ChiTietHoaDon\n"
                + "where HoaDon.MaHD = ChiTietHoaDon.MaHD and MONTH(HoaDon.NgayThanhToan) = month( GETDATE())\n"
                + "GROUP BY MONTH(HoaDon.NgayThanhToan), NgayThanhToan";
        List<soluongbanmodel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluongbanmodel sl = new soluongbanmodel();
                sl.setThang(rs.getDate(1));
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
        String sql = "select NgayThanhToan , sum(HoaDon.TongTien) as tongtien\n"
                + "from HoaDon where MONTH(HoaDon.NgayThanhToan) = MONTH(GETDATE())\n"
                + "GROUP BY MONTH(HoaDon.NgayThanhToan), NgayThanhToan";
        List<doanhthuModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doanhthuModel sl = new doanhthuModel();
                sl.setThang(rs.getDate(1));
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
