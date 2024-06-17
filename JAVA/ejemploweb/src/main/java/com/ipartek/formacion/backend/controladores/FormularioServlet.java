package com.ipartek.formacion.backend.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

			try (Connection con = DriverManager.getConnection(
					"jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db");
					PreparedStatement pst = con.prepareStatement("SELECT * FROM productos WHERE id=?");
					) {
				
				pst.setLong(1, id);
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
					request.setAttribute("producto", producto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

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

		// 4. Ejecutar las acciones específicas

		try (Connection con = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db");
				PreparedStatement pstInsert = con
						.prepareStatement("INSERT INTO productos (nombre, precio) VALUES (?,?)");
				PreparedStatement pstUpdate = con
						.prepareStatement("UPDATE productos SET nombre=?, precio=? WHERE id=?")) {

			if (id == null) {
				// INSERTAR
				pstInsert.setString(1, nombre);
				pstInsert.setDouble(2, precio);

				pstInsert.executeUpdate();
			} else {
				pstUpdate.setString(1, nombre);
				pstUpdate.setDouble(2, precio);
				pstUpdate.setLong(3, id);

				pstUpdate.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. Preparar los datos para la siguiente pantalla

		// 6. Saltar a la siguiente pantalla
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
