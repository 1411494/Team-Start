
drop database PetsFriend;
create database PetsFriend;

use  PetsFriend;

create table persons
(
	dni				char(8),
	first_name		varchar(50),
	last_name		varchar(50),	
	email			varchar(50),
	address			varchar(80),
	phone_number 	varchar(12),
	birth_date		date,
	status			bit,
    
    PRIMARY KEY(dni)
);

create table users
(
	dni				char(8),
    user_name		varchar(8),
    password		varchar(8),
    type			char(1),
    status			bit,
    
   PRIMARY KEY(dni),    
   FOREIGN KEY(dni) REFERENCES persons(dni)
);

create table pets
(
	pet_id			char(5),
	dni				char(8),
	pet_name		varchar(20),
	breed			varchar(20),  /* Raza */
	hair_color		varchar(20),  /* Color de pelo */
	birth_date		date,
    image 			varchar(250),
	status			bit ,

   PRIMARY KEY(pet_id),    
   FOREIGN KEY(dni) REFERENCES users(dni) 

);

CREATE TABLE Services 
(
    service_id  	int,
    description		varchar(20),
    Price 			double,
    status 			bit,
    
   PRIMARY KEY(service_id)  
);


create table PetsServices
(
	PetService_id	int,
	pet_id			char(5),
	service_id		int,
    name_service	varchar(20),
	weight			varchar(10),
	date			date,
	next_date		date,
    price			double,
    delivery		bit,
    observation	    varchar(250),
    status			bit,
    
  PRIMARY KEY(PetService_id)  ,
  FOREIGN KEY(pet_id) REFERENCES pets(pet_id),
  FOREIGN KEY(service_id) REFERENCES Services(service_id) 
);


