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
    String INSERT_SALE_HOADON = "INSERT [dbo].[KhuyenMai] ([tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM],[DKKM]) VALUES(?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM khuyenmai";
    String UPDATE = "UPDATE [dbo].[KhuyenMai] SET TenKM=?, LoaiGG=?, MucGG=? where MaKM=?";
    String UPDATE_SALE_HOADON = "UPDATE [dbo].[KhuyenMai] SET TenKM=?, LoaiGG=?, MucGG=?,DKKM=? where MaKM=?";
    String DELETE = "UPDATE KHUYENMAI SET TrangThai = 1 WHERE MAVOCHER = ?";
    String INSERTNEW = "INSERT INTO [dbo].[sanphamdcsale] ([MaSp],[MaKM]) VALUES(?,(SELECT TOP 1 makm FROM [dbo].[KhuyenMai] ORDER BY makm DESC))";
    String SELECT_MAGG_BY_MASP = "select * from SanPhamDCSale inner join KhuyenMai on KhuyenMai.MaKM = SanPhamDCSale.MaKM where GETDATE() >= NgayBD and GETDATE() <= NgayKT AND masp = ?"; 
    String UPDATE_NGAYBD_NGAYKT = "UPDATE [dbo].[KhuyenMai] SET NgayBD=?, NgayKT=? where MaKM=?"  ;
    String SELECT_GIAMGAI_HOADON = "select * from KhuyenMai where GETDATE() >= NgayBD and GETDATE() <= NgayKT AND LoaiKM = 2";
}
