package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Direccion;
import com.co.wchallenge.integracion.persistencia.rest.modelo.AddressDTO;

public class DireccionConstructor {


	
	private DireccionConstructor () {
	}
	
	public static Direccion convertirADominio (AddressDTO direccionRest) {
		return Direccion.builder()
				.calle(direccionRest.getStreet())
				.ciudad(direccionRest.getCity())
				.codigoPostal(direccionRest.getZipcode())
				.interior(direccionRest.getSuite())
				.latitud(Float.valueOf(direccionRest.getGeo().getLat()))
				.longitud(Float.valueOf(direccionRest.getGeo().getLng()))
				.build();
	}
}
