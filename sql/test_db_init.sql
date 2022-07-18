
-- First drop any existing database and user
DROP DATABASE IF EXISTS db_shoppr_test; 
DROP USER IF EXISTS 'shopprtestuser'@'%';

create database db_shoppr_test; -- Creates the new database
create user 'shopprtestuser'@'%' identified by 'ShopprUserTestPassword'; -- Creates the user
grant all on db_shoppr_test.* to 'shopprtestuser'@'%'; -- Gives all privileges to the new user on the newly created database
