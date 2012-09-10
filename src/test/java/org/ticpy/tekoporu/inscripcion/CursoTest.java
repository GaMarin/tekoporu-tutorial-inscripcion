package org.ticpy.tekoporu.inscripcion;

import org.junit.Assert;
import org.junit.Test;

public class CursoTest {
	@Test
	public void matricularAlumnoConExito() {
		Curso curso = new Curso();
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
