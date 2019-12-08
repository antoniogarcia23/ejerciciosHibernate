package tablas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utilidades {
	private static SessionFactory sessionFactory;
    
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure("ejercicioHibernate/recursos/hibernate.cfg.xml");
        	
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            
            return sessionFactory;
        }
        catch (Throwable ex) {
            // En un caso real se registra en un log
            System.err.println("Falló la creación de la factoría de sesiones inicial." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /*
     * Método estático (Fachada) para crear la factoría de sesiones
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}

