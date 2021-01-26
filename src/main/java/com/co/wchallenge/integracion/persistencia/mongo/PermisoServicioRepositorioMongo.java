package com.co.wchallenge.integracion.persistencia.mongo;

import org.springframework.stereotype.Repository;

import com.co.wchallenge.dominio.repositorio.servicio.PermisoServicioRepositorio;
import com.co.wchallenge.integracion.persistencia.mongo.entidad.PermisoEntidad;
import com.co.wchallenge.integracion.persistencia.mongo.repositorio.PermisoRepositorioMongo;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PermisoServicioRepositorioMongo implements PermisoServicioRepositorio {
	
	private final PermisoRepositorioMongo permisoRepositorioMongo;
	
	@Override
	public void crearPermiso(String claveTipoPermiso, Integer idAlbum, Integer idUsuario) {
		permisoRepositorioMongo.save(
				PermisoEntidad.builder()
					.idAlbum(idAlbum)
					.idUsuario(idUsuario)
					.tipo(claveTipoPermiso)
					.build());
	}

}
