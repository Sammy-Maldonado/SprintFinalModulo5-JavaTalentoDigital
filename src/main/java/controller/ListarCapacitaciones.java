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
import java.util.List;

@WebServlet("/ListarCapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia del servicio de capacitaciones
    private ICapacitacionDAO capacitacionService = new CapacitacionDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("Login");
            return;
        }

        // Obtener la lista de capacitaciones desde el servicio
        List<Capacitacion> capacitaciones = capacitacionService.listarCapacitaciones();

        // Pasar la lista de capacitaciones a la vista
        request.setAttribute("capacitaciones", capacitaciones);
        request.getRequestDispatcher("views/listarCapacitaciones.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}