package com.co.wchallenge.integracion.persistencia.mongo.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.wchallenge.integracion.persistencia.mongo.entidad.PermisoDocumento;

@Repository
public interface PermisoRepositorioMongo extends MongoRepository<PermisoDocumento, String> {

	Optional<PermisoDocumento> findByIdAlbumAndIdUsuario(Integer idAlbum, Integer idUsuario);

	void deleteByIdAlbumAndIdUsuario(Integer idAlbum, Integer idUsuario);

}
