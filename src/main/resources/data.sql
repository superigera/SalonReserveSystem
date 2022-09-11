insert into menu(menu_name,menu_price,menu_times)values
('カット',3000,30),
('カラー',5000,50),
('パーマ',8000,80);



/*
insert into reservations(reservations_id,menu_id,member_id,non_member_nane,non_member_email,non_member_phone_number,date_up)
values('1','1','1',null,null,null,2022-07-04)
*/

insert into members(name,email,phone_number,age,gender,password)
values('testuser','test@test.com','080-0000-0000',20,1,'testpass');
