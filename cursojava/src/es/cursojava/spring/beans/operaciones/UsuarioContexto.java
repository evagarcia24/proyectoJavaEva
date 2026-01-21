package es.cursojava.spring.beans.operaciones;

import org.springframework.stereotype.Component;

@Component
public class UsuarioContexto {

    private Usuario usuarioActual;

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}



