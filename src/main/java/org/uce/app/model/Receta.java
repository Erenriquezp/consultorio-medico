package org.uce.app.model;

import java.time.LocalDate;

public class Receta {
    private final int idReceta;
    private final String ciPaciente;
    private final String ciMedico;
    private final LocalDate fechaEmision;
    private final String medicamentos;
    private final String dosis;

    private Receta(RecetaBuilder builder) {
        this.idReceta = builder.idReceta;
        this.ciPaciente = builder.ciPaciente;
        this.ciMedico = builder.ciMedico;
        this.fechaEmision = builder.fechaEmision;
        this.medicamentos = builder.medicamentos;
        this.dosis = builder.dosis;
    }

    public static class RecetaBuilder {
        private int idReceta;
        private String ciPaciente;
        private String ciMedico;
        private LocalDate fechaEmision;
        private String medicamentos;
        private String dosis;

        public RecetaBuilder idReceta(int idReceta) {
            this.idReceta = idReceta;
            return this;
        }

        public RecetaBuilder ciPaciente(String ciPaciente) {
            this.ciPaciente = ciPaciente;
            return this;
        }

        public RecetaBuilder ciMedico(String ciMedico) {
            this.ciMedico = ciMedico;
            return this;
        }

        public RecetaBuilder fechaEmision(LocalDate fechaEmision) {
            this.fechaEmision = fechaEmision;
            return this;
        }

        public RecetaBuilder medicamentos(String medicamentos) {
            this.medicamentos = medicamentos;
            return this;
        }

        public RecetaBuilder dosis(String dosis) {
            this.dosis = dosis;
            return this;
        }

        public Receta build() {
            return new Receta(this);
        }
    }

    // Getters (opcional)
    public int getIdReceta() {
        return idReceta;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public String getCiMedico() {
        return ciMedico;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public String getDosis() {
        return dosis;
    }
}
