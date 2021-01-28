package com.co.wchallenge.dominio.modelo;

import com.co.wchallenge.dominio.constantes.PermisoEnum;

public class PermisoSeguidor implements Permiso {

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
		return false;
	}

	@Override
	public String getClave() {
		return PermisoEnum.SEGUIDOR.getClave();
	}

	@Override
	public String getNombre() {
		return PermisoEnum.SEGUIDOR.getNombre();
	}

	@Override
	public String getDescripcion() {
		return PermisoEnum.SEGUIDOR.getDescripcion();
	}

	@Override
	public boolean puedeCrearPermiso(Permiso permisoACrear) {
		return !permisoACrear.isCompartir();
	}

}
