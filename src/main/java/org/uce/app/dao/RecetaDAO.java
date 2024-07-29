package org.uce.app.dao;

import org.uce.app.model.Receta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaDAO {

    private static final Logger LOGGER = Logger.getLogger(RecetaDAO.class.getName());

    // Método para crear una nueva receta
    public boolean createReceta(Receta receta) {
        String query = "INSERT INTO Receta (ci_paciente, ci_medico, fecha_emision, medicamentos, dosis) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            setRecetaParameters(stmt, receta);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al crear receta: " + receta, e);
            return false;
        }
    }

    // Método para obtener todas las recetas
    public List<Receta> getAllRecetas() {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM Receta";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                recetas.add(buildRecetaFromResultSet(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener todas las recetas", e);
        }
        return recetas;
    }

    // Método para obtener una receta por ID
    public Receta getRecetaById(int idReceta) {
        String query = "SELECT * FROM Receta WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReceta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildRecetaFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener receta por ID: " + idReceta, e);
        }
        return null;
    }

    // Método para actualizar una receta
    public boolean updateReceta(Receta receta) {
        String query = "UPDATE Receta SET ci_paciente = ?, ci_medico = ?, fecha_emision = ?, medicamentos = ?, dosis = ? WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            setRecetaParameters(stmt, receta);
            stmt.setInt(6, receta.getIdReceta());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar receta: " + receta, e);
            return false;
        }
    }

    // Método para eliminar una receta por ID
    public boolean deleteReceta(int idReceta) {
        String query = "DELETE FROM Receta WHERE id_receta = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReceta);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar receta con ID: " + idReceta, e);
            return false;
        }
    }

    // Método auxiliar para establecer los parámetros del PreparedStatement
    private void setRecetaParameters(PreparedStatement stmt, Receta receta) throws SQLException {
        stmt.setString(1, receta.getCiPaciente());
        stmt.setString(2, receta.getCiMedico());
        stmt.setDate(3, Date.valueOf(receta.getFechaEmision()));
        stmt.setString(4, receta.getMedicamentos());
        stmt.setString(5, receta.getDosis());
    }

    // Método auxiliar para construir un objeto Receta a partir de un ResultSet
    private Receta buildRecetaFromResultSet(ResultSet rs) throws SQLException {
        return new Receta.Builder()
                .idReceta(rs.getInt("id_receta"))
                .ciPaciente(rs.getString("ci_paciente"))
                .ciMedico(rs.getString("ci_medico"))
                .fechaEmision(rs.getObject("fecha_emision", LocalDate.class))
                .medicamentos(rs.getString("medicamentos"))
                .dosis(rs.getString("dosis"))
                .build();
    }
}
