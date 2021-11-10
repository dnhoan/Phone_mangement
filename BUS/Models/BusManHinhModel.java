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
public class BusManHinhModel {

    private String maManHinh;
    private String loaiManHinh;
    private float kichThuoc = 0;
    private String doPhanGiaiManHinh;
    private boolean trangThai = true;

    public BusManHinhModel(String maManHinh, String loaiManHinh, float kichThuoc, String doPhanGiaiManHinh, boolean trangThai) {
        this.maManHinh = maManHinh;
        this.loaiManHinh = loaiManHinh;
        this.kichThuoc = kichThuoc;
        this.doPhanGiaiManHinh = doPhanGiaiManHinh;
        this.trangThai = trangThai;
    }

    public BusManHinhModel(String maManHinh, String loaiManHinh, float kichThuoc, String doPhanGiaiManHinh) {
        this.maManHinh = maManHinh;
        this.loaiManHinh = loaiManHinh;
        this.kichThuoc = kichThuoc;
        this.doPhanGiaiManHinh = doPhanGiaiManHinh;
    }

    public BusManHinhModel() {
    }

    public String getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(String maManHinh) {
        this.maManHinh = maManHinh;
    }

    public String getLoaiManHinh() {
        return loaiManHinh;
    }

    public void setLoaiManHinh(String loaiManHinh) {
        this.loaiManHinh = loaiManHinh;
    }

    public float getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(float kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getDoPhanGiaiManHinh() {
        return doPhanGiaiManHinh;
    }

    public void setDoPhanGiaiManHinh(String doPhanGiaiManHinh) {
        this.doPhanGiaiManHinh = doPhanGiaiManHinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maManHinh + " - " + loaiManHinh;
    }

}
