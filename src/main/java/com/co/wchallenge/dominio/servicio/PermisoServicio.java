package com.co.wchallenge.dominio.servicio;

import java.util.List;

import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.repositorio.servicio.PermisoServicioRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PermisoServicio {
	
	private final PermisoServicioRepositorio permisoServicioRepositorio;
	private final List<Permiso> permisos;

	public Permiso crearPermiso(String claveTipoPermiso, Integer idAlbum, Integer idUsuario) {
		Permiso permiso = permisos.stream().filter(per -> per.getClave().equals(claveTipoPermiso)).findFirst().get();
		permisoServicioRepositorio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario);
		return permiso;
	}

}
