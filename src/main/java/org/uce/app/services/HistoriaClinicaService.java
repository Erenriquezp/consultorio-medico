package org.uce.app.services;

import org.uce.app.dao.HistoriaClinicaDAO;
import org.uce.app.model.HistoriaClinica;

import java.sql.SQLException;
import java.util.List;

public class HistoriaClinicaService implements HistoriaClinicaServiceInterface {
    private final HistoriaClinicaDAO historiaClinicaDAO;

    public HistoriaClinicaService() {
        this.historiaClinicaDAO = new HistoriaClinicaDAO();
    }

    @Override
    public boolean createHistoriaClinica(HistoriaClinica historiaClinica) {
        try {
            historiaClinicaDAO.crearHistoriaClinica(historiaClinica);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HistoriaClinica> getAllHistoriasClinicas() {
        try {
            return historiaClinicaDAO.obtenerTodasLasHistoriasClinicas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HistoriaClinica getHistoriaClinicaById(String id) {
        try {
            return historiaClinicaDAO.obtenerHistoriaClinicaPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateHistoriaClinica(HistoriaClinica historiaClinica) {
        try {
            historiaClinicaDAO.actualizarHistoriaClinica(historiaClinica);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteHistoriaClinica(String id) {
        try {
            historiaClinicaDAO.eliminarHistoriaClinica(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
