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
public interface ICpuService {
    String INSERT = "INSERT INTO CPU(TenCPU, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM CPU";
    String SELECT_BY_ID = "SELECT * FROM CPU WHERE MaCPU = ?";
    String UPDATE = "UPDATE CPU SET TenCPU =?, TrangThai = ? WHERE MaCPU = ?";
    String SELECT_BY_STATUS = "SELECT * FROM CPU WHERE TrangThai = ?";
}
