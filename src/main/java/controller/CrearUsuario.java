package controller;

import model.Administrativo;
import model.Cliente;
import model.Profesional;
import model.Usuario;
import model.DAO.ICrearUsuarioDAO;
import implement.CrearUsuarioDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia del servicio de usuarios
    private ICrearUsuarioDAO usuarioService = new CrearUsuarioDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("Login");
            return;
        }
        request.getRequestDispatcher("views/crearUsuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String empresa = request.getParameter("empresa");  // Solo para Cliente
        String especialidad = request.getParameter("especialidad");  // Solo para Profesional

        if (rut == null || rut.trim().isEmpty() ||
            nombre == null || nombre.trim().isEmpty() ||
            clave == null || clave.trim().isEmpty() ||
            tipoUsuario == null || tipoUsuario.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("views/crearUsuario.jsp").forward(request, response);
            return;
        }

        Usuario nuevoUsuario;
        switch (tipoUsuario) {
            case "Cliente":
                if (empresa == null || empresa.trim().isEmpty()) {
                    request.setAttribute("error", "La empresa es obligatoria para un Cliente.");
                    request.getRequestDispatcher("views/crearUsuario.jsp").forward(request, response);
                    return;
                }
                nuevoUsuario = new Cliente(rut, nombre, clave, tipoUsuario, empresa);
                break;
            case "Profesional":
                if (especialidad == null || especialidad.trim().isEmpty()) {
                    request.setAttribute("error", "La especialidad es obligatoria para un Profesional.");
                    request.getRequestDispatcher("views/crearUsuario.jsp").forward(request, response);
                    return;
                }
                nuevoUsuario = new Profesional(rut, nombre, clave, tipoUsuario, especialidad);
                break;
            case "Administrativo":
                nuevoUsuario = new Administrativo(rut, nombre, clave, tipoUsuario);
                break;
            default:
                request.setAttribute("error", "Tipo de usuario no válido.");
                request.getRequestDispatcher("views/crearUsuario.jsp").forward(request, response);
                return;
        }

        usuarioService.crearUsuario(nuevoUsuario);

        response.sendRedirect("ListadoUsuarios"); // Redirige a la lista de usuarios
    }
}