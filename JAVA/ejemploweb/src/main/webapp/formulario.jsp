<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<main>
	<pre>${producto}</pre>

	<form action="formulario" method="post">
		<input type="hidden" name="id" value="${producto.id}"> <input
			name="nombre" placeholder="Nombre" value="${producto.nombre}">
		<input name="precio" placeholder="Precio" value="${producto.precio}">

		<button>Guardar</button>
	</form>
</main>

<%@ include file="includes/pie.jsp"%>