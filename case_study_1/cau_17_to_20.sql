use furama_management;

-- cau 17:
-- Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
create view temper_table as
(select kh.ma_khach_hang,kh.ho_ten_khach_hang,kh.ma_loai_khach,
sum(IFNULL(dv.chi_phi_thue, 0) + IFNULL(hdct.so_luong, 0) * IFNULL(dvdk.gia, 0)) as tong_tien 
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = kh.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join dich_vu dv on  hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong) = 2021 and kh.ma_loai_khach <= 2
group by kh.ma_khach_hang
having tong_tien >100000
);
SET FOREIGN_KEY_CHECKS = 0;
update khach_hang
set khach_hang.ma_loai_khach = 1 
where khach_hang.ma_khach_hang in (select ma_khach_hang from temper_table);
SET FOREIGN_KEY_CHECKS = 1;
drop view temper_table;

-- cau 18:
-- Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

create view temp_table as
select kh.ma_khach_hang,kh.ho_ten_khach_hang
from khach_hang kh
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
where year(hd.ngay_lam_hop_dong) = 2020;
SET FOREIGN_KEY_CHECKS = 0;
delete from khach_hang where khach_hang.ma_khach_hang in (temp_table);
SET FOREIGN_KEY_CHECKS = 1;
drop view temp_table;

-- cau 19:
-- Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.

create temporary table tempor_table
(select hdct.ma_dich_vu_di_kem 'ma_dich_vu_di_kem', sum(so_luong) as 'so_lan_su_dung'
from hop_dong_chi_tiet hdct
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong) = 2020
group by dvdk.ma_dich_vu_di_kem
having so_lan_su_dung > 10);

-- select*
-- from tempor_table

update dich_vu_di_kem
set gia = (gia*2)
where ma_dich_vu_di_kem in ( select ma_dich_vu_di_kem from tempor_table);

drop temporary table tempor_table;

-- cau 20:
-- Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_khach_hang 'id',ho_ten_khach_hang 'ho_ten', 
email, so_dien_thoai, ngay_sinh, dia_chi, 'nhan_vien' as `type`
from khach_hang
union all
select ma_nhan_vien 'id', ho_ten_nhan_vien 'ho_ten', email, so_dien_thoai, ngay_sinh, dia_chi, 'khach_hang' as `type`
from nhan_vien;

-- cau 21, 22:
-- Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
-- Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.

-- K234/11 Điện Biên Phủ, Gia Lai
create view v_nhan_vien as(
select nv.ma_nhan_vien,nv.ho_ten_nhan_vien,nv.dia_chi
from nhan_vien nv
left join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien 
where year(ngay_lam_hop_dong) = 2020 and month(ngay_lam_hop_dong) = 12
);
SET FOREIGN_KEY_CHECKS = 0;
update nhan_vien
set nhan_vien.dia_chi = 'lien chieu'
where nhan_vien.ma_nhan_vien in (select ma_nhan_vien from v_nhan_vien);
SET FOREIGN_KEY_CHECKS = 1;
drop view v_nhan_vien ;
