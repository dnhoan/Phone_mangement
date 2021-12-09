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

    private int maLoaiPin;
    private String loaiPin;
    private float dungLuongPin;
    private boolean trangThai = true;

    public BusPinModel() {
    }

    public BusPinModel(int maLoaiPin, String loaiPin, float dungLuongPin, boolean trangThai) {

        this.maLoaiPin = maLoaiPin;
        this.loaiPin = loaiPin;
        this.dungLuongPin = dungLuongPin;
        this.trangThai = trangThai;
    }

    public BusPinModel(int maLoaiPin, String loaiPin, float dungLuongPin) {
        this.maLoaiPin = maLoaiPin;
        this.loaiPin = loaiPin;
        this.dungLuongPin = dungLuongPin;
    }

    public int getMaLoaiPin() {
        return maLoaiPin;
    }

    public void setMaLoaiPin(int maLoaiPin) {
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
        return loaiPin + " - " + dungLuongPin + " mAh";
    }

}
