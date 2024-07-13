package org.uce.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import org.uce.app.model.Cita;
import org.uce.app.model.CitaDAO;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GestionCitasController {

    @FXML
    private TextField idMedicoField;
    @FXML
    private TextField idPacienteField;
    @FXML
    private DatePicker fechaField;
    @FXML
    private TextField horaField;
    @FXML
    private TextArea motivoField;
    @FXML
    private TableView<Cita> tablaCitas;

    private ObservableList<Cita> listaCitas;
    private CitaDAO citaDAO;

    @FXML
    public void initialize() {
        citaDAO = new CitaDAO();
        listaCitas = FXCollections.observableArrayList((Cita) citaDAO.getAllCitas());
        tablaCitas.setItems(listaCitas);
    }

    @FXML
    private void agregarCita() {
        Cita cita = new Cita();
//        cita.setId_cita("1");
//        cita.setCi_paciente("123");
//        cita.setCi_medico(idPacienteField.getText());

        //cita.setIdMedico(Integer.parseInt(idMedicoField.getText()));
        //cita.setIdPaciente(Integer.parseInt(idPacienteField.getText()));
        cita.setMotivo(motivoField.getText());
        cita.setEstado("pendiente");

        citaDAO.addCita(cita);
        listaCitas.add(cita);

        idMedicoField.clear();
        idPacienteField.clear();
        fechaField.setValue(null);
        horaField.clear();
        motivoField.clear();
    }
}