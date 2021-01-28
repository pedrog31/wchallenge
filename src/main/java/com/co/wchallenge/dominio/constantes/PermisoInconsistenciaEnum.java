package com.co.wchallenge.dominio.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermisoInconsistenciaEnum {
	
	CLAVE("P01", "Clave permiso invalida", "El permiso no existe."), 
	CREACION("P02", "No permitido", "El usuario no puede crear este permiso."),;

    private final String codigo;
    private final String tipo;
    private final String mensaje;

}
