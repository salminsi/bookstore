DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS appuser;

CREATE TABLE category (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(150)
);

INSERT INTO category (name) 
VALUES 
('Scifi'), 
('Dokkari');


CREATE TABLE book (
id BIGSERIAL PRIMARY KEY,
title VARCHAR(250) NOT NULL,
author VARCHAR(250) NOT NULL,
publicationyear INT NOT NULL,
isbn INT,
price INT,
categoryid BIGINT REFERENCES category(id)
);

INSERT INTO book (title, author, publicationyear, isbn, price, categoryid)
VALUES 
('Kukko Kiekuu', 'Matti Meikalainen', 2021, 87489846, 35, 2),
('Javaa vain', 'Maija Maikalainen', 2017, 86546846, 39, null),
('Minakin Javaan', 'Harri Hepuli', 2014, 94319846, 18, 1);


CREATE TABLE appuser (
id BIGSERIAL PRIMARY KEY,
username VARCHAR(150) NOT NULL,
app_password VARCHAR(500) NOT NULL,
app_role VARCHAR(10) NOT NULL
);

INSERT INTO appuser (username, app_password, app_role)
VALUES
('admin', '$2a$10$R.ntvNy3FSQEgXLsNJh5xumIPlabSrtdBRMIzZAv8A0K.P.966VWW', 'admin'),
('user', '$2a$10$cKAXCXi3GdELDkJXkVbyZejKsnVP54lto0.MLzbvHYjGIoErpkGWO', 'user');
