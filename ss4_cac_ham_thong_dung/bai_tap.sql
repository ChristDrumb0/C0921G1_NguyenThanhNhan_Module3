use quanlysinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject`
order by credit desc
limit 1;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sj.subid,subname,credit,`status`,m.mark
from `subject` sj
join mark m on sj.subid = m.subid
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(mark)
from student st
left join mark m on st.studentid = m.studentid
group by st.studentid
ORDER BY mark desc;