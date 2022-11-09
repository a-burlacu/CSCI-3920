module edu.ucdenver.multilibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ucdenver.application to javafx.fxml;
    exports edu.ucdenver.application;
    exports edu.ucdenver.server;
    opens edu.ucdenver.server to javafx.fxml;
    exports edu.ucdenver.client;
    opens edu.ucdenver.client to javafx.fxml;
    exports edu.ucdenver.library;
    opens edu.ucdenver.library to javafx.fxml;
}