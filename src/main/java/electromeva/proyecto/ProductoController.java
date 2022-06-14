package electromeva.proyecto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;


import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.modelDAO.ProductoDAO;
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
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class ProductoController implements Initializable {
	
	ClienteDAO c = new ClienteDAO();
	ProductoDAO p = new ProductoDAO ();
	 private List<Producto> todosMisProductos=(List<Producto>) p.getall();
	 private final ObservableList<Producto> listaActualizable = FXCollections.observableArrayList(todosMisProductos);
	 
	
	
	
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
	 private TableView<Producto> mitablaProductos;
	 @FXML
	 private TableColumn<Producto,Integer> cod_p;
	 @FXML
	 private TableColumn<Producto,String> nombre;
	 @FXML
	 private TableColumn<Producto,String> marca;
	 @FXML
	 private TableColumn<Producto,String> modelo;
	 @FXML
	 private TableColumn<Producto,Integer/*Property*/> cod_c;
	 
	 @FXML
	 private Button btnEliminar;
	 
	 @FXML
	 private TextField buscar;

	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		
		this.configuraTabla();
		 mitablaProductos.setItems(listaActualizable);
		 //Filtra el prodcuto por el modelo
		 FilteredList<Producto> filteredData = new FilteredList<>(listaActualizable, e -> true);
			buscar.setOnKeyReleased(e -> {
				buscar.textProperty().addListener((observableValue, oldValue, newValue) -> {
					filteredData.setPredicate((Predicate<? super Producto>) product-> {
						if(newValue == null || newValue.isEmpty()) {
							return true;
						}
						if (product.getModelo().contains(newValue)) {
							return true;
						}
						return false;
					});
				});
				SortedList<Producto> sortedData = new SortedList<>(filteredData);
				sortedData.comparatorProperty().bind(mitablaProductos.comparatorProperty());
				mitablaProductos.setItems(sortedData);
			});
		 

		 
		 
	 }
	 /*
	  * Metodo que muestra la tabla 
	  * Tambien permite editar el producto
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
		 	nombre.setCellFactory(TextFieldTableCell.forTableColumn());
			nombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
				@Override
				public void handle(TableColumn.CellEditEvent<Producto, String> t) {
					Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
					selected.setNombre(t.getNewValue());
					p.update(selected);
				}
			});
		 marca.setCellValueFactory(product ->{
				SimpleStringProperty ssp = new SimpleStringProperty();
				ssp.setValue(product.getValue().getMarca());
				return ssp;
			});
		 	marca.setCellFactory(TextFieldTableCell.forTableColumn());
			marca.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
				@Override
				public void handle(TableColumn.CellEditEvent<Producto, String> t) {
					Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
					selected.setMarca(t.getNewValue());
					p.update(selected);
				}
			});
		 modelo.setCellValueFactory(product ->{
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(product.getValue().getModelo().replace(" ","\n"));
			return ssp;
		 	});
		 	modelo.setCellFactory(TextFieldTableCell.forTableColumn());
			modelo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
				@Override
				public void handle(TableColumn.CellEditEvent<Producto, String> t) {
					Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
					selected.setModelo(t.getNewValue());
					p.update(selected);
				}
			});
		 cod_c.setCellValueFactory(product ->{
				ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
				((ObjectProperty<Integer>) ov).setValue(product.getValue().getC().getCod_c());
				return ov;
			});	
		 
		
			
		 mitablaProductos.setEditable(true);
		 mitablaProductos.getSelectionModel().cellSelectionEnabledProperty().set(true);
	 }
	
	 /*
	  * Metodo que elimina el producto por id al seleccionarlo
	  */
	 @FXML
	 private void eliminar() {
		 if(mitablaProductos.getSelectionModel().isEmpty()) {
			 utils.alerta("Error", "", "Debes seleccionar un producto");
		 }else {
			 
				try {
					p.delete(mitablaProductos.getSelectionModel().getSelectedItem());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
			 	
			listaActualizable.remove(mitablaProductos.getSelectionModel().getSelectedItem());
				
		 }
	 }
	
	 
	 

}
