-- grant privilege on tables to drug_user
grant read, insert, update, delete on iadmin to drug_user;
grant read, insert, update, delete on imodel to drug_user;
grant read, insert on record to drug_user;
grant read, insert, update on daily_records to drug_user;
grant read on drug to drug_user;
grant read, insert, update, delete on iuser to drug_user;
grant read, insert on buy_record to drug_user;


-- grant privilege on sequence to drug_user
grant select on iadmin_id_sequence to drug_user;
grant select on imodel_id_sequence to drug_user;
grant select on record_id_sequence to drug_user;
grant select on daily_records_id_sequence to drug_user;
grant select on drug_id_sequence to drug_user;
grant select on iuser_id_sequence to drug_user;
grant select on buy_record_id_sequence to drug_user;



--grant privilege on pkg to drug_user
grant execute on IDRUG to drug_user;