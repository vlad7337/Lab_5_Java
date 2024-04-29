module ua.lab5.javafxlab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.lab5.javafxlab5 to javafx.fxml;
    exports ua.lab5.javafxlab5;
}