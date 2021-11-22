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
public interface IHoaDonService {

    String INSERT = "INSERT INTO HoaDon(MaNV, MaKH, ghichu, ngayBan) values (?,?,?,?)";
    String UPDATE = "update HoaDon set MaNV = ?, MaKH = ?, MaKM = ?, ghichu = ? where MaHD = ?";
    String DELETE = "update HoaDon set TrangThai = 0 where MaHD = ?";
    String SELECT_LASTID = "SELECT Max(MaHD) as LastID FROM HoaDon";
    String SELECT_ALL1 = "SELECT HoaDon.MaHD, HoaDon.NgayBan, HoaDon.NgayTao, KhachHang.MaKH, KhachHang.HoTen as TenKhach, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen as TenNhanVien, \n"
            + "COUNT(ChiTietHoaDon.MAHD) AS SoLuong, SUM(ChiTietHoaDon.GiaBan) as Tong FROM HoaDon JOIN ChiTietHoaDon \n"
            + "ON ChiTietHoaDon.MaHD = HoaDon.MaHD join KhachHang\n"
            + "on KhachHang.MaKH = HoaDon.MaKH join NhanVien \n"
            + "on NhanVien.MaNV = HoaDon.MaNV\n"
            + "where HoaDon.TrangThai = ?\n"
            + "Group by HoaDon.MaHD, HoaDon.NgayBan, HoaDon.NgayTao, KhachHang.MaKH, KhachHang.HoTen, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen\n"
            + "order by HoaDon.NgayBan";

}
