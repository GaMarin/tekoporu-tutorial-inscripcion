package org.ticpy.tekoporu.inscripcion.view;

import java.util.List;

import javax.inject.Inject;

import org.ticpy.tekoporu.inscripcion.business.CursoBC;
import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.stereotype.ViewController;

@ViewController
public class CursoMB {

	@Inject 
	private CursoBC bc;
	
	public List<Alumno> getAlumnosMatriculados(){
		return bc.obtenerAlumnosMatriculados();
	}

}
