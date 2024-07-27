package org.uce.app.model.state;

import org.uce.app.model.Cita;

public interface CitaState {
    void programar(Cita cita);
    void completar(Cita cita);
    void cancelar(Cita cita);
    String getEstado();
}
