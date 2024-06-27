package com.ipartek.formacion.biblioteca.modelos;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
	private Long id;
	private String email;
	private String password;
	private String nombre;
	
	private final ArrayList<Libro> libros = new ArrayList<>();

	public Usuario(Long id, String email, String password, String nombre) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, libros, nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(libros, other.libros) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre + ", libros="
				+ libros + "]";
	}
	
	
}
