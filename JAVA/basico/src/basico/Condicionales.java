package basico;

import java.util.Scanner;

public class Condicionales {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.print("Dime tu nombre: ");
		var nombre = sc.nextLine();

		if (nombre.equals("Javier")) {
			System.out.println("Hola profe");
		} else if (nombre.equals("Pepe")) {
			System.out.println("Joder, qué original ¿no?");
		} else {
			System.out.println("Hola " + nombre);
		}

		switch (nombre) {
		case "Javier":
			System.out.println("Hola profe");
			break;
		case "Pepe":
			System.out.println("Joder, qué original ¿no?");
			break;
		default:
			System.out.println("Hola " + nombre);
		}

		switch (nombre) {
		case "Javier" -> System.out.println("Hola profe");
		case "Pepe" -> System.out.println("Joder, qué original ¿no?");
		default -> System.out.println("Hola " + nombre);
		}

		System.out.print("Dime qué mes quieres: ");
		int mes = sc.nextInt();

		int dias = switch (mes) {
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};
		
		System.out.println(String.format("El mes %s tiene %s días", mes, dias));

		sc.close();
	}
}
