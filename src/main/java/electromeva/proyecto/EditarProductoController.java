package electromeva.proyecto;

import java.io.IOException;

import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.modelDAO.ProductoDAO;
import electromeva.proyecto.utils.utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarProductoController {
	Producto p = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	
	

	 @FXML
	    private void switchToProductos() throws IOException {
	        App.setRoot("ProductosView");
	    }
	
	@FXML private Button insertar;
	@FXML private Button editar;
	@FXML private Button eliminar;
	
	@FXML private TextField txtCod_p;
	@FXML private TextField txtNombre;
	@FXML private TextField txtMarca;
	@FXML private TextField txtModelo;
	@FXML private TextField txtCod_c;
	
	/*
	 * inserta el productos el tableView y en la base de datos
	 */
	
	public void insertar() throws IOException {
		Cliente aux2= null;
		ClienteDAO cdao = new ClienteDAO();
		if(!txtCod_c.getText().isEmpty()) {//Comprueba si el textField de la clave foranea no este  vacio
			try {
				aux2= cdao.get(utils.deStringaEntero(txtCod_c.getText()));// Comprueba que el cliente exista y que el id sea entero
				Cliente c = cdao.get(utils.deStringaEntero(txtCod_c.getText()));
				Producto aux = new Producto (txtNombre.getText() ,txtMarca.getText(), txtModelo.getText(),c);
				pdao.insert(aux);
				App.setRoot("ProductosView");
			} catch (Exception e) {
				utils.alerta("Error", "", "el cliente no existe");
			}
			
		}else {
			utils.alerta("Error", "", "Esta vacia la clave del cliente");
		}
			
		
	}  
	
	
	
	
	
	
	
}
