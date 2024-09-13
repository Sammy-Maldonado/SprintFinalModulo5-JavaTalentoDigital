package controller;

import model.Usuario;
import model.DAO.ICrearUsuarioDAO;
import implement.CrearUsuarioDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListadoUsuarios")
public class ListadoUsuarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia del servicio de usuarios
    private ICrearUsuarioDAO usuarioService = new CrearUsuarioDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("Login");
            return;
        }

        // Obtener la lista de usuarios
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("views/listadoUsuarios.jsp").forward(request, response);
    }
}