--------------------------------------------------------
--  File created - Pazartesi-Haziran-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MEBITECH"."DEP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 50 START WITH 1001 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EMP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MEBITECH"."EMP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 50 START WITH 1001 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MEE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MEBITECH"."MEE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 50 START WITH 1001 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table DEPARTMENT
--------------------------------------------------------

  CREATE TABLE "MEBITECH"."DEPARTMENT" 
   (	"ID" NUMBER(10,0), 
	"D_DESCRIPTION" VARCHAR2(255 CHAR), 
	"D_NAME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "MEBITECH"."EMPLOYEE" 
   (	"ID" NUMBER(10,0), 
	"E_NAME" VARCHAR2(255 CHAR), 
	"E_SALARY" FLOAT(126), 
	"E_SURNAME" VARCHAR2(255 CHAR), 
	"DEPARTMENT_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEETING
--------------------------------------------------------

  CREATE TABLE "MEBITECH"."MEETING" 
   (	"ID" NUMBER(10,0), 
	"M_DESCRIPTION" VARCHAR2(255 CHAR), 
	"M_NAME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEETING_DEPARTMENT
--------------------------------------------------------

  CREATE TABLE "MEBITECH"."MEETING_DEPARTMENT" 
   (	"MEETING_ID" NUMBER(10,0), 
	"DEPARTMENT_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into MEBITECH.DEPARTMENT
SET DEFINE OFF;
Insert into MEBITECH.DEPARTMENT (ID,D_DESCRIPTION,D_NAME) values ('1','for Salesmans','Accounting');
Insert into MEBITECH.DEPARTMENT (ID,D_DESCRIPTION,D_NAME) values ('2','for Engineers','Engineering');
REM INSERTING into MEBITECH.EMPLOYEE
SET DEFINE OFF;
Insert into MEBITECH.EMPLOYEE (ID,E_NAME,E_SALARY,E_SURNAME,DEPARTMENT_ID) values ('1','Ali','12','Cam','1');
Insert into MEBITECH.EMPLOYEE (ID,E_NAME,E_SALARY,E_SURNAME,DEPARTMENT_ID) values ('2','Can','12','Güt','2');
REM INSERTING into MEBITECH.MEETING
SET DEFINE OFF;
Insert into MEBITECH.MEETING (ID,M_DESCRIPTION,M_NAME) values ('1','for Oracle','Oracle Meeting');
Insert into MEBITECH.MEETING (ID,M_DESCRIPTION,M_NAME) values ('2','for Accountants','Accountant Meeting');
REM INSERTING into MEBITECH.MEETING_DEPARTMENT
SET DEFINE OFF;
Insert into MEBITECH.MEETING_DEPARTMENT (MEETING_ID,DEPARTMENT_ID) values ('1','2');
Insert into MEBITECH.MEETING_DEPARTMENT (MEETING_ID,DEPARTMENT_ID) values ('1','1');
Insert into MEBITECH.MEETING_DEPARTMENT (MEETING_ID,DEPARTMENT_ID) values ('2','2');
Insert into MEBITECH.MEETING_DEPARTMENT (MEETING_ID,DEPARTMENT_ID) values ('2','1');
--------------------------------------------------------
--  Constraints for Table DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."DEPARTMENT" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MEBITECH"."DEPARTMENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEETING_DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."MEETING_DEPARTMENT" MODIFY ("DEPARTMENT_ID" NOT NULL ENABLE);
  ALTER TABLE "MEBITECH"."MEETING_DEPARTMENT" MODIFY ("MEETING_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEETING
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."MEETING" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MEBITECH"."MEETING" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."EMPLOYEE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MEBITECH"."EMPLOYEE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."EMPLOYEE" ADD CONSTRAINT "FK3U0222096FY1KHEONUKCQ7MIX" FOREIGN KEY ("DEPARTMENT_ID")
	  REFERENCES "MEBITECH"."DEPARTMENT" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MEETING_DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "MEBITECH"."MEETING_DEPARTMENT" ADD CONSTRAINT "FKM1BY0JNYMSM2COHD1NEDG7KXX" FOREIGN KEY ("DEPARTMENT_ID")
	  REFERENCES "MEBITECH"."DEPARTMENT" ("ID") ENABLE;
  ALTER TABLE "MEBITECH"."MEETING_DEPARTMENT" ADD CONSTRAINT "FKT79TAV3FMP1HKPNCXKBHSFLI3" FOREIGN KEY ("MEETING_ID")
	  REFERENCES "MEBITECH"."MEETING" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "MEBITECH"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password & expire date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "MEBITECH"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := '1QQ2OH0W2KN01OBQLX1JFRNJKVENR5';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/
