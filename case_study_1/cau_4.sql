-- cau 4
use furama_management;
select hop_dong.ma_khach_hang, khach_hang.ho_ten_khach_hang , count(hop_dong.ma_khach_hang) as so_lan_dat_phong
from (hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang)
where khach_hang.ma_loai_khach = 1
group by hop_dong.ma_khach_hang
order by so_lan_dat_phong
;
