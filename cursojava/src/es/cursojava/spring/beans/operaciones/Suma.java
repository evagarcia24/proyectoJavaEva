package es.cursojava.spring.beans.operaciones;

import org.springframework.stereotype.Component;

@Component
public class Suma implements Operacion {

    @Override
    public String getSimbolo() {
        return "+";
    }

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}
