drop table users;

CREATE TABLE users
	(username	varchar(25),
	 password	blob,
	 wins int,
	 losses int);

alter table users
 add constraint users_username_pk primary key(username);