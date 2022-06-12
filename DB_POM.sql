drop table if exists user;

create table user(
no int(5) not null auto_increment primary key,
id varchar(20) not null,
password varchar(50) not null,
filename varchar(20),
filerealname varchar(20),
name varchar(20) not null,
reg_num varchar(13) unique not null,
phone varchar(11) not null,
addr varchar(100) not null,
email varchar(30) not null,
school_name varchar(20) not null,
school_major varchar(30) not null,
school_out date not null,
tall int(3) not null,
Weight int(3) not null,
eye_L varchar(4) not null,
eye_R varchar(4) not null,
gender varchar(1) not null,
marry varchar(1) not null,
disabled varchar(1) not null,
disabled_grade int(1),
disabled_day date
) engine=InnoDB character set = utf8;

INSERT INTO USER(id, password, filename, filerealname, name, reg_num, phone, addr, email, school_name, school_major,school_out, tall, weight, eye_L, eye_R, gender, marry, disabled,disabled_grade,disabled_day)
VALUES( '1', '1', 'sung.jpg','sung.jsp','sung',910508124,01057865845,'서울특별시 구로구 디지털로32길 97-16','stephano_sung@hanmail.net','원광대학교','경영학부','20220523','170','70','2.0','2.0','M','N','Y','5','20220523');

drop table edu;

create table edu(
no int (5) not null,
edu_no int(1) not null,
edu_content text not null
)engine=InnoDB character set = utf8; 


insert into edu values
(1 ,1, '경기도 연수원에서 행정교육 수료'),
(1,2, '충청도 연수원에서 민원교육 수료');

drop table dept;

create table dept(
dept_no int(3) primary key,
dept_name varchar(10) not null
) engine=InnoDB default character set=utf8;

insert into dept ( dept_no, dept_name ) values ( 10, '경영부');
insert into dept ( dept_no, dept_name ) values ( 20, '회계부');
insert into dept ( dept_no, dept_name ) values ( 30, '무역부');
insert into dept ( dept_no, dept_name ) values ( 40, '개발부');
insert into dept ( dept_no, dept_name ) values ( 50, '국내영업부');
insert into dept ( dept_no, dept_name ) values ( 60, '국외영업부');
insert into dept ( dept_no, dept_name ) values ( 70, '인사관리부');
insert into dept ( dept_no, dept_name ) values ( 80, '법무부');


drop table ministry;

create table ministry(
mini_no int(5) primary key,
mini_name varchar(10) not null
) engine=InnoDB default character set=utf8;

insert into ministry ( mini_no, mini_name ) values ( 10, '경영처');
insert into ministry ( mini_no, mini_name ) values ( 20, '회계처');
insert into ministry ( mini_no, mini_name ) values ( 30, '무역처');
insert into ministry ( mini_no, mini_name ) values ( 40, '개발처');
insert into ministry ( mini_no, mini_name ) values ( 50, '국내영업처');
insert into ministry ( mini_no, mini_name ) values ( 60, '국외영업처');
insert into ministry ( mini_no, mini_name ) values ( 70, '인사관리처');
insert into ministry ( mini_no, mini_name ) values ( 80, '법무처');

drop table workExperience;

create table workExperience (
no int(5) not null,
we_no int(1) not null,
dept_no int(5) not null,
mini_no int(5) not null,
start_date datetime default now() not null,
end_date date not null
) engine=InnoDB default character set=utf8;

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 1,1 , 60, 30, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 2,1 , 80, 40, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 3,1 , 60, 20, '2022-05-18', '2022-06-19'); 
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 4,1 , 50, 60, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,1 , 40, 70, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 6,1 , 40, 70, '2022-05-18', '2022-06-19');

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 1,2 , 10, 20, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 2,2 , 60, 40, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 3,2 , 50, 20, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 4,2 , 50, 60, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,2 , 40, 70, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,2 , 20, 30, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 6,2 , 70, 80, '2022-05-18', '2022-06-19');

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 1,3 , 20, 40, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 2,3 , 10, 40, '2022-05-18', '2022-06-19');

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 4,3 , 70, 60, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,3 , 80, 70, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 6,3 , 10, 30, '2022-05-18', '2022-06-19');

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 1,4 , 30, 50, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 2,4 , 10, 60, '2022-05-18', '2022-06-19');

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 4,4 , 40, 80, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,4 , 20, 30, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 6,4 , 40, 70, '2022-05-18', '2022-06-19');


insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 1,5 , 40, 20, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 2,5 , 60, 30, '2022-05-18', '2022-06-19');


drop table salary;
create table salary (
job_position int(2) not null,
salary_class int(1) not null,
money  int(9) not null
) engine=InnoDB default character set=utf8;
select money from salary where salary_class = 1 and job_position = 1;
insert into salary (  job_position, salary_class ,money) values (1, 1, 4189900),
(1, 1, 4189900),
(1, 2, 4336700),
(1, 3, 4487300),
(1, 4, 4641300),
(1, 5, 4799000),
(1, 6, 4958600),
(1, 7, 5120600),
(1, 8, 5284000),
(1, 9, 5449700),
(1, 10, 5616300),
(1, 11, 5782600),
(1, 12, 5954500),
(1, 13, 6127300),
(1, 14, 6300700),
(1, 15, 6452100),
(1, 16, 6586600),
(1, 17, 6705900),
(1, 18, 6812100),
(1, 19, 6907200),
(1, 20, 6992400),
(1, 21, 7071000),
(1, 22, 7140900),
(1, 23, 7200100),

(2, 1, 3771900),
(2, 2, 3911800),
(2, 3, 4053600),
(2, 4, 4196800),
(2, 5, 4341900),
(2, 6, 4487200),
(2, 7, 4634500),
(2, 8, 4781500),
(2, 9, 4929600),
(2, 10, 5077500),
(2, 11, 5226200),
(2, 12, 5379900),
(2, 13, 5534600),
(2, 14, 5674600),
(2, 15, 5803700),
(2, 16, 5922000),
(2, 17, 6031000),
(2, 18, 6130500),
(2, 19, 6222500),
(2, 20, 6306400),
(2, 21, 6383100),
(2, 22, 6453500),
(2, 23, 6517900),
(2, 24, 6570500),
(2, 25, 6620800),

(3, 1, 3403000),
(3, 2, 3528900),
(3, 3, 3658600),
(3, 4, 3789200),
(3, 5, 3921900),
(3, 6, 4055900),
(3, 7, 4191500),
(3, 8, 4327500),
(3, 9, 4464600),
(3, 10, 4601600),
(3, 11, 4738800),
(3, 12, 4881100),
(3, 13, 5013300),
(3, 14, 5136100),
(3, 15, 5249200),
(3, 16, 5354700),
(3, 17, 5452700),
(3, 18, 5542800),
(3, 19, 5628000),
(3, 20, 5707000),
(3, 21, 5780000),
(3, 22, 5847700),
(3, 23, 5910100),
(3, 24, 5985000),
(3, 25, 6016300),
(3, 26, 6062100),
(3, 27, 6104500),

(4, 1, 2916600),
(4, 2, 3035700),
(4, 3, 3156700),
(4, 4, 3280600),
(4, 5, 3406200),
(4, 6, 3533000),
(4, 7, 3660900),
(4, 8, 3789500),
(4, 9, 3918500),
(4, 10, 4047300),
(4, 11, 4177300),
(4, 12, 4299600),
(4, 13, 4414000),
(4, 14, 4520700),
(4, 15, 4621200),
(4, 16, 4716100),
(4, 17, 4804200),
(4, 18, 4886400),
(4, 19, 4963200),
(4, 20, 5035000),
(4, 21, 5102100),
(4, 22, 5165000),
(4, 23, 5224100),
(4, 24, 5330700),
(4, 25, 5373800),
(4, 26, 5413600),
(4, 27, 5413600),
(4, 28, 5451600),

(5, 1, 2606600),
(5, 2, 2711700),
(5, 3, 2821100),
(5, 4, 2934700),
(5, 5, 3051300),
(5, 6, 3170300),
(5, 7, 3291100),
(5, 8, 3413400),
(5, 9, 3536100),
(5, 10, 3659700),
(5, 11, 3775100),
(5, 12, 3886500),
(5, 13, 3992200),
(5, 14, 4090800),
(5, 15, 4183900),
(5, 16, 4271500),
(5, 17, 4353900),
(5, 18, 4431700),
(5, 19, 4505000),
(5, 20, 4573700),
(5, 21, 4638300),
(5, 22, 4699000),
(5, 23, 4756400),
(5, 24, 4809900),
(5, 25, 4860600),
(5, 26, 4908300),
(5, 27, 4957900),
(5, 28, 4987900),
(5, 29, 5020700),
(5, 30, 5054700),

(6, 1, 2150200),
(6, 2, 2250200),
(6, 3, 2353400),
(6, 4, 2458800),
(6, 5, 2567400),
(6, 6, 2679000),
(6, 7, 2790900),
(6, 8, 2903100),
(6, 9, 3015700),
(6, 10, 3121300),
(6, 11, 3221500),
(6, 12, 3320200),
(6, 13, 3412900),
(6, 14, 3500500),
(6, 15, 3584800),
(6, 16, 3663600),
(6, 17, 3728800),
(6, 18, 3810000),
(6, 19, 3877600),
(6, 20, 3941100),
(6, 21, 4002200),
(6, 22, 4059700),
(6, 23, 4113600),
(6, 24, 4165000),
(6, 25, 4213900),
(6, 26, 4260100),
(6, 27, 4303900),
(6, 28, 4340700),
(6, 29, 4385100),
(6, 30, 4409100),
(6, 31, 4440600),
(6, 32, 4470300),
(7, 1, 1929500),
(7, 2, 2017500),
(7, 3, 2110700),
(7, 4, 2208700),
(7, 5, 2310100),
(7, 6, 2414000),
(7, 7, 2518500),
(7, 8, 2623800),
(7, 9, 2723900),
(7, 10, 2819500),
(7, 11, 2909600),
(7, 12, 2998200),
(7, 13, 3082300),
(7, 14, 3162600),
(7, 15, 3239400),
(7, 16, 3312000),
(7, 17, 3381700),
(7, 18, 3448400),
(7, 19, 3511200),
(7, 20, 3571000),
(7, 21, 3628100),
(7, 22, 3681900),
(7, 23, 3734100),
(7, 24, 3783500),
(7, 25, 3830300),
(7, 26, 3875300),
(7, 27, 3913200),
(7, 28, 3948600),
(7, 29, 3982800),
(7, 30, 4015500),
(7, 31, 4046200),

(8, 1, 1720300),
(8, 2, 1803900),
(8, 3, 1892000),
(8, 4, 1982000),
(8, 5, 2075500),
(8, 6, 2127130),
(8, 7, 2267400),
(8, 8, 2359800),
(8, 9, 2447900),
(8, 10, 2531300),
(8, 11, 2612000),
(8, 12, 2690900),
(8, 13, 2766700),
(8, 14, 2839100),
(8, 15, 2908700),
(8, 16, 2975900),
(8, 17, 3038600),
(8, 18, 3099400),
(8, 19, 3157800),
(8, 20, 3213500),
(8, 21, 3266600),
(8, 22, 3317600),
(8, 23, 3366200),
(8, 24, 3413100),
(8, 25, 3457600),
(8, 26, 3500700),
(8, 27, 3536700),
(8, 28, 3571300),
(8, 29, 3604100),
(8, 30, 3635800),
(8, 31, 3666600),

(9, 1, 1686500),
(9, 2, 1709600),
(9, 3, 1748300),
(9, 4, 1802400),
(9, 5, 1872000),
(9, 6, 1959500),
(9, 7, 2046500),
(9, 8, 2130400),
(9, 9, 2210700),
(9, 10, 2288000),
(9, 11, 2361700),
(9, 12, 2435000),
(9, 13, 2505200),
(9, 14, 2573500),
(9, 15, 2638600),
(9, 16, 2701700),
(9, 17, 2763300),
(9, 18, 2820600),
(9, 19, 2877100),
(9, 20, 2930900),
(9, 21, 2981700),
(9, 22, 3030400),
(9, 23, 3076900),
(9, 24, 3121400),
(9, 25, 3164000),
(9, 26, 3202500),
(9, 27, 3235500),
(9, 28, 3267400),
(9, 29, 3298100),
(9, 30, 3328000),
(9, 31, 3367400);

show tables;

insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 4,5 , 40, 70, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 5,5 , 40, 70, '2022-05-18', '2022-06-19');
insert into workExperience ( no, we_no ,dept_no, mini_no , start_date, end_date) values ( 6,5 , 40, 70, '2022-05-18', '2022-06-19');

drop table personnel;

create table personnel(
no int (5) primary key,
name varchar(14) not null,
job_position int(2) ,
salary_class int(1),
money int(9),
mini_no int(5),
dept_no int(3),
enter_date date,
resign_date date
)engine=InnoDB character set = utf8;

insert into personnel( no, name ) values (1, '코스모');

drop table license;

create table license(
no int(5) not null,
lic_no int(1) not null,
license varchar(30) not null,
license_day date not null
)engine=InnoDB character set = utf8;
 
insert into license(no, lic_no, license, license_day) values
('1', '1' ,'한컴타자 서기' ,'2020-02-05');
