package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class NotaMediaAlumnoWhile {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Introduce el número de alumnos: ");
			int numAlumnos = scan.nextInt();

			double sumaNotas = 0;
			int i = 1;

			while (i <= numAlumnos) {
				System.out.println("Introduce la nota del alumno: "+i);
				double nota = scan.nextDouble();
				sumaNotas += nota;
				i++;

			}
			System.out.println("La nota media es: " + sumaNotas / numAlumnos);
		}

	}

}