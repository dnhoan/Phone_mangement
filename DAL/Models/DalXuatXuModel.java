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
public class DalXuatXuModel {
    private String maLoaiPin;
    private String noiXuatXu;
    private boolean trangThai;

    public String getMaLoaiPin() {
        return maLoaiPin;
    }

    public void setMaLoaiPin(String maLoaiPin) {
        this.maLoaiPin = maLoaiPin;
    }

    public String getNoiXuatXu() {
        return noiXuatXu;
    }

    public void setNoiXuatXu(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
