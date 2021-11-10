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
public interface IRomService {
    String INSERT = "INSERT INTO RomSP(TenRom, DungLuong) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM RomSP";
    String SELECT_BY_ID = "SELECT * FROM RomSP WHERE MaROM = ?";
    String UPDATE = "UPDATE RomSP SET TenRom = ?, DungLuong = ?, TrangThai = ? WHERE MaROM = ?";
    String DELETE = "UPDATE RomSP SET TrangThai = 0 WHERE MaROM = ?";
    String BACK_UP = "UPDATE RomSP SET TrangThai = 1 WHERE MaROM = ?";
    String DELETE_FOREVER = "DELETE * FROM WHERE MAROM = ?";
    String SELECT_BY_STATUS = "SELECT * FROM RomSP WHERE TrangThai = ?";
}
