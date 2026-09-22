package pe.edu.pucp.softprog.rrhh.model;

import java.util.Date;

public class Empleado extends Persona{
    private Area area;
    private CuentaUsuario cuentaUsuario;
    private String cargo;
    private double sueldo;
    private boolean activo;

    public Empleado(){};

    public Empleado(String DNI, String nombre, String apellidoPaterno, char genero
            , Date fechaNacimiento, String cargo, double sueldo, boolean activo) {
        super(DNI, nombre, apellidoPaterno, genero, fechaNacimiento);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = activo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
