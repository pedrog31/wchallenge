package com.co.wchallenge.dominio.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermisoInconsistenciaEnum {
	
	CLAVE("P01", "Clave permiso invalida", "El permiso no existe."), 
	CREACION("P02", "Creacion: No permitido", "El usuario no puede crear este permiso."), 
	ELIMINACION("P03", "Eliminacion: No permitido", "El usuario no puede eliminar permisos para este album."), ;

    private final String codigo;
    private final String tipo;
    private final String mensaje;

}
