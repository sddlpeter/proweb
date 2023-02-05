SELECT * FROM fruitdb.t_fruit;


update t_fruit set fname = "香蕉" , price = 2 , fcount = 150 , remark = "taste good!" where fid = 2;


DROP DATABASE IF EXISTS qqzonedb;
CREATE DATABASE qqzonedb;

use qqzonedb;

create table t_user_basic(id int primary key auto_increment, loginId varchar(20), nickName varchar(20), pwd varchar(20), headImg varchar(20));
create table t_user_detail(id int  primary key auto_increment, realName varchar(20), tel varchar(20), email varchar(20), birth varchar(20), star varchar(20));
create table t_topic(id int  primary key auto_increment, title varchar(40), content varchar(300), topicDate date, author int);
create table t_reply(id int  primary key auto_increment, content varchar(100), replyDate date, author int, topic int);
create table t_host_reply(id int  primary key auto_increment, content varchar(100), hostReplyDate date, author int, reply int);
create table t_friend(id int  primary key auto_increment, uid int, fid int);

select * from t_user_basic;
insert into t_user_basic values(1, 'u001', '萧峰', 'ok', 'qf.png');
insert into t_user_basic values(2, 'u002', 'tom', 'ok', 'dy.png');
insert into t_user_basic values(3, 'u003', 'kate', 'ok', 'mrf.png');
insert into t_user_basic values(4, 'u004', 'lucy', 'ok', 'wyy.png');
insert into t_user_basic values(5, 'u005', '张三丰', 'ok', 'zl.png');

select * from t_topic;
insert into t_topic values(3, '我的qq空间开通了', '大家好，我是某某某', '2021-06-18', 1);

select * from t_topic;

select * from t_reply;

insert into t_reply values (10, '这里是回复2', '2021-10-22 11:26:19', 2, 3);
insert into t_reply values (16, '这里是回复1', '2021-10-22 14:18:21', 2, 3);

insert into t_friend values (1, 1, 2);
insert into t_friend values (2, 1, 3);
insert into t_friend values (3, 1, 4);
insert into t_friend values (4, 1, 5);
insert into t_friend values (5, 2, 3);
insert into t_friend values (6, 2, 1);
insert into t_friend values (7, 2, 4);
insert into t_friend values (8, 3, 1);
insert into t_friend values (9, 3, 2);
insert into t_friend values (10, 5, 2);


select * from t_friend;
select * from t_user_basic;

select t3.*
from t_user_basic t1
         join t_friend t2 on t1.id = t2.uid
         join t_user_basic t3 on t2.fid = t3.id
where t1.id = 1


