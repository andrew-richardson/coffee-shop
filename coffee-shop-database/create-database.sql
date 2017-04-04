-- DROP
DROP SCHEMA IF EXISTS coffee_shop CASCADE;

-- CREATE schema
CREATE SCHEMA coffee_shop
  AUTHORIZATION coffee_admin;

-- CREATE table
CREATE TABLE coffee_shop.coffee
(
  id UUID NOT NULL,
  name TEXT NOT NULL,
  price NUMERIC NOT NULL,
  CONSTRAINT coffee_pk PRIMARY KEY (id)
)
WITH
(
  OIDS=FALSE
);
ALTER TABLE coffee_shop.coffee
    OWNER TO coffee_admin;

-- CREATE uuid generator
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO coffee_shop.coffee (id, name, price) VALUES (uuid_generate_v4(),'regular',1.00);
INSERT INTO coffee_shop.coffee (id, name, price) VALUES (uuid_generate_v4(),'mocha',3.00);
INSERT INTO coffee_shop.coffee (id, name, price) VALUES (uuid_generate_v4(),'latte',3.00);
INSERT INTO coffee_shop.coffee (id, name, price) VALUES (uuid_generate_v4(),'cappuccino',3.00);
