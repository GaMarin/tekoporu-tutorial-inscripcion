package org.ticpy.tekoporu.inscripcion.business;

import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.inscripcion.persistence.AlumnoDAO;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

@BusinessController
public class AlumnoBC extends DelegateCrud<Alumno,Integer,AlumnoDAO>{

}
