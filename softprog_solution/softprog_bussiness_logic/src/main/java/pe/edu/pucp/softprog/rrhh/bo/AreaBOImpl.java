package pe.edu.pucp.softprog.rrhh.bo;

import pe.edu.pucp.softprog.rrhh.boi.IAraeaBO;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.imp.AreaImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;

import java.util.List;

public class AreaBOImpl implements IAraeaBO {

    private AreaDAO daoArea;

    public AreaBOImpl(){
        daoArea = new AreaImpl();
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
}
