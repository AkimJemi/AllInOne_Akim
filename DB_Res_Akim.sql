mysql -u root
use book_akim;
drop database if exists akim_res 
create database akim_res;
drop table book;
drop table member;

drop table book;
drop table member;

create table member(
no INT(5) AUTO_INCREMENT PRIMARY KEY,
id varchar(20) not null UNIQUE,
password varchar(30) not null,
email varchar(30) not null UNIQUE,
name varchar(30) not null,
gender enum('M','F','none') not null,
age int(3) not null
) engine=InnoDB default character set=utf8;

create table book(
no INT(5) AUTO_INCREMENT PRIMARY KEY,
member_no varchar(20) not null,
res_Nvm varchar(6) not null default 'none',
if_res enum('yes','no','none') default 'none',
check_res enum('yes','no','none') default 'none'
)engine=InnoDB default character set=utf8;

ALTER TABLE book
ADD FOREIGN KEY (no) REFERENCES member(no) On Delete Cascade ;

DROP TRIGGER IF EXISTS itemlogger;
DELIMITER $$
CREATE TRIGGER itemlogger AFTER INSERT ON member FOR EACH ROW
BEGIN

INSERT INTO book( member_no) value ( (SELECT no FROM member ORDER BY no DESC LIMIT 1));

END$$
DELIMITER ;



insert into member (id, password, name, email, gender, age) values ( 'admin', 'admin', "wowp100@naver.com", "김재민", 'M', 27);
insert into member (id, password, name, email, gender, age) values 
( '1', '1', "김상식","wowp97@naver.com",  'none', 23),
( '2', '1', "김상식","wowp96@naver.com",  'none', 23),
( '3', '1', "김상식","wowp95@naver.com",  'none', 23),
( '4', '1', "김상식","wowp94@naver.com",  'none', 23),
( '5', '1', "김상식","wowp93@naver.com",  'none', 23),
( '6', '1', "김상식","wowp92@naver.com",  'none', 23),
( '7', '1', "김상식","wowp91@naver.com",  'none', 23),
( '8', '1', "김상식","wowp90@naver.com",  'none', 23),
( '9', '1', "김상식","wowp89@naver.com",  'none', 23),
( '10', '1', "김상식","wowp88@naver.com",  'none', 23),
( '11', '1', "김상식","wowp87@naver.com",  'none', 23),
( '12', '1', "김상식","wowp86@naver.com",  'none', 23),
( '13', '1', "김상식","wowp85@naver.com",  'none', 23),
( '14', '1', "김상식","wowp84@naver.com",  'none', 23),
( '15', '1', "김상식","wowp82@naver.com",  'none', 23),
( '16', '1', "김상식","wowp81@naver.com",  'none', 23),
( '17', '1', "김상식","wowp80@naver.com",  'none', 23),
( '18', '1', "김상식","wowp79@naver.com",  'none', 23),
( '19', '1', "김상식","wowp78@naver.com",  'none', 23),
( '20', '1', "김상식","wowp77@naver.com",  'none', 23),
( '21', '1', "김상식","wowp76@naver.com",  'none', 23);

// book;
drop table book;

create table book(
no INT(5) PRIMARY KEY NOT NULL,
res_Num varchar(6) not null,
if_res enum('yes','no','none') default 'none'
)engine=InnoDB default character set=utf8;

insert into book(no, res_Num )values ( '1', '1');
insert into book(no, res_Num , if_res) values ( ?, 'ES100' , ?);


alter table emp2
add constraint EMP_DEPT_FK foreign key (DEPTNO)
references DEPT(DEPTNO) 
deferrable initially deferred → commit 할때 검사
enable novalidate → 새로 들어오는 row 만 검사;

ALTER TABLE book
ADD FOREIGN KEY (no) REFERENCES member(no) On Delete Cascade ;



create table book_sub(



create table package(
no
country


create table product(
no
name
area
price
discount
max
min


create table 