-- use casestudy_2

-- employee search query
select e.id,e.`name`,e.dob,e.gender,e.personal_id,e.salary,e.phone,e.email,e.address,
posi.`name` posiname,edu.`name` eduname,divi.`name` diviname,e.username
from employee e
left join position posi on posi.id = e.position_id
left join education edu on edu.id = e.education_id
left join division divi on divi.id = e.division_id
where e.id = 1;
-- employee query
select e.id,e.`name`,e.dob,e.gender,e.personal_id,e.salary,e.phone,e.email,e.address,posi.`name`,edu.`name`,divi.`name`,e.username
from employee e
left join posittion posi on posi.id = e.position_id
left join education edu on edu.id = e.education_id
left join division divi on divi.id = e.division_id;
-- insert employee
insert into employee(`name`,dob,gender,personal_id,salary,phone,email,address,position_id,education_id,division_id,username)
value ("nhan","12/12/2000",1,1234567890,1000,0987654321,"nhan@gmail.com","123asd",1,1,1,"admin");
-- update employee
update employee set `name`= "dsa",dob="22/11" ,gender=b'1',personal_id=1234,salary=4321,phone=09876,email="dsa@asd",address="123Aasd",position_id=1,education_id=2,division_id=3,username="hr"
where id = 1;

-- trinh do
insert into education (`name`)
value 
('high school'),
('college'),
('University'),
('Post Graduation');


-- vi tri
insert into position (`name`)
value 
('Employee'),
('Manager'),
('Directer');

-- bo phan 
insert into division (`name`)
value 
('Sale-Marketing'),
('Back of House'),
('FO'),
('Manager Team');

-- users
insert into users (username,`password`)
value 
("admin","123456"),
("gm","123456"),
("owner","123456");

-- rent type
insert into rent_type (`name`,cost)
value 
('Short term',200),
('Long term',200),
('Group short term',100),
('Group long term',100);

-- service type
insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,pool_area,storey)
value("HO-0001", 13.2,100,3,1,1,"free bar","idnk");
--  House
insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,storey)
value("HO-0001",13.2,150,3,1,1,"this is House","free pool",2);
-- Villa
insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,pool_area,storey)
value("VL-0001",15,200,3,1,2,"this is Villa","free massage",30,3);
-- Room
insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,`description`)
value("RO-0001",10,100,3,1,3,"free mini-bar");

-- insert customer
insert into customer(`name`,dob,gender,personal_id,phone,email,address,customer_type_id)
value ("customerTest","12-12-2000",1,1234567890,0987654321,"nhan@gmail.com","Beveley Hills",1);
-- insert customer type
insert into customer_type (`name`)
value 
('Standard'),
('Silver'),
('Gold'),
('Platinum'),
('Diamond'),
('SuperUltraMega_Vip');

-- select Customer
select c.id,c.`name`,c.dob,c.gender,c.personal_id,c.phone,c.email,c.address,ct.`name` ctname
from customer c
left join customer_type ct on ct.id = c.customer_type_idusers;
























