/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

/**
 *
 * @author ADMIN
 */
public interface IDalMauSacService {
    String INSERT = "INSERT INTO MauSac(TenMau, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM MauSac WHERE TrangThai = ?";
    String SELECT_BY_ID = "SELECT * FROM MauSac WHERE MaMau = ?";
    String UPDATE = "UPDATE MauSac SET TenMau = ?, TrangThai = ? WHERE MaMau = ?";
}
