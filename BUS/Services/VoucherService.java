/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IVoucher;
import BUS.Models.BusVoucherModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author 84349
 */
public class VoucherService implements IVoucher,IPhoneMangementService<BusVoucherModel, Object>{

    @Override
    public void insert(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.getTenKM(),
                    entity.getMaVC(),
                    entity.getNgayBD(),
                    entity.getNgayKT(),
                    entity.getLoaiGG(),
                    entity.isTrangThai(),
                    entity.getMucGG(),
                    entity.getLoaikm()
                    );
//            [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void insertsalehoadon(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT_SALE_HOADON,
                    entity.getTenKM(),
                    entity.getMaVC(),
                    entity.getNgayBD(),
                    entity.getNgayKT(),
                    entity.getLoaiGG(),
                    entity.isTrangThai(),
                    entity.getMucGG(),
                    entity.getLoaikm(),
                    entity.getDKKM()
                    );
//            [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM],[DKKM]
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
public void  insertspsale(int masp ){
    try {
            JDBCHelper.executeUpdate(INSERTNEW,
                    masp
                    );
//            [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public void insertsanphamdcsale(int masp,int makm) {
        try {
            JDBCHelper.executeUpdate(INSERT_SPSALE,
                    masp,
                    makm
                    );
//            [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void deleteSPsale(BusVoucherModel entity){
        try {
            String sql="DELETE FROM sanphamdcsale WHERE maKM=?";
            JDBCHelper.executeUpdate(sql, entity.getMaKM());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public void update(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getTenKM(),
                    entity.getLoaiGG(),
                    entity.getMucGG(),
                    entity.getMaKM()
                    );
//            TenKM=?, LoaiGG=?, MucGG=?
        } catch (Exception e) {
        }
    }
    public void updatesalehoadon(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE_SALE_HOADON,
                    entity.getTenKM(),
                    entity.getLoaiGG(),
                    entity.getMucGG(),
                    entity.getDKKM(),
                    entity.getMaKM()
                    );
//            TenKM=?, LoaiGG=?, MucGG=?
        } catch (Exception e) {
        }
    }
    public void updatebyMaKM(BusVoucherModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getTenKM(),
                    entity.getLoaiGG(),
                    entity.getMucGG(),
                    entity.getMaKM()
                    );
//            TenKM=?, LoaiGG=?, MucGG=?
        } catch (Exception e) {
        }
    }
    

    @Override
    public void delete(Object id) {
        try {
            String sql = DELETE;
            JDBCHelper.executeUpdate(sql,
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BusVoucherModel selectByID(Object id) {
        String sql = "SELECT * FROM KhuyenMai WHERE Makm=?";
        List<BusVoucherModel> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<BusVoucherModel> selectAll() {
         String sql = SELECT_ALL;
        return selectBySql(sql);
    }

    @Override
    public List<BusVoucherModel> selectBySql(String sql, Object... args) {
        List<BusVoucherModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BusVoucherModel model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
//            System.out.println("hi");
            throw new RuntimeException(ex);
        }
        return list;
    
    }
    public void Update_NgayBD_Ngaykt(BusVoucherModel entity){
        try {
            JDBCHelper.executeUpdate(UPDATE_NGAYBD_NGAYKT, 
                    entity.getNgayBD(),
                    entity.getNgayKT(),
                    entity.getMaKM()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<BusVoucherModel> selectGiamGiaByMasp(int masp) {
        VoucherService voucherService = new VoucherService();
        List<BusVoucherModel> list = voucherService.selectBySql(SELECT_MAGG_BY_MASP, masp);
        return list == null ?  null : list;
    }
    public static List<BusVoucherModel> selectGiamGiaHoaDon() {
        VoucherService voucherService = new VoucherService();
        List<BusVoucherModel> list = voucherService.selectBySql(SELECT_GIAMGAI_HOADON);
        return list == null ?  null : list;
    }
    public static void fillCombo(DefaultComboBoxModel<BusVoucherModel> model, JComboBox cbo, int masp) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            List<BusVoucherModel> list = selectGiamGiaByMasp(masp);
            cbo.addItem("");
            if (list != null) {
                for (BusVoucherModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fillCombo(DefaultComboBoxModel<BusVoucherModel> model, JComboBox cbo, List<BusVoucherModel> list) {
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = selectGiamGiaHoaDon();
            cbo.addItem("");
            if (list != null) {
                for (BusVoucherModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private BusVoucherModel readFromResultSet(ResultSet rs) throws SQLException {
//        [tenKM],[MaVC],[NgayBD],[NgayKT],[LoaiGG],[TrangThai],[mucGG],[LoaiKM]
        BusVoucherModel entity = new BusVoucherModel();
        entity.setMaKM(rs.getInt("MaKM"));
        entity.setLoaikm(rs.getInt("loaiKm"));
        entity.setTenKM(rs.getString("tenKM"));
      entity.setMaVC(rs.getString("mavc"));
        entity.setLoaiGG(rs.getInt("LoaiGG"));
        entity.setNgayBD(rs.getDate("NgayBD"));
       entity.setNgayKT(rs.getDate("NgayKT"));
       entity.setMucGG(rs.getInt("mucGG"));
       entity.setTrangThai(rs.getBoolean("trangthai"));
       entity.setDKKM(rs.getInt("DKKM"));
        return entity;

    }
}
