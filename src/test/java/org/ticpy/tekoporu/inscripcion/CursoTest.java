package org.ticpy.tekoporu.inscripcion;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ticpy.tekoporu.inscripcion.exception.CursoException;
import org.ticpy.tekoporu.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class CursoTest {

	@Inject
	private Curso curso;

	@Test
	public void matricularAlumnoConExito() {
		curso.matricular("Andres Gonzalez");
		Assert.assertTrue(curso.estaMatriculado("Andres Gonzalez"));

	}

	@Test(expected = CursoException.class)
	public void errorMatricularAlumnoDuplicado() {
		curso.matricular("Andres Gonzalez");
		curso.matricular("Andres Gonzalez");
	}

	@Test(expected = CursoException.class)
	public void errorMatricularCursoLleno() {
		for (int i = 1; i <= 5; i++) {
			curso.matricular("Alumno " + i);
		}
		curso.matricular("Alumno 6");

	}
}
