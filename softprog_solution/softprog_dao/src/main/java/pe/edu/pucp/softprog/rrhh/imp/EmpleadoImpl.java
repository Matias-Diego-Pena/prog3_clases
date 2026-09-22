package pe.edu.pucp.softprog.rrhh.imp;

import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmpleadoImpl implements EmpleadoDAO {


    @Override
    public List<Empleado> buscarPorDNI(String DNI) {
        return List.of();
    }

    @Override
    public int insertar(Empleado empleado) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql1 = "INSERT INTO persona(DNI, nombre, apellido_paterno,genero,fecha_nacimiento) \n" +
                "VALUES('"+empleado.getDNI()+
                "', '"+empleado.getNombre()+
                "','"+ empleado.getApellidoPaterno()+
                "','"+empleado.getGenero()+
                "','"+sdf.format(empleado.getFechaNacimiento())+"');";


        String sql2 = "SELECT @@last_insert_id AS id;";
        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola


        try(Connection con = DBManager.getInstance().getConnection();
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement()){

            st1.executeUpdate(sql1);
            ResultSet rs = st2.executeQuery(sql2);
            rs.next();
            empleado.setIdPersona(rs.getInt("id"));

            String sql3 = "INSERT INTO empleado" +
                    "(id_empleado,fid_area,cargo,sueldo,activo) " +
                    "VALUES (" +
                    ""+empleado.getIdPersona()+"," +
                    ""+empleado.getArea().getIdArea()+"," +
                    "'"+empleado.getCargo()+"'," +
                    ""+empleado.getSueldo()+"," +
                    "1);";

            return st3.executeUpdate(sql3);
        }catch (Exception ex){
            System.out.println("ERROR al insertar Empleado: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int modificar(Empleado empleado) {
        return 0;
    }

    @Override
    public int eliminar(int idEmpleado) {
        return 0;
    }

    @Override
    public Empleado buscarPorid(int idEmpleado) {
        return null;
    }

    @Override
    public List<Empleado> listarTodos() {
        return List.of();
    }

}
