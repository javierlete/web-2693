package com.ipartek.formacion.biblioteca.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.biblioteca.modelos.Usuario;

public class BibliotecaUsuario {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SQL_SELECT_EMAIL = "SELECT * FROM usuarios WHERE email=?";

	public static Usuario obtenerPorEmail(String email) {
		Usuario usuario = null;

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL)) {
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"), rs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}
