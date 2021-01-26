package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Comentario {

	private Integer id;
	private Integer idPost;
	private String nombre;
	private String correo;
	private String cuerpo;
	
}
