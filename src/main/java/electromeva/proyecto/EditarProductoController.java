package electromeva.proyecto;

import java.io.IOException;
import java.sql.SQLException;

import electromeva.proyecto.interfaces.IEditar;
import electromeva.proyecto.model.dataobject.Cliente;
import electromeva.proyecto.model.dataobject.Producto;
import electromeva.proyecto.modelDAO.ClienteDAO;
import electromeva.proyecto.modelDAO.ProductoDAO;
import electromeva.proyecto.utils.utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarProductoController implements IEditar {
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
	@Override
	public void insertar() throws IOException {
		Cliente aux2= null;
		ClienteDAO cdao = new ClienteDAO();
		if(!txtCod_c.getText().isEmpty()) {//Comprueba si el textField de la clave foranea no este  vacio
			try {
				aux2= cdao.get(utils.deStringaEntero(txtCod_c.getText()));// Comprueba que el cliente exista y que el id sea entero
				Producto aux = new Producto (txtNombre.getText() ,txtMarca.getText(), txtModelo.getText(), utils.deStringaEntero(txtCod_c.getText()));
				pdao.insert(aux);
				App.setRoot("ProductosView");
			} catch (Exception e) {
				utils.alerta("Error", "", "el cliente no existe");
			}
			
		}else {
			utils.alerta("Error", "", "Esta vacia la clave del cliente");
		}
			
		
	}  
	
	
	
	/*
	 * edita el productos  en el  tableView y en la base de datos
	 */
	@Override
	public void editar() throws IOException {
		Producto aux = null;
		Cliente aux2= null;
		ClienteDAO cdao = new ClienteDAO();
		if(!txtCod_p.getText().isEmpty()) { //Comprueba si el textField del id  no este  vacio
			if( !txtCod_c.getText().isEmpty()) {//Comprueba si el textField de la clave foranea no este  vacio
				try {
					aux= pdao.get(utils.deStringaEntero(txtCod_p.getText()));// Comprueba que el producto exista y que el id sea entero
					try {
						aux2= cdao.get(utils.deStringaEntero(txtCod_c.getText()));// Comprueba que el cliente exista y que el id sea entero
						aux.setCod_p(utils.deStringaEntero(txtCod_p.getText()));
						aux.setNombre(txtNombre.getText());
						aux.setMarca(txtMarca.getText());
						aux.setModelo(txtModelo.getText());
						aux.setCod_c(utils.deStringaEntero(txtCod_c.getText()));
						pdao.update(aux);
						App.setRoot("ProductosView");
					}catch(Exception e){
						utils.alerta("Error", "", "el cliente no existe");
				}
				} catch (Exception e) {
					utils.alerta("Error", "", "el producto no existe");
				}
				
			}else {
				utils.alerta("Error", "", "Esta vacia la clave del cliente");
			}
			
		}else {
			utils.alerta("Error", "", "Esta vacio");
		}
	}
	
	
	
	/*
	 * elimina el productos del tableView y de la base de datos
	 */
	@Override
	public void eliminar() throws IOException {
		Producto aux = null;
		if(!txtCod_p.getText().isEmpty()) {//Comprueba si el textField del idcno este  vacio
			
			
			try {
				aux= pdao.get(utils.deStringaEntero(txtCod_p.getText()));// Comprueba que el producto exista y que el id sea entero
			} catch (Exception e) {
				utils.alerta("Error", "", "el producto no existe");
			}
				aux.setCod_p(utils.deStringaEntero(txtCod_p.getText()));
				try {
					pdao.delete(aux);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				App.setRoot("ProductosView");
			
		}else {
			utils.alerta("Error", "", "Esta vacio");
		}
	}
}
