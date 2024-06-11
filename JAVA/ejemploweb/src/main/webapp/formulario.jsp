<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de productos</title>
</head>
<body>

<form action="formulario" method="post">
	<input name="nombre" placeholder="Nombre">
	<input name="precio" placeholder="Precio">
	
	<button>Guardar</button>
</form>

</body>
</html>