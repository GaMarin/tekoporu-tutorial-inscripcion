package org.ticpy.tekoporu.inscripcion;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import  org.slf4j.Logger;

public class Curso {
	
	private List<String> alumnosMatriculados = new ArrayList<String>();

	@Inject
	private Logger logger;
	
	public void matricular(String alumno) {
		alumnosMatriculados.add(alumno);
		logger.info("Alumno matriculado con éxito");

	}

	public boolean estaMatriculado(String alumno) {
		return alumnosMatriculados.contains(alumno);
	}

}