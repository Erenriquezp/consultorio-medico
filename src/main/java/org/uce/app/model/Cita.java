package org.uce.app.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Cita {
    private String idCita;
    private String ciPaciente;
    private String ciMedico;
    private Date fechaCita;
    private String motivo;
    private String estado;

    public Cita() {
    }

    public Cita(String idCita, String ciPaciente, String ciMedico, Date fechaCita, String motivo, String estado) {
        this.idCita = idCita;
        this.ciPaciente = ciPaciente;
        this.ciMedico = ciMedico;
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

    public String getCiMedico() {
        return ciMedico;
    }

    public void setCiMedico(String ciMedico) {
        this.ciMedico = ciMedico;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
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
