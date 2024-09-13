<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Editar Administrativo</title>
</head>
<body>
    <div class="container mt-5 admin-container">
        <h1 class="mb-4">Editar Administrativo</h1>
        <form action="EditarAdministrativo" method="post">
            <input type="hidden" name="rut" value="${administrativo.rut}">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${administrativo.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="clave" class="form-label">Clave</label>
                <input type="password" class="form-control" id="clave" name="clave" value="${administrativo.clave}" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="ListadoUsuarios" class="btn btn-secondary ms-2">Volver al Listado de Usuarios</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
