package org.ticpy.tekoporu.inscripcion;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.ticpy.tekoporu.exception.ExceptionHandler;
import org.ticpy.tekoporu.inscripcion.config.InscripcionConfig;
import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.inscripcion.exception.CursoException;
import org.ticpy.tekoporu.stereotype.Controller;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.util.ResourceBundle;

@Controller
@Transactional
public class Curso {

	@Inject
	private EntityManager em;

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private InscripcionConfig config;

	public void matricular(Alumno alumno) {
		if (estaMatriculado(alumno)
				|| obtenerAlumnosMatriculados().size() == config
						.getCapacidadCurso()) {
			throw new CursoException();
		}
		em.persist(alumno);

		logger.info(bundle.getString("matricula.exito", alumno));

	}

	public boolean estaMatriculado(Alumno alumno) {
		return obtenerAlumnosMatriculados().contains(alumno);
	}

	@ExceptionHandler
	public void tratar(CursoException e) {
		logger.warn(bundle.getString("matricula.error"));

		throw e;
	}

	private List<Alumno> obtenerAlumnosMatriculados() {
		return em.createQuery("select a from Alumno a").getResultList();

	}
}