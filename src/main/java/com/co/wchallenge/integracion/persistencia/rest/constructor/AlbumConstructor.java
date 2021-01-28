package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Album;
import com.co.wchallenge.integracion.persistencia.rest.dto.AlbumDTO;

public class AlbumConstructor {


	
	private AlbumConstructor () {
	}
	
	public static Album convertirADominio (AlbumDTO albumRest) {
		return Album.builder()
				.id(albumRest.getId())
				.idUsuario(albumRest.getUserId())
				.titulo(albumRest.getTitle())
				.build();
	}
}
