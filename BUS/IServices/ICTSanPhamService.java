package BUS.IServices;

public interface ICTSanPhamService {

    String INSERT = "INSERT INTO CTSANPHAM(GiaNhap, GiaBan, SoLuongNhap, TonKho, Hinh, MoTa, MaCamera,\n"
            + "MaROM, MaRam,MaHeDIeuHanh,MaXuatXu, MaPin,MaManHinh,MaCPU, MaSP, MaMau, MaPhanLoai) \n"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM CTSANPHAM where trangthai = 0";
    String SELECT_BY_ID = "SELECT MACTSP, GiaNhap, GiaBan,SoLuongNhap, NgayNhap, TonKho, Hinh,  \n"
            + "             MoTa, SanPham.MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang,  \n"
            + "             TenHang, CameraSP.MaCamera, LoaiCamera, CameraSP.DoPhanGiai AS DOPHANGIACAM,  \n"
            + "             RomSP.MaROM, TenRom, RomSP.DungLuong AS DUNGLUONGROM,  RamSP.MaRam, LoaiRam, \n"
            + "             DungLuongRam, HeDieuHanh.MaHeDieuHanh, TenHeDieuHanh,  \n"
            + "             XuatXu.MaXuatXu, NoiXuatXu, PIN.MaPin, LoaiPin, DungLuongPin, ManHinhSP.MaManHinh, \n"
            + "             LoaiManHinh, ManHinhSP.KichThuoc AS KICKTHUOCMANHINH, ManHinhSP.DoPhanGiai AS DOPHANGIAIMANHINH, CPU.MaCPU, TenCPU, \n"
            + "			 MauSac.MaMau, TenMau, PhanLoai.MaPhanLoai, Loai\n"
            + "             FROM CTSANPHAM JOIN \n"
            + "             SanPham ON CTSANPHAM.MaSP = SanPham.MaSP JOIN \n"
            + "             DongSP ON DongSP.MaDong = SanPham.MaDong JOIN \n"
            + "             HangSanPham ON HangSanPham.MaHang = DongSP.MaHang JOIN \n"
            + "             CameraSP ON CameraSP.MaCamera = CTSANPHAM.MaCamera JOIN \n"
            + "             RomSP ON RomSP.MaROM = CTSANPHAM.MaROM JOIN \n"
            + "             RamSP ON RamSP.MaRam = CTSANPHAM.MaRam JOIN \n"
            + "             HeDieuHanh ON CTSANPHAM.MaHeDIeuHanh = HeDieuHanh.MaHeDieuHanh JOIN \n"
            + "             XuatXu ON XuatXu.MaXuatXu = CTSANPHAM.MaXuatXu JOIN \n"
            + "             Pin ON PIN.MaPin = CTSANPHAM.MaPin JOIN \n"
            + "             ManHinhSP ON ManHinhSP.MaManHinh = CTSANPHAM.MaManHinh JOIN  \n"
            + "             CPU ON CPU.MaCPU = CTSANPHAM.MaCPU join\n"
            + "			 MauSac on CTSANPHAM.MaMau = MauSac.MaMau join\n"
            + "			 PhanLoai on CTSANPHAM.MaPhanLoai = PhanLoai.MaPhanLoai where MACTSP = ?";
    String UPDATE = "UPDATE CTSANPHAM SET GiaNhap = ?, GiaBan = ?, \n"
            + "SoLuongNhap = ?, TonKho = ?, Hinh = ?,  MoTa = ?,\n"
            + "MaCamera = ?, MaROM = ?, MaRam = ?, MaHeDIeuHanh = ?, \n"
            + "MaXuatXu =?, MaPin = ?, MaManHinh = ?, MaCPU = ?, MaSP = ?,MaMau = ?, MaPhanLoai = ? WHERE MACTSP = ?";
    String DELETE = "UPDATE CTSANPHAM SET TrangThai = 0 WHERE MACTSP = ?";
    String BACKUP = "UPDATE CTSANPHAM SET TrangThai = 1 WHERE MACTSP = ?";
    String SELECT_BY_KEYWORD = "SELECT MACTSP, GiaNhap, GiaBan,SoLuongNhap, NgayNhap, TonKho, Hinh,  \n"
            + "             MoTa, SanPham.MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang,  \n"
            + "             TenHang, CameraSP.MaCamera, LoaiCamera, CameraSP.DoPhanGiai AS DOPHANGIACAM,  \n"
            + "             RomSP.MaROM, TenRom, RomSP.DungLuong AS DUNGLUONGROM,  RamSP.MaRam, LoaiRam, \n"
            + "             DungLuongRam, HeDieuHanh.MaHeDieuHanh, TenHeDieuHanh,  \n"
            + "             XuatXu.MaXuatXu, NoiXuatXu, PIN.MaPin, LoaiPin, DungLuongPin, ManHinhSP.MaManHinh, \n"
            + "             LoaiManHinh, ManHinhSP.KichThuoc AS KICKTHUOCMANHINH, ManHinhSP.DoPhanGiai AS DOPHANGIAIMANHINH, CPU.MaCPU, TenCPU, \n"
            + "			 MauSac.MaMau, TenMau, PhanLoai.MaPhanLoai, Loai\n"
            + "             FROM CTSANPHAM JOIN \n"
            + "             SanPham ON CTSANPHAM.MaSP = SanPham.MaSP JOIN \n"
            + "             DongSP ON DongSP.MaDong = SanPham.MaDong JOIN \n"
            + "             HangSanPham ON HangSanPham.MaHang = DongSP.MaHang JOIN \n"
            + "             CameraSP ON CameraSP.MaCamera = CTSANPHAM.MaCamera JOIN \n"
            + "             RomSP ON RomSP.MaROM = CTSANPHAM.MaROM JOIN \n"
            + "             RamSP ON RamSP.MaRam = CTSANPHAM.MaRam JOIN \n"
            + "             HeDieuHanh ON CTSANPHAM.MaHeDIeuHanh = HeDieuHanh.MaHeDieuHanh JOIN \n"
            + "             XuatXu ON XuatXu.MaXuatXu = CTSANPHAM.MaXuatXu JOIN \n"
            + "             Pin ON PIN.MaPin = CTSANPHAM.MaPin JOIN \n"
            + "             ManHinhSP ON ManHinhSP.MaManHinh = CTSANPHAM.MaManHinh JOIN  \n"
            + "             CPU ON CPU.MaCPU = CTSANPHAM.MaCPU join\n"
            + "			 MauSac on CTSANPHAM.MaMau = MauSac.MaMau join\n"
            + "			 PhanLoai on CTSANPHAM.MaPhanLoai = PhanLoai.MaPhanLoai\n"
            + "			 where CTSANPHAM.TrangThai = ? AND CTSANPHAM.TonKho >= ? \n"
            + "			and (TenSP like ? or TenDong like ? or LoaiCamera like ? or TenRom like ? or LoaiRam like ? or LoaiManHinh like ? \n"
            + "			or LoaiPin like ? or TenCPU like ? or noixuatxu like ? or TenHeDieuHanh like ? or TenMau like ? or Loai like ?)";
    String UPDATE_STOCK = "update CTSANPHAM set TonKho = ? where MACTSP = ?";

    String LAST_ID = "SELECT Max(MACTSP) as LastID FROM CTSANPHAM";
    String SELECT_SP_BY_HOADON = "select TenSP, GiaBan, Hinh, CTSANPHAM.MACTSP, sum(GiabanSauSale) as tongTien, ctsanpham.mactsp as sl\n"
            + "from ChiTietHoaDon join \n"
            + "imei on Imei.maimei = chitiethoadon.maimei join ctsanpham\n"
            + "on ctsanpham.mactsp = imei.mactsp join SanPham\n"
            + "on SanPham.MaSP = CTSANPHAM.MaSP\n"
            + "where mahd = ? and ChiTietHoaDon.trangthai = 1\n"
            + "Group by TenSP, GiaBan, Hinh, CTSANPHAM.MACTSP";
}
