package pe.edu.pucp.softprog.main;


import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.model.Area;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Principal {
    public static void main(String[] args){
        System.out.println("hola");

        Area area = new Area();
        area.setNombre("INVENTARIOS");
        System.out.println(area.getNombre());

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


    }
}
