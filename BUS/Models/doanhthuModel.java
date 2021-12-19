/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class doanhthuModel {
    Date thang;
    float doanhthu;

    public doanhthuModel() {
    }

    public doanhthuModel(Date thang, float doanhthu) {
        this.thang = thang;
        this.doanhthu = doanhthu;
    }

    public Date getThang() {
        return thang;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public void setThang(Date thang) {
        this.thang = thang;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }
    
}
