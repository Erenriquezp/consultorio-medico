package org.uce.app.model;

public class Medico {
    private String ciMedico;
    private String apellidos;
    private String nombres;
    private String telefono;
    private String email;

    public Medico() {
    }

    public Medico(String ciMedico, String apellidos, String nombres, String telefono, String email) {
        this.ciMedico = ciMedico;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCiMedico() {
        return ciMedico;
    }

    public void setCiMedico(String ciMedico) {
        this.ciMedico = ciMedico;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
