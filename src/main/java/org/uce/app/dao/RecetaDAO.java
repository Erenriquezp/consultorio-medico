package org.uce.app.dao;

import org.uce.app.model.Receta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecetaDAO {

    // Método para crear una nueva receta
    public boolean createReceta(Receta receta) {
        String query = "INSERT INTO receta (ci_paciente, ci_medico, fecha_emision, medicamentos, dosis) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, receta.getCiPaciente());
            stmt.setString(2, receta.getCiMedico());
            stmt.setDate(3, Date.valueOf(receta.getFechaEmision()));
            stmt.setString(4, receta.getMedicamentos());
            stmt.setString(5, receta.getDosis());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las recetas
    public List<Receta> getAllRecetas() {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Receta receta = new Receta.RecetaBuilder()
                        .idReceta(rs.getInt("id_receta"))
                        .ciPaciente(rs.getString("ci_paciente"))
                        .ciMedico(rs.getString("ci_medico"))
                        .fechaEmision(rs.getObject("fecha_emision", LocalDate.class))
                        .medicamentos(rs.getString("medicamentos"))
                        .dosis(rs.getString("dosis"))
                        .build();

                recetas.add(receta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recetas;
    }

    // Método para obtener una receta por ID
    public Receta getRecetaById(int idReceta) {
        Receta receta = null;
        String query = "SELECT * FROM receta WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReceta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    receta = new Receta.RecetaBuilder()
                            .idReceta(rs.getInt("id_receta"))
                            .ciPaciente(rs.getString("ci_paciente"))
                            .ciMedico(rs.getString("ci_medico"))
                            .fechaEmision(rs.getObject("fecha_emision", LocalDate.class))
                            .medicamentos(rs.getString("medicamentos"))
                            .dosis(rs.getString("dosis"))
                            .build();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receta;
    }

    // Método para actualizar una receta
    public boolean updateReceta(Receta receta) {
        String query = "UPDATE receta SET ci_paciente = ?, ci_medico = ?, fecha_emision = ?, medicamentos = ?, dosis = ? WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, receta.getCiPaciente());
            stmt.setString(2, receta.getCiMedico());
            stmt.setDate(3, Date.valueOf(receta.getFechaEmision()));
            stmt.setString(4, receta.getMedicamentos());
            stmt.setString(5, receta.getDosis());
            stmt.setInt(6, receta.getIdReceta());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una receta por ID
    public boolean deleteReceta(int idReceta) {
        String query = "DELETE FROM receta WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReceta);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
