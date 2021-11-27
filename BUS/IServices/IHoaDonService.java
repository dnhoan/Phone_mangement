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

    String INSERT = "INSERT INTO HoaDon(MaNV, MaKH, ghichu, TongTien, TienKhachTra, NgayThanhToan, DiaChiNhanHang, PhiVanChuyen, NgayShip) values (?,?,?,?,?,?,?, ?, ?)";
    String UPDATE = "update HoaDon set MaNV = ?, MaKH = ?, MaKM = ?, ghichu = ? where MaHD = ?";
    String UPDATE_STATUS = "update HoaDon set TrangThai = ? where MaHD = ?";
    String SELECT_LASTID = "SELECT Max(MaHD) as LastID FROM HoaDon";
    String SELECT_ALL1 = "SELECT HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"            KhachHang.MaKH, KhachHang.HoTen as TenKhach, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen as TenNhanVien, PhiVanChuyen,  \n" +
"            COUNT(ChiTietHoaDon.MAHD) AS SoLuong \n" +
"            FROM HoaDon JOIN ChiTietHoaDon   \n" +
"                ON ChiTietHoaDon.MaHD = HoaDon.MaHD join KhachHang  \n" +
"                on KhachHang.MaKH = HoaDon.MaKH join NhanVien   \n" +
"                on NhanVien.MaNV = HoaDon.MaNV  \n" +
"            where HoaDon.TrangThai = ?  and ( HoaDon.DiaChiNhanHang like ? or KhachHang.HoTen like ? or KhachHang.SDT like ? or NhanVien.HoTen like ?) \n" +
"            Group by HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"                KhachHang.MaKH, KhachHang.HoTen , KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen, PhiVanChuyen   \n" +
"            order by HoaDon.NgayTao desc";
    String SELECT_NOT_THANH_TOAN = "SELECT HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"            KhachHang.MaKH, KhachHang.HoTen as TenKhach, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen as TenNhanVien, PhiVanChuyen,  \n" +
"            COUNT(ChiTietHoaDon.MAHD) AS SoLuong \n" +
"            FROM HoaDon JOIN ChiTietHoaDon   \n" +
"                ON ChiTietHoaDon.MaHD = HoaDon.MaHD join KhachHang  \n" +
"                on KhachHang.MaKH = HoaDon.MaKH join NhanVien   \n" +
"                on NhanVien.MaNV = HoaDon.MaNV  \n" +
"            where HoaDon.TrangThai = ? AND HoaDon.TongTien != HoaDon.TienKhachTra  and ( HoaDon.DiaChiNhanHang like ? or KhachHang.HoTen like ? or KhachHang.SDT like ? or NhanVien.HoTen like ?) \n" +
"            Group by HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"                KhachHang.MaKH, KhachHang.HoTen , KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen, PhiVanChuyen   \n" +
"            order by HoaDon.NgayTao desc";
    String SELECT_THANH_TOAN = "SELECT HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"            KhachHang.MaKH, KhachHang.HoTen as TenKhach, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen as TenNhanVien, PhiVanChuyen,  \n" +
"            COUNT(ChiTietHoaDon.MAHD) AS SoLuong \n" +
"            FROM HoaDon JOIN ChiTietHoaDon   \n" +
"                ON ChiTietHoaDon.MaHD = HoaDon.MaHD join KhachHang  \n" +
"                on KhachHang.MaKH = HoaDon.MaKH join NhanVien   \n" +
"                on NhanVien.MaNV = HoaDon.MaNV  \n" +
"            where HoaDon.TrangThai = ? AND HoaDon.TongTien = HoaDon.TienKhachTra and ( HoaDon.DiaChiNhanHang like ? or KhachHang.HoTen like ? or KhachHang.SDT like ? or NhanVien.HoTen like ?) \n" +
"            Group by HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu,  \n" +
"                KhachHang.MaKH, KhachHang.HoTen , KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen, PhiVanChuyen   \n" +
"            order by HoaDon.NgayTao desc";
    String SELECT_BY_MAHD = "SELECT HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu, \n"
            + "             KhachHang.MaKH, KhachHang.HoTen as TenKhach, KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen as TenNhanVien, PhiVanChuyen, \n"
            + "             COUNT(ChiTietHoaDon.MAHD) AS SoLuong\n"
            + "             FROM HoaDon JOIN ChiTietHoaDon  \n"
            + "                 ON ChiTietHoaDon.MaHD = HoaDon.MaHD join KhachHang \n"
            + "                 on KhachHang.MaKH = HoaDon.MaKH join NhanVien  \n"
            + "                 on NhanVien.MaNV = HoaDon.MaNV \n"
            + "             where HoaDon.TrangThai = ? and HoaDon.MaHD = ? \n"
            + "             Group by HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.NgayTao, HoaDon.TongTien, HoaDon.TienKhachTra, HoaDon.DiaChiNhanHang, HoaDon.GhiChu, \n"
            + "                 KhachHang.MaKH, KhachHang.HoTen , KhachHang.SDT, NhanVien.MaNV, NhanVien.HoTen,PhiVanChuyen  \n"
            + "             order by HoaDon.NgayThanhToan desc";
    String SELECT_HOA_DON_IN_DATE_AND_TREO= "select * from HoaDon where ((DAY(HoaDon.NgayTao) = DAY(GETDATE()) and Month(HoaDon.NgayTao) = Month(GETDATE()) and Year(HoaDon.NgayTao) = Year(GETDATE())) or TongTien != TienKhachTra) and TrangThai = 1 ";
//    String SELECT_HOA_DON_TREO= "select MaHD from HoaDon where NgayThanhToan = null OR TongTien != TienKhachTra and TrangThai = 1";
}
