<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<main class="container">
	<!-- <pre>${producto}</pre> -->

	<form action="formulario" method="post">
		<input type="hidden" name="id" value="${producto.id}">
		
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="${producto.nombre}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input class="form-control" id="precio" name="precio" placeholder="Precio" value="${producto.precio}">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

</main>

<%@ include file="includes/pie.jsp"%>