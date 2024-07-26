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
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;

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
    public Button buttonActualizarPaciente;
    public Button buttonEliminarPaciente;

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
        setupRowClickListener();
    }
    private void loadPacientes() {
        tablaPacientes.getItems().clear();
        tablaPacientes.getItems().addAll(pacienteService.getAllPacientes());
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

        // Rellenar otros campos...
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
        Paciente paciente = new Paciente.PacienteBuilder()
                .ciPaciente(ciPaciente)
                .primerNombre(primerNombre)
                .segundoNombre(segundoNombre)
                .apellidoPaterno(apellidoPaterno)
                .apellidoMaterno(apellidoMaterno)
                .direccionResidencia(direccionResidencia)
                .barrio(barrio)
                .parroquia(parroquia)
                .canton(canton)
                .provincia(provincia)
                .telefono(telefono)
                .fechaNacimiento(fechaNacimiento)
                .lugarNacimiento(lugarNacimiento)
                .nacionalidad(nacionalidad)
                .grupoCultural(grupoCultural)
                .edad(edad)
                .estadoCivil(estadoCivil)
                .instruccionUltimoAnio(instruccionUltimoAnio)
                .fechaAdmision(fechaAdmision)
                .ocupacion(ocupacion)
                .lugarTrabajo(lugarTrabajo)
                .tipoSeguro(tipoSeguro)
                .referencia(referencia)
                .contactoEmergenciaParentesco(contactoEmergenciaParentesco)
                .contactoEmergenciaNombre(contactoEmergenciaNombre)
                .contactoEmergenciaDireccion(contactoEmergenciaDireccion)
                .contactoEmergenciaTelefono(contactoEmergenciaTelefono)
                .build();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPaciente(ActionEvent actionEvent) {
        Paciente selectedPaciente = tablaPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No hay paciente seleccionado");
            alert.setContentText("Por favor, seleccione un paciente de la tabla.");
            alert.showAndWait();
            return;
        }

        // Obtener los datos actualizados de los campos de texto
        if (pacienteService.updatePaciente(new Paciente.PacienteBuilder()
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
                .build())){
            loadPacientes();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Paciente actualizado");
            alert.setContentText("El paciente ha sido actualizado exitosamente.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al actualizar paciente");
            alert.setContentText("Hubo un problema al actualizar el paciente. Por favor, intente de nuevo.");
            alert.showAndWait();
        }
    }

    public void eliminarPaciente(ActionEvent actionEvent) {
        Paciente selectedPaciente = tablaPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No hay paciente seleccionado");
            alert.setContentText("Por favor, seleccione un paciente de la tabla.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmación");
        confirmAlert.setHeaderText("Confirmar eliminación");
        confirmAlert.setContentText("¿Está seguro de que desea eliminar al paciente seleccionado?");
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                if (pacienteService.deletePaciente(selectedPaciente.getCiPaciente())) {
                    loadPacientes();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setHeaderText("Paciente eliminado");
                    alert.setContentText("El paciente ha sido eliminado exitosamente.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al eliminar paciente");
                    alert.setContentText("Hubo un problema al eliminar el paciente. Por favor, intente de nuevo.");
                    alert.showAndWait();
                }
            }
        });
    }
}
