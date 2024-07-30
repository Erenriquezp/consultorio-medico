package org.uce.app.services;

import org.uce.app.model.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaServiceInterface {
    boolean createHistoriaClinica(HistoriaClinica historiaClinica);
    List<HistoriaClinica> getAllHistoriasClinicas();
    HistoriaClinica getHistoriaClinicaById(String id);
    boolean updateHistoriaClinica(HistoriaClinica historiaClinica);
    boolean deleteHistoriaClinica(String id);
}
