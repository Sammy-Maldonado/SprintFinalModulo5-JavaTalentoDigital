<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Crear Capacitación</title>
</head>
<body>
    <div class="container capacitacion-container">
        <h1 class="my-4">Crear Nueva Capacitación</h1>
        
        <%
            String error = (String) request.getAttribute("error");
            if (error != null && !error.isEmpty()) {
        %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
        <%
            }
        %>
        
        <form method="post" action="CrearCapacitacion" onsubmit="return validarFormulario()">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre de la Capacitación:</label>
                <input type="text" name="nombre" class="form-control" id="nombre" value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>">
            </div>
            <div class="mb-3">
                <label for="detalle" class="form-label">Descripción:</label>
                <textarea name="detalle" class="form-control" id="detalle"><%= request.getAttribute("detalle") != null ? request.getAttribute("detalle") : "" %></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Crear</button>
        </form>

        <!-- Botón para volver al inicio -->
        <div class="mt-3">
            <a href="Inicio" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/crearCapacitacion.js"></script>
</body>
</html>