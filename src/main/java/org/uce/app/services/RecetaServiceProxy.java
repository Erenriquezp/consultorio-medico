package org.uce.app.services;

import org.uce.app.model.Receta;

import java.time.LocalDateTime;
import java.util.List;

public class RecetaServiceProxy implements RecetaServiceInterface {
    private final RecetaService recetaService;

    public RecetaServiceProxy(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @Override
    public boolean createReceta(Receta receta) {
        logActivity("Creating receta: " + receta.getIdReceta() + " at " + LocalDateTime.now());
        boolean result = recetaService.createReceta(receta);
        logActivity("Receta created: " + receta.getIdReceta() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public List<Receta> getAllRecetas() {
        logActivity("Fetching all recetas at " + LocalDateTime.now());
        List<Receta> result = recetaService.getAllRecetas();
        logActivity("Fetched all recetas: " + result.size() + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public Receta getRecetaById(int id) {
        logActivity("Fetching receta by id: " + id + " at " + LocalDateTime.now());
        Receta result = recetaService.getRecetaById(id);
        logActivity("Fetched receta by id: " + id + " result: " + (result != null) + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean updateReceta(Receta receta) {
        logActivity("Updating receta: " + receta.getIdReceta() + " at " + LocalDateTime.now());
        boolean result = recetaService.updateReceta(receta);
        logActivity("Receta updated: " + receta.getIdReceta() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean deleteReceta(int id) {
        logActivity("Deleting receta: " + id + " at " + LocalDateTime.now());
        boolean result = recetaService.deleteReceta(id);
        logActivity("Receta deleted: " + id + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    private void logActivity(String message) {
        // Implementación del registro de actividades
        System.out.println(message); // Simplificado para el ejemplo
    }
}
