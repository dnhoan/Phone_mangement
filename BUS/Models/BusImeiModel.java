/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import DAL.Models.DalImeiModel;

/**
 *
 * @author ADMIN
 */
public class BusImeiModel {
    private DalImeiModel dalImeiModel;

    public DalImeiModel getDalImeiModel() {
        return dalImeiModel;
    }

    public void setDalImeiModel(DalImeiModel dalImeiModel) {
        this.dalImeiModel = dalImeiModel;
    }

    public BusImeiModel() {
    }

    @Override
    public String toString() {
        return dalImeiModel.getTenImei();
    }
    
    
}
