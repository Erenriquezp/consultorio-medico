package org.uce.app.dao;

import org.uce.app.model.Evolucion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvolucionDAO {

    private Connection conexion;

    public EvolucionDAO() throws SQLException {
        this.conexion = ConexionDAO.getInstancia().getConexion();
    }

    // Método para crear una nueva evolución
    public void crearEvolucion(Evolucion evolucion) throws SQLException {
        String query = "INSERT INTO Evolucion (id_historia_clinica, fecha, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, evolucion.getIdHistoriaClinica());
            pstmt.setDate(2, new java.sql.Date(evolucion.getFecha().getTime()));
            pstmt.setString(3, evolucion.getDescripcion());
            pstmt.executeUpdate();
        }
    }

    // Método para obtener una evolución por su ID
    public Evolucion obtenerEvolucionPorId(int idEvolucion) throws SQLException {
        String query = "SELECT * FROM Evolucion WHERE id_evolucion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idEvolucion);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Evolucion evolucion = new Evolucion.EvolutionBuilder()
                            .idEvolucion(rs.getInt("id_evolucion"))
                            .idHistoriaClinica(rs.getString("id_historia_clinica"))
                            .fecha(rs.getDate("fecha"))
                            .descripcion(rs.getString("descripcion"))
                            .build();
                    return evolucion;
                }
            }
        }
        return null;
    }

    // Método para obtener todas las evoluciones
    public List<Evolucion> obtenerTodasLasEvoluciones() throws SQLException {
        List<Evolucion> evoluciones = new ArrayList<>();
        String query = "SELECT * FROM Evolucion";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Evolucion evolucion = new Evolucion.EvolutionBuilder()
                        .idEvolucion(rs.getInt("id_evolucion"))
                        .idHistoriaClinica(rs.getString("id_historia_clinica"))
                        .fecha(rs.getDate("fecha"))
                        .descripcion(rs.getString("descripcion"))
                        .build();
                evoluciones.add(evolucion);
            }
        }
        return evoluciones;
    }

    // Método para actualizar una evolución existente
    public void actualizarEvolucion(Evolucion evolucion) throws SQLException {
        String query = "UPDATE Evolucion SET id_historia_clinica = ?, fecha = ?, descripcion = ? WHERE id_evolucion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, evolucion.getIdHistoriaClinica());
            pstmt.setDate(2, new java.sql.Date(evolucion.getFecha().getTime()));
            pstmt.setString(3, evolucion.getDescripcion());
            pstmt.setInt(4, evolucion.getIdEvolucion());
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar una evolución por su ID
    public void eliminarEvolucion(int idEvolucion) throws SQLException {
        String query = "DELETE FROM Evolucion WHERE id_evolucion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idEvolucion);
            pstmt.executeUpdate();
        }
    }
}
