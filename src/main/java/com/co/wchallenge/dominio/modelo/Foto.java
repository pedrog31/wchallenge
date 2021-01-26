package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Foto {

	private Integer id;
	private Integer idAlbum;
	private String titulo;
	private String url;
	private String urlMiniatura;
	
}
