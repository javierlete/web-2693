package basico;

import java.sql.*;

// CRUD

// Create, Read, Update, Delete: "Altas, bajas, modificaciones y consultas"

public class EjemploJDBC {
//	String URL = "jdbc:mysql://localhost:3306/basededatos";
	private static final String URL = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db";
	private static final String USER = "usuario"; // En SQLite se ignora
	private static final String PASS = "contraseña"; // En SQLite se ignora

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		select();
		selectConId(3);
		
		insertar("Nuevo", 12.34);
		modificar(1, "Modificado", 45.67);
		borrar(5);
	}

	private static void select() throws SQLException {
		String SQL_SELECT = "SELECT * FROM productos";
	
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement st = con.prepareStatement(SQL_SELECT);
		ResultSet rs = st.executeQuery();
	
		while (rs.next()) {
			System.out.printf("%-10s %-20s %10s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		}
		
		con.close();
	}

	private static void selectConId(Integer id) throws SQLException {
		String SQL_SELECT_ID = "SELECT * FROM productos WHERE id = ?";
	
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
		
		pst.setInt(1, id); // En la primera interrogación (1), se pone el id
		
		ResultSet rs = pst.executeQuery();
	
		if (rs.next()) {
			System.out.printf("%-10s %-20s %10s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		} else {
			System.out.println("No encontrado");
		}
		
		con.close();
	}

	private static void insertar(String nombre, Double precio) throws SQLException {
		final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";

		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = con.prepareStatement(SQL_INSERT);
		
		pst.setString(1, nombre);
		pst.setDouble(2, precio);
		
		int numeroDeRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroDeRegistrosModificados);
		
		con.close();
	}

	private static void modificar(Integer id, String nombre, Double precio) throws SQLException {
		final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE id=?";

		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
		
		pst.setString(1, nombre);
		pst.setDouble(2, precio);
		pst.setInt(3, id);
		
		int numeroDeRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroDeRegistrosModificados);
		
		con.close();
	}

	private static void borrar(Integer id) throws SQLException {
		final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = con.prepareStatement(SQL_DELETE);
		
		pst.setInt(1, id);
		
		int numeroDeRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroDeRegistrosModificados);
		
		con.close();		
	}
}
