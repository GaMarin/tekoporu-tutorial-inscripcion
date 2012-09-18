package org.ticpy.tekoporu.inscripcion;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ticpy.tekoporu.inscripcion.business.CursoBC;
import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.inscripcion.exception.CursoException;
import org.ticpy.tekoporu.junit.DemoiselleRunner;
import org.ticpy.tekoporu.security.SecurityContext;

@RunWith(DemoiselleRunner.class)
public class CursoTest {

	@Inject
	private CursoBC curso;

	@Inject
	private SecurityContext securityContext;

	@Before
	public void setUp() {
		securityContext.login();
	}

	@Test
	public void matricularAlumnoConExito() {
		Alumno alumno = new Alumno("Andres Gonzales");
		curso.matricular(alumno);
		Assert.assertTrue(curso.estaMatriculado(alumno));

	}

	@Test(expected = CursoException.class)
	public void errorMatricularAlumnoDuplicado() {
		Alumno alumno = new Alumno("Andres Gonzales");
		curso.matricular(alumno);
		curso.matricular(alumno);

	}

	@Test(expected = CursoException.class)
	public void errorMatricularCursoLleno() {
		for (int i = 1; i <= 5; i++) {
			curso.matricular(new Alumno("Alumno " + i));
		}
		curso.matricular(new Alumno("Alumno 6"));

	}
}
