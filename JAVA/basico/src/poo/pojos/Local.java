package poo.pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Local {
	private Long id;
	private String nombre;
	private Persona encargado;
	private ArrayList<Persona> visitantes = new ArrayList<>();
	
	public Local(Long id, String nombre, Persona encargado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.encargado = encargado;
	}

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
		this.nombre = nombre;
	}

	public Persona getEncargado() {
		return encargado;
	}

	public void setEncargado(Persona encargado) {
		this.encargado = encargado;
	}

	public ArrayList<Persona> getVisitantes() {
		return visitantes;
	}

	public void entra(Persona persona) {
		visitantes.add(persona);
	}
	
	public void sale(Persona persona) {
		visitantes.remove(persona);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(encargado, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(encargado, other.encargado) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nombre=" + nombre + ", encargado=" + encargado + "]";
	}
	
	
}
