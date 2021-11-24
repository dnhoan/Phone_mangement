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
    String INSERT_SPSALE="INSERT [dbo].[sanphamdcsale] ([MaSP],[MaKM]) VALUES (?,?)";
    String INSERT = "INSERT [dbo].[KhuyenMai] ([tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]) VALUES(?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM khuyenmai";
    String UPDATE = "UPDATE [dbo].[KhuyenMai] SET TenKM=?, LoaiGG=?, MucGG=? where MaKM=?";
    String DELETE = "UPDATE KHUYENMAI SET TrangThai = 1 WHERE MAVOCHER = ?";
    String INSERTNEW=
            "INSERT INTO [dbo].[sanphamdcsale] ([MaSp],[MaKM]) VALUES(?,(SELECT TOP 1 makm FROM [dbo].[KhuyenMai] ORDER BY makm DESC))";
    String UPDATE_NGAYBD_NGAYKT="UPDATE [dbo].[KhuyenMai] SET NgayBD=?, NgayKT=? where MaKM=?"  ;
}
