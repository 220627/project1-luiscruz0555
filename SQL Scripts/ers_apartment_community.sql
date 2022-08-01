--ROLES START HERE

CREATE TABLE roles (
role_id serial PRIMARY KEY,
role_name TEXT,
role_salary int

);

INSERT INTO roles (role_name, role_salary)
VALUES ('Manager',70000),('Asst Manager',42000),('Leasing Agent',36000),('Maintenance',48000);


--REIMBURSEMENT TYPE STARTS HERE

CREATE TABLE reimbursement_type (

reimb_type_id serial PRIMARY KEY,
reimb_type TEXT

);

INSERT INTO reimbursement_type (reimb_type)
VALUES ('LODGING'),('TRAVEL'),('FOOD'),('OTHER');

DROP TABLE reimbursement_type;



--REIMBURSEMENT STATUS STARTS HERE

CREATE TABLE reimbursement_status (

reimb_status_id serial PRIMARY KEY,
reimb_status TEXT

);

INSERT INTO reimbursement_status (reimb_status)
VALUES ('SUBMITTED'),('APPROVED'),('REJECTED');

DROP TABLE reimbursement_status;




--USERS STARTS HERE

CREATE TABLE users (

user_id serial PRIMARY KEY,
username TEXT UNIQUE,
PASSWORD TEXT,
first_name TEXT,
last_name TEXT,
email TEXT UNIQUE,
role_id_fk int REFERENCES roles(role_id)

);

INSERT INTO users (username,PASSWORD,first_name,last_name,email,role_id_fk)
VALUES ('miriam22', 'psasword', 'Miriam','Marquez','mmarquez@apartment.com',1),
	   ('laurag19','password','Laura','Garcia','laurgarc44@apartment.com',2),
	   ('jamiem','password','Jamie','Moreno','jjmemo@apartment.com',3),
	   ('luisc','password','Luis','Cruz','luisc@apartment.com',3),
	   ('juanoo','password','Juan','Ontiveros','juanonti@apartment.com',4);

DROP TABLE users;




--REIMBURSEMENTS STARTS HERE

CREATE TABLE reimbursement (

reimb_id serial PRIMARY  KEY,
reimb_amount decimal (6,2),
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description TEXT,
reimb_author_fk int REFERENCES users(user_id),
reimb_resolver_fk int REFERENCES users(user_id),
reimb_status_id_fk int REFERENCES reimbursement_status(reimb_status_id),
reimb_type_id_fk int REFERENCES reimbursement_type(reimb_type_id)

);

DROP TABLE reimbursement;

SELECT * FROM reimbursement WHERE reimb_resolved IS NULL;
