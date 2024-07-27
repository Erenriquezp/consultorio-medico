package org.uce.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDAO {

    private static ConexionDAO instancia;
    private Connection conexion;

    private ConexionDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/consultorio";
            String username = "root";
            String password = "patrones123";

            this.conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Creación de la conexión a la base de datos fallida: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Conexión a la base de datos fallida: " + ex.getMessage());
            throw ex;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public static ConexionDAO getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionDAO();
        } else if (instancia.getConexion().isClosed()) {
            instancia = new ConexionDAO();
        }
        return instancia;
    }

}
