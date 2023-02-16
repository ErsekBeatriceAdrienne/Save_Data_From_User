module com.example.dataapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataapp to javafx.fxml;
    exports com.example.dataapp;
}