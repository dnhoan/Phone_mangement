/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

/**
 *
 * @author ADMIN
 */
public interface IDalImeiService {

    String INSERT = "INSERT INTO IMEI(MACTSP, MaSPSale, TenImei) VALUES(?,?,?)";
    String UPDATE = "update IMEI set TenImei = ? where MaIMEI = ?";
    String UPDATE_GHICHU =  "update imei set ghichu = ? where maimei = ?";
    String UPDATE_IMEI_IN_CTHD = "update ChiTietHoaDon set MaImei = ? where MaImei = ?";
    String UPDATE_STATUS_SELL = "update IMEI set TrangThaiBan = ? where MaIMEI = ?";
    String UPDATE_STATUS_SELL_BY_MAHD = "update IMEI set IMEI.TrangThaiBan = ? \n"
            + "from HoaDon join \n"
            + "ChiTietHoaDon on HoaDon.MaHD = ChiTietHoaDon.MaHD \n"
            + "join IMEI on IMEI.MaIMEI = ChiTietHoaDon.MaImei \n"
            + "where HoaDon.MaHD = ?";
    String SELECT_BY_IDSP = "select * from IMEI where MACTSP = ? and TRANGTHAI = 1 and TenImei like ?";
    String SELECT_IMEIS_NOT_SELL = "select * from IMEI where MACTSP = ? and TRANGTHAI = 1 and TrangThaiBan = 1";
    String DELETE = "update IMEI set TRANGTHAI = 0 where MaIMEI = ?";

    String SELECT_IMEI_BY_MACTSP_AND_MAHD = "select Imei.maImei, CTSANPHAM.MACTSP, tenImei, maspsale, TrangThaiBan, Imei.ghichu  from CTSANPHAM join Imei \n"
            + "on Imei.MaCTSP = CTSANPHAM.MACTSP join ChiTietHoaDon \n"
            + "on ChiTietHoaDon.MaImei = Imei.MaImei join HoaDon\n"
            + "on HoaDon.MaHD = ChiTietHoaDon.MaHD\n"
            + "where CTSANPHAM.MaCTSP = ? and HoaDon.MaHD = ? and TrangThaiBan = 0";
}
