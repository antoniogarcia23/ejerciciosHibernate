package recursos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utilidades {
	
	 private static SessionFactory sessionFactory;
     
	    private static SessionFactory buildSessionFactory() {
	        try {
	           
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            System.out.println("Configuración de Hibernate Cargada");
	             
	   
	            SessionFactory sessionFactory = configuration.buildSessionFactory();

	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            
	            System.err.println("Falló la creacion de la factor�a de sesiones inicial de profesor. " + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	   
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }

	}

