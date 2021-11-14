/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.Models.KhachHangModel;
import DAL.IServices.IPhoneMangementService;

import static BUS.IServices.IKhachHangServices.*;
import DAL.Services.JDBCHelper;
import GUI.QuanLyKhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUCNAM
 */
public class KhachHangService implements IPhoneMangementService<KhachHangModel, Integer>{

    @Override
    public void insert(KhachHangModel kh) {
           try {
            JDBCHelper.executeUpdate(INSERT,
                    kh.getTenKH(),
                    kh.getSDT(),
                    
                    kh.getDiaChi(),
                    kh.isGioiTinh(),
                    kh.getNgaySinh(),
                    kh.getNgayTao(),
                    kh.getGhiChu()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(KhachHangModel kh) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                 
                kh.getTenKH(),
                kh.isGioiTinh(),
                kh.getSDT(),
                kh.getDiaChi(),
                kh.getNgaySinh(),
                kh.getNgayTao(),
                kh.getGhiChu(),
                kh.getMaKH()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }         
                
    }

    @Override
    public void delete(Integer id) {
       try {
            JDBCHelper.executeUpdate(DELETE, id );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void delete2(Integer id) {
       try {
            JDBCHelper.executeUpdate(DELETE2, id );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KhachHangModel selectByID(Integer id) {
         if (this.selectBySql(SELECT_BY_ID,id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID,id).get(0);
    }

    
    public List<KhachHangModel> selectAll1() {
        if (this.selectBySql(SELECT_ALL,1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL,1);
    }
    public List<KhachHangModel> selectAll2() {
        if (this.selectBySql(SELECT_ALL,0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL,0);
    }
  
    @Override
    public List<KhachHangModel> selectBySql(String sql, Object... args) {
           List<KhachHangModel> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {                
                KhachHangModel entity = new KhachHangModel();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setTenKH(rs.getString("HoTen"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setSoLanMua(rs.getInt("SoLanMua"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
           
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     public List<KhachHangModel> selectByName(String keyword){
        String sql = "	select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" +
"	Where HoTen like ? and KhachHang.TrangThai = 1" + 
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai";
        return selectBySql(sql, "%"+keyword+"%");
    }
      public List<KhachHangModel> selectByAge(String keyword,String keyword2){
        String sql = "	select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" +
"       where year(Getdate())-  year(NgaySinh) > ?  and year(Getdate())-  year(NgaySinh)<  ? and KhachHang.TrangThai = 1"+
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai";
        return selectBySql(sql, keyword,keyword2);
    }
       public List<KhachHangModel> selectByName2(String keyword){
        String sql = "	select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" +
"	Where HoTen like ? and KhachHang.TrangThai = 0" + 
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai";
        return selectBySql(sql, "%"+keyword+"%");
    }
   
      public List<KhachHangModel> selectByAge2(String keyword,String keyword2){
        String sql = "	select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang\n" +
"	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH\n" +
"       where year(Getdate())-  year(NgaySinh) > ?  and year(Getdate())-  year(NgaySinh)<  ? and KhachHang.TrangThai = 0"+
"	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai";
        return selectBySql(sql, keyword,keyword2);
    }

public List<KhachHangModel> selectToFillCombo(String keyWord) {
        List<KhachHangModel> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery("select * from KhachHang where TrangThai = 1 and HoTen like ?", "%" + keyWord + "%");
            while (rs.next()) {
                KhachHangModel entity = new KhachHangModel();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setTenKH(rs.getString("HoTen"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<KhachHangModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
