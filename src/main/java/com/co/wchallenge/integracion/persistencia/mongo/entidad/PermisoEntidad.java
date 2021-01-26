package com.co.wchallenge.integracion.persistencia.mongo.entidad;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "Permiso")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class PermisoEntidad {

	@Id
	private ObjectId _id;
	private Integer idAlbum;
	private Integer idUsuario;
	private String tipo;
	
}
