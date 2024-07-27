package org.uce.app.dao;

import org.uce.app.model.Evolucion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvolucionDAO {

    // Método para crear una nueva evolución
    public void crearEvolucion(Evolucion evolucion) throws SQLException {
        String query = "INSERT INTO Evolucion (id_historia_clinica, fecha, descripcion) VALUES (?, ?, ?)";
        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            setEvolucionParameters(pstmt, evolucion);
            pstmt.executeUpdate();
        }
    }

    // Método para obtener una evolución por su ID
    public Evolucion obtenerEvolucionPorId(int idEvolucion) throws SQLException {
        String query = "SELECT * FROM Evolucion WHERE id_evolucion = ?";
        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idEvolucion);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return buildEvolucionFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Método para obtener todas las evoluciones
    public List<Evolucion> obtenerTodasLasEvoluciones() throws SQLException {
        List<Evolucion> evoluciones = new ArrayList<>();
        String query = "SELECT * FROM Evolucion";
        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                evoluciones.add(buildEvolucionFromResultSet(rs));
            }
        }
        return evoluciones;
    }

    // Método para actualizar una evolución existente
    public void actualizarEvolucion(Evolucion evolucion) throws SQLException {
        String query = "UPDATE Evolucion SET id_historia_clinica = ?, fecha = ?, descripcion = ? WHERE id_evolucion = ?";
        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            setEvolucionParameters(pstmt, evolucion);
            pstmt.setInt(4, evolucion.getIdEvolucion());
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar una evolución por su ID
    public void eliminarEvolucion(int idEvolucion) throws SQLException {
        String query = "DELETE FROM Evolucion WHERE id_evolucion = ?";
        try (Connection conexion = ConexionDAO.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idEvolucion);
            pstmt.executeUpdate();
        }
    }

    // Método para establecer los parámetros de la evolución en el PreparedStatement
    private void setEvolucionParameters(PreparedStatement pstmt, Evolucion evolucion) throws SQLException {
        pstmt.setString(1, evolucion.getIdHistoriaClinica());
        pstmt.setDate(2, new java.sql.Date(evolucion.getFecha().getTime()));
        pstmt.setString(3, evolucion.getDescripcion());
    }

    // Método para construir una evolución a partir de un ResultSet
    private Evolucion buildEvolucionFromResultSet(ResultSet rs) throws SQLException {
        return new Evolucion.EvolutionBuilder()
                .idEvolucion(rs.getInt("id_evolucion"))
                .idHistoriaClinica(rs.getString("id_historia_clinica"))
                .fecha(rs.getDate("fecha"))
                .descripcion(rs.getString("descripcion"))
                .build();
    }
}
