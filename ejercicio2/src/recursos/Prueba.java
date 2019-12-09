package recursos;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Prueba {

	public static void main(String[] args) {
		
	}
		
	/**
	 * M�todo para borrar un Seguro
	 * 
	 * @param seguro s
	 */
	public static void borraSeguro(Profesor s) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.delete(s);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error");
		} finally {
			
			session.close();
		}

	}

	/**
	 * M�todo para actualizar un Seguro
	 * 
	 * @param emp
	 */
	public static void actualizaProfesor(Profesor s) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.update(s);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error al actualizar");
		} finally {
			session.close();
		}

	}

	/**
	 * M�todo para almacenar un Seguro
	 * 
	 * @param emp
	 */
	public static void almacenaProfesor(Profesor p) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.save(p);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error al almacenar el Profesor. " + e.getMessage());
		} finally {
			session.close();
		}

	}

	/**
	 * M�todo para recuperar un Seguro
	 * 
	 * @param id
	 * @return
	 */
	public static Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Profesor s = new Profesor();

		// abrimos una transacci�n
		session.beginTransaction();
		// Recuperamos el Seguro
		try
		{
			s = session.load(Profesor.class, id);
			System.out.println("Datos del Profesor recuperado:"
					+ s.toString());
			// Commit de la transacci�n
			session.getTransaction().commit();
		}catch (ObjectNotFoundException e) {
				System.out.println("Dicho Profesor no se encontr� en la base de datos.");
		} finally {
			session.close();
		}
		
		
		return s;
	}
	
	public static Direccion recuperaDireccion(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Direccion s = new Direccion();

		// abrimos una transacci�n
		session.beginTransaction();
		// Recuperamos el Seguro
		try
		{
			s = session.load(Direccion.class, id);
			System.out.println("Datos de la Direccion recuperado:"
					+ s.toString());
			// Commit de la transacci�n
			session.getTransaction().commit();
		}catch (ObjectNotFoundException e) {
				System.out.println("Dicho Direccion no se encontr� en la base de datos.");
		} finally {
			session.close();
		}
		return s;
		

}
}