package pe.edu.pucp.softprog.gestclientes.model;

import pe.edu.pucp.softprog.rrhh.model.Persona;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

import java.util.List;

public class Cliente extends Persona {
    private double lineaCredito;
    private Categoria categoria;
    private List<OrdenVenta> ordenesVenta;

    public Cliente(){};

    public double getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<OrdenVenta> getOrdenesVenta() {
        return ordenesVenta;
    }

    public void setOrdenesVenta(List<OrdenVenta> ordenesVenta) {
        this.ordenesVenta = ordenesVenta;
    }
}
