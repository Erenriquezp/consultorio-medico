package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uce.app.utilities.Paths;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userField;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = userField.getText();
        String password = passwordField.getText();

        // Implementar la lógica de autenticación aquí
        if (authenticate(username, password)) {
            // Si la autenticación es exitosa, cargar la PantallaPrincipal
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
                Stage stage = new Stage();
                stage.setTitle("Pantalla Principal");
                stage.setScene(new Scene(loader.load()));
                stage.show();

                // Cerrar la pantalla de login
                Stage loginStage = (Stage) loginButton.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar mensaje de error si la autenticación falla
            System.out.println("Autenticación fallida");
        }
    }

    private boolean authenticate(String username, String password) {
        // Lógica de autenticación (esto es solo un ejemplo, debes implementar la lógica real)
        return "admin".equals(username) && "admin".equals(password);
    }
}
