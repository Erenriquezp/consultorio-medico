package org.uce.app.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uce.app.dao.ConexionDAO;
import org.uce.app.dao.UsuarioDAO;
import org.uce.app.model.Usuario;

public class AuthService {

    private Connection connection;

    public AuthService() {
        try {
            connection = ConexionDAO.getInstancia().getConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        UsuarioDAO userAut = new UsuarioDAO();
        if (userAut.findByUsername(username) == null) {
            return false;
        } else {
            Usuario user = userAut.findByUsername(username);
            return username.equals(user.getUsername()) && password.equals(user.getPassword());
        }
    }
}
