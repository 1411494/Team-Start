
use  PetsFriend;

drop procedure if exists `person_Action`;
drop procedure if exists `user_Action`;
drop procedure if exists `pet_Action`;
drop procedure if exists `Service_Action`;
drop procedure if exists `PetService_Action`;

delimiter //
create procedure  `person_Action`
(
	_dni			char(8),
	_first_name		varchar(50),
	_last_name		varchar(50),	
	_email			varchar(50),
	_address		varchar(80),
	_phone_number 	varchar(12),
	_birth_date		varchar(20),
	_status			bit
)
begin
	if not exists(select dni from persons where dni = _dni ) then
		insert into persons 
			values(	_dni,
					_first_name,
                    _last_name,
                    _email,
                    _address, 
                    _phone_number,
                    _birth_date,
                    _status);
	ELSE
		if(_status = 1) Then
			update persons
				set first_name 	= 	_first_name,
					last_name 	= 	_last_name,
					email		=	_email,
					address		=	_address,
					phone_number=	_phone_number,
					birth_date	=	_birth_date,
					status		=	_status
			where dni = _dni;
		else	
			update persons
				set status		=	_status
			where dni = _dni;
        end if;
    end if;		
END //

delimiter //
create procedure  `user_Action`
(
	_dni			char(8),
    _user_name		varchar(8),
    _password		varchar(8),
    _type			char(1),
    _status			bit
)
begin	
	if not exists(select dni from users where dni = _dni ) then
		insert into users
			values (_dni,
					_user_name,
                    _password,
                    _type,
                    _status);
	else
		if(_status = 1) Then
			update users
				set user_name 	= 	_user_name,
					password	=	_password,
                    type		= 	_type,
                    status		= 	_status
			where	dni = _dni;
        Else
			update users
				set status		= 	_status
			where	dni = _dni;
        end if;
    
    end if;
END //



delimiter //
create procedure  `pet_Action`
(
	_pet_id			char(5),
	_dni			char(8),
	_pet_name		varchar(20),
	_breed			varchar(20),  /* Raza */
	_hair_color		varchar(20),  /* Color de pelo */
	_birth_date		varchar(20),
    _image			varchar(250),
	_status			bit

)
begin
	declare _newIdPets char(5);
	if not exists(select pet_id from pets where dni = _dni 
											and pet_id= _pet_id ) then
    
        set _newIdPets = (select pet_Max(_dni));
		insert into pets 
			values( _newIdPets,
					_dni,
                    _pet_name,
                    _breed,
                    _hair_color,
                    _birth_date,
                    _image,
                    _status);
	else	
		update pets
			set pet_name	= 	_pet_name,
				breed		=	_breed,
                hair_color	=	_hair_color,
                birth_date	=	_birth_date,
                image		= 	_image,
                status		=	_status
			where dni = _dni 
			and pet_id= _pet_id ;
	end if;
END //


delimiter //
create procedure  `service_Action`
(
    _service_id  	int,
    _description	varchar(20),
    _Price 			double,
    _status 		bit
)
begin
	declare _newIdService char(5);
	if not exists(select service_id from services where  service_id= _service_id ) then
                                            
      set _newIdService = (select Service_Max());

		insert into Services
			values (
                _service_id  	,
				_description	,
				_Price 			,
				_status 		
            );

	else	
		update Services
			set service_id		=	_service_id,
				description		= 	_description,
				Price			= 	_Price,
				status			=	_status
			where  service_id= _service_id ;
    
	end if;
END //


delimiter //
create procedure  `petService_Action`
(
	_PetService_id	int,
	_pet_id			char(5),
	_service_id		int,
    _name_service	varchar(20),
	_weight			varchar(10),
	_date			date,
	_next_date		date,
    _price			decimal,
    _delivery		bit,
    _observation	varchar(250),
    _status			bit

)
begin

	declare _newIdPetService char(5);
	if not exists(select PetService_id from petServices where  PetService_id= _PetService_id) then

		set _newIdPetService = (select PetService_Max(_pet_id)); 
        
        insert into petsServices
			values(
				_PetService_id	,
				_pet_id			,
				_service_id		,
				_name_service	,
				_weight			,
				_date			,
				_next_date		,
				_price			,
				_delivery		,
				_observation	,
				_status			
				);
	else
		
		update petServices
			set PetService_id	=	_PetService_id	,
				pet_id			=	_pet_id			,
				service_id		=	_service_id		,
				name_service	=	_name_service	,
				weight			=	_weight			,
				date			=	_date			,
				next_date		=	_next_date		,
				price			=	_price			,
				delivery		=	_delivery		,
				observation	=	_observation	,
				status			=	_status	
			where  PetService_id= _PetService_id;
    
    end if;
END //