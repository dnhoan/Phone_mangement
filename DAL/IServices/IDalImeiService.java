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
    String SELECT_BY_IDSP = "select * from IMEI where MACTSP = ? and TRANGTHAI = 1 and TenImei like ?";
    String DELETE = "update IMEI set TRANGTHAI = 0 where MaIMEI = ?";
}
