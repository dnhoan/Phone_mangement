/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Models;

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
    private List<String> listImeis;

    public List<String> getListImeis() {
        return listImeis;
    }

    public void setListImeis(List<String> listImeis) {
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
