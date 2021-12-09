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
public class BusDongSpModel {
    private int maDong;
    private String tenDong;
    private BusHangModel busHangModel;
    private boolean trangThai;

    public BusDongSpModel() {
    }

    public BusDongSpModel(int maDong, String tenDong, BusHangModel busHangModel, boolean trangThai) {
        this.maDong = maDong;
        this.tenDong = tenDong;
        this.busHangModel = busHangModel;
        this.trangThai = trangThai;
    }

    public BusDongSpModel(int maDong, String tenDong, BusHangModel busHangModel) {
        this.maDong = maDong;
        this.tenDong = tenDong;
        this.busHangModel = busHangModel;
    }

    public BusHangModel getBusHangModel() {
        return busHangModel;
    }

    public void setBusHangModel(BusHangModel busHangModel) {
        this.busHangModel = busHangModel;
    }

    

    public int getMaDong() {
        return maDong;
    }

    public void setMaDong(int maDong) {
        this.maDong = maDong;
    }

    public String getTenDong() {
        return tenDong;
    }

    public void setTenDong(String tenDong) {
        this.tenDong = tenDong;
    }


  

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenDong ;
    }
    
}
