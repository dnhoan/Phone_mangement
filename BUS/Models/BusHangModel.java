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
public class BusHangModel {

    private int maHang;
    private String tenHang;
    private boolean trangThai;

    public BusHangModel(int maHang, String tenHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
    }

    public BusHangModel(int maHang, String tenHang, boolean trangThai) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.trangThai = trangThai;
    }

    public BusHangModel() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenHang;
    }

}
