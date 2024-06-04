package basico;

import java.util.Scanner;

public class Repetitivas {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		
		String seguir;
		
		do {
			System.out.println("Hola");
			System.out.print("¿Quieres seguir? (s/N) ");
			
			seguir = sc.nextLine();
		} while(seguir.equalsIgnoreCase("s"));
		
		System.out.println("Pues adios");
		
		int c1 = 1;
		
		while(c1 <= 10) {
			System.out.print(c1 + " ");
			c1++;
		}
		
		System.out.println();
		
		for(int c2 = 1; c2 <= 10; c2++) {
			System.out.print(c2 + " ");
		}
		
		System.out.println();
		
		int[] arr = { 10, 20, 30, 40 };
		
		for(int i = 0; i < arr.length; i++) {
			int dato = arr[i];
			System.out.printf("arr[%s]\t%s\n", i, dato);
		}
		
		for(int dato: arr) {
			System.out.print(dato + " ");
		}
		
		sc.close();
	}
}
