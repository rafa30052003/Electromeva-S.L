package electromeva.proyecto;

import java.io.IOException;
import java.util.List;

import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.modelDAO.ClienteDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClienteController {
	ClienteDAO c = new ClienteDAO ();
	List<Cliente> todosMisClientes;
	 @FXML
	    private void switchToInico() throws IOException {
	        App.setRoot("InicioView");
	    }
	 @FXML
	    private void switchToProductos() throws IOException {
	        App.setRoot("ProductosView");
	    }
	 @FXML
	    private void switchToEditar() throws IOException {
	        App.setRoot("EditarCliente");
	    }
	 @FXML
	 private void salir() {
	    System.exit(0);
	 }
	 
	
	 @FXML
	 private TableView mitabla = new TableView();
	 @FXML
	 private TableColumn<Cliente,Integer> cod_c ;
	 @FXML
	 private TableColumn<Cliente,String> nombre;
	 @FXML
	 private TableColumn<Cliente,String> apellidos;
	 @FXML
	 private TableColumn<Cliente,String> apodo;
	 
	 
	 /*
	  * metodo que muestra la base de datos en el tableView
	  */
	 
	 @FXML
		protected void initialize() {
		
		 	
			this.configuraTabla();
			 todosMisClientes = (List<Cliente>) c.getall();
			mitabla.setItems(FXCollections.observableArrayList(todosMisClientes));
			
			
		}
	 
	 private void configuraTabla() {
		 cod_c.setCellValueFactory(client ->{
				ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
				((ObjectProperty<Integer>) ov).setValue(client.getValue().getCod_c());
				return ov;
			});	
		 nombre.setCellValueFactory(client ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(client.getValue().getNombre());
				return ssp;
			});
		 apellidos.setCellValueFactory(client ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(client.getValue().getApellidos());
				return ssp;
			});
		apodo.setCellValueFactory(client ->{
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(client.getValue().getApodo());
			return ssp;
		});
		 
	 }
}
