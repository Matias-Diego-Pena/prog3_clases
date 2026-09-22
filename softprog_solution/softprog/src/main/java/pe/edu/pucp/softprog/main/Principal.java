package pe.edu.pucp.softprog.main;


import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.model.Area;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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



        try {
            Connection con = DBManager.getInstance().getConnection();

            Statement st = con.createStatement();
            String sql = "SELECT id_area, nombre FROM area WHERE activa = 1";
            //cuando es select es excecute query,
            // devuelve un tipo resource(un CURSOR)
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                /* envez de esto es mejor otra cosa
                int idArea = rs.getInt("id_area");
                String nombre = rs.getString("nombre");
                System.out.println(idArea + ". " + nombre);
                 */
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

    }
}
