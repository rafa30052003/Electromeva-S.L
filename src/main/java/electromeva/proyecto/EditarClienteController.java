package electromeva.proyecto;

import java.io.IOException;


import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.modelDAO.ClienteDAO;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarClienteController {
	
	ClienteDAO cdao = new ClienteDAO();
	Cliente c = new Cliente();
	

	 @FXML
	    private void switchToClientes() throws IOException {
	        App.setRoot("ClientesView");
	    }
	
	@FXML private Button insertar;
	@FXML private Button editar;
	@FXML private Button eliminar;
	

	@FXML private TextField txtNombre;
	@FXML private TextField txtApellidos;
	@FXML private TextField txtApodo;
	
	
	/*
	 * inserta el cliente el tableView y en la base de datos
	 */
	
	public void insertar() throws IOException {
	
		Cliente aux=new Cliente(txtNombre.getText(), txtApellidos.getText(), txtApodo.getText());
			cdao.insert(aux);
			App.setRoot("ClientesView");
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	

