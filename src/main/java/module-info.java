module electromeva.proyecto {
    requires javafx.controls;
    requires javafx.fxml;

    opens electromeva.proyecto to javafx.fxml;
    exports electromeva.proyecto;
}