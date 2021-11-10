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
public interface IPinService {
    String INSERT = "INSERT INTO Pin(LoaiPin, DungLuongPin, TrangThai) VALUES (?,?,?)";
    String SELECT_ALL = "SELECT * FROM Pin";
    String SELECT_BY_ID = "SELECT *FROM Pin WHERE MaPin = ?;";
    String UPDATE = "UPDATE Pin SET LoaiPin = ?, DungLuongPin=?, TrangThai = ? WHERE MaPin = ?";
    String SELECT_BY_STATUS = "SELECT * FROM Pin WHERE TrangThai = ?";
}
