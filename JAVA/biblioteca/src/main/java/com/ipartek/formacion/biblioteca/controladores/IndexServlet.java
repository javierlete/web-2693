package com.ipartek.formacion.biblioteca.controladores;

import java.io.IOException;

import com.ipartek.formacion.biblioteca.accesodatos.Biblioteca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/libros")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("libros", Biblioteca.libros);
		
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
