/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BusHoaDon {
    private int mahd;
    private Date ngayThanhToan;
    private NhanVienModel nhanVienModel;
    private KhachHangModel khachHangModel;
    private int soLuong;
    private Date ngayTao;
    private float tongTien;
    private float tienKhachTra;
    private String diaChiNhanHang;
    private float phiVanChuyen;
    private String ghiChu;
    private int trangThaiGiaoHang;
    private int makm;
    private float tiemKhuyenMai;
    private boolean trangThai;

    public int getMakm() {
        return makm;
    }

    public void setMakm(int makm) {
        this.makm = makm;
    }

    public float getTiemKhuyenMai() {
        return tiemKhuyenMai;
    }

    public void setTiemKhuyenMai(float tiemKhuyenMai) {
        this.tiemKhuyenMai = tiemKhuyenMai;
    }

    public int getTrangThaiGiaoHang() {
        return trangThaiGiaoHang;
    }

    public void setTrangThaiGiaoHang(int trangThaiGiaoHang) {
        this.trangThaiGiaoHang = trangThaiGiaoHang;
    }

    public float getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(float phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(float tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }



    public NhanVienModel getNhanVienModel() {
        return nhanVienModel;
    }

    public void setNhanVienModel(NhanVienModel nhanVienModel) {
        this.nhanVienModel = nhanVienModel;
    }



    public KhachHangModel getKhachHangModel() {
        return khachHangModel;
    }

    public void setKhachHangModel(KhachHangModel khachHangModel) {
        this.khachHangModel = khachHangModel;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
