package org.uce.app.services;

import org.uce.app.model.Paciente;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class PacienteServiceProxy implements PacienteServiceInterface {
    private static final Logger logger = Logger.getLogger(PacienteServiceProxy.class.getName());
    private final PacienteServiceInterface pacienteService;

    public PacienteServiceProxy(PacienteServiceInterface pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    public boolean createPaciente(Paciente paciente) {
        logActivity("Creating patient: " + paciente + " at " + LocalDateTime.now());
        boolean result = pacienteService.createPaciente(paciente);
        logActivity("Patient creation result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public List<Paciente> getAllPacientes() {
        logActivity("Fetching all patients at " + LocalDateTime.now());
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        logActivity("Number of patients retrieved: " + pacientes.size() + " at " + LocalDateTime.now());
        return pacientes;
    }

    @Override
    public Paciente getPacienteByCi(String ciPaciente) {
        logActivity("Fetching patient by CI: " + ciPaciente + " at " + LocalDateTime.now());
        Paciente paciente = pacienteService.getPacienteByCi(ciPaciente);
        logActivity("Patient retrieved: " + paciente + " at " + LocalDateTime.now());
        return paciente;
    }

    @Override
    public boolean updatePaciente(Paciente paciente) {
        logActivity("Updating patient: " + paciente + " at " + LocalDateTime.now());
        boolean result = pacienteService.updatePaciente(paciente);
        logActivity("Patient update result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean deletePaciente(String ciPaciente) {
        logActivity("Deleting patient with CI: " + ciPaciente + " at " + LocalDateTime.now());
        boolean result = pacienteService.deletePaciente(ciPaciente);
        logActivity("Patient deletion result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    private void logActivity(String message) {
        // Logging implementation using Logger
        logger.info(message);
    }
}
