----创建表空间
CREATE SMALLFILE TABLESPACE "T10" DATAFILE 'C:\APP\ALLAN\ORADATA\T10\t10.dbf' SIZE 10M AUTOEXTEND ON NEXT 1000K MAXSIZE UNLIMITED LOGGING EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT AUTO; 
--创建用户
CREATE USER "T10" PROFILE "DEFAULT" IDENTIFIED BY "*******" DEFAULT TABLESPACE "T10" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK;
--默认给用户授予连接角色
GRANT "CONNECT" TO "T10";
--给用户授权，scott用户下的全部表的操作权限
GRANT ALTER ON "SCOTT"."BONUS" TO "T10";
GRANT DELETE ON "SCOTT"."BONUS" TO "T10";
GRANT INDEX ON "SCOTT"."BONUS" TO "T10";
GRANT INSERT ON "SCOTT"."BONUS" TO "T10";
GRANT REFERENCES ON "SCOTT"."BONUS" TO "T10";
GRANT SELECT ON "SCOTT"."BONUS" TO "T10";
GRANT UPDATE ON "SCOTT"."BONUS" TO "T10";
GRANT ALTER ON "SCOTT"."DEPT" TO "T10";
GRANT DELETE ON "SCOTT"."DEPT" TO "T10";
GRANT INDEX ON "SCOTT"."DEPT" TO "T10";
GRANT INSERT ON "SCOTT"."DEPT" TO "T10";
GRANT REFERENCES ON "SCOTT"."DEPT" TO "T10";
GRANT SELECT ON "SCOTT"."DEPT" TO "T10";
GRANT UPDATE ON "SCOTT"."DEPT" TO "T10";
GRANT ALTER ON "SCOTT"."EMP" TO "T10";
GRANT DELETE ON "SCOTT"."EMP" TO "T10";
GRANT INDEX ON "SCOTT"."EMP" TO "T10";
GRANT INSERT ON "SCOTT"."EMP" TO "T10";
GRANT REFERENCES ON "SCOTT"."EMP" TO "T10";
GRANT SELECT ON "SCOTT"."EMP" TO "T10";
GRANT UPDATE ON "SCOTT"."EMP" TO "T10";
GRANT ALTER ON "SCOTT"."SALGRADE" TO "T10";
GRANT DELETE ON "SCOTT"."SALGRADE" TO "T10";
GRANT INDEX ON "SCOTT"."SALGRADE" TO "T10";
GRANT INSERT ON "SCOTT"."SALGRADE" TO "T10";
GRANT REFERENCES ON "SCOTT"."SALGRADE" TO "T10";
GRANT SELECT ON "SCOTT"."SALGRADE" TO "T10";
GRANT UPDATE ON "SCOTT"."SALGRADE" TO "T10";
---绑定DBA角色
GRANT "DBA" TO "T10";
ALTER USER "T10" DEFAULT ROLE ALL 
----------获取系统当前时间
select sysdate from dual;
-------创建UserInfo表
drop table userInfo;
create table UserInfo
(
  id         number,
  user_name  nvarchar2(30),
  createdate date default sysdate
);
---添加数据
insert into userinfo(id, user_name)values(1, 'accp');
insert into userinfo(id, user_name)values(2, '张三');
insert into userinfo(id, user_name)values(3, 'test');
insert into userinfo(id, user_name)values(4, 'test');
commit;
---select * from userInfo for update;

---字符串连接
select 'a'||'b'||'c' str1 from dual;
select concat('张三','abc') name from dual

---时间函数
select sysdate from dual;
---将时间转换为指定格式的字符串，一般在查询时使用
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual;
---将字符串转换为时间数据类型，一般在插入，修改记录时使用
select to_date('2017-07-09 03:34:24','yyyy-mm-dd hh24:mi:ss') from dual;
---获取间隔时间sysdate+1 指的是在当前时间的基础上+1天（24小时），添加小时的时候可以做转换，一小时=1/24
select (sysdate + 8/24) from dual;
---指定添加年,月，日，时，分，秒
select sysdate+ interval '1' year from dual;
select sysdate+ interval '1' month from dual;
select sysdate+ interval '1' day from dual;
select sysdate+ interval '1' hour from dual;
select sysdate+ interval '1' minute from dual;
select sysdate+ interval '1' second from dual;
--nvl nvl2 decode
select nvl(null,'100' ) from dual;
select nvl2(null,100,200 ) from dual;
select decode(4,1,'abc',2,'eee',3,'defalut','null') from dual;
