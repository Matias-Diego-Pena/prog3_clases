package pe.edu.pucp.softprog.rrhh.imp;

import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.config.TransactionContext;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmpleadoImpl implements EmpleadoDAO {


    @Override
    public List<Empleado> buscarPorDNI(String DNI) {
        return List.of();
    }



    /*este es para llamar a un procedimiento
    @Override
    public int insertar(Empleado empleado) {
        String sql =
                "{call INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?)}";

        try(
            Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql);){

            cs.registerOutParameter("_id_empleado", Types.INTEGER);
            cs.setInt("_fid_area",empleado.getArea().getIdArea());
            cs.setString("_DNI",empleado.getDNI());
            cs.setString("_nombre",empleado.getNombre());
            cs.setString("_apellido",empleado.getApellidoPaterno());
            cs.setString("_genero",String.valueOf(empleado.getGenero()));
            cs.setDate("_fecha_nacimiento",
                    new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setString("_cargo",empleado.getCargo());
            cs.setDouble("_sueldo",empleado.getSueldo());
            cs.executeUpdate();
            empleado.setIdPersona(cs.getInt("_id_empleado"));
            return empleado.getIdPersona();
        }catch(Exception ex){
            System.out.println("ERROR al insertar Empleado: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
    */

    //este es con el prepared statement
    @Override
    public int insertar(Empleado empleado) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String sql1 = "INSERT INTO persona" +
                "(DNI, nombre, apellido_paterno,genero,fecha_nacimiento) \n" +
                "VALUES(?,?,?,?,?);";

        String sql2 = "SELECT @@last_insert_id AS id;";

        String sql3 = "INSERT INTO empleado" +
                "(id_empleado,fid_area,cargo,sueldo,activo) " +
                "VALUES (?,?,?,?,1);";

        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola

        //ahora hacemos 2 try, uno para la conexion y otro para los statement
        try{
            Connection con = TransactionContext.getConnection();
            con.setAutoCommit(false);
            try(PreparedStatement pst1 = con.prepareStatement(sql1);
                PreparedStatement pst2 = con.prepareStatement(sql2);
                PreparedStatement pst3 = con.prepareStatement(sql3)){

                //registro persona
                pst1.setString(1,empleado.getDNI());
                pst1.setString(2,empleado.getNombre());
                pst1.setString(3,empleado.getApellidoPaterno());
                pst1.setString(4,String.valueOf(empleado.getGenero()));
                pst1.setDate(5, new java.sql.Date(
                        empleado.getFechaNacimiento().getTime()));
                pst1.executeUpdate();
                //captura del ID
                ResultSet rs = pst2.executeQuery();
                rs.next();
                empleado.setIdPersona(rs.getInt("id"));
                //registrar empleado
                pst3.setInt(1,empleado.getIdPersona());
                pst3.setInt(2,empleado.getArea().getIdArea());
                pst3.setString(3,empleado.getCargo());
                pst3.setDouble(4,empleado.getSueldo());
                pst3.executeUpdate();
                //confirmar cmabios
                con.commit();
                return empleado.getIdPersona();
            }catch (Exception ex){
                con.rollback();
            throw new RuntimeException(ex);
            }
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
