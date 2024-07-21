package org.uce.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Cita;
import org.uce.app.services.CitaService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionCitasController {

    public TableColumn idCitaColumn;
    public TableColumn ciPacienteColumn;
    public TableColumn fechaCitaColumn;
    public TableColumn motivoColumn;
    public TableColumn estadoColumn;
    @FXML
    private TextField idCitaField;
    @FXML
    private TextField ciPacienteField;
    @FXML
    private DatePicker fechaCitaField;
    @FXML
    private TextArea motivoField;
    @FXML
    private TextField estadoField;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private Button buttonAgregaCita;

    @FXML
    private TableView<Cita> tablaCitas;

    private CitaService citaService;

    public GestionCitasController() {
        citaService = new CitaService();
    }

    @FXML
    private void initialize() {
        idCitaColumn.setCellValueFactory(new PropertyValueFactory<>("idCita"));

        ciPacienteColumn.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));

        fechaCitaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));

        motivoColumn.setCellValueFactory(new PropertyValueFactory<>("motivo"));

        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

        loadCitas();
    }

    private void loadCitas() {
        tablaCitas.getItems().clear();
        tablaCitas.getItems().addAll(citaService.getAllCitas());
    }

    @FXML
    private void agregarCita() {
        String idCita = idCitaField.getText();
        String ciPaciente = ciPacienteField.getText();
        LocalDate fechaCita = fechaCitaField.getValue();
        String motivo = motivoField.getText();
        String estado = estadoField.getText();

        Cita cita = new Cita(idCita, ciPaciente, null, motivo, estado);

        boolean success = citaService.createCita(cita);

        Alert alert;
        if (success) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Cita agregada exitosamente.");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al agregar la cita.");
        }
        alert.showAndWait();
    }

    @FXML
    private void regresar() {
        Stage stage = (Stage) buttonRegresar.getScene().getWindow();
        stage.close();
        cargarPantallaPrincipal();
    }

    @FXML
    private void handleSalir() {
        Stage stage = (Stage) buttonSalir.getScene().getWindow();
        stage.close();
    }

    private void cargarPantallaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/pantalla_principal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
