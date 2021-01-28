package com.co.wchallenge.integracion.persistencia.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.dominio.repositorio.consulta.UsuarioConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.rest.constructor.UsuarioConstructor;
import com.co.wchallenge.integracion.persistencia.rest.dto.UserDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UsuarioConsultaRepositorioRest implements UsuarioConsultaRepositorio {

	private final RestTemplate plantillaRest;

	@Override
	public List<Usuario> obtenerUsuarios() {
		return Arrays.asList(
				plantillaRest.getForObject("/users", UserDTO[].class))
					.stream().map(UsuarioConstructor::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public Optional<Usuario> obtenerUsuario(String correo, Integer identificador) {
		UriComponents uri = UriComponentsBuilder
				.fromPath("/users")
				.queryParam("id", identificador)
				.queryParam("email", correo)
				.build();
		return Arrays.asList(
				plantillaRest.getForObject(uri.toUriString(), UserDTO[].class))
					.stream().findFirst().map(UsuarioConstructor::convertirADominio);
	}

}
