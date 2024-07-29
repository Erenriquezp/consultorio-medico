package org.uce.app.model;

import java.time.LocalDate;

public class Paciente {
    private final String ciPaciente;
    private final String primerNombre;
    private final String segundoNombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String direccionResidencia;
    private final String barrio;
    private final String parroquia;
    private final String canton;
    private final String provincia;
    private final String telefono;
    private final LocalDate fechaNacimiento;
    private final String lugarNacimiento;
    private final String nacionalidad;
    private final String grupoCultural;
    private final Integer edad;
    private final String estadoCivil;
    private final String instruccionUltimoAnio;
    private final LocalDate fechaAdmision;
    private final String ocupacion;
    private final String lugarTrabajo;
    private final String tipoSeguro;
    private final String referencia;
    private final String contactoEmergenciaParentesco;
    private final String contactoEmergenciaNombre;
    private final String contactoEmergenciaDireccion;
    private final String contactoEmergenciaTelefono;

    private Paciente(Builder builder) {
        this.ciPaciente = builder.ciPaciente;
        this.primerNombre = builder.primerNombre;
        this.segundoNombre = builder.segundoNombre;
        this.apellidoPaterno = builder.apellidoPaterno;
        this.apellidoMaterno = builder.apellidoMaterno;
        this.direccionResidencia = builder.direccionResidencia;
        this.barrio = builder.barrio;
        this.parroquia = builder.parroquia;
        this.canton = builder.canton;
        this.provincia = builder.provincia;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.lugarNacimiento = builder.lugarNacimiento;
        this.nacionalidad = builder.nacionalidad;
        this.grupoCultural = builder.grupoCultural;
        this.edad = builder.edad;
        this.estadoCivil = builder.estadoCivil;
        this.instruccionUltimoAnio = builder.instruccionUltimoAnio;
        this.fechaAdmision = builder.fechaAdmision;
        this.ocupacion = builder.ocupacion;
        this.lugarTrabajo = builder.lugarTrabajo;
        this.tipoSeguro = builder.tipoSeguro;
        this.referencia = builder.referencia;
        this.contactoEmergenciaParentesco = builder.contactoEmergenciaParentesco;
        this.contactoEmergenciaNombre = builder.contactoEmergenciaNombre;
        this.contactoEmergenciaDireccion = builder.contactoEmergenciaDireccion;
        this.contactoEmergenciaTelefono = builder.contactoEmergenciaTelefono;
    }

    public static class Builder {
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
        private Integer edad;
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

        public Builder ciPaciente(String ciPaciente) {
            this.ciPaciente = ciPaciente;
            return this;
        }

        public Builder primerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
            return this;
        }

        public Builder segundoNombre(String segundoNombre) {
            this.segundoNombre = segundoNombre;
            return this;
        }

        public Builder apellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
            return this;
        }

        public Builder apellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
            return this;
        }

        public Builder direccionResidencia(String direccionResidencia) {
            this.direccionResidencia = direccionResidencia;
            return this;
        }

        public Builder barrio(String barrio) {
            this.barrio = barrio;
            return this;
        }

        public Builder parroquia(String parroquia) {
            this.parroquia = parroquia;
            return this;
        }

        public Builder canton(String canton) {
            this.canton = canton;
            return this;
        }

        public Builder provincia(String provincia) {
            this.provincia = provincia;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder lugarNacimiento(String lugarNacimiento) {
            this.lugarNacimiento = lugarNacimiento;
            return this;
        }

        public Builder nacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
            return this;
        }

        public Builder grupoCultural(String grupoCultural) {
            this.grupoCultural = grupoCultural;
            return this;
        }

        public Builder edad(Integer edad) {
            this.edad = edad;
            return this;
        }

        public Builder estadoCivil(String estadoCivil) {
            this.estadoCivil = estadoCivil;
            return this;
        }

        public Builder instruccionUltimoAnio(String instruccionUltimoAnio) {
            this.instruccionUltimoAnio = instruccionUltimoAnio;
            return this;
        }

        public Builder fechaAdmision(LocalDate fechaAdmision) {
            this.fechaAdmision = fechaAdmision;
            return this;
        }

        public Builder ocupacion(String ocupacion) {
            this.ocupacion = ocupacion;
            return this;
        }

        public Builder lugarTrabajo(String lugarTrabajo) {
            this.lugarTrabajo = lugarTrabajo;
            return this;
        }

        public Builder tipoSeguro(String tipoSeguro) {
            this.tipoSeguro = tipoSeguro;
            return this;
        }

        public Builder referencia(String referencia) {
            this.referencia = referencia;
            return this;
        }

        public Builder contactoEmergenciaParentesco(String contactoEmergenciaParentesco) {
            this.contactoEmergenciaParentesco = contactoEmergenciaParentesco;
            return this;
        }

        public Builder contactoEmergenciaNombre(String contactoEmergenciaNombre) {
            this.contactoEmergenciaNombre = contactoEmergenciaNombre;
            return this;
        }

        public Builder contactoEmergenciaDireccion(String contactoEmergenciaDireccion) {
            this.contactoEmergenciaDireccion = contactoEmergenciaDireccion;
            return this;
        }

        public Builder contactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
            this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }

    // Getters (opcional)
    public String getCiPaciente() {
        return ciPaciente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getParroquia() {
        return parroquia;
    }

    public String getCanton() {
        return canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getGrupoCultural() {
        return grupoCultural;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getInstruccionUltimoAnio() {
        return instruccionUltimoAnio;
    }

    public LocalDate getFechaAdmision() {
        return fechaAdmision;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getContactoEmergenciaParentesco() {
        return contactoEmergenciaParentesco;
    }

    public String getContactoEmergenciaNombre() {
        return contactoEmergenciaNombre;
    }

    public String getContactoEmergenciaDireccion() {
        return contactoEmergenciaDireccion;
    }

    public String getContactoEmergenciaTelefono() {
        return contactoEmergenciaTelefono;
    }
}
