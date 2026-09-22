package pe.edu.pucp.softprog.rrhh.model;

public class Area {
	private int idArea;
	private String nombre;
	private boolean activo;

	public Area(){};

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
}