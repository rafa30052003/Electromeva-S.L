package electromeva.proyecto.model.dataobject;

import java.util.List;

public class Cliente {
	private int cod_c;
	private String nombre;
	private String apellidos;
	private String apodo;
	List<Producto> misProductos;
	public Cliente(int cod_c, String nombre, String apellidos, String apodo, List<Producto> misProductos) {
		super();
		this.cod_c = cod_c;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.misProductos = misProductos;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Producto> getMisProductos() {
		return misProductos;
	}
	public void setMisProductos(List<Producto> misProductos) {
		this.misProductos = misProductos;
	}
	@Override
	public String toString() {
		return "Cliente [cod_c=" + cod_c + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo=" + apodo
				+ ", misProductos=" + misProductos + "]";
	}
	
	
	
	
}

	
