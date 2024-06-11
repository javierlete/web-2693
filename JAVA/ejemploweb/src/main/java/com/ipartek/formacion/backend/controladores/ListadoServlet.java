package com.ipartek.formacion.backend.controladores;

import java.io.IOException;
import java.util.TreeMap;

import com.ipartek.formacion.backend.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;
	static final TreeMap<Long, Producto> productos = new TreeMap<>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productos.put(1L, new Producto(1L, "Portátil", 1234.56));
		productos.put(2L, new Producto(2L, "Monitor", 123.56));
		productos.put(3L, new Producto(3L, "Ratón", 12.56));
		
		request.setAttribute("productos", productos.values());
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
