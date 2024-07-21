package org.uce.app.model;

import java.time.LocalDate;

public class Paciente {
    private String ciPaciente;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccionResidencia;
    private String barrio;
    private String parroquia;
    private String canton;
    private String provincia;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String nacionalidad;
    private String grupoCultural;
    private int edad;
    private String estadoCivil;
    private String instruccionUltimoAnio;
    private LocalDate fechaAdmision;
    private String ocupacion;
    private String lugarTrabajo;
    private String tipoSeguro;
    private String referencia;
    private String contactoEmergenciaParentesco;
    private String contactoEmergenciaNombre;
    private String contactoEmergenciaDireccion;
    private String contactoEmergenciaTelefono;

    public Paciente(String ciPaciente, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String direccionResidencia, String barrio, String parroquia, String canton, String provincia, String telefono, LocalDate fechaNacimiento, String lugarNacimiento, String nacionalidad, String grupoCultural, int edad, String estadoCivil, String instruccionUltimoAnio, LocalDate fechaAdmision, String ocupacion, String lugarTrabajo, String tipoSeguro, String referencia, String contactoEmergenciaParentesco, String contactoEmergenciaNombre, String contactoEmergenciaDireccion, String contactoEmergenciaTelefono) {
        this.ciPaciente = ciPaciente;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccionResidencia = direccionResidencia;
        this.barrio = barrio;
        this.parroquia = parroquia;
        this.canton = canton;
        this.provincia = provincia;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.grupoCultural = grupoCultural;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.instruccionUltimoAnio = instruccionUltimoAnio;
        this.fechaAdmision = fechaAdmision;
        this.ocupacion = ocupacion;
        this.lugarTrabajo = lugarTrabajo;
        this.tipoSeguro = tipoSeguro;
        this.referencia = referencia;
        this.contactoEmergenciaParentesco = contactoEmergenciaParentesco;
        this.contactoEmergenciaNombre = contactoEmergenciaNombre;
        this.contactoEmergenciaDireccion = contactoEmergenciaDireccion;
        this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
    }

    public Paciente() {
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(String ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGrupoCultural() {
        return grupoCultural;
    }

    public void setGrupoCultural(String grupoCultural) {
        this.grupoCultural = grupoCultural;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getInstruccionUltimoAnio() {
        return instruccionUltimoAnio;
    }

    public void setInstruccionUltimoAnio(String instruccionUltimoAnio) {
        this.instruccionUltimoAnio = instruccionUltimoAnio;
    }

    public LocalDate getFechaAdmision() {
        return fechaAdmision;
    }

    public void setFechaAdmision(LocalDate fechaAdmision) {
        this.fechaAdmision = fechaAdmision;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getContactoEmergenciaParentesco() {
        return contactoEmergenciaParentesco;
    }

    public void setContactoEmergenciaParentesco(String contactoEmergenciaParentesco) {
        this.contactoEmergenciaParentesco = contactoEmergenciaParentesco;
    }

    public String getContactoEmergenciaNombre() {
        return contactoEmergenciaNombre;
    }

    public void setContactoEmergenciaNombre(String contactoEmergenciaNombre) {
        this.contactoEmergenciaNombre = contactoEmergenciaNombre;
    }

    public String getContactoEmergenciaDireccion() {
        return contactoEmergenciaDireccion;
    }

    public void setContactoEmergenciaDireccion(String contactoEmergenciaDireccion) {
        this.contactoEmergenciaDireccion = contactoEmergenciaDireccion;
    }

    public String getContactoEmergenciaTelefono() {
        return contactoEmergenciaTelefono;
    }

    public void setContactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
        this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
    }
}
