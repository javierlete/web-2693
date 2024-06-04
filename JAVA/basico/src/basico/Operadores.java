package basico;

public class Operadores {
	public static void main(String[] args) {
		System.out.println("5 % 2 = " + (5 % 2));
		System.out.println("5 ^ 2 = " + (5 ^ 2));
		System.out.println("5 elevado a 2 = " + Math.pow(5, 2));
		
		System.out.println("1 + 2 + 3 = " + (1 + 2 + 3));
		
		int x = 5;
		
		System.out.println("1 + x + 10 = " + (1 + x + 10));
		System.out.println("1 <= x <= 10 = " + (1 <= x && x <= 10));
		
		System.out.println("x = " + x);
		System.out.println("x++ = " + x++);
		System.out.println("x = " + x);
		System.out.println("++x = " + ++x);
		System.out.println("x = " + x);
		
		int a = 5, b = 7;
		
		System.out.println(a > b ? a : b);
	}
}
