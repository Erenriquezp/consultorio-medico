package org.uce.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.Paciente;
import org.uce.app.services.PacienteService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionPacientesController {

    @FXML
    public TextField instruccionField;
    @FXML
    public TableColumn<Paciente, String> ciPacienteColumn;
    @FXML
    public TableColumn<Paciente, String> primerNombreColumn;
    @FXML
    public TableColumn<Paciente, String> segundoNombreColumn;
    @FXML
    public TableColumn<Paciente, String> apellidoPaternoColumn;
    @FXML
    public TableColumn<Paciente, String> apellidoMaternoColumn;
    @FXML
    public TableColumn<Paciente, String> direccionResidenciaColumn;
    @FXML
    public TableColumn<Paciente, String> barrioColumn;
    @FXML
    public TableColumn<Paciente, String> parroquiaColumn;
    @FXML
    public TableColumn<Paciente, String> cantonColumn;
    @FXML
    public TableColumn<Paciente, String> provinciaColumn;
    @FXML
    public TableColumn<Paciente, String> telefonoColumn;
    @FXML
    public TableColumn<Paciente, LocalDate> fechaNacimientoColumn;
    @FXML
    public TableColumn<Paciente, String> lugarNacimientoColumn;
    @FXML
    public TableColumn<Paciente, String> nacionalidadColumn;
    @FXML
    public TableColumn<Paciente, Integer> edadColumn;
    @FXML
    public TableColumn<Paciente, String> estadoCivilColumn;
    @FXML
    public TableColumn<Paciente, String> instruccionColumn;
    @FXML
    public TableColumn<Paciente, LocalDate> fechaAdmisionColumn;
    @FXML
    public TableColumn<Paciente, String> lugarTrabajoColumn;
    @FXML
    public TableColumn<Paciente, String> referenciaColumn;
    @FXML
    public TableColumn<Paciente, String> contactoEmergenciaNombreColumn;
    @FXML
    public TableColumn<Paciente, String> tipoSeguroColumn;
    @FXML
    public TableColumn<Paciente, String> ocupacionColumn;
    @FXML
    public TableColumn<Paciente, String> contactoEmergenciaParentescoColumn;
    @FXML
    public TableColumn<Paciente, String> contactoEmergenciaDireccionColumn;
    @FXML
    public TableColumn<Paciente, String> contactoEmergenciaTelefonoColumn;

    @FXML
    private TextField ciPacienteField;
    @FXML
    private TextField primerNombreField;
    @FXML
    private TextField segundoNombreField;
    @FXML
    private TextField apellidoPaternoField;
    @FXML
    private TextField apellidoMaternoField;
    @FXML
    private TextField direccionResidenciaField;
    @FXML
    private TextField barrioField;
    @FXML
    private TextField parroquiaField;
    @FXML
    private TextField cantonField;
    @FXML
    private TextField provinciaField;
    @FXML
    private TextField telefonoField;
    @FXML
    private DatePicker fechaNacimientoField;
    @FXML
    private TextField lugarNacimientoField;
    @FXML
    private TextField nacionalidadField;
    @FXML
    private TextField edadField;
    @FXML
    private TextField ocupacionField;
    @FXML
    private TextField lugarTrabajoField;
    @FXML
    private TextField tipoSeguroField;
    @FXML
    private TextField referenciaField;
    @FXML
    private TextField contactoEmergenciaParentescoField;
    @FXML
    private TextField contactoEmergenciaNombreField;
    @FXML
    private TextField contactoEmergenciaDireccionField;
    @FXML
    private TextField contactoEmergenciaTelefonoField;
    @FXML
    private SplitMenuButton grupoCulturalMenu;
    @FXML
    private SplitMenuButton estadoCivilMenu;
    @FXML
    private DatePicker fechaAdmisionPicker;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private Button buttonAgregaPaciente;

    @FXML
    private TableView<Paciente> tablaPacientes;

    private final PacienteService pacienteService;

    public GestionPacientesController() {
        pacienteService = new PacienteService();
    }
    @FXML
    private void initialize() {
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

        loadPacientes();
    }
    private void loadPacientes() {
        tablaPacientes.getItems().clear();
        tablaPacientes.getItems().addAll(pacienteService.getAllPacientes());
    }
    @FXML
    private void agregarPaciente() {
        // Obtener los datos ingresados en los campos de texto
        String ciPaciente = ciPacienteField.getText();
        String primerNombre = primerNombreField.getText();
        String segundoNombre = segundoNombreField.getText();
        String apellidoPaterno = apellidoPaternoField.getText();
        String apellidoMaterno = apellidoMaternoField.getText();
        String direccionResidencia = direccionResidenciaField.getText();
        String barrio = barrioField.getText();
        String parroquia = parroquiaField.getText();
        String canton = cantonField.getText();
        String provincia = provinciaField.getText();
        String telefono = telefonoField.getText();
        LocalDate fechaNacimiento = fechaNacimientoField.getValue();
        String lugarNacimiento = lugarNacimientoField.getText();
        String nacionalidad = nacionalidadField.getText();
        String grupoCultural = grupoCulturalMenu.getText();
        Integer edad = Integer.parseInt(edadField.getText());
        String estadoCivil = estadoCivilMenu.getText();
        String instruccionUltimoAnio = instruccionField.getText();
        LocalDate fechaAdmision = fechaAdmisionPicker.getValue();
        String ocupacion = ocupacionField.getText();
        String lugarTrabajo = lugarTrabajoField.getText();
        String tipoSeguro = tipoSeguroField.getText();
        String referencia = referenciaField.getText();
        String contactoEmergenciaParentesco = contactoEmergenciaParentescoField.getText();
        String contactoEmergenciaNombre = contactoEmergenciaNombreField.getText();
        String contactoEmergenciaDireccion = contactoEmergenciaDireccionField.getText();
        String contactoEmergenciaTelefono = contactoEmergenciaTelefonoField.getText();

        // Crear una instancia de Paciente con los datos ingresados
        Paciente paciente = new Paciente(ciPaciente, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno,
                direccionResidencia, barrio, parroquia, canton, provincia, telefono, fechaNacimiento, lugarNacimiento,
                nacionalidad, grupoCultural, edad, estadoCivil, instruccionUltimoAnio, fechaAdmision, ocupacion,
                lugarTrabajo, tipoSeguro, referencia, contactoEmergenciaParentesco, contactoEmergenciaNombre,
                contactoEmergenciaDireccion, contactoEmergenciaTelefono);

        // Intentar agregar el paciente usando PacienteService
        boolean success = pacienteService.createPaciente(paciente);

        // Mostrar un mensaje según el resultado de la operación
        Alert alert;
        if (success) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Paciente agregado exitosamente.");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al agregar el paciente.");
        }
        alert.showAndWait();
    }
    // Métodos para manejar la acción de los SplitMenuButton
    @FXML
    private void handleGrupoCulturalMenuAction(javafx.event.ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        grupoCulturalMenu.setText(menuItem.getText());
    }
    @FXML
    private void handleEstadoCivilMenuAction(javafx.event.ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        estadoCivilMenu.setText(menuItem.getText());
    }
    @FXML
    private void handleRegresar() {
        // Regresar a la pantalla principal
        Stage stage = (Stage) buttonRegresar.getScene().getWindow();
        stage.close();
        cargarPantallaPrincipal();
    }

    @FXML
    private void handleSalir() {
        // Salir de la aplicación
        Stage stage = (Stage) buttonSalir.getScene().getWindow();
        stage.close();
    }

    private void cargarPantallaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Paths.PantallaPrincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
