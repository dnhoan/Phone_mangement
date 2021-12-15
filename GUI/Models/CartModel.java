/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Models;

import BUS.Models.BusSanPham;
import DAL.Models.DalImeiModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CartModel {
    private int mactsp;
    private String tensp;
    private String hinh;
    private float gia;
    private float tongTien;
    private boolean trangThai;
    private float tongTienHang;
    private int soLuong;
    private BusSanPham busSanPham;
    private boolean giamTheoTien;
    private float soLuongGiam;
    private List<DalImeiModel> listImeis;

    public float getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(float tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public boolean isGiamTheoTien() {
        return giamTheoTien;
    }

    public void setGiamTheoTien(boolean giamTheoTien) {
        this.giamTheoTien = giamTheoTien;
    }



    public float getSoLuongGiam() {
        return soLuongGiam;
    }

    public void setSoLuongGiam(float soLuongGiam) {
        this.soLuongGiam = soLuongGiam;
    }

    public BusSanPham getBusSanPham() {
        return busSanPham;
    }

    public void setBusSanPham(BusSanPham busSanPham) {
        this.busSanPham = busSanPham;
    }
    

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public List<DalImeiModel> getListImeis() {
        return listImeis;
    }

    public void setListImeis(List<DalImeiModel> listImeis) {
        this.listImeis = listImeis;
    }

    

    public CartModel() {
    }

    public int getMactsp() {
        return mactsp;
    }

    public void setMactsp(int mactsp) {
        this.mactsp = mactsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }


    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
