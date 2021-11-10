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
public interface IRamService {
    String INSERT = "INSERT INTO RamSP(LoaiRam, DungLuongRam, TrangThai) VALUES (?,?,?)";
    String SELECT_ALL = "SELECT * FROM RamSP";
    String SELECT_BY_ID = "SELECT * FROM RamSP WHERE MaRam = ?";
    String UPDATE = "UPDATE RamSP SET LoaiRam = ?, DungLuongRam = ?, TrangThai = ? WHERE MaRam = ?";
    String SELECT_BY_STATUS = "SELECT * FROM RamSP WHERE TrangThai = ?";
}
