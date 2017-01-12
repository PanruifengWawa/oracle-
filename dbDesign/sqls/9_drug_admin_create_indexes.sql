create index buy_record_id_idx on buy_record(id);
create index buy_record_user_id_idx on buy_record(user_id);
create index buy_record_drug_id_idx on buy_record(drug_id);
create index buy_record_user_drug_id_idx on buy_record(user_id,drug_id);

create index daily_record_id_idx on daily_records(id);
create index daily_record_app_key_idx on daily_records(app_key);

create index drug_id_idx on drug(id);
create index drug_name_idx on drug(name);

create index admin_username_idx on iadmin(user_name);
create index admin_token_idx on iadmin(token);

create index model_id_idx on imodel(id);
create index model_app_key on imodel(app_key);

create index user_login_idx on iuser(user_name,password);
create index user_token_idx on iuser(token);

create index record_app_key_idx on record(app_key);