CREATE DATABASE eventdb;

CREATE USER 'eventdb'@'localhost' IDENTIFIED BY 'password';

GRANT ALL on eventdb.* TO 'eventdb'@'localhost';

FLUSH PRIVILEGES;

create table Guests (
    guest_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR (30),
    PRIMARY KEY (guest_id)
);

create table Event (
    event_id INT NOT NULL AUTO_INCREMENT,
    event_name VARCHAR(30),
    PRIMARY KEY (event_id)
);

