package es.cursojava.inicio.bucles;
import java.util.Scanner;

public class NotaMediaAlumnosFor {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Introduce el número de alumnos: ");
			int numAlumnos = scan.nextInt();
			
			double sumaNotas=0;
			
			for(int i=0; i<numAlumnos; i++) {
				System.out.println("Introduce nota del alumno "+(i+1));
				double nota = scan.nextDouble();
				sumaNotas += nota;
				
			}
			System.out.println("La nota media de todos los alumnos es: "+ sumaNotas/numAlumnos);
		}

	}

}
