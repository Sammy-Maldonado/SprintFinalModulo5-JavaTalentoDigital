<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="controller.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Bienvenido</title>
</head>
<body>
    <div class="container">
        <!-- Encabezado con nombre de usuario y botón de logout -->
        <div class="d-flex justify-content-end align-items-center mt-3">
            <div class="me-3">
                <% 
                    // Obtener el nombre del usuario desde la sesión
                    String nombreUsuario = (String) session.getAttribute("usuario");
                    if (nombreUsuario != null) {
                %>
                    <span class="fw-bold">Hola, <%= nombreUsuario %></span>
                <% } else { %>
                    <span class="fw-bold">Usuario no logueado</span>
                <% } %>
            </div>
            <!-- Botón para cerrar sesión -->
            <a href="Logout" class="btn btn-danger">Cerrar sesión</a>
        </div>

        <!-- Contenido principal -->
        <h1 class="text-center my-4">Bienvenido</h1>
        <div class="row">
            <!-- Card 1: Redirigir a Contacto -->
            <div class="col-12 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Contacto</h5>
                        <p class="card-text">Accede al formulario de contacto.</p>
                        <a href="Contacto" class="btn btn-primary">Ir a Contacto</a>
                    </div>
                </div>
            </div>

            <!-- Card 2: Crear Capacitación -->
            <div class="col-12 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Crear Capacitación</h5>
                        <p class="card-text">Accede al formulario para crear una nueva capacitación.</p>
                        <a href="CrearCapacitacion" class="btn btn-primary">Ir a Crear Capacitación</a>
                    </div>
                </div>
            </div>
            
            <!-- Card 3: Listar Capacitaciones -->
            <div class="col-12 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Listar Capacitaciones</h5>
                        <p class="card-text">Accede a la lista de capacitaciones creadas.</p>
                        <a href="ListarCapacitaciones" class="btn btn-primary">Ir a Listar Capacitaciones</a>
                    </div>
                </div>
            </div>
            
            <!-- Card 4: Redirigir a Crear Usuario -->
            <div class="col-12 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Crear Usuario</h5>
                        <p class="card-text">Accede al formulario para crear un nuevo usuario.</p>
                        <a href="CrearUsuario" class="btn btn-primary">Ir a Crear Usuario</a>
                    </div>
                </div>
            </div>
            
            <!-- Card 5: Listado de Usuarios -->
            <div class="col-12 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Listado de Usuarios</h5>
                        <p class="card-text">Accede a la lista de usuarios registrados en el sistema.</p>
                        <a href="ListadoUsuarios" class="btn btn-primary">Ir a Listado de Usuarios</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>