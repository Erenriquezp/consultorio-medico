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
                Usuario usuario = new Usuario.UsuarioBuilder()
                        .username(rs.getString("med_user"))
                        .password(rs.getString("med_password"))
                        .ci(rs.getString("ci_medico"))
                        .build();

                System.out.println(usuario.getUsername());
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

