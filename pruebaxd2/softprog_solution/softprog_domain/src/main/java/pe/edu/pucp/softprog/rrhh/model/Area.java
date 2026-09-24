package pe.edu.pucp.softprog.rrhh.model;

import java.util.ArrayList;
import java.util.List;

public class Area {
	private int idArea;
	private List<Empleado> empleados;
	private String nombre;
	private boolean activo;

	public Area(){};

	public Area(String nombre) {
		this.nombre = nombre;
		this.empleados = new ArrayList<>();
	}

	public Area(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}

	public Area(int idArea, String nombre, boolean activo) {
		this.idArea = idArea;
		this.nombre = nombre;
		this.activo = activo;
	}


	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public List<Empleado> getEmpleados() {return empleados;}

	public void setEmpleados(List<Empleado> empleados) {this.empleados = empleados;}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void agregarEmpeado (Empleado emp){
		this.empleados.add(emp);
	}
}