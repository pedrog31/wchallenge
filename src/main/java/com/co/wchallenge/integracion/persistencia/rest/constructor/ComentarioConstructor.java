package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Comentario;
import com.co.wchallenge.integracion.persistencia.rest.dto.ComentarioDTO;

public class ComentarioConstructor {


	
	private ComentarioConstructor () {
	}
	
	public static Comentario convertirADominio (ComentarioDTO comentarioRest) {
		return Comentario.builder()
				.idPost(comentarioRest.getPostId())
				.id(comentarioRest.getId())
				.correo(comentarioRest.getEmail())
				.cuerpo(comentarioRest.getBody())
				.nombre(comentarioRest.getName())
				.build();
	}
}
