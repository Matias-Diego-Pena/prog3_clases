package pe.edu.pucp.softprog.dao;
import java.util.List;

public interface IDAO<T> {
    //metodos comunes que usaremos para los comandos de la base de datos
    //el metodo CRUD osea CREATE, READ, UPDATE, DELETE
    //metodos que se repiten para todas las clases

    //entonces

    int insertar(T objeto);

    int modificar(T objeto);

    int eliminar(int idObjeto);

    T buscarPorid(int idObjeto);

    List<T> listarTodos();
}
