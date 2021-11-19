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
public class DalMauSacModel {
    private int maMau;
    private String tenMau;
    private boolean trangThai;

    public DalMauSacModel() {
    }

    public DalMauSacModel(String tenMau, boolean trangThai) {
        this.tenMau = tenMau;
        this.trangThai = trangThai;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public boolean isTrangThai() {
        return trangThai;
    } 

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
