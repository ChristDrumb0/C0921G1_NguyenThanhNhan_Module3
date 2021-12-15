
-- cau 2
select *
from furama_management.nhan_vien
where (ho_ten_nhan_vien like 'T%' or ho_ten_nhan_vien like 'K%' or ho_ten_nhan_vien like 'H%')and  char_length(ho_ten_nhan_vien) <20;

-- cau 3
select *
from furama_management.khach_hang
where (year(ngay_sinh) between 1971 and 2003)
and (dia_chi like '%đà nẵng%' or dia_chi like '%quảng trị%');

-- cau 4
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

use furama_management;
select hop_dong.ma_khach_hang, khach_hang.ho_ten_khach_hang , count(hop_dong.ma_khach_hang) as so_lan_dat_phong
from (hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang)
where khach_hang.ma_loai_khach = 1
group by hop_dong.ma_khach_hang
order by so_lan_dat_phong;

-- cau 5: 
-- Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

use furama_management;
select 	khach_hang.ma_khach_hang, khach_hang.ho_ten_khach_hang, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, 
hop_dong.ngay_ket_thuc, sum(IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL(hop_dong_chi_tiet.so_luong, 0) * IFNULL(dich_vu_di_kem.gia, 0)) as tong_tien 
from (((((khach_hang
left join hop_dong on  khach_hang.ma_khach_hang = hop_dong.ma_khach_hang)
left join dich_vu on  dich_vu.ma_dich_vu = hop_dong.ma_dich_vu)
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach)
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong)
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem)
-- where 
group by hop_dong.ma_hop_dong
order by khach_hang.ma_khach_hang;

-- cau 6
-- Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng 
-- được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
use furama_management;
select dv.ma_dich_vu 'mã dich vụ', dv.ten_dich_vu 'tên phòng', dv.dien_tich 'diện tích', dv.chi_phi_thue 'chi phí thuê', ldv.ten_loai_dich_vu 'loại phòng'
from ((dich_vu dv
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu)
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu)
-- where not MONTH(hd.ngay_lam_hop_dong) IN (1,2,3) AND YEAR(hd.ngay_lam_hop_dong) = 2021
WHERE dv.ma_dich_vu 
	NOT IN (SELECT dv.ma_dich_vu FROM((hop_dong hd JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu)join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu)
			WHERE MONTH(hd.ngay_lam_hop_dong) IN (1 , 2, 3) AND YEAR(hd.ngay_lam_hop_dong) = 2021)
group by dv.ma_dich_vu
order by dv.dien_tich desc;
