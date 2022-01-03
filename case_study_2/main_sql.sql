drop database if exists casestudy_2;
create database casestudy_2;

use casestudy_2;

CREATE TABLE position (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE education (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE division (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    is_delete BIT(1) DEFAULT 0
);
create table roles (
	id  INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    is_delete BIT(1) DEFAULT 0
);
create table users(
	`username` VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255),
    is_delete BIT(1) DEFAULT 0
);
create table users_roles(
	role_id int,
    username VARCHAR(255),
    primary key (role_id,username),
    foreign key (role_id) references roles(id),
    foreign key (username) references users(username),
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    dob VARCHAR(50) NOT NULL,
    gender int default 0,
    personal_id VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    position_id INT,
    education_id INT,
    division_id INT,
    username varchar(255),	
    foreign key (username) references users (username),    
    FOREIGN KEY (position_id) REFERENCES position (id),
    FOREIGN KEY (education_id) REFERENCES education (id),
    FOREIGN KEY (division_id) REFERENCES division (id),
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE customer_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(50) NOT NULL,
   is_delete BIT(1) DEFAULT 0
);
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender BIT(1) NOT NULL,
    personal_id VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    customer_type_id INT,
    FOREIGN KEY (customer_type_id) REFERENCES customer_type (id),
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE service_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE rent_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    cost double not null,
    is_delete BIT(1) DEFAULT 0
);
create TABLE service (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    area DOUBLE NOT NULL,
    cost DOUBLE NOT NULL,
    capacity INT NOT NULL,
	rent_type_id INT,
    service_type_id INT,
    room_standard VARCHAR(50),
    `description` VARCHAR(50),
    pool_area DOUBLE,
    storey INT,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type (id),
    FOREIGN KEY (service_type_id) REFERENCES service_type (id),
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE attach_service (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    cost DOUBLE NOT NULL,
    unit VARCHAR(50) NOT NULL,
   `status` VARCHAR(50) NOT NULL,
   is_delete BIT(1) DEFAULT 0
);
CREATE TABLE contract (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_date VARCHAR(50) NOT NULL,
    end_date VARCHAR(50) NOT NULL,
    deposit DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    service_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (service_id) REFERENCES service (id),
    is_delete BIT(1) DEFAULT 0
);
CREATE TABLE detail_contract (
    id INT PRIMARY KEY,
    amount INT NOT NULL,
    contract_id INT,
    attach_service_id INT,
    FOREIGN KEY (contract_id) REFERENCES contract (id),
    FOREIGN KEY (attach_service_id) REFERENCES attach_service (id),
    is_delete BIT(1) DEFAULT 0
);






