package com.empresa.seguros2;

import java.util.List;

import com.empresa.seguros2.modelo.Seguro;
import com.empresa.seguros2.persistencia.SeguroDAO;
import com.empresa.seguros2.persistencia.dao.impl.SeguroDAOImplJpa;

public class SeguroController {

		SeguroDAO seguroDAO;
		
		public SeguroController(){
			seguroDAO = new SeguroDAOImplJpa();
		}
		public void guardar(Seguro seguro){
			seguroDAO.persist(seguro);
		}
		
		public void ej1(){
			List<Seguro> seguros = seguroDAO.findAll();
			for(Seguro s: seguros){
				System.out.println("seguros: " + s.toString());
			}
		}
		public void ej2(){
			List<Object[]> seguros = seguroDAO.getNifNombre();
				for (Object[] s: seguros){
					System.out.println("NIF: " + s[0]+ ",Nombre: " + s[1]);
				}
		}
		
		public void ej3(String nombre,String apellido1,String apellido2) {
	    	Seguro s = seguroDAO.getByName(nombre, apellido1, apellido2);
	    	System.out.println(s);
			

	    }
		public void ej8() {
	    	Long i = seguroDAO.getCantidadSeguros();
	    	System.out.println("Numero de seguros: " +i);
			
	    }
		public void ej9(){
	    	List<Object[]> lista= seguroDAO.mostrarNombreNif_Y_Asistencias();
	    	for(Object[] o : lista) {
	    		System.out.println("Nombre seguro: " + o[0]);
	    		System.out.println("Nif: " + o[1]);
	    		System.out.println("Nº Asistencias: " + o[2]);
	    		System.out.println();

	    	}
	    }

	}

