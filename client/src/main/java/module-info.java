module com.fhict.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires server;

    opens com.fhict.client to javafx.fxml;
    exports com.fhict.client;
}