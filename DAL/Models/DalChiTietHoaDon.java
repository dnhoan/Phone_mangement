/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Models;

/**
 *
 * @author ADMIN
 */
public class DalChiTietHoaDon {
    private int macthd;
    private int mahd;
    private int maImei;
    private float GiaBanSauSale;
    private float giaBan;
    private boolean trangThai;

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaBanSauSale() {
        return GiaBanSauSale;
    }

    public void setGiaBanSauSale(float GiaBanSauSale) {
        this.GiaBanSauSale = GiaBanSauSale;
    }

    public int getMaImei() {
        return maImei;
    }

    public void setMaImei(int maImei) {
        this.maImei = maImei;
    }


    public int getMacthd() {
        return macthd;
    }

    public void setMacthd(int macthd) {
        this.macthd = macthd;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
