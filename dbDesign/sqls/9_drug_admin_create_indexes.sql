create index buy_record_id on buy_record(id);
create index buy_record_user_id on buy_record(user_id);
create index buy_record_drug_id on buy_record(drug_id);
create index buy_record_user_drug_id on buy_record(user_id,drug_id);

create index daily_record_id on daily_record(id);
