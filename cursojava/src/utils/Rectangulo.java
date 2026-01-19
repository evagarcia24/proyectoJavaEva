//Escribe un único método en Java que sirva para realizar los siguientes cálculos sobre un rectángulo a partir de la base y la altura
//proporcionadas por el usuario:
//+ Calcular el área del rectángulo. Area=base×altura
//+ Calcular el perímetro del rectángulo. Perímetro=2×(base+altura)
//+ Calcular la diagonal del rectángulo (utilizando el teorema de Pitágoras). Diagonal= (raíz cuadrada)base2+altura2

package utils;

import java.util.Scanner;


public class Rectangulo {
	
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Introduce la base del rectángulo: ");
			double base = scan.nextDouble();

			System.out.print("Introduce la altura del rectángulo: ");
			double altura = scan.nextDouble();

			double[] resultados = calcularRectangulo(base, altura);

			System.out.println("Área del rectángulo: " + resultados[0]);
			System.out.println("Perímetro del rectángulo: " + resultados[1]);
			System.out.println("Diagonal del rectángulo: " + resultados[2]);
		}
	}

	public static double[] calcularRectangulo(double base, double altura) {
		
		double [] resultados = new double[3];
		double area = base * altura;
		double perimetro = 2 * (base + altura);
		double diagonal = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
		
		//double [] resultados = {area, perimetro, diagonal};

		return resultados;
	}
	

}


