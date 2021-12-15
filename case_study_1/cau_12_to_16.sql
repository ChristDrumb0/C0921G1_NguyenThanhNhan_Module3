use furama_management;

-- cau 12: 
-- Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hd.ma_hop_dong , nv.ho_ten_nhan_vien , kh.ho_ten_khach_hang,kh.so_dien_thoai,dv.ten_dich_vu,sum(hdct.so_luong) 'tong so luong', hd.tien_coc
from hop_dong hd
left join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
left join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong) = 2020 and quarter(hd.ngay_lam_hop_dong) = 4
group by hd.ma_hop_dong
;

-- cau 13:
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem,dvdk.ten_dich_di_kem,dvdk.gia,dvdk.don_vi,dvdk.trang_thai,sum(hdct.so_luong) 'so luong'
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong) >= all (select hdct.so_luong from hop_dong_chi_tiet hdct)
;
-- cau 14:
-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hd.ma_hop_dong,dv.ten_dich_vu,dvdk.ten_dich_di_kem,count(hdct.ma_dich_vu_di_kem) 'so_lan_su_dung'
from  dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct  on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu= hd.ma_dich_vu
group by dvdk.ten_dich_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1
order by hd.ma_hop_dong
;

-- cau 15:
-- Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien,ho_ten_nhan_vien,td.ten_trinh_do,bp.ten_bo_phan,so_dien_thoai,dia_chi
from nhan_vien nv
join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien 
-- where year(hd.ngay_lam_hop_dong) in (2020,2021)
group by nv.ma_nhan_vien
having count(hd.ma_hop_dong) <= 3
;

-- cau 16:
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE nv
-- select *
FROM nhan_vien nv 
where ma_nhan_vien in (
select *
FROM nhan_vien nv 
left JOIN hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
-- WHERE year(hd.ngay_lam_hop_dong) NOT IN (2019,2020,2021)
GROUP BY nv.ma_nhan_vien
HAVING COUNT(hd.ma_hop_dong)=0);

