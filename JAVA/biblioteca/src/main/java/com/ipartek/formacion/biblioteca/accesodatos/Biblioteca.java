package com.ipartek.formacion.biblioteca.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.modelos.Libro;
import com.ipartek.formacion.biblioteca.modelos.Usuario;

import static com.ipartek.formacion.biblioteca.accesodatos.Constantes.*;

public class Biblioteca {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SQL_SELECT = """
		SELECT 
		    *
		FROM
		    libros l
		LEFT JOIN 
			usuarios u ON u.id = l.usuarios_id
	""";
	private static final String SQL_RESERVA = """
		UPDATE libros 
		SET 
		    disponible = NOT disponible
		WHERE
		    id = ?;
	""";
	
	// Cargamos el driver de MySQL cuando se pida la clase Biblioteca
	
	public static ArrayList<Libro> obtenerTodos() {
		ArrayList<Libro> libros = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			
			Libro libro;
			Usuario usuario;
			
			while(rs.next()) {
				libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.descripcion"), rs.getString("l.foto"));
				
				if(rs.getObject("u.id") != null) {
					usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), rs.getString("u.nombre"));
					
					libro.setUsuario(usuario);
				}
				
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
