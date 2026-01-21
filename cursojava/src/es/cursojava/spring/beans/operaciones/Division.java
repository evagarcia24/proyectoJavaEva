package es.cursojava.spring.beans.operaciones;

import org.springframework.stereotype.Component;

@Component("division")
public class Division implements Operacion {

	@Override
	public String getSimbolo() {
		return "/";
	}

	@Override
	public double calcular(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("No se puede dividir entre cero");
		}
		return a / b;
	}
}