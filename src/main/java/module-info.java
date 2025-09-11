module co.edu.poli.IngenieriaDeSoftware {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

    opens co.edu.poli.vista to javafx.fxml;
    exports co.edu.poli.vista;
    opens co.edu.poli.controlador to javafx.fxml;
    exports co.edu.poli.controlador;
}
