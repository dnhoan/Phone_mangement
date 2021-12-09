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
public class BusSanPham {
    private int masp;
    private String tensp;
    private BusDongSpModel busDongSpModel;
    private boolean trangThai;

    public BusSanPham() {
    }

    public BusSanPham(int masp, String tensp, BusDongSpModel busDongSpModel, boolean trangThai) {
        this.masp = masp;
        this.tensp = tensp;
        this.busDongSpModel = busDongSpModel;
        this.trangThai = trangThai;
    }

    public BusSanPham(int masp, String tensp, BusDongSpModel busDongSpModel) {
        this.masp = masp;
        this.tensp = tensp;
        this.busDongSpModel = busDongSpModel;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public BusDongSpModel getBusDongSpModel() {
        return busDongSpModel;
    }

    public void setBusDongSpModel(BusDongSpModel busDongSpModel) {
        this.busDongSpModel = busDongSpModel;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tensp ;
    }
    
}
