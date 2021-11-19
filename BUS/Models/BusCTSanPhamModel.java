
package BUS.Models;

import java.util.Date;

public class BusCTSanPhamModel {
    private int maCTSP;
    private Date ngayNhap;
    private float giaBan;
    private float giaNhap;
    private String hinh;
    private String mota;
    private int tonKho;
    private int soLuongNhap;
    private boolean trangThai;
    private BusCameraModel cameraModel;
    private BusManHinhModel manHinhModel;
    private BusCPUModel cPUModel;
    private BusHeDieuHanhModel heDieuHanhModel;
    private BusPinModel pinModel;
    private BusRamModel ramModel;
    private BusRomModel romModel;
    private BusXuatXuModel xuatXuModel;
    private BusSanPham sanPhamModel;
    private BusMauSacModel busMauSacModel;
    private BusPhanLoaiSpModel busPhanLoaiSpModel;
            



    public BusMauSacModel getBusMauSacModel() {
        return busMauSacModel;
    }

    public void setBusMauSacModel(BusMauSacModel busMauSacModel) {
        this.busMauSacModel = busMauSacModel;
    }

    public BusPhanLoaiSpModel getBusPhanLoaiSpModel() {
        return busPhanLoaiSpModel;
    }

    public void setBusPhanLoaiSpModel(BusPhanLoaiSpModel busPhanLoaiSpModel) {
        this.busPhanLoaiSpModel = busPhanLoaiSpModel;
    }

    public BusCTSanPhamModel(int maCTSP, Date ngayNhap, float giaBan, float giaNhap, String hinh, String mota, int tonKho, int soLuongNhap, boolean trangThai, BusCameraModel cameraModel, BusManHinhModel manHinhModel, BusCPUModel cPUModel, BusHeDieuHanhModel heDieuHanhModel, BusPinModel pinModel, BusRamModel ramModel, BusRomModel romModel, BusXuatXuModel xuatXuModel, BusSanPham sanPhamModel, BusMauSacModel busMauSacModel, BusPhanLoaiSpModel busPhanLoaiSpModel) {
        this.maCTSP = maCTSP;
        this.ngayNhap = ngayNhap;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.hinh = hinh;
        this.mota = mota;
        this.tonKho = tonKho;
        this.soLuongNhap = soLuongNhap;
        this.trangThai = trangThai;
        this.cameraModel = cameraModel;
        this.manHinhModel = manHinhModel;
        this.cPUModel = cPUModel;
        this.heDieuHanhModel = heDieuHanhModel;
        this.pinModel = pinModel;
        this.ramModel = ramModel;
        this.romModel = romModel;
        this.xuatXuModel = xuatXuModel;
        this.sanPhamModel = sanPhamModel;
        this.busMauSacModel = busMauSacModel;
        this.busPhanLoaiSpModel = busPhanLoaiSpModel;
    }

    public BusCTSanPhamModel() {
    }

    public int getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(int maCTSP) {
        this.maCTSP = maCTSP;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public BusCameraModel getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(BusCameraModel cameraModel) {
        this.cameraModel = cameraModel;
    }

    public BusManHinhModel getManHinhModel() {
        return manHinhModel;
    }

    public void setManHinhModel(BusManHinhModel manHinhModel) {
        this.manHinhModel = manHinhModel;
    }

    public BusCPUModel getcPUModel() {
        return cPUModel;
    }

    public void setcPUModel(BusCPUModel cPUModel) {
        this.cPUModel = cPUModel;
    }

    public BusHeDieuHanhModel getHeDieuHanhModel() {
        return heDieuHanhModel;
    }

    public void setHeDieuHanhModel(BusHeDieuHanhModel heDieuHanhModel) {
        this.heDieuHanhModel = heDieuHanhModel;
    }

    public BusPinModel getPinModel() {
        return pinModel;
    }

    public void setPinModel(BusPinModel pinModel) {
        this.pinModel = pinModel;
    }

    public BusRamModel getRamModel() {
        return ramModel;
    }

    public void setRamModel(BusRamModel ramModel) {
        this.ramModel = ramModel;
    }

    public BusRomModel getRomModel() {
        return romModel;
    }

    public void setRomModel(BusRomModel romModel) {
        this.romModel = romModel;
    }

    public BusXuatXuModel getXuatXuModel() {
        return xuatXuModel;
    }

    public void setXuatXuModel(BusXuatXuModel xuatXuModel) {
        this.xuatXuModel = xuatXuModel;
    }

    public BusSanPham getSanPhamModel() {
        return sanPhamModel;
    }

    public void setSanPhamModel(BusSanPham sanPhamModel) {
        this.sanPhamModel = sanPhamModel;
    }

    
}
