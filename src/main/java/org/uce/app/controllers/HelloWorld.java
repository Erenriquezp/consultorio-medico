package org.uce.app.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class HelloWorld {

    @FXML
    private Label lblMessage;

    @FXML
    void click(ActionEvent event) {
        lblMessage.setText("Hello World");
    }
}
