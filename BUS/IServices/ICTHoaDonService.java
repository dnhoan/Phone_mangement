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
    String INSERT = "INSERT INTO ChiTietHoaDon(MAHD, MaCTSP, SoLuong, GiaBan) values (?,?,?,?)";
    String UPDATE = "update ChiTietHoaDon set MaHD = ?, MaCTSP = ?, SoLuong = ?, GiaBan= ? where MaCTHD = ?";
    String DELETE = "update ChiTietHoaDon set TrangThai = 0 where MaCTHD = ?";
}
