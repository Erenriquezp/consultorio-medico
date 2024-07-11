package org.uce.app.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private Connection connection;

//    public MedicoDAO() {
//        try {
//            connection = DatabaseConnection.getInstance().getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public List<Medico> getAllMedicos() {
//        List<Medico> medicos = new ArrayList<>();
//        String query = "SELECT * FROM medico";
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//            while (rs.next()) {
//                Medico medico = new Medico();
//                medico.setId(rs.getInt("id"));
//                medico.setNombre(rs.getString("nombre"));
//                medico.setEspecialidad(rs.getString("especialidad"));
//                medico.setTelefono(rs.getString("telefono"));
//                medico.setEmail(rs.getString("email"));
//                medicos.add(medico);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return medicos;
//    }

    // Métodos CRUD para Medico (Create, Read, Update, Delete)
}