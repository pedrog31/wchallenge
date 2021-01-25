package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Direccion {

	private String calle;
	private String interior;
	private String ciudad;
	private String codigoPostal;
	private Float latitud;
	private Float longitud;
	
}
