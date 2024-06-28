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
						<div class="btn-group">
							<input type="radio" class="btn-check" name="disponibilidad${libro.id}"
								id="disponible${libro.id}" autocomplete="off" ${libro.disponible ? 'checked' : '' } disabled> <label
								class="btn btn-outline-success" for="disponible${libro.id}">Disponible</label>

							<input type="radio" class="btn-check" name="disponibilidad${libro.id}"
								id="nodisponible${libro.id}" autocomplete="off" ${libro.disponible ? '' : 'checked' } disabled> <label
								class="btn btn-outline-danger" for="nodisponible${libro.id}">No disponible</label>
								
      
						</div>
						
						<c:if test="${sessionScope.usuario != null && (sessionScope.usuario == libro.usuario || libro.usuario == null)}">
							<a class="btn btn-primary ${sessionScope.usuario == null ? 'disabled' : ''}" href="reservar?id=${libro.id}">${libro.disponible ? 'Reservar' : 'Devolver'}</a>
						</c:if>
       					<small class="text-body-secondary">${libro.usuario.nombre}</small>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</main>

<%@ include file="includes/pie.jsp"%>