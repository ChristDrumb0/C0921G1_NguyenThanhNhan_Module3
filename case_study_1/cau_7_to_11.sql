-- cau 7
-- Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của 
-- tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

use furama_management;
select dv.ma_dich_vu 'mã dich vụ', dv.ten_dich_vu 'tên phòng', dv.dien_tich 'diện tích', dv.so_nguoi_toi_da 'số người tối đa' , dv.chi_phi_thue 'chi phí thuê', ldv.ten_loai_dich_vu 'loại phòng'
from ((hop_dong hd
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu)
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu)
WHERE dv.ma_dich_vu 
	NOT IN (SELECT dv.ma_dich_vu FROM((hop_dong hd JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu)join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu)
			WHERE YEAR(hd.ngay_lam_hop_dong) = 2021)
group by dv.ma_dich_vu
order by dv.dien_tich desc;  

-- cau 8
-- Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
use furama_management;
select distinct kh.ho_ten_khach_hang
from khach_hang kh;

-- cau 9
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
use furama_management;
select month(hd.ngay_lam_hop_dong) 'tháng', hd.ma_hop_dong 'số lượng hợp đồng'
from hop_dong hd
where year(hd.ngay_lam_hop_dong) = 2021
group by month(hd.ngay_lam_hop_dong)
order by month(hd.ngay_lam_hop_dong);

-- cau 10
-- Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
use furama_management;
select hd.ma_hop_dong, hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_coc, ifnull(sum(hdct.so_luong),0)'so_luong_dich_vu_di_kem'
from (hop_dong hd 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong)
group by hd.ma_hop_dong;

-- cau 11
-- Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
use furama_management;
select dvdk.ma_dich_vu_di_kem ,dvdk.ten_dich_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
where (kh.dia_chi like '%vinh%' or dia_chi like '%quảng ngãi%') and kh.ma_loai_khach = 1



