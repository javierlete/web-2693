package basico;

import java.sql.*;

public class EjemploJDBC {
	private static final String SQL_SELECT = "SELECT * FROM productos";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		String URL = "jdbc:mysql://localhost:3306/basededatos";
		final String URL = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\WEB\\JAVA\\ejemploweb\\sql\\ejemploweb.db";
		final String USER = "usuario"; // En SQLite se ignora
		final String PASS = "contraseña"; // En SQLite se ignora
		
		Class.forName("org.sqlite.JDBC");
		
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);
		
		while(rs.next()) {
			System.out.printf("%-10s %-20s %10s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		}
	}
}
