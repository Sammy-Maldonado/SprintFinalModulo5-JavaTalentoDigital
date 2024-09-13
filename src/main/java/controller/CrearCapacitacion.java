package controller;

import model.Capacitacion;
import model.DAO.ICapacitacionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.CapacitacionDAOImpl;

import java.io.IOException;

@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia del servicio de capacitaciones
    private ICapacitacionDAO capacitacionService = new CapacitacionDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("Login");
            return;
        }
        request.getRequestDispatcher("views/crearCapacitacion.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String detalle = request.getParameter("detalle");

        if (nombre == null || nombre.trim().isEmpty() ||
        		detalle == null || detalle.trim().isEmpty()) {
            request.setAttribute("error", "El nombre y el detalle son obligatorios.");
            request.getRequestDispatcher("views/crearCapacitacion.jsp").forward(request, response);
            return;
        }

        // Obtener el siguiente ID disponible
        int id = capacitacionService.listarCapacitaciones().size() + 1;
        Capacitacion nuevaCapacitacion = new Capacitacion(id, nombre, detalle);
        capacitacionService.crearCapacitacion(nuevaCapacitacion);

        response.sendRedirect("ListarCapacitaciones"); // Redirige a la lista de capacitaciones
    }
}