package electromeva.proyecto.modelDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import electromeva.proyecto.interfaces.DAO;
import electromeva.proyecto.interfaces.IDAO;
import electromeva.proyecto.model.dataobject.Cliente;


public class ClienteDAO extends DAO implements IDAO <Cliente, Integer> {

	
		
	
	
	
	/*
	 * metodo para insetar un cliente en la base de datos
	 */
	@Override
	public boolean insert(Cliente ob) {
		boolean result = false;
		String sql="INSERT INTO clientes VALUES (null,?,?,?);";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			
			sentencia.setString(1, ob.getNombre());
			sentencia.setString(2, ob.getApellidos());
			sentencia.setString(3, ob.getApodo());
			sentencia.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	
	/*
	 * busca al cliente por id en la base de datos
	 */
	@Override
	public Cliente get(Integer id) throws SQLException {
		Cliente c = null;
		String sql="select cod_c, nombre, apellidos, apodo from clientes where cod_c=?";
		
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			c=new Cliente();
			c.setCod_c(rs.getInt("cod_c"));
			c.setNombre(rs.getString("nombre"));
			c.setApellidos(rs.getString("apellidos"));
			c.setApodo(rs.getString("apodo"));
		
			
			
		
		return c;
	}
	
	/*
	 * imprime todos los atrinbutos del cliente por pantalla
	 */
	@Override
	public List<Cliente> getall() {
		List <Cliente> listaClientes = new ArrayList<>();
		
		String sql="select cod_c, nombre, apellidos, apodo from clientes";
		
		try {
			PreparedStatement  sentencia = miConexion.prepareStatement(sql);
			
			ResultSet rs = sentencia.executeQuery();
			
			while(rs.next()) {
				//rs.next();
				Cliente c = new Cliente();
				c.setCod_c(rs.getInt("cod_c"));
				c.setNombre(rs.getString("nombre"));
				c.setApellidos(rs.getString("apellidos"));
				c.setApodo(rs.getString("apodo"));
				listaClientes.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaClientes;
		
	}
	/*
	 * edita el cliente
	 */
	@Override
	public int update(Cliente ob) {
		int result= 0; 
		
		String sql="UPDATE clientes SET nombre = ?, apellidos = ?, apodo = ? WHERE clientes.cod_c = ?";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getNombre());
			sentencia.setString(2, ob.getApellidos());
			sentencia.setString(3, ob.getApodo());
			sentencia.setInt(4, ob.getCod_c());
			
			sentencia.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	/*
	 * elimina al cliente por id
	 */
	@Override
	public int delete(Cliente ob) throws SQLException {
		int result =0;
		String sql="Delete from clientes where cod_c=? ";
		
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_c());
			sentencia.executeUpdate();
			result= 1;
			
		
		return result;
	}

	
}
