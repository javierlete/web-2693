package basico;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase de iniciación
 */
public class HolaMundo {
	/**
	 * Método que se utiliza por defecto como punto de entrada cuando arrancas una clase
	 * @param args los argumentos recibidos de consola
	 */
	public static void main(String[] args) {
		/*
		 * Ejemplos básicos de programación
		 * Muestra como utilizar entrada y salida
		 */
		
		Scanner sc = new Scanner(System.in); // Esto crea un canal de entrada para leer líneas
		
		System.out.println("Hola");
		
		System.out.print("Dime tu nombre completo: ");
		
		String nombreCompleto = sc.nextLine();
		
		System.out.println("Bienvenido " + nombreCompleto.toLowerCase());
		
		System.out.println("Longitud: " + nombreCompleto.length());
		
		System.out.println("5 primeras letras: " + nombreCompleto.substring(0,5));
		
		String texto = "Uno";
		
		System.out.println(texto);
		
		texto = texto.toUpperCase();
		
		System.out.println(texto);
		
		LocalDateTime inicioJava = LocalDateTime.of(2024, 6, 3, 8, 30);
		
		System.out.println(inicioJava);
		
		int[] arr = new int[3];
		
		arr[0] = 5;
		arr[1] = 6;
		arr[2] = 7;
		// arr[3] = 8;
		
		System.out.println(arr.length);
		
		System.out.println(arr[0]);
		
		System.out.println(Arrays.toString(arr));
		
		String[] textos;
		
		int tamano = 2;
		
		textos = new String[tamano];
		
		textos[0] = "Uno";
		textos[1] = "Dos";
		
		System.out.println(Arrays.toString(textos));
		
		sc.close();
	}
}
