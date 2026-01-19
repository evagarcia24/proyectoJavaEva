package hibernate.ejercicioOneToMany.service;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//import es.cursojava.hibernate.ejercicio1.entites.Aula;
//import es.cursojava.hibernate.ejercicio1.entites.Curso;
//import hibernate.ejercicioOneToMany.dao.AlumnoDao;
//import hibernate.ejercicioOneToMany.dao.AulaDao;
//import hibernate.ejercicioOneToMany.dao.CursoDao;
//import hibernate.ejercicioOneToMany.entites.Alumno;
//
//public class FileLoaderService {
//
//	private AulaDao aulaDao;
//	private CursoDao cursoDao;
//	private AlumnoDao alumnoDao;
//
//	public FileLoaderService(AulaDao aulaDao, CursoDao cursoDao, AlumnoDao alumnoDao) {
//		this.aulaDao = aulaDao;
//		this.cursoDao = cursoDao;
//		this.alumnoDao = alumnoDao;
//
//	}
//	
//	public void cargarAulas(String path) throws Exception {
//	    List<String> lines = Files.readAllLines(Paths.get(path));
//	    lines.remove(0); // quitar cabecera
//
//	    for (String line : lines) {
//	        String[] p = line.split(";");
//	        Aula aula = new Aula();
//	        aulaDao.save(aula);
//	    }
//	}
	
//	public void cargarCursos(String path) throws Exception {
//	    List<String> lines = Files.readAllLines(Paths.get(path));
//	    lines.remove(0); // cabecera
//
//	    for (String line : lines) {
//	        String[] p = line.split(";");
//
//	        Curso curso = new Curso(
//	            p[0],            // codigo
//	            p[1],            // nombre
//	            Integer.parseInt(p[3]) // horasTotales
//	        );
//
//	        curso.setDescripcion(p[2]);
//	        curso.setActivo(Boolean.parseBoolean(p[4]));
//	        curso.setNivel(p[5]);
//	        curso.setCategoria(p[6]);
//	        curso.setPrecio(new BigDecimal(p[7]));
//	        curso.setFechaInicio(LocalDate.parse(p[8]));
//	        curso.setFechaFin(LocalDate.parse(p[9]));
//	        curso.setFechaCreacion(LocalDateTime.parse(p[10] + "T00:00:00"));

//	        // buscar aula
//	        Aula aula = aulaDao.findByCodigo(p[11]);
//	        curso.setAula(aula);
//
//	        cursoDao.save(curso);
//	    }
//	}
//	
//	public void cargarAlumnos(String path) throws Exception {
//	    List<String> lines = Files.readAllLines(Paths.get(path));
//	    lines.remove(0); // cabecera
//
//	    for (String line : lines) {
//	        String[] p = line.split(";");
//
//	        Alumno a = new Alumno(p[0], p[1], Integer.parseInt(p[2]));
//
//	        Curso curso = cursoDao.findByCodigo(p[3]);
//	        a.setCurso(curso);
//
//	        alumnoDao.save(a);
//	    }
//	}


	




