/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BusHoaDon {
    private int mahd;
    private Date ngayBan;
    private NhanVienModel nhanVienModel;
    private KhachHangModel khachHangModel;
    private boolean trangThai;

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public NhanVienModel getNhanVienModel() {
        return nhanVienModel;
    }

    public void setNhanVienModel(NhanVienModel nhanVienModel) {
        this.nhanVienModel = nhanVienModel;
    }



    public KhachHangModel getKhachHangModel() {
        return khachHangModel;
    }

    public void setKhachHangModel(KhachHangModel khachHangModel) {
        this.khachHangModel = khachHangModel;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
