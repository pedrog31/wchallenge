package com.co.wchallenge.dominio.modelo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Inconsistencia {
	
	private String codigo;
	private String mensaje;
	private String tipo;
/*
	public static Inconsistencia de(SeccionInconsistenciaEnum seccionInconsistenciaEnum) {
		return new Inconsistencia(seccionInconsistenciaEnum.getCodigo(), seccionInconsistenciaEnum.getMensaje(),
				seccionInconsistenciaEnum.getTipo());
	}*/
}
