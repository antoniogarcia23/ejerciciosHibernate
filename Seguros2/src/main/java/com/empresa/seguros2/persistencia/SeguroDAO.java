package com.empresa.seguros2.persistencia;

import java.util.List;

import com.empresa.seguros2.modelo.Seguro;

public interface SeguroDAO extends GenericDAO<Seguro,Integer> {
	
	public List<Object[]> getNifNombre();
	
	public Seguro getByName(String nombre,String apellido1,String apellido2);
	
	public Long getCantidadSeguros();
	
	public List<Object[]> mostrarNombreNif_Y_Asistencias();
}
