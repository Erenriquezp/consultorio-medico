package org.uce.app.services;

import org.uce.app.model.Evolucion;

import java.util.List;

public interface EvolucionServiceInterface {
    boolean createEvolucion(Evolucion evolucion);
    List<Evolucion> getAllEvoluciones();
    Evolucion getEvolucionById(int id);
    boolean updateEvolucion(Evolucion evolucion);
    boolean deleteEvolucion(int id);
}