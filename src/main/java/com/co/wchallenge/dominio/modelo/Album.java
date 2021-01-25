package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Album {

	private Integer id;
	private Integer idUsuario;
	private String titulo;
	
}
