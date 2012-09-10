package org.ticpy.tekoporu.inscripcion;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.ticpy.tekoporu.util.ResourceBundle;

public class Curso {

	private List<String> alumnosMatriculados = new ArrayList<String>();

	@Inject
	private Logger logger;
	@Inject
	private ResourceBundle bundle;

	public void matricular(String alumno) {
		if (estaMatriculado(alumno) || alumnosMatriculados.size() == 5) {
			throw new RuntimeException();
		}
		alumnosMatriculados.add(alumno);
		logger.info(bundle.getString("matricula.exito", alumno));

	}

	public boolean estaMatriculado(String alumno) {
		return alumnosMatriculados.contains(alumno);
	}

}