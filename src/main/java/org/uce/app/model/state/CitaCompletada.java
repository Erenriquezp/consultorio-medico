package org.uce.app.model.state;

import org.uce.app.model.Cita;

public class CitaCompletada implements CitaState {

    @Override
    public void programar(Cita cita) {
        // No se puede programar una cita que ya está completada
        System.out.println("No se puede programar una cita que ya está completada.");
    }

    @Override
    public void completar(Cita cita) {
        // No se puede completar una cita que ya está completada
        System.out.println("La cita ya está completada.");
    }

    @Override
    public void cancelar(Cita cita) {
        // No se puede cancelar una cita que ya está completada
        System.out.println("No se puede cancelar una cita que ya está completada.");
    }

    @Override
    public String getEstado() {
        return "Completada";
    }
}
