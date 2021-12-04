

CREATE DATABASE QuanLyBanDienThoai
GO
USE QuanLyBanDienThoai
GO

CREATE TABLE HangSanPham(
	MaHang int IDENTITY(1,1) NOT NULL,
	TenHang nvarchar(20) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY(MaHang)
	)
GO
/*
INSERT INTO HangSanPham(TenHang, TrangThai) VALUES (?,?)
SELECT * FROM HangSanPham
SELECT * FROM HangSanPham WHERE TrangThai = 1
SELECT * FROM HangSanPham WHERE MaHang = ?
UPDATE HangSanPham SET TenHang = ?, TrangThai = ? WHERE MaHang = ?
*/
CREATE TABLE DongSP(
	MaDong int IDENTITY(1,1) NOT NULL,
	TenDong nvarchar(20) NOT NULL,
	MaHang int NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaDong),
	FOREIGN KEY(MaHang) REFERENCES HangSanPham(MaHang),
)
/*
INSERT INTO DongSP(TenDong, MaHang, TrangThai) VALUES (?,?,?)
SELECT * FROM DongSP
SELECT * FROM DongSP WHERE TrangThai = 1
SELECT * FROM DongSP WHERE MaDong = ?
SELECT * FROM DongSP WHERE MaHang = ?
UPDATE DongSP SET TenDong = ?, MaHang = ?, TrangThai = ? WHERE MaDong = ?
*/
GO

CREATE TABLE RomSP(
	MaROM int IDENTITY(1,1) NOT NULL,
	TenRom nvarchar(20) NOT NULL,
	DungLuong float not null,
	TrangThai bit default 1,
	PRIMARY KEY (MaROM)
)

GO
/*
INSERT INTO RomSP(TenRom, DungLuong, TrangThai) VALUES (?,?,?)
SELECT * FROM RomSP
SELECT * FROM RomSP WHERE TrangThai = 1
SELECT * FROM RomSP WHERE MaROM = ?
UPDATE RomSP SET TenRom = ?, DungLuong = ?, TrangThai = ? WHERE MaROM = ?
*/

CREATE TABLE CameraSP(
	MaCamera int IDENTITY(1,1) NOT NULL,
	LoaiCamera nvarchar(50) NOT NULL,
	DoPhanGiai nvarchar(25) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaCamera)
)
GO
/*
INSERT INTO CameraSP(LoaiCamera, DoPhanGiai, TrangThai) VALUES (?,?,?)
SELECT * FROM CameraSP
SELECT * FROM CameraSP WHERE TrangThai = 1
SELECT * FROM CameraSP WHERE MaCamera = ?
UPDATE CameraSP SET LoaiCamera = ?, DoPhanGiai = ?, TrangThai = ? WHERE MACA = ?
*/
CREATE TABLE HeDieuHanh(
	MaHeDieuHanh int IDENTITY(1,1) NOT NULL,
	TenHeDieuHanh nvarchar(25) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaHeDieuHanh)
)
GO
/*
INSERT INTO HeDieuHanh(TenHeDieuHanh, TrangThai) VALUES (?,?)
SELECT * FROM HeDieuHanh
SELECT * FROM HeDieuHanh WHERE TrangThai = 1
SELECT * FROM HeDieuHanh WHERE MaHeDieuHanh = ?
UPDATE HeDieuHanh SET TenHeDieuHanh = ?, TrangThai = ? WHERE MaHeDieuHanh = ?
*/
CREATE TABLE ManHinhSP(	
	MaManHinh int IDENTITY(1,1) NOT NULL,
	LoaiManHinh nvarchar(50) NOT NULL,
	KichThuoc float not null,
	DoPhanGiai nvarchar(25) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaManHinh)
)
GO
/*
INSERT INTO ManHinhSP(LoaiManHinh, KichThuoc, DoPhanGiai, TrangThai) VALUES (?,?,?,?)
SELECT * FROM ManHinhSP
SELECT * FROM ManHinhSP WHERE TrangThai = 1
SELECT * FROM ManHinhSP WHERE MaManHinh = ?
UPDATE ManHinhSP SET LoaiManHinh = ?, KichThuoc = ?, DoPhanGiai = ?, TrangThai = ? WHERE MaManHinh = ?
*/
CREATE TABLE RamSP(
	MaRam int IDENTITY(1,1) NOT NULL,
	LoaiRam nvarchar(20) NOT NULL,
	DungLuongRam float not null,
	TrangThai bit default 1,

	PRIMARY KEY (MaRam)
)
GO
/*
INSERT INTO RamSP(LoaiRam, DungLuongRam, TrangThai) VALUES (?,?,?)
SELECT * FROM RamSP
SELECT * FROM RamSP WHERE TrangThai = 1
SELECT * FROM RamSP WHERE MaRam = ?
UPDATE RamSP SET LoaiRam = ?, DungLuongRam = ?, TrangThai = ? WHERE MaRam = ?
*/
CREATE TABLE Pin(
	MaPin int IDENTITY(1,1) NOT NULL,
	LoaiPin nvarchar (25) NOT NULL,
	DungLuongPin float not null,
	TrangThai bit default 1,
	PRIMARY KEY (MaPin)
)
GO
/*
INSERT INTO Pin(LoaiPin, DungLuongPin, TrangThai) VALUES (?,?,?)
SELECT * FROM Pin
SELECT * FROM Pin WHERE TrangThai = 1
SELECT * FROM Pin WHERE MaPin = ?
UPDATE Pin SET LoaiPin = ?, DungLuongPin=?, TrangThai = ? WHERE MaPin = ?
*/
CREATE TABLE CPU(
	MaCPU int IDENTITY(1,1) NOT NULL,
	TenCPU nvarchar(50) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaCPU)
)
GO
/*
INSERT INTO CPU(TenCPU, TrangThai) VALUES (?,?)
SELECT * FROM CPU
SELECT * FROM CPU WHERE TrangThai = 1
SELECT * FROM CPU WHERE MaCPU = ?
UPDATE CPU SET TenCPU =?, TrangThai = ? WHERE MaCPU = ?
*/
CREATE TABLE XuatXu(
	MaXuatXu int IDENTITY(1,1) NOT NULL,
	NoiXuatXu nvarchar(20) NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaXuatXu) 
)
GO
/*
INSERT INTO XuatXu(NoiXuatXu, TrangThai) VALUES (?,?)
SELECT * FROM XuatXu
SELECT * FROM XuatXu WHERE TrangThai = 1
SELECT * FROM XuatXu WHERE MaXuatXu = ?
UPDATE XuatXu SET NoiXuatXu =?, TrangThai = ? WHERE MaXuatXu = ?
*/
CREATE TABLE SanPham(
	MaSP int IDENTITY(1,1) NOT NULL,
	TenSP nvarchar(50) NOT NULL,
	MaDong int,
	TrangThai bit default 1,
	PRIMARY KEY (MaSP),
	FOREIGN KEY(MaDong) REFERENCES DongSP(MaDong),
)
GO
/*
INSERT INTO SanPham(TenSP, MaDong, TrangThai) VALUES (?,?,?)
UPDATE SanPham SET TenSP =?, MaDong = ?, TrangThai = ? WHERE MaSP = ?
*/
CREATE TABLE CTSANPHAM (
	MACTSP int IDENTITY(1,1) NOT NULL,
	NgayNhap date default getDate(),
		GiaBan float  NULL,
	GiaNhap float nULL,
	Hinh nvarchar(50) not null,
		MoTa nvarchar(200) NULL,

	
	TonKho int NOT NULL,
		SoLuongNhap int  NULL,
			TrangThai bit default 1,
	MaCamera int NOT NULL,
	MaROM int NOT NULL,
	MaRam int NOT NULL,
	MaHeDIeuHanh int NOT NULL,
	MaXuatXu int NOT NULL,
	MaPin int NOT NULL,
	MaManHinh int NOT NULL,
	MaCPU int NOT NULL,
	MaSP int not null,
	MaMau int not null,
	MaPhanLoai int not null,
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

/*
select * from CTSANPHAM
SELECT MACTSP, GiaNhap, GiaBan, SoLuongNhap, NgayNhap, TonKho, Hinh, 
MoTa, SanPham.MaSP, TenSP, DongSP.MaDong, TenDong, HangSanPham.MaHang, 
TenHang, CameraSP.MaCamera, LoaiCamera, CameraSP.DoPhanGiai AS DOPHANGIACAM, 
RomSP.MaROM, TenRom, RomSP.DungLuong AS DUNGLUONGROM,  RamSP.MaRam, LoaiRam,
DungLuongRam, HeDieuHanh.MaHeDieuHanh, TenHeDieuHanh, 
XuatXu.MaXuatXu, NoiXuatXu, PIN.MaPin, LoaiPin, DungLuongPin, ManHinhSP.MaManHinh,
LoaiManHinh, ManHinhSP.KichThuoc AS KICKTHUOCMANHINH, ManHinhSP.DoPhanGiai AS DOPHANGIAIMANHINH, CPU.MaCPU, TenCPU
FROM CTSANPHAM JOIN
SanPham ON CTSANPHAM.MaSP = SanPham.MaSP JOIN
DongSP ON DongSP.MaDong = SanPham.MaDong JOIN
HangSanPham ON HangSanPham.MaHang = DongSP.MaHang JOIN
CameraSP ON CameraSP.MaCamera = CTSANPHAM.MaCamera JOIN
RomSP ON RomSP.MaROM = CTSANPHAM.MaROM JOIN
RamSP ON RamSP.MaRam = CTSANPHAM.MaRam JOIN
HeDieuHanh ON CTSANPHAM.MaHeDIeuHanh = HeDieuHanh.MaHeDieuHanh JOIN
XuatXu ON XuatXu.MaXuatXu = CTSANPHAM.MaXuatXu JOIN
Pin ON PIN.MaPin = CTSANPHAM.MaPin JOIN
ManHinhSP ON ManHinhSP.MaManHinh = CTSANPHAM.MaManHinh JOIN 
CPU ON CPU.MaCPU = CTSANPHAM.MaCPU where TenSP like '%%'
*/
GO
CREATE TABLE KhachHang(
	MaKH int IDENTITY(1,1) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	SDT varchar(15)  NULL,
	Email nvarchar(50),
	DiaChi nvarchar(50)  NULL,
	GioiTinh bit NULL,
	NgaySinh date  null,
	NgayTao date default getDate() ,
	GhiChu nvarchar(150),
	TrangThai bit default 1,
	PRIMARY KEY (MaKH)
	)
GO




CREATE TABLE NhanVien(
	MaNV varchar(20) NOT NULL,
	MatKhau NVARCHAR(50) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	SDT varchar(15)  NULL,
	GioiTinh bit  NULL,
	NgaySinh date   NULL,
	DiaChi nvarchar(50),
	VaiTro bit DEFAULT 0,
	Hinh nvarchar(50) NOT NULL,
	GhiChu nvarchar(200),
	NgayBD date,
	NgayKT date,
	Email nvarchar(50),
	TrangThai bit default 1,
	PRIMARY KEY (MaNV)
)
GO

CREATE TABLE HoaDon(
	MaHD int IDENTITY(1,1) NOT NULL,
	NgayBan date default getDate(),
	Loai bit NOT NULL,
	MaNV varchar(20) NOT NULL,
	MaKH int not null,
	MaKM int not null,
	TrangThai bit default 1,
	PRIMARY KEY(MaHD),
	FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
	FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH),
	FOREIGN KEY(MaKM) REFERENCES KhuyenMai(MaKM),
)
GO

CREATE TABLE ChiTietHoaDon(
	MaCTHD int IDENTITY(1,1) NOT NULL,
	MaHD int NOT NULL,
	MaCTSP int not null,
	SoLuong int NOT NULL,
	GiaBan float NOT NULL,
	GiaNhap float NULL,
	TrangThai bit default 1,
	PRIMARY KEY(MaCTHD),
	FOREIGN KEY(MaHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY(MaCTSP) REFERENCES CTSANPHAM(MACTSP)
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
	LoaiKM BIT NULL,
	PRIMARY KEY (MaKM)
)





----PIN
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-Ion',3300,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-po',5000,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES (N'Lithium (thế hệ mới)',3300,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('LiFe',2400,0)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Nicd',6500,0)
select* from Pin
----ManHinh
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('AMOLED',6,'HD',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('IPS Quantum',5.5,'FULL HD+',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('LED-backlit',4.7,'WXGA',0)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('ClearBlack',4.5,'HD',0)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('IPS LCD',6.1,'FULL HD',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('TFT-LCD',5,'FULL HD',0)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('S-LCD',5.2,'QHD',0)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('LCD',5.5,'UHD',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('LTPS LCD',6.4,'FULL HD+',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('OLED',6.7,'QHD+',1)
INSERT INTO [DBO].[ManHinhSP] ([LoaiManHinh],[KichThuoc],[DoPhanGiai],[TrangThai]) VALUES ('PLS LCD',6.5,'FULL HD+',0)
select * from ManHinhSP
----HeDieuHanh
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('IOS',1)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Android',1)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Windows Phone',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Symbian',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('BlackBerry OS',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Bada',0)
select * from HeDieuHanh


DROP DATABASE QLBanDienThoai
DROP TABLE CTSANPHAM
DROP TABLE SanPham
drop table ctsanpham
drop table HoaDon
drop table NhanVien
drop table KhuyenMai

drop database QLBanDienThoai




SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [GiaSP], [SoLuong], [GiaNhap], [TrangThai] )  VALUES (1, 1, N'SP001', 1000,100, 500,0)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [GiaSP], [SoLuong], [GiaNhap], [TrangThai] )  VALUES (2, 2, N'SP002', 2000,100, 600,0)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [GiaSP], [SoLuong], [GiaNhap], [TrangThai] )  VALUES (3, 3, N'SP003', 3000,100, 700,0)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [GiaSP], [SoLuong], [GiaNhap], [TrangThai] )  VALUES (4, 4, N'SP004', 4000,100, 800,0)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [GiaSP], [SoLuong], [GiaNhap], [TrangThai] )  VALUES (5, 5, N'SP005', 5000,100, 900,0)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF

SET IDENTITY_INSERT [dbo].[HangSanPham] ON 

INSERT [dbo].[HangSanPham] ([MaHang], [TenHang]) VALUES (1, N'Nokia')
INSERT [dbo].[HangSanPham] ([MaHang], [TenHang]) VALUES (2, N'Bphone')
INSERT [dbo].[HangSanPham] ([MaHang], [TenHang]) VALUES (3, N'SamSung')
INSERT [dbo].[HangSanPham] ([MaHang], [TenHang]) VALUES (4, N'Xiaomi')
INSERT [dbo].[HangSanPham] ([MaHang], [TenHang]) VALUES (5, N'Iphone')

SET IDENTITY_INSERT [dbo].[HangSanPham] OFF
GO
	MaKM int IDENTITY(1,1) NOT NULL,
	TenKM nvarchar(50) NOT NULL,
	DieuKienKM nvarchar(20) NOT NULL,
	PhanTramKM float not null,
	NgayBD Date default getdate(),
	NgayKT date NOT NULL,
	TrangThai bit default 1,
	PRIMARY KEY (MaKM)

	MaKM INT IDENTITY(1,1) NOT NULL,
	TenKM NVARCHAR(50) NULL,
	MaVC VARCHAR(20) NULL,
	NgayBD DATE NULL,						
	NgayKT DATE NULL,
	LoaiGG BIT NULL,
	TrangThai BIT NULL,
	MucGG INT NULL, 
	LoaiKM BIT NULL,

INSERT [dbo].[KhuyenMai] ([TenKM], [MaVC], [NgayBD], [NgayKT],[LoaiGG], [TrangThai],[MucGG],[LoaiKM])  values('dsdsds','dsdsds','2019/03/12','2020/12/24',1,1,10000,1)

SET IDENTITY_INSERT [dbo].[HoaDon] on
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai], [MaNV], [MaKH], [MaKM], [TrangThai]) VALUES (1, CAST(N'2020-11-10' AS Date), 1,  N'Nam01', 1,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM] ,[TrangThai]) VALUES (2, CAST(N'2020-11-10' AS Date), 1, N'Trong01', 1,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH],[MaKM] ,[TrangThai]) VALUES (3, CAST(N'2020-11-10' AS Date), 1,  N'Cuong01',1,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM],[TrangThai] )VALUES (4, CAST(N'2020-11-10' AS Date), 1, N'Khang01',2,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM],[TrangThai]) VALUES (5, CAST(N'2020-11-10' AS Date), 1, N'Hoan01', 2,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM],[TrangThai]) VALUES (6, CAST(N'2020-11-10' AS Date), 1, N'Hoan01', 3,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM],[TrangThai]) VALUES (7, CAST(N'2020-11-10' AS Date), 1, N'Hoan01', 4,1,1)
INSERT [dbo].[HoaDon] ([MaHD],  [NgayBan], [Loai],  [MaNV], [MaKH], [MaKM],[TrangThai]) VALUES (8, CAST(N'2020-11-10' AS Date), 1, N'Hoan01', 5,1,1)
SET IDENTITY_INSERT [dbo].[HoaDon] off

select * from HoaDon
GO
SET IDENTITY_INSERT [dbo].[KhachHang] On


INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (1,N'Ngô Văn A',N'011226651','ngovana@gmail.com',N'DC01',1,N'2002-10-02',CAST(N'2020-11-10' AS Date),'', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]  ) VALUES (2,N'Ngô Văn B',N'01122665','ngovanb@gmail.com',  N'DC02',1,N'2002-12-08',CAST(N'2020-11-11' AS Date),'aduchat', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (3,N'Ngô Văn C',N'011226653', 'ngovanc@gmail.com', N'DC03',0,N'2002-01-07',CAST(N'2020-11-12' AS Date),'dsds', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (4,N'Ngô Văn D',N'011226654', 'ngovand@gmail.com', N'DC04',0,N'2002-10-06',CAST(N'2020-11-13' AS Date),'m', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (5,N'Ngô Văn F',N'011226655','ngovanf@gmail.com',  N'DC05',1,N'2002-05-05',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (7,N'Ngô Văn E',N'011226655','ngovane@gmail.com',  N'DC06',1,N'1997-05-05',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (8,N'Ngô Văn g',N'011226655','ngovang@gmail.com',  N'DC06',1,N'1987-05-05',CAST(N'2020-11-14' AS Date),'', 0)
SET IDENTITY_INSERT [dbo].[KhachHang] off
GO
select * from KhachHang
	
	select KhachHang.MaKH,KhachHang.HoTen,SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai, Count(MaHD) as SoLanMua from KhachHang
	LEFT JOIN HoaDon On KhachHang.MaKH=HoaDon.MaKH
	Where year(Getdate())-  year(NgaySinh) > 23  and year(Getdate())-  year(Ngaysinh)<  30
	group by KhachHang.MaKH,KhachHang.HoTen,KhachHang.SDT,DiaChi,GioiTinh,NgaySinh,NgayTao,GhiChu,KhachHang.TrangThai

	

	
	
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Nam01', N'123',N'Lê đức nam',N'0966349996', 1,'2002/07/04', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','leducnam209@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Trong01', N'123',N'Phan đức trọng',N'0328250138', 1,'2002/02/13', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','trong123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Cuong01', N'123',N'Nguyễn duy cuong',N'0398250138', 1,'2002/02/15', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','cuong123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Hoan01', N'123',N'Đào ngọc hoan',N'0398250138', 1,'2002/02/16', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','hoan123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Khang01', N'123',N'Trần vĩ khang',N'0398250138', 1,'2002/02/17', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','khang123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Khang02', N'123',N'Trần vĩ khang',N'0398250138', 1,'2002/02/17', N'DC01', 1,'HINH01','adu chat','2020/12/01','2021/12/22','khang123@gmail.com',0)

select * from NhanVien



INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD] ,[TrangThai]) VALUES ( N'Nam01', N'123',N'Lê đức nam',N'0398250138', 0,N'12/02/2002', N'DC01', 0, 'TOT','HINH01',CAST(N'2020-12-11' AS Date),1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD] ,[TrangThai]) VALUES ( N'Trong01', N'123',N'Phan đức trọng',N'0328250138', 0,N'13/02/2002', N'DC02', 0, 'TOT','HINH02',CAST(N'2020-8-12' AS Date),1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD] ,[TrangThai]) VALUES ( N'Cuong01', N'123',N'Nguyễn duy cuong',N'0398250138', 0,N'15/02/2002', N'DC03', 0, 'TOT','HINH03',CAST(N'2020-12-13' AS Date),1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD] ,[TrangThai]) VALUES ( N'Hoan01', N'123',N'Đào ngọc hoan',N'0398250138', 0,N'16/02/2002', N'DC04', 0, 'TOT','HINH04',CAST(N'2020-12-14' AS Date),1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[GhiChu],[Hinh],[NgayBD] ,[TrangThai]) VALUES ( N'Khang01', N'123',N'Trần vĩ khang',N'0398250138', 0,N'17/02/2002', N'DC05', 0, 'TOT','HINH05',CAST(N'2020-12-15' AS Date),1)
GO

/*
INSERT [dbo].[DiaChi] ([MaDiaChi],[DiaChiKH] ,[TrangThai]) VALUES (N'DC01',N'HÀ NỘI',1)
INSERT [dbo].[DiaChi] ([MaDiaChi],[DiaChiKH] ,[TrangThai]) VALUES (N'DC02',N'HÀ NỘI',1)
INSERT [dbo].[DiaChi] ([MaDiaChi],[DiaChiKH] ,[TrangThai]) VALUES (N'DC03',N'HỒ CHÍ MINH',1)
INSERT [dbo].[DiaChi] ([MaDiaChi],[DiaChiKH] ,[TrangThai]) VALUES (N'DC04',N'HÀ NỘI',1)
INSERT [dbo].[DiaChi] ([MaDiaChi],[DiaChiKH] ,[TrangThai]) VALUES (N'DC05',N'ĐÀ NẴNG',1)
*/


INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (N'CPU01',N'CPU Intel P Core i7',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (N'CPU02',N'CPU Intel Core i9',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (N'CPU03',N'CPU AMD Ryzen 7 ',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (N'CPU04',N'CPU Intel P Core i7',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (N'CPU05',N'CPU Intel P Core i7',1) 







INSERT [dbo].[SanPham] ([MaSP], [], [G], [GiaBan], [SoLuong], [MaHang], [MoTa], [NgayNhap], [TrangThai]) VALUES (N'SP014', N'Samsung Galaxy A30s', 0, 6000000, 0, 4, N'Màn hình:Super AMOLED, 6.4", HD+
Hệ điều hành:Android 9 (Pie)', NULL, 1)

GO
select * from ChiTietHoaDon
select * from KhachHang
select * from NhanVien
select * from KhachHang
select * from HoaDon
select * from SanPham

