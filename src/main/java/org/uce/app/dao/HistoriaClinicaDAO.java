package org.uce.app.dao;

import org.uce.app.model.HistoriaClinica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinicaDAO {
    // Método para crear una nueva historia clínica
    public void crearHistoriaClinica(HistoriaClinica historiaClinica) throws SQLException {
        String query = "INSERT INTO Historia_clinica (id_historia_clinica, ci_medico, ci_paciente, motivo_consulta, " +
                "antecedentes_personales, antecedentes_familiares, enfermedades_actuales, raos_organos_sentidos, " +
                "raos_respiratorio, raos_cardiovascular, raos_digestivo, raos_genital, raos_urinario, raos_musculo_esqueletico, " +
                "raos_endocrino, raos_hemo_linfatico, raos_nervioso, sva_fecha_medicion, sva_temperatura, sva_presion_arterial, " +
                "sva_pulsomin_fre_respiratoria, sva_pesokg_tallacm, efr_cabeza, efr_cuello, efr_torax, efr_abdomen, efr_pelvs, " +
                "efr_extremidades, diagnostico_desc, diagnostico_cie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            setHistoriaClinicaParameters(pstmt, historiaClinica);
            pstmt.executeUpdate();
        }
    }

    // Método para obtener una historia clínica por su ID
    public HistoriaClinica obtenerHistoriaClinicaPorId(String idHistoriaClinica) throws SQLException {
        String query = "SELECT * FROM Historia_clinica WHERE id_historia_clinica = ?";

        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, idHistoriaClinica);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return buildHistoriaClinicaFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Método para obtener todas las historias clínicas
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() throws SQLException {
        List<HistoriaClinica> historiasClinicas = new ArrayList<>();
        String query = "SELECT * FROM Historia_clinica";

        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                historiasClinicas.add(buildHistoriaClinicaFromResultSet(rs));
            }
        }
        return historiasClinicas;
    }

    // Método para actualizar una historia clínica existente
    public void actualizarHistoriaClinica(HistoriaClinica historiaClinica) throws SQLException {
        String query = "UPDATE Historia_clinica SET ci_medico = ?, ci_paciente = ?, motivo_consulta = ?, antecedentes_personales = ?, antecedentes_familiares = ?, enfermedades_actuales = ?, raos_organos_sentidos = ?, raos_respiratorio = ?, raos_cardiovascular = ?, raos_digestivo = ?, raos_genital = ?, raos_urinario = ?, raos_musculo_esqueletico = ?, raos_endocrino = ?, raos_hemo_linfatico = ?, raos_nervioso = ?, sva_fecha_medicion = ?, sva_temperatura = ?, sva_presion_arterial = ?, sva_pulsomin_fre_respiratoria = ?, sva_pesokg_tallacm = ?, efr_cabeza = ?, efr_cuello = ?, efr_torax = ?, efr_abdomen = ?, efr_pelvs = ?, efr_extremidades = ?, diagnostico_desc = ?, diagnostico_cie = ? WHERE id_historia_clinica = ?";

        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
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
            pstmt.setDate(18, historiaClinica.getSvaFechaMedicion()); // Corregido
            pstmt.setString(19, historiaClinica.getSvaTemperatura());
            pstmt.setString(20, historiaClinica.getSvaPresionArterial());
            pstmt.setString(21, historiaClinica.getSvaPulsoMinFreRespiratoria());
            pstmt.setString(22, historiaClinica.getSvaPesoKgTallaCm());
            pstmt.setString(23, historiaClinica.getEfrCabeza());
            pstmt.setString(24, historiaClinica.getEfrCuello());
            pstmt.setString(25, historiaClinica.getEfrTorax());
            pstmt.setString(26, historiaClinica.getEfrAbdomen());
            pstmt.setString(27, historiaClinica.getEfrPelvis());
            pstmt.setString(28, historiaClinica.getEfrExtremidades());
            pstmt.setString(29, historiaClinica.getDiagnosticoDesc());
            pstmt.setString(30, historiaClinica.getDiagnosticoCIE());
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar una historia clínica por su ID
    public void eliminarHistoriaClinica(String idHistoriaClinica) throws SQLException {
        String query = "DELETE FROM Historia_clinica WHERE id_historia_clinica = ?";

        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, idHistoriaClinica);
            pstmt.executeUpdate();
        }
    }

    // Método para establecer los parámetros de la historia clínica en el PreparedStatement
    private void setHistoriaClinicaParameters(PreparedStatement pstmt, HistoriaClinica historiaClinica) throws SQLException {
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
        pstmt.setDate(18, historiaClinica.getSvaFechaMedicion()); // Corregido
        pstmt.setString(19, historiaClinica.getSvaTemperatura());
        pstmt.setString(20, historiaClinica.getSvaPresionArterial());
        pstmt.setString(21, historiaClinica.getSvaPulsoMinFreRespiratoria());
        pstmt.setString(22, historiaClinica.getSvaPesoKgTallaCm());
        pstmt.setString(23, historiaClinica.getEfrCabeza());
        pstmt.setString(24, historiaClinica.getEfrCuello());
        pstmt.setString(25, historiaClinica.getEfrTorax());
        pstmt.setString(26, historiaClinica.getEfrAbdomen());
        pstmt.setString(27, historiaClinica.getEfrPelvis());
        pstmt.setString(28, historiaClinica.getEfrExtremidades());
        pstmt.setString(29, historiaClinica.getDiagnosticoDesc());
        pstmt.setString(30, historiaClinica.getDiagnosticoCIE());
    }

    // Método para construir una historia clínica a partir de un ResultSet
    private HistoriaClinica buildHistoriaClinicaFromResultSet(ResultSet rs) throws SQLException {
        return new HistoriaClinica.Builder()
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
                .svaFechaMedicion(rs.getDate("sva_fecha_medicion")) // Corregido
                .svaTemperatura(rs.getString("sva_temperatura"))
                .svaPresionArterial(rs.getString("sva_presion_arterial"))
                .svaPulsoMinFreRespiratoria(rs.getString("sva_pulsomin_fre_respiratoria"))
                .svaPesoKgTallaCm(rs.getString("sva_pesokg_tallacm"))
                .efrCabeza(rs.getString("efr_cabeza"))
                .efrCuello(rs.getString("efr_cuello"))
                .efrTorax(rs.getString("efr_torax"))
                .efrAbdomen(rs.getString("efr_abdomen"))
                .efrPelvis(rs.getString("efr_pelvs"))
                .efrExtremidades(rs.getString("efr_extremidades"))
                .diagnosticoDesc(rs.getString("diagnostico_desc"))
                .diagnosticoCIE(rs.getString("diagnostico_cie"))
                .build();
    }
}
