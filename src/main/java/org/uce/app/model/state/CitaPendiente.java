package org.uce.app.model.state;

import org.uce.app.model.Cita;

public class CitaPendiente implements CitaState {

    @Override
    public void programar(Cita cita) {
        // No se puede programar una cita que ya está pendiente
        System.out.println("La cita ya está pendiente.");
    }

    @Override
    public void completar(Cita cita) {
        cita.setEstado(new CitaCompletada());
        System.out.println("La cita ha sido completada.");
    }

    @Override
    public void cancelar(Cita cita) {
        cita.setEstado(new CitaCancelada());
        System.out.println("La cita ha sido cancelada.");
    }

    @Override
    public String getEstado() {
        return "Programada";
    }
}
