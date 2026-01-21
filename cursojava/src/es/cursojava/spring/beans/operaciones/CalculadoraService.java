package es.cursojava.spring.beans.operaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service

public class CalculadoraService {

    private Map<String, Operacion> operaciones = new HashMap<>();

    public CalculadoraService(List<Operacion> operacionesList) {

        for (Operacion op : operacionesList) {
            operaciones.put(op.getSimbolo(), op);
        }
    }

    @SoloAdmin
    public double calcular(double a, double b, String simbolo) {

        Operacion operacion = operaciones.get(simbolo);

        if (operacion == null) {
            throw new IllegalArgumentException("Operación no soportada: " + simbolo);
        }

        return operacion.calcular(a, b);
    }
}


