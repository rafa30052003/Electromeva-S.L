package electromeva.proyecto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

import electromeva.proyecto.model.dataobject.Cliente;

import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.utils.utils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class ClienteController {
	
	ClienteDAO c = new ClienteDAO ();
	private List<Cliente> todosMisClientes=(List<Cliente>) c.getall();
	private final ObservableList<Cliente> listaActualizable = FXCollections.observableArrayList(todosMisClientes);
	
	
	 
	
	
	 @FXML
	    private void switchToInico() throws IOException {
	        App.setRoot("InicioView");
	    }
	 @FXML
	    private void switchToProductos() throws IOException {
	        App.setRoot("ProductosView");
	    }
	 @FXML
	    private void switchToInsertar() throws IOException {
	        App.setRoot("EditarCliente");
	    }
	 @FXML
	 private void salir() {
	    System.exit(0);
	 }
	 
	 
	 @FXML
	 private TableView<Cliente> mitabla;
	 @FXML
	 private TableColumn<Cliente,Integer> cod_c ;
	 @FXML
	 private TableColumn<Cliente,String> nombre;
	 @FXML
	 private TableColumn<Cliente,String> apellidos;
	 @FXML
	 private TableColumn<Cliente,String> apodo;
	 
	 @FXML
	private TextField buscar;
	 
	 
	
	
	 
	 @FXML
	protected void initialize() {
		 	this.configuraTabla();
			mitabla.setItems(listaActualizable);
			//Filtra el cliente por apodo a través de un TexField
			FilteredList<Cliente> filteredData = new FilteredList<>(listaActualizable, e -> true);
			buscar.setOnKeyReleased(e -> {
				buscar.textProperty().addListener((observableValue, oldValue, newValue) -> {
					filteredData.setPredicate((Predicate<? super Cliente>) client-> {
						if(newValue == null || newValue.isEmpty()) {
							return true;
						}
						if (client.getApodo().contains(newValue)) {
							return true;
						}
						return false;
					});
				});
				SortedList<Cliente> sortedData = new SortedList<>(filteredData);
				sortedData.comparatorProperty().bind(mitabla.comparatorProperty());
				mitabla.setItems(sortedData);
			});
			
			
		}
	 /*
	  * metodo que muestra la base de datos en el tableView
	  * Tambien edita el cliente
	  */
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
		 	nombre.setCellFactory(TextFieldTableCell.forTableColumn());
			nombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cliente, String>>() {
				@Override
				public void handle(TableColumn.CellEditEvent<Cliente, String> t) {
					Cliente selected = (Cliente) t.getTableView().getItems().get(t.getTablePosition().getRow());
					selected.setNombre(t.getNewValue());
					c.update(selected);
				}
			});
		 apellidos.setCellValueFactory(client ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(client.getValue().getApellidos());
				return ssp;
			});
		 	apellidos.setCellFactory(TextFieldTableCell.forTableColumn());
			apellidos.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cliente, String>>() {
				@Override
				public void handle(TableColumn.CellEditEvent<Cliente, String> t) {
					Cliente selected = (Cliente) t.getTableView().getItems().get(t.getTablePosition().getRow());
					selected.setApellidos(t.getNewValue());
					c.update(selected);
				}
			});
		apodo.setCellValueFactory(client ->{
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(client.getValue().getApodo());
			return ssp;
		});
		apodo.setCellFactory(TextFieldTableCell.forTableColumn());
		apodo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cliente, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Cliente, String> t) {
				Cliente selected = (Cliente) t.getTableView().getItems().get(t.getTablePosition().getRow());
				selected.setApodo(t.getNewValue());
				c.update(selected);
			}
		});
		
		 mitabla.setEditable(true);
		 mitabla.getSelectionModel().cellSelectionEnabledProperty().set(true);
	 }
		 
	 /*
	  * Elimina el cliente al seleccionar en la tableView
	  */
	@FXML
	 private void eliminar() {
		 if(mitabla.getSelectionModel().isEmpty()) {
			 utils.alerta("Error", "", "Debes seleccionar un cliente");
		 }else {
			 try {
				c.delete(mitabla.getSelectionModel().getSelectedItem());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 	
				listaActualizable.remove(mitabla.getSelectionModel().getSelectedItem());
		 }
	 }

	/*
	 * Selecciona el  cliente para poder ver sus productos posteriormente (en VerProdutoController)
	 */
	@FXML
	private void verProductos() {
		 Cliente client=mitabla.getSelectionModel().getSelectedItem();
		 
		if(client==null) {
			 utils.alerta("Error", "", "Debes seleccionar un cliente");
		}else {
			
			try {
				//App.setRoot("VerProductos");
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VerProductos" + ".fxml"));
				
		        Parent p=fxmlLoader.load();
		       
				App.scene.setRoot(p);
				
				VerProductoController vC=fxmlLoader.getController();
				
				vC.setCliente(client);
				vC.inicio();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
}
