package hibernate.ejercicioOneToMany.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ALUMNO")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "EDAD", nullable = false)
	private int edad;

	// Relación ManyToOne con Curso
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURSO_ID")
	private Curso curso;

	// Constructor vacío
	public Alumno() {
		super();
	}

	// Constructor con parámetros
	public Alumno(String nombre, String email, int edad, Curso curso) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
	}

	// Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", email=" + email + ", edad=" + edad + "]";
	}

	
}
