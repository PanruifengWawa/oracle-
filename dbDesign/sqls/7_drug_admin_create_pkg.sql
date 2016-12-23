create or replace PACKAGE IDRUG AS 

FUNCTION login_get_token ( in_user_name IN iuser.user_name%type , in_password IN iuser.password%type)
RETURN iuser.token%type;

PROCEDURE change_user_details(in_birthday IN iuser.birthday%type := null,in_eamil IN iuser.email%type,in_token IN iuser.token%type,flag OUT number);

PROCEDURE bug_drug(in_drug_id IN drug.id%type,in_amount IN BUY_RECORD.AMOUNT%type,in_token IN iuser.token%type,flag OUT number);
END IDRUG;


