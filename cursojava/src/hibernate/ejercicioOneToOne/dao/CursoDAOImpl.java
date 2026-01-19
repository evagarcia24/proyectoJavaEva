package hibernate.ejercicioOneToOne.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.cursojava.hibernate.ejercicio1.entites.Aula;
import es.cursojava.hibernate.ejercicio1.entites.Curso;
import es.cursojava.utils.HibernateUtil;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.LockModeType;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;

//public class CursoDAOImpl implements CursoDAO, EntityManager{
//
//private Session session;
//	private Transaction transaction;
//
//	public CursoDAOImpl() {
//		session = HibernateUtil.getSessionFactory();
//		transaction = session.beginTransaction();
//	}
//
//	public void guardarCurso(Curso curso) {
//		session.persist(curso);
//	}
//
//	public void eliminarCurso(Long id) {
//
//	}
//
//	public void actualizarCurso(Curso curso) {
//
//	}
//
//	public Curso obtenerCursoPorId(Long id) {
//		return session.get(Curso.class, id);
//	}
//
//	public List<Curso> obtenerTodosLosCursos() {
//		return session.createQuery("from Curso", Curso.class).list();
//
//	}
//
//	public void commitTransaction() {
//		transaction.commit();
//	}
//
//	@Override
//	public List<Curso> obtenerCursosActivos() {
//
//		Query<Curso> query = session.createQuery("from Curso c where c.activo = true", Curso.class);
//
//		return query.list();
//	}
//
//	@Override
//	public List<Curso> obtenerCursosPorNombre(String nombreCurso) {
//		// En HQL no se deben poner los comodines (%) dentro de la cadena de la consulta
//		// junto al placeholder.
//		// Uso correcto: '... where nombre like :nombreParam' y paso '%valor%' al
//		// parámetro.
//		Query<Curso> query = session.createQuery("from Curso c where c.nombre like :nombreParam", Curso.class);
//		query.setParameter("nombreParam", "%" + nombreCurso.trim() + "%");
//
//		return query.list();
//	}
//
//	public List<Curso> buscarPorRangoFechaInicio(java.time.LocalDate desde, java.time.LocalDate hasta) {
//		System.out.println("Buscando cursos desde " + desde + " hasta " + hasta);
//
//		Query<Curso> query = session.createQuery(
//				"from Curso c where c.fechaInicio >= :desdeFecha and " + "c.fechaInicio <= :hastaFecha", Curso.class);
//		query.setParameter("desdeFecha", desde);
//		query.setParameter("hastaFecha", hasta);
//
//		return query.list();
//
//	}
//
//	public List<Curso> informacionPorCategoriaYFechaIncio(String categoria, LocalDate fechaInicio) {
//		System.out.println("Categoria: " + categoria + ", Fecha Inicio: " + fechaInicio);
////		Query<Curso> query = session.createQuery(
////				"from Curso where categoria = :categoriaParam and fechaInicio >= :fechaInicioParam", Curso.class);
////		query.setParameter("categoriaParam", categoria);
////		query.setParameter("fechaInicioParam", fechaInicio);
//
//		Query<Curso> query = session.createQuery("from Curso c where c.fechaInicio >= :fechaInicioParam", Curso.class);
//		query.setParameter("fechaInicioParam", fechaInicio);
//
//		return query.list();
//	}
//
//	@Override
//	public Curso obtenerCursosPorCodigo(String codigo) {
//		Query<Curso> query = session.createQuery("from Curso c where c.codigo = :codigoCurso", Curso.class);
//		query.setParameter("codigoCurso", codigo);
//
//		return query.uniqueResult();
//	}
//
//	@Override
//	public List<Curso> obtenerCursosPorCategoriaYFechaInicio(String categoria, LocalDate fechaInicio) {
//		Query<Curso> query = session.createQuery(
//				"from Curso c where c.categoria = :categoriaCurso" + " and c.fechaInicio >= :fechaInicioCurso",
//				Curso.class);
//		query.setParameter("categoriaCurso", categoria);
//		query.setParameter("fechaInicioCurso", fechaInicio);
//
//		return query.list();
//	}
//
//	@Override
//	public List<Curso> obtenerCursosPorNivelYHorasYFechaInicio(String nivel, int numHoras, LocalDate fechaInicio) {
//		Query<Curso> query = session.createQuery("from Curso c where c.nivel = :nivelCurso"
//				+ " and c.horasTotales >= :numHorasCurso" + " and c.fechaInicio >= :fechaInicioCurso", Curso.class);
//
//		query.setParameter("nivelCurso", nivel);
//		query.setParameter("numHorasCurso", numHoras);
//		query.setParameter("fechaInicioCurso", fechaInicio);
//
//		return query.list();
//	}
//
//	public List<Curso> obtenerNombreDescripcionCursos() {
//		List<Object[]> datos = session.createQuery("select c.nombre, c.descripcion from Curso c").list();
//		List<Curso> cursos = new ArrayList<>();
//		for (Object[] fila : datos) {
//			String nombre = (String) fila[0];
//			String descripcion = (String) fila[1];
//			Curso curso = new Curso(nombre, descripcion, null);
//			cursos.add(curso);
//			System.out.println("Nombre: " + nombre + ", Descripcion: " + descripcion);
//		}
//
//		return cursos;
//	}
//
//	public List<Curso> obtenerNombreDescripcionCursos2() {
//		String hqlQuery = "select new " + "es.cursojava.hibernate.ejercicio1.entites.Curso(c.nombre, c.descripcion ) "
//				+ "from Curso c order by c.nombre asc";
//
//		List<Curso> cursos = session.createQuery(hqlQuery, Curso.class).setMaxResults(3).list();
//
//		return cursos;
//	}
//
//	// Método para asignar un aula a un curso
////	public void asignarAulaCurso(Long cursoId, Aula aula) {
////
////	//	EntityManager em = emf.createEntityManager();
////		try {
////			em.getTransaction().begin();
////			Curso curso = em.find(Curso.class, cursoId);
////			if (curso != null) {
////				curso.setAula(aula);
////				em.merge(curso); // actualiza el curso con el aula asignada
////			}
////			em.getTransaction().commit();
////		} finally {
////			em.close();
////		}
////	}
//
//	// Método para obtener un curso con su aula
////	public Curso obtenerCursoConAula(Long cursoId) {
////		EntityManager em = emf.createEntityManager();
////		try {
////			return em.createQuery("SELECT c FROM Curso c LEFT JOIN FETCH c.aula WHERE c.id = :id", Curso.class)
////					.setParameter("id", cursoId).getSingleResult();
////		} finally {
////			em.close();
////		}
////	}
//
//	@Override
//	public void persist(Object entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <T> T merge(T entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void remove(Object entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <T> T find(Class<T> entityClass, Object primaryKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setFlushMode(FlushModeType flushMode) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public FlushModeType getFlushMode() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void lock(Object entity, LockModeType lockMode) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void refresh(Object entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void refresh(Object entity, Map<String, Object> properties) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void refresh(Object entity, LockModeType lockMode) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void detach(Object entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean contains(Object entity) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public LockModeType getLockMode(Object entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setProperty(String propertyName, Object value) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Map<String, Object> getProperties() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createQuery(String qlString) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createQuery(CriteriaUpdate updateQuery) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createQuery(CriteriaDelete deleteQuery) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createNamedQuery(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createNativeQuery(String sqlString) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createNativeQuery(String sqlString, Class resultClass) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public jakarta.persistence.Query createNativeQuery(String sqlString, String resultSetMapping) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void joinTransaction() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isJoinedToTransaction() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <T> T unwrap(Class<T> cls) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object getDelegate() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void close() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isOpen() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public EntityTransaction getTransaction() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EntityManagerFactory getEntityManagerFactory() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CriteriaBuilder getCriteriaBuilder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Metamodel getMetamodel() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EntityGraph<?> createEntityGraph(String graphName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EntityGraph<?> getEntityGraph(String graphName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
