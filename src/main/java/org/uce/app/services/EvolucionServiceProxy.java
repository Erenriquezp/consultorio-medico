package org.uce.app.services;

import org.uce.app.model.Evolucion;

import java.time.LocalDateTime;
import java.util.List;

public class EvolucionServiceProxy implements EvolucionServiceInterface {
    private final EvolucionServiceInterface evolucionService;

    public EvolucionServiceProxy(EvolucionServiceInterface evolucionService) {
        this.evolucionService = evolucionService;
    }

    @Override
    public boolean createEvolucion(Evolucion evolucion) {
        logActivity("Creating evolucion: " + evolucion.getIdEvolucion() + " at " + LocalDateTime.now());
        boolean result = evolucionService.createEvolucion(evolucion);
        logActivity("Evolucion created: " + evolucion.getIdEvolucion() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public List<Evolucion> getAllEvoluciones() {
        logActivity("Fetching all evoluciones at " + LocalDateTime.now());
        List<Evolucion> result = evolucionService.getAllEvoluciones();
        logActivity("Fetched all evoluciones: " + result.size() + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public Evolucion getEvolucionById(int id) {
        logActivity("Fetching evolucion by id: " + id + " at " + LocalDateTime.now());
        Evolucion result = evolucionService.getEvolucionById(id);
        logActivity("Fetched evolucion by id: " + id + " result: " + (result != null) + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean updateEvolucion(Evolucion evolucion) {
        logActivity("Updating evolucion: " + evolucion.getIdEvolucion() + " at " + LocalDateTime.now());
        boolean result = evolucionService.updateEvolucion(evolucion);
        logActivity("Evolucion updated: " + evolucion.getIdEvolucion() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean deleteEvolucion(int id) {
        logActivity("Deleting evolucion: " + id + " at " + LocalDateTime.now());
        boolean result = evolucionService.deleteEvolucion(id);
        logActivity("Evolucion deleted: " + id + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    private void logActivity(String message) {
        // Implementación del registro de actividades
        System.out.println(message); // Simplificado para el ejemplo
    }
}