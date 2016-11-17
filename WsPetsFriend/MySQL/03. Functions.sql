use PetsFriend;

drop function if exists `pet_Max`;
drop function if exists  `PetServices_Max`;

delimiter //
create function `pet_Max`( _dni char(8) )returns char(5)
begin
	declare maxPets int;
    declare newIdPets char(5);
    
	if Not Exists(select pet_id from pets where dni = _dni) Then
       set maxPets = 0;
	else
		set maxPets=  (select substring(max(pet_id), 2,4) from pets where dni = _dni);
	end if;
    
    set maxPets =maxPets + 1;
	set newIdPets = concat('P', LPAD(maxPets, 4,'0'));

	return newIdPets;
    
end //

delimiter //
create function `PetService_Max`( _pet_id char(5) )returns int
begin
	declare maxPetService int;
    declare newIdPetService int;
    
	if Not Exists(select PetService_id from PetServices where pet_id= _pet_id) Then
       set maxPetService = 0;
	else
		set maxPetService=  (select max(PetService_id)  from PetServices where pet_id= _pet_id);
	end if;
    
    set maxPetService =maxPetService + 1;
	set newIdPetService = maxPetService ;

	return newIdPetService;
    
end //


delimiter //
create function `Service_Max`()returns int
begin
	declare maxService int;
    declare newIdService int;
    
	if (select count(1) from Services) = 0 Then
       set maxService = 0;
	else
		set maxService=  (select max(Service_id)  from Services);
	end if;
    
    set maxService =maxService + 1;
	set newIdService = maxService ;

	return newIdService;
    
end //
