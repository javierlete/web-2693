package poo.pruebas;

import poo.pojos.Local;
import poo.pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		Local local = new Local(1L, "Bilbao", new Persona("Javier", "Lete"));
		
		local.entra(new Persona());
		local.entra(new Persona("Pepe", "Pérez"));
		local.entra(new Persona("Juan", "González"));
		
		System.out.println(local);
		System.out.println(local.getVisitantes());
		
		for(var p: local.getVisitantes()) {
			System.out.println(p);
		}
	}
}
