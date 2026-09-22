drop table if exists area;

create table area (
	id_area int primary key auto_increment,
    nombre varchar(45),
    activa tinyint
)ENGINE=InnoDB;

insert into area(nombre, activa) values ('RECURSOS HUMANNOS',1);
insert into area(nombre, activa) values ('FINANZAS',1);