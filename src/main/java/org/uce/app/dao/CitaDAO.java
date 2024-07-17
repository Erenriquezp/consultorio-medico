package org.uce.app.dao;

import org.uce.app.model.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Método para crear una nueva cita
    public boolean createCita(Cita cita) {
        String query = "INSERT INTO cita (idCita, ciPaciente, ciMedico, fechaCita, motivo, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cita.getIdCita());
            stmt.setString(2, cita.getCiPaciente());
            stmt.setString(3, cita.getCiMedico());
            stmt.setTimestamp(4, new Timestamp(cita.getFechaCita().getTime()));
            stmt.setString(5, cita.getMotivo());
            stmt.setString(6, cita.getEstado());
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
        String query = "SELECT * FROM cita";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdCita(rs.getString("idCita"));
                cita.setCiPaciente(rs.getString("ciPaciente"));
                cita.setCiMedico(rs.getString("ciMedico"));
                cita.setFechaCita(rs.getTimestamp("fechaCita"));
                cita.setMotivo(rs.getString("motivo"));
                cita.setEstado(rs.getString("estado"));
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    // Método para obtener una cita por ID
    public Cita getCitaById(String idCita) {
        Cita cita = null;
        String query = "SELECT * FROM cita WHERE idCita = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idCita);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cita = new Cita();
                    cita.setIdCita(rs.getString("idCita"));
                    cita.setCiPaciente(rs.getString("ciPaciente"));
                    cita.setCiMedico(rs.getString("ciMedico"));
                    cita.setFechaCita(rs.getTimestamp("fechaCita"));
                    cita.setMotivo(rs.getString("motivo"));
                    cita.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    // Método para actualizar una cita
    public boolean updateCita(Cita cita) {
        String query = "UPDATE cita SET ciPaciente = ?, ciMedico = ?, fechaCita = ?, motivo = ?, estado = ? WHERE idCita = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cita.getCiPaciente());
            stmt.setString(2, cita.getCiMedico());
            stmt.setTimestamp(3, new Timestamp(cita.getFechaCita().getTime()));
            stmt.setString(4, cita.getMotivo());
            stmt.setString(5, cita.getEstado());
            stmt.setString(6, cita.getIdCita());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una cita
    public boolean deleteCita(String idCita) {
        String query = "DELETE FROM cita WHERE idCita = ?";
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
}
