package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Compania;
import com.co.wchallenge.integracion.persistencia.rest.modelo.CompanyDTO;

public class CompaniaConstructor {


	
	private CompaniaConstructor () {
	}
	
	public static Compania convertirADominio (CompanyDTO companiaRest) {
		return Compania.builder()
				.bs(companiaRest.getBs())
				.nombre(companiaRest.getName())
				.slogan(companiaRest.getCatchPhrase())
				.build();
	}
}
