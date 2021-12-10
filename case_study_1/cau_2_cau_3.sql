
-- cau 2
select *
from furama_management.nhan_vien
where (ho_ten_nhan_vien like 'T%' or ho_ten_nhan_vien like 'K%' or ho_ten_nhan_vien like 'H%')and  length(ho_ten_nhan_vien) <20;

-- cau 3
select *
from furama_management.khach_hang
where (year(ngay_sinh) between 1971 and 2003)
and (dia_chi like '%đà nẵng%' or dia_chi like '%quảng trị%');

