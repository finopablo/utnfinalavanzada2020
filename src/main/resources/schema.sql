DROP DATABASE final;
CREATE DATABASE final;
USE final;

CREATE TABLE cities(iata_code varchar(3)  PRIMARY KEY,
                    city_name varchar(50) NOT NULL);
CREATE TABLE employees (id int  PRIMARY KEY,
                        name varchar(50) NOT NULL,
                        last_name varchar(50) NOT NULL,
                        age int,
                        city_iata_code varchar(3),
                        CONSTRAINT fk_employees_cities foreign KEY (city_iata_code) references cities(iata_code));