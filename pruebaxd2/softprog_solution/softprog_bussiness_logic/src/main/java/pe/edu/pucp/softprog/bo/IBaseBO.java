package pe.edu.pucp.softprog.bo;

import java.util.List;

public interface IBaseBO <T>{
    int insertar(T objeto) throws Exception;
    int modificar(T objeto);
    int eliminar(int idObjeto);

    List<T> listarTodos();
    T obtenerPorId(int idObejto);
}
