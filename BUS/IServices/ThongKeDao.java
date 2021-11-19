/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.soluongbanmodel;
import java.util.List;
import BUS.Models.doanhthuModel;
/**
 *
 * @author LENOVO
 */
public interface ThongKeDao {

//    String SoluongBan = "select ChiTietHoaDon.MaHD = HoaDon.MaHD\n"
//            + "select MONTH(HoaDon.NgayBan) as thang, COUNT(ChiTietHoaDon.MaCTSP) as soluong\n"
//            + "from HoaDon, ChiTietHoaDon where HoaDon.MaHD = ChiTietHoaDon.MaCTHD\n"
//            + "GROUP BY MONTH(HoaDon.NgayBan)";
    public List<soluongbanmodel> GetSLBan();
    public List<doanhthuModel> GetDoanhThu();
}
