<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container">
	<h2>Perfil</h2>

	<div class="row">
		<dl class="col-sm-4">
			<dt>Nombre</dt>
			<dd>${sessionScope.usuario.nombre}</dd>
			<dt>Email</dt>
			<dd>${sessionScope.usuario.email}</dd>
		</dl>

		<div class="col-sm-8">
			<table class="table table-hover table-striped table-bordered">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>OPCIONES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${libros}" var="libro">
						<tr>
							<th>${libro.id}</th>
							<td>${libro.titulo}</td>
							<td><a
								class="btn btn-danger ${sessionScope.usuario == null ? 'disabled' : ''}"
								href="reservar?id=${libro.id}">Devolver</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>

<%@ include file="includes/pie.jsp"%>