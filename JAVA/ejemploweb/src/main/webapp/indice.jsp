<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<main class="container">

	<div class="row row-cols-1 row-cols-md-3 g-4">
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text">${p.precio}</p>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary"></small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</main>

<%@ include file="includes/pie.jsp"%>