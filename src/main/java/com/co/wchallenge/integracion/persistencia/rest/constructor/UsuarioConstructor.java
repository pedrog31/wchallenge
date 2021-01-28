package com.co.wchallenge.integracion.persistencia.rest.constructor;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.integracion.persistencia.rest.dto.UserDTO;

public class UsuarioConstructor {


	
	private UsuarioConstructor () {
	}
	
	public static Usuario convertirADominio (UserDTO usuarioRest) {
		return Usuario.builder()
				.id(usuarioRest.getId())
				.nombre(usuarioRest.getName())
				.nombreUsuario(usuarioRest.getUsername())
				.correoElectronico(usuarioRest.getEmail())
				.telefono(usuarioRest.getPhone())
				.sitioWeb(usuarioRest.getWebsite())
				.compania(CompaniaConstructor.convertirADominio(usuarioRest.getCompany()))
				.direccion(DireccionConstructor.convertirADominio(usuarioRest.getAddress()))
				.build();
	}
}
