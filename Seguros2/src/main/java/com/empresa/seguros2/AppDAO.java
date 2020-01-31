package com.empresa.seguros2;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.empresa.seguros2.persistencia.Utilidades;



public class AppDAO {

	public static void main(String[] args) {
EntityManager em = null; 
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			
			
			
			SeguroController seguroController = new SeguroController();
			//seguroController.ej1();
			//seguroController.ej2();
			//seguroController.ej3("NURIA", "PUERTO", "VILLANOVA");
			//seguroController.ej8();
			seguroController.ej9();
			
			AsistenciaController asistenciaController = new AsistenciaController();
			//BigDecimal bd = new BigDecimal(10.00);
			//asistenciaController.ej4(bd);
			
			//BigDecimal menor = new BigDecimal(5.00);
			//BigDecimal mayor = new BigDecimal(10.00);
			//asistenciaController.ej5(menor, mayor);
			
			//asistenciaController.ej6();
			//asistenciaController.ej7();
			
			
			
	}catch (Exception e ) {
		if (em != null) {
			e.printStackTrace();
			System.out.println("Se va a hacer rollback de la transacción");
			em.getTransaction().rollback();
		}
	} finally {
		if (em != null) {
			em.close();
		}
	}
	Utilidades.closeEntityManagerFactory();
}
}


