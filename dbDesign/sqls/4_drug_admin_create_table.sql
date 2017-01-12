create table iadmin(
	id number(6) 
			constraint admin_pk primary key,
	user_name varchar2(16) 
			constraint user_name_unique unique
			constraint user_name_not_null not null,
	password varchar2(32)
			constraint password_not_null not null,
	token 	varchar2(256)
			constraint token_unique unique
			constraint token_not_null not null
);

create table imodel(
	id number(6)
			constraint model_pk primary key,
	model_name varchar2(32)
			constraint model_name_not_null not null,
	algorithm varchar2(32)
			constraint algorithm_not_null not null,
	state number(1)
			default 0 -- 0 training, 1 completed
			constraint state_not_null not null,
	file_dir varchar2(256)
			constraint file_dir_not_null not null,
	file_name varchar2(256)
			constraint file_name_not_null not null,
	created_time date 
			default trunc(SYSDATE)
			constraint create_time_not_null not null,
	published number(1)
			default 0 -- 0 private, 1 published
			constraint published_not_null not null,
	model_size number(6)
			default 0,
	model_input varchar2(256),
	model_target varchar2(256),
	app_key varchar2(256),
	admin_id
		constraint user_id_not_null not null
		constraint user_id_fk references iadmin(id)
);

create table record(
	id number(6)
			constraint record_pk primary key,
	app_key varchar2(256)
			constraint app_key_not_null not null,
	idate date
		default trunc(SYSDATE)
			constraint date_not_null not null,
	ip varchar2(32)
			constraint ip_not_null not null
);

create table daily_records(
	id number(6)
			constraint daily_records_pk primary key,
	app_key varchar2(256)
			constraint daily_app_key_not_null not null,
	idate date
			default trunc(SYSDATE)
			constraint daily_date_not_null not null,
	count number(6)
			default 0

);

create table drug(
	id number(6)
			constraint drug_pk primary key,
	name varchar2(256)
			constraint name_not_null not null
			constraint name_unique unique,
	intro varchar2(256),
	pic varchar2(256),
	price number(16,4)
			constraint price_not_null not null
);

create table iuser(
	id number(6)
			constraint user_pk primary key,
	user_name varchar2(16) 
			constraint iuser_name_unique unique
			constraint iuser_name_not_null not null,
	password varchar2(32)
			constraint ipassword_not_null not null,
	token varchar2(256)
			constraint itoken_unique unique
			constraint itoken_not_null not null,
	ilevel number(2)
			default 0
			constraint ilevel_not_null not null,
	consumed_money number(16,4)
			default 0
			constraint consumed_money_not_null not null,
	birthday date,
	age number(3),
	email varchar2(30)
			constraint email_not_null not null
			constraint email_check check(email like '_%@_%._%')
);

create table buy_record(
	id number(6)
			constraint buy_record_pk primary key,
	idate date
			default trunc(SYSDATE)
			constraint buy_date_not_null not null,
	user_id 
			constraint buy_user_id_not_null not null
			constraint buy_user_id_fk references iuser(id),
	drug_id
			constraint buy_drug_id_not_null not null
			constraint buy_drug_id_fk references drug(id),
	amount number(6)
			constraint amount_not_null not null

);