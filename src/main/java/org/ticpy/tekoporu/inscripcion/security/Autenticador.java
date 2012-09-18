package org.ticpy.tekoporu.inscripcion.security;

import javax.enterprise.inject.Alternative;

import org.ticpy.tekoporu.security.Authenticator;
import org.ticpy.tekoporu.security.User;

@Alternative
public class Autenticador implements Authenticator {

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		return true;
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
