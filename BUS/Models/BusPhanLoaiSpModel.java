/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import DAL.Models.DalPhanLoaiSpModel;

/**
 *
 * @author ADMIN
 */
public class BusPhanLoaiSpModel {
    private DalPhanLoaiSpModel dalPhanLoaiSpModel;

    public DalPhanLoaiSpModel getDalPhanLoaiSpModel() {
        return dalPhanLoaiSpModel;
    }

    public void setDalPhanLoaiSpModel(DalPhanLoaiSpModel dalPhanLoaiSpModel) {
        this.dalPhanLoaiSpModel = dalPhanLoaiSpModel;
    }

    @Override
    public String toString() {
        return dalPhanLoaiSpModel.getTenLoai();
    }
    
}
