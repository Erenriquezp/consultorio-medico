package org.uce.app.model; // Paquete en el que se encuentra esta clase

import java.sql.*; // Importa todas las clases del paquete java.sql para manejo de la base de datos
import java.util.ArrayList; // Importa la clase ArrayList
import java.util.List; // Importa la interfaz List

public class MedicoDAO {
    private Connection connection; // Objeto Connection para establecer la conexión a la base de datos

    // Constructor de la clase
//    public MedicoDAO() {
//        try {
//            // Obtiene una instancia de la conexión a la base de datos
//            connection = DatabaseConnection.getInstance().getConnection();
//        } catch (SQLException e) {
//            // Manejo de la excepción en caso de error al conectar
//            e.printStackTrace();
//        }
//    }
//
//    // Método para obtener todos los médicos de la base de datos
//    public List<Medico> getAllMedicos() {
//        List<Medico> medicos = new ArrayList<>(); // Lista para almacenar los médicos
//        String query = "SELECT * FROM medico"; // Consulta SQL para obtener todos los médicos
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//            // Crea una declaración y ejecuta la consulta
//            while (rs.next()) {
//                // Recorre el resultado de la consulta
//                Medico medico = new Medico(); // Crea una nueva instancia de Medico
//                medico.setId(rs.getInt("id")); // Establece el ID del médico
//                medico.setNombre(rs.getString("nombre")); // Establece el nombre del médico
//                medico.setEspecialidad(rs.getString("especialidad")); // Establece la especialidad del médico
//                medico.setTelefono(rs.getString("telefono")); // Establece el teléfono del médico
//                medico.setEmail(rs.getString("email")); // Establece el email del médico
//                medicos.add(medico); // Agrega el médico a la lista
//            }
//        } catch (SQLException e) {
//            // Manejo de la excepción en caso de error al ejecutar la consulta
//            e.printStackTrace();
//        }
//        return medicos; // Retorna la lista de médicos
//    }
//
//    // Métodos CRUD para Medico (Create, Read, Update, Delete)
}
