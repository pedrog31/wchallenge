package com.co.wchallenge.dominio.repositorio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Permiso;

public interface PermisoConsultaRepositorio {

	Optional<Permiso> obtenerPermiso(Integer idAlbum, Integer idUsuario);

	List<Integer> obtenerUsuariosConPermisos(String claveTipoPermiso, Integer idAlbum);

}
