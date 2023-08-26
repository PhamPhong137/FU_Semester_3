1.Install postgresql
refer: http://w3resource.com/PostgreSQL/install-postgresql-on-linux-and-windows.php
2.In postgresql prompt
create database "dbname"
3.\q
4.psql -h ip -U postgres dbname < sqlexbackup.sql (sqlexbackup.sql is for sqlex database, empexbackup.sql is for employee database
  and northwindexbackup.sql is for northwind database)
sqlex_backup.pgsql must be with proper path. For local machine ip is 127.0.0.1
5.psql -h ip -U postgres dbname
6.CREATE ROLE username WITH LOGIN ENCRYPTED PASSWORD 'password';
7.GRANT CONNECT ON DATABASE dbname TO username;
8.GRANT USAGE ON SCHEMA public TO datasoft1;
9.GRANT SELECT ON ALL TABLES IN SCHEMA public TO username;
10.\q
11.psql -h ip -U username dbname
supply password for username
11.Start executing SQL commands now

