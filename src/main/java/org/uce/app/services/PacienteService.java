package org.uce.app.services;

import org.uce.app.dao.PacienteDAO;
import org.uce.app.model.Paciente;

import java.util.List;

public class PacienteService {

    private PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }

    public boolean createPaciente(Paciente paciente) {
        return pacienteDAO.createPaciente(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteDAO.getAllPacientes();
    }

    public Paciente getPacienteByCi(String ciPaciente) {
        return pacienteDAO.getPacienteByCi(ciPaciente);
    }

    public boolean updatePaciente(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    public boolean deletePaciente(String ciPaciente) {
        return pacienteDAO.deletePaciente(ciPaciente);
    }
}
