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
    String UPDATE_STATUS_SELL = "update IMEI set TrangThaiBan = ? where MaIMEI = ?";
    String SELECT_BY_IDSP = "select * from IMEI where MACTSP = ? and TRANGTHAI = 1 and TenImei like ?";
    String SELECT_IMEIS_NOT_SELL = "select * from IMEI where MACTSP = ? and TRANGTHAI = 1 and TrangThaiBan = 1";
    String DELETE = "update IMEI set TRANGTHAI = 0 where MaIMEI = ?";
}
