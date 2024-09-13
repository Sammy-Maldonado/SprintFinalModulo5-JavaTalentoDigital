<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Profesional" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Editar Profesional</title>
</head>
<body>
    <div class="container mt-5 profesional-container">
        <h1 class="mb-4">Editar Profesional</h1>
        <form action="EditarProfesional" method="post">
            <input type="hidden" name="rut" value="${profesional.rut}">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${profesional.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="clave" class="form-label">Clave</label>
                <input type="password" class="form-control" id="clave" name="clave" value="${profesional.clave}" required>
            </div>
            <div class="mb-3">
                <label for="especialidad" class="form-label">Especialidad</label>
                <input type="text" class="form-control" id="especialidad" name="especialidad" value="${profesional.especialidad}" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Profesional</button>
            <a href="ListadoUsuarios" class="btn btn-secondary ms-2">Volver al Listado de Usuarios</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>