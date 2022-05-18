package electromeva.proyecto;

import java.io.IOException;

import electromeva.proyecto.interfaces.IEditar;
import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.utils.utils;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarClienteController implements IEditar {
	
	ClienteDAO cdao = new ClienteDAO();
	Cliente c = new Cliente();
	

	 @FXML
	    private void switchToClientes() throws IOException {
	        App.setRoot("ClientesView");
	    }
	
	@FXML private Button insertar;
	@FXML private Button editar;
	@FXML private Button eliminar;
	
	@FXML private TextField txtCod_c;
	@FXML private TextField txtNombre;
	@FXML private TextField txtApellidos;
	@FXML private TextField txtApodo;
	
	
	/*
	 * inserta el cliente el tableView y en la base de datos
	 */
	@Override
	public void insertar() throws IOException {
	
		Cliente aux=new Cliente(txtNombre.getText(), txtApellidos.getText(), txtApellidos.getText());
			cdao.insert(aux);
			App.setRoot("ClientesView");
	}
	
	
	
	
	/*
	 * edita el cliente en el  tableView y en la base de datos
	 */
	@Override
	public void editar() throws IOException {
		Cliente aux = null;
		if(!txtCod_c.getText().isEmpty()) { //Comprueba si el textField del id no este  vacio
			
			try {
				aux= cdao.get(utils.deStringaEntero(txtCod_c.getText()));// Comprueba que el cliente exista y que el id sea entero
			} catch (Exception e) {
				utils.alerta("Error", "", "el cliente no existe");
			}
			aux.setCod_c(utils.deStringaEntero(txtCod_c.getText()));
			aux.setNombre(txtNombre.getText());
			aux.setApellidos(txtApellidos.getText());
			aux.setApodo(txtApodo.getText());
			cdao.update(aux);
			App.setRoot("ClientesView");
		}else {
			utils.alerta("Error", "", "Esta vacio");
		}
		
	}
	
	
	
	
	
	
	/*
	 * elimina el cliente del tableView y de la base de datos
	 */
	@Override
	public void eliminar() throws IOException {
		Cliente aux = null;
		if(!txtCod_c.getText().isEmpty()) {//Comprueba si el textField del idcno este  vacio
			
			
			try {
				aux= cdao.get(utils.deStringaEntero(txtCod_c.getText()));// Comprueba que el cliente exista y que el id sea entero
			} catch (Exception e) {
				utils.alerta("Error", "", "el cliente no existe");
			}
				aux.setCod_c(utils.deStringaEntero(txtCod_c.getText()));
				try {
					cdao.delete(aux);
					
				} catch (Exception e) {
					utils.alerta("Error", "", "no se puede borrar un cliente que está asociado a un producto");
				}
				App.setRoot("ClientesView");
			
		}else {
			utils.alerta("Error", "", "Esta vacio");
		}
	}
	
	
	
	
}
