package com.empresa.seguros2;

import java.math.BigDecimal;
import java.util.List;

import com.empresa.seguros2.modelo.Asistencia;
import com.empresa.seguros2.persistencia.AsistenciaDAO;
import com.empresa.seguros2.persistencia.dao.impl.AsistenciaDAOImplJpa;

public class AsistenciaController {
	
	AsistenciaDAO asistenciaDAO;
	
	public AsistenciaController(){
		asistenciaDAO = new AsistenciaDAOImplJpa();
	}
	public void guardar(Asistencia asistencia){
		asistenciaDAO.persist(asistencia);
	}
	public void ej4(BigDecimal importe){
		List<Asistencia> asistencias = AsistenciaDAO.mostrarSuperiorImporte(importe);
    	for (Asistencia a: asistencias) {
			System.out.println(a.getId());
		}
    }
	public void ej5(BigDecimal menor,BigDecimal mayor) {
    	List<Asistencia> asistencias = asistenciaDAO.mostrarImporteEntre(menor, mayor);
    	for (Asistencia a: asistencias) {
			System.out.println(a.getId());
		}
    }
	public void ej6() {
    	BigDecimal bd = asistenciaDAO.mostrarSumaImportes();
    	System.out.println(bd);
    }
	
	public void ej7(){
		double b = asistenciaDAO.mostrarMediaImportes();
    	System.out.println(b);
	}
}
