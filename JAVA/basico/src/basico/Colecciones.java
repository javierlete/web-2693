package basico;

import java.util.ArrayList;
import java.util.TreeMap;

public class Colecciones {
	public static void main(String[] args) {
		ejemploArrayList();
		ejemploTreeMap();
	}

	private static void ejemploTreeMap() {
		var dic = new TreeMap<String, String>();
	
		dic.put("perro", "dog");
		dic.put("casa", "home");
		
		System.out.println(dic.get("perro"));
		
		for(var clave: dic.keySet()) { // Claves
			System.out.printf("%s: %s\n", clave, dic.get(clave));
		}
		
		for(var valor: dic.values()) { // Valores
			System.out.println(valor);
		}
		
		for(var par: dic.entrySet()) { // Pares(clave, valor)
			var clave = par.getKey();
			var valor = par.getValue();
			
			System.out.printf("%s: %s\n", clave, valor);
		}
	}
	
	private static void ejemploArrayList() {
		var al = new ArrayList<String>();
		
		al.add("Uno");
		al.add("Dos");
		al.add("Ties");
		al.add("Basura");
		al.add("Cinco");
		
		al.remove("Basura"); // Borrar elemento
		al.set(2, "Tres"); // Sustituir elemento
		al.add(3, "Cuatro"); // Añadir elemento
		
		System.out.println(al);
		
		String tercero = al.get(2);
		
		System.out.println(tercero);
		
		System.out.println(al.size());
		
		for(var dato: al) {
			System.out.println(dato);
		}
	}
}
