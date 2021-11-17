/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.soluongbanmodel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ThongKeServicesImpl implements ThongKeServices{
    private ThongKeDao thongKeDao = null;
    public ThongKeServicesImpl(){
        this.thongKeDao = new ThongKeDaoImpl();
    }
    @Override
    public List<soluongbanmodel> GetSLBan() {
        return thongKeDao.GetSLBan();
    }
    
    
}
