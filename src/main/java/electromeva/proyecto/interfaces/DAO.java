package electromeva.proyecto.interfaces;

import java.sql.Connection;

import electromeva.proyecto.utils.Connect;

public abstract class DAO {
	 
	protected Connection miConexion;
	
	
	protected DAO() {
		super();
		this.miConexion=Connect.getConnect();
		
	}
}
