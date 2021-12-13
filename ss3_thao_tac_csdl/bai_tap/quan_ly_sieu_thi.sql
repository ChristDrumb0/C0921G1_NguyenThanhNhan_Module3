-- bài tập 
use quan_ly_sieu_thi;
select * from custommer ;
select * from `order` ;
select * from  order_detail;
select * from  product;


insert into quan_ly_sieu_thi.custommer 
value 
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into quan_ly_sieu_thi.`order`
value 
(1,1,'2006/03/21',Null),
(2,2,'2006/03/23',Null),
(3,1,'2006/03/16',Null);

insert into quan_ly_sieu_thi.product
value 
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into quan_ly_sieu_thi.order_detail
value 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
use quan_ly_sieu_thi;
SELECT `order`.oID ,`order`.oDate , `order`.oTotalPrice
FROM `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
use quan_ly_sieu_thi;
SELECT custommer.cName ,product.pName, product.pPrice
FROM custommer 
JOIN `order` on custommer.cid = `order`.cid
JOIN order_detail on `order`.oid = order_detail.oid
JOIN product on order_detail.pid = product.pid;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
use quan_ly_sieu_thi;
SELECT custommer.cid, custommer.cname
FROM custommer
LEFT JOIN `order` ON custommer.cod = `order`.cid
WHERE oID IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
use quan_ly_sieu_thi;
SELECT O.oid 'order ID', O.odate 'order ID', sum(Od.odqty* P.pprice) 'tong_gia'
FROM order_detail Od 
JOIN product P on Od.pid = P.pid
JOIN `order` O on O.oid = Od.oid
GROUP BY Od.oid;
