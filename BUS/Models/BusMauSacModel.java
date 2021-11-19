/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import DAL.Models.DalMauSacModel;

/**
 *
 * @author ADMIN
 */
public class BusMauSacModel {
    private DalMauSacModel dalMauSacModel;

    public DalMauSacModel getDalMauSacModel() {
        return dalMauSacModel;
    }

    public void setDalMauSacModel(DalMauSacModel dalMauSacModel) {
        this.dalMauSacModel = dalMauSacModel;
    }

    @Override
    public String toString() {
        return dalMauSacModel.getTenMau();
    }
    
    
    
}
