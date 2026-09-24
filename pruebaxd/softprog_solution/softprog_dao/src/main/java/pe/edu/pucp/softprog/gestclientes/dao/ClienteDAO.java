package pe.edu.pucp.softprog.gestclientes.dao;

import pe.edu.pucp.softprog.dao.IDAO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

import java.util.List;

public interface ClienteDAO extends IDAO<Cliente> {

    List<Cliente> listarPorDNINombre(String DNINombre);
}
