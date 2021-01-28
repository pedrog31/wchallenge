package com.co.wchallenge.dominio.modelo;


public interface Permiso {
	
	boolean isLeer();
	boolean isCompartir();
	boolean isAgregarEliminarPermisos();
	String getClave();
	String getNombre();
	String getDescripcion();
	boolean puedeCrearPermiso(Permiso permisoACrear);
	
}
