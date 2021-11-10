/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package BUS.Models;

import DAL.Models.*;

/**
 *
 * @author ADMIN
 */
public class BusXuatXuModel {
    private int maXuatXu;
    private String noiXuatXu;
    private boolean trangThai;

    public BusXuatXuModel() {
    }

    public BusXuatXuModel(int maXuatXu, String noiXuatXu) {
        this.maXuatXu = maXuatXu;
        this.noiXuatXu = noiXuatXu;
    }

    public BusXuatXuModel(int maXuatXu, String noiXuatXu, boolean trangThai) {
        this.maXuatXu = maXuatXu;
        this.noiXuatXu = noiXuatXu;
        this.trangThai = trangThai;
    }

   


    public int getMaXuatXu() {
        return maXuatXu;
    }

    public String getNoiXuatXu() {
        return noiXuatXu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setMaXuatXu(int maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public void setNoiXuatXu(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return noiXuatXu ;
    }
    

    
}
