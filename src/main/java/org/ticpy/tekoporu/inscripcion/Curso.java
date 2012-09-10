package org.ticpy.tekoporu.inscripcion;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private List<String> alumnosMatriculados = new ArrayList<String>();

	public void matricular(String alumno) {
		alumnosMatriculados.add(alumno);
	}

	public boolean estaMatriculado(String alumno) {
		return alumnosMatriculados.contains(alumno);
	}

}