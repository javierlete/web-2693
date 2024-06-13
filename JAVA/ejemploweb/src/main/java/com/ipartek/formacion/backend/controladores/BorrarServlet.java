package com.ipartek.formacion.backend.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		ListadoServlet.productos.remove(id);
		
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
