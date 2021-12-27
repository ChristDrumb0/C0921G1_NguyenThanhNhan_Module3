create database oder_management;
use oder_management;
CREATE TABLE don_vi_dh(
    MaDv int PRIMARY KEY,
    TenDV VARCHAR(50),
    DC varchar(100),
    DT VARCHAR(20)
);
CREATE TABLE don_vi_kh(
    MaDvKh int PRIMARY KEY,
    TenDV VARCHAR(50),
    DC varchar(100)
);
CREATE TABLE hang(
    MaH int PRIMARY KEY,
    TenH VARCHAR(50),
    DvTinh varchar(100),
    MoTa varchar(100)
);
CREATE TABLE nguoi_dat(
    MaND int PRIMARY KEY,
    TenND VARCHAR(50)
);	

CREATE TABLE noi_giao(
    MaDDG int PRIMARY KEY,
    TenNoiGiao VARCHAR(50)
);
CREATE TABLE nguoi_nhan(
    MaNN int PRIMARY KEY,
    TenNN VARCHAR(50)
);
CREATE TABLE nguoi_giao(
    MaNG int PRIMARY KEY,
    TenNG VARCHAR(50)
);

