drop table messages;
drop table contacts;
drop table users;

CREATE TABLE users
	(username	varchar(25),
	password	binary(16));

CREATE TABLE contacts
	(username	varchar(25),
	contact		varchar(25));

CREATE TABLE messages
	(sender		varchar(25),
	receiver	varchar(25),
	message		varchar(200),
	date_sent	date);

alter table users
 add constraint users_username_pk primary key(username);

alter table contacts
 add constraint contacts_username_contact_pk primary key(username, contact);

alter table messages
 add constraint messages_sender_receiver_pk primary key(sender, receiver);

alter table contacts
 add constraint contact_username_fk foreign key(username)
 references users(username);

alter table contacts
 add constraint contacts_contact_fk foreign key(contact)
 references users(username);

alter table messages
 add constraint messages_sender_fk foreign key(sender)
 references users(username);

alter table messages
 add constraint messages_receiver_fk foreign key(receiver)
 references users(username);
