package com.co.wchallenge.sistema.seguridad.servicio;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.co.wchallenge.sistema.seguridad.modelo.TokenAutenticacion;

public class AutenticacionTokenServicio extends AbstractUserDetailsAuthenticationProvider {

	private TokenSeguridadServicio jwtTokenServicio;
	
    public AutenticacionTokenServicio(TokenSeguridadServicio jwtTokenServicio) {
		this.jwtTokenServicio = jwtTokenServicio;
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return (TokenAutenticacion.class.isAssignableFrom(authentication));
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken autenticacion) {
        String token = ((TokenAutenticacion) autenticacion).getToken();
		try {
	        return jwtTokenServicio.obtenerAutenticacionPersona(token);
		} catch (Exception e) {
            throw new SessionAuthenticationException(e.getMessage());
        }
    }

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// default implementation ignored
	}
}
