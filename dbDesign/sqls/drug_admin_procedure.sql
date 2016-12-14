

CREATE OR REPLACE PROCEDURE export_drug
 AS
outfile utl_file.file_type;
BEGIN
  outfile := utl_file.fopen('UTLEXPORTPATH','drug.txt','W');
    for rec in (SELECT "A1"."COLUMN1" "COLUMN1" FROM "DRUG_ADMIN"."TABLE1" "A1")
    loop
       utl_file.put_line(outfile, rec.COLUMN1);
    end loop;
    utl_file.fclose(outfile);
END export_drug;

exec export_drug;



--IF (l_cnt<>1) THEN RAISE_APPLICATION_ERROR( -20002,
--CASE
--WHEN :new.job_id = :old.job_id
--THEN 'Salary modification invalid'
--ELSE 'Job reassignment puts salary out of range'
--END ); END IF;

-- use case when

--grant select on squence to user