package org.uce.app.dao;

import org.uce.app.model.HistoriaClinica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinicaDAO {

    private Connection conexion;

    public HistoriaClinicaDAO() throws SQLException {
        this.conexion = ConexionDAO.getInstancia().getConexion();
    }

    // Método para crear una nueva historia clínica
    public void crearHistoriaClinica(HistoriaClinica historiaClinica) throws SQLException {
        String query = "INSERT INTO Historia_clinica (id_historia_clinica, ci_medico, ci_paciente, motivo_consulta, " +
                "antecedentes_personales, antecedentes_familiares, enfermedades_actuales, raos_organos_sentidos, " +
                "raos_respiratorio, raos_cardiovascular, raos_digestivo, raos_genital, raos_urinario, raos_musculo_esqueletico, " +
                "raos_endocrino, raos_hemo_linfatico, raos_nervioso, sva_fecha_medicion, sva_temperatura, sva_presion_arterial, " +
                "sva_pulso_min_fre_respiratoria, sva_peso_kg_talla_cm, efr_cabeza, efr_cuello, efr_torax, efr_abdomen, efr_pelvs, " +
                "efr_extremidades, diagnostico_desc, diagnostico_cie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, historiaClinica.getIdHistoriaClinica());
            pstmt.setString(2, historiaClinica.getCiMedico());
            pstmt.setString(3, historiaClinica.getCiPaciente());
            pstmt.setString(4, historiaClinica.getMotivoConsulta());
            pstmt.setString(5, historiaClinica.getAntecedentesPersonales());
            pstmt.setString(6, historiaClinica.getAntecedentesFamiliares());
            pstmt.setString(7, historiaClinica.getEnfermedadesActuales());
            pstmt.setString(8, historiaClinica.getRaosOrganosSentidos());
            pstmt.setString(9, historiaClinica.getRaosRespiratorio());
            pstmt.setString(10, historiaClinica.getRaosCardiovascular());
            pstmt.setString(11, historiaClinica.getRaosDigestivo());
            pstmt.setString(12, historiaClinica.getRaosGenital());
            pstmt.setString(13, historiaClinica.getRaosUrinario());
            pstmt.setString(14, historiaClinica.getRaosMusculoEsqueletico());
            pstmt.setString(15, historiaClinica.getRaosEndocrino());
            pstmt.setString(16, historiaClinica.getRaosHemoLinfatico());
            pstmt.setString(17, historiaClinica.getRaosNervioso());
            pstmt.setString(18, historiaClinica.getSvaFechaMedicion());
            pstmt.setString(19, historiaClinica.getSvaTemperatura());
            pstmt.setString(20, historiaClinica.getSvaPresionArterial());
            pstmt.setString(21, historiaClinica.getSvaPulsoMinFreRespiratoria());
            pstmt.setString(22, historiaClinica.getSvaPesoKgTallaCm());
            pstmt.setString(23, historiaClinica.getEfrCabeza());
            pstmt.setString(24, historiaClinica.getEfrCuello());
            pstmt.setString(25, historiaClinica.getEfrTorax());
            pstmt.setString(26, historiaClinica.getEfrAbdomen());
            pstmt.setString(27, historiaClinica.getEfrPelvs());
            pstmt.setString(28, historiaClinica.getEfrExtremidades());
            pstmt.setString(29, historiaClinica.getDiagnosticoDesc());
            pstmt.setString(30, historiaClinica.getDiagnosticoCIE());
            pstmt.executeUpdate();
        }
    }

    // Método para obtener una historia clínica por su ID
    public HistoriaClinica obtenerHistoriaClinicaPorId(String idHistoriaClinica) throws SQLException {
        String query = "SELECT * FROM Historia_clinica WHERE id_historia_clinica = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, idHistoriaClinica);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    HistoriaClinica historiaClinica = new HistoriaClinica.HistoriaClinicaBuilder()
                            .idHistoriaClinica(rs.getString("id_historia_clinica"))
                            .ciMedico(rs.getString("ci_medico"))
                            .ciPaciente(rs.getString("ci_paciente"))
                            .motivoConsulta(rs.getString("motivo_consulta"))
                            .antecedentesPersonales(rs.getString("antecedentes_personales"))
                            .antecedentesFamiliares(rs.getString("antecedentes_familiares"))
                            .enfermedadesActuales(rs.getString("enfermedades_actuales"))
                            .raosOrganosSentidos(rs.getString("raos_organos_sentidos"))
                            .raosRespiratorio(rs.getString("raos_respiratorio"))
                            .raosCardiovascular(rs.getString("raos_cardiovascular"))
                            .raosDigestivo(rs.getString("raos_digestivo"))
                            .raosGenital(rs.getString("raos_genital"))
                            .raosUrinario(rs.getString("raos_urinario"))
                            .raosMusculoEsqueletico(rs.getString("raos_musculo_esqueletico"))
                            .raosEndocrino(rs.getString("raos_endocrino"))
                            .raosHemoLinfatico(rs.getString("raos_hemo_linfatico"))
                            .raosNervioso(rs.getString("raos_nervioso"))
                            .svaFechaMedicion(rs.getString("sva_fecha_medicion"))
                            .svaTemperatura(rs.getString("sva_temperatura"))
                            .svaPresionArterial(rs.getString("sva_presion_arterial"))
                            .svaPulsoMinFreRespiratoria(rs.getString("sva_pulso_min_fre_respiratoria"))
                            .svaPesoKgTallaCm(rs.getString("sva_peso_kg_talla_cm"))
                            .efrCabeza(rs.getString("efr_cabeza"))
                            .efrCuello(rs.getString("efr_cuello"))
                            .efrTorax(rs.getString("efr_torax"))
                            .efrAbdomen(rs.getString("efr_abdomen"))
                            .efrPelvs(rs.getString("efr_pelvs"))
                            .efrExtremidades(rs.getString("efr_extremidades"))
                            .diagnosticoDesc(rs.getString("diagnostico_desc"))
                            .diagnosticoCIE(rs.getString("diagnostico_cie"))
                            .build();

                    return historiaClinica;
                }
            }
        }
        return null;
    }

    // Método para obtener todas las historias clínicas
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() throws SQLException {
        List<HistoriaClinica> historiasClinicas = new ArrayList<>();
        String query = "SELECT * FROM Historia_clinica";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                HistoriaClinica historiaClinica = new HistoriaClinica.HistoriaClinicaBuilder()
                        .idHistoriaClinica(rs.getString("id_historia_clinica"))
                        .ciMedico(rs.getString("ci_medico"))
                        .ciPaciente(rs.getString("ci_paciente"))
                        .motivoConsulta(rs.getString("motivo_consulta"))
                        .antecedentesPersonales(rs.getString("antecedentes_personales"))
                        .antecedentesFamiliares(rs.getString("antecedentes_familiares"))
                        .enfermedadesActuales(rs.getString("enfermedades_actuales"))
                        .raosOrganosSentidos(rs.getString("raos_organos_sentidos"))
                        .raosRespiratorio(rs.getString("raos_respiratorio"))
                        .raosCardiovascular(rs.getString("raos_cardiovascular"))
                        .raosDigestivo(rs.getString("raos_digestivo"))
                        .raosGenital(rs.getString("raos_genital"))
                        .raosUrinario(rs.getString("raos_urinario"))
                        .raosMusculoEsqueletico(rs.getString("raos_musculo_esqueletico"))
                        .raosEndocrino(rs.getString("raos_endocrino"))
                        .raosHemoLinfatico(rs.getString("raos_hemo_linfatico"))
                        .raosNervioso(rs.getString("raos_nervioso"))
                        .svaFechaMedicion(rs.getString("sva_fecha_medicion"))
                        .svaTemperatura(rs.getString("sva_temperatura"))
                        .svaPresionArterial(rs.getString("sva_presion_arterial"))
                        .svaPulsoMinFreRespiratoria(rs.getString("sva_pulso_min_fre_respiratoria"))
                        .svaPesoKgTallaCm(rs.getString("sva_peso_kg_talla_cm"))
                        .efrCabeza(rs.getString("efr_cabeza"))
                        .efrCuello(rs.getString("efr_cuello"))
                        .efrTorax(rs.getString("efr_torax"))
                        .efrAbdomen(rs.getString("efr_abdomen"))
                        .efrPelvs(rs.getString("efr_pelvs"))
                        .efrExtremidades(rs.getString("efr_extremidades"))
                        .diagnosticoDesc(rs.getString("diagnostico_desc"))
                        .diagnosticoCIE(rs.getString("diagnostico_cie"))
                        .build();

                historiasClinicas.add(historiaClinica);
            }
        }
        return historiasClinicas;
    }

    // Método para actualizar una historia clínica existente
    public void actualizarHistoriaClinica(HistoriaClinica historiaClinica) throws SQLException {
        String query = "UPDATE Historia_clinica SET ci_medico = ?, ci_paciente = ?, motivo_consulta = ?, antecedentes_personales = ?, antecedentes_familiares = ?, enfermedades_actuales = ?, raos_organos_sentidos = ?, raos_respiratorio = ?, raos_cardiovascular = ?, raos_digestivo = ?, raos_genital = ?, raos_urinario = ?, raos_musculo_esqueletico = ?, raos_endocrino = ?, raos_hemo_linfatico = ?, raos_nervioso = ?, sva_fecha_medicion = ?, sva_temperatura = ?, sva_presion_arterial = ?, sva_pulso_min_fre_respiratoria = ?, sva_peso_kg_talla_cm = ?, efr_cabeza = ?, efr_cuello = ?, efr_torax = ?, efr_abdomen = ?, efr_pelvs = ?, efr_extremidades = ?, diagnostico_desc = ?, diagnostico_cie = ? WHERE id_historia_clinica = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, historiaClinica.getCiMedico());
            pstmt.setString(2, historiaClinica.getCiPaciente());
            pstmt.setString(3, historiaClinica.getMotivoConsulta());
            pstmt.setString(4, historiaClinica.getAntecedentesPersonales());
            pstmt.setString(5, historiaClinica.getAntecedentesFamiliares());
            pstmt.setString(6, historiaClinica.getEnfermedadesActuales());
            pstmt.setString(7, historiaClinica.getRaosOrganosSentidos());
            pstmt.setString(8, historiaClinica.getRaosRespiratorio());
            pstmt.setString(9, historiaClinica.getRaosCardiovascular());
            pstmt.setString(10, historiaClinica.getRaosDigestivo());
            pstmt.setString(11, historiaClinica.getRaosGenital());
            pstmt.setString(12, historiaClinica.getRaosUrinario());
            pstmt.setString(13, historiaClinica.getRaosMusculoEsqueletico());
            pstmt.setString(14, historiaClinica.getRaosEndocrino());
            pstmt.setString(15, historiaClinica.getRaosHemoLinfatico());
            pstmt.setString(16, historiaClinica.getRaosNervioso());
            pstmt.setString(17, historiaClinica.getSvaFechaMedicion());
            pstmt.setString(18, historiaClinica.getSvaTemperatura());
            pstmt.setString(19, historiaClinica.getSvaPresionArterial());
            pstmt.setString(20, historiaClinica.getSvaPulsoMinFreRespiratoria());
            pstmt.setString(21, historiaClinica.getSvaPesoKgTallaCm());
            pstmt.setString(22, historiaClinica.getEfrCabeza());
            pstmt.setString(23, historiaClinica.getEfrCuello());
            pstmt.setString(24, historiaClinica.getEfrTorax());
            pstmt.setString(25, historiaClinica.getEfrAbdomen());
            pstmt.setString(26, historiaClinica.getEfrPelvs());
            pstmt.setString(27, historiaClinica.getEfrExtremidades());
            pstmt.setString(28, historiaClinica.getDiagnosticoDesc());
            pstmt.setString(29, historiaClinica.getDiagnosticoCIE());
            pstmt.setString(30, historiaClinica.getIdHistoriaClinica());
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar una historia clínica por su ID
    public void eliminarHistoriaClinica(String idHistoriaClinica) throws SQLException {
        String query = "DELETE FROM Historia_clinica WHERE id_historia_clinica = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, idHistoriaClinica);
            pstmt.executeUpdate();
        }
    }
}
