package es.cursojava.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursojava.spring.AppConfig;
import es.cursojava.spring.beans.operaciones.UsuarioContexto;
import es.cursojava.spring.beans.operaciones.CalculadoraService;
import es.cursojava.spring.beans.operaciones.Usuario;
import es.cursojava.spring.beans.operaciones.Rol;

public class MainPorRol {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UsuarioContexto contexto = ctx.getBean(UsuarioContexto.class);
        CalculadoraService calc = ctx.getBean(CalculadoraService.class);

        Usuario admin = new Usuario("AdminUser", Rol.ADMIN);
        Usuario user = new Usuario("NormalUser", Rol.USER);

        // Caso permitido
        contexto.setUsuarioActual(admin);
        System.out.println("Admin puede calcular: " + calc.calcular(10, 5, "+"));

        // Caso prohibido
        contexto.setUsuarioActual(user);
        System.out.println("User intenta calcular:");
        System.out.println(calc.calcular(10, 5, "+")); // aquí debe saltar SecurityException

        ctx.close();
    }
}
