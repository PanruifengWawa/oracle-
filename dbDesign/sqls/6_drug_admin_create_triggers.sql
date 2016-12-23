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

--logical triggers
-- 1 when a user use model it will insert a record into table record, and this will cause record in table daily_records to add 1 
create or replace trigger model_records_trigger after insert on record
	for each row 
    declare 
        allcount number(6);
        one_record_id daily_records.id%type;
	begin 
    select count(*) into allcount from daily_records where app_key = :new.app_key and to_char(idate,'yyyymmdd')=to_char(CURRENT_DATE,'yyyymmdd');
  
    if allcount = 0 then
        insert into daily_records(app_key,idate,count) values(:new.app_key,CURRENT_DATE,1);
    else 
      select id into one_record_id from daily_records where app_key = :new.app_key and to_char(idate,'yyyymmdd')=to_char(CURRENT_DATE,'yyyymmdd');
      update daily_records set count=count+1 where id = one_record_id;
    end if;
    
	
	end;
/

--calculate age when you input or delete the birthday
create or replace trigger cal_age before update or insert on iuser
	for each row 
	begin 
    if :new.birthday is null then 
        :new.age := null;
    else
      select floor(MONTHS_BETWEEN(sysdate,:new.birthday)/12) into :new.age from dual;
    end if;    
	end;
/
