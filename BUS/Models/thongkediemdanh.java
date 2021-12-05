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
public class thongkediemdanh {
    String MaNV;
    int DiemDanh;
    String NgayDiemDanh;

    public thongkediemdanh(String MaNV, int DiemDanh, String NgayDiemDanh) {
        this.MaNV = MaNV;
        this.DiemDanh = DiemDanh;
        this.NgayDiemDanh = NgayDiemDanh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public int getDiemDanh() {
        return DiemDanh;
    }

    public String getNgayDiemDanh() {
        return NgayDiemDanh;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setDiemDanh(int DiemDanh) {
        this.DiemDanh = DiemDanh;
    }

    public void setNgayDiemDanh(String NgayDiemDanh) {
        this.NgayDiemDanh = NgayDiemDanh;
    }

  
    public thongkediemdanh() {
    }
}
