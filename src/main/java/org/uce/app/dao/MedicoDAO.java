package org.uce.app.dao;

import org.uce.app.model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDAO {

    private static final Logger LOGGER = Logger.getLogger(MedicoDAO.class.getName());

    // Método para crear un nuevo médico
    public boolean createMedico(Medico medico) {
        String query = "INSERT INTO medico (ci_medico, apellidos, nombres, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            setMedicoParameters(stmt, medico);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al crear médico: " + medico, e);
            return false;
        }
    }

    // Método para obtener todos los médicos
    public List<Medico> getAllMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String query = "SELECT * FROM medico";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                medicos.add(buildMedicoFromResultSet(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener todos los médicos", e);
        }
        return medicos;
    }

    // Método para obtener un médico por CI
    public Medico getMedicoByCi(String ciMedico) {
        String query = "SELECT * FROM medico WHERE ci_medico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciMedico);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildMedicoFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener médico por CI: " + ciMedico, e);
        }
        return null;
    }

    // Método para actualizar un médico
    public boolean updateMedico(Medico medico) {
        String query = "UPDATE medico SET apellidos = ?, nombres = ?, telefono = ?, email = ? WHERE ci_medico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            setMedicoParameters(stmt, medico);
            stmt.setString(5, medico.getCiMedico());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar médico: " + medico, e);
            return false;
        }
    }

    // Método para eliminar un médico
    public boolean deleteMedico(String ciMedico) {
        String query = "DELETE FROM medico WHERE ci_medico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciMedico);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar médico con CI: " + ciMedico, e);
            return false;
        }
    }

    // Método auxiliar para establecer los parámetros del PreparedStatement
    private void setMedicoParameters(PreparedStatement stmt, Medico medico) throws SQLException {
        stmt.setString(1, medico.getCiMedico());
        stmt.setString(2, medico.getApellidos());
        stmt.setString(3, medico.getNombres());
        stmt.setString(4, medico.getTelefono());
        stmt.setString(5, medico.getEmail());
    }

    // Método auxiliar para construir un objeto Medico a partir de un ResultSet
    private Medico buildMedicoFromResultSet(ResultSet rs) throws SQLException {
        return new Medico.Builder()
                .ciMedico(rs.getString("ci_medico"))
                .apellidos(rs.getString("apellidos"))
                .nombres(rs.getString("nombres"))
                .telefono(rs.getString("telefono"))
                .email(rs.getString("email"))
                .build();
    }
}
