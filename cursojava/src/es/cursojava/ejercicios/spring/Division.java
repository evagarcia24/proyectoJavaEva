package es.cursojava.ejercicios.spring;

import org.springframework.stereotype.Component;

import es.cursojava.spring.beans.operaciones.Operacion;

@Component
public class Division implements Operacion {

    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public double ejecutar(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }
}