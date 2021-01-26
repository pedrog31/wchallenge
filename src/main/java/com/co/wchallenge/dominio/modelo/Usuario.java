package com.co.wchallenge.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Usuario {

	private Integer id;
	private String nombre;
	private String nombreUsuario;
	private String correoElectronico;
	private Direccion direccion;
	private String telefono;
	private String sitioWeb;
	private Compania compania;
	
}
