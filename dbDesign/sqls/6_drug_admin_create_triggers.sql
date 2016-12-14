-- id auto increment triggers
create or replace trigger iadmin_id_auto_trigger  
	before insert on iadmin  
	for each row  
	begin  
	    select iadmin_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  

create or replace trigger imodel_id_auto_trigger  
	before insert on imodel  
	for each row  
	begin  
	    select imodel_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  


create or replace trigger record_id_auto_trigger  
	before insert on record  
	for each row  
	begin  
	    select record_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  

create or replace trigger daily_records_id_auto_trigger  
	before insert on daily_records  
	for each row  
	begin  
	    select daily_records_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  

create or replace trigger drug_id_auto_trigger  
	before insert on drug
	for each row  
	begin  
	    select drug_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  


create or replace trigger iuser_id_auto_trigger  
	before insert on iuser
	for each row  
	begin  
	    select iuser_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  

create or replace trigger buy_record_id_auto_trigger  
	before insert on buy_record  
	for each row  
	begin  
	    select buy_record_id_sequence.nextval into :new.id  FROM dual;  
	end;  
/  
