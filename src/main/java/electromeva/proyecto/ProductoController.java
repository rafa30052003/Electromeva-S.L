package electromeva.proyecto;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.modelDAO.ProductoDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProductoController implements Initializable {
	ProductoDAO p = new ProductoDAO ();
	List<Producto> todosMisProductos;
	
	
	
	
	 @FXML
	    private void switchToClientes() throws IOException {
	        App.setRoot("ClientesView");
	    }
	 @FXML
	    private void switchToInicio() throws IOException {
	        App.setRoot("InicioView");
	    }
	 @FXML
	    private void switchToEditar() throws IOException {
	        App.setRoot("EditarProducto");
	    }
	 @FXML
	 private void salir() {
	    System.exit(0);
	 }
	 
	 
	 @FXML
	 private TableView mitablaProductos = new TableView();
	 @FXML
	 private TableColumn<Producto,Integer> cod_p;
	 @FXML
	 private TableColumn<Producto,String> nombre;
	 @FXML
	 private TableColumn<Producto,String> marca;
	 @FXML
	 private TableColumn<Producto,String> modelo;
	 @FXML
	 private TableColumn<Producto,Integer> cod_c;
	 
	 
	 
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		
		 
		 this.configuraTabla();
		 todosMisProductos =  new ProductoDAO().getall();
		 mitablaProductos.setItems(FXCollections.observableArrayList(todosMisProductos));
		 
	 }
	 
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
		 cod_c.setCellValueFactory(product ->{
				ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
				((ObjectProperty<Integer>) ov).setValue(product.getValue().getCod_c());
				return ov;
			});	
		
		 
	 }
	
	
	 
}
