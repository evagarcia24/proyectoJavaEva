package controlUsuarios;

import java.util.Date;
import java.util.List;

import es.cursojava.spring.beans.operaciones.Rol;
//import es.juego.dominio.criatura.Criatura;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "ROL", nullable = false)
//    private RolUsuario rol;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ALTA", nullable = false)
    private Date fechaAlta;

    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;

    // La imagen de perfil se almacena como ruta al archivo
    @Column(name = "IMAGEN_PERFIL")
    private String imagenPerfil;

    
//    @OneToMany(mappedBy = "usuario")
//    private List<Criatura> criaturas;

    
    // Constructor sobrecargado
        public Usuario(String string, Rol admin) {
    	
	}
    
    // No se incluye en el constructor el id ni la fecha de alta, ya que se generan automaticamente
//    public Usuario(String username, String email, String password, RolUsuario rol, boolean activo, String imagenPerfil) {
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.rol = rol;
//		this.activo = activo;
//		this.imagenPerfil = imagenPerfil;
//	}
           
    
	// Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public RolUsuario getRol() {
//        return rol;
//    }
//
//    public void setRol(RolUsuario rol) {
//        this.rol = rol;
//    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
    
    // Este metodo asigna automaticamente la fecha de alta al crear el usuario
    @PrePersist
    protected void onCreate() {
        this.fechaAlta = new Date();
    }
}

