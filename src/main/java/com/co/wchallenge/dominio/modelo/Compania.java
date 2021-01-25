package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Compania {

	private String nombre;
	private String slogan;
	private String bs;
	
}
