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
//    [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]
 private int MaKM;
    private boolean loaikm;
    private String tenKM;
    private String maVC;
    private Date NgayBD;
    private Date NgayKT;
    private int LoaiGG;
    private int mucGG;
    private boolean TrangThai;
    public  String MucGGtable(){
        String ha= null;
        if(LoaiGG==0){
            ha=mucGG+" VND";
        }else if(LoaiGG==1){
            ha= mucGG+" %";
        }
        
        return ha;
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
            long noDay2 = (c3.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
            if (noDay <0) {
                TrangThai=false;
                return hi="Sắp diễn ra";
                
            }
            else if(noDay>0&&noDay1>0||noDay==0){
                TrangThai=true;
                return hi="Đang diễn ra";
            }
            else if(noDay1<0 ||noDay2==0){
                TrangThai=false;
                return hi="Đã kết thúc";
            }
//            else if(noDay1==0){
//                TrangThai=false;
//                return hi=""
//            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return hi;
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

    public int getLoaiGG() {
        return LoaiGG;
    }

    public void setLoaiGG(int LoaiGG) {
        this.LoaiGG = LoaiGG;
    }

    

    public int getMucGG() {
        return mucGG;
    }

    public void setMucGG(int mucGG) {
        this.mucGG = mucGG;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    

   

}
