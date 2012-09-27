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

	private String nombreAlumno;
 
	public List<Alumno> getAlumnosMatriculados(){
		return bc.obtenerAlumnosMatriculados();
	}

	public void setNombreAlumno(String nombreAlumno) {

		this.nombreAlumno = nombreAlumno;
	}

	public String getNombreAlumno() {

		return nombreAlumno;
	}
	
	public void matricular() {
		bc.matricular(new Alumno(this.getNombreAlumno()));
	}

}
