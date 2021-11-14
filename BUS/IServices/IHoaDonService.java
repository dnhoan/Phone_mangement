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

    String INSERT = "INSERT INTO HoaDon(MaNV, MaKH, MaKM, ghichu) values (?,?,?,?)";
    String UPDATE = "update HoaDon set MaNV = ?, MaKH = ?, MaKM = ?, ghichu = ? where MaHD = ?";
    String DELETE = "update HoaDon set TrangThai = 0 where MaHD = ?";
    String SELECT_LASTID = "SELECT Max(MaHD) as LastID FROM HoaDon";
    String SELECT_ALL1 = "select MaCTHD, HoaDon.MaHD, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBan, \n"
            + "HoaDon.ngaytao,\n"
            + "ChiTietHoaDon.SoLuong, SUM(ChiTietHoaDon.GiaBan * ChiTietHoaDon.SoLuong) as TongTien   \n"
            + "from HoaDon join\n"
            + "ChiTietHoaDon on HoaDon.MaHD = ChiTietHoaDon.MaHD join \n"
            + "KhachHang on KhachHang.MaKH = HoaDon.MaKH join\n"
            + "CTSANPHAM on CTSANPHAM.MACTSP = ChiTietHoaDon.MaCTSP join\n"
            + "SanPham on SanPham.MaSP = CTSANPHAM.MaSP where ChiTietHoaDon.TrangThai = 1 \n"
            + "group by MaCTHD, HoaDon.MaHD, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBan, \n"
            + "HoaDon.ngaytao,\n"
            + "ChiTietHoaDon.SoLuong"; //    String SELECT_BY_ID;
            //    String 

}
