package org.uce.app.model;

import java.time.LocalDate;

public class Receta {
    private int idReceta;
    private String ciPaciente;
    private String ciMedico;
    private LocalDate fechaEmision;
    private String medicamentos;
    private String dosis;

    // Constructores
    public Receta() {}

    public Receta(int idReceta, String ciPaciente, String ciMedico, LocalDate fechaEmision, String medicamentos, String dosis) {
        this.idReceta = idReceta;
        this.ciPaciente = ciPaciente;
        this.ciMedico = ciMedico;
        this.fechaEmision = fechaEmision;
        this.medicamentos = medicamentos;
        this.dosis = dosis;
    }

    // Getters y Setters
    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
