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
public interface IDalPhanLoaiSpService {
    String INSERT = "INSERT INTO PhanLoai(Loai, TrangThai) VALUES (?,?)";
    String SELECT_ALL = "SELECT * FROM PhanLoai WHERE TrangThai = ?";
    String SELECT_BY_ID = "SELECT * FROM PhanLoai WHERE MaPhanLoai = ?";
    String UPDATE = "UPDATE PhanLoai SET Loai = ?, TrangThai = ? WHERE MaPhanLoai = ?";
}
