package com.co.wchallenge.dominio.modelo;

import com.co.wchallenge.dominio.constantes.PermisoEnum;

public class PermisoLector implements Permiso {

	@Override
	public boolean isLeer() {
		return true;
	}

	@Override
	public boolean isCompartir() {
		return false;
	}

	@Override
	public boolean isAgregarEliminarPermisos() {
		return false;
	}

	@Override
	public String getClave() {
		return PermisoEnum.LECTOR.getClave();
	}

	@Override
	public String getNombre() {
		return PermisoEnum.LECTOR.getNombre();
	}

	@Override
	public String getDescripcion() {
		return PermisoEnum.LECTOR.getDescripcion();
	}

	@Override
	public boolean puedeCrearPermiso(Permiso permisoACrear) {
		return false;
	}

}
