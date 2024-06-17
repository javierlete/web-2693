package com.ipartek.formacion.backend.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.backend.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;

	static {
		try {
			Class.forName("org.sqlite.JDBC");// NECESARIO para aplicaciones que se ejecutan en el Tomcat
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection con = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM productos");
				ResultSet rs = pst.executeQuery()) {
			
			ArrayList<Producto> productos = new ArrayList<>();

			Producto producto;
			
			while (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
				
				productos.add(producto);
			}

			request.setAttribute("productos", productos);

			request.getRequestDispatcher("listado.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
