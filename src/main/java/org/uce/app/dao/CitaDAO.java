package org.uce.app.dao;

import org.uce.app.model.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Método para crear una nueva cita
    public boolean createCita(Cita cita) {
        String query = "INSERT INTO Cita (id_cita, ci_paciente, fecha_cita, motivo, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            setCitaParameters(stmt, cita);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las citas
    public List<Cita> getAllCitas() {
        List<Cita> citas = new ArrayList<>();
        String query = "SELECT * FROM Cita";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cita cita = buildCitaFromResultSet(rs);
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    // Método para obtener una cita por ID
    public Cita getCitaById(String idCita) {
        String query = "SELECT * FROM Cita WHERE id_cita = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idCita);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildCitaFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para actualizar una cita
    public boolean updateCita(Cita cita) {
        String query = "UPDATE Cita SET ci_paciente = ?, fecha_cita = ?, motivo = ?, estado = ? WHERE id_cita = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cita.getCiPaciente());
            stmt.setTimestamp(2, Timestamp.valueOf(cita.getFechaCita()));
            stmt.setString(3, cita.getMotivo());
            stmt.setString(4, cita.getEstado());
            stmt.setString(5, cita.getIdCita());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una cita
    public boolean deleteCita(String idCita) {
        String query = "DELETE FROM Cita WHERE id_cita = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idCita);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para establecer los parámetros de la cita en el PreparedStatement
    private void setCitaParameters(PreparedStatement stmt, Cita cita) throws SQLException {
        stmt.setString(1, cita.getIdCita());
        stmt.setString(2, cita.getCiPaciente());
        stmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaCita()));
        stmt.setString(4, cita.getMotivo());
        stmt.setString(5, cita.getEstado());
    }

    // Método para construir una cita a partir de un ResultSet
    private Cita buildCitaFromResultSet(ResultSet rs) throws SQLException {
        return new Cita.CitaBuilder()
                .idCita(rs.getString("id_cita"))
                .ciPaciente(rs.getString("ci_paciente"))
                .fechaCita(rs.getTimestamp("fecha_cita").toLocalDateTime())
                .motivo(rs.getString("motivo"))
                .estado(rs.getString("estado"))
                .build();
    }
}
