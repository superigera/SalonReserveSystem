CREATE TABLE IF NOT EXISTS menu (
  menu_id VARCHAR(50) PRIMARY KEY AUTO_INCREMENT,
  menu_name VARCHAR(50),
  menu_price INT,
  menu_times INT
);

create table if not exists reservations(
	reservations_id varchar(50) primary key AUTO_INCREMENT,
	menu_id varchar(50),
	member_id varchar(50),
	non_member_nane varchar(50),
	non_member_email varchar(50),
	non_member_phone_number varchar(50),
	reserve_days varchar(50),
	reserve_time varchar(50),
	date_up date
);

create table if not exists members(
	member_id varchar(50) primary key AUTO_INCREMENT,
	name varchar(50),
	email varchar(50),
	phone_number varchar(50),
	age Integer,
	gender Integer,
	password varchar(50),
	created_at date,
	update_at date,
	logical_delete_flag boolean,
	role_id boolean
);