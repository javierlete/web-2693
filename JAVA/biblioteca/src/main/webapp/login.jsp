<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container">
	<form action="login" method="post">
		<div class="row mb-3">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="email">
			</div>
		</div>
		<div class="row mb-3">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Iniciar sesión</button>
		<div class="text-danger">${error}</div>
	</form>
</main>

<%@ include file="includes/pie.jsp"%>