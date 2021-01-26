package com.co.wchallenge.integracion.persistencia.mongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.wchallenge.integracion.persistencia.mongo.entidad.PermisoEntidad;

@Repository
public interface PermisoRepositorioMongo extends MongoRepository<PermisoEntidad, String> {

}
