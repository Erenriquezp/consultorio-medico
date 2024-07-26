package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Cita;
import org.uce.app.services.CitaService;
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;

public class GestionCitasController {
    @FXML
    private TableColumn<Cita, String> idCitaColumn;
    @FXML
    private TableColumn<Cita, String> ciPacienteColumn;
    @FXML
    private TableColumn<Cita, LocalDate> fechaCitaColumn;
    @FXML
    private TableColumn<Cita, String> motivoColumn;
    @FXML
    private TableColumn<Cita, String> estadoColumn;
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

    private final CitaService citaService;

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
        setupRowClickListener();
    }
    private void setupRowClickListener() {
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(Cita cita) {
        idCitaField.setText(cita.getIdCita());
        ciPacienteField.setText(cita.getCiPaciente());
        fechaCitaField.setValue(cita.getFechaCita().toLocalDate());
        motivoField.setText(cita.getMotivo());
        estadoField.setText(cita.getEstado());
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

        if (idCita.isEmpty() || ciPaciente.isEmpty() || fechaCita == null || motivo.isEmpty() || estado.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
            return;
        }

        Cita cita = new Cita.CitaBuilder()
                .idCita(idCita)
                .ciPaciente(ciPaciente)
                .fechaCita(fechaCita.atStartOfDay())
                .motivo(motivo)
                .estado(estado)
                .build();
        boolean success = citaService.createCita(cita);

        Alert alert;
        if (success) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Cita agregada exitosamente.");
            loadCitas();
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al agregar la cita.");
        }
        alert.showAndWait();
    }
    public void actualizarCita(ActionEvent actionEvent) {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cita no seleccionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una cita.");
            alert.showAndWait();
            return;
        }

        boolean success = citaService.updateCita(new Cita.CitaBuilder()
                .idCita(idCitaField.getText())
                .ciPaciente(ciPacienteField.getText())
                .fechaCita(fechaCitaField.getValue().atStartOfDay())
                .motivo(motivoField.getText())
                .estado(estadoField.getText())
                .build());

        Alert alert;
        if (success) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Cita actualizada exitosamente.");
            loadCitas();
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al actualizar la cita.");
        }
        alert.showAndWait();
    }

    public void eliminarCita(ActionEvent actionEvent) {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cita no seleccionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una cita.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar eliminación");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Está seguro de que desea eliminar la cita seleccionada?");
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                boolean success = citaService.deleteCita(selectedCita.getIdCita());
                Alert alert;
                if (success) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setHeaderText(null);
                    alert.setContentText("Cita eliminada exitosamente.");
                    loadCitas();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Hubo un error al eliminar la cita.");
                }
                alert.showAndWait();
            }
        });
    }

    @FXML
    private void handleRegresar() {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
