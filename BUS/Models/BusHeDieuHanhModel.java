/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import DAL.Models.*;

/**
 *
 * @author ADMIN
 */
public class BusHeDieuHanhModel {
    private String MaHeDieuHanh;
    private String tenHeDieuHanh;
    private boolean trangThai = true;

    public BusHeDieuHanhModel() {
    }

    
    public BusHeDieuHanhModel(String MaHeDieuHanh, String tenHeDieuHanh, boolean trangThai) {
        this.MaHeDieuHanh = MaHeDieuHanh;
        this.tenHeDieuHanh = tenHeDieuHanh;
        this.trangThai = trangThai;
    }

    
    public BusHeDieuHanhModel(String MaHeDieuHanh, String tenHeDieuHanh) {
        this.MaHeDieuHanh = MaHeDieuHanh;
        this.tenHeDieuHanh = tenHeDieuHanh;
    }

    public String getMaHeDieuHanh() {
        return MaHeDieuHanh;
    }

    public void setMaHeDieuHanh(String MaHeDieuHanh) {
        this.MaHeDieuHanh = MaHeDieuHanh;
    }

    public String getTenHeDieuHanh() {
        return tenHeDieuHanh;
    }

    public void setTenHeDieuHanh(String tenHeDieuHanh) {
        this.tenHeDieuHanh = tenHeDieuHanh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenHeDieuHanh;
    }
    
}
