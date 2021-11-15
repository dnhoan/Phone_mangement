/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

/**
 *
 * @author DUCNAM
 */
public interface IKhachHangServices {
    String INSERT = "INSERT [dbo].[KhachHang] ([HoTen], [SDT],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES ( ?,?,?,?,?,?,?,1)";
    String SELECT_ALL = "select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,KhachHang.NgayTao,KhachHang.GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" + "WHERE KhachHang.TrangThai = ?"+
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,KhachHang.NgayTao,KhachHang.GhiChu,KhachHang.TrangThai\n";
    String DELETE = "UPDATE KhachHang set TrangThai= 0 where MaKH=?";
    String DELETE2 = "UPDATE KhachHang set TrangThai= 1 where MaKH=?";
     String SELECT_BY_ID = "select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,KhachHang.NgayTao,KhachHang.GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" + "WHERE KhachHang.MaKH = ?"+
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,KhachHang.NgayTao,KhachHang.GhiChu,KhachHang.TrangThai\n;";
    String UPDATE ="UPDATE KhachHang set Hoten = ? ,GioiTinh = ? , SDT= ? , DiaChi = ?,NgaySinh = ?,NgayTao = ? ,GhiChu = ? where MaKH =?";
}
