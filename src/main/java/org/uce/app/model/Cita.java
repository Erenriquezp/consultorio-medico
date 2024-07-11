package org.uce.app.model;

import java.time.LocalDateTime;

public class Cita {
    private int id;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;
    private int idMedico;
    private int idPaciente;

    public Cita(int id, LocalDateTime fechaHora, String motivo, String estado, int idMedico, int idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public Cita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
