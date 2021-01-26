package com.co.wchallenge.sistema.seguridad.modelo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenAutenticacion extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private final String token;

	public TokenAutenticacion(final String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenAutenticacion other = (TokenAutenticacion) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

}
