package org.uce.app.services;

import org.uce.app.dao.CitaDAO;
import org.uce.app.model.Cita;

import java.util.List;

public class CitaService {

    private CitaDAO citaDAO;

    public CitaService() {
        this.citaDAO = new CitaDAO();
    }

    public boolean createCita(Cita cita) {
        return citaDAO.createCita(cita);
    }

    public List<Cita> getAllCitas() {
        return citaDAO.getAllCitas();
    }

    public Cita getCitaById(String idCita) {
        return citaDAO.getCitaById(idCita);
    }

    public boolean updateCita(Cita cita) {
        return citaDAO.updateCita(cita);
    }

    public boolean deleteCita(String idCita) {
        return citaDAO.deleteCita(idCita);
    }
}
