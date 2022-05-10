package electromeva.proyecto.model.dataobject;

import java.util.List;

public class Producto {
	private int cod_p;
	private String nombre;
	private String marca;
	private String modelo;
	private int cod_c;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int cod_p, String nombre, String marca, String modelo, int cod_c) {
		super();
		this.cod_p = cod_p;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.cod_c = cod_c;
	}
	public int getCod_p() {
		return cod_p;
	}
	public void setCod_p(int cod_p) {
		this.cod_p = cod_p;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCod_c() {
		return cod_c;
	}
	public void setCod_c(int cod_c) {
		this.cod_c = cod_c;
	}
	@Override
	public String toString() {
		return "Producto [cod_p=" + cod_p + ", nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo
				+ ", cod_c=" + cod_c + "]";
	}

	


	
	











	
	
	
	
	
}
