package org.uce.app.model;

import java.time.LocalDateTime;

public class Cita {
    private String idCita;
    private String ciPaciente;
    private LocalDateTime fechaCita;
    private String motivo;
    private String estado;

    public Cita() {
    }

    public Cita(String idCita, String ciPaciente, LocalDateTime fechaCita, String motivo, String estado) {
        this.idCita = idCita;
        this.ciPaciente = ciPaciente;
        this.fechaCita = fechaCita;
        this.motivo = motivo;
        this.estado = estado;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(String ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
