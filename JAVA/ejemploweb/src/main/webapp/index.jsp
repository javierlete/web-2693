<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola</title>
<link rel="stylesheet" href="css/index.css">

</head>
<body>

	<h1>Hola desde JSP</h1>
	
	<% for(int i = 1; i <= 5; i++) { %>
	
		<h2><%= LocalDate.now() %></h2>

	<% } %>
</body>
</html>