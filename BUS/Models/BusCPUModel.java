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
public class BusCPUModel {
    private int maCPU;
    private String tenCPU;
    private boolean trangThai;

    public BusCPUModel(int maCPU, String tenCPU, boolean trangThai) {
        this.maCPU = maCPU;
        this.tenCPU = tenCPU;
        this.trangThai = trangThai;
    }

    public BusCPUModel(int maCPU, String tenCPU) {
        this.maCPU = maCPU;
        this.tenCPU = tenCPU;
    }

    public BusCPUModel() {
    }

    public int getMaCPU() {
        return maCPU;
    }

    public void setMaCPU(int maCPU) {
        this.maCPU = maCPU;
    }

    public String getTenCPU() {
        return tenCPU;
    }

    public void setTenCPU(String tenCPU) {
        this.tenCPU = tenCPU;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenCPU;
    }
    
}
