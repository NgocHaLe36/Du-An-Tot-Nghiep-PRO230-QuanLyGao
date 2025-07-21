/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  lengh
 * Created: Jul 4, 2025
 */
-- ==========================================
CREATE DATABASE QuanLyGao;
GO
USE QuanLyGao;
GO
-- ==========================================
CREATE TABLE Users (
    Username NVARCHAR(50) PRIMARY KEY,
    Password NVARCHAR(50),
    Enabled BIT,
    Fullname NVARCHAR(100),
    Manager BIT
);

INSERT INTO Users(Username, Password, Enabled, Fullname, Manager) VALUES
('baonpts02017','789',1,N'Nguyyễn Phước Bảo',0),
('halnts02076','1234',1,N'Lê Ngọc Hà',1),
('khoivmts02197','456789',0,N'Lê Vũ Minh Khôi',0),
('linhnt02067','111111',1,N'Nguyễn Thị Linh',0),
('thaolntts02067','98765',1,N'Nguyễn Lê Thanh Thảo',0),
('truongpt02067','222222',1,N'Phạm Thành Trương',0);

-- ==========================================
-- B?ng LoaiGao (5 lo?i)
-- ==========================================
CREATE TABLE LoaiGao (
    MaLoai NVARCHAR PRIMARY KEY,
    TenLoai NVARCHAR(100)
);

INSERT INTO LoaiGao(MaLoai, TenLoai) VALUES
(1, N'Gạo Tẻ'),
(2, N'Gạo Nếp'),
(3, N'Gạo Lứt'),
(4, N'Gạo Nhật'),
(5, N'Nếp Than');

-- ==========================================
-- B?ng Gao (10 lo?i)
-- ==========================================
CREATE TABLE Gao (
    MaGao INT PRIMARY KEY,
    TenGao NVARCHAR(100),
    XuatXu NVARCHAR(100),
    Gia FLOAT,
    DonViTinh NVARCHAR(20),
    SoLuongTon INT,
    MaLoai INT FOREIGN KEY REFERENCES LoaiGao(MaLoai)
);

INSERT INTO Gao(MaGao, TenGao, XuatXu, Gia, DonViTinh, SoLuongTon, MaLoai) VALUES
(1, N'G?o ST25', N'Sóc Trăng', 25000, N'Kg', 100, 1),
(2, N'G?o Hương Lài', N'Đồng Tháp', 18000, N'Kg', 50, 2),
(3, N'G?o Tám Thơm', N'Hà Nội', 14000, N'Kg', 75, 1),
(4, N'G?o ST24', N'Sóc Trăng', 24000, N'Kg', 80, 3),
(5, N'G?o Nàng Hương', N'An Giang', 20000, N'Kg', 60, 2),
(6, N'G?o L?t Đ?', N'Long An', 30000, N'Kg', 40, 3),
(7, N'G?o Nh?t', N'Nhật Bản', 50000, N'Kg', 30, 4),
(8, N'N?p Than', N'Lào Cai', 35000, N'Kg', 20, 5),
(9, N'G?o Hương Lài ĐB', N'Đồng Tháp', 21000, N'Kg', 90, 2),
(10,N'G?o Thơm ĐB', N'Tiền Giang', 27000, N'Kg', 70, 3);

-- ==========================================
-- B?ng Cards (30 th?)
-- ==========================================
CREATE TABLE Cards (
    Id INT PRIMARY KEY,
    Status INT
);

INSERT INTO Cards(Id, Status) VALUES
(1,0),(2,1),(3,2),(4,0),(5,1),(6,2),(7,0),(8,1),(9,2),(10,0),
(11,1),(12,2),(13,0),(14,1),(15,2),(16,0),(17,1),(18,2),(19,0),(20,1),
(21,2),(22,0),(23,1),(24,2),(25,0),(26,1),(27,2),(28,0),(29,1),(30,2);

-- ==========================================
-- B?ng HoaDon
-- ==========================================
CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY,
    Username NVARCHAR(50) FOREIGN KEY REFERENCES Users(Username),
    ThoiGianVao DATETIME,
    ThoiGianRa DATETIME,
    TrangThai INT,
    CardId INT FOREIGN KEY REFERENCES Cards(Id)
);

INSERT INTO HoaDon(MaHD, Username, ThoiGianVao, ThoiGianRa, TrangThai, CardId) VALUES
(1,'baonpts02017','2025-07-04 10:00:00','2025-07-04 10:30:00',0,1),
(2,'halnts02076','2025-07-04 11:00:00','2025-07-04 11:45:00',1,2),
(3,'khoivmts02197','2025-07-04 12:00:00','2025-07-04 12:30:00',2,3),
(4,'linhnt02067','2025-07-04 13:00:00','2025-07-04 13:20:00',0,4),
(5,'thaolntts02067','2025-07-04 14:00:00','2025-07-04 14:50:00',1,5),
(6,'truongpt02067','2025-07-04 15:00:00','2025-07-04 15:30:00',2,6),
(7,'halnts02076','2025-07-04 16:00:00','2025-07-04 16:25:00',0,7),
(8,'baonpts02017','2025-07-04 17:00:00','2025-07-04 17:40:00',1,8),
(9,'linhnt02067','2025-07-04 18:00:00','2025-07-04 18:20:00',2,9),
(10,'thaolntts02067','2025-07-04 19:00:00','2025-07-04 19:50:00',0,10);

-- ==========================================
-- B?ng ChiTietHoaDon
-- ==========================================
CREATE TABLE ChiTietHoaDon (
    MaCT INT PRIMARY KEY,
    MaHD INT FOREIGN KEY REFERENCES HoaDon(MaHD),
    MaGao INT FOREIGN KEY REFERENCES Gao(MaGao),
    DonGia FLOAT,
    GiamGia FLOAT,
    SoLuong INT
);

INSERT INTO ChiTietHoaDon(MaCT, MaHD, MaGao, DonGia, GiamGia, SoLuong) VALUES
(1,1,1,25000,0,2),
(2,1,2,18000,500,1),
(3,2,3,14000,0,3),
(4,3,4,24000,1000,2),
(5,4,5,20000,0,4),
(6,5,6,30000,500,1),
(7,6,7,50000,0,2),
(8,7,8,35000,1000,3),
(9,8,9,21000,0,1),
(10,9,10,27000,500,2);

-- ==========================================
-- Tạo bảng KhachHang
-- ==========================================
CREATE TABLE KhachHang (
    MaKH INT PRIMARY KEY,
    HoTen NVARCHAR(100),
    SoDT VARCHAR(20),
    DiaChi NVARCHAR(200),
    Email VARCHAR(100),
    NgayDangKy DATE
);

INSERT INTO KhachHang(MaKH, HoTen, SoDT, DiaChi, Email, NgayDangKy) VALUES
(1, N'Nguyễn Văn An', '0901122334', N'Hà Nội', 'an@gmail.com', '2025-06-01'),
(2, N'Trần Thị Bình', '0911222333', N'Đà Nẵng', 'binh@gmail.com', '2025-06-05'),
(3, N'Lê Quốc Cường', '0922333444', N'HCM', 'cuong@gmail.com', '2025-06-10'),
(4, N'Phạm Thị Dung', '0933444555', N'Hải Phòng', 'dung@gmail.com', '2025-06-12'),
(5, N'Hồ Văn Em', '0944555666', N'Đắk Lắk', 'em@gmail.com', '2025-06-15'),
(6, N'Võ Thị Hoa', '0955666777', N'Bình Dương', 'hoa@gmail.com', '2025-06-18'),
(7, N'Đặng Minh Hùng', '0966777888', N'Cần Thơ', 'hung@gmail.com', '2025-06-20'),
(8, N'Trương Thanh Ích', '0977888999', N'Lâm Đồng', 'ich@gmail.com', '2025-06-22'),
(9, N'Ngô Văn Khoa', '0988999000', N'Nghệ An', 'khoa@gmail.com', '2025-06-25'),
(10, N'Bùi Thị Lan', '0999000111', N'Nam Định', 'lan@gmail.com', '2025-06-28');

-- ==========================================
-- Tạo bảng NhaCungCap
-- ==========================================
CREATE TABLE NhaCungCap (
    MaNCC INT PRIMARY KEY,
    TenNCC NVARCHAR(100),
    DiaChi NVARCHAR(200),
    SoDT VARCHAR(20),
    Email VARCHAR(100)
);

INSERT INTO NhaCungCap(MaNCC, TenNCC, DiaChi, SoDT, Email) VALUES
(1, N'Cty Gạo Sạch', N'Hà Nội', '0241234567', 'sach@gmail.com'),
(2, N'Gạo Miền Tây', N'Cần Thơ', '0292388888', 'mt@gmail.com'),
(3, N'Gạo Miền tây', N'Sóc Trăng', '0292666777', 'al@gmail.com'),
(4, N'Lúa Vàng', N'Đồng Tháp', '0272444555', 'lv@gmail.com'),
(5, N'Nhật Bản Import', N'HCM', '0282777333', 'nb@gmail.com'),
(6, N'VinaGao', N'Long An', '0272777888', 'vg@gmail.com'),
(7, N'Thanh Thanh', N'Bình Định', '0255666999', 'tt@gmail.com'),
(8, N'Gạo Sạch Lào Cai', N'Lào Cai', '0214666111', 'lc@gmail.com'),
(9, N'Gạo Organic', N'Lâm Đồng', '0263333444', 'go@gmail.com'),
(10, N'Quốc Tế Rice', N'Đà Nẵng', '0236777555', 'qt@gmail.com');

-- ==========================================
-- Tạo bảng PhieuNhap
-- ==========================================
CREATE TABLE PhieuNhap (
    MaPN INT PRIMARY KEY,
    NgayNhap DATE,
    MaNCC INT FOREIGN KEY REFERENCES NhaCungCap(MaNCC),
    GhiChu NVARCHAR(200),
    MaGao INT FOREIGN KEY REFERENCES Gao(MaGao),
    SoLuong INT,
    DonGiaNhap FLOAT
);

INSERT INTO PhieuNhap(MaPN, NgayNhap, MaNCC, GhiChu, MaGao, SoLuong, DonGiaNhap) VALUES
(1, '2025-06-30', 1, N'Nhập ST25', 1, 200, 23000),
(2, '2025-07-01', 2, N'Nhập Hương Lài', 2, 150, 17000),
(3, '2025-07-01', 3, N'Nhập Tám Thơm', 3, 180, 13000),
(4, '2025-07-02', 4, N'Nhập ST24', 4, 100, 22000),
(5, '2025-07-02', 5, N'Nhập Nàng Hương', 5, 90, 19000),
(6, '2025-07-03', 6, N'Nhập Lứt Đỏ', 6, 120, 28000),
(7, '2025-07-03', 7, N'Nhập Nhật', 7, 70, 48000),
(8, '2025-07-03', 8, N'Nhập Nếp Than', 8, 60, 33000),
(9, '2025-07-04', 9, N'Nhập Hương Lài ĐB', 9, 110, 20000),
(10,'2025-07-04',10,N'Nhập Thơm ĐB', 10, 130, 25000);

