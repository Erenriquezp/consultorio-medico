package org.uce.app.controllers; // Paquete en el que se encuentra esta clase

import javafx.collections.FXCollections; // Importa la clase FXCollections para manejar colecciones observables
import javafx.collections.ObservableList; // Importa la interfaz ObservableList para listas observables
import javafx.fxml.FXML; // Importa la anotación FXML para marcar métodos y campos
import javafx.scene.control.TableView; // Importa la clase TableView para tablas de JavaFX
import javafx.scene.control.TextArea; // Importa la clase TextArea para áreas de texto
import javafx.scene.control.TextField; // Importa la clase TextField para campos de texto
import org.uce.app.model.HistorialMedico; // Importa la clase HistorialMedico del modelo
import org.uce.app.model.HistorialMedicoDAO; // Importa la clase HistorialMedicoDAO para acceso a la base de datos

public class HistorialMedicoController {

    @FXML
    private TextField idPacienteField; // Campo de texto para el ID del paciente
    @FXML
    private TextField fechaField; // Campo de texto para la fecha
    @FXML
    private TextArea diagnosticoField; // Área de texto para el diagnóstico
    @FXML
    private TextArea tratamientoField; // Área de texto para el tratamiento
    @FXML
    private TableView<HistorialMedico> tablaHistorial; // Tabla para mostrar el historial médico

    private ObservableList<HistorialMedico> listaHistorial; // Lista observable para los datos del historial médico
    private HistorialMedicoDAO historialMedicoDAO; // Objeto DAO para acceder a la base de datos

    // Método que se llama al inicializar el controlador
    @FXML
    public void initialize() {
        // Inicializa el DAO
        historialMedicoDAO = new HistorialMedicoDAO();
        // Obtiene todos los registros de historial médico y los convierte a una lista observable
        listaHistorial = FXCollections.observableArrayList((HistorialMedico) historialMedicoDAO.getAllHistorialMedico());
        // Establece los datos de la lista en la tabla
        tablaHistorial.setItems(listaHistorial);
    }

    // Método para agregar una nueva entrada al historial médico
    @FXML
    private void agregarEntrada() {
        // Crea una nueva instancia de HistorialMedico y establece sus propiedades
        HistorialMedico historial = new HistorialMedico();
        historial.setIdPaciente(Integer.parseInt(idPacienteField.getText())); // Establece el ID del paciente
        historial.setFecha(fechaField.getText()); // Establece la fecha
        historial.setDiagnostico(diagnosticoField.getText()); // Establece el diagnóstico
        historial.setTratamiento(tratamientoField.getText()); // Establece el tratamiento

        // Agrega la nueva entrada a la base de datos
        historialMedicoDAO.addHistorialMedico(historial);
        // Agrega la nueva entrada a la lista observable
        listaHistorial.add(historial);

        // Limpia los campos de texto después de agregar la entrada
        idPacienteField.clear();
        fechaField.clear();
        diagnosticoField.clear();
        tratamientoField.clear();
    }
}
