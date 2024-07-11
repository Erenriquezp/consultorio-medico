package org.uce.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.uce.app.model.HistorialMedico;
import org.uce.app.model.HistorialMedicoDAO;

public class HistorialMedicoController {

    @FXML
    private TextField idPacienteField;
    @FXML
    private TextField fechaField;
    @FXML
    private TextArea diagnosticoField;
    @FXML
    private TextArea tratamientoField;
    @FXML
    private TableView<HistorialMedico> tablaHistorial;

    private ObservableList<HistorialMedico> listaHistorial;
    private HistorialMedicoDAO historialMedicoDAO;

    @FXML
    public void initialize() {
        historialMedicoDAO = new HistorialMedicoDAO();
        listaHistorial = FXCollections.observableArrayList((HistorialMedico) historialMedicoDAO.getAllHistorialMedico());
        tablaHistorial.setItems(listaHistorial);
    }

    @FXML
    private void agregarEntrada() {
        HistorialMedico historial = new HistorialMedico();
        historial.setIdPaciente(Integer.parseInt(idPacienteField.getText()));
        historial.setFecha(fechaField.getText());
        historial.setDiagnostico(diagnosticoField.getText());
        historial.setTratamiento(tratamientoField.getText());

        historialMedicoDAO.addHistorialMedico(historial);
        listaHistorial.add(historial);

        idPacienteField.clear();
        fechaField.clear();
        diagnosticoField.clear();
        tratamientoField.clear();
    }
}