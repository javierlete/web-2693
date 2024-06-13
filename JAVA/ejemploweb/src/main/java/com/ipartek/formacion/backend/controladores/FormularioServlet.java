package com.ipartek.formacion.backend.controladores;

import java.io.IOException;

import com.ipartek.formacion.backend.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			Producto producto = ListadoServlet.productos.get(id);

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");

		// 2. Convertir la información
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		Double precio = Double.parseDouble(sPrecio);

		// 3. Empaquetar en modelo
		Producto producto = new Producto(id, nombre, precio);

		// 4. Ejecutar las acciones específicas
		if (id == null) {
			// INSERTAR
			id = ListadoServlet.productos.size() > 0 ? ListadoServlet.productos.lastKey() + 1L : 1L;
			producto.setId(id);
		} 

		ListadoServlet.productos.put(id, producto);
		
		// 5. Preparar los datos para la siguiente pantalla
		request.setAttribute("productos", ListadoServlet.productos.values());

		// 6. Saltar a la siguiente pantalla
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
