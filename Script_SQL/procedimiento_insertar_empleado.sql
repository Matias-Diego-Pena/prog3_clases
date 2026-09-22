DELIMITER $
CREATE PROCEDURE INSERTAR_EMPLEADO (
	out _id_empleado INT,
    IN _fid_area INT,
	IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(45),
    IN _apellido VARCHAR(45),
    IN _genero char,
    in _fecha_nacimiento DATE,
    in _cargo varchar(45),
    in _sueldo decimal(10,2)
)
BEGIN

	INSERT INTO persona(DNI, nombre, apellido_paterno, genero, fecha_nacimiento) 
VALUES(_DNI, _nombre, _apellido, _genero, _fecha_nacimiento);


SET _id_empleado = @@last_insert_id;
INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo,activo)
VALUES (_id_empleado,_fid_area,_cargo,_sueldo,1);

END$


DELIMITER $
CREATE PROCEDURE INSERTAR_CLIENTE (
	out _id_cliente INT,
	IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(45),
    IN _apellido VARCHAR(45),
    IN _genero char,
    in _fecha_nacimiento DATE,
    in _linea_credito decimal(10,2),
    in _categoria enum('STANDARD','VIP','PALTINIUM')
)
BEGIN

	INSERT INTO persona(DNI, nombre, apellido_paterno, genero, fecha_nacimiento) 
VALUES(_DNI, _nombre, _apellido, _genero, _fecha_nacimiento);


SET _id_cliente = @@last_insert_id;
INSERT INTO cliente(id_cliente,linea_credito,categoria)
VALUES (_id_cliente,_linea_credito,_categoria);

END$

DELIMITER $
CREATE PROCEDURE LISTA_CLIENTES_X_DNI_CLIENTE(
	IN _DNI_NOMBRE VARCHAR(45)
)
BEGIN
	SELECT * 
    FROM persona p INNER JOIN cliente c
    ON c.id_cliente=p.id_persona
    WHERE p.DNI LIKE CONCAT('%',_DNI_NOMBRE,'%') OR
    CONCAT(p.nombre,p.apellido_paterno) LIKE CONCAT('%',_DNI_NOMBRE,'%');
END$

call INSERTAR_CLIENTE(@id_cliente,'48321902','JOSE','PARRA','M','2007-02-02',5000,'VIP');
call INSERTAR_EMPLEADO(@id_empleado,1,'83751211','MANUEL','TUPIA','M','1987-10-05','JEFE DE VENTAS',5500);
