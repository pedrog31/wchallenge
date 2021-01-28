package com.co.wchallenge.sistema.utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilidad {
	
	private JsonUtilidad () {
		
	}

	public static String aJsonString(Object o) {
		try {
			return new ObjectMapper().writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return "";
		}

	}

}
