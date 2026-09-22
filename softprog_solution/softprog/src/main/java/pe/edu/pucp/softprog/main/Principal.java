package pe.edu.pucp.softprog.main;


import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.softprog.gestclientes.imp.ClienteImpl;
import pe.edu.pucp.softprog.gestclientes.model.Categoria;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.imp.AreaImpl;
import pe.edu.pucp.softprog.rrhh.imp.EmpleadoImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args){
        System.out.println("hola");

        Area area = new Area();
        area.setNombre("DIRECCION ACADEMICA");
        System.out.println(area.getNombre());


        AreaDAO daoArea = new AreaImpl();

        if (daoArea.insertar(area)!=0){
            System.out.println("El area " + area.getNombre()
                    + " se registro correctamente");
        }

        List<Area> areas = daoArea.listarTodos();

        for (Area a: areas){
            System.out.println(a.getIdArea()+". "
            +a.getNombre());
        }

        Area areaModificar = areas.get(1);
        areaModificar.setNombre("FISICA");
        if(daoArea.modificar(areaModificar)!=0){
            System.out.println("se modifico el area correctamente");
        }

        if (daoArea.eliminar(2)!=0){
            System.out.println("se elimino el area");
        }

        Area areaBuscar = daoArea.buscarPorid(1);

        System.out.println(areaBuscar.getIdArea()+". "
                + areaBuscar.getNombre());




        Empleado empleado  = new Empleado("87132712","DIEGO"
        ,"OSORIO",'M',new Date(),"INFORMATICO"
                ,2500,true);

        empleado.setArea(areas.get(areas.size()-1));

        EmpleadoDAO daoEmpleado = new EmpleadoImpl();
        if(daoEmpleado.insertar(empleado)!=0){
            System.out.println("se agrego Empleado a la tabla");
        }





        Cliente cliente = new Cliente("97133456","MARIA","GUEVARA"
               ,'F', new Date(),2100.00, Categoria.STANDARD);


        ClienteDAO daoCliente = new ClienteImpl();
        
        if(daoCliente.insertar(cliente)!=0){
            System.out.println("Se inserto el registro del Cliente");
        }


        List<Cliente> clientes = daoCliente.listarPorDNINombre("PA");
        for (Cliente c: clientes){
            System.out.println(c.getIdPersona()+". "+
                    c.getNombre()+" "+ c.getApellidoPaterno());
        }



    }
}
