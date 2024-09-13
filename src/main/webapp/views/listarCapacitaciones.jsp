<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Capacitacion" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Listado de Capacitaciones</title>
</head>
<body>
    <div class="container">
        <h1 class="my-4">Listado de Capacitación</h1>
        <p>Aquí se mostrarán las capacitaciones registradas en el sistema.</p>

        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>

        <c:if test="${not empty capacitaciones}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="capacitacion" items="${capacitaciones}">
                        <tr>
                            <td>${capacitacion.nombre}</td>
                            <td>${capacitacion.detalle}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty capacitaciones}">
            <p>No hay capacitaciones disponibles.</p>
        </c:if>

        <!-- Botón para volver al inicio -->
        <div class="mt-3">
            <a href="Inicio" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>