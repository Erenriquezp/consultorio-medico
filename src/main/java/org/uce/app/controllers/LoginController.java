package org.uce.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uce.app.services.AuthService;
import org.uce.app.services.AuthServiceInterface;
import org.uce.app.services.AuthServiceProxy;
import org.uce.app.services.FacadeService;
import org.uce.app.utilities.Paths;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    // Instancia del Proxy en lugar del servicio concreto
    private final FacadeService facadeService;

    // Constructor del controlador
    public LoginController() {
        this.facadeService = new FacadeService();
    }

    @FXML
    private void handleLogin() {
        String username = userField.getText();
        String password = passwordField.getText();

        if (facadeService.authenticate(username, password)) {
            loadMainScreen();
        } else {
            showAlert();
        }
    }

    @FXML
    private void handleCloseApp() {
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

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password.");
        alert.showAndWait();
    }
}
