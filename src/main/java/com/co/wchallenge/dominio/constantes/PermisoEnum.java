package com.co.wchallenge.dominio.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PermisoEnum {

	DUENO("dueno", "Dueño", "Tiene todos los permisos del gestor, es el creador de este."),
	GESTOR("gestor", "Gestor", "Tiene todos los permisos del seguidor, puede agregar y eliminar permisos sobre un album."),
	SEGUIDOR("seguidor", "Seguidor", "Tiene todos los permisos del lector, puede compartir a otros el album solo como lector."),
	LECTOR("lector", "Lector", "Puede ver el album.");
	
	private final String clave;
	private final String nombre;
	private final String descripcion;
}
