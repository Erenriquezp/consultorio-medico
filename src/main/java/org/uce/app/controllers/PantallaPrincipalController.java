package org.uce.app.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaPrincipalController {

    @FXML
    private void gestionarPacientes() {
        cargarPantalla("/fxml/GestionPacientes.fxml", "Gestión de Pacientes");
    }

    @FXML
    private void gestionarCitas() {
        cargarPantalla("/fxml/GestionCitas.fxml", "Gestión de Citas");
    }

    @FXML
    private void gestionarHistorialMedico() {
        cargarPantalla("/fxml/HistorialMedico.fxml", "Historial Médico");
    }

    private void cargarPantalla(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}