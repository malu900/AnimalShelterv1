module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires server;
    opens com.fhict.client to javafx.fxml;
    exports com.fhict.client;
}