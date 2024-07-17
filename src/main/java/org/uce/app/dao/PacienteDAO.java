package org.uce.app.dao;

import org.uce.app.model.Paciente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // Método para crear un nuevo paciente
    public boolean createPaciente(Paciente paciente) {
        String query = "INSERT INTO paciente (ci_paciente, primer_nombre, segundo_nombre, appellido_paterno, apellido_materno, direccion_recidencia, barrio, parroquia, canton, provincia, telefono, fecha_nacimiento, lugar_nacimiento, nacionalidad, grupo_cultural, edad, estado_civil, instruccion, fecha_admision, ocupacion, lugar_trabajo, tipo_seguro, referencia, contacto_emergencia_parentesco, contacto_emergencia_nombre, contacto_emergencia_direccion, contacto_emergencia_telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paciente.getCi_paciente());
            stmt.setString(2, paciente.getPrimer_nombre());
            stmt.setString(3, paciente.getSegundo_nombre());
            stmt.setString(4, paciente.getAppellido_paterno());
            stmt.setString(5, paciente.getApellido_materno());
            stmt.setString(6, paciente.getDireccion_recidencia());
            stmt.setString(7, paciente.getBarrio());
            stmt.setString(8, paciente.getParroquia());
            stmt.setString(9, paciente.getCanton());
            stmt.setString(10, paciente.getProvincia());
            stmt.setString(11, paciente.getTelefono());
            stmt.setDate(12, Date.valueOf(paciente.getFecha_nacimiento()));
            stmt.setString(13, paciente.getLugar_nacimiento());
            stmt.setString(14, paciente.getNacionalidad());
            stmt.setString(15, paciente.getGrupo_cultural());
            stmt.setInt(16, paciente.getEdad());
            stmt.setString(17, paciente.getEstado_civil());
            stmt.setString(18, paciente.getInstruccion());
            stmt.setDate(19, new java.sql.Date(paciente.getFecha_admision().getTime()));
            stmt.setString(20, paciente.getOcupacion());
            stmt.setString(21, paciente.getLugar_trabajo());
            stmt.setString(22, paciente.getTipo_seguro());
            stmt.setString(23, paciente.getReferencia());
            stmt.setString(24, paciente.getContacto_emergencia_parentesco());
            stmt.setString(25, paciente.getContacto_emergencia_nombre());
            stmt.setString(26, paciente.getContacto_emergencia_direccion());
            stmt.setString(27, paciente.getContacto_emergencia_telefono());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todos los pacientes
    public List<Paciente> getAllPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT * FROM paciente";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCi_paciente(rs.getString("ci_paciente"));
                paciente.setPrimer_nombre(rs.getString("primer_nombre"));
                paciente.setSegundo_nombre(rs.getString("segundo_nombre"));
                paciente.setAppellido_paterno(rs.getString("appellido_paterno"));
                paciente.setApellido_materno(rs.getString("apellido_materno"));
                paciente.setDireccion_recidencia(rs.getString("direccion_recidencia"));
                paciente.setBarrio(rs.getString("barrio"));
                paciente.setParroquia(rs.getString("parroquia"));
                paciente.setCanton(rs.getString("canton"));
                paciente.setProvincia(rs.getString("provincia"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                paciente.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                paciente.setNacionalidad(rs.getString("nacionalidad"));
                paciente.setGrupo_cultural(rs.getString("grupo_cultural"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setEstado_civil(rs.getString("estado_civil"));
                paciente.setInstruccion(rs.getString("instruccion"));
                paciente.setFecha_admision(rs.getDate("fecha_admision"));
                paciente.setOcupacion(rs.getString("ocupacion"));
                paciente.setLugar_trabajo(rs.getString("lugar_trabajo"));
                paciente.setTipo_seguro(rs.getString("tipo_seguro"));
                paciente.setReferencia(rs.getString("referencia"));
                paciente.setContacto_emergencia_parentesco(rs.getString("contacto_emergencia_parentesco"));
                paciente.setContacto_emergencia_nombre(rs.getString("contacto_emergencia_nombre"));
                paciente.setContacto_emergencia_direccion(rs.getString("contacto_emergencia_direccion"));
                paciente.setContacto_emergencia_telefono(rs.getString("contacto_emergencia_telefono"));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    // Método para obtener un paciente por CI
    public Paciente getPacienteByCi(String ci_paciente) {
        Paciente paciente = null;
        String query = "SELECT * FROM paciente WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ci_paciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setCi_paciente(rs.getString("ci_paciente"));
                    paciente.setPrimer_nombre(rs.getString("primer_nombre"));
                    paciente.setSegundo_nombre(rs.getString("segundo_nombre"));
                    paciente.setAppellido_paterno(rs.getString("appellido_paterno"));
                    paciente.setApellido_materno(rs.getString("apellido_materno"));
                    paciente.setDireccion_recidencia(rs.getString("direccion_recidencia"));
                    paciente.setBarrio(rs.getString("barrio"));
                    paciente.setParroquia(rs.getString("parroquia"));
                    paciente.setCanton(rs.getString("canton"));
                    paciente.setProvincia(rs.getString("provincia"));
                    paciente.setTelefono(rs.getString("telefono"));
                    paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    paciente.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                    paciente.setNacionalidad(rs.getString("nacionalidad"));
                    paciente.setGrupo_cultural(rs.getString("grupo_cultural"));
                    paciente.setEdad(rs.getInt("edad"));
                    paciente.setEstado_civil(rs.getString("estado_civil"));
                    paciente.setInstruccion(rs.getString("instruccion"));
                    paciente.setFecha_admision(rs.getDate("fecha_admision"));
                    paciente.setOcupacion(rs.getString("ocupacion"));
                    paciente.setLugar_trabajo(rs.getString("lugar_trabajo"));
                    paciente.setTipo_seguro(rs.getString("tipo_seguro"));
                    paciente.setReferencia(rs.getString("referencia"));
                    paciente.setContacto_emergencia_parentesco(rs.getString("contacto_emergencia_parentesco"));
                    paciente.setContacto_emergencia_nombre(rs.getString("contacto_emergencia_nombre"));
                    paciente.setContacto_emergencia_direccion(rs.getString("contacto_emergencia_direccion"));
                    paciente.setContacto_emergencia_telefono(rs.getString("contacto_emergencia_telefono"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    // Método para actualizar un paciente
    public boolean updatePaciente(Paciente paciente) {
        String query = "UPDATE paciente SET primer_nombre = ?, segundo_nombre = ?, appellido_paterno = ?, apellido_materno = ?, direccion_recidencia = ?, barrio = ?, parroquia = ?, canton = ?, provincia = ?, telefono = ?, fecha_nacimiento = ?, lugar_nacimiento = ?, nacionalidad = ?, grupo_cultural = ?, edad = ?, estado_civil = ?, instruccion = ?, fecha_admision = ?, ocupacion = ?, lugar_trabajo = ?, tipo_seguro = ?, referencia = ?, contacto_emergencia_parentesco = ?, contacto_emergencia_nombre = ?, contacto_emergencia_direccion = ?, contacto_emergencia_telefono = ? WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paciente.getPrimer_nombre());
            stmt.setString(2, paciente.getSegundo_nombre());
            stmt.setString(3, paciente.getAppellido_paterno());
            stmt.setString(4, paciente.getApellido_materno());
            stmt.setString(5, paciente.getDireccion_recidencia());
            stmt.setString(6, paciente.getBarrio());
            stmt.setString(7, paciente.getParroquia());
            stmt.setString(8, paciente.getCanton());
            stmt.setString(9, paciente.getProvincia());
            stmt.setString(10, paciente.getTelefono());
            stmt.setDate(11, Date.valueOf(paciente.getFecha_nacimiento()));
            stmt.setString(12, paciente.getLugar_nacimiento());
            stmt.setString(13, paciente.getNacionalidad());
            stmt.setString(14, paciente.getGrupo_cultural());
            stmt.setInt(15, paciente.getEdad());
            stmt.setString(16, paciente.getEstado_civil());
            stmt.setString(17, paciente.getInstruccion());
            stmt.setDate(18, new java.sql.Date(paciente.getFecha_admision().getTime()));
            stmt.setString(19, paciente.getOcupacion());
            stmt.setString(20, paciente.getLugar_trabajo());
            stmt.setString(21, paciente.getTipo_seguro());
            stmt.setString(22, paciente.getReferencia());
            stmt.setString(23, paciente.getContacto_emergencia_parentesco());
            stmt.setString(24, paciente.getContacto_emergencia_nombre());
            stmt.setString(25, paciente.getContacto_emergencia_direccion());
            stmt.setString(26, paciente.getContacto_emergencia_telefono());
            stmt.setString(27, paciente.getCi_paciente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un paciente por CI
    public boolean deletePaciente(String ci_paciente) {
        String query = "DELETE FROM paciente WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ci_paciente);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
