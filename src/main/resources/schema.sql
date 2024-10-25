DROP TABLE IF EXISTS CATEGORIES;

CREATE TABLE CATEGORIES (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(100) NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS ITEMS;

create table ITEMS(
  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  MAX_PRICE int,
  MIN_PRICE int,
  QUALITY int DEFAULT 25,
  CATEGORY_ID INT,
  PRIMARY KEY (ID),
  FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(ID)
);
