package com.co.wchallenge.sistema.utilidades;

import java.io.Serializable;

import com.co.wchallenge.sistema.constantes.TecnicaInconsistenciaEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorTecnico implements Serializable {

	private static final long serialVersionUID = 3197467234078283196L;
	
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
