package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // Muestra el formulario de login
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // Verifica las credenciales del usuario
        String usuario = request.getParameter("username");
        String clave = request.getParameter("password");

        if ("admin".equals(usuario) && "1234".equals(clave)) {
            // Si las credenciales son correctas, crea la sesión
            request.getSession().setAttribute("usuario", usuario);
            
            // Redirige al servlet de contacto
            response.sendRedirect("Contacto");
            
        } else {
            // Si las credenciales son incorrectas, redirige al login
            response.sendRedirect("Login");
        }
    }
}