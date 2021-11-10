package BUS.IServices;

public interface ISanPhamService {

    String INSERT = "INSERT INTO SanPham(MaSP, TenSP, GiaNhap, GiaBan, SoLuongNhap, TonKho, Hinh, MoTa, MaCamera, MaROM, MaRam, MaDong, MaHeDIeuHanh, MaXuatXu, MaPin, MaManHinh, MaCPU) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM SanPham";
    String SELECT_BY_ID = "SELECT * FROM SanPham WHERE MaSP = ?";
    String UPDATE = "UPDATE SanPham SET TenSP = ?, GiaNhap = ?, GiaBan = ?, SoLuongNhap = ?, TonKho = ?, Hinh = ?,  MoTa = ?, MaCamera = ?, MaROM = ?, MaRam = ?, MaDong = ?, MaHeDIeuHanh = ?, MaXuatXu =?, MaPin = ?, MaManHinh = ?, MaCPU = ? WHERE MaSP = ?";
    String DELETE = "UPDATE SanPham SET TrangThai = 0 WHERE MaSP = ?";
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
            + "CPU ON CPU.MaCPU = CTSANPHAM.MaCPU where TenSP like ?";
}
