//Desarrolla una calculadora en Java utilizando Spring Core que permita realizar distintas operaciones matemáticas básicas (suma, resta, multiplicación y división) aplicando los principios
//de Inversión de Control (IoC) y Inyección de Dependencias (DI).
//Cada operación deberá implementarse como un bean independiente de Spring y todas ellas deberán compartir una interfaz común Operacion. La lógica de la calculadora se concentrará en un 
//servicio llamado CalculadoraService, que no podrá crear directamente las operaciones (no se permite el uso de new), sino que deberá recibirlas automáticamente desde el contenedor de Spring.
//El servicio deberá seleccionar y ejecutar la operación adecuada en función de un símbolo matemático (+, -, *, /) recibido como parámetro.
//La aplicación deberá configurarse mediante anotaciones (@Component, @Service, @ComponentScan, etc.) y deberá incluir una clase principal desde la que se pruebe el funcionamiento de la 
//calculadora.
//EXTRA:
//=======================================
//El diseño debe permitir añadir nuevas operaciones sin modificar el código del servicio, demostrando así un diseño desacoplado y extensible.
package es.cursojava.spring;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import es.cursojava.spring.beans.operaciones.CalculadoraService;

public class CalculadoraMain {

    public static void main(String[] args) {

        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {// A partir de este punto, es cuando Spring crea la "cajita negra" y gestiona los beans

            CalculadoraService calculadora = ctx.getBean(CalculadoraService.class);

            Scanner scanner = new Scanner(System.in);
			System.out.print("Ingrese el primer número: ");
			double a = scanner.nextDouble();
			System.out.print("Ingrese el segundo número: ");
			double b = scanner.nextDouble();
				
				System.out.println("Suma: " + calculadora.calcular(a, b, "+"));
				System.out.println("Resta: " + calculadora.calcular(a, b, "-"));
				System.out.println("Multiplicación: " + calculadora.calcular(a, b, "*"));
				System.out.println("División: " + calculadora.calcular(a, b, "/"));
			}
        }
    }


