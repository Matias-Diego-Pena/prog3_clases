package pe.edu.pucp.softprog.rrhh.bo;

import pe.edu.pucp.softprog.config.TransactionContext;
import pe.edu.pucp.softprog.rrhh.boi.IAraeaBO;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.imp.AreaImpl;
import pe.edu.pucp.softprog.rrhh.imp.EmpleadoImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

import java.util.List;

public class AreaBOImpl implements IAraeaBO {

    private AreaDAO daoArea;
    private EmpleadoDAO daoEmpleado;

    public AreaBOImpl(){
        daoArea = new AreaImpl();
        daoEmpleado = new EmpleadoImpl();
    }

    @Override
    public int insertar(Area area) throws Exception{
        if (area == null)
            throw new Exception("El area que quiere registrar esta vacia");
        if (area.getNombre()==null)
            throw new Exception("El nombre del area esta vacio");
        if (area.getNombre().length()>45)
            throw new Exception ("El nombre es muy largo");
        if (area.getNombre().trim().isEmpty())
            throw new Exception ("El nombre no debe ser espacios en blanco");


        return daoArea.insertar(area);
    }

    @Override
    public int modificar(Area area) {
        return 0;
    }

    @Override
    public int eliminar(int idArea) {
        return 0;
    }

    @Override
    public List<Area> listarTodos() {
        return null;
    }

    @Override
    public Area obtenerPorId(int idArea) {
        return null;
    }

    @Override
    public int insertarAreaConEmpleado(Area area) {

        try {
            daoArea.insertar(area);
            for (Empleado emp : area.getEmpleados()) {
                emp.setArea(area);
                daoEmpleado.insertar(emp);
            }
            TransactionContext.commit();
            return 1;
        }catch(Exception ex) {
            TransactionContext.rollback();
            throw new RuntimeException("Error: " + ex.getMessage());
        } finally{
            TransactionContext.close();
        }
    }
}
