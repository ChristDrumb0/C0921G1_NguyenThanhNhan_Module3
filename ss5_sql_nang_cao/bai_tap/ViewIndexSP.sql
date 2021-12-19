CREATE DATABASE demo_view_index_and_store_procedure;

USE demo_view_index_and_store_procedure;

CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
product_code VARCHAR(255) NOT NULL,
product_name VARCHAR(255) NOT NULL,
product_price INT NOT NULL,
product_amount INT NOT NULL,
product_description VARCHAR(255) NOT NULL,
product_status VARCHAR(255) NOT NULL
);

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
('SP01', 'air blade 2021', 55000000, 1000, 'Mới', 'Còn hàng'),
('SP02', 'SH 150i 2021', 89000000, 700, 'Mới', 'Còn hàng'),
('SP03', 'air blade 2020', 45000000, 2000, 'Mới', 'Còn hàng'),
('SP04', 'SH mode 2021', 75000000, 500, 'Mới', 'Còn hàng'),
('SP05', 'wave 2021', 21000000, 3000, 'Mới', 'Còn hàng'),
('SP06', 'SH 300i 2021', 200000000, 200, 'Mới', 'Còn hàng');


CREATE UNIQUE INDEX index_of_product_code ON products (product_code);


ALTER TABLE products ADD INDEX index_of_product_name_and_product_price (product_name, product_price);


EXPLAIN SELECT * FROM products WHERE product_code = 'SP03';

EXPLAIN SELECT * FROM products WHERE product_name = 'SH 150i 2021' AND product_price = 89000000;


ALTER TABLE products DROP INDEX index_of_product_code;

ALTER TABLE products DROP INDEX index_of_product_name_and_product_price;


CREATE VIEW view_products AS
    SELECT 
        product_code, product_name, product_price, product_status
    FROM
        products;

SELECT * FROM view_products;

/*
Tiến hành sửa đổi view
*/
CREATE OR REPLACE VIEW view_products AS
    SELECT 
        product_code,
        product_name,
        product_price,
        product_amount,
        product_status
    FROM
        products
    WHERE
        product_price >= 20000;

SELECT * FROM view_products;

/*
Tiến hành xoá view
*/
DROP VIEW view_products;


DELIMITER //

CREATE PROCEDURE find_all_products ()

BEGIN

SELECT * FROM products;

END //

DELIMITER ;

CALL find_all_products ();


DELIMITER //

DROP PROCEDURE IF EXISTS `find_all_products` //

CREATE PROCEDURE find_all_products ()

BEGIN

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES 
('SP07', 'Sirius', 24000000, 500, 'Mới', 'Còn hàng');

END //

DELIMITER ;

CALL find_all_products ();


DELIMITER //

DROP PROCEDURE IF EXISTS `find_all_products` //

CREATE PROCEDURE find_all_products ()

BEGIN

UPDATE products
SET product_price = 95000000
WHERE id = 2;

END //

DELIMITER ;

CALL find_all_products ();


DELIMITER //

DROP PROCEDURE IF EXISTS `find_all_products` //

CREATE PROCEDURE find_all_products ()

BEGIN

DELETE FROM products
WHERE id = 3;

END //

DELIMITER ;

CALL find_all_products ();