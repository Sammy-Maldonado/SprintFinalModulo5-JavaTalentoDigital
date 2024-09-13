package implement;

import model.Administrativo;
import model.Cliente;
import model.Profesional;
import model.Usuario;
import model.DAO.ICrearUsuarioDAO;
import connection.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrearUsuarioDAOImpl implements ICrearUsuarioDAO {
    private Connection conexion;

    public CrearUsuarioDAOImpl() {
        this.conexion = ConexionBD.getInstancia().getConexion();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                String tipoUsuario = rs.getString("tipoUsuario");
                String empresa = rs.getString("empresa");
                String especialidad = rs.getString("especialidad");

                Usuario usuario;
                switch (tipoUsuario) {
                    case "Cliente":
                        usuario = new Cliente(rut, nombre, clave, tipoUsuario, empresa);
                        break;
                    case "Profesional":
                        usuario = new Profesional(rut, nombre, clave, tipoUsuario, especialidad);
                        break;
                    case "Administrativo":
                        usuario = new Administrativo(rut, nombre, clave, tipoUsuario);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de usuario no válido");
                }
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    @Override
    public void crearUsuario(Usuario usuario) {
        String sql;
        if (usuario instanceof Cliente) {
            sql = "INSERT INTO usuarios (rut, nombre, clave, tipoUsuario, empresa) VALUES (?, ?, ?, ?, ?)";
        } else if (usuario instanceof Profesional) {
            sql = "INSERT INTO usuarios (rut, nombre, clave, tipoUsuario, especialidad) VALUES (?, ?, ?, ?, ?)";
        } else if (usuario instanceof Administrativo) {
            sql = "INSERT INTO usuarios (rut, nombre, clave, tipoUsuario) VALUES (?, ?, ?, ?)";
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getRut());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getClave());
            pstmt.setString(4, usuario.getTipoUsuario());

            if (usuario instanceof Cliente) {
                pstmt.setString(5, ((Cliente) usuario).getEmpresa());
            } else if (usuario instanceof Profesional) {
                pstmt.setString(5, ((Profesional) usuario).getEspecialidad());
            }

            pstmt.executeUpdate();
            System.out.println("Usuario creado: " + usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void editarUsuario(Usuario usuario) {
        String sql;
        
        // Determinar el tipo de usuario y crear la consulta SQL correspondiente
        if (usuario instanceof Cliente) {
            sql = "UPDATE usuarios SET nombre = ?, clave = ?, empresa = ? WHERE rut = ?";
        } else if (usuario instanceof Profesional) {
            sql = "UPDATE usuarios SET nombre = ?, clave = ?, especialidad = ? WHERE rut = ?";
        } else if (usuario instanceof Administrativo) {
            sql = "UPDATE usuarios SET nombre = ?, clave = ? WHERE rut = ?";
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getClave());

            // Asignar campos adicionales según el tipo de usuario
            if (usuario instanceof Cliente) {
                pstmt.setString(3, ((Cliente) usuario).getEmpresa());
                pstmt.setString(4, usuario.getRut());
            } else if (usuario instanceof Profesional) {
                pstmt.setString(3, ((Profesional) usuario).getEspecialidad());
                pstmt.setString(4, usuario.getRut());
            } else if (usuario instanceof Administrativo) {
                pstmt.setString(3, usuario.getRut());
            }

            pstmt.executeUpdate();
            System.out.println("Usuario actualizado: " + usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Usuario obtenerUsuarioPorRut(String rut) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE rut = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, rut);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String clave = rs.getString("clave");
                    String tipoUsuario = rs.getString("tipoUsuario");
                    String empresa = rs.getString("empresa");
                    String especialidad = rs.getString("especialidad");

                    switch (tipoUsuario) {
                        case "Cliente":
                            usuario = new Cliente(rut, nombre, clave, tipoUsuario, empresa);
                            break;
                        case "Profesional":
                            usuario = new Profesional(rut, nombre, clave, tipoUsuario, especialidad);
                            break;
                        case "Administrativo":
                            usuario = new Administrativo(rut, nombre, clave, tipoUsuario);
                            break;
                        default:
                            throw new IllegalArgumentException("Tipo de usuario no válido");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}