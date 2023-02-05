insert into menu(menu_name,menu_price,menu_times)values
('カット',3000,30),
('カラー',5000,50),
('パーマ',8000,80);




insert into reservations(menu_id,member_id,non_member_name,non_member_email,non_member_phone_number,reserve_days,reserve_time,delete_flag)values
('1',null,'杉本','test1@test.com','08069625416',20230131,1700,0),
('3',null,'後藤','test2@test.com','01234567890',20230131,1200,0),
('3',null,'屋比久','test3@test.com','12345678901',20230131,'0900',0),
('2',null,'北井','test4@test.com','23456789012',20230201,1100,0),
('1',null,'平山','test5@test.com','34567890123',20230201,1500,0),
('1',null,'早川','test6@test.com','45678901234',20230201,1600,0),
('1',1,'user','user@test.com','00000000000',20230206,1000,0),
('1',1,'user','user@test.com','00000000000',20230206,1200,0),
('1',1,'user','user@test.com','00000000000',20230207,1800,0),
('1',1,'user','user@test.com','00000000000',20230207,1300,0),
('2',1,'user','user@test.com','00000000000',20230207,1000,0),
('3',1,'user','user@test.com','00000000000',20230208,1300,0),
('1',2,'admin','admin@test.com','00000000000',20230208,1000,0),
('1',2,'admin','admin@test.com','00000000000',20230205,1300,0),
('1',2,'admin','admin@test.com','00000000000',20230206,1300,0);


insert into members(name,email,password,authority,delete_flag)values
('user','user@test.com','$2a$10$uQxncf/XXn.6Dt7e24qEh.lndhGE9ZG2PElEkbmOYExuUbJJs6Ly2','ROLE_USER',0),
('admin','admin@test.com','$2a$10$uQxncf/XXn.6Dt7e24qEh.lndhGE9ZG2PElEkbmOYExuUbJJs6Ly2','ROLE_ADMIN',0);
