package electromeva.proyecto.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import electromeva.proyecto.interfaces.IDAO;
import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.utils.Connect;

public class ProductoDAO implements IDAO<Producto,Integer> {
	private Connection miConexion=null;
	
	
	public ProductoDAO() {
		super();
		this.miConexion=Connect.getConnect();
				
	}
	    
	
	
	
	
	@Override
	public boolean insert(Producto ob) {
		boolean result = false;
		String sql="insert cod_p, nombre, marca, modelo values (?,?,?,?)";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_p());
			sentencia.setString(2, ob.getNombre());
			sentencia.setString(3, ob.getMarca());
			sentencia.setString(4, ob.getModelo());
			sentencia.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Producto get(Integer id) {
		/*Producto p =null;
		
		String sql= "select cod_p, nombre, modelo, marca from producto where cod_p=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet rs= sentencia.executeQuery();
			rs.next();
			p= new Producto();
			p.setCod_p(rs.getInt("cod_p"));
			p.setNombre(rs.getString("nombre"));
			p.setMarca(rs.getString("marca"));
			p.setModelo(rs.getString("modelo"));
			ClienteDAO cdao = new ClienteDAO();
			p.setMisClientes(cdao.getallClientesForProductos(p));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	public List<Producto> getall() {
		List <Producto> listaProductos = new ArrayList<Producto>();
		
		String sql="select * from producto";
		
		try {
			
			Statement  sentencia = miConexion.createStatement();
			 
			ResultSet rs = sentencia.executeQuery(sql);
			
			while(rs.next()) {
				//rs.next();
				Producto p = new Producto();
				p.setCod_p(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setMarca(rs.getString(3));
				p.setModelo(rs.getString(4));
				p.setCod_c(rs.getInt(5));
				listaProductos.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaProductos;
		
	}

	@Override
	public int update(Producto ob) {
		
		return 0;
	}

	@Override
	public int delete(Producto ob) {
		int result =0;
		String sql="Delete from producto where cod_p=? ";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_p());
			sentencia.executeUpdate();
			result= 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

	

}
