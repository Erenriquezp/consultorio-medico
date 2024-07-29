package org.uce.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.uce.app.dao.HistoriaClinicaDAO;
import org.uce.app.model.HistoriaClinica;

import java.sql.SQLException;

public class HistoriaClinicaController {

    @FXML
    private TextField idHistoriaClinicaField;
    @FXML
    private TextField ciMedicoField;
    @FXML
    private TextField ciPacienteField;
    @FXML
    private TextArea motivoConsultaField;
    @FXML
    private TextArea antecedentesPersonalesField;
    @FXML
    private TextArea antecedentesFamiliaresField;
    @FXML
    private TextArea enfermedadesActualesField;
    @FXML
    private TextArea raosOrganosSentidosField;
    @FXML
    private TextArea raosRespiratorioField;
    @FXML
    private TextArea raosCardiovascularField;
    @FXML
    private TextArea raosDigestivoField;
    @FXML
    private TextArea raosGenitalField;
    @FXML
    private TextArea raosUrinarioField;
    @FXML
    private TextArea raosMusculoEsqueleticoField;
    @FXML
    private TextArea raosEndocrinoField;
    @FXML
    private TextArea raosHemoLinfaticoField;
    @FXML
    private TextArea raosNerviosoField;
    @FXML
    private TextField svaFechaMedicionField;
    @FXML
    private TextField svaTemperaturaField;
    @FXML
    private TextField svaPresionArterialField;
    @FXML
    private TextField svaPulsoMinFreRespiratoriaField;
    @FXML
    private TextField svaPesoKgTallaCmField;
    @FXML
    private TextArea efrCabezaField;
    @FXML
    private TextArea efrCuelloField;
    @FXML
    private TextArea efrToraxField;
    @FXML
    private TextArea efrAbdomenField;
    @FXML
    private TextArea efrPelvsField;
    @FXML
    private TextArea efrExtremidadesField;
    @FXML
    private TextArea diagnosticoDescField;
    @FXML
    private TextField diagnosticoCIEField;
    @FXML
    private TableView<HistoriaClinica> tablaHistoriasClinicas;

    private ObservableList<HistoriaClinica> listaHistoriasClinicas;
    private HistoriaClinicaDAO historiaClinicaDAO;

    @FXML
    public void initialize() throws SQLException {
        historiaClinicaDAO = new HistoriaClinicaDAO();
        listaHistoriasClinicas = FXCollections.observableArrayList(historiaClinicaDAO.obtenerTodasLasHistoriasClinicas());
        tablaHistoriasClinicas.setItems(listaHistoriasClinicas);
    }

    @FXML
    private void agregarHistoriaClinica() throws SQLException {
        HistoriaClinica historiaClinica = new HistoriaClinica.Builder()
                .idHistoriaClinica(idHistoriaClinicaField.getText())
                .ciMedico(ciMedicoField.getText())
                .ciPaciente(ciPacienteField.getText())
                .motivoConsulta(motivoConsultaField.getText())
                .antecedentesPersonales(antecedentesPersonalesField.getText())
                .antecedentesFamiliares(antecedentesFamiliaresField.getText())
                .enfermedadesActuales(enfermedadesActualesField.getText())
                .raosOrganosSentidos(raosOrganosSentidosField.getText())
                .raosRespiratorio(raosRespiratorioField.getText())
                .raosCardiovascular(raosCardiovascularField.getText())
                .raosDigestivo(raosDigestivoField.getText())
                .raosGenital(raosGenitalField.getText())
                .raosUrinario(raosUrinarioField.getText())
                .raosMusculoEsqueletico(raosMusculoEsqueleticoField.getText())
                .raosEndocrino(raosEndocrinoField.getText())
                .raosHemoLinfatico(raosHemoLinfaticoField.getText())
                .raosNervioso(raosNerviosoField.getText())
                .svaFechaMedicion(svaFechaMedicionField.getText())
                .svaTemperatura(svaTemperaturaField.getText())
                .svaPresionArterial(svaPresionArterialField.getText())
                .svaPulsoMinFreRespiratoria(svaPulsoMinFreRespiratoriaField.getText())
                .svaPesoKgTallaCm(svaPesoKgTallaCmField.getText())
                .efrCabeza(efrCabezaField.getText())
                .efrCuello(efrCuelloField.getText())
                .efrTorax(efrToraxField.getText())
                .efrAbdomen(efrAbdomenField.getText())
                .efrPelvs(efrPelvsField.getText())
                .efrExtremidades(efrExtremidadesField.getText())
                .diagnosticoDesc(diagnosticoDescField.getText())
                .diagnosticoCIE(diagnosticoCIEField.getText())
                .build();


        historiaClinicaDAO.crearHistoriaClinica(historiaClinica);
        listaHistoriasClinicas.add(historiaClinica);

        limpiarCampos();
    }

    private void limpiarCampos() {
        idHistoriaClinicaField.clear();
        ciMedicoField.clear();
        ciPacienteField.clear();
        motivoConsultaField.clear();
        antecedentesPersonalesField.clear();
        antecedentesFamiliaresField.clear();
        enfermedadesActualesField.clear();
        raosOrganosSentidosField.clear();
        raosRespiratorioField.clear();
        raosCardiovascularField.clear();
        raosDigestivoField.clear();
        raosGenitalField.clear();
        raosUrinarioField.clear();
        raosMusculoEsqueleticoField.clear();
        raosEndocrinoField.clear();
        raosHemoLinfaticoField.clear();
        raosNerviosoField.clear();
        svaFechaMedicionField.clear();
        svaTemperaturaField.clear();
        svaPresionArterialField.clear();
        svaPulsoMinFreRespiratoriaField.clear();
        svaPesoKgTallaCmField.clear();
        efrCabezaField.clear();
        efrCuelloField.clear();
        efrToraxField.clear();
        efrAbdomenField.clear();
        efrPelvsField.clear();
        efrExtremidadesField.clear();
        diagnosticoDescField.clear();
        diagnosticoCIEField.clear();
    }

    public void eliminarHistoria(ActionEvent actionEvent) {
    }

    public void actualizarHistoria(ActionEvent actionEvent) {
    }
}
