CREATE SCHEMA `chess`;
USE chess;

-- 유저 정보
CREATE TABLE user_info(
u_idx int NOT NULL PRIMARY KEY auto_increment,
id varchar(100) not null,
password varchar(100) not null,
nickname varchar(100) not null,
mmr int default 0
);

-- 채팅 로그
CREATE TABLE chat(
u_idx int,
chatting varchar(1000),
time datetime,
FOREIGN KEY (u_idx) REFERENCES user_info (u_idx)
);

select * from user_info where id = 'jw';
select * from chat;

insert into user_info values(0, 'jw', 'jwjw', '정욱', 0);