package DAL.Services;

import DAL.IServices.IDalMauSacService;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalMauSacModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DalMauSacService implements IPhoneMangementService<DalMauSacModel, Integer>, IDalMauSacService {

    @Override
    public void insert(DalMauSacModel entity) {
        try {
            JDBCHelper.executeUpdate(INSERT,
                    entity.getTenMau(),
                    entity.isTrangThai()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DalMauSacModel entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getTenMau(),
                    entity.isTrangThai(),
                    entity.getMaMau()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public DalMauSacModel selectByID(Integer id) {
        try {
            return this.selectBySql(SELECT_BY_ID,id).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DalMauSacModel> selectTable(int trangThai) {
        try {
            return this.selectBySql(SELECT_ALL, trangThai) == null ? null : this.selectBySql(SELECT_ALL, trangThai);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<DalMauSacModel> selectBySql(String sql, Object... args) {
        List<DalMauSacModel> listMau = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DalMauSacModel mau = new DalMauSacModel();
                mau.setMaMau(rs.getInt("mamau"));
                mau.setTenMau(rs.getString("tenmau"));
                mau.setTrangThai(rs.getBoolean("trangthai"));
                listMau.add(mau);
            }
            rs.getStatement().close();
            return listMau;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<DalMauSacModel> selectAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }
}
