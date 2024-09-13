<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Crear Usuario</title>
</head>
<body>
    <div class="container login-container">
        <h1 class="my-4">Crear Nuevo Usuario</h1>
        <form action="CrearUsuario" method="post" id="usuarioForm">
            <div class="mb-3">
                <label for="rut" class="form-label">RUT:</label>
                <input type="text" id="rut" name="rut" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="clave" class="form-label">Contraseña:</label>
                <input type="password" id="clave" name="clave" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="tipoUsuario" class="form-label">Tipo de Usuario:</label>
                <select id="tipoUsuario" name="tipoUsuario" class="form-select">
                	<option value="Administrativo">Administrativo</option>
                    <option value="Cliente">Cliente</option>
                    <option value="Profesional">Profesional</option>
                </select>
            </div>
            <div class="mb-3 d-none" id="empresaDiv">
                <label for="empresa" class="form-label">Empresa:</label>
                <input type="text" id="empresa" name="empresa" class="form-control">
            </div>
            <div class="mb-3 d-none" id="especialidadDiv">
                <label for="especialidad" class="form-label">Especialidad:</label>
                <input type="text" id="especialidad" name="especialidad" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Crear Usuario</button>
        </form>

        <!-- Botón para volver al inicio -->
        <div class="mt-3">
            <a href="Inicio" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/crearUsuario.js"></script>
</body>
</html>