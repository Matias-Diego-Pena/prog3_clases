package pe.edu.pucp.softprog.main;


import pe.edu.pucp.softprog.config.DBManager;
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

        /* ya no se tiene que hace esta cosa grande
        try {
            Connection con = DBManager.getInstance().getConnection();

            //para ejecutar alguna instruccion dentro de la base datos
            Statement st = con.createStatement();
            //indicamos la instruccion
            String sql = "INSERT INTO area(nombre, activa) VALUES ('"
                    +area.getNombre() + "',1)";

            //ejecutar la instruccion

            int resultado = st.executeUpdate(sql);

            //verificamos
            if (resultado == 1){
                System.out.println("el area: " + area.getNombre() + " se registro " +
                        "en la base de datos");
            } else {
                System.out.println("hubo un error al registrar");
            }
            //cerrar la conexion
            con.close();
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
         */

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









        //este ya no cuenta xd
        /*
        try {
            Connection con = DBManager.getInstance().getConnection();

            Statement st = con.createStatement();
            String sql = "SELECT id_area, nombre FROM area WHERE activa = 1";
            //cuando es select es excecute query,
            // devuelve un tipo resource(un CURSOR)
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                // envez de esto es mejor otra cosa
                //int idArea = rs.getInt("id_area");
                //String nombre = rs.getString("nombre");
                //System.out.println(idArea + ". " + nombre);
                //
                Area areaTemp = new Area();
                areaTemp.setIdArea(rs.getInt("id_area"));
                areaTemp.setNombre(rs.getString("nombre"));
                System.out.println(areaTemp.getIdArea() + ". " + areaTemp.getNombre());
            }
            rs.close();
            con.close();

        } catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        */

    }
}
