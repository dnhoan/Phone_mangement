/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.soluongbanmodel;
import BUS.Models.doanhthuModel;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public interface ThongKeServices {
   public List<soluongbanmodel> GetSLBan();
   
   public List<doanhthuModel> GetDoanhThu();
}
