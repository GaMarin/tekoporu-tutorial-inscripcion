package org.ticpy.tekoporu.inscripcion;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void errorMatricularAlumnoDuplicado() {
	}

	@Test
	public void errorMatricularCursoLleno() {
	}
}
