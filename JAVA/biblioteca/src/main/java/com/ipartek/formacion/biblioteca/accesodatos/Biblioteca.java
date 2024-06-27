package com.ipartek.formacion.biblioteca.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.modelos.Libro;

public class Biblioteca {
	private static final String URL = "jdbc:mysql://localhost/biblioteca";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	private static final String SQL_SELECT = "SELECT * FROM libros";
	private static final String SQL_RESERVA = """
		UPDATE libros 
		SET 
		    disponible = NOT disponible
		WHERE
		    id = ?;
	""";
	
	// Cargamos el driver de MySQL cuando se pida la clase Biblioteca
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Libro> obtenerTodos() {
		ArrayList<Libro> libros = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			
			Libro libro;
			
			while(rs.next()) {
				libro = new Libro(rs.getLong("id"), rs.getString("titulo"), rs.getString("descripcion"), rs.getBoolean("disponible"), rs.getString("foto"));
				
				libros.add(libro);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return libros;
	}
	
	public static void conmutarReserva(Long id) {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_RESERVA);
				) {
			pst.setLong(1, id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
