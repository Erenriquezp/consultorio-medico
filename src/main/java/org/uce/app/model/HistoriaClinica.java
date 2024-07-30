package org.uce.app.model;

import java.sql.Date;

public class HistoriaClinica {
    private final String idHistoriaClinica;
    private final String ciMedico;
    private final String ciPaciente;
    private final String motivoConsulta;
    private final String antecedentesPersonales;
    private final String antecedentesFamiliares;
    private final String enfermedadesActuales;
    private final String raosOrganosSentidos;
    private final String raosRespiratorio;
    private final String raosCardiovascular;
    private final String raosDigestivo;
    private final String raosGenital;
    private final String raosUrinario;
    private final String raosMusculoEsqueletico;
    private final String raosEndocrino;
    private final String raosHemoLinfatico;
    private final String raosNervioso;
    private final Date svaFechaMedicion;
    private final String svaTemperatura;
    private final String svaPresionArterial;
    private final String svaPulsoMinFreRespiratoria;
    private final String svaPesoKgTallaCm;
    private final String efrCabeza;
    private final String efrCuello;
    private final String efrTorax;
    private final String efrAbdomen;
    private final String efrPelvis;
    private final String efrExtremidades;
    private final String diagnosticoDesc;
    private final String diagnosticoCIE;

    private HistoriaClinica(Builder builder) {
        this.idHistoriaClinica = builder.idHistoriaClinica;
        this.ciMedico = builder.ciMedico;
        this.ciPaciente = builder.ciPaciente;
        this.motivoConsulta = builder.motivoConsulta;
        this.antecedentesPersonales = builder.antecedentesPersonales;
        this.antecedentesFamiliares = builder.antecedentesFamiliares;
        this.enfermedadesActuales = builder.enfermedadesActuales;
        this.raosOrganosSentidos = builder.raosOrganosSentidos;
        this.raosRespiratorio = builder.raosRespiratorio;
        this.raosCardiovascular = builder.raosCardiovascular;
        this.raosDigestivo = builder.raosDigestivo;
        this.raosGenital = builder.raosGenital;
        this.raosUrinario = builder.raosUrinario;
        this.raosMusculoEsqueletico = builder.raosMusculoEsqueletico;
        this.raosEndocrino = builder.raosEndocrino;
        this.raosHemoLinfatico = builder.raosHemoLinfatico;
        this.raosNervioso = builder.raosNervioso;
        this.svaFechaMedicion = builder.svaFechaMedicion;
        this.svaTemperatura = builder.svaTemperatura;
        this.svaPresionArterial = builder.svaPresionArterial;
        this.svaPulsoMinFreRespiratoria = builder.svaPulsoMinFreRespiratoria;
        this.svaPesoKgTallaCm = builder.svaPesoKgTallaCm;
        this.efrCabeza = builder.efrCabeza;
        this.efrCuello = builder.efrCuello;
        this.efrTorax = builder.efrTorax;
        this.efrAbdomen = builder.efrAbdomen;
        this.efrPelvis = builder.efrPelvs;
        this.efrExtremidades = builder.efrExtremidades;
        this.diagnosticoDesc = builder.diagnosticoDesc;
        this.diagnosticoCIE = builder.diagnosticoCIE;
    }

    public static class Builder {
        private String idHistoriaClinica;
        private String ciMedico;
        private String ciPaciente;
        private String motivoConsulta;
        private String antecedentesPersonales;
        private String antecedentesFamiliares;
        private String enfermedadesActuales;
        private String raosOrganosSentidos;
        private String raosRespiratorio;
        private String raosCardiovascular;
        private String raosDigestivo;
        private String raosGenital;
        private String raosUrinario;
        private String raosMusculoEsqueletico;
        private String raosEndocrino;
        private String raosHemoLinfatico;
        private String raosNervioso;
        private Date svaFechaMedicion;
        private String svaTemperatura;
        private String svaPresionArterial;
        private String svaPulsoMinFreRespiratoria;
        private String svaPesoKgTallaCm;
        private String efrCabeza;
        private String efrCuello;
        private String efrTorax;
        private String efrAbdomen;
        private String efrPelvs;
        private String efrExtremidades;
        private String diagnosticoDesc;
        private String diagnosticoCIE;

        public Builder() {
        }

        public Builder idHistoriaClinica(String idHistoriaClinica) {
            this.idHistoriaClinica = idHistoriaClinica;
            return this;
        }

        public Builder ciMedico(String ciMedico) {
            this.ciMedico = ciMedico;
            return this;
        }

        public Builder ciPaciente(String ciPaciente) {
            this.ciPaciente = ciPaciente;
            return this;
        }

        public Builder motivoConsulta(String motivoConsulta) {
            this.motivoConsulta = motivoConsulta;
            return this;
        }

        public Builder antecedentesPersonales(String antecedentesPersonales) {
            this.antecedentesPersonales = antecedentesPersonales;
            return this;
        }

        public Builder antecedentesFamiliares(String antecedentesFamiliares) {
            this.antecedentesFamiliares = antecedentesFamiliares;
            return this;
        }

        public Builder enfermedadesActuales(String enfermedadesActuales) {
            this.enfermedadesActuales = enfermedadesActuales;
            return this;
        }

        public Builder raosOrganosSentidos(String raosOrganosSentidos) {
            this.raosOrganosSentidos = raosOrganosSentidos;
            return this;
        }

        public Builder raosRespiratorio(String raosRespiratorio) {
            this.raosRespiratorio = raosRespiratorio;
            return this;
        }

        public Builder raosCardiovascular(String raosCardiovascular) {
            this.raosCardiovascular = raosCardiovascular;
            return this;
        }

        public Builder raosDigestivo(String raosDigestivo) {
            this.raosDigestivo = raosDigestivo;
            return this;
        }

        public Builder raosGenital(String raosGenital) {
            this.raosGenital = raosGenital;
            return this;
        }

        public Builder raosUrinario(String raosUrinario) {
            this.raosUrinario = raosUrinario;
            return this;
        }

        public Builder raosMusculoEsqueletico(String raosMusculoEsqueletico) {
            this.raosMusculoEsqueletico = raosMusculoEsqueletico;
            return this;
        }

        public Builder raosEndocrino(String raosEndocrino) {
            this.raosEndocrino = raosEndocrino;
            return this;
        }

        public Builder raosHemoLinfatico(String raosHemoLinfatico) {
            this.raosHemoLinfatico = raosHemoLinfatico;
            return this;
        }

        public Builder raosNervioso(String raosNervioso) {
            this.raosNervioso = raosNervioso;
            return this;
        }

        public Builder svaFechaMedicion(Date svaFechaMedicion) {
            this.svaFechaMedicion = svaFechaMedicion;
            return this;
        }

        public Builder svaTemperatura(String svaTemperatura) {
            this.svaTemperatura = svaTemperatura;
            return this;
        }

        public Builder svaPresionArterial(String svaPresionArterial) {
            this.svaPresionArterial = svaPresionArterial;
            return this;
        }

        public Builder svaPulsoMinFreRespiratoria(String svaPulsoMinFreRespiratoria) {
            this.svaPulsoMinFreRespiratoria = svaPulsoMinFreRespiratoria;
            return this;
        }

        public Builder svaPesoKgTallaCm(String svaPesoKgTallaCm) {
            this.svaPesoKgTallaCm = svaPesoKgTallaCm;
            return this;
        }

        public Builder efrCabeza(String efrCabeza) {
            this.efrCabeza = efrCabeza;
            return this;
        }

        public Builder efrCuello(String efrCuello) {
            this.efrCuello = efrCuello;
            return this;
        }

        public Builder efrTorax(String efrTorax) {
            this.efrTorax = efrTorax;
            return this;
        }

        public Builder efrAbdomen(String efrAbdomen) {
            this.efrAbdomen = efrAbdomen;
            return this;
        }

        public Builder efrPelvis(String efrPelvs) {
            this.efrPelvs = efrPelvs;
            return this;
        }

        public Builder efrExtremidades(String efrExtremidades) {
            this.efrExtremidades = efrExtremidades;
            return this;
        }

        public Builder diagnosticoDesc(String diagnosticoDesc) {
            this.diagnosticoDesc = diagnosticoDesc;
            return this;
        }

        public Builder diagnosticoCIE(String diagnosticoCIE) {
            this.diagnosticoCIE = diagnosticoCIE;
            return this;
        }

        public HistoriaClinica build() {
            return new HistoriaClinica(this);
        }
    }

    // Getters for all fields
    public String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public String getCiMedico() {
        return ciMedico;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public String getAntecedentesPersonales() {
        return antecedentesPersonales;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public String getEnfermedadesActuales() {
        return enfermedadesActuales;
    }

    public String getRaosOrganosSentidos() {
        return raosOrganosSentidos;
    }

    public String getRaosRespiratorio() {
        return raosRespiratorio;
    }

    public String getRaosCardiovascular() {
        return raosCardiovascular;
    }

    public String getRaosDigestivo() {
        return raosDigestivo;
    }

    public String getRaosGenital() {
        return raosGenital;
    }

    public String getRaosUrinario() {
        return raosUrinario;
    }

    public String getRaosMusculoEsqueletico() {
        return raosMusculoEsqueletico;
    }

    public String getRaosEndocrino() {
        return raosEndocrino;
    }

    public String getRaosHemoLinfatico() {
        return raosHemoLinfatico;
    }

    public String getRaosNervioso() {
        return raosNervioso;
    }

    public Date getSvaFechaMedicion() {
        return svaFechaMedicion;
    }

    public String getSvaTemperatura() {
        return svaTemperatura;
    }

    public String getSvaPresionArterial() {
        return svaPresionArterial;
    }

    public String getSvaPulsoMinFreRespiratoria() {
        return svaPulsoMinFreRespiratoria;
    }

    public String getSvaPesoKgTallaCm() {
        return svaPesoKgTallaCm;
    }

    public String getEfrCabeza() {
        return efrCabeza;
    }

    public String getEfrCuello() {
        return efrCuello;
    }

    public String getEfrTorax() {
        return efrTorax;
    }

    public String getEfrAbdomen() {
        return efrAbdomen;
    }

    public String getEfrPelvis() {
        return efrPelvis;
    }

    public String getEfrExtremidades() {
        return efrExtremidades;
    }

    public String getDiagnosticoDesc() {
        return diagnosticoDesc;
    }

    public String getDiagnosticoCIE() {
        return diagnosticoCIE;
    }
}
