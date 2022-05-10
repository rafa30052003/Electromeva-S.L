module electromeva.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.xml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;

    opens electromeva.proyecto to javafx.fxml;
    opens electromeva.proyecto.utils to java.xml.bind, javax.xml.bind;
  
    exports electromeva.proyecto;
}