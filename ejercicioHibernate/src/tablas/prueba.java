package tablas;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class prueba {

	public static void main(String[] args) {
		Seguro ser = new Seguro("233621", "Jose", "Lopez", "Reyes", 20, 2,'y', 2, new Date(),"A terceros");
		//insertar(ser);
		//eliminar(id);
		//leer(id);
		//actualizar(ser);
		

	}
	
	static void eliminar(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacci�n
				session.beginTransaction();
				// Guardamos el objeto en la sesi�n
				Seguro s = session.load(Seguro.class, id);
				session.delete(s);
				System.out.println(s.getIdSeguro() + " borrado");
				// Commit de la transacci�n
				session.getTransaction().commit();
				

				// Cerramos la factoria de sesiones, sino el programa no finalizar�
				Utilidades.getSessionFactory().close();
		
	}
	static void actualizar(Seguro ser) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacci�n
				session.beginTransaction();
				//Actualizamos el objeto en la sesi�n
				session.update(ser);
				// Commit de la transacci�n
				session.getTransaction().commit();
				
				// Cerramos la factoria de sesiones, sino el programa no finalizar�
				Utilidades.getSessionFactory().close();
	}


	static void insertar(Seguro ser) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacci�n
				session.beginTransaction();
				// Guardamos el objeto en la sesi�n
				session.save(ser);
				// Commit de la transacci�n
				session.getTransaction().commit();
				System.out.println("Seguro ID=" + ser.getIdSeguro() + " insertado");

				// Cerramos la factoria de sesiones, sino el programa no finalizar�
				Utilidades.getSessionFactory().close();
		
	}
	static void leer(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacci�n
		session.beginTransaction();
		// Guardamos el objeto en la sesi�n
		Seguro s = session.load(Seguro.class, id);
		
		System.out.println(s);
		// Commit de la transacci�n
		session.getTransaction().commit();
		

		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getSessionFactory().close();
	}

	
}
