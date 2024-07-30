package org.uce.app.services;

import org.uce.app.dao.EvolucionDAO;
import org.uce.app.model.Evolucion;

import java.sql.SQLException;
import java.util.List;

public class EvolucionService implements EvolucionServiceInterface {

    private final EvolucionDAO evolucionDAO;

    public EvolucionService() {
        this.evolucionDAO = new EvolucionDAO();
    }

    @Override
    public boolean createEvolucion(Evolucion evolucion) {
        try {
            evolucionDAO.crearEvolucion(evolucion);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Evolucion> getAllEvoluciones() {
        try {
            return evolucionDAO.obtenerTodasLasEvoluciones();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Evolucion getEvolucionById(int id) {
        try {
            return evolucionDAO.obtenerEvolucionPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateEvolucion(Evolucion evolucion) {
        try {
            evolucionDAO.actualizarEvolucion(evolucion);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEvolucion(int id) {
        try {
            evolucionDAO.eliminarEvolucion(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}