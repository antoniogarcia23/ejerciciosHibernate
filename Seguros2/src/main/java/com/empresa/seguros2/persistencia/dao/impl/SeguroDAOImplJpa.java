package com.empresa.seguros2.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.empresa.seguros2.modelo.Seguro;
import com.empresa.seguros2.persistencia.SeguroDAO;
import com.empresa.seguros2.persistencia.Utilidades;

public class SeguroDAOImplJpa extends GenericDAOImplJpa<Seguro,Integer> implements  SeguroDAO {
	
	
	public List<Object[]> getNifNombre(){
		EntityManager em= Utilidades.getEntityManagerFactory().createEntityManager();
			TypedQuery<Object[]> q = em.createQuery(
								"select s.nif, s.nombre from Seguro s", Object[].class);
			return q.getResultList();
	}
	
	public List<Seguro> findAll() { 
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Seguro> seguros = em.createNamedQuery("Seguro.findAll")
			.getResultList();
		return seguros;
	}
	
	public Seguro getByName(String nombre, String apellido1, String apellido2) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		Seguro seguro =  (Seguro) em.createQuery(
				"select S " +
				"from Seguro S " +
				"where S.nombre like :nombre and S.ape1 like :ape1 and S.ape2 like :ape2 " )
			.setParameter( "nombre", nombre)
			.setParameter("ape1", apellido1)
			.setParameter("ape2", apellido2)
			.getSingleResult();
		return seguro;
	}
	public Long getCantidadSeguros() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		Long n =  (Long) em.createQuery(
				"select count(S) " +
				"from Seguro S ")
				.getSingleResult()
			;
		return n;
	}
	public List<Object[]> mostrarNombreNif_Y_Asistencias() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Object[]> lista =  (List<Object[]>) em.createQuery(
				"select  S.nombre,S.nif,count(*) " +
				"from Seguro S  join Asistencia A on S.id=A.seguro group by S.id"
				)
				.getResultList()
			;
		
		return lista;
	}
}
