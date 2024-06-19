package com.ipartek.formacion.biblioteca.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.modelos.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/libros")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var libros = new ArrayList<Libro>();
		
		libros.add(new Libro(1L, "Java en primero", "El mejor", false, "java-primero"));
		libros.add(new Libro(2L, "C# en primero", "Muy bueno", true, "csharp-primero"));
		libros.add(new Libro(3L, "Servlets en segundo", "Interesante", true, "servlets-segundo"));
		libros.add(new Libro(4L, "JavaScript en un año", "Buff", false, "javascript-anno"));

		request.setAttribute("libros", libros);
		
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
