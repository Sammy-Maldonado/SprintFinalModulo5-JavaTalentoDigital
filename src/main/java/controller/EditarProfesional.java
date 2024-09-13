package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.CrearUsuarioDAOImpl;
import model.Profesional;
import model.Usuario;
import model.DAO.ICrearUsuarioDAO;

@WebServlet("/EditarProfesional")
public class EditarProfesional extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICrearUsuarioDAO usuarioDAO;

    public EditarProfesional() {
        super();
        // Inicializar el DAO
        this.usuarioDAO = new CrearUsuarioDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");

        // Buscar profesional por su RUT en la base de datos
        Usuario usuario = usuarioDAO.obtenerUsuarioPorRut(rut);

        if (usuario instanceof Profesional) {
            Profesional profesional = (Profesional) usuario;
            // Enviar el profesional al JSP para editar
            request.setAttribute("profesional", profesional);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/editarProfesional.jsp");
            dispatcher.forward(request, response);
        } else {
            // Manejar el caso en que el usuario no sea un profesional
            response.sendRedirect("ListadoUsuarios");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave"); // Asegúrate de tener el campo "clave" en el formulario
        String especialidad = request.getParameter("especialidad");

        // Crear el objeto profesional con los datos actualizados
        Profesional profesional = new Profesional(rut, nombre, clave, "Profesional", especialidad);

        // Actualizar el profesional en la base de datos
        usuarioDAO.editarUsuario(profesional);

        // Redirigir a la lista de usuarios
        response.sendRedirect("ListadoUsuarios");
    }
}