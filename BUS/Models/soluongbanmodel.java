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
public class soluongbanmodel {
    private String thang;
    private int soluongban;

    public soluongbanmodel(String thang, int soluongban) {
        this.thang = thang;
        this.soluongban = soluongban;
    }

    public soluongbanmodel() {
    }

    public String getThang() {
        return thang;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }
    
}
