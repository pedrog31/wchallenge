package com.co.wchallenge.integracion.persistencia.rest.modelo;

import lombok.Getter;

@Getter
public class ComentarioDTO {

	private Integer postId;
	private Integer id;
	private String name;
	private String email;
	private String body;
	
}
