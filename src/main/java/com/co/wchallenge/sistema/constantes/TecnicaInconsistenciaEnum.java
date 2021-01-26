package com.co.wchallenge.sistema.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TecnicaInconsistenciaEnum {

    NO_AUTORIZADO("TEC1", "No autorizado", "Por favor inicie sesion nuevamente para acceder a este recurso"), 
    ACCESO_DENEGADO("TEC2", "No permitido", "Parece que no tienes permisos para acceder a este recurso."), 
    USUARIO_INEXISTENTE("TEC3", "No permitido", "No existe un usuario con los datos ingresados.");

    private final String codigo;
    private final String tipo;
    private final String mensaje;
}
