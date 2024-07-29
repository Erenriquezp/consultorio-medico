package org.uce.app.model;

import java.time.LocalDateTime;
import org.uce.app.model.state.CitaState;
import org.uce.app.model.state.CitaPendiente;
import org.uce.app.model.state.CitaCompletada;
import org.uce.app.model.state.CitaCancelada;

public class Cita {
    private final String idCita;
    private final String ciPaciente;
    private final LocalDateTime fechaCita;
    private final String motivo;
    private CitaState estado;

    public Cita(Builder builder) {
        this.idCita = builder.idCita;
        this.ciPaciente = builder.ciPaciente;
        this.fechaCita = builder.fechaCita;
        this.motivo = builder.motivo;
        this.setEstado(builder.estado); // Ajustar el estado inicial
    }

    public static class Builder {
        private String idCita;
        private String ciPaciente;
        private LocalDateTime fechaCita;
        private String motivo;
        private String estado;

        public Builder() {}

        public Builder idCita(String idCita) {
            this.idCita = idCita;
            return this;
        }

        public Builder ciPaciente(String ciPaciente) {
            this.ciPaciente = ciPaciente;
            return this;
        }

        public Builder fechaCita(LocalDateTime fechaCita) {
            this.fechaCita = fechaCita;
            return this;
        }

        public Builder motivo(String motivo) {
            this.motivo = motivo;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Cita build() {
            return new Cita(this);
        }
    }

    public void setEstado(CitaState estado) {
        this.estado = estado;
    }

    public void setEstado(String estado) {
        switch (estado) {
            case "Programada" -> this.estado = new CitaPendiente();
            case "Completada" -> this.estado = new CitaCompletada();
            case "Cancelada" -> this.estado = new CitaCancelada();
            default -> throw new IllegalArgumentException("Estado desconocido: " + estado);
        }
    }

    public void programar() {
        estado.programar(this);
    }

    public void completar() {
        estado.completar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    // Getters
    public String getIdCita() {
        return idCita;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado.getEstado();
    }
}
