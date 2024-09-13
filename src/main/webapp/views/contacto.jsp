<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Contacto</title>
</head>
<body>
    <div class="container contacto-container">
        <h1 class="my-4">Formulario de Contacto</h1>
        <form method="post" action="Contacto">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" name="nombre" class="form-control" id="nombre">
            </div>
            <div class="mb-3">
                <label for="correo" class="form-label">Correo:</label>
                <input type="email" name="correo" class="form-control" id="correo">
            </div>
            <div class="mb-3">
                <label for="mensaje" class="form-label">Mensaje:</label>
                <textarea name="mensaje" class="form-control" id="mensaje"></textarea>
            </div>
            <input type="submit" value="Enviar" class="btn btn-primary">
        </form>

        <!-- Botón para volver al inicio -->
        <div class="mt-3">
            <a href="Inicio" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>