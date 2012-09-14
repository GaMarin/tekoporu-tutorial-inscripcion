package org.ticpy.tekoporu.inscripcion.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.stereotype.PersistenceController;

@PersistenceController
public class AlumnoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Alumno alumno) {
		em.persist(alumno);
	}

	public List<Alumno> findAll() {

		return em.createQuery("select a from Alumno a").getResultList();

	}
}
