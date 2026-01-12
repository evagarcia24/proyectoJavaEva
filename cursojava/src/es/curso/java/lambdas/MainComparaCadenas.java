package es.curso.java.lambdas;

public class MainComparaCadenas {

	public static void main(String[] args) {
		ComparaCadenas comparaLongitud = (s1) -> s1.length() > 5;
		ComparaCadenas contieneTexto = (s1) -> s1.contains("Java");

		String cadena1 = "Hola Mundo";
		String cadena2 = "Aprendiendo Java";

		System.out.println("¿La cadena \"" + cadena1 + "\" tiene más de 5 caracteres? " + comparaLongitud.comparar(cadena1));
		System.out.println("¿La cadena \"" + cadena2 + "\" contiene el texto 'Java'? " + contieneTexto.comparar(cadena2));
		
		GeneraMensaje generarMensaje = () -> System.out.println("¡Este es un mensaje generado por una expresión lambda!");
		generarMensaje.mensaje();

	}

}
