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
    private String maHD;
    private Date ngayBan;
    private String manv;
    private int makh;
    private int makm;
    private String ghiChu;
    private boolean trangThai;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getMakm() {
        return makm;
    }

    public void setMakm(int makm) {
        this.makm = makm;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
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
