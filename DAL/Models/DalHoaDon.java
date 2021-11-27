/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DalHoaDon {
    private int maHD;
    private Date ngayThanhToan;
    private Date ngayTao;
    private float tongTien;
    private float tienKhachTra;
    private String diaChiNhanHang;
    private String manv;
    private int makh;
    private float phiVanChuyen;
    private Date ngayGiaoHang;
    private String ghiChu;
    private boolean trangThai;

    public float getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(float phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(float tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }


    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
