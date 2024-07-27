package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Paciente;
import org.uce.app.services.PacienteService;
import org.uce.app.services.PacienteServiceProxy; // Importar el proxy
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;

public class GestionPacientesController {

    @FXML
    private TextField instruccionField, ciPacienteField, primerNombreField, segundoNombreField,
            apellidoPaternoField, apellidoMaternoField, direccionResidenciaField,
            barrioField, parroquiaField, cantonField, provinciaField, telefonoField,
            lugarNacimientoField, nacionalidadField, edadField, ocupacionField,
            lugarTrabajoField, tipoSeguroField, referenciaField,
            contactoEmergenciaParentescoField, contactoEmergenciaNombreField,
            contactoEmergenciaDireccionField, contactoEmergenciaTelefonoField;

    @FXML
    private TableColumn<Paciente, String> ciPacienteColumn, primerNombreColumn, segundoNombreColumn,
            apellidoPaternoColumn, apellidoMaternoColumn,
            direccionResidenciaColumn, barrioColumn, parroquiaColumn,
            cantonColumn, provinciaColumn, telefonoColumn,
            lugarNacimientoColumn, nacionalidadColumn,
            estadoCivilColumn, instruccionColumn, lugarTrabajoColumn,
            referenciaColumn, contactoEmergenciaNombreColumn,
            tipoSeguroColumn, ocupacionColumn,
            contactoEmergenciaParentescoColumn,
            contactoEmergenciaDireccionColumn,
            contactoEmergenciaTelefonoColumn;

    @FXML
    private TableColumn<Paciente, LocalDate> fechaNacimientoColumn, fechaAdmisionColumn;

    @FXML
    private TableColumn<Paciente, Integer> edadColumn;

    @FXML
    private Button buttonRegresar, buttonSalir;

    @FXML
    private DatePicker fechaNacimientoField, fechaAdmisionPicker;

    @FXML
    private SplitMenuButton grupoCulturalMenu, estadoCivilMenu;

    @FXML
    private TableView<Paciente> tablaPacientes;

    private final PacienteServiceProxy pacienteServiceProxy;

    public GestionPacientesController() {
        // Inicializar el servicio real
        PacienteService pacienteService = new PacienteService();

        // Inicializar el proxy con el servicio real
        this.pacienteServiceProxy = new PacienteServiceProxy(pacienteService);
    }

    @FXML
    private void initialize() {
        initializeTableColumns();
        loadPacientes();
        setupRowClickListener();
    }

    private void initializeTableColumns() {
        // Initialize table columns
        ciPacienteColumn.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));
        primerNombreColumn.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
        segundoNombreColumn.setCellValueFactory(new PropertyValueFactory<>("segundoNombre"));
        apellidoPaternoColumn.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        apellidoMaternoColumn.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        direccionResidenciaColumn.setCellValueFactory(new PropertyValueFactory<>("direccionResidencia"));
        barrioColumn.setCellValueFactory(new PropertyValueFactory<>("barrio"));
        parroquiaColumn.setCellValueFactory(new PropertyValueFactory<>("parroquia"));
        cantonColumn.setCellValueFactory(new PropertyValueFactory<>("canton"));
        provinciaColumn.setCellValueFactory(new PropertyValueFactory<>("provincia"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        fechaNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        lugarNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("lugarNacimiento"));
        nacionalidadColumn.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
        instruccionColumn.setCellValueFactory(new PropertyValueFactory<>("instruccionUltimoAnio"));
        fechaAdmisionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaAdmision"));
        ocupacionColumn.setCellValueFactory(new PropertyValueFactory<>("ocupacion"));
        lugarTrabajoColumn.setCellValueFactory(new PropertyValueFactory<>("lugarTrabajo"));
        tipoSeguroColumn.setCellValueFactory(new PropertyValueFactory<>("tipoSeguro"));
        referenciaColumn.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        contactoEmergenciaNombreColumn.setCellValueFactory(new PropertyValueFactory<>("contactoEmergenciaNombre"));
        contactoEmergenciaParentescoColumn.setCellValueFactory(new PropertyValueFactory<>("contactoEmergenciaParentesco"));
        contactoEmergenciaDireccionColumn.setCellValueFactory(new PropertyValueFactory<>("contactoEmergenciaDireccion"));
        contactoEmergenciaTelefonoColumn.setCellValueFactory(new PropertyValueFactory<>("contactoEmergenciaTelefono"));
    }

    private void loadPacientes() {
        tablaPacientes.getItems().clear();
        tablaPacientes.getItems().addAll(pacienteServiceProxy.getAllPacientes());
    }

    private void setupRowClickListener() {
        tablaPacientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(Paciente paciente) {
        ciPacienteField.setText(paciente.getCiPaciente());
        primerNombreField.setText(paciente.getPrimerNombre());
        segundoNombreField.setText(paciente.getSegundoNombre());
        apellidoPaternoField.setText(paciente.getApellidoPaterno());
        apellidoMaternoField.setText(paciente.getApellidoMaterno());
        direccionResidenciaField.setText(paciente.getDireccionResidencia());
        barrioField.setText(paciente.getBarrio());
        parroquiaField.setText(paciente.getParroquia());
        cantonField.setText(paciente.getCanton());
        provinciaField.setText(paciente.getProvincia());
        telefonoField.setText(paciente.getTelefono());
        fechaNacimientoField.setValue(paciente.getFechaNacimiento());
        lugarNacimientoField.setText(paciente.getLugarNacimiento());
        nacionalidadField.setText(paciente.getNacionalidad());
        grupoCulturalMenu.setText(paciente.getGrupoCultural());
        edadField.setText(paciente.getEdad().toString());
        estadoCivilMenu.setText(paciente.getEstadoCivil());
        instruccionField.setText(paciente.getInstruccionUltimoAnio());
        fechaAdmisionPicker.setValue(paciente.getFechaAdmision());
        ocupacionField.setText(paciente.getOcupacion());
        lugarTrabajoField.setText(paciente.getLugarTrabajo());
        tipoSeguroField.setText(paciente.getTipoSeguro());
        referenciaField.setText(paciente.getReferencia());
        contactoEmergenciaParentescoField.setText(paciente.getContactoEmergenciaParentesco());
        contactoEmergenciaNombreField.setText(paciente.getContactoEmergenciaNombre());
        contactoEmergenciaDireccionField.setText(paciente.getContactoEmergenciaDireccion());
        contactoEmergenciaTelefonoField.setText(paciente.getContactoEmergenciaTelefono());
    }

    @FXML
    private void agregarPaciente() {
        try {
            Paciente paciente = buildPacienteFromFields();
            boolean success = pacienteServiceProxy.createPaciente(paciente);
            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Paciente agregado exitosamente." : "Hubo un error al agregar el paciente.");
            if (success) {
                loadPacientes();
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error de formato", "Edad debe ser un número entero.");
        }
    }

    private Paciente buildPacienteFromFields() {
        return new Paciente.PacienteBuilder()
                .ciPaciente(ciPacienteField.getText())
                .primerNombre(primerNombreField.getText())
                .segundoNombre(segundoNombreField.getText())
                .apellidoPaterno(apellidoPaternoField.getText())
                .apellidoMaterno(apellidoMaternoField.getText())
                .direccionResidencia(direccionResidenciaField.getText())
                .barrio(barrioField.getText())
                .parroquia(parroquiaField.getText())
                .canton(cantonField.getText())
                .provincia(provinciaField.getText())
                .telefono(telefonoField.getText())
                .fechaNacimiento(fechaNacimientoField.getValue())
                .lugarNacimiento(lugarNacimientoField.getText())
                .nacionalidad(nacionalidadField.getText())
                .grupoCultural(grupoCulturalMenu.getText())
                .edad(Integer.parseInt(edadField.getText()))
                .estadoCivil(estadoCivilMenu.getText())
                .instruccionUltimoAnio(instruccionField.getText())
                .fechaAdmision(fechaAdmisionPicker.getValue())
                .ocupacion(ocupacionField.getText())
                .lugarTrabajo(lugarTrabajoField.getText())
                .tipoSeguro(tipoSeguroField.getText())
                .referencia(referenciaField.getText())
                .contactoEmergenciaParentesco(contactoEmergenciaParentescoField.getText())
                .contactoEmergenciaNombre(contactoEmergenciaNombreField.getText())
                .contactoEmergenciaDireccion(contactoEmergenciaDireccionField.getText())
                .contactoEmergenciaTelefono(contactoEmergenciaTelefonoField.getText())
                .build();
    }

    @FXML
    private void handleGrupoCulturalMenuAction(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        grupoCulturalMenu.setText(menuItem.getText());
    }

    @FXML
    private void handleEstadoCivilMenuAction(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        estadoCivilMenu.setText(menuItem.getText());
    }

    @FXML
    private void eliminarPaciente() {
        Paciente paciente = tablaPacientes.getSelectionModel().getSelectedItem();
        if (paciente != null) {
            boolean success = pacienteServiceProxy.deletePaciente(paciente.getCiPaciente());
            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Paciente eliminado exitosamente." : "Hubo un error al eliminar el paciente.");
            if (success) {
                loadPacientes();
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Seleccionar Paciente", "Por favor, seleccione un paciente para eliminar.");
        }
    }

    @FXML
    private void actualizarPaciente() {
        Paciente selectedPaciente = tablaPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente != null) {
            try {
                Paciente pacienteActualizado = buildPacienteFromFields();
                boolean success = pacienteServiceProxy.updatePaciente(pacienteActualizado);
                showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                        success ? "Éxito" : "Error",
                        success ? "Paciente actualizado exitosamente." : "Hubo un error al actualizar el paciente.");
                if (success) {
                    loadPacientes();
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error de formato", "Edad debe ser un número entero.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Seleccionar Paciente", "Por favor, seleccione un paciente para actualizar.");
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

    private void closeStage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
