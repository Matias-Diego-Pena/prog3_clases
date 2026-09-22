package pe.edu.pucp.softprog.rrhh.imp;

import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AreaImpl implements AreaDAO {

    @Override
    public int insertar(Area area) {
        String sql = "INSERT INTO area(nombre,activa) " +
                "VALUES('"+area.getNombre()+"',1)";

        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola
        try(Connection con = DBManager.getInstance().getConnection();
            Statement st = con.createStatement()){
            return st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("ERROR al insertar Area: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int modificar(Area area) {
        String sql = "UPDATE area SET nombre ='"+
                area.getNombre()+"' WHERE id_area ="+area.getIdArea();

        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola
        try(Connection con = DBManager.getInstance().getConnection();
            Statement st = con.createStatement()){
            return st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("ERROR al insertar Area: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int eliminar(int idArea) {
        String sql = "UPDATE area SET activa = 0 WHERE id_area ="+idArea;

        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola
        try(Connection con = DBManager.getInstance().getConnection();
            Statement st = con.createStatement()){
            return st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("ERROR al insertar Area: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Area buscarPorid(int idArea) {
        Area area = null;
        String sql = "Select * FROM area WHERE id_area = " + idArea;

        //dentro del try ponemos la conexion para que cuando
        // termine se cierre sola
        try(Connection con = DBManager.getInstance().getConnection();
            Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(rs.getBoolean("activa"));
            }
            return area;
        }catch (Exception ex){
            System.out.println("ERROR al insertar Area: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Area> listarTodos() {
        List<Area> areas = null;
        String sql = "SELECT * FROM area WHERE activa = 1";

        try(Connection con = DBManager.getInstance().getConnection();
            Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                if (areas == null) areas = new ArrayList<>();
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                areas.add(area);
            }
            return areas;
        }catch (Exception ex){
            System.out.println("ERROR al insertar Area: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
