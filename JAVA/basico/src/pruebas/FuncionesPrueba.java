package pruebas;

import static basico.Funciones.*;

public class FuncionesPrueba {
	public static void main(String[] args) {
		mostrar();
		mostrar("Hola");
		
		double a = leerInt("A");
		double b = leerInt("B");
		double c = leerInt("C");
		
		double[] resultados = ecuacionCuadratica(a, b, c);
		
		mostrar(String.format("%sx2 + %sx + %s = 0, x1 = %.3f, x2 = %.3f\n", a, b, c, resultados[0], resultados[1]));
	}
}
