package org.uce.app.services;

import org.uce.app.dao.CitaDAO;
import org.uce.app.model.Cita;
import java.util.List;

public class CitaService implements CitaServiceInterface {
    private final CitaDAO citaDAO;

    public CitaService() {
        this.citaDAO = new CitaDAO();
    }

    @Override
    public boolean createCita(Cita cita) {
        return citaDAO.createCita(cita);
    }

    @Override
    public List<Cita> getAllCitas() {
        return citaDAO.getAllCitas();
    }

    @Override
    public Cita getCitaById(String id) {
        return citaDAO.getCitaById(id);
    }

    @Override
    public boolean updateCita(Cita cita) {
        return citaDAO.updateCita(cita);
    }

    @Override
    public boolean deleteCita(String id) {
        return citaDAO.deleteCita(id);
    }
}
