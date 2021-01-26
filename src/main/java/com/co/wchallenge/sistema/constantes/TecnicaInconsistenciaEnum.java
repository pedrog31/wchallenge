package com.co.wchallenge.sistema.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TecnicaInconsistenciaEnum {

    NO_AUTORIZADO("TEC3", "No autorizado", "Por favor inicie sesion nuevamente para acceder a este recurso"), 
    ACCESO_DENEGADO("TEC4", "No permitido", "Parece que no tienes permisos para acceder a este recurso.");

    private final String codigo;
    private final String tipo;
    private final String mensaje;
}
