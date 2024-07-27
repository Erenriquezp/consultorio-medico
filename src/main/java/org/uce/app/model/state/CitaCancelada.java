package org.uce.app.model.state;

import org.uce.app.model.Cita;

public class CitaCancelada implements CitaState {

    @Override
    public void programar(Cita cita) {
        // No se puede programar una cita que ya está cancelada
        System.out.println("No se puede programar una cita que ya está cancelada.");
    }

    @Override
    public void completar(Cita cita) {
        // No se puede completar una cita que está cancelada
        System.out.println("No se puede completar una cita que está cancelada.");
    }

    @Override
    public void cancelar(Cita cita) {
        // La cita ya está cancelada
        System.out.println("La cita ya está cancelada.");
    }

    @Override
    public String getEstado() {
        return "Cancelada";
    }
}
