package com.co.wchallenge.integracion.persistencia.mongo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.repositorio.consulta.PermisoConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.mongo.entidad.PermisoDocumento;
import com.co.wchallenge.integracion.persistencia.mongo.repositorio.PermisoRepositorioMongo;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PermisoConsultaRepositorioMongo implements PermisoConsultaRepositorio {
	
	private final List<Permiso> permisos;
	private final PermisoRepositorioMongo permisoRepositorioMongo;

	@Override
	public Optional<Permiso> obtenerPermiso(Integer idAlbum, Integer idUsuario) {
		Optional<PermisoDocumento> permisoDocOptional =  permisoRepositorioMongo.findByIdAlbumAndIdUsuario(idAlbum, idUsuario);
		return permisoDocOptional.isPresent() ? permisos.stream().filter(per -> per.getClave().equals(permisoDocOptional.get().getTipo())).findFirst() : Optional.empty();
	}

	@Override
	public List<Integer> obtenerUsuariosConPermisos(String claveTipoPermiso, Integer idAlbum) {
		return permisoRepositorioMongo.findByIdAlbumAndTipo(idAlbum, claveTipoPermiso)
				.stream().map(PermisoDocumento::getIdUsuario).collect(Collectors.toList());
	}
}