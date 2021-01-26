package com.co.wchallenge.dominio.excepcion;

import java.util.List;

import com.co.wchallenge.dominio.modelo.Inconsistencia;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "de")
@Getter
public class ExcepcionNegocio extends Exception {
	
	private static final long serialVersionUID = 1L;

	private final List<Inconsistencia> inconsistencias;

	public static ExcepcionNegocio de (Inconsistencia inconsistencia) {
		return new ExcepcionNegocio(List.of(inconsistencia));
	}
}
