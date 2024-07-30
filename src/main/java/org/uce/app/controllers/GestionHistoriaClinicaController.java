package org.uce.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.model.HistoriaClinica;
import org.uce.app.services.FacadeService;
import org.uce.app.utilities.Paths;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class GestionHistoriaClinicaController {

    @FXML
    private TextField idHistoriaClinicaField;
    @FXML
    private TextField cedulaMedicoField;
    @FXML
    private TextField cedulaPacienteField;
    @FXML
    private TextField motivoConsultaField;
    @FXML
    private TextField antecedentesPersonalesField;
    @FXML
    private TextField antecedentesFamiliaresField;
    @FXML
    private TextField enfermedadesActualesField;
    @FXML
    private TextField revisionSentidosField;
    @FXML
    private TextField revisionRespiratorioField;
    @FXML
    private TextField revisionCardiovascularField;
    @FXML
    private TextField revisionDigestivoField;
    @FXML
    private TextField revisionGenitalesField;
    @FXML
    private TextField revisionUrinarioField;
    @FXML
    private TextField revisionMuscularField;
    @FXML
    private TextField revisionEndocrinoField;
    @FXML
    private TextField revisionHemoLinfaField;
    @FXML
    private TextField revisionNerviosoField;
    @FXML
    private DatePicker fechaMedicionField;
    @FXML
    private TextField temperaturaField;
    @FXML
    private TextField presionArterialField;
    @FXML
    private TextField pulsoFrecuenciaField;
    @FXML
    private TextField pesoTallaField;
    @FXML
    private TextField examenCabezaField;
    @FXML
    private TextField examenCuelloField;
    @FXML
    private TextField examenToraxField;
    @FXML
    private TextField examenAbdomenField;
    @FXML
    private TextField examenPelvisField;
    @FXML
    private TextField examenExtremidadesField;
    @FXML
    private TextField descripcionDiagnosticoField;
    @FXML
    private TextField codigoCIEField;
    @FXML
    private TableView<HistoriaClinica> tablaHistorial;
    @FXML
    private TableColumn<HistoriaClinica, String> columnIdHistoriaClinica;
    @FXML
    private TableColumn<HistoriaClinica, String> columnCedulaMedico;
    @FXML
    private TableColumn<HistoriaClinica, String> columnCedulaPaciente;
    @FXML
    private TableColumn<HistoriaClinica, LocalDate> columnFechaMedicion;
    @FXML
    private TableColumn<HistoriaClinica, String> columnDiagnostico;
    @FXML
    private Button buttonAddHClinic;
    @FXML
    private Button buttonUpdateHistoriC;
    @FXML
    private Button buttonDelateHistoriC;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;

    private final FacadeService facadeService;


    public GestionHistoriaClinicaController() {
        this.facadeService = new FacadeService();
    }

    @FXML
    private void initialize() {
        configureTableColumns();
        loadHistoriasClinicas();
        setupRowClickListener();
    }

    private void configureTableColumns() {
        columnIdHistoriaClinica.setCellValueFactory(new PropertyValueFactory<>("idHistoriaClinica"));
        columnCedulaMedico.setCellValueFactory(new PropertyValueFactory<>("ciMedico"));
        columnCedulaPaciente.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));
        columnFechaMedicion.setCellValueFactory(new PropertyValueFactory<>("svaFechaMedicion"));
        columnDiagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnosticoDesc"));
    }

    private void setupRowClickListener() {
        tablaHistorial.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(HistoriaClinica historiaClinica) {
        idHistoriaClinicaField.setText(historiaClinica.getIdHistoriaClinica());
        cedulaMedicoField.setText(historiaClinica.getCiMedico());
        cedulaPacienteField.setText(historiaClinica.getCiPaciente());
        motivoConsultaField.setText(historiaClinica.getMotivoConsulta());
        antecedentesPersonalesField.setText(historiaClinica.getAntecedentesPersonales());
        antecedentesFamiliaresField.setText(historiaClinica.getAntecedentesFamiliares());
        enfermedadesActualesField.setText(historiaClinica.getEnfermedadesActuales());
        revisionSentidosField.setText(historiaClinica.getRaosOrganosSentidos());
        revisionRespiratorioField.setText(historiaClinica.getRaosRespiratorio());
        revisionCardiovascularField.setText(historiaClinica.getRaosCardiovascular());
        revisionDigestivoField.setText(historiaClinica.getRaosDigestivo());
        revisionGenitalesField.setText(historiaClinica.getRaosGenital());
        revisionUrinarioField.setText(historiaClinica.getRaosUrinario());
        revisionMuscularField.setText(historiaClinica.getRaosMusculoEsqueletico());
        revisionEndocrinoField.setText(historiaClinica.getRaosEndocrino());
        revisionHemoLinfaField.setText(historiaClinica.getRaosHemoLinfatico());
        revisionNerviosoField.setText(historiaClinica.getRaosNervioso());
        fechaMedicionField.setValue(historiaClinica.getSvaFechaMedicion().toLocalDate());
        temperaturaField.setText(historiaClinica.getSvaTemperatura());
        presionArterialField.setText(historiaClinica.getSvaPresionArterial());
        pulsoFrecuenciaField.setText(historiaClinica.getSvaPulsoMinFreRespiratoria());
        pesoTallaField.setText(historiaClinica.getSvaPesoKgTallaCm());
        examenCabezaField.setText(historiaClinica.getEfrCabeza());
        examenCuelloField.setText(historiaClinica.getEfrCuello());
        examenToraxField.setText(historiaClinica.getEfrTorax());
        examenAbdomenField.setText(historiaClinica.getEfrAbdomen());
        examenPelvisField.setText(historiaClinica.getEfrPelvis());
        examenExtremidadesField.setText(historiaClinica.getEfrExtremidades());
        descripcionDiagnosticoField.setText(historiaClinica.getDiagnosticoDesc());
        codigoCIEField.setText(historiaClinica.getDiagnosticoCIE());
    }

    private void loadHistoriasClinicas() {
        tablaHistorial.getItems().clear();
        tablaHistorial.getItems().addAll(facadeService.getAllHistoriasClinicas());
    }

    @FXML
    private void agregarHistoriaClinica() {
        if (!validateFields()) return;

        HistoriaClinica historiaClinica = buildHistoriaClinicaFromFields();
        boolean success = facadeService.createHistoriaClinica(historiaClinica);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Historia clínica agregada exitosamente." : "Hubo un error al agregar la historia clínica.");

        if (success) loadHistoriasClinicas();
    }

    @FXML
    private void actualizarHistoriaClinica() {
        HistoriaClinica selectedHistoriaClinica = tablaHistorial.getSelectionModel().getSelectedItem();
        if (selectedHistoriaClinica == null) {
            showAlert(Alert.AlertType.WARNING, "Historia no seleccionada", "Por favor, seleccione una historia clínica.");
            return;
        }

        HistoriaClinica historiaActualizada = buildHistoriaClinicaFromFields();
        boolean success = facadeService.updateHistoriaClinica(historiaActualizada);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Historia clínica actualizada exitosamente." : "Hubo un error al actualizar la historia clínica.");

        if (success) loadHistoriasClinicas();
    }

    @FXML
    private void eliminarHistoriaClinica() {
        HistoriaClinica selectedHistoriaClinica = tablaHistorial.getSelectionModel().getSelectedItem();
        if (selectedHistoriaClinica == null) {
            showAlert(Alert.AlertType.WARNING, "Historia no seleccionada", "Por favor, seleccione una historia clínica.");
            return;
        }

        boolean success = facadeService.deleteHistoriaClinica(selectedHistoriaClinica.getIdHistoriaClinica());

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Historia clínica eliminada exitosamente." : "Hubo un error al eliminar la historia clínica.");

        if (success) loadHistoriasClinicas();
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonRegresar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    @FXML
    private void salir() {
        Stage stage = (Stage) buttonSalir.getScene().getWindow();
        stage.close();
    }

    private boolean validateFields() {
        return !idHistoriaClinicaField.getText().isEmpty() &&
                !cedulaMedicoField.getText().isEmpty() &&
                !cedulaPacienteField.getText().isEmpty() &&
                fechaMedicionField.getValue() != null &&
                !temperaturaField.getText().isEmpty() &&
                !presionArterialField.getText().isEmpty() &&
                !pulsoFrecuenciaField.getText().isEmpty() &&
                !pesoTallaField.getText().isEmpty();
    }

    private HistoriaClinica buildHistoriaClinicaFromFields() {
        // Recoge los valores de los campos del formulario
        String idHistoriaClinica = idHistoriaClinicaField.getText();
        String ciMedico = cedulaMedicoField.getText();  // Cambiado
        String ciPaciente = cedulaPacienteField.getText();  // Cambiado
        String motivoConsulta = motivoConsultaField.getText();
        String antecedentesPersonales = antecedentesPersonalesField.getText();
        String antecedentesFamiliares = antecedentesFamiliaresField.getText();
        String enfermedadesActuales = enfermedadesActualesField.getText();
        String revisionSentidos = revisionSentidosField.getText();  // Cambiado
        String revisionRespiratorio = revisionRespiratorioField.getText();
        String revisionCardiovascular = revisionCardiovascularField.getText();
        String revisionDigestivo = revisionDigestivoField.getText();
        String revisionGenitales = revisionGenitalesField.getText();  // Cambiado
        String revisionUrinario = revisionUrinarioField.getText();
        String revisionMuscular = revisionMuscularField.getText();  // Cambiado
        String revisionEndocrino = revisionEndocrinoField.getText();
        String revisionHemoLinfa = revisionHemoLinfaField.getText();  // Cambiado
        String revisionNervioso = revisionNerviosoField.getText();
        LocalDate fechaMedicion = fechaMedicionField.getValue();  // Cambiado
        String temperatura = temperaturaField.getText();  // Cambiado
        String presionArterial = presionArterialField.getText();  // Cambiado
        String pulsoFrecuencia = pulsoFrecuenciaField.getText();  // Cambiado
        String pesoTalla = pesoTallaField.getText();  // Cambiado
        String examenCabeza = examenCabezaField.getText();  // Cambiado
        String examenCuello = examenCuelloField.getText();  // Cambiado
        String examenTorax = examenToraxField.getText();  // Cambiado
        String examenAbdomen = examenAbdomenField.getText();  // Cambiado
        String examenPelvis = examenPelvisField.getText();  // Cambiado
        String examenExtremidades = examenExtremidadesField.getText();  // Cambiado
        String descripcionDiagnostico = descripcionDiagnosticoField.getText();  // Cambiado
        String codigoCIE = codigoCIEField.getText();  // Cambiado

        // Crea una instancia de HistoriaClinica usando el Builder
        return new HistoriaClinica.Builder()
                .idHistoriaClinica(idHistoriaClinica)
                .ciMedico(ciMedico)
                .ciPaciente(ciPaciente)
                .motivoConsulta(motivoConsulta)
                .antecedentesPersonales(antecedentesPersonales)
                .antecedentesFamiliares(antecedentesFamiliares)
                .enfermedadesActuales(enfermedadesActuales)
                .raosOrganosSentidos(revisionSentidos)  // Cambiado
                .raosRespiratorio(revisionRespiratorio)
                .raosCardiovascular(revisionCardiovascular)
                .raosDigestivo(revisionDigestivo)
                .raosGenital(revisionGenitales)  // Cambiado
                .raosUrinario(revisionUrinario)
                .raosMusculoEsqueletico(revisionMuscular)  // Cambiado
                .raosEndocrino(revisionEndocrino)
                .raosHemoLinfatico(revisionHemoLinfa)  // Cambiado
                .raosNervioso(revisionNervioso)
                .svaFechaMedicion(Date.valueOf(fechaMedicion))  // Cambiado
                .svaTemperatura(temperatura)  // Cambiado
                .svaPresionArterial(presionArterial)  // Cambiado
                .svaPulsoMinFreRespiratoria(pulsoFrecuencia)  // Cambiado
                .svaPesoKgTallaCm(pesoTalla)  // Cambiado
                .efrCabeza(examenCabeza)  // Cambiado
                .efrCuello(examenCuello)  // Cambiado
                .efrTorax(examenTorax)  // Cambiado
                .efrAbdomen(examenAbdomen)  // Cambiado
                .efrPelvis(examenPelvis)  // Cambiado
                .efrExtremidades(examenExtremidades)  // Cambiado
                .diagnosticoDesc(descripcionDiagnostico)  // Cambiado
                .diagnosticoCIE(codigoCIE)  // Cambiado
                .build();
    }


    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
