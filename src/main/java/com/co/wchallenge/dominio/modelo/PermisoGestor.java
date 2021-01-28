package com.co.wchallenge.dominio.modelo;

import com.co.wchallenge.dominio.constantes.PermisoEnum;

public class PermisoGestor implements Permiso {

	@Override
	public boolean isLeer() {
		return true;
	}

	@Override
	public boolean isCompartir() {
		return true;
	}

	@Override
	public boolean isAgregarEliminarPermisos() {
		return true;
	}

	@Override
	public String getClave() {
		return PermisoEnum.GESTOR.getClave();
	}

	@Override
	public String getNombre() {
		return PermisoEnum.GESTOR.getNombre();
	}

	@Override
	public String getDescripcion() {
		return PermisoEnum.GESTOR.getDescripcion();
	}

	@Override
	public boolean puedeCrearPermiso(Permiso permisoACrear) {
		return true;
	}

}
