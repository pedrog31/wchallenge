package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Foto;
import com.co.wchallenge.integracion.persistencia.rest.modelo.FotoDTO;

public class FotoConstructor {


	
	private FotoConstructor () {
	}
	
	public static Foto convertirADominio (FotoDTO fotoRest) {
		return Foto.builder()
				.id(fotoRest.getId())
				.idAlbum(fotoRest.getAlbumId())
				.titulo(fotoRest.getTitle())
				.url(fotoRest.getUrl())
				.urlMiniatura(fotoRest.getThumbnailUrl())
				.build();
	}
}
