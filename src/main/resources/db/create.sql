SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teas (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 price VARCHAR,
 image VARCHAR,
 type VARCHAR,
 sourceCountry VARCHAR
)