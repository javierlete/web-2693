package com.ipartek.formacion.biblioteca.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.modelos.Libro;

public class Biblioteca {
	public static final ArrayList<Libro> libros = new ArrayList<Libro>();

	static {
		libros.add(new Libro(1L, "Java en primero", "El mejor", false, "java-primero"));
		libros.add(new Libro(2L, "C# en primero", "Muy bueno", true, "csharp-primero"));
		libros.add(new Libro(3L, "Servlets en segundo", "Interesante", true, "servlets-segundo"));
		libros.add(new Libro(4L, "JavaScript en un año", "Buff", false, "javascript-anno"));
	}

}
