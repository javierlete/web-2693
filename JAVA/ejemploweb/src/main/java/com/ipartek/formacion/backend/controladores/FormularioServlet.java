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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recoger información de la petición
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		
		// 2. Convertir la información
		Double precio = Double.parseDouble(sPrecio);
		
		// 3. Empaquetar en modelo
		Producto producto = new Producto(null, nombre, precio);
		
		// 4. Ejecutar las acciones específicas
		Long id = ListadoServlet.productos.size() > 0 ? ListadoServlet.productos.lastKey() + 1L : 1L;
		producto.setId(id);
		ListadoServlet.productos.put(id, producto);
		
		// 5. Preparar los datos para la siguiente pantalla
		request.setAttribute("productos", ListadoServlet.productos.values());
		
		// 6. Saltar a la siguiente pantalla
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
