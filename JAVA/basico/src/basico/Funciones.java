package basico;

import java.util.Scanner;

public class Funciones {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		mostrar("Hola");

		mostrar();

		mostrar("Que tal");

		int entero = leerInt("Dime un entero");

		mostrar(String.valueOf(entero));

		String nombre = leerTexto("Dime tu nombre");

		mostrar("Hola " + nombre);
	}

	public static String leerTexto(String mensaje) {
		System.out.print(mensaje + ": ");
		String resultado = sc.nextLine();

		return resultado;
	}

	public static Integer leerInt(String mensaje) {
		boolean hayError = true;
		Integer numero = null;

		do {
			String resultado = leerTexto(mensaje);

			try {
				numero = Integer.parseInt(resultado);
				hayError = false;
			} catch (NumberFormatException e) {
				mostrar("No es un número");
			}
		} while (hayError);

		return numero;
	}

	public static void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

	public static void mostrar() {
		mostrar("");
	}

	public static int sumar(int a, int b) {
		return a + b;
	}

	public static double[] ecuacionCuadratica(double a, double b, double c) {
		var x = new double[2];

		double raiz = Math.sqrt(b * b - 4 * a * c);

		x[0] = (-b + raiz) / (2 * a);
		x[1] = (-b - raiz) / (2 * a);
		
		return x;
	}
}
