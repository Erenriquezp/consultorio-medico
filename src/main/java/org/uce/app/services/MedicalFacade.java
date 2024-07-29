package org.uce.app.services;

import org.uce.app.dao.*;
import org.uce.app.model.*;

import java.util.List;

public class MedicalFacade {
    private final CitaDAO citaDAO;
    private final EvolucionDAO evolucionDAO;
    private final MedicoDAO medicoDAO;
    private final PacienteDAO pacienteDAO;
    private final RecetaDAO recetaDAO;
    private final HistoriaClinicaDAO historiaClinicaDAO;
    private final UsuarioDAO usuarioDAO;

    public MedicalFacade() {
        this.citaDAO = new CitaDAO();
        this.evolucionDAO = new EvolucionDAO();
        this.medicoDAO = new MedicoDAO();
        this.pacienteDAO = new PacienteDAO();
        this.recetaDAO = new RecetaDAO();
        this.historiaClinicaDAO = new HistoriaClinicaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    // Métodos para gestionar citas
    public boolean registrarCita(Cita cita) {
        return citaDAO.createCita(cita);
    }

    public List<Cita> obtenerTodasLasCitas() {
        return citaDAO.getAllCitas();
    }

    public Cita obtenerCitaPorId(String id) {
        return citaDAO.getCitaById(id);
    }

    public boolean actualizarCita(Cita cita) {
        return citaDAO.updateCita(cita);
    }

    public boolean eliminarCita(String id) {
        return citaDAO.deleteCita(id);
    }

    // Métodos para gestionar evoluciones
    public void registrarEvolucion(Evolucion evolucion) {
        evolucionDAO.crearEvolucion(evolucion);
    }

    public List<Evolucion> obtenerTodasLasEvoluciones() {
        return evolucionDAO.obtenerTodasLasEvoluciones();
    }

    public Evolucion obtenerEvolucionPorId(int id) {
        return evolucionDAO.obtenerEvolucionPorId(id);
    }

    public void actualizarEvolucion(Evolucion evolucion) {
        evolucionDAO.actualizarEvolucion(evolucion);
    }

    public void eliminarEvolucion(int id) {
        evolucionDAO.eliminarEvolucion(id);
    }

    // Métodos para gestionar médicos
    public boolean registrarMedico(Medico medico) {
        return medicoDAO.createMedico(medico);
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return medicoDAO.getAllMedicos();
    }

    public Medico obtenerMedicoPorId(String id) {
        return medicoDAO.getMedicoByCi(id);
    }

    public boolean actualizarMedico(Medico medico) {
        return medicoDAO.updateMedico(medico);
    }

    public boolean eliminarMedico(String id) {
        return medicoDAO.deleteMedico(id);
    }

    // Métodos para gestionar pacientes
    public boolean registrarPaciente(Paciente paciente) {
        return pacienteDAO.createPaciente(paciente);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteDAO.getAllPacientes();
    }

    public Paciente obtenerPacientePorId(String id) {
        return pacienteDAO.getPacienteByCi(id);
    }

    public boolean actualizarPaciente(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    public boolean eliminarPaciente(String id) {
        return pacienteDAO.deletePaciente(id);
    }

    // Métodos para gestionar recetas
    public boolean registrarReceta(Receta receta) {
        return recetaDAO.createReceta(receta);
    }

    public List<Receta> obtenerTodasLasRecetas() {
        return recetaDAO.getAllRecetas();
    }

    public Receta obtenerRecetaPorId(int id) {
        return recetaDAO.getRecetaById(id);
    }

    public boolean actualizarReceta(Receta receta) {
        return recetaDAO.updateReceta(receta);
    }

    public boolean eliminarReceta(int id) {
        return recetaDAO.deleteReceta(id);
    }

    // Métodos para gestionar historias clínicas
    public void registrarHistoriaClinica(HistoriaClinica historiaClinica) {
        historiaClinicaDAO.createHistoriaClinica(historiaClinica);
    }

    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaDAO.getAllHistoriasClinicas();
    }

//    public HistoriaClinica obtenerHistoriaClinicaPorId(String id) {
//        return historiaClinicaDAO.obtenerHistoriaClinicaPorId(id);
//    }

//    public void actualizarHistoriaClinica(HistoriaClinica historiaClinica) {
//        historiaClinicaDAO.actualizarHistoriaClinica(historiaClinica);
//    }
//
//    public void eliminarHistoriaClinica(String id) {
//        historiaClinicaDAO.eliminarHistoriaClinica(id);
//    }

    // Métodos para gestionar usuarios
    public Usuario obtenerUsuarioPorUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }
}

