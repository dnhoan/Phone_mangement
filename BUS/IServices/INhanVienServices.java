/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

/**
 *
 * @author 84349
 */
public interface INhanVienServices {
    String INSERT = "INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD],[TrangThai],[Email]) VALUES ( ?, ?,?,?, ?,?, ?, ?, ?,?,?,1,?)";
    String SELECT_ALL = "select * from NhanVien ";
    String SELECT_ON="select * from NhanVien where trangthai=1";
    String SELECT_OFF="select * from NhanVien where trangthai=0";
    String SELECT_BY_ID = "select * from NhanVien where MaNV = ?";
    String UPDATE = "UPDATE NhanVien SET MatKhau=?, HoTen=?,SDT=? , GioiTinh=?, NgaySinh=?,DiaChi=?, VaiTro=?,GhiChu=?,Hinh=?,Email=?,NgayBD=? where MaNV=?";
//                    UPDATE NhanVien SET MatKhau=?, HoTen=?,SDT=? , GioiTinh=?, NgaySinh=?,DiaChi=?, VaiTro=?,GhiChu=?,Hinh=?,Email=?,NgayBD=? where MaNV=?
    String DELETE = "UPDATE NhanVien set TrangThai= 0 where MaNV=?";
    String KHOIPHUC = "UPDATE NhanVien set TrangThai= 1 where MaNV=?";
    String SELECT_BY_KEYWORD_ON = "select * from NhanVien WHERE HoTen LIKE ? AND TrangThai=1";
    String SELECT_BY_KEYWORD_OFF = "select * from NhanVien WHERE HoTen LIKE ? AND TrangThai=0";
    String UPDATE_NGAYNGHI="UPDATE NhanVien set NgayKT= ? where MaNV=?";
}
