package electromeva.proyecto;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class InicioController {
	
	
	
	 @FXML
	    private void switchToClientes() throws IOException {
		
	        App.setRoot("ClientesView");
	    }
	 @FXML
	    private void switchToProductos() throws IOException {
	        App.setRoot("ProductosView");
	    }
	 @FXML
	    private void switchToEditar() throws IOException {
	        App.setRoot("EditarView");
	    }
	
	
	 
	 @FXML
	 private void salir() {
	    System.exit(0);
	 }
	 
}
