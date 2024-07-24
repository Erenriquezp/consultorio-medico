package org.uce.app.model;

import java.time.LocalDateTime;

public class Cita {
    private final String idCita;
    private final String ciPaciente;
    private final LocalDateTime fechaCita;
    private final String motivo;
    private final String estado;

    public Cita(CitaBuilder builder) {
        this.idCita = builder.idCita;
        this.ciPaciente = builder.ciPaciente;
        this.fechaCita = builder.fechaCita;
        this.motivo = builder.motivo;
        this.estado = builder.estado;
    }

    public static class CitaBuilder {
        private String idCita;
        private String ciPaciente;
        private LocalDateTime fechaCita;
        private String motivo;
        private String estado;

        public CitaBuilder(){}

        public CitaBuilder idCita(String idCita) {
            this.idCita = idCita;
            return this;
        }

        public CitaBuilder ciPaciente(String ciPaciente) {
            this.ciPaciente = ciPaciente;
            return this;
        }

        public CitaBuilder fechaCita(LocalDateTime fechaCita) {
            this.fechaCita = fechaCita;
            return this;
        }

        public CitaBuilder motivo(String motivo) {
            this.motivo = motivo;
            return this;
        }

        public CitaBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Cita build(){
            return new Cita(this);
        }
    }

    public String getEstado() {
        return estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public String getIdCita() {
        return idCita;
    }
}
