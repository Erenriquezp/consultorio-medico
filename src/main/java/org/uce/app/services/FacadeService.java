package org.uce.app.services;

import org.uce.app.model.Cita;
import org.uce.app.model.Paciente;


import java.util.List;

public class FacadeService {

    private final AuthServiceInterface authService;
    private final CitaServiceInterface citaService;
    private final PacienteServiceInterface pacienteService;

    public FacadeService() {
        this.authService = new AuthServiceProxy(new AuthService());
        this.citaService = new CitaServiceProxy(new CitaService());
        this.pacienteService = new PacienteServiceProxy(new PacienteService());
    }

    // AuthService methods
    public boolean authenticate(String username, String password) {
        return authService.authenticate(username, password);
    }

    // CitaService methods
    public boolean createCita(Cita cita) {
        return citaService.createCita(cita);
    }

    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    public Cita getCitaById(String id) {
        return citaService.getCitaById(id);
    }

    public boolean updateCita(Cita cita) {
        return citaService.updateCita(cita);
    }

    public boolean deleteCita(String id) {
        return citaService.deleteCita(id);
    }

    // PacienteService methods
    public boolean createPaciente(Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    public Paciente getPacienteByCi(String ciPaciente) {
        return pacienteService.getPacienteByCi(ciPaciente);
    }

    public boolean updatePaciente(Paciente paciente) {
        return pacienteService.updatePaciente(paciente);
    }

    public boolean deletePaciente(String ciPaciente) {
        return pacienteService.deletePaciente(ciPaciente);
    }
}

