/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

/**
 *
 * @author LENOVO
 */
public class doanhthuModel {
    String thang;
    float doanhthu;

    public doanhthuModel() {
    }

    public doanhthuModel(String thang, float doanhthu) {
        this.thang = thang;
        this.doanhthu = doanhthu;
    }

    public String getThang() {
        return thang;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }
    
}
