/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

/**
 *
 * @author ADMIN
 */
public class BusCTHoaDon {
    private int macthd;
    private BusHoaDon busHoaDon;
    private BusCTSanPhamModel busCTSanPhamModel;
    private int soLuong;
    private float gia;
    private float thanhTien;
    private boolean trangThai;

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMacthd() {
        return macthd;
    }

    public void setMacthd(int macthd) {
        this.macthd = macthd;
    }

    public BusHoaDon getBusHoaDon() {
        return busHoaDon;
    }

    public void setBusHoaDon(BusHoaDon busHoaDon) {
        this.busHoaDon = busHoaDon;
    }

    public BusCTSanPhamModel getBusCTSanPhamModel() {
        return busCTSanPhamModel;
    }

    public void setBusCTSanPhamModel(BusCTSanPhamModel busCTSanPhamModel) {
        this.busCTSanPhamModel = busCTSanPhamModel;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
