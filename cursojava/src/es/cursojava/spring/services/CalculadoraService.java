package es.cursojava.spring.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.cursojava.spring.beans.operaciones.Operacion;

@Service
public class CalculadoraService {

    private final Map<String, Operacion> operaciones;

    public CalculadoraService(List<Operacion> operaciones) {
        this.operaciones = operaciones.stream()
                .collect(Collectors.toMap(Operacion::getSimbolo, op -> op));
    }

    public double calcular(double a, double b, String simbolo) {
        Operacion operacion = operaciones.get(simbolo);

        if (operacion == null) {
            throw new IllegalArgumentException("Operación no soportada: " + simbolo);
        }

        return operacion.calcular(a, b);
    }
}
