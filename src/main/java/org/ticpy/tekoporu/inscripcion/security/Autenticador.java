package org.ticpy.tekoporu.inscripcion.security;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.ticpy.tekoporu.security.Authenticator;
import org.ticpy.tekoporu.security.User;

@Alternative
public class Autenticador implements Authenticator {

	@Inject
	private Credenciales credenciales;

	@Override
	public boolean authenticate() {
		boolean autenticado = false;
		if (credenciales.getNombre().equals("secretaria")
				&& credenciales.getContraseña().equals("secreto")) {
			autenticado = true;
		}
		return autenticado;

	}

	@Override
	public void unAuthenticate() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser() {
		return new User() {
			@Override
			public void setAttribute(Object arg0, Object arg1) {
			}

			@Override
			public String getId() {
				return null;
			}

			@Override
			public Object getAttribute(Object arg0) {
				return null;
			}
		};

	}
}
