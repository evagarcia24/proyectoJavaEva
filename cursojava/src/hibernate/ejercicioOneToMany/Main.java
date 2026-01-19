package hibernate.ejercicioOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import es.cursojava.hibernate.ejercicio1.entites.Aula;
//import es.cursojava.utils.HibernateUtil;
//import hibernate.ejercicioOneToMany.dao.AlumnoDao;
//import hibernate.ejercicioOneToMany.dao.AulaDao;
//import hibernate.ejercicioOneToMany.dao.CursoDao;
//import hibernate.ejercicioOneToMany.service.FileLoaderService;
//
//public class Main {
//
//    private static SessionFactory sessionFactory = (SessionFactory) HibernateUtil.getSessionFactory();
//
//    public static void main(String[] args) throws Exception {
//
//        AulaDao aulaDao = new AulaDao(sessionFactory);
//        CursoDao cursoDao = new CursoDao(sessionFactory);
//        AlumnoDao alumnoDao = new AlumnoDao(sessionFactory);
//        FileLoaderService loader = new FileLoaderService(aulaDao, cursoDao, alumnoDao);
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        loader.cargarAulas("aulas.txt");
//        loader.cargarCursos("cursos_aula.txt");
//        loader.cargarAlumnos("alumnos_cursos.txt");
//
//        tx.commit();
//
//        System.out.println("Datos cargados con éxito!......");
//
//        // Buscar aula del alumno100
//        session.beginTransaction();
//        Aula aula = alumnoDao.buscarAulaDeAlumno("alumno100");
//        session.getTransaction().commit();
//
//        System.out.println("El alumno100 está en el aula: " + aula.getCodigoAula());
//    }
//}

