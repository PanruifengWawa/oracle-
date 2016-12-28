create or replace PACKAGE BODY IDRUG AS

  FUNCTION login_get_token ( in_user_name IN iuser.user_name%type , in_password IN iuser.password%type)
RETURN iuser.token%type AS
  return_token iuser.token%type;
  BEGIN
    select nvl(token,null) into return_token from iuser where user_name = in_user_name and password = in_password;
    RETURN return_token;
  END login_get_token;
  
PROCEDURE add_user(in_user_name IN iuser.user_name%type,in_password IN iuser.password%type,in_token IN iuser.token%type,in_email IN iuser.email%type ,flag OUT number)
IS
  email_format number(1);
  user_count number(1);
  BEGIN
    select count(1) into email_format from dual where regexp_like(in_email,'^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$');
    select count(*) into user_count from iuser where user_name = in_user_name;
    if email_format = 1 and user_count = 0
    then
      insert into iuser(user_name,password,token,ilevel,consumed_money,email) values(in_user_name,in_password,in_token,0,0,in_email);
      commit;
      flag := 1;
    else
      flag := 0;
    end if;
  END add_user;
  
  PROCEDURE change_user_details(in_birthday IN iuser.birthday%type := null,in_email IN iuser.email%type,in_token IN iuser.token%type,flag OUT number) 
  IS
  email_format number(1);
  user_id_count iuser.id%type;
  BEGIN
    select count(1) into email_format from dual where regexp_like(in_email,'^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$');
    select count(*) into user_id_count from iuser where token = in_token;
    if(user_id_count = 1 and email_format = 1) 
    then 
      update iuser set email=in_email , birthday=in_birthday where token = in_token;
      commit;
      flag := 1;
    else
      flag := 0;
    end if;
  END change_user_details;
  
  PROCEDURE bug_drug(in_drug_id IN drug.id%type,in_amount IN BUY_RECORD.AMOUNT%type,in_token IN iuser.token%type,flag OUT number)
  IS
  drug_count number(1);
  user_count number(1);
  iuser_id iuser.id%type;
  BEGIN
    select count(*) into drug_count from drug where id = in_drug_id;
    select count(*) into user_count from iuser where token = in_token;
    if(drug_count = 1 and user_count = 1 and in_amount > 0) then
      select id into iuser_id from iuser where token = in_token;
      insert into buy_record(idate,user_id,drug_id,amount) values(sysdate,iuser_id,in_drug_id,in_amount);
      flag := 1;
      commit;
    else
      flag := 0;
    end if;
  END bug_drug;

END IDRUG;