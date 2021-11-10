/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

/**
 *
 * @author ADMIN
 */
public interface IDongService {

    String INSERT = "INSERT INTO DongSP(TenDong, MaHang, TrangThai) VALUES (?,?,?)";
    String SELECT_ALL = "SELECT * FROM DongSP";
    String SELECT_BY_ID = "SELECT * FROM DongSP WHERE MaDong = ?";
    String UPDATE = "UPDATE DongSP SET TenDong = ?, MaHang = ?, TrangThai = ? WHERE MaDong = ?";
    String SELECT_BY_MAHANG = "select MaDong, HangSanPham.MaHang, TenDong, TenHang \n"
            + "from HangSanPham join DongSP on DongSP.MaDong = HangSanPham.MaHang \n"
            + "where DongSP.TrangThai = 1 and DongSP.MaHang = ?";
    String SELECT_BY_STATUS = "SELECT * FROM DongSP WHERE TrangThai = 1";
}
