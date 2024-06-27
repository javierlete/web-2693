package com.ipartek.formacion.biblioteca.controladores;

import java.io.IOException;

import com.ipartek.formacion.biblioteca.accesodatos.Biblioteca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reservar")
public class ReservarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		Biblioteca.conmutarReserva(id);
		
		response.sendRedirect(request.getContextPath() + "/libros");
	}

}
