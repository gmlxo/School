create table member_mvc(
userid varchar2(20),
username varchar2(20),
primary key (userid)
);

select * from member_mvc ORDER by userid DESC;

insert into member_mvc values('admin', '관리자');
insert into member_mvc values('user1', '금나라');
insert into member_mvc values('user2', '은나라');
insert into member_mvc values('user3', '동나라');