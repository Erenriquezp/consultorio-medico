package org.uce.app.model;

import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private String ci_paciente;
    private String primer_nombre;
    private String segundo_nombre;
    private String appellido_paterno;
    private String apellido_materno;
    private String direccion_recidencia;
    private String barrio;
    private String parroquia;
    private String canton;
    private String provincia;
    private String telefono;
    private LocalDate fecha_nacimiento;
    private String lugar_nacimiento;
    private String nacionalidad;
    private String grupo_cultural;
    private int edad;
    private String estado_civil;
    private String instruccion;
    private Date fecha_admision;
    private String ocupacion;
    private String lugar_trabajo;
    private String tipo_seguro;
    private String referencia;
    private String contacto_emergencia_parentesco;
    private String contacto_emergencia_nombre;
    private String contacto_emergencia_direccion;
    private String contacto_emergencia_telefono;

    public Paciente(String ci_paciente, String primer_nombre, String segundo_nombre, String appellido_paterno, String apellido_materno, String direccion_recidencia, String barrio, String parroquia, String canton, String provincia, String telefono, LocalDate fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String grupo_cultural, int edad, String estado_civil, String instruccion, Date fecha_admision, String ocupacion, String lugar_trabajo, String tipo_seguro, String referencia, String contacto_emergencia_parentesco, String contacto_emergencia_nombre, String contacto_emergencia_direccion, String contacto_emergencia_telefono) {
        this.ci_paciente = ci_paciente;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.appellido_paterno = appellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion_recidencia = direccion_recidencia;
        this.barrio = barrio;
        this.parroquia = parroquia;
        this.canton = canton;
        this.provincia = provincia;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.grupo_cultural = grupo_cultural;
        this.edad = edad;
        this.estado_civil = estado_civil;
        this.instruccion = instruccion;
        this.fecha_admision = fecha_admision;
        this.ocupacion = ocupacion;
        this.lugar_trabajo = lugar_trabajo;
        this.tipo_seguro = tipo_seguro;
        this.referencia = referencia;
        this.contacto_emergencia_parentesco = contacto_emergencia_parentesco;
        this.contacto_emergencia_nombre = contacto_emergencia_nombre;
        this.contacto_emergencia_direccion = contacto_emergencia_direccion;
        this.contacto_emergencia_telefono = contacto_emergencia_telefono;
    }

    public Paciente() {
    }

    public String getCi_paciente() {
        return ci_paciente;
    }

    public void setCi_paciente(String ci_paciente) {
        this.ci_paciente = ci_paciente;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getAppellido_paterno() {
        return appellido_paterno;
    }

    public void setAppellido_paterno(String appellido_paterno) {
        this.appellido_paterno = appellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getDireccion_recidencia() {
        return direccion_recidencia;
    }

    public void setDireccion_recidencia(String direccion_recidencia) {
        this.direccion_recidencia = direccion_recidencia;
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGrupo_cultural() {
        return grupo_cultural;
    }

    public void setGrupo_cultural(String grupo_cultural) {
        this.grupo_cultural = grupo_cultural;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public Date getFecha_admision() {
        return fecha_admision;
    }

    public void setFecha_admision(Date fecha_admision) {
        this.fecha_admision = fecha_admision;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getTipo_seguro() {
        return tipo_seguro;
    }

    public void setTipo_seguro(String tipo_seguro) {
        this.tipo_seguro = tipo_seguro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getContacto_emergencia_parentesco() {
        return contacto_emergencia_parentesco;
    }

    public void setContacto_emergencia_parentesco(String contacto_emergencia_parentesco) {
        this.contacto_emergencia_parentesco = contacto_emergencia_parentesco;
    }

    public String getContacto_emergencia_nombre() {
        return contacto_emergencia_nombre;
    }

    public void setContacto_emergencia_nombre(String contacto_emergencia_nombre) {
        this.contacto_emergencia_nombre = contacto_emergencia_nombre;
    }

    public String getContacto_emergencia_direccion() {
        return contacto_emergencia_direccion;
    }

    public void setContacto_emergencia_direccion(String contacto_emergencia_direccion) {
        this.contacto_emergencia_direccion = contacto_emergencia_direccion;
    }

    public String getContacto_emergencia_telefono() {
        return contacto_emergencia_telefono;
    }

    public void setContacto_emergencia_telefono(String contacto_emergencia_telefono) {
        this.contacto_emergencia_telefono = contacto_emergencia_telefono;
    }
}

