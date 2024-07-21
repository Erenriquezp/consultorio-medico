package org.uce.app.dao;

import org.uce.app.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario findByUsername(String username) {
        String query = "SELECT * FROM LogIn WHERE med_user = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsername(rs.getString("med_user"));
                usuario.setPassword(rs.getString("med_password"));
                usuario.setCi(rs.getString("ci_medico"));
                System.out.println(usuario.getUsername());
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

