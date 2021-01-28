package com.co.wchallenge.dominio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.repositorio.consulta.PermisoConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PermisoConsulta {

	private final List<Permiso> permisos;
	private final PermisoConsultaRepositorio permisoConsultaRepositorio;

	public Optional<Permiso> buscarPermiso(Integer idAlbum, Integer idUsuario) {
		return permisoConsultaRepositorio.obtenerPermiso(idAlbum, idUsuario);
	}

	public List<Permiso> obtenerPermisos() {
		return permisos;
	}
}
