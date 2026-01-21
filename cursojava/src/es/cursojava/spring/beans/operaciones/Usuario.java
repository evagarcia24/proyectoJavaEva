package es.cursojava.spring.beans.operaciones;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Usuario {

    private String nombre;
    private Rol rol;

    public Usuario(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', rol=" + rol + "}";
    }
}