package com.co.wchallenge.integracion.persistencia.rest.dto;

import lombok.Getter;

@Getter
public class UserDTO {

	private int id;
	private String name;
	private String username;
	private String email;
	private AddressDTO address;
	private String phone;
	private String website;
	private CompanyDTO company;
    
}
