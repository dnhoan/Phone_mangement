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
public class BusRomModel {
    private int maRom;
    private String loaiRon;
    private float dungLuongRom;
    private boolean trangThai;

    public BusRomModel(int maRom, String loaiRon, float dungLuongRom) {
        this.maRom = maRom;
        this.loaiRon = loaiRon;
        this.dungLuongRom = dungLuongRom;
    }

    public BusRomModel(int maRom, String loaiRon, float dungLuongRom, boolean trangThai) {
        this.maRom = maRom;
        this.loaiRon = loaiRon;
        this.dungLuongRom = dungLuongRom;
        this.trangThai = trangThai;
    }



    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public BusRomModel() {
    }

    public int getMaRom() {
        return maRom;
    }

    public void setMaRom(int maRom) {
        this.maRom = maRom;
    }

    public String getLoaiRon() {
        return loaiRon;
    }

    public void setLoaiRon(String loaiRon) {
        this.loaiRon = loaiRon;
    }

    public float getDungLuongRom() {
        return dungLuongRom;
    }

    public void setDungLuongRom(float dungLuongRom) {
        this.dungLuongRom = dungLuongRom;
    }

    @Override
    public String toString() {
        return "" + getLoaiRon()+" - " + getDungLuongRom();
    }
    
}
