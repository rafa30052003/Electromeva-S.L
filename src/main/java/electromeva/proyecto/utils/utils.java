package electromeva.proyecto.utils;

import javafx.scene.control.Alert;

public class utils {
	/*
	 * Envia una alerta de cuando ha ocurrido un error
	 */
	 public static void alerta(String titulo, String header, String content) {
		 Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(header);
			alert.setTitle(titulo);
			alert.setContentText(content);
			alert.showAndWait();
	 }
	
	 /*
	  * Comprueba que el id sea entero
	  */
		public static boolean esEntero(String cad) {
			try {
				Integer.parseInt(cad);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		
		/*
		 * Al comprobar que el id es entero lo pasa de cadena a entero
		 */
		public static int deStringaEntero(String cad) {
			try {
				
			return Integer.parseInt(cad);
			} catch (Exception e) {
				
				return -1;
			}
		}
		
		
		
		
}
