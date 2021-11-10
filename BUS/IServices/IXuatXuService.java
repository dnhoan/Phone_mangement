/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

public interface IXuatXuService {
    String INSERT = "INSERT INTO XuatXu(NoiXuatXu, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM XuatXu";
    String SELECT_BY_ID = "SELECT * FROM XuatXu WHERE MaXuatXu = ?";
    String UPDATE = "UPDATE XuatXu SET NoiXuatXu =?, TrangThai = ? WHERE MaXuatXu = ?";
    String SELECT_BY_STATUS = "SELECT * FROM XuatXu WHERE TrangThai = ?";
}
