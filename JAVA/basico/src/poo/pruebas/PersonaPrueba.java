package poo.pruebas;

import java.time.LocalDate;

import poo.pojos.Persona;

public class PersonaPrueba {
	public static void main(String[] args) {
		var p = new Persona();
		
		p.setId(5L);
		p.setNombre("   dfghdf ghdfgh    ");
		p.setApellidos("Lete");
		p.setFechaNacimiento(LocalDate.of(2000, 6, 7));
		
		System.out.println(p);
		
		System.out.println(p.getNombre());
		System.out.println(p.getEdad());
		
		Persona p2 = new Persona(2L, "Pepe", "Pérez", LocalDate.of(1990, 2, 3));
		
		System.out.println(p2.getId());
		System.out.println(p2.getNombre());
		System.out.println(p2.getApellidos());
		System.out.println(p2.getFechaNacimiento());
		System.out.println(p2.getEdad());
		
		System.out.println(p2.toString());
		System.out.println(p2);
		
		Persona francisco = new Persona();
		Persona javier = new Persona();
		
		System.out.println(francisco);
		System.out.println(javier);
		
		System.out.println(francisco.hashCode());
		System.out.println(javier.hashCode());
		
		System.out.println(francisco == javier); // SON EL MISMO
		System.out.println(francisco.equals(javier)); // SON GEMELOS
	}
}
