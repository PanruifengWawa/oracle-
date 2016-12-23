-- view of what user has bought
create or replace view user_buy_record as 
select u.id user_id,u.email email ,u.token token,drug.name drug_name,b_r.idate idate,drug.price price,b_r.amount amount, drug.price * b_r.amount drug_cost
from iuser u,buy_record b_r,drug drug
where u.id = b_r.user_id and drug.id = b_r.drug_id;