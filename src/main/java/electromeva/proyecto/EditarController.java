package electromeva.proyecto;

import java.io.IOException;

import javafx.fxml.FXML;

public class EditarController {
	 @FXML
	    private void switchToClientes() throws IOException {
	        App.setRoot("ClientesView");
	    }
	 @FXML
	    private void switchToProductos() throws IOException {
	        App.setRoot("ProductosView");
	    }
	 @FXML
	    private void switchToInicio() throws IOException {
	        App.setRoot("InicioView");
	    }
	 @FXML
	 private void salir() {
	    System.exit(0);
	 }
}
