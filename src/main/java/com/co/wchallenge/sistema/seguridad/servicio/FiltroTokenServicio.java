package com.co.wchallenge.sistema.seguridad.servicio;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.co.wchallenge.sistema.seguridad.modelo.TokenAutenticacion;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FiltroTokenServicio extends OncePerRequestFilter {

	public static final String CLAVE_HEADER = "Authorization";
	private static final String PREFIJO_TOKEN = "Bearer ";

	private AuthenticationManager authenticationManager;

	public FiltroTokenServicio(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader(CLAVE_HEADER);
		if (header != null && header.startsWith(PREFIJO_TOKEN)) {
			Authentication authentication = authenticationManager.authenticate(new TokenAutenticacion(header.substring(7)));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}
}