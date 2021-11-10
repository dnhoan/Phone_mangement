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
public interface IHeDieuHanhService {
    String INSERT = "INSERT INTO HeDieuHanh(TenHeDieuHanh, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM HeDieuHanh";
    String SELECT_BY_ID = "SELECT * FROM HeDieuHanh WHERE MaHeDieuHanh = ?";
    String UPDATE = "UPDATE HeDieuHanh SET TenHeDieuHanh = ?, TrangThai = ? WHERE MaHeDieuHanh = ?";
    String SELECT_BY_STATUS = "SELECT * FROM HeDieuHanh WHERE TrangThai = ?";
}
