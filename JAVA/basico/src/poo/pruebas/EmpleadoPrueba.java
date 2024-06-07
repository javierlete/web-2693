package poo.pruebas;

import java.time.LocalDate;

import poo.pojos.Empleado;
import poo.pojos.Local;
import poo.pojos.Persona;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Empleado e = new Empleado();

		e.setNombre("Javier");
		e.setSueldoMensual(1234.46);

		System.out.println(e);

		Empleado e2 = new Empleado();

		e2.setNombre("Javier");
		e2.setSueldoMensual(123654.12);

		System.out.println(e.equals(e2));

		Empleado e3 = new Empleado(null, "Pepe", "Pérez", LocalDate.of(2000, 1, 2), 12345.45);

		System.out.println(e3);

		Local l = new Local(null, "Juan", e);

		l.entra(e2);
		l.entra(new Persona(e3));
		l.entra(new Persona());

		System.out.println(l);
		System.out.println(l.getVisitantes());

		Persona p = e;

		System.out.println(p);

		Object o = p;

		System.out.println(o);

		Empleado en = (Empleado) o;

		System.out.println(en.getSueldoMensual());

		Object objeto = new Object();

		if (objeto instanceof Empleado) {
			Empleado eo = (Empleado) objeto;
			System.out.println(eo.getSueldoMensual());
		} else {
			System.out.println("No es un empleado");
		}

	}
}
