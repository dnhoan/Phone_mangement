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
public class BusRamModel {
    private int maRam;
    private String loaiRam;
    private float dungLuongRam;
    private boolean trangThai;

    public BusRamModel(int maRam, String loaiRam, float dungLuongRam, boolean trangThai) {
        this.maRam = maRam;
        this.loaiRam = loaiRam;
        this.dungLuongRam = dungLuongRam;
        this.trangThai = trangThai;
    }

    public BusRamModel(int maRam, String loaiRam) {
        this.maRam = maRam;
        this.loaiRam = loaiRam;
    }

    public BusRamModel(int maRam, String loaiRam, float dungLuongRam) {
        this.maRam = maRam;
        this.loaiRam = loaiRam;
        this.dungLuongRam = dungLuongRam;
    }

    

    public BusRamModel() {
    }

    
    
    
    public int getMaRam() {
        return maRam;
    }

    public void setMaRam(int maRam) {
        this.maRam = maRam;
    }

    public String getLoaiRam() {
        return loaiRam;
    }

    public void setLoaiRam(String loaiRam) {
        this.loaiRam = loaiRam;
    }

    public float getDungLuongRam() {
        return dungLuongRam;
    }

    public void setDungLuongRam(float dungLuongRam) {
        this.dungLuongRam = dungLuongRam;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return loaiRam + " - " + dungLuongRam+" gb";
    }
    
}
