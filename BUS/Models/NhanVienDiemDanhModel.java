/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

/**
 *
 * @author LENOVO
 */
public class NhanVienDiemDanhModel {
    String MaNV,Hoten,anh;

    public NhanVienDiemDanhModel() {
    }

    public NhanVienDiemDanhModel(String MaNV, String Hoten, String anh) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.anh = anh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

   

    public String getMaNV() {
        return MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    
}
