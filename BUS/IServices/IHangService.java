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
public interface IHangService {
    String INSERT = "INSERT INTO HangSanPham(TenHang, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM HangSanPham";
    String SELECT_BY_ID = "SELECT * FROM HangSanPham WHERE MaHang = ?";
    String UPDATE = "UPDATE HangSanPham SET TenHang = ?, TrangThai = ? WHERE MaHang = ?";
    String SELECT_BY_STATUS = "SELECT * FROM HangSanPham WHERE TrangThai = ?";
}
