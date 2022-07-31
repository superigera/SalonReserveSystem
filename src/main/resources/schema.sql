CREATE TABLE IF NOT EXISTS menu (
  menu_id VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50),
  price INT
);

create table if not exists reservations(
	reservations_id varchar(50) primary key,
	menu_id varchar(50),
	member_id varchar(50),
	non_member_nane varchar(50),
	non_member_email varchar(50),
	non_member_phone_number varchar(50),
	date_up date
);

create table if not exists members(
	member_id_id varchar(50) primary key,
	name varchar(50),
	email varchar(50),
	phone_number varchar(50),
	age int,
	sex boolean,
	birth date,
	password varchar(50),
	created_at date,
	update_at date,
	logical_delete_flag boolean,
	role_id boolean
);