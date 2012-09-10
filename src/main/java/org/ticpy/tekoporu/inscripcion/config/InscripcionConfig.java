package org.ticpy.tekoporu.inscripcion.config;

import org.ticpy.tekoporu.configuration.Configuration;

@Configuration(resource = "inscripcion")
public class InscripcionConfig {
	
	private int capacidadCurso;

	public int getCapacidadCurso() {
		return capacidadCurso;
	}

}
