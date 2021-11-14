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
    private int mactsp;
    private int soLuong;
    private float gia;
    private boolean trangThai;

    public int getMactsp() {
        return mactsp;
    }

    public void setMactsp(int mactsp) {
        this.mactsp = mactsp;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
