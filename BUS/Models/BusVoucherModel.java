/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import GUI.Services.DateService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 84349
 */
public class BusVoucherModel {

    private int MaKM;
    private boolean loaikm;
    private String tenKM;
    private String maVC;
    private String DieuKienKM;
    private int LoaiGG;
    private Date NgayBD;
    private Date NgayKT;
    private int SotienduocTru;
    private int GiaTriDonHangToiThieu;
    private int tongsoluotsd;
    private boolean  TrangThai;

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    public String TrangThaitable() {
        String hi = null;
        try {
            LocalDate dateNgay = LocalDate.now();
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dateNgay.toString());
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            c1.setTime(NgayBD);
            c2.setTime(d);
            c3.setTime(NgayKT);
//
//        // Công thức tính số ngày giữa 2 mốc thời gian:
            long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
            long noDay1 = (c3.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
            
            if (noDay <0) {
                return hi="Sắp diễn ra";
                
            }
            else if(noDay>0&&noDay1>0){
                return hi="Đang diễn ra";
            }
            else if(noDay1<0){
                return hi="Đã két thúc";
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return hi;
    }

    public int getTongsoluotsd() {
        return tongsoluotsd;
    }

    public void setTongsoluotsd(int tongsoluotsd) {
        this.tongsoluotsd = tongsoluotsd;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }

    public boolean isLoaikm() {
        return loaikm;
    }

    public void setLoaikm(boolean loaikm) {
        this.loaikm = loaikm;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getDieuKienKM() {
        return DieuKienKM;
    }

    public void setDieuKienKM(String DieuKienKM) {
        this.DieuKienKM = DieuKienKM;
    }

    public int getLoaiGG() {
        return LoaiGG;
    }

    public void setLoaiGG(int LoaiGG) {
        this.LoaiGG = LoaiGG;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public int getSotienduocTru() {
        return SotienduocTru;
    }

    public void setSotienduocTru(int SotienduocTru) {
        this.SotienduocTru = SotienduocTru;
    }

    public int getGiaTriDonHangToiThieu() {
        return GiaTriDonHangToiThieu;
    }

    public void setGiaTriDonHangToiThieu(int GiaTriDonHangToiThieu) {
        this.GiaTriDonHangToiThieu = GiaTriDonHangToiThieu;
    }

}
