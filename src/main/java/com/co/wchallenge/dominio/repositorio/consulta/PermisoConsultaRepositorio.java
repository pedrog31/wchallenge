package com.co.wchallenge.dominio.repositorio.consulta;

import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Permiso;

public interface PermisoConsultaRepositorio {

	Optional<Permiso> obtenerPermiso(Integer idAlbum, Integer idUsuario);

}
