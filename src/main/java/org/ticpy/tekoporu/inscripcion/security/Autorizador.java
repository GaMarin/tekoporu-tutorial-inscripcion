package org.ticpy.tekoporu.inscripcion.security;

import javax.enterprise.inject.Alternative;

import org.ticpy.tekoporu.security.Authorizer;

@Alternative
public class Autorizador implements Authorizer{

	@Override
	public boolean hasRole(String role) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasPermission(String resource, String operation) {
		// TODO Auto-generated method stub
		return true;
	}

}
