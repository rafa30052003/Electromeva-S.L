package electromeva.proyecto.utils;
import javax.xml.bind.annotation.*;


import java.io.Serializable;


@XmlRootElement(name="conexion")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosConexion implements Serializable {
	protected String server;//poner privados
	protected String database;
	protected String username;
	protected String password;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DatosConexion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DatosConexion [server=" + server + ", database=" + database + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
