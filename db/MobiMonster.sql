CREATE DATABASE MOBIMONSTER0
GO
USE MOBIMONSTER0
GO

drop table DiemDanh
CREATE TABLE DiemDanh
(
	MaDiemDanh INT IDENTITY(1,1) NOT NULL,
	MaNV VARCHAR(20) NOT NULL,
	DiemDanh BIT NULL,
	DiMuon Bit default 1 null,
	NgayDiemDanh DATE NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaDiemDanh),
	FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV)
)

GO

CREATE TABLE Luong
(
	MaLuong INT IDENTITY(1,1) NOT NULL,
	LuongHopDong money,
	TongLuong money,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaLuong)
)

GO

CREATE TABLE NhanVien
(
	MaNV VARCHAR(20) NOT NULL,
	MatKhau NVARCHAR(50) NULL,
	HoTen NVARCHAR(50) NULL,
	SDT VARCHAR(15) NULL,
	GioiTinh BIT  NULL,
	NgaySinh DATE NULL,
	DiaChi NVARCHAR(150) NULL,
	VaiTro BIT DEFAULT 0 NULL,
	Hinh NVARCHAR(50) NULL,
	GhiChu NVARCHAR(200) NULL,
	NgayBD DATE NULL,
	NgayKT DATE NULL,
	Email NVARCHAR(100) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	MaLuong INT NULL,
	
	PRIMARY KEY(MaNV),
	FOREIGN KEY(MaLuong) REFERENCES Luong(MaLuong),
	

)

GO
CREATE TABLE KhachHang
(
	MaKH INT IDENTITY(1,1) NOT NULL,
	HoTen NVARCHAR(50) NULL,
	SDT VARCHAR(15)  NULL,
	Email NVARCHAR(100) NULL,
	DiaChi NVARCHAR(50)  NULL,
	GioiTinh BIT NULL,
	NgaySinh DATE  NULL,
	NgayTao DATE DEFAULT GETDATE() NULL,
	GhiChu NVARCHAR(200) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaKH)
)


GO
CREATE TABLE HoaDon(
	MaHD INT IDENTITY(1,1) NOT NULL,
	NgayThanhToan DATE DEFAULT GETDATE() NULL,
	NgayTao DATE DEFAULT GETDATE() NULL,
	TongTien float null, --Tong tien ko co phi ship
	TienKhachTra float null, -- Bao gom phi van chuyen
	MaNV VARCHAR(20) NULL,
	MaKH INT NULL,
	GhiChu nvarchar(225) null,
	PhiVanChuyen float null,
	DiaChiNhanHang nvarchar(225) null,
	NgayShip date null,
	TrangThaiGiaoHang int null, /* 2: Dang giao, 0: Chua giao, 1: GiaoThanhCong*/
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY(MaHD),
	FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
	FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH),
)
GO
CREATE TABLE HangSanPham(
	MaHang INT IDENTITY(1,1) NOT NULL,
	TenHang NVARCHAR(20) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY(MaHang)
	)
GO

CREATE TABLE DongSP(
	MaDong INT IDENTITY(1,1) NOT NULL,
	TenDong NVARCHAR(20) NULL,
	MaHang INT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaDong),
	FOREIGN KEY(MaHang) REFERENCES HangSanPham(MaHang),
)
GO

CREATE TABLE SanPham(
	MaSP INT IDENTITY(1,1) NOT NULL,
	TenSP NVARCHAR(50) NULL,
	MaDong INT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaSP),
	FOREIGN KEY(MaDong) REFERENCES DongSP(MaDong),
)
GO






CREATE TABLE KhuyenMai
(
	MaKM INT IDENTITY(1,1) NOT NULL,
	TenKM NVARCHAR(50) NULL,
	MaVC VARCHAR(20) NULL,
	NgayBD DATE NULL,						
	NgayKT DATE NULL,
	LoaiGG BIT NULL,
	TrangThai BIT NULL,
	MucGG INT NULL, 
	LoaiKM int NULL,
	DKKM int null
	PRIMARY KEY (MaKM)
)

CREATE TABLE loaimagiamgia(
	idloaimagiamgia int primary key,
	tenloaigiamgia nvarchar(50),
)
update loaimagiamgia set idloaimagiamgia = 0 where idloaimagiamgia = 1
insert into loaimagiamgia values(0,'Giảm giá toàn shop')
insert into loaimagiamgia values(1,'Giảm giá theo sản phẩm')
insert into loaimagiamgia values(2,'Giảm giá theo hóa đơn')

GO
CREATE TABLE SanPhamDCSale
(
	MaSPSale INT IDENTITY(1,1) NOT NULL,
	MaSP INT NULL,
	MaKM INT NULL,
	PRIMARY KEY (MaSPSale),
	FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY(MaKM) REFERENCES KhuyenMai(MaKM)
)


GO

CREATE TABLE  Imei
(
	MaImei INT IDENTITY(1,1) NOT NULL,
	MaCTSP INT NULL,
	MaSPSale INT NULL,
	TenImei NVARCHAR(50) NULL,
	GhiChu nvarchar(225) null,
	TrangThaiBan bit default 1 null, -- 0: Da ban 1: chua ban
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaImei),
	FOREIGN KEY(MaCTSP) REFERENCES CTSANPHAM(MaCTSP),
	FOREIGN KEY(MaSPSale) REFERENCES SanPhamDCSale(MaSPSale)

)
GO



CREATE TABLE ChiTietHoaDon(
	MaCTHD INT IDENTITY(1,1) NOT NULL,
	MaHD INT NULL,
	MaImei INT NULL,
	GiaBanSauSale FLOAT  NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY(MaCTHD),
	FOREIGN KEY(MaHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY(MaImei) REFERENCES Imei(MaImei),
)

GO

CREATE TABLE CTSANPHAM (
	MACTSP INT IDENTITY(1,1) NOT NULL,
	GiaNhap FLOAT NULL,
	GiaBan FLOAT NULL,
	NgayNhap DATE DEFAULT GETDATE() NULL,
	SoLuongNhap int null,
	TonKho INT NULL,
	Hinh NVARCHAR(50) NULL,
	MoTa	NVARCHAR(200) NULL,
	MaCamera INT  NULL,
	MaROM INT NULL,
	MaRam INT NULL,
	MaHeDieuHanh INT  NULL,
	MaXuatXu INT  NULL,
	MaPin INT NULL,
	MaManHinh INT  NULL,
	MaCPU INT  NULL,
	MaSP INT NULL,
	MaMau INT NULL,
	MaPhanLoai INT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MACTSP),
	FOREIGN KEY(MaCamera) REFERENCES CameraSP(MaCamera),
	FOREIGN KEY(MaROM) REFERENCES RomSP(MaROM),
	FOREIGN KEY(MaRam) REFERENCES RamSP(MaRam),
	FOREIGN KEY(MaHeDieuHanh) REFERENCES HeDieuHanh(MaHeDieuHanh),
	FOREIGN KEY(MaXuatXu) REFERENCES XuatXu(MaXuatXu),
	FOREIGN KEY(MaPin) REFERENCES Pin(MaPin),
	FOREIGN KEY(MaManHinh) REFERENCES ManHinhSP(MaManHinh),
	FOREIGN KEY(MaCPU) REFERENCES CPU(MaCPU),
	FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY(MaMau) REFERENCES MauSac(MaMau),
	FOREIGN KEY(MaPhanLoai) REFERENCES PhanLoai(MaPhanLoai)
)
GO

CREATE TABLE CameraSP(
	MaCamera INT IDENTITY(1,1) NOT NULL,
	LoaiCamera NVARCHAR(50) NULL,
	DoPhanGiai NVARCHAR(25) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaCamera)
)
GO
CREATE TABLE RomSP(
	MaROM INT IDENTITY(1,1) NOT NULL,
	TenRom NVARCHAR(20) NULL,
	DungLuong FLOAT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaROM)
)

GO
CREATE TABLE RamSP(
	MaRam INT IDENTITY(1,1) NOT NULL,
	LoaiRam NVARCHAR(20) NULL,
	DungLuongRam FLOAT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaRam)
)

GO
CREATE TABLE HeDieuHanh(
	MaHeDieuHanh INT IDENTITY(1,1) NOT NULL,
	TenHeDieuHanh NVARCHAR(25) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaHeDieuHanh)
)
GO
CREATE TABLE XuatXu(
	MaXuatXu INT IDENTITY(1,1) NOT NULL,
	NoiXuatXu NVARCHAR(20) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaXuatXu) 
)
GO

CREATE TABLE Pin(
	MaPin INT IDENTITY(1,1) NOT NULL,
	LoaiPin NVARCHAR (25) NULL,
	DungLuongPin FLOAT NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaPin)
)
GO
CREATE TABLE ManHinhSP(	
	MaManHinh INT IDENTITY(1,1) NOT NULL,
	LoaiManHinh NVARCHAR(50) NULL,
	KichThuoc FLOAT NULL,
	DoPhanGiai NVARCHAR(25)NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaManHinh)
)
GO
CREATE TABLE CPU(
	MaCPU INT IDENTITY(1,1) NOT NULL,
	TenCPU NVARCHAR(50) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaCPU)
)
GO
CREATE TABLE MauSac
(
	MaMau INT IDENTITY(1,1) NOT NULL,
	TenMau NVARCHAR(50) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaMau)
)
GO
CREATE TABLE PhanLoai
(
	MaPhanLoai INT IDENTITY(1,1) NOT NULL,
	Loai NVARCHAR(50) NULL,
	TrangThai BIT DEFAULT 1 NULL,
	PRIMARY KEY (MaPhanLoai)
)
-- trigger c?p nh?t t?n kho
create trigger trg_CapNhatHoaDon on HoaDon after update as
begin
	update CTSANPHAM set TonKho = SoLuongNhap - stock.sl from (select count(mactsp) as sl, MACTSP from inserted inner join ChiTietHoaDon 
	on ChiTietHoaDon.MaHD = inserted.MaHD inner join IMEI on IMEI.MaIMEI = ChiTietHoaDon.MaImei
	where ChiTietHoaDon.TrangThai = 1 and IMEI.TRANGTHAI = 1
	group by MACTSP ) as Stock where CTSANPHAM.MACTSP = Stock.MACTSP

	update CTSANPHAM set TonKho = TonKho + stock.sl from (select count(mactsp) as sl, MACTSP from inserted inner join ChiTietHoaDon 
	on ChiTietHoaDon.MaHD = inserted.MaHD inner join IMEI on IMEI.MaIMEI = ChiTietHoaDon.MaImei
	where ChiTietHoaDon.TrangThai = 0 and IMEI.TRANGTHAI = 1
	group by MACTSP ) as Stock where CTSANPHAM.MACTSP = Stock.MACTSP
end
-- c?p nh?t tr?ng th�i b�n trong imei khi insert v�o chi ti?t h�a ??n
create trigger trg_updateTrangThaiBanTo0 on ChiTietHoaDon after insert as
begin
	update IMEI set TrangThaiBan = 0 from IMEI join inserted on inserted.MaImei = IMEI.MaImei
end
-- c?p nh?t tr?ng th�i trong imei khi tr?ng th�i ? chi ti?t h�a b? x�a
create trigger trg_updateTrangThaiBanTo1 on ChiTietHoaDon after update as
begin
	update IMEI set TrangThaiBan = 1, MaSPSale = null from IMEI join deleted on deleted.MaImei = IMEI.MaImei where deleted.trangThai = 1
	update IMEI set TrangThaiBan = 0 from IMEI join inserted on inserted.MaImei = IMEI.MaImei where inserted.trangThai = 1
end
