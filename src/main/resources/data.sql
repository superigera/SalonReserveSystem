insert into menu(menu_name,menu_price,menu_times)values
('カット',3000,30),
('カラー',5000,50),
('パーマ',8000,80);




insert into reservations(menu_id,member_id,non_member_name,non_member_email,non_member_phone_number,reserve_days,reserve_time,delete_flag)values
('1',null,'杉本','test1@test.com','08069625416',20221024,2300,0),
('3',null,'後藤','test2@test.com','01234567890',20221024,1200,0),
('3',null,'屋比久','test3@test.com','12345678901',20221024,'0900',0),
('2',null,'北井','test4@test.com','23456789012',20221026,1100,0),
('1',null,'平山','test5@test.com','34567890123',20221101,1100,0),
('1',null,'早川','test6@test.com','45678901234',20230105,1100,0),
('1',1,'user','user@test.com','00000000000',20221024,1000,0),
('1',1,'user','user@test.com','00000000000',20221027,1300,0),
('1',1,'user','user@test.com','00000000000',20221025,1000,0),
('1',1,'user','user@test.com','00000000000',20221026,1300,0),
('1',1,'user','user@test.com','00000000000',20221124,1000,0),
('1',1,'user','user@test.com','00000000000',20221127,1300,0),
('1',2,'admin','admin@test.com','00000000000',20221024,1000,0),
('1',2,'admin','admin@test.com','00000000000',20221127,1300,0);


insert into members(name,email,password,authority,delete_flag)values
('user','user@test.com','$2a$10$uQxncf/XXn.6Dt7e24qEh.lndhGE9ZG2PElEkbmOYExuUbJJs6Ly2','ROLE_USER',0),
('admin','admin@test.com','$2a$10$uQxncf/XXn.6Dt7e24qEh.lndhGE9ZG2PElEkbmOYExuUbJJs6Ly2','ROLE_ADMIN',0);
