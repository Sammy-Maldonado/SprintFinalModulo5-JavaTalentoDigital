package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout") 
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        // Obtener la sesión actual, si existe
        HttpSession session = request.getSession(false); 

        // Si la sesión existe, invalidarla (cerrar sesión)
        if (session != null) {
            session.invalidate(); 
        }

        // Redirigir al sitio de login
        response.sendRedirect("Login");
    }
    
    // También puedes manejar el método POST si es necesario
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}