package pe.edu.pucp.softprog.ventas.model;

import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

import java.util.Date;
import java.util.List;

public class OrdenVenta {
    private int idVentaOrden;
    private double total;
    private Date fechaHora;
    private boolean activo;
    private Cliente cliente;
    private Empleado empleado;
    private List<LineaOrdenVenta> lineasOrdenVenta;

    public OrdenVenta (){};

    public int getIdVentaOrden() {
        return idVentaOrden;
    }

    public void setIdVentaOrden(int idVentaOrden) {
        this.idVentaOrden = idVentaOrden;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<LineaOrdenVenta> getLineasOrdenVenta() {
        return lineasOrdenVenta;
    }

    public void setLineasOrdenVenta(List<LineaOrdenVenta> lineasOrdenVenta) {
        this.lineasOrdenVenta = lineasOrdenVenta;
    }
}
