package electromeva.proyecto.model.dataobject;

import java.util.List;

public class Cliente {
	private int cod_c;
	private String nombre;
	private String apellidos;
	private String apodo;
	private List<Producto> p;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(int cod_c, String nombre, String apellidos, String apodo, List<Producto> p) {
		super();
		this.cod_c = cod_c;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.p = p;
	}


	public Cliente(String nombre, String apellidos, String apodo, List<Producto> p) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.p = p;
	}
	
	


	public Cliente(String nombre, String apellidos, String apodo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
	}


	public int getCod_c() {
		return cod_c;
	}


	public void setCod_c(int cod_c) {
		this.cod_c = cod_c;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getApodo() {
		return apodo;
	}


	public void setApodo(String apodo) {
		this.apodo = apodo;
	}


	public List<Producto> getP() {
		return p;
	}


	public void setP(List<Producto> p) {
		this.p = p;
	}


	@Override
	public String toString() {
		return "Cliente [cod_c=" + cod_c + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo=" + apodo
				+ ", p=" + p + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	
