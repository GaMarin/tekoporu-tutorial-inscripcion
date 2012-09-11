package org.ticpy.tekoporu.inscripcion.domain;

public class Alumno {

	private String nombre;

	public Alumno() {}

	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object otro) {
		return ((Alumno)otro).nombre.equals(this.nombre);
	}
}
