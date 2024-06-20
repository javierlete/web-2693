package com.ipartek.formacion.biblioteca.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoge información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Realiza las operaciones específicas que necesite
		
		if("javier@email.net".equals(email) && "contra".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
//			Lanza la siguiente vista
			response.sendRedirect(request.getContextPath() + "/libros");
		} else {
//			Prepara el modelo para la siguiente vista
			request.setAttribute("error", "El usuario o la contraseña no son correctos");
			
//			Lanza la siguiente vista
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
