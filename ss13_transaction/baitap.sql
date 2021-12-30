use demo

-- baitap 1

-- 1 update
DELIMITER $$
CREATE PROCEDURE edit_user(

IN user_id int(11),

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    update users 
    set `name`=user_name , email = user_email, country = user_country 
    where id = user_id;

    END$$

DELIMITER ;

-- 2 view
DELIMITER $$
CREATE PROCEDURE view_user(

)

BEGIN
    select * 
	from users;
    END$$

DELIMITER ;

-- 3 delete
DELIMITER $$
CREATE PROCEDURE delete_user(

IN user_id int(11)

)

BEGIN

    delete
    from users 
    where id = user_id;

    END$$

DELIMITER ;