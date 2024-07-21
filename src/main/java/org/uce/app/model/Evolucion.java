package org.uce.app.model;

import java.util.Date;

public class Evolucion {
    private int idEvolucion;
    private String idHistoriaClinica;
    private Date fecha;
    private String descripcion;

    // Constructor sin parámetros
    public Evolucion() {
    }

    // Constructor con parámetros
    public Evolucion(int idEvolucion, String idHistoriaClinica, Date fecha, String descripcion) {
        this.idEvolucion = idEvolucion;
        this.idHistoriaClinica = idHistoriaClinica;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdEvolucion() {
        return idEvolucion;
    }

    public void setIdEvolucion(int idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(String idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

