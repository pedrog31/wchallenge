package com.co.wchallenge.integracion.persistencia.rest.dto;

import lombok.Getter;

@Getter
public class AddressDTO {

	private String street;
	private String suite;
	private String city;
    private String zipcode;
    private GeoDTO geo;
    
}
