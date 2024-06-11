<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>

<% 
ArrayList<String> lista = new ArrayList<>(); 

lista.add("Uno");
lista.add("Dos");
lista.add("Tres");

request.setAttribute("lista", lista);
%>

<ul>
	<% 
	for(String dato: lista) { 
			if(!dato.equals("Dos")) { %>
		<li><%=dato %></li>
	<%		}
	} %>
</ul>

<ul>
	<c:forEach items="${lista}" var="dato">
		<c:if test="${dato != 'Dos'}">
			<li>${dato}</li>
		</c:if>
	</c:forEach>
</ul>


</body>
</html>