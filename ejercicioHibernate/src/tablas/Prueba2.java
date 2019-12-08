package tablas;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

public class Prueba2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seguro ser = new Seguro("563214", "Juan", "Alonso", "Garcia", 52, 2, 'y', 2, new Date(),"A todo riesgo");
		ser.setIdSeguro(21);
		ser.setMayorDeEdad(true);
		
		//insertar(s);
		//eliminar(id);
		//leer(id);
		//actualizar(s);
		//comprobarMayorDeEdad(21);
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Date todayWithZeroTime=null;
		try {
			 todayWithZeroTime = formatter.parse(formatter.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] clave= {'1','2','a','b'};
		ser.setFechaNacimiento(todayWithZeroTime);
		ser.setHora(new Time(632552000));
		ser.setClave(clave);
		ser.setComentarios("Simplemente inmejorable");
		actualizar(ser);
	}
	static void comprobarMayorDeEdad(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacción
		session.beginTransaction();
		Seguro s = session.load(Seguro.class,id);
		
		if(s.getEdad()>17) {
			s.setMayorDeEdad(true);
			System.out.println("Es mayor de edad");
		}
		else {
			System.out.println("No es mayor de edad");
			s.setMayorDeEdad(false);
		}
		
		session.update(s);
		session.getTransaction().commit();
		Utilidades.getSessionFactory().close();
	}
	static void insertar(Seguro ser) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacción
				session.beginTransaction();
				// Guardamos el objeto en la sesión
				session.save(ser);
				// Commit de la transacción
				session.getTransaction().commit();
				System.out.println("Seguro ID=" + ser.getIdSeguro() + " insertado");

				// Cerramos la factoria de sesiones, sino el programa no finalizará
				Utilidades.getSessionFactory().close();
		
	}
	static void eliminar(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacción
				session.beginTransaction();
				// Guardamos el objeto en la sesión
				Seguro s = session.load(Seguro.class, id);
				session.delete(s);
				System.out.println(s.getIdSeguro() + " borrado");
				// Commit de la transacción
				session.getTransaction().commit();
				

				// Cerramos la factoria de sesiones, sino el programa no finalizará
				Utilidades.getSessionFactory().close();
		
	}
	static void leer(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		Seguro s = session.load(Seguro.class, id);
		
		System.out.println(s);
		// Commit de la transacción
		session.getTransaction().commit();
		

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}
	static void actualizar(Seguro ser) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				// abrimos una transacción
				session.beginTransaction();
				//Actualizamos el objeto en la sesión
				session.update(ser);
				// Commit de la transacción
				session.getTransaction().commit();
				
				// Cerramos la factoria de sesiones, sino el programa no finalizará
				Utilidades.getSessionFactory().close();
	}

}

