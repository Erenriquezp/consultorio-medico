package org.uce.app.services;

import org.uce.app.model.HistoriaClinica;
import java.util.List;
import java.time.LocalDateTime;

public class HistoriaClinicaServiceProxy implements HistoriaClinicaServiceInterface {
    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaServiceProxy(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @Override
    public boolean createHistoriaClinica(HistoriaClinica historiaClinica) {
        logActivity("Creating historiaClinica: " + historiaClinica.getIdHistoriaClinica() + " at " + LocalDateTime.now());
        boolean result = historiaClinicaService.createHistoriaClinica(historiaClinica);
        logActivity("HistoriaClinica created: " + historiaClinica.getIdHistoriaClinica() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public List<HistoriaClinica> getAllHistoriasClinicas() {
        logActivity("Fetching all historiasClinicas at " + LocalDateTime.now());
        List<HistoriaClinica> result = historiaClinicaService.getAllHistoriasClinicas();
        //logActivity("Fetched all historiasClinicas: " + result.size() + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public HistoriaClinica getHistoriaClinicaById(String id) {
        logActivity("Fetching historiaClinica by id: " + id + " at " + LocalDateTime.now());
        HistoriaClinica result = historiaClinicaService.getHistoriaClinicaById(id);
        logActivity("Fetched historiaClinica by id: " + id + " result: " + (result != null) + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean updateHistoriaClinica(HistoriaClinica historiaClinica) {
        logActivity("Updating historiaClinica: " + historiaClinica.getIdHistoriaClinica() + " at " + LocalDateTime.now());
        boolean result = historiaClinicaService.updateHistoriaClinica(historiaClinica);
        logActivity("HistoriaClinica updated: " + historiaClinica.getIdHistoriaClinica() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean deleteHistoriaClinica(String id) {
        logActivity("Deleting historiaClinica: " + id + " at " + LocalDateTime.now());
        boolean result = historiaClinicaService.deleteHistoriaClinica(id);
        logActivity("HistoriaClinica deleted: " + id + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    private void logActivity(String message) {
        // Implementación del registro de actividades
        System.out.println(message); // Simplificado para el ejemplo
    }
}
