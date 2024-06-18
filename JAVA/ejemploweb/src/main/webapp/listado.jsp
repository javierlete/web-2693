<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<main>
	<!-- <pre>${productos}</pre> -->
	<%-- <pre>${productos}</pre> --%>

	<h2>Listado de productos</h2>

	<table class="table table-bordered table-striped table-hover">
		<caption>Listado de productos</caption>
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td><a class="btn btn-sm btn-primary"
						href="formulario?id=${p.id}">Editar <i
							class="bi bi-pencil-square"></i></a> <a class="btn btn-sm btn-danger"
						href="borrar?id=${p.id}">Borrar <i class="bi bi-trash"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-sm btn-primary" href="formulario">Añadir
						<i class="bi bi-plus-circle-fill"></i>
				</a></td>
			</tr>
		</tfoot>

	</table>
</main>

<%@ include file="includes/pie.jsp"%>