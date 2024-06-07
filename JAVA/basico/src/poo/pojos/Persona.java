package poo.pojos;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
	// VARIABLES DE INSTANCIA
	private Long id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

	// CONSTRUCTORES
	public Persona(Long id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
	}

	public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(null, nombre, apellidos, fechaNacimiento);
	}

	public Persona(String nombre, String apellidos) {
		this(null, nombre, apellidos, null);
	}

	public Persona() {
		this(null, "ANÓNIMO", null, null);
	}

	// GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se puede dar un nombre nulo");
		}

		if (nombre.isBlank()) {
			throw new RuntimeException("No se puede dar un nombre vacío");
		}

		this.nombre = nombre.trim();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now().minusYears(18))) {
			throw new RuntimeException("Debe ser mayor de edad");
		}

		this.fechaNacimiento = fechaNacimiento;
	}

	// MÉTODOS DE INSTANCIA
	public Integer getEdad() {
		if (fechaNacimiento == null) {
			// throw new RuntimeException("No tengo la fecha de nacimiento");
			return null;
		}

		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}
	
	// HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaNacimiento, id, nombre);
	}

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	// TOSTRINGOTEPAD
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
}
