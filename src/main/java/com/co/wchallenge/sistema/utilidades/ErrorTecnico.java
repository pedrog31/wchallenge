package com.co.wchallenge.sistema.utilidades;

import com.co.wchallenge.sistema.constantes.TecnicaInconsistenciaEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorTecnico {

	private String codigo;
	private String tipo;
	private String mensaje;

	public static ErrorTecnico de (TecnicaInconsistenciaEnum tecnicaInconsistenciaEnum) {
		return new ErrorTecnico(
				tecnicaInconsistenciaEnum.getCodigo(), 
				tecnicaInconsistenciaEnum.getTipo(), 
				tecnicaInconsistenciaEnum.getMensaje());
	}
}
