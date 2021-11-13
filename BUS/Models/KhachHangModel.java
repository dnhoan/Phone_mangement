/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import GUI.Services.DateService;
import java.util.Date;

/**
 *
 * @author DUCNAM
 */
public class KhachHangModel {
    int maKH;
    String tenKH;
    String SDT;
    String diaChi;
    boolean gioiTinh;
    
    Date ngaySinh;
    Date ngayTao;
    String ghiChu;
    boolean trangThai;
    int soLanMua;
    public KhachHangModel() {
    }

    public KhachHangModel(int maKH, String tenKH, String SDT, String diaChi, boolean gioiTinh, Date ngaySinh,Date ngayTao, String ghiChu, boolean trangThai, int soLanMua) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.soLanMua = soLanMua;
    }

    

    
    
    
    
    
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }
    
    
    
}
