package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Contacto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificación de sesión
        HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("usuario") == null) {
            // Redirigir al login si no hay sesión activa
            response.sendRedirect("Login");
            return;
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/contacto.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificación de sesión
        HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("Login");
            return;
        }

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String mensaje = request.getParameter("mensaje");

        // Validaciones
        if (nombre == null || nombre.trim().isEmpty() ||
            correo == null || correo.trim().isEmpty() ||
            mensaje == null || mensaje.trim().isEmpty()) {

            // Si alguno de los campos está vacío, se redirige con un mensaje de error
            request.setAttribute("error", "Todos los campos son obligatorios.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/contacto.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Imprimir los datos del formulario en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Mensaje: " + mensaje);

        // Si las validaciones son correctas, se sigue el flujo normal
        request.setAttribute("nombre", nombre);
        request.setAttribute("correo", correo);
        request.setAttribute("mensaje", mensaje);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/contacto.jsp");
        dispatcher.forward(request, response);
    }
}