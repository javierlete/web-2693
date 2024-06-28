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
	
	private static final String SQL_PROPIETARIO = """
		SELECT usuarios_id FROM libros WHERE id = ?;
	""";
	
	private static final String SQL_RESERVA = """
		UPDATE libros SET usuarios_id=? WHERE id=?;
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
	
	public static void conmutarReserva(Long idLibro, Long idUsuario) {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				) {
			PreparedStatement pst = con.prepareStatement(SQL_PROPIETARIO);
			pst.setLong(1, idLibro);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				long lIdPropietario = rs.getLong("usuarios_id");
				Long idPropietario = lIdPropietario == 0 ? null: lIdPropietario;
				
				PreparedStatement pstConmutar = con.prepareStatement(SQL_RESERVA);
				
				pstConmutar.setLong(2, idLibro);
				
				if(idPropietario == null) {
					// Está disponible
					pstConmutar.setLong(1, idUsuario);
					pstConmutar.executeUpdate();
				} else {
					// Lo tiene reservado idPropietario
					if(idPropietario == idUsuario) {
						pstConmutar.setObject(1, null);
						pstConmutar.executeUpdate();
					}
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
