/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

/**
 *
 * @author LENOVO
 */
public class BusDiemDanh {
    String manv;
    int madiemdanh;
    String ngaydiemdanh;
    Boolean diemdanh,dimuon,trangthai;

    public BusDiemDanh() {
    }

    public BusDiemDanh(String manv, int madiemdanh, String ngaydiemdanh, Boolean diemdanh, Boolean dimuon, Boolean trangthai) {
        this.manv = manv;
        this.madiemdanh = madiemdanh;
        this.ngaydiemdanh = ngaydiemdanh;
        this.diemdanh = diemdanh;
        this.dimuon = dimuon;
        this.trangthai = trangthai;
    }

  
    public String getManv() {
        return manv;
    }

  

    public int getMadiemdanh() {
        return madiemdanh;
    }

    public String getNgaydiemdanh() {
        return ngaydiemdanh;
    }

    public Boolean getDiemdanh() {
        return diemdanh;
    }

    public Boolean getDimuon() {
        return dimuon;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    

    public void setMadiemdanh(int madiemdanh) {
        this.madiemdanh = madiemdanh;
    }

    public void setNgaydiemdanh(String ngaydiemdanh) {
        this.ngaydiemdanh = ngaydiemdanh;
    }

    public void setDiemdanh(Boolean diemdanh) {
        this.diemdanh = diemdanh;
    }

    public void setDimuon(Boolean dimuon) {
        this.dimuon = dimuon;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }
    

}