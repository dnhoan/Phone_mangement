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
public interface ILoaiSanPhamService {

    String INSERT = "INSERT INTO SanPham(TenSP, MaDong) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM SANPHAM WHERE TrangThai = 1";
    String SELECT_BY_ID = "SELECT MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, TenHang FROM SanPham JOIN \n"
            + "DongSP ON DongSP.MaDong = SanPham.MaDong JOIN\n"
            + "HangSanPham ON DongSP.MaHang = HangSanPham.MaHang WHERE SANPHAM.TrangThai = 1 AND masp = ?";
    String UPDATE = "UPDATE SanPham SET TenSP =?, MaDong = ? WHERE MaSP = ?";
    String DELETE = "UPDATE SanPham SET TrangThai = 0 WHERE MaSP = ?";
    String SELECT_BY_STATUS = "SELECT * FROM SANPHAM WHERE TrangThai = 1";
    String SELECT_BY_KEYWORD = "SELECT MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, TenHang FROM SanPham JOIN \n"
            + "DongSP ON DongSP.MaDong = SanPham.MaDong JOIN\n"
            + "HangSanPham ON DongSP.MaHang = HangSanPham.MaHang WHERE SANPHAM.TrangThai = 1 AND TenSP LIKE ?";
    String SELECT_RECYCLE = "SELECT MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, TenHang FROM SanPham JOIN \n"
            + "DongSP ON DongSP.MaDong = SanPham.MaDong JOIN\n"
            + "HangSanPham ON DongSP.MaHang = HangSanPham.MaHang WHERE SANPHAM.TrangThai = 0";
    String BACK_UP = "UPDATE SanPham SET TrangThai = 1 WHERE MaSP = ?";
}
