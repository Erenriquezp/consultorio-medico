package org.uce.app.dao;

import org.uce.app.model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    // Método para crear un nuevo médico
    public boolean createMedico(Medico medico) {
        String query = "INSERT INTO medico (ciMedico, apellidos, nombres, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, medico.getCiMedico());
            stmt.setString(2, medico.getApellidos());
            stmt.setString(3, medico.getNombres());
            stmt.setString(4, medico.getTelefono());
            stmt.setString(5, medico.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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
                Medico medico = new Medico();
                medico.setCiMedico(rs.getString("ciMedico"));
                medico.setApellidos(rs.getString("apellidos"));
                medico.setNombres(rs.getString("nombres"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setEmail(rs.getString("email"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    // Método para obtener un médico por CI
    public Medico getMedicoByCi(String ciMedico) {
        Medico medico = null;
        String query = "SELECT * FROM medico WHERE ciMedico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciMedico);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();
                    medico.setCiMedico(rs.getString("ciMedico"));
                    medico.setApellidos(rs.getString("apellidos"));
                    medico.setNombres(rs.getString("nombres"));
                    medico.setTelefono(rs.getString("telefono"));
                    medico.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    // Método para actualizar un médico
    public boolean updateMedico(Medico medico) {
        String query = "UPDATE medico SET apellidos = ?, nombres = ?, telefono = ?, email = ? WHERE ciMedico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, medico.getApellidos());
            stmt.setString(2, medico.getNombres());
            stmt.setString(3, medico.getTelefono());
            stmt.setString(4, medico.getEmail());
            stmt.setString(5, medico.getCiMedico());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un médico
    public boolean deleteMedico(String ciMedico) {
        String query = "DELETE FROM medico WHERE ciMedico = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciMedico);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
