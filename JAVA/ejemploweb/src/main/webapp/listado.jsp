<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<main>
	<pre>${productos}</pre>

	<table border="1">
		<caption>Listado de productos</caption>
		<thead>
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
					<td><a href="formulario?id=${p.id}">Editar</a> <a
						href="borrar?id=${p.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="formulario">Añadir</a></td>
			</tr>
		</tfoot>

	</table>
</main>

<%@ include file="includes/pie.jsp"%>