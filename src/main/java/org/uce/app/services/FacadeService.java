package org.uce.app.services;

import org.uce.app.model.Cita;
import org.uce.app.model.Evolucion;
import org.uce.app.model.HistoriaClinica;
import org.uce.app.model.Paciente;
import org.uce.app.model.Receta;

import java.util.List;

public class FacadeService {

    private final AuthServiceInterface authService;
    private final CitaServiceInterface citaService;
    private final PacienteServiceInterface pacienteService;
    private final RecetaServiceInterface recetaService;
    private final HistoriaClinicaServiceInterface historiaClinicaService;
    private final EvolucionServiceInterface evolucionService;

    public FacadeService() {
        this.authService = new AuthServiceProxy(new AuthService());
        this.citaService = new CitaServiceProxy(new CitaService());
        this.pacienteService = new PacienteServiceProxy(new PacienteService());
        this.recetaService = new RecetaServiceProxy(new RecetaService());
        this.historiaClinicaService = new HistoriaClinicaServiceProxy(new HistoriaClinicaService());
        this.evolucionService = new EvolucionServiceProxy(new EvolucionService());
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

    // RecetaService methods
    public boolean createReceta(Receta receta) {
        return recetaService.createReceta(receta);
    }

    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    public Receta getRecetaById(int id) {
        return recetaService.getRecetaById(id);
    }

    public boolean updateReceta(Receta receta) {
        return recetaService.updateReceta(receta);
    }

    public boolean deleteReceta(int id) {
        return recetaService.deleteReceta(id);
    }

    // HistoriaClinicaService methods
    public boolean createHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaService.createHistoriaClinica(historiaClinica);
    }

    public List<HistoriaClinica> getAllHistoriasClinicas() {
        return historiaClinicaService.getAllHistoriasClinicas();
    }

    public HistoriaClinica getHistoriaClinicaById(String idHistoriaClinica) {
        return historiaClinicaService.getHistoriaClinicaById(idHistoriaClinica);
    }

    public boolean updateHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaService.updateHistoriaClinica(historiaClinica);
    }

    public boolean deleteHistoriaClinica(String idHistoriaClinica) {
        return historiaClinicaService.deleteHistoriaClinica(idHistoriaClinica);
    }

    // EvolucionService methods
    public boolean createEvolucion(Evolucion evolucion) {
        return evolucionService.createEvolucion(evolucion);
    }

    public List<Evolucion> getAllEvoluciones() {
        return evolucionService.getAllEvoluciones();
    }

    public Evolucion getEvolucionById(int id) {
        return evolucionService.getEvolucionById(id);
    }

    public boolean updateEvolucion(Evolucion evolucion) {
        return evolucionService.updateEvolucion(evolucion);
    }

    public boolean deleteEvolucion(int id) {
        return evolucionService.deleteEvolucion(id);
    }
}