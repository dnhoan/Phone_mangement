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
public interface IVoucher {
    String INSERT = "INSERT INTO [DBO].[KhuyenMai] ([loaima],[tenKM],[mavocher],[DieuKienKM],[LoaiGiamGia],[NgayBD],[NgayKT],[sotienduoctru],[giatridonhangtoithieu],[trangthai]) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM khuyenmai";
    String UPDATE = "UPDATE KHUYENMAI SET DIEUKIENKM =?, LOAIGIAMGIA=?,SOTIENDUOCTRU=?,GIATRIDONHANGTOITHIEU=? WHERE MAVOCHER=? ";
    String DELETE = "UPDATE KHUYENMAI SET TrangThai = 1 WHERE MAVOCHER = ?";
      
}
