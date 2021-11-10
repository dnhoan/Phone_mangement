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
public interface IManHinhService {
    String INSERT = "INSERT INTO ManHinhSP(LoaiManHinh, KichThuoc, DoPhanGiai, TrangThai) VALUES (?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM ManHinhSP";
    String SELECT_BY_ID = "SELECT * FROM ManHinhSP WHERE MaManHinh = ?";
    String UPDATE = "UPDATE ManHinhSP SET LoaiManHinh = ?, KichThuoc = ?, DoPhanGiai = ?, TrangThai = ? WHERE MaManHinh = ?";
    String SELECT_BY_STATUS = "SELECT * FROM ManHinhSP WHERE TrangThai = ?";
}
