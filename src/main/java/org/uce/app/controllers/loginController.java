package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.uce.app.utilities.Paths;

import java.io.IOException;

public class loginController {

    // botton de login
    @FXML
    private Button btnLogin;

    //
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;

    //-- Metodo cuando aplastas el botton 'ingresar'
    @FXML
    private void eventAction(ActionEvent event) {
    //cargarPantalla(Paths.pantallaPrincipal, "Pantalla Principal");
    }
    //-- Metodo para cuando se ingresa el User y Password
    @FXML
    void eventKey(KeyEvent event) {

    }
    // Método privado para cargar una nueva pantalla
//    private void cargarPantalla(String fxmlPath, String titulo) {
//        try {
//            // Crea un FXMLLoader con la ruta del archivo FXML
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//            // Crea un nuevo Stage (ventana)
//            Stage stage = new Stage();
//            // Establece el título de la ventana
//            stage.setTitle(titulo);
//            // Carga el archivo FXML y establece la escena en el Stage
//            stage.setScene(new Scene(loader.load()));
//            // Muestra la ventana
//            stage.show();
//        } catch (IOException e) {
//            // Manejo de la excepción en caso de error al cargar el archivo FXML
//            e.printStackTrace();
//        }
//    }
}
