package com.co.wchallenge.dominio.modelo;

import java.io.Serializable;

import com.co.wchallenge.dominio.constantes.PermisoInconsistenciaEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Inconsistencia implements Serializable {
	
	private static final long serialVersionUID = 5271665682119998815L;
	
	private String codigo;
	private String mensaje;
	private String tipo;

	public static Inconsistencia de(PermisoInconsistenciaEnum permisoInconsistenciaEnum) {
		return new Inconsistencia(permisoInconsistenciaEnum.getCodigo(), permisoInconsistenciaEnum.getMensaje(),
				permisoInconsistenciaEnum.getTipo());
	}
}
