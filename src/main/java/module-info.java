module com.example.passwordkeychain {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires junit;

    opens com.example.passwordkeychain to javafx.fxml;
    exports com.example.passwordkeychain;
    exports com.example.passwordkeychain.model;
    opens com.example.passwordkeychain.model to javafx.fxml;
    exports com.example.passwordkeychain.control;
    opens com.example.passwordkeychain.control to javafx.fxml;
    opens com.example.passwordkeychain.test to org.junit.jupiter;
    exports com.example.passwordkeychain.test;
}