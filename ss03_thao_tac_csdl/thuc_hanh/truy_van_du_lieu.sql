#Hiển thị danh sách tất cả học viên
USE QuanLySinhVien;
SELECT *
FROM Student;

#Hiển thị danh sách học viên đang theo học
USE QuanLySinhVien;
SELECT *
FROM Student
WHERE Status = true;

#Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
USE QuanLySinhVien;
SELECT *
FROM Subject
WHERE Credit < 10;

#Hiển thị danh sách học viên lớp A1
USE QuanLySinhVien;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

#Hiển thị điểm môn CF của các học viên.
USE QuanLySinhVien;
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';