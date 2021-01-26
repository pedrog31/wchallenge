package com.co.wchallenge.sistema.seguridad.manejador;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.co.wchallenge.sistema.constantes.TecnicaInconsistenciaEnum;
import com.co.wchallenge.sistema.utilidades.ErrorTecnico;
import com.co.wchallenge.sistema.utilidades.JsonUtilidad;

public class AutenticacionDenegadaManejador implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc)
			throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpStatus.FORBIDDEN.value());
	    response.getWriter().write(JsonUtilidad.aJsonString(Arrays.asList(ErrorTecnico.de(TecnicaInconsistenciaEnum.ACCESO_DENEGADO))));
	    response.flushBuffer();
	}
}
