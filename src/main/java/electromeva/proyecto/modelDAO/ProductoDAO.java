package electromeva.proyecto.modelDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import electromeva.proyecto.interfaces.DAO;
import electromeva.proyecto.interfaces.IDAO;

import electromeva.proyecto.model.dataobject.Producto;


public class ProductoDAO extends DAO implements IDAO<Producto,Integer> {
	
	
	
	
	
	
	
	/*
	 * metodo para insetar un producto en la base de datos
	 */
	@Override
	public boolean insert(Producto ob) {
		boolean result = false;
		String sql="insert INTO producto VALUES (null,?,?,?,?)";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			
			sentencia.setString(1, ob.getNombre());
			sentencia.setString(2, ob.getMarca());
			sentencia.setString(3, ob.getModelo());
			sentencia.setInt(4, ob.getCod_c());
			
			sentencia.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/*
	 * busca al producto por id en la base de datos
	 */
	@Override
	public Producto get(Integer id) throws SQLException {
		Producto p =null;
		
		String sql= "select cod_p, nombre, modelo, marca, cod_c from producto where cod_p=?";
		PreparedStatement sentencia = miConexion.prepareStatement(sql);
		sentencia.setInt(1, id);
		ResultSet rs = sentencia.executeQuery();
		rs.next();
		p= new Producto();
		p.setCod_p(rs.getInt("cod_p"));
		p.setNombre(rs.getString("nombre"));
		p.setMarca(rs.getString("marca"));
		p.setModelo(rs.getString("modelo"));
		p.setCod_c(rs.getInt("cod_c"));
		return p;
	}
	/*
	 * imprime todos los atrinbutos del producto por pantalla
	 */
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
	
	/*
	 * edita el producto
	 */
	@Override
	public int update(Producto ob) {
		int result= 0; 
		String sql="UPDATE producto SET nombre = ?, marca = ?, modelo = ?, cod_c= ?  WHERE producto.cod_p = ?";
		try {
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getNombre());
			sentencia.setString(2, ob.getMarca());
			sentencia.setString(3, ob.getModelo());
			sentencia.setInt(4, ob.getCod_c());
			sentencia.setInt(5, ob.getCod_p());
			sentencia.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/*
	 * elimina al producto por id
	 */
	@Override
	public int delete(Producto ob) throws SQLException {
		int result =0;
		String sql="Delete from producto where cod_p=? ";
		
			PreparedStatement sentencia= miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getCod_p());
			sentencia.executeUpdate();
			result= 1;
			
		
		return result;
	}

	

	

}
