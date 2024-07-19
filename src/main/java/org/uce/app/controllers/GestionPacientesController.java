package org.uce.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPacientesController {

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
    private TextField direccionRecidenciaField;
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
    private TextField fechaNacimientoField;
    @FXML
    private TextField lugarNacimientoField;
    @FXML
    private TextField nacionalidadField;
    @FXML
    private TextField edadField;
    @FXML
    private TextField instruccionField;
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
    private TableView<?> tablaPacientes;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private Button buttonAgregaPaciente;

    @FXML
    private void initialize() {
        // Initialize the menu items for Grupo Cultural
        List<MenuItem> grupoCulturalItems = new ArrayList<>();
        grupoCulturalItems.add(new MenuItem("Afroecuatoriana"));
        grupoCulturalItems.add(new MenuItem("Indígena"));
        grupoCulturalItems.add(new MenuItem("Mestiza"));
        grupoCulturalItems.add(new MenuItem("Montubia"));
        grupoCulturalItems.add(new MenuItem("Blanca"));

//        grupoCulturalItems.forEach(item -> item.setOnAction(e -> grupoCulturalMenu.setText(item.getText())));
//        grupoCulturalMenu.getItems().addAll(grupoCulturalItems);

        // Initialize the menu items for Estado Civil
        List<MenuItem> estadoCivilItems = new ArrayList<>();
        estadoCivilItems.add(new MenuItem("SOL"));
        estadoCivilItems.add(new MenuItem("CAS"));
        estadoCivilItems.add(new MenuItem("VIU"));

//        estadoCivilItems.forEach(item -> item.setOnAction(e -> estadoCivilMenu.setText(item.getText())));
//        estadoCivilMenu.getItems().addAll(estadoCivilItems);
    }

    @FXML
    private void agregarPaciente() {
        // Lógica para agregar un nuevo paciente
        // Ejemplo de obtención de datos de los campos de texto
        String ciPaciente = ciPacienteField.getText();
        String primerNombre = primerNombreField.getText();
        String segundoNombre = segundoNombreField.getText();
        String apellidoPaterno = apellidoPaternoField.getText();
        String apellidoMaterno = apellidoMaternoField.getText();
        String direccionRecidencia = direccionRecidenciaField.getText();
        String barrio = barrioField.getText();
        String parroquia = parroquiaField.getText();
        String canton = cantonField.getText();
        String provincia = provinciaField.getText();
        String telefono = telefonoField.getText();
        String fechaNacimiento = fechaNacimientoField.getText();
        String lugarNacimiento = lugarNacimientoField.getText();
        String nacionalidad = nacionalidadField.getText();
        String edad = edadField.getText();
        String instruccion = instruccionField.getText();
        String ocupacion = ocupacionField.getText();
        String lugarTrabajo = lugarTrabajoField.getText();
        String tipoSeguro = tipoSeguroField.getText();
        String referencia = referenciaField.getText();
        String contactoEmergenciaParentesco = contactoEmergenciaParentescoField.getText();
        String contactoEmergenciaNombre = contactoEmergenciaNombreField.getText();
        String contactoEmergenciaDireccion = contactoEmergenciaDireccionField.getText();
        String contactoEmergenciaTelefono = contactoEmergenciaTelefonoField.getText();
        String grupoCultural = grupoCulturalMenu.getText();
        String estadoCivil = estadoCivilMenu.getText();
        String fechaAdmision = fechaAdmisionPicker.getValue().toString();

        // Aquí puedes agregar la lógica para guardar los datos en la base de datos
    }

    @FXML
    private void regresar() {
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
