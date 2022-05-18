package electromeva.proyecto.interfaces;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public interface IEditar {
	
	@FXML void insertar() throws IOException;
	@FXML void editar() throws IOException;
	@FXML void eliminar() throws IOException;
	
}
