package com.co.wchallenge.integracion.persistencia.rest.dto;

import lombok.Getter;

@Getter
public class ComentarioDTO {

	private Integer postId;
	private Integer id;
	private String name;
	private String email;
	private String body;
	
}
