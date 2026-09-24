package pe.edu.pucp.softprog.rrhh.boi;

import pe.edu.pucp.softprog.bo.IBaseBO;
import pe.edu.pucp.softprog.rrhh.model.Area;


public interface IAraeaBO extends IBaseBO<Area> {
    int insertarAreaConEmpleado(Area area);
}
