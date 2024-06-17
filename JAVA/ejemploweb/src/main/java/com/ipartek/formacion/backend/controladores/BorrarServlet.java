package com.ipartek.formacion.backend.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db");
				PreparedStatement pst = con.prepareStatement("DELETE FROM productos WHERE id = ?")) {
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
