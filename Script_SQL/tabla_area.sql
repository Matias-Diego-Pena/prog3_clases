drop table if exists empleado;
drop table if exists cliente;
drop table if exists persona;
drop table if exists area;



create table area (
	id_area int primary key auto_increment,
    nombre varchar(45),
    activa tinyint
)ENGINE=InnoDB;

CREATE TABLE persona (
	id_persona INT PRIMARY KEY AUTO_INCREMENT,
    DNI VARCHAR(8),
    nombre VARCHAR(35),
    apellido_paterno VARCHAR(45),
    genero CHAR,
    fecha_nacimiento DATE
) ENGINE=InnoDB;

CREATE TABLE empleado (
	id_empleado INT,
    fid_area INT,
    cargo VARCHAR (45),
    sueldo DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
    FOREIGN KEY(fid_area) REFERENCES area(id_area)
)ENGINE=InnoDB;

CREATE TABLE cliente (
	id_cliente INT,
    linea_credito DECIMAL(10,2),
    categoria ENUM('STANDARD', 'VIP','PLATINIUM'),
    PRIMARY KEY(id_cliente),
    FOREIGN KEY(id_cliente) REFERENCES persona(id_persona)
)ENGINE=InnoDB;

insert into area(nombre, activa) values ('RECURSOS HUMANNOS',1);
insert into area(nombre, activa) values ('FINANZAS',1);