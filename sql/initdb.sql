create database db_shoppr; -- Creates the new database
create user 'shoppruser'@'%' identified by 'ShopprUserDevPassword'; -- Creates the user
grant all on db_shoppr.* to 'shoppruser'@'%'; -- Gives all privileges to the new user on the newly created database
