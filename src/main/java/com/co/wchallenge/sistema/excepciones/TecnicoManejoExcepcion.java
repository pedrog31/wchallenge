package com.co.wchallenge.sistema.excepciones;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.co.wchallenge.sistema.utilidades.ErrorTecnico;

@ControllerAdvice
public class TecnicoManejoExcepcion {
	
	@ExceptionHandler(ExcepcionTecnica.class)
	public ResponseEntity<List<ErrorTecnico>> manejarError(ExcepcionTecnica en) {
		return ResponseEntity
				.badRequest()
				.body(en.getErroresTecnicos());
	}
}
