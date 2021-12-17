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
public class soluongbanmodel {
    private Date thang;
    private int soluongban;

    public soluongbanmodel(Date thang, int soluongban) {
        this.thang = thang;
        this.soluongban = soluongban;
    }

    public soluongbanmodel() {
    }

    public Date getThang() {
        return thang;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setThang(Date thang) {
        this.thang = thang;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }
    
}
