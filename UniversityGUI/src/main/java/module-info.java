module com.example.universitygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.cudenver.application to javafx.fxml;
    exports edu.cudenver.application;
    exports edu.cudenver.university;
    opens edu.cudenver.university to javafx.fxml;
}