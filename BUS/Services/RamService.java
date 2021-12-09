/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.ISanPhamService.SELECT_ALL;
import BUS.Models.BusRamModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BUS.IServices.IRamService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author ADMIN
 */
public class RamService implements IRamService, IPhoneMangementService<BusRamModel, Integer> {
      String KHOIPHUC = "UPDATE RamSP SET TrangThai = 1 WHERE MaRam = ?";
      public  void khoiphuc(int id){
        try {
            this.selectBySql(KHOIPHUC, id);
        } catch (Exception e) {
        }
    }
    @Override
    public void insert(BusRamModel entity) {
           try {
            this.selectBySql( INSERT, entity.getLoaiRam(),entity.getDungLuongRam(),entity.isTrangThai());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BusRamModel entity) {
         try {
            this.selectBySql(UPDATE, entity.getLoaiRam(),entity.getDungLuongRam(),entity.isTrangThai(),entity.getMaRam());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusRamModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<BusRamModel> selectAll() {
        try {
             if (this.selectBySql(SELECT_BY_STATUS,1).isEmpty()) {
                return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,1);
        } catch (Exception e) {
        } return null;
   
    }
     public List<BusRamModel> selectStatus(){
         if (this.selectBySql(SELECT_BY_STATUS,0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS,0);
    }
    public static void fillCombo(DefaultComboBoxModel<BusRamModel> model, JComboBox cbo, List<BusRamModel> list) {
        RamService ramService = new RamService();
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = ramService.selectAll();
            if (list != null) {
                for (BusRamModel ram : list) {
                    model.addElement(ram);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BusRamModel> selectBySql(String sql, Object... args) {
        List<BusRamModel> listCam = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusRamModel ramModel = new BusRamModel(
                        rs.getInt("maram"),
                        rs.getString("LoaiRam"),
                        rs.getFloat("dungluongram"),
                        rs.getBoolean("TrangThai")
                );
                listCam.add(ramModel);
            }
            rs.getStatement().close();
            return listCam;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
