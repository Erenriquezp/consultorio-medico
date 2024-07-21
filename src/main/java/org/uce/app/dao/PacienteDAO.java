package org.uce.app.dao;

import org.uce.app.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // Método para crear un nuevo paciente
    public boolean createPaciente(Paciente paciente) {
        String query = "INSERT INTO Paciente (ci_paciente, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, direccion_residencia, barrio, parroquia, canton, provincia, telefono, fecha_nacimiento, lugar_nacimiento, nacionalidad, grupo_cultural, edad, estado_civil, instruccion_ultimo_anio, fecha_admision, ocupacion, lugar_trabajo, tipo_seguro, referencia, contacto_emergencia_nombre, contacto_emergencia_parentesco, contacto_emergencia_direccion, contacto_emergencia_telefono) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paciente.getCiPaciente());
            stmt.setString(2, paciente.getPrimerNombre());
            stmt.setString(3, paciente.getSegundoNombre());
            stmt.setString(4, paciente.getApellidoPaterno());
            stmt.setString(5, paciente.getApellidoMaterno());
            stmt.setString(6, paciente.getDireccionResidencia());
            stmt.setString(7, paciente.getBarrio());
            stmt.setString(8, paciente.getParroquia());
            stmt.setString(9, paciente.getCanton());
            stmt.setString(10, paciente.getProvincia());
            stmt.setString(11, paciente.getTelefono());
            stmt.setDate(12, Date.valueOf(paciente.getFechaNacimiento()));
            stmt.setString(13, paciente.getLugarNacimiento());
            stmt.setString(14, paciente.getNacionalidad());
            stmt.setString(15, paciente.getGrupoCultural());
            stmt.setInt(16, paciente.getEdad());
            stmt.setString(17, paciente.getEstadoCivil());
            stmt.setString(18, paciente.getInstruccionUltimoAnio());
            stmt.setDate(19, Date.valueOf(paciente.getFechaAdmision()));
            stmt.setString(20, paciente.getOcupacion());
            stmt.setString(21, paciente.getLugarTrabajo());
            stmt.setString(22, paciente.getTipoSeguro());
            stmt.setString(23, paciente.getReferencia());
            stmt.setString(24, paciente.getContactoEmergenciaNombre());
            stmt.setString(25, paciente.getContactoEmergenciaParentesco());
            stmt.setString(26, paciente.getContactoEmergenciaDireccion());
            stmt.setString(27, paciente.getContactoEmergenciaTelefono());
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
        String query = "SELECT * FROM Paciente";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCiPaciente(rs.getString("ci_paciente"));
                paciente.setPrimerNombre(rs.getString("primer_nombre"));
                paciente.setSegundoNombre(rs.getString("segundo_nombre"));
                paciente.setApellidoPaterno(rs.getString("apellido_paterno"));
                paciente.setApellidoMaterno(rs.getString("apellido_materno"));
                paciente.setDireccionResidencia(rs.getString("direccion_residencia"));
                paciente.setBarrio(rs.getString("barrio"));
                paciente.setParroquia(rs.getString("parroquia"));
                paciente.setCanton(rs.getString("canton"));
                paciente.setProvincia(rs.getString("provincia"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                paciente.setLugarNacimiento(rs.getString("lugar_nacimiento"));
                paciente.setNacionalidad(rs.getString("nacionalidad"));
                paciente.setGrupoCultural(rs.getString("grupo_cultural"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setEstadoCivil(rs.getString("estado_civil"));
                paciente.setInstruccionUltimoAnio(rs.getString("instruccion_ultimo_anio"));
                paciente.setFechaAdmision(rs.getDate("fecha_admision").toLocalDate());
                paciente.setOcupacion(rs.getString("ocupacion"));
                paciente.setLugarTrabajo(rs.getString("lugar_trabajo"));
                paciente.setTipoSeguro(rs.getString("tipo_seguro"));
                paciente.setReferencia(rs.getString("referencia"));
                paciente.setContactoEmergenciaNombre(rs.getString("contacto_emergencia_nombre"));
                paciente.setContactoEmergenciaParentesco(rs.getString("contacto_emergencia_parentesco"));
                paciente.setContactoEmergenciaDireccion(rs.getString("contacto_emergencia_direccion"));
                paciente.setContactoEmergenciaTelefono(rs.getString("contacto_emergencia_telefono"));
                pacientes.add(paciente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    // Método para obtener un paciente por CI
    public Paciente getPacienteByCi(String ciPaciente) {
        Paciente paciente = null;
        String query = "SELECT * FROM Paciente WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciPaciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setCiPaciente(rs.getString("ci_paciente"));
                    paciente.setPrimerNombre(rs.getString("primer_nombre"));
                    paciente.setSegundoNombre(rs.getString("segundo_nombre"));
                    paciente.setApellidoPaterno(rs.getString("apellido_paterno"));
                    paciente.setApellidoMaterno(rs.getString("apellido_materno"));
                    paciente.setDireccionResidencia(rs.getString("direccion_residencia"));
                    paciente.setBarrio(rs.getString("barrio"));
                    paciente.setParroquia(rs.getString("parroquia"));
                    paciente.setCanton(rs.getString("canton"));
                    paciente.setProvincia(rs.getString("provincia"));
                    paciente.setTelefono(rs.getString("telefono"));
                    paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    paciente.setLugarNacimiento(rs.getString("lugar_nacimiento"));
                    paciente.setNacionalidad(rs.getString("nacionalidad"));
                    paciente.setGrupoCultural(rs.getString("grupo_cultural"));
                    paciente.setEdad(rs.getInt("edad"));
                    paciente.setEstadoCivil(rs.getString("estado_civil"));
                    paciente.setInstruccionUltimoAnio(rs.getString("instruccion_ultimo_anio"));
                    paciente.setFechaAdmision(rs.getDate("fecha_admision").toLocalDate());
                    paciente.setOcupacion(rs.getString("ocupacion"));
                    paciente.setLugarTrabajo(rs.getString("lugar_trabajo"));
                    paciente.setTipoSeguro(rs.getString("tipo_seguro"));
                    paciente.setReferencia(rs.getString("referencia"));
                    paciente.setContactoEmergenciaNombre(rs.getString("contacto_emergencia_nombre"));
                    paciente.setContactoEmergenciaParentesco(rs.getString("contacto_emergencia_parentesco"));
                    paciente.setContactoEmergenciaDireccion(rs.getString("contacto_emergencia_direccion"));
                    paciente.setContactoEmergenciaTelefono(rs.getString("contacto_emergencia_telefono"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    // Método para actualizar un paciente
    public boolean updatePaciente(Paciente paciente) {
        String query = "UPDATE Paciente SET primer_nombre = ?, segundo_nombre = ?, apellido_paterno = ?, apellido_materno = ?, direccion_residencia = ?, barrio = ?, parroquia = ?, canton = ?, provincia = ?, telefono = ?, fecha_nacimiento = ?, lugar_nacimiento = ?, nacionalidad = ?, grupo_cultural = ?, edad = ?, estado_civil = ?, instruccion_ultimo_anio = ?, fecha_admision = ?, ocupacion = ?, lugar_trabajo = ?, tipo_seguro = ?, referencia = ?, contacto_emergencia_nombre = ?, contacto_emergencia_parentesco = ?, contacto_emergencia_direccion = ?, contacto_emergencia_telefono = ? WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paciente.getPrimerNombre());
            stmt.setString(2, paciente.getSegundoNombre());
            stmt.setString(3, paciente.getApellidoPaterno());
            stmt.setString(4, paciente.getApellidoMaterno());
            stmt.setString(5, paciente.getDireccionResidencia());
            stmt.setString(6, paciente.getBarrio());
            stmt.setString(7, paciente.getParroquia());
            stmt.setString(8, paciente.getCanton());
            stmt.setString(9, paciente.getProvincia());
            stmt.setString(10, paciente.getTelefono());
            stmt.setDate(11, Date.valueOf(paciente.getFechaNacimiento()));
            stmt.setString(12, paciente.getLugarNacimiento());
            stmt.setString(13, paciente.getNacionalidad());
            stmt.setString(14, paciente.getGrupoCultural());
            stmt.setInt(15, paciente.getEdad());
            stmt.setString(16, paciente.getEstadoCivil());
            stmt.setString(17, paciente.getInstruccionUltimoAnio());
            stmt.setDate(18, Date.valueOf(paciente.getFechaAdmision()));
            stmt.setString(19, paciente.getOcupacion());
            stmt.setString(20, paciente.getLugarTrabajo());
            stmt.setString(21, paciente.getTipoSeguro());
            stmt.setString(22, paciente.getReferencia());
            stmt.setString(23, paciente.getContactoEmergenciaNombre());
            stmt.setString(24, paciente.getContactoEmergenciaParentesco());
            stmt.setString(25, paciente.getContactoEmergenciaDireccion());
            stmt.setString(26, paciente.getContactoEmergenciaTelefono());
            stmt.setString(27, paciente.getCiPaciente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un paciente
    public boolean deletePaciente(String ciPaciente) {
        String query = "DELETE FROM Paciente WHERE ci_paciente = ?";
        try (Connection connection = ConexionDAO.getInstancia().getConexion();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ciPaciente);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
