-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
USE QuanLySinhVien;
SELECT* FROM student
WHERE studentname LIKE 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
USE QuanLySinhVien;
SELECT* FROM class
WHERE month(startdate) = 12;  

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
USE QuanLySinhVien;
SELECT* FROM `subject`
WHERE credit >= 3 AND credit <= 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
USE QuanLySinhVien;
SET SQL_SAFE_UPDATES = 0;
UPDATE student
SET classid = 2
WHERE studentname = 'Hung';
SELECT* FROM student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần.
--  nếu trùng sắp theo tên tăng dần.
USE QuanLySinhVien;
SELECT S.studentname , Subj.subname,M.mark
FROM student S 
JOIN mark M on S.studentid = M.studentid
JOIN `subject` Subj on M.subid = Subj.subid
ORDER BY mark DESC ,studentname ASC;
