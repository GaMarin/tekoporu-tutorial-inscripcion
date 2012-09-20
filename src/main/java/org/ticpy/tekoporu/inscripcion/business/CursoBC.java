package org.ticpy.tekoporu.inscripcion.business;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.ticpy.tekoporu.annotation.Startup;
import org.ticpy.tekoporu.exception.ExceptionHandler;
import org.ticpy.tekoporu.inscripcion.config.InscripcionConfig;
import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.inscripcion.exception.CursoException;
import org.ticpy.tekoporu.security.RequiredPermission;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.util.ResourceBundle;

@Transactional
@BusinessController
public class CursoBC {

	@Inject
	private AlumnoBC alumnoBC;

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private InscripcionConfig config;

	@Transactional
	@RequiredPermission(resource = "curso",	operation = "matricular")
	public void matricular(Alumno alumno) {
		if (estaMatriculado(alumno)
				|| obtenerAlumnosMatriculados().size() == config
						.getCapacidadCurso()) {
			throw new CursoException();
		}

		alumnoBC.insert(alumno);
		logger.info(bundle.getString("matricula.exito", alumno));

	}
	
	@RequiredPermission(resource = "curso", operation = "consular")
	public boolean estaMatriculado(Alumno alumno) {
		return obtenerAlumnosMatriculados().contains(alumno);
	}

	@ExceptionHandler
	public void tratar(CursoException e) {
		logger.warn(bundle.getString("matricula.error"));

		throw e;
	}

	public List<Alumno> obtenerAlumnosMatriculados() {

		return alumnoBC.findAll();
	}

	@Startup
	public void iniciar() {
		logger.info("Iniciando el CursoBC...");
	}

}