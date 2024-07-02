<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<footer class="bg-body-tertiary p-2">
	<% pageContext.setAttribute("ahora", java.time.LocalDateTime.now()); %>
	<p>&copy;<javatime:format value="${ahora}" pattern="yyyy"/> Javier Lete</p>
</footer>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</body>

</html>