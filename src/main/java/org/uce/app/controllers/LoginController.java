package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uce.app.services.AuthService;
import org.uce.app.utilities.Paths;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    private AuthService authService = new AuthService();

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = userField.getText();
        String password = passwordField.getText();

        if (authService.authenticate(username, password)) {
            loadMainScreen();
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    private void handleCloseApp(ActionEvent event) {
        Stage stage = (Stage) userField.getScene().getWindow();
        stage.close();
    }

    private void loadMainScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();

            // Close the login window
            Stage loginStage = (Stage) userField.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
