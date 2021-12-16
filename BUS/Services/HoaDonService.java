/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IHoaDonService;
import BUS.Models.BusHoaDon;
import BUS.Models.KhachHangModel;
import BUS.Models.NhanVienModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalHoaDon;
import DAL.Services.JDBCHelper;
import GUI.Services.DateService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonService implements IPhoneMangementService<DalHoaDon, Integer>, IHoaDonService {

    CTHoaDonService cTHoaDonService = new CTHoaDonService();

    @Override
    public void insert(DalHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.getManv(),
                    entity.getMakh(),
                    entity.getGhiChu(),
                    entity.getTongTien(),
                    entity.getTienKhachTra(),
                    entity.getNgayThanhToan() == null ? null : DateService.toString(entity.getNgayThanhToan(), "yyyy-MM-dd"),
                    entity.getDiaChiNhanHang(),
                    entity.getPhiVanChuyen(),
                    entity.getNgayGiaoHang() == null ? null : DateService.toString(entity.getNgayGiaoHang(), "yyyy-MM-dd"),
                    entity.getTrangThaiGiaoHang(),
                    entity.getMaKm(),
                    entity.getTienKm()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getNgayThanhToan() == null ? null : DateService.toString(entity.getNgayThanhToan(), "yyyy-MM-dd"),
                    entity.getTongTien(),
                    entity.getTienKhachTra(),
                    entity.getManv(),
                    entity.getMakh(),
                    entity.getGhiChu(),
                    entity.getDiaChiNhanHang(),
                    entity.getPhiVanChuyen(),
                    entity.getNgayGiaoHang() == null ? null : DateService.toString(entity.getNgayGiaoHang(), "yyyy-MM-dd"),
                    entity.getTrangThaiGiaoHang(),
                    entity.getMaKm(),
                    entity.getTienKm(),
                    entity.getMaHD()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTongTien(float tongTien, int mahd) {
        try {
            JDBCHelper.executeQuery(UPDATE_TONGTIEN, mahd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
//        try {
//            JDBCHelper.executeUpdate(DELETE, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public boolean updateTongTienKhiTraHang(float tongTien, float khachThanhToan, int mahd) {
        try {
            JDBCHelper.executeUpdate(UPDATE_TONGTIEN_KHACHTHANHTOAN, tongTien, khachThanhToan, mahd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isXoaHoaDon(int mahd) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(COUNT_NGAY_THANH_TOAN, mahd);
            System.out.println("mahd "+ mahd);
            while (rs.next()) {
                System.out.println("so ngay");
                return rs.getInt("soNgay") <= 7;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isBackUpHoaDon(int mahd) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CHECK_IMEI_BY_MAD, mahd);
            while (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void updateStatus(Integer status, Integer id, String ghiChu) {
        try {
            cTHoaDonService.updateStatus(status, id);
            JDBCHelper.executeUpdate(UPDATE_STATUS, status,ghiChu, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer selectLasID() {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SELECT_LASTID);
            while (rs.next()) {
                return rs.getInt("LastID");
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<BusHoaDon> selectAll1(String term, int filter) {
        System.out.println(filter);
        List<BusHoaDon> list = new ArrayList<>();
        try {
            String sql;
            switch (filter) {
                case 0:
                    sql = SELECT_ALL1; // tất cả hóa đơn đang treo
                    list = this.selectSql(sql, 1, "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%");
                    break;
                case 1: // đang giao
                    sql = SELECT_BY_TRANG_THAI_GIAO_HANG;
                    list = this.selectSql(sql, 2, 1, "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%");
                    break;
                case 2: // chưa giao
                    sql = SELECT_BY_TRANG_THAI_GIAO_HANG;
                    list = this.selectSql(sql, 0, 1, "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%");
                    break;
                case 3: // hóa đơn xóa
                    sql = SELECT_TREO_BI_XOA;
                    list = this.selectSql(sql, 0,
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%",
                            "%" + term + "%");
                    break;
                default:
                    sql = SELECT_ALL1;
            }

            if (list.isEmpty()) {
                return null;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BusHoaDon> getAllHoaDon(String term, int statusHoaDon) {
        List<BusHoaDon> list = this.selectSql(SELECT_ALL, statusHoaDon == 1 ? 0 : 1,
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%",
                "%" + term + "%"
        );
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    public List<BusHoaDon> selectSql(String sql, Object... args) {
        List<BusHoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusHoaDon busHoaDon = this.getResultSet(rs);
                listHoaDon.add(busHoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    BusHoaDon getResultSet(ResultSet rs) throws SQLException {
        BusHoaDon busHoaDon = new BusHoaDon();
        KhachHangModel khachHangModel = new KhachHangModel();
        khachHangModel.setMaKH(rs.getInt("makh"));
        khachHangModel.setTenKH(rs.getString("tenkhach"));
        khachHangModel.setSDT(rs.getString("sdt"));
        NhanVienModel nhanVienModel = new NhanVienModel();
        nhanVienModel.setMaNV(rs.getString("manv"));
        nhanVienModel.setHoTen(rs.getString("tenNhanVien"));
        busHoaDon.setKhachHangModel(khachHangModel);
        busHoaDon.setNhanVienModel(nhanVienModel);
        busHoaDon.setMahd(rs.getInt("mahd"));
        busHoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
        busHoaDon.setNgayTao(rs.getDate("ngaytao"));
        busHoaDon.setSoLuong(rs.getInt("soluong"));
        busHoaDon.setTongTien(rs.getFloat("TongTien"));
        busHoaDon.setTienKhachTra(rs.getFloat("TienKhachTra"));
        busHoaDon.setDiaChiNhanHang(rs.getString("DiaChiNhanHang"));
        busHoaDon.setGhiChu(rs.getString("GhiChu"));
        busHoaDon.setPhiVanChuyen(rs.getFloat("PhiVanChuyen"));
        busHoaDon.setTrangThaiGiaoHang(rs.getInt("TrangThaiGiaoHang"));
        busHoaDon.setTiemKhuyenMai(rs.getFloat("tienKhuyenMai"));
        busHoaDon.setMakm(rs.getInt("makm"));
//        busHoaDon.setTrangThai(rs.getBoolean("TrangThai"));
        return busHoaDon;
    }

    BusHoaDon getResultSetButonHD(ResultSet rs) throws SQLException {
        BusHoaDon busHoaDon = new BusHoaDon();
        KhachHangModel khachHangModel = new KhachHangModel();
        khachHangModel.setMaKH(rs.getInt("makh"));
        NhanVienModel nhanVienModel = new NhanVienModel();
        nhanVienModel.setMaNV(rs.getString("manv"));
        busHoaDon.setKhachHangModel(khachHangModel);
        busHoaDon.setNhanVienModel(nhanVienModel);
        busHoaDon.setMahd(rs.getInt("mahd"));
        busHoaDon.setTongTien(rs.getFloat("TongTien"));
        busHoaDon.setTienKhachTra(rs.getFloat("TienKhachTra"));
        busHoaDon.setDiaChiNhanHang(rs.getString("DiaChiNhanHang"));
        busHoaDon.setGhiChu(rs.getString("GhiChu"));
        busHoaDon.setPhiVanChuyen(rs.getFloat("PhiVanChuyen"));
        busHoaDon.setTiemKhuyenMai(rs.getFloat("tienKhuyenMai"));
        busHoaDon.setMakm(rs.getInt("makm"));
        busHoaDon.setNgayTao(rs.getDate("NgayTao"));
        return busHoaDon;
    }

    public List<BusHoaDon> selectHoaDonTreo() {
        List<BusHoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(SELECT_HOA_DON_TREO);
            while (rs.next()) {
                BusHoaDon busHoaDon = this.getResultSetButonHD(rs);
                listHoaDon.add(busHoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BusHoaDon selectByMahd(Integer mahd, int isRemoved) {
        try {
//            if (this.selectSql(SELECT_BY_MAHD, isRemoved, mahd).isEmpty()) {
//                return null;
//            }
            return this.selectSql(SELECT_BY_MAHD, isRemoved, mahd).get(0);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DalHoaDon selectByID(Integer id) {
        return null;
    }

    @Override
    public List<DalHoaDon> selectAll() {
//        if (this.selectSql(SELECT_ALL) == null) {
        return null;
//        }
//        return this.selectSql(SELECT_ALL);
    }

    @Override
    public List<DalHoaDon> selectBySql(String sql, Object... args) {
        return null;
    }

}
