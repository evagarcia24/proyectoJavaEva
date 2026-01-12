package es.curso.java.lambdas;

public class OperacionesMatematicas {

	public static void main(String[] args) {

		Operaciones sumaLambda = (a, b) -> a + b;
		Operaciones restaLambda = (a, b) -> a - b;
		Operaciones multiplicacionLambda = (a, b) -> a * b;
		Operaciones divisionLambda = (a, b) -> a / b;

		int a = 10;
		int b = 5;

		System.out.println("Suma: " + sumaLambda.operar(a, b));
		System.out.println("Resta: " + restaLambda.operar(a, b));
		System.out.println("Multiplicacion: " + multiplicacionLambda.operar(a, b));
		System.out.println("Division: " + divisionLambda.operar(a, b));
	}

}




