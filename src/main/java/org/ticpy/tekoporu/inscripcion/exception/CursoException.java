package org.ticpy.tekoporu.inscripcion.exception;

import org.ticpy.tekoporu.exception.ApplicationException;

@ApplicationException(rollback = true)
public class CursoException extends RuntimeException {
	public CursoException() {
		super("Error al matricular!");
	}
}
