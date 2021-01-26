package com.co.wchallenge.sistema.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.co.wchallenge.dominio.excepcion.ExcepcionNegocio;
import com.co.wchallenge.dominio.modelo.Inconsistencia;

import java.util.List;

@ControllerAdvice
public class NegocioManejoExcepcion {

    @ExceptionHandler(ExcepcionNegocio.class)
    public ResponseEntity<List<Inconsistencia>> manejarError(ExcepcionNegocio en) {
        return ResponseEntity.badRequest().body(en.getInconsistencias());
    }
}
