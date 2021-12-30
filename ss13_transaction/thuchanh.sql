
-- thực hành 1
DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;


-- thực hành 2
create table Permision(

id int(11) primary key,

`name` varchar(50)

);

create table User_Permision(
permision_id int(11),
user_id int(11),

primary key(permision_id,user_id),
foreign key (user_id) references users (id),
foreign key (permision_id) references Permision (id)
);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');

-- query xem thay đổi
select *
from user_permision up
left join `users` u on up.user_id = u.id
left join permision p on up.permision_id = p.id