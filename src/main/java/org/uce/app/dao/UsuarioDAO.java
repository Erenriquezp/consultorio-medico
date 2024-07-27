package org.uce.app.dao;

import org.uce.app.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());

    // Método para encontrar un usuario por nombre de usuario
    public Usuario findByUsername(String username) {
        String query = "SELECT * FROM LogIn WHERE med_user = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario.UsuarioBuilder()
                            .username(rs.getString("med_user"))
                            .password(rs.getString("med_password"))
                            .ci(rs.getString("ci_medico"))
                            .build();

                    LOGGER.info("Usuario encontrado: " + usuario.getUsername());
                    return usuario;
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al buscar usuario con nombre: " + username, e);
        }
        return null;
    }
}
