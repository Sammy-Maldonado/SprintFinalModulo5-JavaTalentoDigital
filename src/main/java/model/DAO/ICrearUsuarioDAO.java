package model.DAO;

import model.Usuario;
import java.util.List;

public interface ICrearUsuarioDAO {
	List<Usuario> listarUsuarios();
    void crearUsuario(Usuario usuario);
    void editarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorRut(String rut);
}