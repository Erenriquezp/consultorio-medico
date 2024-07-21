package org.uce.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setIdHistoriaClinica(idHistoriaClinicaField.getText());
        historiaClinica.setCiMedico(ciMedicoField.getText());
        historiaClinica.setCiPaciente(ciPacienteField.getText());
        historiaClinica.setMotivoConsulta(motivoConsultaField.getText());
        historiaClinica.setAntecedentesPersonales(antecedentesPersonalesField.getText());
        historiaClinica.setAntecedentesFamiliares(antecedentesFamiliaresField.getText());
        historiaClinica.setEnfermedadesActuales(enfermedadesActualesField.getText());
        historiaClinica.setRaosOrganosSentidos(raosOrganosSentidosField.getText());
        historiaClinica.setRaosRespiratorio(raosRespiratorioField.getText());
        historiaClinica.setRaosCardiovascular(raosCardiovascularField.getText());
        historiaClinica.setRaosDigestivo(raosDigestivoField.getText());
        historiaClinica.setRaosGenital(raosGenitalField.getText());
        historiaClinica.setRaosUrinario(raosUrinarioField.getText());
        historiaClinica.setRaosMusculoEsqueletico(raosMusculoEsqueleticoField.getText());
        historiaClinica.setRaosEndocrino(raosEndocrinoField.getText());
        historiaClinica.setRaosHemoLinfatico(raosHemoLinfaticoField.getText());
        historiaClinica.setRaosNervioso(raosNerviosoField.getText());
        historiaClinica.setSvaFechaMedicion(svaFechaMedicionField.getText());
        historiaClinica.setSvaTemperatura(svaTemperaturaField.getText());
        historiaClinica.setSvaPresionArterial(svaPresionArterialField.getText());
        historiaClinica.setSvaPulsoMinFreRespiratoria(svaPulsoMinFreRespiratoriaField.getText());
        historiaClinica.setSvaPesoKgTallaCm(svaPesoKgTallaCmField.getText());
        historiaClinica.setEfrCabeza(efrCabezaField.getText());
        historiaClinica.setEfrCuello(efrCuelloField.getText());
        historiaClinica.setEfrTorax(efrToraxField.getText());
        historiaClinica.setEfrAbdomen(efrAbdomenField.getText());
        historiaClinica.setEfrPelvs(efrPelvsField.getText());
        historiaClinica.setEfrExtremidades(efrExtremidadesField.getText());
        historiaClinica.setDiagnosticoDesc(diagnosticoDescField.getText());
        historiaClinica.setDiagnosticoCIE(diagnosticoCIEField.getText());

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
}
