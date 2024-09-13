package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.CrearUsuarioDAOImpl;
import model.Administrativo;
import model.Usuario;
import model.DAO.ICrearUsuarioDAO;

@WebServlet("/EditarAdministrativo")
public class EditarAdministrativo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICrearUsuarioDAO usuarioDAO;

    public EditarAdministrativo() {
        super();
        // Inicializar el DAO
        this.usuarioDAO = new CrearUsuarioDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");

        // Buscar administrativo por su RUT en la base de datos
        Usuario usuario = usuarioDAO.obtenerUsuarioPorRut(rut);

        if (usuario instanceof Administrativo) {
            Administrativo administrativo = (Administrativo) usuario;
            // Enviar el administrativo al JSP para editar
            request.setAttribute("administrativo", administrativo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/editarAdministrativo.jsp");
            dispatcher.forward(request, response);
        } else {
            // Manejar el caso en que el usuario no sea un administrativo
            response.sendRedirect("ListadoUsuarios");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave"); // Asegúrate de tener el campo "clave" en el formulario

        // Crear el objeto administrativo con los datos actualizados
        Administrativo administrativo = new Administrativo(rut, nombre, clave, "Administrativo");

        // Actualizar el administrativo en la base de datos
        usuarioDAO.editarUsuario(administrativo);

        // Redirigir a la lista de usuarios
        response.sendRedirect("ListadoUsuarios");
    }
}