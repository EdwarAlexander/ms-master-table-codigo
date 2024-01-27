-- creacion de la tabla cliente
create table customers(
    id_customer serial primary key,
	name varchar(100) not null,
	lastname varchar(100) not null,
	telephone varchar(20),
	email varchar(50) unique,
	document varchar(20) unique,
	user_create VARCHAR(45),
    date_create TIMESTAMP,
    user_modif VARCHAR(45),
    date_modif TIMESTAMP
);
--documentacion de la tabla cliente
comment on table customers is 'Tabla que guarda la información del cliente';
comment on column customers.id_customer is 'Identificador unico de la tabla cliente';
comment on column customers.name is 'Nombre del cliente';
comment on column customers.lastname is 'Apellidos del cliente';
comment on column customers.telephone is 'Celular del cliente';
comment on column customers.email is 'Correo del cliente';
comment on column customers.document is 'Nro de documento del cliente';
comment on column customers.user_create is 'Usuario que crea el registro';
comment on column customers.date_create is 'Fecha de creacion del registro';
comment on column customers.user_modif is 'Usuario que actualiza el registro';
comment on column customers.date_modif is 'Fecha de actualizacion del registro';

-- creacion de la tabla publicidad
create table publicity(
    id_publicity serial primary key,
    name varchar(100) not null,
    status int not null,
    user_create VARCHAR(45),
    date_create TIMESTAMP,
    user_modif VARCHAR(45),
    date_modif TIMESTAMP,
    user_del VARCHAR(45),
    date_del TIMESTAMP
);
-- documentacion de la tabla publicidad
comment on table publicity is 'tabla que guarda la información de las publicidades';
comment on column publicity.id_publicity is 'Identificador unico de la tabla publicidad';
comment on column publicity.name is 'Nombre de la publicidad';
comment on column publicity.status is 'Estado de la publicidad';
comment on column publicity.user_create is 'Usuario que crea el registro';
comment on column publicity.date_create is 'Fecha de creación del registro';
comment on column publicity.user_modif is 'Usuario que modifica el registro';
comment on column publicity.date_modif is 'Fecha de actualización el registro';
comment on column publicity.user_del is 'Usuario que elimina el registro';
comment on column publicity.date_del is 'Fecha de eliminación del registro';