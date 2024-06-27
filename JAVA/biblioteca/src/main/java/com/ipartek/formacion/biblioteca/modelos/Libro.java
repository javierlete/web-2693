package com.ipartek.formacion.biblioteca.modelos;

import java.util.Objects;

public class Libro {
	private Long id;
	private String titulo;
	private String descripcion;
	private String foto;
	
	private Usuario usuario;

	// Source/Generate Constructor using Fields... (Generate)
	public Libro(Long id, String titulo, String descripcion, String foto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.foto = foto;
	}

	// Source/Generate Getters and Setters... (Select All) (Generate)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getDisponible() {
		return usuario == null;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, foto, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(foto, other.foto)
				&& Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", foto=" + foto
				+ ", usuario=" + usuario + "]";
	}
	
}
