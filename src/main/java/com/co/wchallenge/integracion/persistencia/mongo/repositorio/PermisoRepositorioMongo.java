package com.co.wchallenge.integracion.persistencia.mongo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.co.wchallenge.integracion.persistencia.mongo.entidad.PermisoDocumento;

@Repository
public interface PermisoRepositorioMongo extends MongoRepository<PermisoDocumento, String> {

	Optional<PermisoDocumento> findByIdAlbumAndIdUsuario(Integer idAlbum, Integer idUsuario);

	void deleteByIdAlbumAndIdUsuario(Integer idAlbum, Integer idUsuario);

	@Query(value = "{'idAlbum' : ?0, 'tipo' : ?1}", fields = "{'idUsuario' : 1}")
	List<PermisoDocumento> findByIdAlbumAndTipo(Integer idAlbum, String claveTipoPermiso);

}
