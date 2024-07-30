package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Evolucion;
import org.uce.app.services.FacadeService;
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class GestionEvolucionController {
    @FXML
    private TableColumn<Evolucion, Integer> idEvolucionColumn;
    @FXML
    private TableColumn<Evolucion, String> idHistoriaClinicaColumn;
    @FXML
    private TableColumn<Evolucion, LocalDate> fechaColumn;
    @FXML
    private TableColumn<Evolucion, String> descripcionColumn;
    @FXML
    private TextField idEvolucionField;
    @FXML
    private TextField idHistoriaClinicaField;
    @FXML
    private TextField fechaField;
    @FXML
    private TextArea descripcionField;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private TableView<Evolucion> tablaEvoluciones;
    @FXML
    private TextField buscarIdEvolucionField;

    private final FacadeService facadeService;

    public GestionEvolucionController() {
        this.facadeService = new FacadeService();
    }

    @FXML
    private void initialize() {
        configureTableColumns();
        loadEvoluciones();
        setupRowClickListener();
    }

    private void configureTableColumns() {
        idEvolucionColumn.setCellValueFactory(new PropertyValueFactory<>("idEvolucion"));
        idHistoriaClinicaColumn.setCellValueFactory(new PropertyValueFactory<>("idHistoriaClinica"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    private void setupRowClickListener() {
        tablaEvoluciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(Evolucion evolucion) {
        idEvolucionField.setText(String.valueOf(evolucion.getIdEvolucion()));
        idHistoriaClinicaField.setText(evolucion.getIdHistoriaClinica());
        fechaField.setText(evolucion.getFecha().toString());
        descripcionField.setText(evolucion.getDescripcion());
    }

    private void loadEvoluciones() {
        tablaEvoluciones.getItems().clear();
        tablaEvoluciones.getItems().addAll(facadeService.getAllEvoluciones());
    }

    @FXML
    private void agregarEvolucion() {
        if (!validateFields()) return;

        Evolucion evolucion = buildEvolucionFromFields();
        boolean success = facadeService.createEvolucion(evolucion);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Evolución agregada exitosamente." : "Hubo un error al agregar la evolución.");

        if (success) loadEvoluciones();
    }

    public void actualizarEvolucion() {
        Evolucion selectedEvolucion = tablaEvoluciones.getSelectionModel().getSelectedItem();
        if (selectedEvolucion == null) {
            showAlert(Alert.AlertType.WARNING, "Evolución no seleccionada", "Por favor, seleccione una evolución.");
            return;
        }

        Evolucion evolucionActualizada = buildEvolucionFromFields();
        boolean success = facadeService.updateEvolucion(evolucionActualizada);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Evolución actualizada exitosamente." : "Hubo un error al actualizar la evolución.");

        if (success) loadEvoluciones();
    }

    public void eliminarEvolucion() {
        Evolucion selectedEvolucion = tablaEvoluciones.getSelectionModel().getSelectedItem();
        if (selectedEvolucion == null) {
            showAlert(Alert.AlertType.WARNING, "Evolución no seleccionada", "Por favor, seleccione una evolución.");
            return;
        }

        Optional<ButtonType> response = showConfirmation();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            boolean success = facadeService.deleteEvolucion(selectedEvolucion.getIdEvolucion());

            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Evolución eliminada exitosamente." : "Hubo un error al eliminar la evolución.");

            if (success) loadEvoluciones();
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
        if (idEvolucionField.getText().isEmpty() || idHistoriaClinicaField.getText().isEmpty() || fechaField.getText().isEmpty() || descripcionField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    private Evolucion buildEvolucionFromFields() {
        return new Evolucion.Builder()
                .idEvolucion(idEvolucionField.getText().isEmpty() ? 0 : Integer.parseInt(idEvolucionField.getText()))
                .idHistoriaClinica(idHistoriaClinicaField.getText())
                .fecha(java.sql.Date.valueOf(fechaField.getText()))
                .descripcion(descripcionField.getText())
                .build();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Optional<ButtonType> showConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la evolución seleccionada?");
        return alert.showAndWait();
    }

    @FXML
    public void buscarEvolucion(ActionEvent actionEvent) {
        String idEvolucion = buscarIdEvolucionField.getText();
        if (idEvolucion.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "ID vacío", "Por favor, ingrese un ID de evolución.");
            return;
        }

        Evolucion evolucion = facadeService.getEvolucionById(Integer.parseInt(idEvolucion));
        if (evolucion == null) {
            showAlert(Alert.AlertType.WARNING, "Evolución no encontrada", "No se encontró ninguna evolución con el ID proporcionado.");
        } else {
            tablaEvoluciones.getItems().clear();
            tablaEvoluciones.getItems().add(evolucion);
        }
    }
}