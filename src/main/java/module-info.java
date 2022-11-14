module ShoppingListApp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens org.example to javafx.fxml;
    opens org.example.domain to com.fasterxml.jackson.databind;
    opens org.example.persistance to com.fasterxml.jackson.databind;
    exports org.example;
    exports org.example.controller;
    opens org.example.controller to javafx.fxml;
}