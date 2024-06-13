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

<pre>${producto}</pre>

<form action="formulario" method="post">
	<input type="hidden" name="id" value="${producto.id}">
	<input name="nombre" placeholder="Nombre" value="${producto.nombre}">
	<input name="precio" placeholder="Precio" value="${producto.precio}">
	
	<button>Guardar</button>
</form>

</body>
</html>