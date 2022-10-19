module com.example.universitygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ucdenver.application to javafx.fxml;
    exports edu.ucdenver.application;
}