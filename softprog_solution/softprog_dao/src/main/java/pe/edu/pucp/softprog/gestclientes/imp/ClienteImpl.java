package pe.edu.pucp.softprog.gestclientes.imp;

import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.softprog.gestclientes.model.Categoria;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ClienteDAO {


    @Override
    public int insertar(Cliente cliente) {
        String sql =
                "{call INSERTAR_CLIENTE(?,?,?,?,?,?,?,?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)){

            cs.registerOutParameter("_id_cliente", Types.INTEGER);
            cs.setString("_DNI", cliente.getDNI());
            cs.setString("_nombre",cliente.getNombre());
            cs.setString("_apellido",cliente.getApellidoPaterno());
            cs.setString("_genero",String.valueOf(cliente.getGenero()));
            cs.setDate("_fecha_nacimiento",
                    new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            cs.setDouble("_linea_credito", cliente.getLineaCredito());
            cs.setString("_categoria", cliente.getCategoria().toString());

            cs.executeUpdate();
            cliente.setIdPersona(cs.getInt("_id_cliente"));
            return cliente.getIdPersona();
        }catch (Exception ex){
            System.out.println("ERROR al insertar Cliente: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int modificar(Cliente cliente) {
        return 0;
    }

    @Override
    public int eliminar(int idCliente) {
        return 0;
    }

    @Override
    public Cliente buscarPorid(int idCliente) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return List.of();
    }

    @Override
    public List<Cliente> listarPorDNINombre(String DNINombre) {
        List<Cliente> clientes = null;
        String sql = "{call LISTA_CLIENTES_X_DNI_CLIENTE(?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)){
            cs.setString("_DNI_NOMBRE",DNINombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                if (clientes == null) clientes = new ArrayList<>();
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getInt("id_cliente"));
                cliente.setDNI(rs.getString("DNI"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
                cliente.setGenero(rs.getString("genero").charAt(0));
                cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setLineaCredito(rs.getDouble("linea_credito"));
                cliente.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                clientes.add(cliente);
            }

            return clientes;

        }catch (Exception ex){
            System.out.println("ERROR al filtar clientes: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
