package com.co.wchallenge.dominio.repositorio.servicio;

public interface PermisoServicioRepositorio {

	void crearPermiso(String claveTipoPermiso, Integer idAlbum, Integer idUsuario);

	void eliminarPermiso(Integer idAlbum, Integer idUsuario);

}
