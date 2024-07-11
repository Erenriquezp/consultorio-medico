package org.uce.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.uce.app.model.Paciente;
import org.uce.app.model.PacienteDAO;

public class GestionPacientesController {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField fechaNacimientoField;
    @FXML
    private TextField sexoField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField direccionField;
    @FXML
    private TableView<Paciente> tablaPacientes;

    private ObservableList<Paciente> listaPacientes;
    private PacienteDAO pacienteDAO;

    @FXML
    public void initialize() {
        pacienteDAO = new PacienteDAO();
        listaPacientes = FXCollections.observableArrayList((Paciente) pacienteDAO.getAllPacientes());
        tablaPacientes.setItems(listaPacientes);
    }

    @FXML
    private void agregarPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombreField.getText());
        paciente.setFechaNacimiento(fechaNacimientoField.getText());
        paciente.setSexo(sexoField.getText());
        paciente.setTelefono(telefonoField.getText());
        paciente.setEmail(emailField.getText());
        paciente.setDireccion(direccionField.getText());

        pacienteDAO.addPaciente(paciente);
        listaPacientes.add(paciente);

        nombreField.clear();
        fechaNacimientoField.clear();
        sexoField.clear();
        telefonoField.clear();
        emailField.clear();
        direccionField.clear();
    }
}