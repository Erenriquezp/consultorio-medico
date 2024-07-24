package org.uce.app.model;

import java.util.Date;

public class Evolucion {
    private final int idEvolucion;
    private final String idHistoriaClinica;
    private final Date fecha;
    private final String descripcion;

    private Evolucion(EvolutionBuilder builder) {
        this.idEvolucion = builder.idEvolucion;
        this.idHistoriaClinica = builder.idHistoriaClinica;
        this.fecha = builder.fecha;
        this.descripcion = builder.descripcion;
    }

    public static class EvolutionBuilder {
        private int idEvolucion;
        private String idHistoriaClinica;
        private Date fecha;
        private String descripcion;

        public EvolutionBuilder() {
        }

        public EvolutionBuilder idEvolucion(int idEvolucion) {
            this.idEvolucion = idEvolucion;
            return this;
        }

        public EvolutionBuilder idHistoriaClinica(String idHistoriaClinica) {
            this.idHistoriaClinica = idHistoriaClinica;
            return this;
        }

        public EvolutionBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        public EvolutionBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Evolucion build() {
            return new Evolucion(this);
        }
    }

    // Getters for all fields
    public int getIdEvolucion() {
        return idEvolucion;
    }

    public String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}


