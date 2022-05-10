package electromeva.proyecto.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import electromeva.proyecto.interfaces.IDAO;
import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.utils.Connect;

public class ClienteDAO implements IDAO<Cliente, Integer> {

	
		private Connection miConexion=null;
			
			
			public ClienteDAO() {
				super();
				this.miConexion=Connect.getConnect();
				
			}
	
	
	
	
	@Override
	public boolean insert(Cliente ob) {
		boolean result = false;
		String sql="insert cod_c, nombre, apellidos, apodo values(?,?,?,?)";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_c());
			sentencia.setString(2, ob.getNombre());
			sentencia.setString(3, ob.getApellidos());
			sentencia.setString(3, ob.getNombre());
			sentencia.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public Cliente get(Integer id) {
		Cliente c = null;
		String sql="select cod_c, nombre, apellidos, apodo from clientes where cod_c=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			c=new Cliente();
			c.setCod_c(rs.getInt("cod_c"));
			c.setNombre(rs.getString("nombre"));
			c.setApellidos(rs.getString("apellidos"));
			c.setApodo(rs.getString("apodo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

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

	@Override
	public int update(Cliente ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente ob) {
		int result =0;
		String sql="Delete from producto where cod_c=? ";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_c());
			sentencia.executeUpdate();
			result= 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
