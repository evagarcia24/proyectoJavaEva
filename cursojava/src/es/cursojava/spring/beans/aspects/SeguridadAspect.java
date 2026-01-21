package es.cursojava.spring.beans.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cursojava.spring.beans.operaciones.Rol;
import es.cursojava.spring.beans.operaciones.Usuario;
import es.cursojava.spring.beans.operaciones.UsuarioContexto;

@Aspect
@Component
public class SeguridadAspect {

    @Autowired
    private UsuarioContexto usuarioContexto;

    @Before("@annotation(SoloAdmin)")
    public void verificarAcceso() {
        Usuario usuario = usuarioContexto.getUsuarioActual();

        if (usuario == null) {
            throw new SecurityException("No hay usuario autenticado");
        }

        if (usuario.getRol() != Rol.ADMIN) {
            throw new SecurityException("Acceso denegado: se requiere rol ADMIN");
        }
    }
}
