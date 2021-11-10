package BUS.IServices;

public interface ICTSanPhamService {

    String INSERT = "INSERT INTO CTSANPHAM(GiaNhap, GiaBan, SoLuongNhap, TonKho, Hinh, MoTa, MaCamera,\n"
            + "MaROM, MaRam,MaHeDIeuHanh,MaXuatXu, MaPin,MaManHinh,MaCPU, MaSP) \n"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM CTSANPHAM where trangthai = 0";
    String SELECT_BY_ID = "SELECT MACTSP, GiaNhap, GiaBan, SoLuongNhap, NgayNhap, TonKho, Hinh, \n"
            + "MoTa, SanPham.MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, \n"
            + "TenHang, CameraSP.MaCamera, LoaiCamera, CameraSP.DoPhanGiai AS DOPHANGIACAM, \n"
            + "RomSP.MaROM, TenRom, RomSP.DungLuong AS DUNGLUONGROM,  RamSP.MaRam, LoaiRam,\n"
            + "DungLuongRam, HeDieuHanh.MaHeDieuHanh, TenHeDieuHanh, \n"
            + "XuatXu.MaXuatXu, NoiXuatXu, PIN.MaPin, LoaiPin, DungLuongPin, ManHinhSP.MaManHinh,\n"
            + "LoaiManHinh, ManHinhSP.KichThuoc AS KICKTHUOCMANHINH, ManHinhSP.DoPhanGiai AS DOPHANGIAIMANHINH, CPU.MaCPU, TenCPU\n"
            + "FROM CTSANPHAM JOIN\n"
            + "SanPham ON CTSANPHAM.MaSP = SanPham.MaSP JOIN\n"
            + "DongSP ON DongSP.MaDong = SanPham.MaDong JOIN\n"
            + "HangSanPham ON HangSanPham.MaHang = DongSP.MaHang JOIN\n"
            + "CameraSP ON CameraSP.MaCamera = CTSANPHAM.MaCamera JOIN\n"
            + "RomSP ON RomSP.MaROM = CTSANPHAM.MaROM JOIN\n"
            + "RamSP ON RamSP.MaRam = CTSANPHAM.MaRam JOIN\n"
            + "HeDieuHanh ON CTSANPHAM.MaHeDIeuHanh = HeDieuHanh.MaHeDieuHanh JOIN\n"
            + "XuatXu ON XuatXu.MaXuatXu = CTSANPHAM.MaXuatXu JOIN\n"
            + "Pin ON PIN.MaPin = CTSANPHAM.MaPin JOIN\n"
            + "ManHinhSP ON ManHinhSP.MaManHinh = CTSANPHAM.MaManHinh JOIN \n"
            + "CPU ON CPU.MaCPU = CTSANPHAM.MaCPU where mactsp = ?";
    String UPDATE = "UPDATE CTSANPHAM SET GiaNhap = ?, GiaBan = ?, \n"
            + "SoLuongNhap = ?, TonKho = ?, Hinh = ?,  MoTa = ?,\n"
            + "MaCamera = ?, MaROM = ?, MaRam = ?, MaHeDIeuHanh = ?, \n"
            + "MaXuatXu =?, MaPin = ?, MaManHinh = ?, MaCPU = ?, MaSP = ? WHERE MACTSP = ?";
    String DELETE = "UPDATE CTSANPHAM SET TrangThai = 0 WHERE MACTSP = ?";    
    String SELECT_BY_KEYWORD = "SELECT MACTSP, GiaNhap, GiaBan, SoLuongNhap, NgayNhap, TonKho, Hinh, \n"
            + "MoTa, SanPham.MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, \n"
            + "TenHang, CameraSP.MaCamera, LoaiCamera, CameraSP.DoPhanGiai AS DOPHANGIACAM, \n"
            + "RomSP.MaROM, TenRom, RomSP.DungLuong AS DUNGLUONGROM,  RamSP.MaRam, LoaiRam,\n"
            + "DungLuongRam, HeDieuHanh.MaHeDieuHanh, TenHeDieuHanh, \n"
            + "XuatXu.MaXuatXu, NoiXuatXu, PIN.MaPin, LoaiPin, DungLuongPin, ManHinhSP.MaManHinh,\n"
            + "LoaiManHinh, ManHinhSP.KichThuoc AS KICKTHUOCMANHINH, ManHinhSP.DoPhanGiai AS DOPHANGIAIMANHINH, CPU.MaCPU, TenCPU\n"
            + "FROM CTSANPHAM JOIN\n"
            + "SanPham ON CTSANPHAM.MaSP = SanPham.MaSP JOIN\n"
            + "DongSP ON DongSP.MaDong = SanPham.MaDong JOIN\n"
            + "HangSanPham ON HangSanPham.MaHang = DongSP.MaHang JOIN\n"
            + "CameraSP ON CameraSP.MaCamera = CTSANPHAM.MaCamera JOIN\n"
            + "RomSP ON RomSP.MaROM = CTSANPHAM.MaROM JOIN\n"
            + "RamSP ON RamSP.MaRam = CTSANPHAM.MaRam JOIN\n"
            + "HeDieuHanh ON CTSANPHAM.MaHeDIeuHanh = HeDieuHanh.MaHeDieuHanh JOIN\n"
            + "XuatXu ON XuatXu.MaXuatXu = CTSANPHAM.MaXuatXu JOIN\n"
            + "Pin ON PIN.MaPin = CTSANPHAM.MaPin JOIN\n"
            + "ManHinhSP ON ManHinhSP.MaManHinh = CTSANPHAM.MaManHinh JOIN \n"
            + "CPU ON CPU.MaCPU = CTSANPHAM.MaCPU where CTSANPHAM.TrangThai = 1 AND TenSP like ?";
}
