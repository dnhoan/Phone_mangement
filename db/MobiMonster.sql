CREATE DATABASE MOBIMONSTER
GO
USE MOBIMONSTER
GO
drop database MOBIMONSTER

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
	PRIMARY KEY(MaNV),
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
select * from ChiTietHoaDon
select * from Imei
select * from CTSANPHAM
select * from HoaDon
update HoaDon set NgayTao = '12-2-2021', NgayThanhToan = '12-2-2021' where MaHD = 22
alter table ChiTietHoaDon add GiaBan float null
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
	LoaiRom NVARCHAR(20) NULL,
	DungLuongRom FLOAT NULL,
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
select * from CTSANPHAM
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
update CTSANPHAM set TonKho = SoLuongNhap - stock.sl from 
(select count(mactsp) as sl, mactsp from imei where Imei.MaCTSP = ? and Imei.TrangThaiBan = 0 group by mactsp) as stock
where stock.mactsp = CTSANPHAM.MACTSP
select count(mactsp) as sl, mactsp from imei where Imei.MaCTSP = 1 and Imei.TrangThaiBan = 0 group by mactsp
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






INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Nam01', N'abcdef',N'Lê đức nam',N'0966349996', 1,'1992/07/04', N'Hà Nội city', 1,'','','2020/12/01','2021/12/22','leducnam209@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Trong01', N'123456',N'Phan đức trọng',N'0328250138', 1,'2002/02/13', N'Hồ chí Minh', 1,'','','2020/12/01','2021/12/22','trong123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Cuong01', N'678910',N'Nguyễn duy cuong',N'0398250138', 1,'1995/02/15', N'Hải phòng', 1,'','','2020/12/01','2021/12/22','cuong123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Hoan01', N'hoan01',N'Đào ngọc hoan',N'0398250138', 1,'1993/02/16', N'Nam Định', 1,'','','2020/12/01','2021/12/22','hoan123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Khang01', N'khang1234',N'Trần vĩ khang',N'0398250138', 1,'1860/02/17', N'Quản Ninh', 1,'','','2020/12/01','2021/12/22','khang123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Kha01', N'kh9832',N'Trần vĩ kha',N'0398250138', 1,'2000/01/11', N'Nam Từ Liêm Hà Nội', 1,'','','2020/12/01','2021/12/22','khang123@gmail.com',0)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Kh01', N'395302',N'Trần vĩ kh',N'0398250138', 1,'1990/02/12', N'Thái Bình', 1,'','','2020/12/01','2021/12/22','khang123@gmail.com',0)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'Khang02', N'nvmxndf',N'Trần vi khang',N'0398250138', 1,'2002/02/13', N'Cầu Giấy Hà Nội', 1,'','','2020/12/01','2021/12/22','kha123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'trong02', N'trongvcv',N'Trần vĩ trong',N'0398250138', 1,'1980/02/14', N'Đà Nẵng', 1,'','','2020/12/01','2021/12/22','kha123@gmail.com',1)
INSERT [dbo].[NhanVien] ([MaNV],[MatKhau], [HoTen],[SDT] , [GioiTinh], [NgaySinh],[DiaChi], [VaiTro],[Hinh],[GhiChu],[NgayBD],[NgayKT],[Email],[TrangThai]) VALUES ( N'hoan02', N'26052002',N'Trần vĩ hoan',N'0398250138', 1,'2002/02/15', N'Quận Đống Đa Hà Nội', 1,'','','2020/12/01','2021/12/22','hoanam2k2.tb@gmail.com',1)

select * from NhanVien



INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (1,N'Ngô Văn Dũng',N'011226651','ngovana@gmail.com',N'Hà Nội',1,N'2002-10-02',CAST(N'2020-11-10' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]  ) VALUES (2,N'Phan đức trọng',N'01122665','ngovanb@gmail.com',  N'Thài Bình',1,N'2002-12-08',CAST(N'2020-11-11' AS Date),'aduchat', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (3,N'trần vĩ khang',N'011226653', 'ngovanc@gmail.com', N'Hà Nội',0,N'2002-01-07',CAST(N'2020-11-12' AS Date),'dsds', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (4,N'trần quyết chiến',N'011226654', 'ngovand@gmail.com', N'Thái Bình',0,N'2002-10-06',CAST(N'2020-11-13' AS Date),'m', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (5,N'lê đức nam',N'011226655','ngovanf@gmail.com',  N'Hà Nội',1,N'2002-05-01',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (6,N'phạm quốc huy',N'011226655','ngovane@gmail.com',  N'Nam Định',1,N'1997-05-02',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (7,N'trần quốc trường',N'011226655','ngovang@gmail.com',  N'TP Hồ Chí Minh',1,N'1989-05-03',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (8,N'Hồ thị mai',N'011226655','ngovang@gmail.com',  N'Ninh Bình',1,N'1982-05-04',CAST(N'2020-11-14' AS Date),'', 0)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (9,N'lê văn đức',N'011226655','ngovang@gmail.com',  N'Cầu Giấy Hà Nội',1,N'1982-05-05',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (10,N'ngô kiến huy',N'011226655','ngovang@gmail.com',  N'Ba Vì',1,N'1987-05-06',CAST(N'2020-11-14' AS Date),'', 1)
INSERT [dbo].[KhachHang] ( [MaKH],[HoTen], [SDT],[Email],[DiaChi],[GioiTinh], [NgaySinh],[NgayTao],[GhiChu],[TrangThai]) VALUES (11,N'trần như quỳnh',N'011226655','ngovang@gmail.com',  N'Bắc Giang',1,N'1987-05-07',CAST(N'2020-11-14' AS Date),'', 0)

delete from khachhang

select * from KhachHang
SET IDENTITY_INSERT [dbo].[Pin] On

INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (1,N'CPU Intel P Core i7',0) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (2,N'CPU In Core i9',0) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (3,N'CPU AMD Ryzen 7 ',0) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (4,N'CPU Intel P Core i7',0) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (5,N'CPU Intel P Core i9',0) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (5,N'Exynos 2100 8 nhân',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (6,N'Apple A15 Bionic 6 nhân',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (7,N'MediaTek Dimensity 700 5G 8 nhân',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (8,N'Snapdragon 865 8 nhân',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (9,N'Snapdragon 720G 8 nhân',1) 
INSERT [dbo].[CPU] ([MaCPU],[TenCPU] ,[TrangThai]) VALUES (10,N'Apple A13 Bionic 6 nhân',1) 
SET IDENTITY_INSERT [dbo].[CPU] Off
select * from CPU

INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-Ion',3300,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-po',5000,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES (N'Lithium (thế hệ mới)',3300,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('LiFe',2400,0)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Pin 3 cell',6500,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Pin 6 cell',6500,0)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-Ion',3110,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-Ion',10090,0)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Nicd',6500,1)
INSERT INTO [DBO].[Pin] ([LoaiPin],[DungLuongPin],[TrangThai]) VALUES ('Li-po',6500,0)

select * from pin

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


INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('IOS',1)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Android',1)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Windows Phone',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Symbian',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('BlackBerry OS',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Bada',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Firefox OS',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Windows',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Ubuntu',0)
INSERT INTO [DBO].[HeDieuHanh] ([TenHeDieuHanh],[TrangThai]) VALUES ('Bada',0)
select * from HeDieuHanh



INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'TRUNG QUỐC',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'NGA',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'MỸ',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'ANH',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'VIỆT NAM',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'ĐỨC',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'ITALY',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'NHẬT BẢN',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'HÀN QUỐC',1)
INSERT INTO [DBO].[XuatXu] ([NoiXuatXu],[TrangThai]) VALUES(N'THÁI LAN',1)


INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM01',2,1)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM02',4,1)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM03',8,1)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM04',16,1)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM05',32,1)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM06',64,0)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM07',512,0)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM08',3,0)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM09',1.5,0)
INSERT INTO [DBO].[RamSP] ([LoaiRam],[DungLuongRam],[TrangThai]) VALUES(N'RAM10',10,1)
select * from RomSP
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM03',256,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM02',512,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM03',32,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM04',16,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM05',64,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM06',128,1)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM07',256,0)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM08',32,0)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM09',64,0)
INSERT INTO [DBO].[RomSP] ([LoaiRom],[DungLuongRom],[TrangThai]) VALUES(N'ROM10',16,0)

INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAMERA KÉP',N'20MP',1)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAMERA ĐƠN',N'20MP',1)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAMERA DỌC',N'32MP',1)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAMERA NGANG',N'16MP',1)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAMERA VUÔNG',N'48MP',1)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAM KÉP',N'32MP',0)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAM VUÔNG',N'16MP',0)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAM NGANG',N'32MP',0)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAM KÉP',N'16MP',0)
INSERT INTO [DBO].[CameraSP] ([LoaiCamera],[DoPhanGiai],[TrangThai]) VALUES(N'CAM KÉP',N'48MP',0)

INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'XANH',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'ĐỎ',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'TÍM',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'VÀNG',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'HỒNG',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'ĐEN NHÁM',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'XANH NGỌC',0)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'TÍM',0)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'TRẮNG',1)
INSERT INTO [DBO].[MauSac] ([TenMau],[TrangThai]) VALUES(N'NÂU',0)





