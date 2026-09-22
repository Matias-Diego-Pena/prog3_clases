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


call INSERTAR_EMPLEADO(@id_empleado,1,'83751211','MANUEL','TUPIA','M','1987-10-05','JEFE DE VENTAS',5500);
