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
import org.uce.app.services.CitaServiceInterface;
import org.uce.app.services.CitaServiceProxy;
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

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
    private TableView<Cita> tablaCitas;

    private final CitaServiceInterface citaService;

    public GestionCitasController() {
        CitaService realService = new CitaService();
        this.citaService = new CitaServiceProxy(realService);
    }

    @FXML
    private void initialize() {
        configureTableColumns();
        loadCitas();
        setupRowClickListener();
    }

    private void configureTableColumns() {
        idCitaColumn.setCellValueFactory(new PropertyValueFactory<>("idCita"));
        ciPacienteColumn.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));
        fechaCitaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        motivoColumn.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
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
        if (!validateFields()) return;

        Cita cita = buildCitaFromFields();
        boolean success = citaService.createCita(cita);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Cita agregada exitosamente." : "Hubo un error al agregar la cita.");

        if (success) loadCitas();
    }

    public void actualizarCita() {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            showAlert(Alert.AlertType.WARNING, "Cita no seleccionada", "Por favor, seleccione una cita.");
            return;
        }

        Cita citaActualizada = buildCitaFromFields();
        boolean success = citaService.updateCita(citaActualizada);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Cita actualizada exitosamente." : "Hubo un error al actualizar la cita.");

        if (success) loadCitas();
    }

    public void eliminarCita() {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            showAlert(Alert.AlertType.WARNING, "Cita no seleccionada", "Por favor, seleccione una cita.");
            return;
        }

        Optional<ButtonType> response = showConfirmation("Confirmar eliminación", "¿Está seguro de que desea eliminar la cita seleccionada?");
        if (response.isPresent() && response.get() == ButtonType.OK) {
            boolean success = citaService.deleteCita(selectedCita.getIdCita());

            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Cita eliminada exitosamente." : "Hubo un error al eliminar la cita.");

            if (success) loadCitas();
        }
    }

    @FXML
    private void handleRegresar() {
        closeStage(buttonRegresar);
        cargarPantallaPrincipal();
    }

    @FXML
    private void handleSalir() {
        closeStage(buttonSalir);
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

    private void closeStage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    private boolean validateFields() {
        if (idCitaField.getText().isEmpty() || ciPacienteField.getText().isEmpty() || fechaCitaField.getValue() == null ||
                motivoField.getText().isEmpty() || estadoField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    private Cita buildCitaFromFields() {
        return new Cita.CitaBuilder()
                .idCita(idCitaField.getText())
                .ciPaciente(ciPacienteField.getText())
                .fechaCita(fechaCitaField.getValue().atStartOfDay())
                .motivo(motivoField.getText())
                .estado(estadoField.getText())
                .build();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Optional<ButtonType> showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert.showAndWait();
    }
}
