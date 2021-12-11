package BUS.Services;

import BUS.IServices.ICTSanPhamService;
import BUS.Models.BusCPUModel;
import BUS.Models.BusCTSanPhamModel;
import BUS.Models.BusCameraModel;
import BUS.Models.BusDongSpModel;
import BUS.Models.BusHangModel;
import BUS.Models.BusHeDieuHanhModel;
import BUS.Models.BusManHinhModel;
import BUS.Models.BusMauSacModel;
import BUS.Models.BusPhanLoaiSpModel;
import BUS.Models.BusPinModel;
import BUS.Models.BusRamModel;
import BUS.Models.BusRomModel;
import BUS.Models.BusSanPham;
import BUS.Models.BusXuatXuModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalCTSanPhamModel;
import DAL.Models.DalMauSacModel;
import DAL.Models.DalPhanLoaiSpModel;
import DAL.Services.JDBCHelper;
import GUI.Models.CartModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamService implements ICTSanPhamService, IPhoneMangementService<DalCTSanPhamModel, Integer> {
    
    @Override
    public void insert(DalCTSanPhamModel sp) {
        System.out.println(sp.getMaMau() + " " + sp.getMaPhanLoai());
        try {
            JDBCHelper.executeUpdate(INSERT,
                    sp.getGiaNhap(),
                    sp.getGiaBan(),
                    sp.getSoLuongNhap(),
                    sp.getTonKho(),
                    sp.getHinh(),
                    sp.getMota(),
                    sp.getMaCamera(),
                    sp.getMaRom(),
                    sp.getMaRam(),
                    sp.getMaHeDieuHanh(),
                    sp.getMaXuatXu(),
                    sp.getMaLoaiPin(),
                    sp.getMaManHinh(),
                    sp.getMaCpu(),
                    sp.getMaSp(),
                    sp.getMaMau(),
                    sp.getMaPhanLoai()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStock(Integer id, int stock) {
        try {
           JDBCHelper.executeUpdate(UPDATE_STOCK,stock, id);
        } catch (SQLException e) {
        }
    }
    @Override
    public void update(DalCTSanPhamModel sp) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    sp.getGiaNhap(),
                    sp.getGiaBan(),
                    sp.getSoLuongNhap(),
                    sp.getTonKho(),
                    sp.getHinh(),
                    sp.getMota(),
                    sp.getMaCamera(),
                    sp.getMaRom(),
                    sp.getMaRam(),
                    sp.getMaHeDieuHanh(),
                    sp.getMaXuatXu(),
                    sp.getMaLoaiPin(),
                    sp.getMaManHinh(),
                    sp.getMaCpu(),
                    sp.getMaSp(),
                    sp.getMaMau(),
                    sp.getMaPhanLoai(),
                    sp.getMactsp()
            );
        } catch (SQLException e) {
        }
    }
    public int selectLastIdSp() {
        try {
            ResultSet rs = JDBCHelper.executeQuery(LAST_ID);
            while(rs.next()) {
                return rs.getInt("LastID");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    public void backup(Integer id) {
        try {
            JDBCHelper.executeUpdate(BACKUP, id);
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(Integer id) {
        System.out.println(id);
        try {
            JDBCHelper.executeUpdate(DELETE, id);
        } catch (SQLException e) {
        }
    }

    @Override
    public DalCTSanPhamModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID, id).get(0);
    }

    public BusCTSanPhamModel selectID(Integer id) {
        if (this.select(SELECT_BY_ID, id) == null) {
            return null;
        }
        return this.select(SELECT_BY_ID, id).get(0);
    }

    @Override
    public List<DalCTSanPhamModel> selectAll() {
        if (this.selectBySql(SELECT_ALL) == null) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    public List<DalCTSanPhamModel> selectBySql(String sql, Object... args) {
        return null;
    }

    public List<BusCTSanPhamModel> select(String sql, Object... args) {
        List<BusCTSanPhamModel> listProducts = new ArrayList<>();
        try {
            ResultSet resultSet = JDBCHelper.executeQuery(sql, args);
            while (resultSet.next()) {
                BusCTSanPhamModel product = this.getResultSet(resultSet);
                listProducts.add(product);
            }
            resultSet.getStatement().close();
            return listProducts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Integer selectMaspByMactsp(int mactsp) {
        try {
            ResultSet resultSet = JDBCHelper.executeQuery("select SanPham.MaSP from SanPham inner join CTSANPHAM on SanPham.MaSP = CTSANPHAM.MaSP where MACTSP = ?", mactsp);
            while (resultSet.next()) {
                return resultSet.getInt("masp");
            }
            resultSet.getStatement().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
//    public static void main(String[] args) {
//        SanPhamService sanPhamService = new SanPhamService();
//        BusCTSanPhamModel busCTSanPhamModel = sanPhamService.selectID(5);
//        List<BusCTSanPhamModel> list = sanPhamService.selectBySearch("");
//    }

    public List<BusCTSanPhamModel> selectRecycle(int tonKho, String term) {
        return this.select(SELECT_BY_KEYWORD, 0, tonKho,
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%"
        );
    }

    public List<BusCTSanPhamModel> selectBySearch(int tonKho, String term) {
        return this.select(SELECT_BY_KEYWORD,1, tonKho,
                 "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%"
        );
    }
    public List<BusCTSanPhamModel> selectBySearchAndPhanLoai(int tonKho, String term, int maPhanLoai) {
        return this.select(SELECT_BY_KEYWORD_AND_PHAN_LOAI,1, tonKho, maPhanLoai,
                 "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%"
        );
    }
    public List<CartModel> selectSpByMahd(int mahd) {
            List<CartModel> listCart = new ArrayList<>();
            try {
                ResultSet resultSet = JDBCHelper.executeQuery(SELECT_SP_BY_HOADON, mahd);
                while (resultSet.next()) {
                    CartModel cart = new CartModel();
                    cart.setTensp(resultSet.getString("TenSP"));
                    cart.setHinh(resultSet.getString("hinh"));
                    cart.setGia(resultSet.getFloat("giaban"));
                    cart.setMactsp(resultSet.getInt("mactsp"));
                    cart.setTongTien(resultSet.getFloat("tongtien"));
                    cart.setSoLuong(resultSet.getInt("sl"));
                    listCart.add(cart);
                }
                resultSet.getStatement().close();
                return listCart;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    private BusCTSanPhamModel getResultSet(ResultSet rs) throws SQLException {
        BusCTSanPhamModel sp = new BusCTSanPhamModel();
        sp.setMaCTSP(rs.getInt("MACTSP"));
        sp.setGiaBan(rs.getFloat("giaban"));
        sp.setGiaNhap(rs.getFloat("gianhap"));
        sp.setNgayNhap(rs.getDate("ngaynhap"));
        sp.setTonKho(rs.getInt("tonKho"));
        sp.setHinh(rs.getString("hinh"));
        sp.setMota(rs.getString("mota"));
        BusCameraModel cameraModel = new BusCameraModel(
                rs.getInt("macamera"),
                rs.getString("loaicamera"),
                rs.getString("dophangiacam")
        );
        BusRomModel romModel = new BusRomModel(
                rs.getInt("marom"),
                rs.getString("tenrom"),
                rs.getFloat("Dungluongrom")
        );
        BusRamModel ramModel = new BusRamModel(
                rs.getInt("maram"),
                rs.getString("LoaiRam"),
                rs.getFloat("dungluongram")
        );
        BusHeDieuHanhModel heDieuHanhModel = new BusHeDieuHanhModel(
                rs.getInt("mahedieuhanh"),
                rs.getString("tenHeDieuHanh")
        );
        BusXuatXuModel xuatXuModel = new BusXuatXuModel(
                rs.getInt("maxuatxu"),
                rs.getString("noixuatxu")
        );
        BusPinModel pinModel = new BusPinModel(
                rs.getInt("MaPin"),
                rs.getString("LoaiPin"),
                rs.getFloat("DungLuongPin")
        );
        BusManHinhModel manHinhModel = new BusManHinhModel(
                rs.getInt("MaManHinh"),
                rs.getString("LoaiManHinh"),
                rs.getFloat("KICKTHUOCMANHINH"),
                rs.getString("DOPHANGIAIMANHINH")
        );
        BusCPUModel cPUModel = new BusCPUModel(
                rs.getInt("macpu"),
                rs.getString("tencpu")
        );
        BusMauSacModel busMauSacModel = new BusMauSacModel();
        DalMauSacModel dalMauSacModel = new DalMauSacModel();
        dalMauSacModel.setMaMau(rs.getInt("MaMau"));
        dalMauSacModel.setTenMau(rs.getString("TenMau"));
        busMauSacModel.setDalMauSacModel(dalMauSacModel);
        
        BusPhanLoaiSpModel busPhanLoaiSpModel = new BusPhanLoaiSpModel();
        DalPhanLoaiSpModel dalPhanLoaiSpModel = new DalPhanLoaiSpModel();
        dalPhanLoaiSpModel.setMaPhanLoai(rs.getInt("MaPhanLoai"));
        dalPhanLoaiSpModel.setTenLoai(rs.getString("Loai"));
        busPhanLoaiSpModel.setDalPhanLoaiSpModel(dalPhanLoaiSpModel);
        
        sp.setBusMauSacModel(busMauSacModel);
        sp.setBusPhanLoaiSpModel(busPhanLoaiSpModel);
        sp.setCameraModel(cameraModel);
        sp.setRomModel(romModel);
        sp.setRamModel(ramModel);
        sp.setHeDieuHanhModel(heDieuHanhModel);
        sp.setXuatXuModel(xuatXuModel);
        sp.setPinModel(pinModel);
        sp.setManHinhModel(manHinhModel);
        sp.setcPUModel(cPUModel);
        sp.setSoLuongNhap(rs.getInt("SoLuongNhap"));
        BusHangModel dalHangModel = new BusHangModel(rs.getInt("mahang"), rs.getString("tenHang"));
        BusDongSpModel busDongSpModel = new BusDongSpModel(rs.getInt("madong"), rs.getString("tendong"), dalHangModel);
        BusSanPham sanPham = new BusSanPham(rs.getInt("masp"), rs.getString("tensp"), busDongSpModel);
        sp.setSanPhamModel(sanPham);
        return sp;
    }
}
