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
public interface ICameraService {
    String INSERT = "INSERT INTO CameraSP(LoaiCamera, DoPhanGiai, TrangThai) VALUES (?,?,?)";
    String SELECT_ALL = "SELECT * FROM CameraSP";
    String SELECT_BY_ID = "SELECT * FROM CameraSP WHERE MaCamera = ?";
    String UPDATE = "UPDATE CameraSP SET LoaiCamera = ?, DoPhanGiai = ?, TrangThai = ? WHERE MaCamera = ?";
    String SELECT_BY_USING = "SELECT * FROM CameraSP WHERE TrangThai = 1";
    String SELECT_BY_RECYCLE = "SELECT * FROM CameraSP WHERE TrangThai = 0";
}
