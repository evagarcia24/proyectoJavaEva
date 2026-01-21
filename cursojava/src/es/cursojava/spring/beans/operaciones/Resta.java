package es.cursojava.spring.beans.operaciones;

import org.springframework.stereotype.Component;

@Component("resta")
public class Resta implements Operacion {

    @Override
    public String getSimbolo() {
        return "-";
    }

    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}