package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.CrearUsuarioDAOImpl;
import model.Cliente;
import model.DAO.ICrearUsuarioDAO;

@WebServlet("/EditarCliente")
public class EditarCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICrearUsuarioDAO usuarioDAO;

    public EditarCliente() {
        super();
        // Inicializar el DAO
        this.usuarioDAO = new CrearUsuarioDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");

        // Buscar cliente por su RUT en la base de datos
        Cliente cliente = (Cliente) usuarioDAO.obtenerUsuarioPorRut(rut);

        if (cliente != null) {
            // Enviar el cliente al JSP para que se pueda editar
            request.setAttribute("cliente", cliente);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/editarCliente.jsp");
            dispatcher.forward(request, response);
        } else {
            // Manejar el caso en que el cliente no exista
            response.sendRedirect("ListadoUsuarios");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        String empresa = request.getParameter("empresa");

        // Crear el objeto cliente con los datos actualizados
        Cliente cliente = new Cliente(rut, nombre, clave, "Cliente", empresa);

        // Actualizar el cliente en la base de datos
        usuarioDAO.editarUsuario(cliente);

        // Redirigir a la lista de usuarios
        response.sendRedirect("ListadoUsuarios");
    }
}