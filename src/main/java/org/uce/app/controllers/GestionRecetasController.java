package org.uce.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Receta;
import org.uce.app.services.FacadeService;
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class GestionRecetasController {
    @FXML
    private TableColumn<Receta, Integer> idRecetaColumn;
    @FXML
    private TableColumn<Receta, String> ciPacienteColumn;
    @FXML
    private TableColumn<Receta, String> ciMedicoColumn;
    @FXML
    private TableColumn<Receta, LocalDate> fechaEmisionColumn;
    @FXML
    private TableColumn<Receta, String> medicamentosColumn;
    @FXML
    private TableColumn<Receta, String> dosisColumn;

    @FXML
    private TextField numeroRecetaField;
    @FXML
    private TextField ciPacienteField;
    @FXML
    private TextField ciMedicoField;
    @FXML
    private TextField fechaEmisionField;
    @FXML
    private TextArea medicamentosField;
    @FXML
    private TextField dosisField;

    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private TableView<Receta> tablaRecetas;

    private final FacadeService facadeService;

    public GestionRecetasController() {
        this.facadeService = new FacadeService();
    }

    @FXML
    private void initialize() {
        configureTableColumns();
        loadRecetas();
        setupRowClickListener();
    }

    private void configureTableColumns() {
        idRecetaColumn.setCellValueFactory(new PropertyValueFactory<>("idReceta"));
        ciPacienteColumn.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));
        ciMedicoColumn.setCellValueFactory(new PropertyValueFactory<>("ciMedico"));
        fechaEmisionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaEmision"));
        medicamentosColumn.setCellValueFactory(new PropertyValueFactory<>("medicamentos"));
        dosisColumn.setCellValueFactory(new PropertyValueFactory<>("dosis"));
    }

    private void setupRowClickListener() {
        tablaRecetas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(Receta receta) {
        numeroRecetaField.setText(String.valueOf(receta.getIdReceta()));
        ciPacienteField.setText(receta.getCiPaciente());
        ciMedicoField.setText(receta.getCiMedico());
        fechaEmisionField.setText(receta.getFechaEmision().toString());
        medicamentosField.setText(receta.getMedicamentos());
        dosisField.setText(receta.getDosis());
    }

    private void loadRecetas() {
        tablaRecetas.getItems().clear();
        tablaRecetas.getItems().addAll(facadeService.getAllRecetas());
    }

    @FXML
    private void agregarReceta() {
        if (!validateFields()) return;

        Receta receta = buildRecetaFromFields();
        boolean success = facadeService.createReceta(receta);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Receta agregada exitosamente." : "Hubo un error al agregar la receta.");

        if (success) loadRecetas();
    }

    @FXML
    private void actualizarReceta() {
        Receta selectedReceta = tablaRecetas.getSelectionModel().getSelectedItem();
        if (selectedReceta == null) {
            showAlert(Alert.AlertType.WARNING, "Receta no seleccionada", "Por favor, seleccione una receta.");
            return;
        }

        Receta recetaActualizada = buildRecetaFromFields();
        boolean success = facadeService.updateReceta(recetaActualizada);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Receta actualizada exitosamente." : "Hubo un error al actualizar la receta.");

        if (success) loadRecetas();
    }

    @FXML
    private void eliminarReceta() {
        Receta selectedReceta = tablaRecetas.getSelectionModel().getSelectedItem();
        if (selectedReceta == null) {
            showAlert(Alert.AlertType.WARNING, "Receta no seleccionada", "Por favor, seleccione una receta.");
            return;
        }

        Optional<ButtonType> response = showConfirmation();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            boolean success = facadeService.deleteReceta(selectedReceta.getIdReceta());

            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Receta eliminada exitosamente." : "Hubo un error al eliminar la receta.");

            if (success) loadRecetas();
        }
    }

    @FXML
    private void buscarReceta() {
        // Implement search functionality if needed
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
        if (numeroRecetaField.getText().isEmpty() || ciPacienteField.getText().isEmpty() || ciMedicoField.getText().isEmpty() ||
                fechaEmisionField.getText().isEmpty() || medicamentosField.getText().isEmpty() || dosisField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    private Receta buildRecetaFromFields() {
        return new Receta.Builder()
                .idReceta(Integer.parseInt(numeroRecetaField.getText()))
                .ciPaciente(ciPacienteField.getText())
                .ciMedico(ciMedicoField.getText())
                .fechaEmision(LocalDate.parse(fechaEmisionField.getText()))
                .medicamentos(medicamentosField.getText())
                .dosis(dosisField.getText())
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
        alert.setContentText("¿Está seguro de que desea eliminar la receta seleccionada?");
        return alert.showAndWait();
    }
}
