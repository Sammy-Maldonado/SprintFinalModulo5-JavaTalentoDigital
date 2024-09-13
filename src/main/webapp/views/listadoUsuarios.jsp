<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.Cliente"%>
<%@ page import="model.Profesional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
<title>Listado de Usuarios</title>
</head>
<body>
	<div class="container">
		<h1 class="my-4">Listado de Usuarios</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>RUT</th>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Empresa</th>
					<th>Especialidad</th>
				</tr>
			</thead>
			<tbody>
				<%
				@SuppressWarnings("unchecked")
				List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
				if (usuarios != null) {
					for (Usuario usuario : usuarios) {
						String tipoUsuario = usuario.getTipoUsuario();
				%>
				<tr>
					<td><%=usuario.getRut()%></td>
					<td><%=usuario.getNombre()%></td>
					<td><%=tipoUsuario%></td>
					<td><%=usuario instanceof Cliente ? ((Cliente) usuario).getEmpresa() : ""%></td>
					<td><%=usuario instanceof Profesional ? ((Profesional) usuario).getEspecialidad() : ""%></td>
					<td>
						<!-- Enlace para editar el usuario --> <a
						href="<%=tipoUsuario.equals("Cliente") ? "EditarCliente"
		: tipoUsuario.equals("Profesional") ? "EditarProfesional" : "EditarAdministrativo"%>?rut=<%=usuario.getRut()%>"
						class="btn btn-primary"> Editar </a>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="6">No hay usuarios disponibles</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<!-- Botón para volver al inicio -->
		<div class="mt-3">
			<a href="Inicio" class="btn btn-secondary">Volver al Inicio</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>