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
public interface ICTHoaDonService {

    String INSERT = "INSERT INTO ChiTietHoaDon(MAHD, MaImei, GiaBanSauSale) values (?,?,?)";
    String UPDATE = "update ChiTietHoaDon set MaHD = ?, MaImei = ?, GiaBanSauSale= ? where MaCTHD = ?";
    String DELETE = "update ChiTietHoaDon set TrangThai = 0 where MaCTHD = ?";
    String SELECT_ALL1 = "select MaCTHD, HoaDon.MaHD, SanPham.MaSP, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "	KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBanSauSale, \n"
            + "	HoaDon.ngaytao,\n"
            + "	ChiTietHoaDon.SoLuong, SUM(ChiTietHoaDon.GiaBanSauSale * ChiTietHoaDon.SoLuong) as TongTien   \n"
            + "	from HoaDon join\n"
            + "	ChiTietHoaDon on HoaDon.MaHD = ChiTietHoaDon.MaHD join \n"
            + "	KhachHang on KhachHang.MaKH = HoaDon.MaKH join\n"
            + "	CTSANPHAM on CTSANPHAM.MACTSP = ChiTietHoaDon.MaCTSP join\n"
            + "	SanPham on SanPham.MaSP = CTSANPHAM.MaSP where ChiTietHoaDon.TrangThai = 1 \n"
            + "	group by MaCTHD, HoaDon.MaHD, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "	KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBanSauSale, \n"
            + "	HoaDon.ngaytao, SanPham.MaSP,\n"
            + "	ChiTietHoaDon.SoLuong";
    String SELECT_ALL0 = "select MaCTHD, HoaDon.MaHD, SanPham.MaSP, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "	KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBanSauSale, \n"
            + "	HoaDon.ngaytao,\n"
            + "	ChiTietHoaDon.SoLuong, SUM(ChiTietHoaDon.GiaBanSauSale * ChiTietHoaDon.SoLuong) as TongTien   \n"
            + "	from HoaDon join\n"
            + "	ChiTietHoaDon on HoaDon.MaHD = ChiTietHoaDon.MaHD join \n"
            + "	KhachHang on KhachHang.MaKH = HoaDon.MaKH join\n"
            + "	CTSANPHAM on CTSANPHAM.MACTSP = ChiTietHoaDon.MaCTSP join\n"
            + "	SanPham on SanPham.MaSP = CTSANPHAM.MaSP where ChiTietHoaDon.TrangThai = 0 \n"
            + "	group by MaCTHD, HoaDon.MaHD, HoaDon.MaKH, HoaDon.MaNV, KhachHang.HoTen, \n"
            + "	KhachHang.SDT, SanPham.TenSP, CTSANPHAM.MACTSP, ChiTietHoaDon.GiaBanSauSale, \n"
            + "	HoaDon.ngaytao, SanPham.MaSP,\n"
            + "	ChiTietHoaDon.SoLuong";
}
