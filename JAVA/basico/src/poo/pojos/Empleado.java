package poo.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona {
	private Double sueldoMensual;

	public Empleado(Long id, String nombre, String apellidos, LocalDate fechaNacimiento, Double sueldoMensual) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.sueldoMensual = sueldoMensual;
	}

	public Empleado() {
		this(null, "EMPLEADO ANÓNIMO", null, null, null);
	}

	public Double getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(Double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sueldoMensual);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(sueldoMensual, other.sueldoMensual);
	}

	@Override
	public String toString() {
		return "Empleado [sueldoMensual=" + sueldoMensual + ", id=" + getId() + ", fechaNacimiento="
				+ getFechaNacimiento() + ", nombreCompleto=" + getNombreCompleto() + "]";
	}
	
	
}
