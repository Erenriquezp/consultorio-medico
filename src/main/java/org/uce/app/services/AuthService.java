package org.uce.app.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uce.app.dao.ConexionDAO;

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
        return true;
    }
}
