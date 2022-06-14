package electromeva.proyecto;

import java.io.IOException;

import java.util.List;


import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.modelDAO.ProductoDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VerProductoController  {
	ProductoDAO p ;
	ClienteDAO cdao;
	public Cliente c;
	
	
	 @FXML
	    private void switchToCliente() throws IOException {
	        App.setRoot("ClientesView");
	    }
	
	 @FXML
	 private TableView<Producto> mitablaProductos;
	 @FXML
	 private TableColumn<Producto,Integer> cod_p;
	 @FXML
	 private TableColumn<Producto,String> nombre;
	 @FXML
	 private TableColumn<Producto,String> marca;
	 @FXML
	 private TableColumn<Producto,String> modelo;
	 
	 @FXML private TextField cod_c;
	 @FXML private TextField nombre_c;
	 @FXML private TextField apodo;
	 
	 /*
	  * metodo que setea el cliente
	  */
	 protected void initAttributes(Cliente client) {
		 this.c = client;
		 this.cod_c.setText(c.getCod_c()+"");
		 this.nombre_c.setText(c.getNombre());
		 
		 this.apodo.setText(c.getApodo());
		 
		 this.showClient();
		
	 }
	 
	 
	 
	 /*
	  * metodo que coge al cliente seleccionado
	  */
	 private void showClient() {
		 
		 int cod= Integer.parseInt(cod_c.getText());
		 String nombre= nombre_c.getText();
		
		 String apodoo=apodo.getText();
		 
		 if(c!=null) {
			 c.setCod_c(cod);
			 c.setNombre(nombre);
			 c.setApodo(apodoo);
		 }
	 }
	 
	 
	 public void initialize() {
		 this.configuraTabla();
		 
		
	}
	 /*
	  * Metodo que selecciona los productos especificos de un cliente especifico
	  */
	 public void inicio() {
		 
		 cdao=new ClienteDAO();
		
		List<Producto> ProductosClient = cdao.getProduct(c);
		
		 ObservableList<Producto> ListaActualizable = FXCollections.observableArrayList(ProductosClient);
		 mitablaProductos.getItems().addAll(ListaActualizable);
		 this.initAttributes(c);
	 }
	 
	 /*
	  * Metodo que muestra la tabla
	  */
	 private void configuraTabla() {
		
		 cod_p.setCellValueFactory(product ->{
				ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
				((ObjectProperty<Integer>) ov).setValue(product.getValue().getCod_p());
				return ov;
			});	
		 nombre.setCellValueFactory(product ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(product.getValue().getNombre());
				return ssp;
			});
		 marca.setCellValueFactory(product ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(product.getValue().getMarca());
				return ssp;
			});
		 modelo.setCellValueFactory(product ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(product.getValue().getModelo().replace(" ","\n"));
				return ssp;
			 	});
	 }
	 
	 public void setCliente(Cliente c) {
		 
		 this.c=c;
	 }
	 public Cliente getCliente() {
		 return c;
	 }
	
}
