SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teas (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 price DOUBLE,
 image VARCHAR,
 type VARCHAR,
 sourceCountry VARCHAR
);

CREATE TABLE IF NOT EXISTS accoutrements (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  price DOUBLE,
  image VARCHAR,
  type VARCHAR,
  maker VARCHAR
);