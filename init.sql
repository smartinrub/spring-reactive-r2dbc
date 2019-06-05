CREATE USER admin WITH PASSWORD 'password123';
ALTER USER admin WITH SUPERUSER;
GRANT ALL PRIVILEGES ON DATABASE postgres TO admin;

CREATE TABLE hotel (
   id SERIAL PRIMARY KEY,
   name VARCHAR (255) NOT NULL
);
