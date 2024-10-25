DROP TABLE IF EXISTS ITEMS;

create table ITEMS(
  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  MAX_PRICE int,
  MIN_PRICE int,
  QUALITY int DEFAULT 25,
  PRIMARY KEY ( ID )
);