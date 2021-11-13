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
    private NhanVienModel busNhanVienModel;
    private BusKhachHang busKhachHang;
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

    public NhanVienModel getBusNhanVienModel() {
        return busNhanVienModel;
    }

    public void setBusNhanVienModel(NhanVienModel busNhanVienModel) {
        this.busNhanVienModel = busNhanVienModel;
    }

    public BusKhachHang getBusKhachHang() {
        return busKhachHang;
    }

    public void setBusKhachHang(BusKhachHang busKhachHang) {
        this.busKhachHang = busKhachHang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
