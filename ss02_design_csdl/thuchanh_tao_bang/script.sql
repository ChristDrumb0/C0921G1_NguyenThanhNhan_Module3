create database grade_management;
use grade_management;
CREATE TABLE student(
    MaHS VARCHAR(20) PRIMARY KEY,
    TenHS VARCHAR(50),
    NgaySinh DATETIME,
    Lop VARCHAR(20),
    GT VARCHAR(20)
);
CREATE TABLE `subject`(
    MaMH VARCHAR(20) PRIMARY KEY,
    TenMH VARCHAR(50)
);
CREATE TABLE grade_board(
    MaHS VARCHAR(20),
    MaMH VARCHAR(20),
    DiemThi INT,
    NgayKT DATETIME,
    PRIMARY KEY (MaHS, MaMH),
    FOREIGN KEY (MaHS) REFERENCES student(MaHS),
    FOREIGN KEY (MaMH) REFERENCES `subject`(MaMH)
);
CREATE TABLE teacher(
    MaGV VARCHAR(20) PRIMARY KEY,
    TenGV VARCHAR(20),
    SDT VARCHAR(10)
);

alter table `subject` add MaGV varchar (50);
alter table `subject` add constraint FK_maGV foreign key (MaGV) references teacher(MaGV);

