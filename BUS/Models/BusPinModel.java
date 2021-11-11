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
public class BusPinModel {

    private String maLoaiPin;
    private String loaiPin;
    private float dungLuongPin;
    private boolean trangThai = true;

    public BusPinModel() {
    }

    public BusPinModel(String maLoaiPin, String loaiPin, float dungLuongPin, boolean trangThai) {

        this.maLoaiPin = maLoaiPin;
        this.loaiPin = loaiPin;
        this.dungLuongPin = dungLuongPin;
        this.trangThai = trangThai;
    }

    public BusPinModel(String maLoaiPin, String loaiPin, float dungLuongPin) {
        this.maLoaiPin = maLoaiPin;
        this.loaiPin = loaiPin;
        this.dungLuongPin = dungLuongPin;
    }

    public String getMaLoaiPin() {
        return maLoaiPin;
    }

    public void setMaLoaiPin(String maLoaiPin) {
        this.maLoaiPin = maLoaiPin;
    }

    public String getLoaiPin() {
        return loaiPin;
    }

    public void setLoaiPin(String loaiPin) {
        this.loaiPin = loaiPin;
    }

    public float getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(float dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maLoaiPin + " - " + loaiPin;
    }

}
