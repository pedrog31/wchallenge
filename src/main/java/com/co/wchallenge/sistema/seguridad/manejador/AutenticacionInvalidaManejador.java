package com.co.wchallenge.sistema.seguridad.manejador;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.co.wchallenge.sistema.constantes.TecnicaInconsistenciaEnum;
import com.co.wchallenge.sistema.utilidades.ErrorTecnico;
import com.co.wchallenge.sistema.utilidades.JsonUtilidad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AutenticacionInvalidaManejador implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		response.setContentType("application/json");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	    response.getWriter().write(JsonUtilidad.aJsonString(Arrays.asList(ErrorTecnico.de(TecnicaInconsistenciaEnum.NO_AUTORIZADO))));
	    response.flushBuffer();
	}
}
