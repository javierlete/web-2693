<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container">
	
	<div class="row row-cols-1 row-cols-md-3 g-4">

		<c:forEach items="${libros}" var="libro">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/400/300?${libro.id}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${libro.titulo}</h5>
						<p class="card-text">${libro.descripcion}</p>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary">${libro.disponible ? 'Disponible': 'No disponible'}</small>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</main>

<%@ include file="includes/pie.jsp"%>